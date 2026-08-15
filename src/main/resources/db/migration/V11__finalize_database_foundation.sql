-- ============================================================
-- Fuel Station Shift Reconciliation System
-- Database Migration V11
--
-- Purpose:
--   1. Align reconciliation submission history with the
--      employee-specific reconciliation workflow.
--   2. Make submission numbering employee-specific across
--      reconciliation calculation versions.
--   3. Introduce append-only application audit-event storage.
--
-- Important:
--
--   Each employee working in a shift has an independent
--   reconciliation submission and approval workflow.
--
--   Example:
--
--       Sujith
--           Submission #1 -> Returned
--           Submission #2 -> Approved
--
--       Sonu
--           Submission #1 -> Approved
--
--   Recalculation creates a new reconciliation version and
--   employee_reconciliation row, while submission numbering
--   continues for that employee's participation in the shift.
--
--   audit_event is append-only application history.
-- ============================================================


-- ============================================================
-- 1. Refine Reconciliation Submission
--
-- Existing V9 model:
--
--     reconciliation_submission
--         -> reconciliation
--
-- Revised model:
--
--     shift
--       -> shift_employee
--           -> employee_reconciliation
--               -> reconciliation_submission
--                   -> approval_decision
--
-- The existing reconciliation_id is retained because it
-- identifies the exact shift-level calculation version that
-- contained the employee reconciliation being submitted.
--
-- The tables are empty at the time V11 is introduced, so no
-- historical-row migration/backfill is required.
-- ============================================================


-- ------------------------------------------------------------
-- Add employee-specific workflow references
-- ------------------------------------------------------------

ALTER TABLE reconciliation.reconciliation_submission
    ADD COLUMN shift_id BIGINT;

ALTER TABLE reconciliation.reconciliation_submission
    ADD COLUMN employee_reconciliation_id BIGINT;

ALTER TABLE reconciliation.reconciliation_submission
    ADD COLUMN shift_employee_id BIGINT;

ALTER TABLE reconciliation.reconciliation_submission
    ADD COLUMN employee_id BIGINT;


-- ------------------------------------------------------------
-- Add Foreign Keys
-- ------------------------------------------------------------

ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT fk_reconciliation_submission_shift
        FOREIGN KEY (shift_id)
        REFERENCES reconciliation.shift (id)
        ON DELETE RESTRICT;


ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT fk_reconciliation_submission_employee_reconciliation
        FOREIGN KEY (employee_reconciliation_id)
        REFERENCES reconciliation.employee_reconciliation (id)
        ON DELETE RESTRICT;


ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT fk_reconciliation_submission_shift_employee
        FOREIGN KEY (shift_employee_id)
        REFERENCES reconciliation.shift_employee (id)
        ON DELETE RESTRICT;


ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT fk_reconciliation_submission_employee
        FOREIGN KEY (employee_id)
        REFERENCES reconciliation.employee (id)
        ON DELETE RESTRICT;


-- ------------------------------------------------------------
-- All newly introduced relationships are mandatory.
--
-- Safe because reconciliation_submission currently contains
-- zero rows.
-- ------------------------------------------------------------

ALTER TABLE reconciliation.reconciliation_submission
    ALTER COLUMN shift_id SET NOT NULL;

ALTER TABLE reconciliation.reconciliation_submission
    ALTER COLUMN employee_reconciliation_id SET NOT NULL;

ALTER TABLE reconciliation.reconciliation_submission
    ALTER COLUMN shift_employee_id SET NOT NULL;

ALTER TABLE reconciliation.reconciliation_submission
    ALTER COLUMN employee_id SET NOT NULL;


-- ============================================================
-- 2. Correct Submission Numbering
--
-- V9 uniqueness:
--
--     reconciliation_id + submission_number
--
-- This allowed:
--
--     Reconciliation V1 -> Submission #1
--     Reconciliation V2 -> Submission #1
--
-- Revised uniqueness:
--
--     shift_employee_id + submission_number
--
-- This gives:
--
--     Sujith / Shift 101
--         Submission #1
--         Submission #2
--         Submission #3
--
-- while another employee in the same shift may independently
-- have their own Submission #1.
-- ============================================================

ALTER TABLE reconciliation.reconciliation_submission
    DROP CONSTRAINT uk_reconciliation_submission_number;


ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT uk_reconciliation_submission_employee_number
        UNIQUE (
            shift_employee_id,
            submission_number
        );


-- ============================================================
-- One employee_reconciliation calculation result should be
-- submitted only once.
--
-- If values are corrected and recalculated, a new
-- employee_reconciliation row/version shall be generated and
-- that new result becomes the next submission.
-- ============================================================

ALTER TABLE reconciliation.reconciliation_submission
    ADD CONSTRAINT uk_reconciliation_submission_employee_reconciliation
        UNIQUE (
            employee_reconciliation_id
        );


-- ============================================================
-- Existing V9 constraints remain valid:
--
--     submission_number = 1
--         -> INITIAL
--
--     submission_number > 1
--         -> RESUBMISSION
--
-- Numbering is now scoped to shift_employee_id instead of
-- reconciliation_id.
-- ============================================================


-- ============================================================
-- 3. Indexes for Revised Submission Relationships
-- ============================================================

CREATE INDEX idx_reconciliation_submission_shift
    ON reconciliation.reconciliation_submission (
        shift_id
    );


CREATE INDEX idx_reconciliation_submission_employee_reconciliation
    ON reconciliation.reconciliation_submission (
        employee_reconciliation_id
    );


CREATE INDEX idx_reconciliation_submission_shift_employee
    ON reconciliation.reconciliation_submission (
        shift_employee_id
    );


CREATE INDEX idx_reconciliation_submission_employee
    ON reconciliation.reconciliation_submission (
        employee_id
    );


-- ============================================================
-- 4. Audit Event
--
-- Append-only history of important application actions.
--
-- Examples:
--
--     USER_LOGGED_IN
--     USER_LOGIN_FAILED
--
--     SHIFT_OPENED
--     SHIFT_CLOSED
--
--     EMPLOYEE_ASSIGNED
--     EMPLOYEE_SHIFT_STARTED
--     EMPLOYEE_SHIFT_COMPLETED
--
--     START_RECEIPT_UPLOADED
--     END_RECEIPT_UPLOADED
--     RECEIPT_REPLACED
--
--     OCR_STARTED
--     OCR_COMPLETED
--     OCR_FAILED
--
--     READING_CORRECTED
--
--     COLLECTION_ENTERED
--     ADJUSTMENT_CREATED
--     ADJUSTMENT_APPROVED
--
--     RECONCILIATION_CALCULATED
--     RECONCILIATION_SUBMITTED
--     RECONCILIATION_RETURNED
--     RECONCILIATION_RESUBMITTED
--
--     RECONCILIATION_LEVEL_1_APPROVED
--     RECONCILIATION_LEVEL_2_APPROVED
--
--     REPORT_GENERATED
--
-- action_code is intentionally not constrained to a fixed
-- database enum so additional audit actions can be introduced
-- by future application functionality without schema changes.
--
-- user_id is nullable because some security events, such as an
-- unsuccessful login attempt, may occur before an authenticated
-- application user has been established.
--
-- old_value_json and new_value_json preserve relevant before/
-- after state where appropriate.
--
-- JSONB is used for flexible audit payloads without changing
-- the relational transaction model.
-- ============================================================

CREATE TABLE reconciliation.audit_event (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,

    organization_id BIGINT,
    fuel_station_id BIGINT,

    user_id BIGINT,

    -- Snapshot retained for convenient historical display
    actor_username_snapshot VARCHAR(100),

    action_code VARCHAR(100) NOT NULL,

    event_outcome VARCHAR(20) NOT NULL DEFAULT 'SUCCESS',

    entity_type VARCHAR(100),
    entity_id BIGINT,

    event_description VARCHAR(1000),

    old_value_json JSONB,
    new_value_json JSONB,
    additional_data_json JSONB,

    event_timestamp TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    ip_address INET,

    correlation_id VARCHAR(100),

    CONSTRAINT fk_audit_event_organization
        FOREIGN KEY (organization_id)
        REFERENCES reconciliation.organization (id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_audit_event_fuel_station
        FOREIGN KEY (fuel_station_id)
        REFERENCES reconciliation.fuel_station (id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_audit_event_user
        FOREIGN KEY (user_id)
        REFERENCES reconciliation.application_user (id)
        ON DELETE RESTRICT,

    CONSTRAINT ck_audit_event_action_code_not_blank
        CHECK (
            BTRIM(action_code) <> ''
        ),

    CONSTRAINT ck_audit_event_actor_username_not_blank
        CHECK (
            actor_username_snapshot IS NULL
            OR BTRIM(actor_username_snapshot) <> ''
        ),

    CONSTRAINT ck_audit_event_outcome
        CHECK (
            event_outcome IN (
                'SUCCESS',
                'FAILURE'
            )
        ),

    CONSTRAINT ck_audit_event_entity_type_not_blank
        CHECK (
            entity_type IS NULL
            OR BTRIM(entity_type) <> ''
        ),

    CONSTRAINT ck_audit_event_description_not_blank
        CHECK (
            event_description IS NULL
            OR BTRIM(event_description) <> ''
        ),

    CONSTRAINT ck_audit_event_correlation_id_not_blank
        CHECK (
            correlation_id IS NULL
            OR BTRIM(correlation_id) <> ''
        )
);


-- ============================================================
-- 5. Audit Event Indexes
--
-- Audit reporting commonly filters by:
--
--     organization
--     station
--     user
--     action
--     entity
--     timestamp
--     correlation/request
-- ============================================================

CREATE INDEX idx_audit_event_organization_timestamp
    ON reconciliation.audit_event (
        organization_id,
        event_timestamp
    );


CREATE INDEX idx_audit_event_station_timestamp
    ON reconciliation.audit_event (
        fuel_station_id,
        event_timestamp
    );


CREATE INDEX idx_audit_event_user_timestamp
    ON reconciliation.audit_event (
        user_id,
        event_timestamp
    );


CREATE INDEX idx_audit_event_action_timestamp
    ON reconciliation.audit_event (
        action_code,
        event_timestamp
    );


CREATE INDEX idx_audit_event_entity
    ON reconciliation.audit_event (
        entity_type,
        entity_id
    );


CREATE INDEX idx_audit_event_timestamp
    ON reconciliation.audit_event (
        event_timestamp
    );


CREATE INDEX idx_audit_event_correlation_id
    ON reconciliation.audit_event (
        correlation_id
    );