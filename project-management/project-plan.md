# Fuel Station Shift Reconciliation System
## Project Plan and Product Delivery Roadmap

**Project:** Fuel Station Shift Reconciliation System
**Roadmap Baseline Date:** 16-Aug-2026
**Target Production Release:** 31-Oct-2026
**Development Capacity:** Approximately 4 focused hours per day
**Delivery Approach:** Incremental milestone-based development
**Current Phase:** Phase 1C — Backend Application Development
**Current Milestone:** Milestone 1C.2 — Application Service Foundation

---

## 1. Purpose

This document defines the implementation and delivery roadmap for the
Fuel Station Shift Reconciliation System.

It acts as the authoritative project-level execution plan covering:

- completed milestones;
- current implementation status;
- remaining product deliverables;
- milestone dependencies;
- planned delivery dates;
- client review and demonstration checkpoints;
- UI/UX prototype reviews;
- documentation alignment;
- testing and quality assurance;
- production hardening;
- User Acceptance Testing (UAT);
- final production deployment.

This document shall be reviewed and updated at the completion of every
milestone.

---

## 2. Product Delivery Objective

The objective of the project is to deliver a production-ready,
responsive web-based Fuel Station Shift Reconciliation System that
supports the complete operational workflow of a fuel station.

The system shall support:

- organization management;
- fuel station management;
- dispenser unit management;
- dispenser-side management;
- nozzle management;
- fuel-type management;
- fuel-price management;
- employee management;
- configurable shift definitions;
- employee shift participation;
- employee working-hour tracking;
- nozzle assignment;
- mobile-friendly receipt capture;
- receipt image storage;
- OCR processing;
- OCR confidence handling;
- manual correction;
- fuel-sale calculation;
- cash denomination entry;
- coins entry;
- TID / digital collection entry;
- credit sales;
- configurable adjustments;
- employee-level reconciliation;
- shift-level reconciliation;
- shortage / excess detection;
- two-level approval workflow;
- audit history;
- operational and management reports;
- incoming fuel-stock / invoice processing;
- role-based access control;
- responsive desktop and mobile user experience.

The final target is a production-ready **Version 1.0 release by
31-Oct-2026**, subject to client decisions, UAT completion, and resolution
of critical defects.

---

## 3. Delivery Principles

The project shall follow the principles below.

### 3.1 Incremental Delivery

Functionality shall be implemented through small, independently
verifiable milestones.

Each milestone shall have:

- clearly defined scope;
- implementation tasks;
- verification criteria;
- build verification;
- Git commit history;
- documentation impact review;
- roadmap impact review.

### 3.2 Database-First Persistence Alignment

The approved PostgreSQL database structure and Flyway migrations form the
persistence baseline.

Java persistence mappings shall remain aligned with the approved database
schema.

### 3.3 Business-Driven Application Services

Application services shall represent business use cases rather than
directly exposing database operations.

### 3.4 API-Driven Architecture

The backend shall expose REST APIs that can be consumed by the responsive
web frontend.

### 3.5 Mobile-Friendly Operations

Employee workflows, particularly receipt capture and shift operations,
shall be designed for convenient use from mobile devices.

### 3.6 Client Feedback Before UI Finalization

UI/UX prototypes shall be reviewed with the client before significant
frontend implementation is finalized.

### 3.7 Incremental Client Demonstrations

The client shall receive functional demonstrations at meaningful
business-flow checkpoints instead of waiting until the complete system is
finished.

---

## 4. Current Project Status

As of 16-Aug-2026:

| Area | Status |
|---|---|
| Business requirements | Completed; alignment update required |
| BRD | Completed; alignment update required |
| Architecture | Completed; alignment update required |
| Domain model | Completed; alignment update required |
| Database design | Completed; alignment update required |
| PostgreSQL database foundation | Complete |
| Flyway migrations V1-V11 | Complete |
| JPA persistence foundation | Complete |
| Domain entity mappings | Complete |
| Spring Data repositories | Complete |
| Backend application services | Not started |
| REST APIs | Not started |
| Security implementation | Not started |
| UI/UX prototype | Not started |
| Responsive frontend | Not started |
| OCR application workflow | Not started |
| Reports | Not started |
| End-to-end testing | Not started |
| Production deployment | Not started |

---

# 5. Completed Milestones

## Phase 1A — Requirements and Solution Design

**Status:** COMPLETE

Major outputs include:

- business requirements;
- BRD;
- architecture;
- domain model;
- database design;
- business rules;
- security requirements;
- acceptance criteria;
- audit-event definitions;
- transaction-boundary decisions;
- optimistic-locking decisions.

A documentation-alignment milestone remains necessary because later client
clarifications and database-design decisions refined portions of the
original documents.

---

## Phase 1B — Database Foundation

**Status:** COMPLETE

Major outputs include:

- PostgreSQL database foundation;
- reconciliation schema;
- master-data tables;
- shift-operation tables;
- receipt and OCR tables;
- sales tables;
- payment and adjustment tables;
- reconciliation tables;
- approval-workflow tables;
- security tables;
- audit tables;
- Flyway migrations V1-V11;
- constraints;
- indexes;
- foreign-key relationships;
- optimistic-locking columns.

---

## Milestone 1C.1 — Domain and Persistence Foundation

**Status:** COMPLETE
**Completion Date:** 16-Aug-2026

### Deliverables

- JPA persistence foundation;
- base entity support;
- core master entities;
- configuration master entities;
- shift-operation entities;
- receipt and OCR entities;
- sales entities;
- payment entities;
- adjustment entities;
- reconciliation entities;
- approval entities;
- security entities;
- audit entities;
- Spring Data repositories;
- composite identifiers;
- Java enums aligned with database constraints;
- explicit JPA entity scanning;
- explicit Spring Data repository scanning.

### Verification

- 11 Flyway migrations validated;
- 38 PostgreSQL tables verified;
- 38 JPA entity mappings verified;
- 38 Spring Data repositories discovered;
- enum values verified against PostgreSQL CHECK constraints;
- Hibernate EntityManagerFactory initialized;
- PostgreSQL connectivity verified;
- Spring Boot application started successfully;
- Maven clean test passed;
- Git whitespace verification passed;
- repository synchronized with origin/main;
- working tree clean.

### Git History

- `b36b740` — Milestone 1C.1: Establish JPA persistence foundation
- `3cabf96` — Milestone 1C.1: Map core master domain entities
- `26ac94a` — Milestone 1C.1: Map configuration master entities
- `5fa8da4` — Milestone 1C.1: Map shift operation domain entities
- `123a5aa` — Milestone 1C.1: Map receipt and OCR domain entities
- `e5384f6` — Milestone 1C.1: Map transactional and security domain entities
- `3e36ad1` — fix: configure JPA entity and repository scanning

---

# 6. Remaining Product Roadmap

## Phase 1A.R1 — Requirements and Design Documentation Alignment

**Status:** PLANNED
**Target:** Aug-2026

Synchronize project documentation with the final client requirements and
the approved V1-V11 database structure.

Documents:

- `docs/business-requirements.md`
- `docs/BRD/BRD-v1.0.md`
- `docs/domain-model.md`
- `docs/database-design.md`
- `docs/architecture.md`

Areas requiring review include:

- finalized user roles;
- station/dispenser/side/nozzle relationships;
- configurable shifts;
- employee working hours;
- receipt ownership;
- OCR processing;
- manual correction;
- payment structures;
- adjustment structures;
- employee reconciliation;
- shift reconciliation;
- submission/resubmission workflow;
- Level-1 review;
- Level-2 approval;
- audit model;
- incoming fuel-stock requirements.

Documentation alignment shall not redesign an already approved database
structure unless an actual requirement defect is discovered.

---

# 7. Phase 1C — Backend Application Development

## Milestone 1C.2 — Application Service Foundation

**Status:** NEXT
**Target:** Aug-2026

### Objective

Establish common application-layer conventions before implementing
business-specific APIs.

### Scope

- application-service package structure;
- transaction-boundary conventions;
- service input/output conventions;
- DTO conventions;
- entity-not-found handling;
- business-validation handling;
- optimistic-lock conflict handling;
- current-user abstraction;
- organization context;
- station context;
- reusable application exceptions;
- common validation utilities;
- service testing conventions.

### Completion Criteria

- agreed application-layer structure;
- common exception model implemented;
- transaction strategy established;
- current-user/context abstraction established;
- representative service tests passing;
- Maven build successful;
- roadmap reviewed and updated.

---

## Milestone 1C.3 — Administration and Master Data APIs

**Status:** PLANNED
**Target:** Aug-2026

Implement application services and REST APIs for:

- organization;
- fuel station;
- fuel type;
- fuel price;
- dispenser unit;
- dispenser side;
- nozzle;
- nozzle fuel-type assignment;
- employee;
- cash denomination;
- adjustment type;
- shift definition.

Include:

- validation;
- pagination where appropriate;
- search/filtering;
- activation/deactivation;
- optimistic locking;
- audit integration where required.

---

## Milestone 1C.4 — Authentication, Authorization and User Administration

**Status:** PLANNED
**Target:** Late Aug / Early Sep-2026

Implement:

- login;
- password handling;
- authenticated-user context;
- role-based authorization;
- station-level access;
- application-user administration;
- role assignment;
- station-access assignment;
- account locking;
- failed-login handling;
- password-change requirement;
- login auditing.

---

## Milestone 1C.5 — Shift Operations and Employee Working Hours

**Status:** PLANNED
**Target:** Early Sep-2026

Implement:

- shift opening;
- shift definition resolution;
- station shift validation;
- active dispenser-unit selection;
- shift employee assignment;
- employee snapshot creation;
- employee working-hours start;
- employee working-hours completion;
- working-hours correction;
- nozzle assignment;
- employee replacement;
- assignment release;
- shift lifecycle validation.

---

## Milestone 1C.6 — Receipt Upload, Storage and OCR Processing

**Status:** PLANNED
**Target:** Mid Sep-2026

Implement:

- receipt upload;
- file validation;
- secure file storage;
- SHA-256 hashing;
- duplicate detection support;
- image metadata;
- receipt replacement;
- OCR preprocessing;
- OCR execution;
- OCR attempt tracking;
- OCR field extraction;
- confidence handling;
- nozzle reading extraction;
- manual correction;
- employee confirmation;
- receipt processing lifecycle.

---

## Milestone 1C.7 — Fuel Sales, Collections and Adjustments

**Status:** PLANNED
**Target:** Late Sep-2026

Implement:

- start/end VTOT calculation;
- quantity-sold calculation;
- fuel-price resolution;
- expected-sales calculation;
- cash denomination entry;
- notes calculation;
- coins entry;
- TID collection;
- credit sales;
- adjustment entry;
- adjustment approval;
- calculation-version handling.

---

## Milestone 1C.8 — Reconciliation and Two-Level Approval

**Status:** PLANNED
**Target:** Early Oct-2026

Implement:

- employee reconciliation;
- shift reconciliation;
- expected amount;
- accounted amount;
- shortage;
- excess;
- tolerance handling;
- employee submission;
- resubmission;
- Level-1 return;
- Level-1 approval;
- approval with remarks;
- Level-2 rejection/return;
- Level-2 approval;
- final approval;
- immutable approval history;
- workflow validation.

---

## Milestone 1C.9 — Audit Service and Backend Hardening

**Status:** PLANNED
**Target:** Early Oct-2026

Implement:

- centralized audit-event creation;
- actor snapshots;
- entity references;
- before/after values;
- correlation IDs;
- security-sensitive events;
- application error handling;
- API error response standardization;
- backend validation review;
- transaction review;
- concurrency review.

---

# 8. Phase 1D — UI/UX and Responsive Web Frontend

Phase 1D shall partially execute in parallel with Phase 1C.

## Milestone 1D.1 — UI/UX Prototype Foundation

**Target:** Start during Aug-2026

Prepare:

- visual language;
- navigation model;
- responsive layout;
- mobile layout;
- common forms;
- common tables;
- confirmation dialogs;
- validation presentation.

---

## Milestone 1D.2 — Login and Dashboard Prototypes

Prototype:

- login;
- employee dashboard;
- reviewer dashboard;
- approver dashboard;
- administrator dashboard.

---

## Milestone 1D.3 — Administration Prototypes

Prototype administration screens for:

- organization;
- stations;
- dispenser units;
- sides;
- nozzles;
- employees;
- fuel types;
- fuel prices;
- shift definitions;
- users;
- roles;
- station access.

---

## Milestone 1D.4 — Shift Operations Prototypes

Prototype:

- shift opening;
- employee selection;
- dispenser selection;
- nozzle assignment;
- employee hours;
- shift status.

---

## Milestone 1D.5 — Mobile Receipt and OCR Prototypes

Prototype the mobile-first flow:

1. Take/select receipt photograph.
2. Preview.
3. Replace if required.
4. Submit.
5. OCR processing.
6. Display extracted readings.
7. Highlight uncertain values.
8. Correct values.
9. Confirm.

This prototype requires explicit client feedback before final
implementation.

---

## Milestone 1D.6 — Collections and Reconciliation Prototypes

Prototype:

- cash denomination entry;
- coins;
- TID collection;
- credit sales;
- adjustments;
- employee reconciliation;
- shift reconciliation.

---

## Milestone 1D.7 — Reviewer and Approver Prototypes

Prototype:

- Level-1 review queue;
- reconciliation review;
- return with reason;
- approval;
- approval with remarks;
- Level-2 queue;
- Level-2 approval;
- audit/history view.

---

## Milestone 1D.8 — Approved Frontend Implementation

Implement approved prototypes using the selected frontend technology.

Frontend development may proceed incrementally as backend APIs become
available.

---

# 9. Client Review and Demonstration Plan

## UI Review #1 — Initial UX Direction

**Target:** Late Aug-2026

Present:

- navigation;
- login;
- dashboards;
- administration screens;
- mobile layout;
- initial receipt-capture flow.

### Objective

Obtain early agreement on:

- terminology;
- layout;
- navigation;
- mobile usability;
- information hierarchy;
- workflow expectations.

---

## Demo #1 — Administration and Operational Setup

**Target:** Early/Mid Sep-2026

Expected capabilities:

- login;
- station setup;
- dispenser/nozzle setup;
- employee management;
- fuel prices;
- shift definition;
- shift opening;
- employee assignment;
- nozzle assignment;
- employee working hours.

### Objective

Validate operational configuration and shift setup with the client.

---

## Demo #2 — Employee End-to-End Shift Workflow

**Target:** Late Sep / Early Oct-2026

Expected flow:

```text
Employee Login
    ↓
Shift
    ↓
Receipt Capture
    ↓
OCR
    ↓
Review / Correction
    ↓
Fuel Sale Calculation
    ↓
Cash / Coins
    ↓
TID
    ↓
Credit
    ↓
Adjustments
```

### Objective

Validate the actual employee-facing station workflow.

---

## Demo #3 — Complete Reconciliation and Approval Workflow

**Target:** Mid Oct-2026

Expected flow:

```text
Employee Reconciliation
        ↓
Submission
        ↓
Level-1 Review
        ↓
Return / Approval
        ↓
Resubmission if required
        ↓
Level-2 Approval
        ↓
Final Reconciliation
        ↓
Audit History
        ↓
Reports
```

### Objective

Validate the complete business process before UAT.

---

# 10. Phase 1E — Reports and Management Visibility

**Target:** Oct-2026

Implement:

- reconciliation reports;
- employee reconciliation reports;
- shift reports;
- fuel sales reports;
- payment collection reports;
- adjustment reports;
- employee working-hours reports;
- receipt/OCR reports;
- manual-correction reports;
- approval-history reports;
- audit-history reports;
- PDF export;
- Excel export where required.

Report requirements shall remain aligned with the approved BRD.

---

# 11. Phase 1F — Incoming Fuel Stock

**Status:** PARTIALLY DEFERRED / CLIENT DEPENDENT

Known scope includes:

- invoice number;
- invoice date/time;
- product description;
- product code;
- quantity;
- value;
- invoice image;
- OCR extraction;
- manual verification/correction.

Remaining work depends on client clarification of the required incoming
fuel-stock report.

## Planned Sequence

### 1F.1 Client Report Clarification

Confirm:

- report purpose;
- grouping;
- filters;
- totals;
- stock interpretation;
- historical requirements.

### 1F.2 Data Model Finalization

### 1F.3 Database Migration

### 1F.4 Invoice Upload and OCR

### 1F.5 Verification / Correction UI

### 1F.6 Incoming Fuel Stock Report

This dependency shall be tracked as a project risk until clarified.

---

# 12. Phase 1G — Testing and Quality Assurance

**Target:** Continuous + final intensive cycle in Oct-2026

Testing shall include:

## 1G.1 Domain Unit Tests

## 1G.2 PostgreSQL Repository Integration Tests

## 1G.3 Application Service Tests

## 1G.4 REST API Integration Tests

## 1G.5 OCR and File Upload Tests

## 1G.6 Security and Authorization Tests

## 1G.7 Frontend Component Tests

## 1G.8 End-to-End Business Flow Tests

Critical E2E scenarios include:

```text
Login
→ Open Shift
→ Assign Employees
→ Assign Nozzles
→ Upload START Receipt
→ OCR
→ Correct / Confirm
→ Upload END Receipt
→ OCR
→ Calculate Sales
→ Enter Collections
→ Reconcile
→ Submit
→ Review
→ Approve
→ Close Shift
```

## 1G.9 Concurrency Tests

Verify:

- optimistic locking;
- concurrent updates;
- duplicate submissions;
- concurrent approval attempts.

## 1G.10 Performance and Stability Tests

---

# 13. Phase 1H — Production Hardening and Deployment

**Target:** Late Oct-2026

Implement and verify:

- production configuration;
- environment-specific secrets;
- HTTPS;
- reverse proxy;
- database security;
- least-privilege database access;
- receipt-file storage;
- backup;
- restore;
- 14-month retention policy;
- archival/purge strategy;
- application logging;
- audit logging;
- monitoring;
- health checks;
- deployment packaging;
- production startup procedures.

---

# 14. Phase 1I — UAT and Production Release

**Target:** 21-Oct-2026 to 31-Oct-2026

## 1I.1 UAT Environment Preparation

## 1I.2 Client User Acceptance Testing

## 1I.3 UAT Defect Resolution

Defects shall be classified as:

- Critical;
- High;
- Medium;
- Low.

Critical production-blocking defects must be resolved before release.

## 1I.4 Documentation

Prepare:

- administrator guide;
- employee/user guide;
- reviewer/approver guide;
- deployment guide;
- backup/restore guide;
- operational support notes.

## 1I.5 Production Readiness Review

## 1I.6 Production Deployment

## 1I.7 Version 1.0 Release

**Target Release Date: 31-Oct-2026**

---

# 15. High-Level Delivery Schedule

| Period | Primary Target |
|---|---|
| 16-Aug to 31-Aug | Application foundation, master/admin backend, documentation alignment, UI prototypes |
| 01-Sep to 15-Sep | Security, shift operations, employee hours, first client demo |
| 16-Sep to 30-Sep | Receipt/OCR, sales, collections, adjustments |
| 01-Oct to 10-Oct | Reconciliation and two-level approval |
| 11-Oct to 20-Oct | Frontend completion, reports, integration and third client demo |
| 21-Oct to 27-Oct | UAT, defects, testing and production hardening |
| 28-Oct to 31-Oct | Final verification, deployment and v1.0 release |

---

# 16. Parallel Delivery Tracks

The project shall not execute all activities sequentially.

Where practical, the following tracks shall progress in parallel:

```text
Backend Development
        │
        ├───────────────┐
        │               │
        ▼               ▼
UI/UX Prototype    Documentation
        │           Alignment
        │               │
        └───────┬───────┘
                ▼
          Client Review
                │
                ▼
      Frontend Implementation
                │
                ▼
          Integration Tests
                │
                ▼
              UAT
                │
                ▼
       Production Release
```

This approach is intended to reduce late-stage client feedback and protect
the 31-Oct-2026 delivery target.

---

# 17. Milestone Completion Procedure

Every milestone shall undergo a formal completion review.

The review shall verify:

1. planned scope completed;
2. implementation reviewed;
3. database alignment verified where applicable;
4. build successful;
5. automated tests successful;
6. application startup successful where applicable;
7. Git whitespace check successful;
8. Git working tree clean;
9. commits pushed to `origin/main`;
10. documentation impact reviewed;
11. client-demo impact reviewed;
12. remaining roadmap reviewed;
13. delivery-date impact reviewed;
14. risks/dependencies updated;
15. next milestone scope confirmed.

The project plan shall then be updated with:

- actual completion date;
- completion status;
- significant Git commit references;
- verification performed;
- issues discovered;
- decisions made;
- client feedback;
- documentation impact;
- roadmap impact;
- schedule variance;
- current confidence in the target release date.

---

# 18. Documentation Alignment Policy

The following documents shall remain synchronized with the implemented and
client-approved system:

- `docs/business-requirements.md`
- `docs/BRD/BRD-v1.0.md`
- `docs/architecture.md`
- `docs/domain-model.md`
- `docs/database-design.md`
- `project-management/project-plan.md`

When implementation reveals a genuine requirement or design discrepancy,
the discrepancy shall be reviewed rather than silently changing either
the documentation or implementation.

---

# 19. Client Decision Register

Client decisions affecting implementation shall be recorded in this
project plan or an associated decision document.

Current items requiring client input include:

### UI/UX

- dashboard layout;
- navigation;
- terminology;
- mobile receipt-capture experience;
- reconciliation presentation;
- reviewer/approver workflow presentation.

### Incoming Fuel Stock

- required report;
- grouping/filtering;
- stock interpretation;
- totals;
- historical presentation.

Additional client-dependent items shall be added as they arise.

---

# 20. Current Risks and Dependencies

## RISK-001 — Delivery Capacity

The 31-Oct-2026 target assumes approximately four focused development
hours per day.

**Mitigation:** milestone tracking, parallel UI work, incremental testing,
early client reviews and scope control.

---

## RISK-002 — Late UI Feedback

Late client feedback on UI or workflow could require substantial frontend
rework.

**Mitigation:** begin UI prototypes during backend development and obtain
client feedback early.

---

## RISK-003 — OCR Accuracy

Receipt image quality may affect OCR accuracy.

**Mitigation:** preprocessing, confidence scoring, OCR attempt tracking,
manual correction and testing with real receipt samples.

---

## RISK-004 — Incoming Fuel Stock Clarification

Final incoming-fuel-stock reporting requirements remain dependent on
client clarification.

**Mitigation:** obtain clarification before finalizing the corresponding
database and application design.

---

## RISK-005 — Integration Compression

Leaving frontend/backend integration until the end could threaten the
release date.

**Mitigation:** integrate incrementally as APIs and approved UI components
become available.

---

# 21. Release v1.0 Definition

Version 1.0 shall be considered production-ready when:

- agreed first-release functional requirements are implemented;
- critical client-approved workflows are operational;
- role-based access is enforced;
- responsive employee workflow is usable on mobile devices;
- receipt OCR workflow is operational;
- manual correction is auditable;
- sales calculations are verified;
- collections are captured;
- reconciliation is verified;
- two-level approval works end-to-end;
- required reports are available;
- audit history is available;
- required documentation is synchronized;
- automated tests pass;
- UAT is completed;
- critical/high release-blocking defects are resolved;
- backup and recovery procedures are verified;
- production configuration is prepared;
- deployment verification succeeds.

**Target Production Release: 31-Oct-2026**

---

# 22. Next Action

The next implementation milestone is:

**Milestone 1C.2 — Application Service Foundation**

Before implementation begins:

1. commit this project-plan baseline;
2. review the detailed scope of Milestone 1C.2;
3. define its package structure;
4. define its commit sequence;
5. define its completion criteria;
6. begin implementation incrementally.