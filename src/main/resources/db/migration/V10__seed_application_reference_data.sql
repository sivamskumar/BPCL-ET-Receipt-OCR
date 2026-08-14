-- ============================================================
-- Fuel Station Shift Reconciliation System
-- Database Migration V10
--
-- Purpose:
--   Seed application-controlled reference data.
--
-- Important:
--   This migration contains only reference data whose codes
--   are controlled by the application.
--
--   Client-specific master data such as organizations,
--   stations, fuel types, cash denominations, adjustment
--   types, dispenser units, nozzles, employees and shift
--   definitions shall be maintained through application
--   administration screens.
-- ============================================================


-- ============================================================
-- 1. Security Roles
-- ============================================================

INSERT INTO reconciliation.role (
    role_code,
    role_name
)
VALUES
    (
        'EMPLOYEE',
        'Employee'
    ),
    (
        'REVIEWER',
        'Reviewer'
    ),
    (
        'APPROVER',
        'Approver'
    ),
    (
        'ADMINISTRATOR',
        'Administrator'
    );