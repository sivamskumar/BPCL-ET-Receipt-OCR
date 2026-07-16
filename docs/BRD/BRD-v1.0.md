# Fuel Station Shift Reconciliation System

# Business Requirements Document (BRD)

---

## Document Information

| Item | Details |
|------|----------|
| Project Name | Fuel Station Shift Reconciliation System |
| Document Name | Business Requirements Document |
| Version | 1.0 |
| Status | Draft for Client Review |
| Prepared By | Sivakumar Mani |
| Reviewed By | To Be Confirmed |
| Approved By | Client |
| Document Date | July 2026 |

---

# Revision History

| Version | Date | Author | Description |
|---|---|---|---|
| 0.1 | July 2026 | Sivakumar Mani | Initial BRD structure |
| 0.2 | July 2026 | Sivakumar Mani | Business overview |
| 0.3 | July 2026 | Sivakumar Mani | Functional requirements |
| 0.4 | July 2026 | Sivakumar Mani | Business rules and quality requirements |
| 0.5 | July 2026 | Sivakumar Mani | Workflows, screens and reports |
| 1.0 Draft | July 2026 | Sivakumar Mani | Consolidated draft for client review |

---

# Distribution List

| Name | Designation | Organization |
|------|-------------|--------------|
| Client | Business Owner | TBD |
| Sivakumar Mani | Software Developer | Project Team |

---

# Approval Sheet

| Name | Designation | Signature | Date |
|------|-------------|-----------|------|
| Client | Business Owner | | |
| Reviewer | Project Reviewer | | |
| Sivakumar Mani | Developer | | |

---

# Table of Contents

# 1. Executive Summary

## 1.1 Purpose

The Fuel Station Shift Reconciliation System is a centralized web-based application designed to automate the end-to-end reconciliation process performed at fuel stations.

The system enables employees to upload Electronic Totalizer (ET) receipts at the beginning and end of each operational shift. Using Optical Character Recognition (OCR), the application extracts nozzle-wise fuel readings, calculates fuel sales, records cash and digital collections, and automatically performs reconciliation.

The application aims to replace manual calculations with an accurate, transparent and auditable reconciliation process.

---

## 1.2 Vision

To provide a secure, scalable and user-friendly reconciliation platform that minimizes manual effort, improves operational accuracy and supports future expansion across multiple fuel stations.

---

## 1.3 Business Benefits

Implementation of this solution is expected to provide the following benefits:

- Eliminate manual reconciliation calculations.
- Reduce arithmetic and recording errors.
- Improve accountability of fuel station employees.
- Improve accuracy of daily fuel sales calculations.
- Reduce reconciliation time.
- Maintain complete audit history.
- Support centralized monitoring of multiple stations.
- Provide management reports for operational decision making.
- Enable future integration with enterprise systems.

---

# 2. Business Background

Fuel stations currently perform shift reconciliation manually using printed Electronic Totalizer receipts.

At the beginning of a shift, employees obtain a Start Reading Receipt from the dispenser unit.

At the end of the shift, another receipt is generated showing updated cumulative readings.

Employees manually compare these readings to determine:

- Quantity of fuel sold
- Total sales amount
- Cash received
- UPI collections
- Card collections
- Credit sales
- Expenses
- Final cash difference

This manual process is time-consuming and prone to calculation mistakes.

The proposed system automates these activities while preserving complete operational history.

---

# 3. Current Business Process (As-Is)

The current operational process consists of the following activities.

1. Employee reports for duty.
2. Start Reading Receipt is printed.
3. Employee performs fuel dispensing during the shift.
4. Customers pay using cash, UPI, card or credit.
5. Employee manually records collections.
6. End Reading Receipt is printed.
7. Employee manually calculates fuel quantity sold.
8. Employee manually calculates expected sales amount.
9. Employee manually counts cash.
10. Employee manually compares expected amount with collections.
11. Manager verifies calculations.
12. Shift is closed.

---

## Current Process Flow

```text
Employee

↓

Print Start Reading Receipt

↓

Fuel Dispensing

↓

Collect Payments

↓

Print End Reading Receipt

↓

Manual Calculation

↓

Manager Verification

↓

Shift Closed
```

---

# 4. Problems in Existing Process

The existing manual process introduces several operational challenges.

## P1 Manual Calculations

Employees manually calculate fuel quantities and sales values.

This increases the likelihood of arithmetic errors.

---

## P2 Time Consumption

Manual reconciliation requires considerable time after every shift.

This delays shift closure.

---

## P3 Human Errors

Errors may occur while:

- Reading receipt values
- Calculating differences
- Counting cash
- Recording UPI collections
- Recording expenses

---

## P4 Limited Audit Trail

Manual records make it difficult to determine:

- Who made changes
- When changes were made
- Why changes were made

---

## P5 Difficult Reporting

Preparation of daily and monthly reports requires additional manual effort.

---

## P6 Limited Scalability

Managing multiple fuel stations using manual methods is difficult.

---

## P7 Poor Traceability

Receipt images, calculations and payment entries are not centrally linked.

---

# 5. Proposed Solution

The proposed solution is a centralized web application accessible from desktop and mobile devices.

The application will automate:

- Receipt upload
- OCR processing
- Fuel sales calculation
- Cash denomination calculation
- UPI collection entry
- Card collection entry
- Credit sale entry
- Expense entry
- Shift reconciliation
- Approval workflow
- Report generation

The application will maintain a complete audit trail for all important business activities.

---

## Proposed Process Flow

```text
Login

↓

Open Shift

↓

Upload Start Receipt

↓

OCR Processing

↓

Fuel Dispensing

↓

Upload End Receipt

↓

OCR Processing

↓

Calculate Fuel Sales

↓

Enter Collections

↓

Reconciliation

↓

Approval

↓

Shift Closed
```

---

# 6. Business Objectives

The objectives of this project are:

BO-001
Automate receipt processing.

BO-002
Improve reconciliation accuracy.

BO-003
Reduce manual calculations.

BO-004
Provide centralized data management.

BO-005
Improve employee accountability.

BO-006
Support multiple fuel stations.

BO-007
Provide management reports.

BO-008
Maintain complete audit history.

BO-009
Reduce shift closing time.

BO-010
Provide a scalable platform for future expansion.

---

# 7. Project Scope

## 7.1 In Scope

The first release includes:

- Organization management
- Fuel station management
- Dispenser unit management
- Nozzle configuration
- Employee management
- Nozzle assignment
- Fuel price management
- Shift management
- Start Receipt upload
- End Receipt upload
- OCR processing
- Manual OCR correction
- Fuel sales calculation
- Cash denomination entry
- UPI collection entry
- Card collection entry
- Credit sale entry
- Expense and adjustment entry
- Employee reconciliation
- Shift reconciliation
- Two-level approval workflow
- Reports
- Audit history
- Responsive web application

---

## 7.2 Out of Scope

The following features are excluded from the initial release.

- Native Android application
- Native iOS application
- Bank integration
- Automatic UPI reconciliation
- ERP integration
- SMS notifications
- Email notifications
- Tank inventory management
- Loyalty programs
- AI fraud detection

These may be implemented in future releases.

---

# 8. Stakeholders

The following stakeholders participate in the project.

| Stakeholder | Responsibility |
|-------------|----------------|
| Fuel Station Owner | Business ownership |
| Station Manager | Operational management |
| Employee | Shift operations |
| Reviewer | First-level reconciliation review |
| Approver | Second-level approval |
| System Administrator | System configuration |
| Auditor | Audit and compliance |
| Software Development Team | Design, development and support |

---

## End of Business Overview

The remaining sections of this Business Requirements Document will define detailed functional requirements, business rules, workflows, user interfaces, reports and acceptance criteria.

# 9. Functional Requirements

## 9.1 Introduction

This section defines the functional capabilities that shall be provided by the Fuel Station Shift Reconciliation System.

Each functional requirement is assigned:

- Functional Requirement ID
- Module Identifier
- Priority
- Actors
- Description
- Preconditions
- Postconditions
- Acceptance Criteria

Priority definitions:

| Priority | Description |
|-----------|-------------|
| Critical | Mandatory for successful operation of the application. |
| High | Required for Version 1.0 release. |
| Medium | Important but may be deferred if necessary. |
| Low | Future enhancement. |

---

# 9.2 Authentication Module

---

## FR-001 — User Login

**Module ID**

AUTH-001

**Priority**

Critical

**Actors**

- Employee
- Reviewer
- Approver
- Administrator
- Auditor

### Business Requirement

The system shall authenticate users using their assigned username and password before granting access to the application.

### Preconditions

- User account exists.
- User account is active.
- User account is not locked.

### Postconditions

- User session is established.
- User role is identified.
- Appropriate dashboard is displayed.

### Acceptance Criteria

- Valid credentials allow login.
- Invalid credentials display an error message.
- Locked users cannot log in.
- Inactive users cannot log in.

---

## FR-002 — User Logout

**Module ID**

AUTH-002

**Priority**

High

**Actors**

All authenticated users.

### Business Requirement

The system shall allow authenticated users to securely terminate their session.

### Preconditions

User is logged in.

### Postconditions

- User session is invalidated.
- User is redirected to the Login page.

### Acceptance Criteria

- Logout successfully terminates the session.
- Previously accessed pages cannot be reopened using the browser Back button.

---

## FR-003 — Password Change

**Module ID**

AUTH-003

**Priority**

High

**Actors**

All authenticated users.

### Business Requirement

The system shall allow users to change their password after successful authentication.

### Preconditions

- User is authenticated.
- Current password is entered correctly.

### Postconditions

- Password is updated.
- Previous password becomes invalid.

### Acceptance Criteria

- Current password must be validated.
- New password must satisfy password policy.
- Confirmation password must match.

---

## FR-004 — Role Based Access Control

**Module ID**

AUTH-004

**Priority**

Critical

### Business Requirement

The system shall restrict access to functions based on the authenticated user's assigned role.

### Roles

- Employee
- Reviewer
- Approver
- Administrator
- Auditor

### Acceptance Criteria

Users shall only access screens and functions authorized for their assigned role.

---

## FR-005 — Session Timeout

**Module ID**

AUTH-005

**Priority**

High

### Business Requirement

The system shall automatically terminate inactive user sessions after the configured timeout period.

### Acceptance Criteria

- Inactive sessions expire automatically.
- User shall log in again to continue.

---

# 9.3 Organization Module

---

## FR-006 — Organization Management

**Module ID**

ORG-001

**Priority**

Medium

### Business Requirement

The system shall allow authorized administrators to create and maintain organization information.

### Organization Information

- Organization Code
- Organization Name
- Address
- Contact Details
- Active Status

---

## FR-007 — View Organization

**Module ID**

ORG-002

The system shall allow authorized users to view organization information.

---

## FR-008 — Update Organization

**Module ID**

ORG-003

The system shall allow authorized administrators to modify organization information.

---

## FR-009 — Activate / Deactivate Organization

**Module ID**

ORG-004

The system shall allow administrators to activate or deactivate organizations without deleting historical data.

---

# 9.4 Fuel Station Module

---

## FR-010 — Fuel Station Management

**Module ID**

STN-001

### Business Requirement

The system shall allow administrators to maintain fuel station information.

Station information includes:

- Station Code
- Station Name
- Address
- Contact Details
- Time Zone
- Active Status

---

## FR-011 — View Fuel Station

**Module ID**

STN-002

The system shall allow authorized users to view fuel station details.

---

## FR-012 — Update Fuel Station

**Module ID**

STN-003

The system shall allow administrators to update station information.

---

## FR-013 — Activate / Deactivate Fuel Station

**Module ID**

STN-004

The system shall allow administrators to activate or deactivate stations while preserving historical data.

---

## FR-014 — Assign Users to Station

**Module ID**

STN-005

The system shall allow administrators to assign authorized users to one or more fuel stations.

---

# 9.5 Dispenser Unit Module

---

## FR-015 — Register Dispenser Unit

**Module ID**

DU-001

### Business Requirement

The system shall allow administrators to register dispenser units.

The following information shall be maintained:

- DU Serial Number
- Display Name
- Manufacturer
- Model
- Active Status

---

## FR-016 — View Dispenser Unit

**Module ID**

DU-002

The system shall allow authorized users to view dispenser unit details.

---

## FR-017 — Update Dispenser Unit

**Module ID**

DU-003

The system shall allow administrators to modify dispenser unit information.

---

## FR-018 — Activate / Deactivate Dispenser Unit

**Module ID**

DU-004

The system shall allow administrators to activate or deactivate dispenser units while preserving historical transactions.

---

## FR-019 — Validate DU Serial Number

**Module ID**

DU-005

### Business Requirement

The system shall validate that uploaded Start and End Reading receipts belong to the same normalized DU Serial Number before reconciliation processing begins.

### Acceptance Criteria

- Matching DU Serial Numbers allow processing.
- Mismatched DU Serial Numbers require review and prevent automatic reconciliation.

---

# 9.6 Employee Management Module

## FR-020 — Create Employee

**Module ID:** EMP-001  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an authorized administrator to create an employee record.

### Employee Information

- Employee Code
- Employee Name
- Mobile Number
- Email Address, where applicable
- Assigned Station or Stations
- Active Status

### Preconditions

- The administrator is authenticated.
- The administrator has employee-management permission.

### Postconditions

- A new employee record is created.
- The action is recorded in the audit history.

### Acceptance Criteria

- Employee Code is mandatory.
- Employee Code must be unique within the organization.
- Employee Name is mandatory.
- Duplicate employee records shall be prevented.
- The employee shall be available for nozzle assignment after activation.

---

## FR-021 — View Employees

**Module ID:** EMP-002  
**Priority:** High  
**Primary Actors:** Administrator, Manager, Reviewer

### Business Requirement

The system shall allow authorized users to view employees available within their permitted organization or stations.

### Acceptance Criteria

- Users can search by Employee Code or Employee Name.
- Users can filter by station and active status.
- Users shall only view employees within their permitted scope.

---

## FR-022 — Update Employee

**Module ID:** EMP-003  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an authorized administrator to update employee information.

### Acceptance Criteria

- Historical shift records shall retain the employee details recorded for those shifts.
- Employee Code uniqueness shall be maintained.
- All significant changes shall be audited.

---

## FR-023 — Activate or Deactivate Employee

**Module ID:** EMP-004  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to activate or deactivate an employee without deleting historical records.

### Acceptance Criteria

- An inactive employee cannot be assigned to a new shift.
- Existing historical shifts remain unchanged.
- Deactivation shall not delete reconciliation history.

---

## FR-024 — Assign Employee to Station

**Module ID:** EMP-005  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to associate an employee with one or more permitted fuel stations.

### Acceptance Criteria

- The employee can only access assigned stations unless broader access is authorized.
- Station assignments can be activated or ended.
- Historical station assignments shall be retained.

---

# 9.7 Nozzle Management Module

## FR-025 — Create Nozzle

**Module ID:** NOZ-001  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to configure nozzle points for a dispenser unit.

### Nozzle Information

- Dispenser Unit
- Nozzle Number
- Fuel Type
- Display Name, where required
- Active Status

### Acceptance Criteria

- Nozzle Number is mandatory.
- Nozzle Number must be positive.
- Nozzle Number must be unique within a dispenser unit.
- Fuel Type is mandatory.
- The system shall not permanently restrict a dispenser unit to four nozzles.

---

## FR-026 — View Nozzles

**Module ID:** NOZ-002  
**Priority:** High

### Business Requirement

The system shall allow authorized users to view nozzle configuration by station and dispenser unit.

### Acceptance Criteria

The displayed information shall include:

- Nozzle Number
- Fuel Type
- Assigned Employee
- Assignment Effective Period
- Active Status

---

## FR-027 — Update Nozzle

**Module ID:** NOZ-003  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to update nozzle configuration.

### Acceptance Criteria

- Changes shall not alter completed shift records.
- Fuel Type changes shall take effect only for new operational periods.
- Changes shall be recorded in the audit history.

---

## FR-028 — Activate or Deactivate Nozzle

**Module ID:** NOZ-004  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to activate or deactivate a nozzle.

### Acceptance Criteria

- An inactive nozzle cannot be included in a new shift.
- Historical readings and sales shall remain available.
- Deactivation shall not delete prior assignments.

---

## FR-029 — Assign Nozzle to Employee

**Module ID:** NOZ-005  
**Priority:** Critical  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow an administrator to assign a nozzle to an employee for a defined effective period.

### Assignment Information

- Station
- Dispenser Unit
- Nozzle
- Employee
- Effective From Date
- Effective To Date, where applicable

### Acceptance Criteria

- Only active employees can be assigned.
- Only active nozzles can be assigned.
- One nozzle cannot be assigned to multiple employees for an overlapping period.
- Historical assignments shall be retained.
- Assignment changes shall not alter completed shift reconciliations.

---

## FR-030 — Resolve Shift Nozzle Assignment

**Module ID:** NOZ-006  
**Priority:** Critical

### Business Requirement

When a shift is opened, the system shall determine the employee assigned to each nozzle for the shift business date.

### Acceptance Criteria

- Every active nozzle participating in the shift shall have one assigned employee.
- Missing or conflicting assignments shall prevent shift activation.
- The assignments used for the shift shall be preserved as a shift snapshot.

---

# 9.8 Fuel Type and Fuel Price Module

## FR-031 — Maintain Fuel Types

**Module ID:** PRICE-001  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow authorized administrators to maintain supported fuel types.

### Initial Fuel Types

- Petrol
- Diesel

### Acceptance Criteria

- Fuel Type Code must be unique.
- Fuel Type Name is mandatory.
- Additional fuel types can be added without modifying historical records.
- An inactive fuel type cannot be assigned to a new nozzle.

---

## FR-032 — Create Fuel Price

**Module ID:** PRICE-002  
**Priority:** Critical  
**Primary Actors:** Administrator, Manager

### Business Requirement

The system shall allow an authorized user to record a fuel price for a station and fuel type.

### Fuel Price Information

- Station
- Fuel Type
- Price Per Litre
- Effective From Date and Time
- Effective To Date and Time, where applicable
- Active Status

### Acceptance Criteria

- Price Per Litre must be greater than zero.
- Effective From is mandatory.
- Overlapping price periods for the same station and fuel type shall not be allowed.
- Price history shall be preserved.

---

## FR-033 — View Fuel Price History

**Module ID:** PRICE-003  
**Priority:** High

### Business Requirement

The system shall allow authorized users to view current and historical fuel prices.

### Acceptance Criteria

Users can filter price history by:

- Station
- Fuel Type
- Effective Date
- Active Status

---

## FR-034 — Update Future Fuel Price

**Module ID:** PRICE-004  
**Priority:** High  
**Primary Actors:** Administrator, Manager

### Business Requirement

The system shall allow correction of a future fuel price that has not yet been used by an operational shift.

### Acceptance Criteria

- A fuel price already used in a completed reconciliation shall not be silently changed.
- Historical price corrections require authorized procedures and audit records.
- Overlapping price periods remain prohibited.

---

## FR-035 — Resolve Effective Fuel Price

**Module ID:** PRICE-005  
**Priority:** Critical

### Business Requirement

The system shall automatically select the fuel price applicable to the station, fuel type and shift date or time.

### Acceptance Criteria

- Exactly one applicable price shall be identified.
- Missing price configuration shall prevent final sales calculation.
- Conflicting price configuration shall trigger review.
- The selected price shall be retained with the shift calculation.

---

# 9.9 Shift Management Module

## FR-036 — Open Shift

**Module ID:** SHIFT-001  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an authorized employee to open an operational shift for an assigned station and dispenser unit.

### Shift Information

- Station
- Dispenser Unit
- DU Serial Number
- Business Date
- Shift Number
- Start Date and Time
- Participating Employees
- Assigned Nozzles

### Preconditions

- The employee is authenticated.
- The station is active.
- The dispenser unit is active.
- Nozzle assignments are valid.
- Required fuel prices are configured.

### Postconditions

- A new shift is created with Open status.
- Employee and nozzle assignment snapshots are created.
- The shift-opening action is audited.

### Acceptance Criteria

- Shift Number must be unique for the dispenser unit and business date.
- Invalid station, DU, employee or nozzle configurations shall prevent opening.
- The shift shall display all participating employees and nozzles.

---

## FR-037 — View Open Shifts

**Module ID:** SHIFT-002  
**Priority:** High

### Business Requirement

The system shall allow authorized users to view open shifts within their permitted stations.

### Acceptance Criteria

Users can filter shifts by:

- Station
- Dispenser Unit
- Business Date
- Employee
- Shift Status

---

## FR-038 — Resume Shift

**Module ID:** SHIFT-003  
**Priority:** High  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an authorized employee to resume an incomplete shift.

### Acceptance Criteria

- Previously entered information shall be retained.
- The employee shall continue from the next required activity.
- Closed or cancelled shifts cannot be resumed through the normal workflow.

---

## FR-039 — Update Open Shift Information

**Module ID:** SHIFT-004  
**Priority:** High  
**Primary Actors:** Employee, Supervisor

### Business Requirement

The system shall allow permitted shift information to be corrected while the shift remains open.

### Acceptance Criteria

- Critical changes shall be restricted after receipt confirmation.
- All significant changes shall be audited.
- Historical assignment snapshots shall not be changed without authorization.

---

## FR-040 — Cancel Shift

**Module ID:** SHIFT-005  
**Priority:** High  
**Primary Actors:** Supervisor, Manager

### Business Requirement

The system shall allow an authorized user to cancel an invalid or incorrectly opened shift.

### Acceptance Criteria

- A cancellation reason is mandatory.
- Cancelled shifts remain available for audit.
- A cancelled shift cannot be reconciled or approved.
- Cancellation shall not physically delete uploaded records.

---

## FR-041 — Maintain Shift Status

**Module ID:** SHIFT-006  
**Priority:** Critical

### Business Requirement

The system shall maintain the operational status of every shift throughout its lifecycle.

### Supported Statuses

- Open
- Start Receipt Uploaded
- End Receipt Uploaded
- OCR Completed
- Readings Confirmed
- Payments Entered
- Reconciled
- Submitted for Level-1 Review
- Returned to Employee
- Resubmitted
- Forwarded for Level-2 Approval
- Approved
- Closed
- Cancelled

### Acceptance Criteria

- Status transitions shall follow the approved business workflow.
- Unauthorized status changes shall be prevented.
- Every status transition shall be audited.

---

## FR-042 — Preserve Shift Assignment Snapshot

**Module ID:** SHIFT-007  
**Priority:** Critical

### Business Requirement

The system shall preserve the employees, nozzles and fuel types used during a shift.

### Acceptance Criteria

- Later changes to master data shall not change previous shift calculations.
- Historical shifts shall display the assignments used at the time of operation.

---

## FR-043 — Validate Shift Completeness

**Module ID:** SHIFT-008  
**Priority:** Critical

### Business Requirement

Before reconciliation submission, the system shall validate that all required shift activities are complete.

### Required Conditions

- Start Receipt is available.
- End Receipt is available.
- Receipt values are confirmed.
- Fuel-sales calculation is complete.
- Employee collections are entered.
- Required adjustments are recorded.
- Reconciliation is calculated.

### Acceptance Criteria

The system shall clearly identify incomplete activities and prevent submission until mandatory information is completed.

---

## FR-044 — Close Approved Shift

**Module ID:** SHIFT-009  
**Priority:** Critical  
**Primary Actor:** Authorized Manager or System Workflow

### Business Requirement

The system shall close a shift after all required approvals are completed.

### Acceptance Criteria

- Only an approved shift can be closed.
- Closed shifts become read-only during normal operation.
- Reopening requires an authorized correction process.
- Closure date, time and user shall be recorded.

---

# 9.10 Receipt Management Module

## FR-045 — Upload Start Reading Receipt

**Module ID:** RCPT-001  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to upload the Start Reading Receipt for an open shift.

### Supported User Actions

The user shall be able to:

- Capture a new receipt image using a supported device camera.
- Select an existing receipt image from the device.
- Preview the selected image.
- Replace the image before submission.
- Submit the image for processing.

### Preconditions

- The user is authenticated.
- The shift is open.
- A Start Reading Receipt has not already been confirmed for the shift.

### Postconditions

- The receipt image is stored.
- Receipt metadata is recorded.
- Receipt processing is initiated.
- The shift status is updated.

### Acceptance Criteria

- The user can upload a supported image.
- The selected image is displayed for preview.
- The user can replace an incorrect or poor-quality image.
- Duplicate submission is prevented.
- Successful upload displays a confirmation message.
- Failed upload displays a clear error message.

---

## FR-046 — Upload End Reading Receipt

**Module ID:** RCPT-002  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to upload the End Reading Receipt for an open shift.

### Preconditions

- The user is authenticated.
- The shift is active.
- A Start Reading Receipt exists.
- An End Reading Receipt has not already been confirmed.

### Postconditions

- The End Reading Receipt is stored.
- Receipt processing is initiated.
- The shift status is updated.

### Acceptance Criteria

- The receipt belongs to the selected shift.
- The user can preview and replace the image before submission.
- Duplicate End Reading Receipt submission is prevented.
- A confirmation message is displayed after successful upload.

---

## FR-047 — Validate Receipt File

**Module ID:** RCPT-003  
**Priority:** Critical

### Business Requirement

The system shall validate an uploaded receipt image before processing.

### Validation Rules

The system shall validate:

- File is present.
- File is not empty.
- File type is supported.
- File size is within the configured limit.
- Image can be opened successfully.
- Image dimensions meet the minimum requirement.
- File does not duplicate an existing receipt image.

### Initial Supported File Types

- JPEG
- JPG
- PNG

### Acceptance Criteria

- Invalid files are rejected.
- The user receives a clear reason for rejection.
- Validation limits are configurable.
- Failed files are not processed by OCR.

---

## FR-048 — Store Receipt Metadata

**Module ID:** RCPT-004  
**Priority:** High

### Business Requirement

The system shall record metadata for every uploaded receipt.

### Receipt Metadata

- Receipt Type
- Shift
- Original Filename
- Stored Filename
- File Type
- File Size
- Image Dimensions
- File Hash
- Upload Date and Time
- Uploaded By
- Processing Status

### Acceptance Criteria

- Metadata is retained for audit.
- Original filenames are preserved for reference.
- Physical storage filenames are generated securely.
- File hashes support duplicate detection.

---

## FR-049 — Prevent Duplicate Receipt Upload

**Module ID:** RCPT-005  
**Priority:** High

### Business Requirement

The system shall detect and prevent accidental duplicate receipt uploads.

### Acceptance Criteria

- Duplicate files are detected using file hash or equivalent validation.
- The user is informed that the receipt has already been uploaded.
- Authorized users may review a suspected duplicate.
- Duplicate attempts are recorded where required.

---

## FR-050 — Replace Unconfirmed Receipt

**Module ID:** RCPT-006  
**Priority:** High  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to replace an uploaded receipt before the receipt values are confirmed.

### Acceptance Criteria

- Only unconfirmed receipts can be replaced through the normal workflow.
- The replacement reason may be recorded.
- Previous upload metadata remains available for audit where required.
- OCR processing restarts for the replacement image.

---

## FR-051 — View Receipt Image

**Module ID:** RCPT-007  
**Priority:** High

### Business Requirement

The system shall allow authorized users to view uploaded receipt images.

### Acceptance Criteria

- The receipt image can be viewed from the shift screen.
- The user can zoom the image.
- The image is associated with the correct receipt type.
- Access is restricted by role and station permission.

---

# 9.11 OCR Processing Module

## FR-052 — Initiate OCR Processing

**Module ID:** OCR-001  
**Priority:** Critical

### Business Requirement

The system shall automatically initiate receipt processing after a valid image is uploaded.

### Postconditions

- Processing status is updated.
- OCR processing begins.
- Processing progress or status is visible to the user.

### Acceptance Criteria

- OCR starts without requiring duplicate user action.
- The user can view whether processing is pending, successful or failed.
- Long-running processing does not freeze the user interface.

---

## FR-053 — Improve Receipt Image Quality

**Module ID:** OCR-002  
**Priority:** High

### Business Requirement

The system shall improve receipt image quality before attempting data extraction.

### Processing May Include

- Image resizing
- Grayscale conversion
- Contrast improvement
- Noise removal
- Thresholding
- Rotation correction
- Deskewing
- Perspective correction
- Region-based extraction

### Acceptance Criteria

- Processing improves readability where possible.
- The original image remains unchanged.
- Processed images may be retained for troubleshooting according to policy.

---

## FR-054 — Extract DU Serial Number

**Module ID:** OCR-003  
**Priority:** Critical

### Business Requirement

The system shall extract the DU Serial Number from the uploaded receipt.

### Acceptance Criteria

- The extracted value is normalized before comparison.
- The original extracted text is retained.
- Missing or low-confidence values require review.
- Start and End Receipt DU Serial Numbers are compared.

---

## FR-055 — Extract Receipt Date and Time

**Module ID:** OCR-004  
**Priority:** High

### Business Requirement

The system shall extract the printed receipt date and time where available.

### Acceptance Criteria

- Valid date and time values are displayed for confirmation.
- Invalid or missing values are flagged.
- Start Receipt time should precede End Receipt time unless an authorized exception applies.

---

## FR-056 — Extract Nozzle Number

**Module ID:** OCR-005  
**Priority:** Critical

### Business Requirement

The system shall identify each nozzle number printed on the receipt.

### Acceptance Criteria

- Nozzle numbers are matched to configured nozzles.
- Duplicate nozzle numbers within one receipt are flagged.
- Missing required nozzles trigger review.
- Unconfigured nozzle numbers are highlighted.

---

## FR-057 — Extract ATOT Reading

**Module ID:** OCR-006  
**Priority:** Critical

### Business Requirement

The system shall extract the accumulated amount total, referred to as ATOT, for each nozzle.

### Acceptance Criteria

- ATOT is interpreted as a precise decimal value.
- Original OCR text is retained.
- Invalid or uncertain values require review.
- Negative ATOT values are rejected.

---

## FR-058 — Extract VTOT Reading

**Module ID:** OCR-007  
**Priority:** Critical

### Business Requirement

The system shall extract the accumulated volume total, referred to as VTOT, for each nozzle.

### Acceptance Criteria

- VTOT is interpreted as a precise decimal value.
- Original OCR text is retained.
- Invalid or uncertain values require review.
- Negative VTOT values are rejected.

---

## FR-059 — Extract ECAL Factor

**Module ID:** OCR-008  
**Priority:** Medium

### Business Requirement

The system shall extract the ECAL factor where it is printed and required for operational validation.

### Acceptance Criteria

- ECAL is stored against the correct nozzle.
- Missing ECAL does not prevent processing unless configured as mandatory.
- Uncertain ECAL values are flagged for review.

---

## FR-060 — Record OCR Confidence

**Module ID:** OCR-009  
**Priority:** High

### Business Requirement

The system shall record confidence information for extracted receipt data.

### Acceptance Criteria

- Confidence is available for relevant extracted fields.
- The system uses a configurable confidence threshold.
- Fields below the threshold are marked for manual review.
- Users are not required to understand technical OCR scoring details.

---

## FR-061 — Handle OCR Processing Failure

**Module ID:** OCR-010  
**Priority:** Critical

### Business Requirement

The system shall handle receipt-processing failures without losing the uploaded receipt.

### Acceptance Criteria

- The receipt remains available.
- The failure reason is recorded.
- The user receives a clear message.
- Authorized users can retry processing.
- Technical failure details are logged for support.

---

## FR-062 — Retry OCR Processing

**Module ID:** OCR-011  
**Priority:** High  
**Primary Actors:** Employee, Reviewer, Administrator

### Business Requirement

The system shall allow authorized users to retry processing for a failed or low-quality receipt.

### Acceptance Criteria

- A retry does not create a duplicate business receipt.
- Multiple processing attempts may be retained for audit.
- The latest successful result is clearly identified.
- Previous results remain available where required.

---

## FR-063 — Display Extracted Receipt Data

**Module ID:** OCR-012  
**Priority:** Critical

### Business Requirement

The system shall display extracted receipt values for user review.

### Displayed Information

- Receipt Type
- DU Serial Number
- Receipt Date and Time
- Nozzle Number
- ATOT
- VTOT
- ECAL, where available
- Warning or review status

### Acceptance Criteria

- Extracted values are displayed beside or near the receipt image.
- Values are grouped by nozzle.
- Uncertain or missing fields are clearly highlighted.

---

## FR-064 — Correct Extracted Receipt Data

**Module ID:** OCR-013  
**Priority:** Critical  
**Primary Actors:** Employee where permitted, Reviewer, Supervisor

### Business Requirement

The system shall allow authorized users to correct an extracted receipt value before confirmation.

### Required Correction Information

- Original Value
- Corrected Value
- Correction Reason
- Corrected By
- Correction Date and Time

### Acceptance Criteria

- The original OCR value is preserved.
- Correction reason is mandatory.
- Only authorized roles can make corrections.
- Every correction is recorded in the audit history.
- Corrected numeric values are validated.

---

## FR-065 — Confirm Receipt Readings

**Module ID:** OCR-014  
**Priority:** Critical  
**Primary Actors:** Employee, Reviewer

### Business Requirement

The system shall allow an authorized user to confirm that receipt readings are correct.

### Preconditions

- Required fields are available.
- Validation errors are resolved.
- Any required corrections are completed.

### Postconditions

- Receipt status becomes Confirmed.
- Receipt readings become available for sales calculation.
- The confirming user and time are recorded.

### Acceptance Criteria

- Unresolved critical errors prevent confirmation.
- Confirmed values are protected from ordinary editing.
- Changes after confirmation require an authorized correction process.

---

## FR-066 — Validate Start and End Receipt Pair

**Module ID:** OCR-015  
**Priority:** Critical

### Business Requirement

The system shall validate the Start and End Receipts as a valid pair before fuel-sales calculation.

### Validation Rules

- Both receipts belong to the same shift.
- Both receipts have the same normalized DU Serial Number.
- Required nozzle numbers are present.
- Start and End readings correspond to the same configured nozzles.
- End Receipt date and time is later than Start Receipt date and time, subject to authorized exceptions.

### Acceptance Criteria

- Valid pairs proceed to sales calculation.
- Invalid pairs are marked for review.
- Automatic reconciliation is prevented until critical differences are resolved.

---

# 9.12 Fuel Sales Calculation Module

## FR-067 — Calculate Nozzle-Wise Fuel Quantity

**Module ID:** SALES-001  
**Priority:** Critical

### Business Requirement

The system shall calculate the quantity of fuel sold through each nozzle.

### Calculation

```text
Quantity Sold =
    End VTOT
  - Start VTOT
```

### Acceptance Criteria

- Calculation uses confirmed readings.
- Calculation uses precise decimal arithmetic.
- End VTOT lower than Start VTOT is rejected.
- Results are retained per nozzle, fuel type and employee.

---

## FR-068 — Calculate Receipt Amount Difference

**Module ID:** SALES-002  
**Priority:** Critical

### Business Requirement

The system shall calculate the dispenser-recorded sales amount for each nozzle.

### Calculation

```text
Receipt Amount Difference =
    End ATOT
  - Start ATOT
```

### Acceptance Criteria

- End ATOT lower than Start ATOT is rejected.
- The result is retained for audit.
- Calculation uses precise decimal arithmetic.

---

## FR-069 — Calculate Price-Based Sales Amount

**Module ID:** SALES-003  
**Priority:** Critical

### Business Requirement

The system shall calculate the expected sales amount using quantity sold and the applicable fuel price.

### Calculation

```text
Calculated Sales Amount =
    Quantity Sold
  × Effective Price Per Litre
```

### Acceptance Criteria

- The effective fuel price is selected automatically.
- Missing price configuration prevents final calculation.
- The price used is retained with the calculation.
- Configured rounding rules are applied consistently.

---

## FR-070 — Calculate Nozzle Amount Variance

**Module ID:** SALES-004  
**Priority:** High

### Business Requirement

The system shall compare the Receipt Amount Difference with the Price-Based Sales Amount.

### Calculation

```text
Amount Variance =
    Receipt Amount Difference
  - Calculated Sales Amount
```

### Acceptance Criteria

- The variance is calculated per nozzle.
- Variance beyond the configured limit is flagged.
- The user can view both source amounts and the difference.

---

## FR-071 — Allocate Nozzle Sales to Employee

**Module ID:** SALES-005  
**Priority:** Critical

### Business Requirement

The system shall allocate nozzle-wise fuel sales to the employee assigned to that nozzle for the shift.

### Acceptance Criteria

- Allocation uses the shift assignment snapshot.
- Sales are not allocated using later master-data changes.
- Every nozzle sale belongs to exactly one participating employee.
- Missing employee assignment prevents final reconciliation.

---

## FR-072 — Calculate Employee Fuel Sales Summary

**Module ID:** SALES-006  
**Priority:** Critical

### Business Requirement

The system shall calculate an employee-wise fuel-sales summary.

### Summary Information

- Assigned Nozzles
- Fuel Quantity by Fuel Type
- Sales Amount by Fuel Type
- Total Quantity Sold
- Total Expected Sales Amount

### Acceptance Criteria

- Petrol and Diesel are displayed separately.
- Additional fuel types can be displayed when configured.
- Employee totals equal the sum of assigned nozzle sales.

---

## FR-073 — Calculate Shift Fuel Sales Summary

**Module ID:** SALES-007  
**Priority:** Critical

### Business Requirement

The system shall calculate the total fuel sales for the shift.

### Acceptance Criteria

- Shift totals equal the sum of employee totals.
- Quantities are grouped by fuel type.
- Expected sales amount is available for reconciliation.
- Incomplete nozzle calculations prevent finalization.

---

## FR-074 — Recalculate Fuel Sales

**Module ID:** SALES-008  
**Priority:** High  
**Primary Actors:** Reviewer, Supervisor

### Business Requirement

The system shall recalculate fuel sales when an authorized receipt correction or fuel-price correction affects the result.

### Acceptance Criteria

- Previous calculations remain traceable where required.
- Recalculation records user, date and reason.
- Payment and reconciliation results are marked for recalculation.
- Approved shifts cannot be silently recalculated.

---

## FR-075 — Display Fuel Sales Calculation Details

**Module ID:** SALES-009  
**Priority:** High

### Business Requirement

The system shall display the values used in fuel-sales calculations.

### Displayed Information

- Start ATOT
- End ATOT
- Receipt Amount Difference
- Start VTOT
- End VTOT
- Quantity Sold
- Fuel Price
- Calculated Sales Amount
- Amount Variance
- Assigned Employee

### Acceptance Criteria

- Users can review calculations before payment entry.
- Values are shown nozzle-wise and employee-wise.
- Flagged variances are clearly identified.

---

# 9.13 Collection Management Module

## FR-076 — Maintain Cash Denominations

**Module ID:** PAY-001  
**Priority:** High  
**Primary Actor:** Administrator

### Business Requirement

The system shall allow authorized administrators to maintain the currency denominations available for cash collection entry.

### Initial Denominations

- ₹500
- ₹200
- ₹100
- ₹50
- ₹20
- ₹10
- ₹5
- ₹2
- ₹1

### Acceptance Criteria

- Denomination value must be greater than zero.
- Duplicate denomination values shall not be allowed for the same currency.
- Denominations may be activated or deactivated.
- Historical denomination entries shall remain unchanged.

---

## FR-077 — Enter Cash Denomination Counts

**Module ID:** PAY-002  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to enter the quantity held for each supported cash denomination.

### Preconditions

- The employee is authenticated.
- The shift readings are confirmed.
- Fuel-sales calculation is complete.
- The employee participates in the shift.

### Acceptance Criteria

- Quantity shall accept non-negative whole numbers only.
- The employee shall only enter collections for their own reconciliation unless otherwise authorized.
- Existing entries may be updated before submission.
- Entered values shall be saved against the shift and employee.

---

## FR-078 — Calculate Cash Denomination Amount

**Module ID:** PAY-003  
**Priority:** Critical

### Business Requirement

The system shall calculate the amount for each denomination.

### Calculation

```text
Denomination Amount =
    Denomination Value
  × Quantity
```

### Acceptance Criteria

- The backend shall perform the calculation.
- Browser-calculated values shall not be treated as authoritative.
- The calculated amount shall update when quantity changes.
- Negative quantities shall not be accepted.

---

## FR-079 — Calculate Employee Cash Total

**Module ID:** PAY-004  
**Priority:** Critical

### Business Requirement

The system shall calculate the total physical cash entered by an employee.

### Calculation

```text
Cash Total =
    Sum of all Denomination Amounts
```

### Acceptance Criteria

- The total shall equal the sum of all denomination rows.
- The total shall be recalculated whenever a denomination count changes.
- The cash total shall be included in employee reconciliation.

---

## FR-080 — Enter UPI Terminal Collection

**Module ID:** PAY-005  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to record the total amount received through each UPI terminal used during the shift.

### UPI Collection Information

- UPI Provider or Machine Name, where applicable
- Terminal ID (TID)
- Total Amount Received
- Remarks, where required

### Acceptance Criteria

- TID is mandatory.
- Total Amount Received must be zero or greater.
- Multiple UPI terminals may be entered for one employee and shift.
- Duplicate TID entries for the same employee and shift shall be prevented or clearly validated.
- The entry shall be associated with the correct employee and shift.

---

## FR-081 — Calculate Employee UPI Total

**Module ID:** PAY-006  
**Priority:** Critical

### Business Requirement

The system shall calculate the total UPI amount for an employee by adding all UPI terminal collections.

### Calculation

```text
UPI Total =
    Sum of Amounts Recorded for all UPI TIDs
```

### Acceptance Criteria

- The total shall update when a UPI terminal entry is added, changed or removed.
- The total shall be included in employee reconciliation.
- Individual TID values shall remain available for review and audit.

---

## FR-082 — View UPI Terminal Entries

**Module ID:** PAY-007  
**Priority:** High

### Business Requirement

The system shall allow authorized users to view employee-wise UPI terminal collection details.

### Acceptance Criteria

The display shall include:

- Employee
- TID
- UPI Provider or Machine Name
- Amount
- Remarks
- Entered By
- Entry Date and Time

---

## FR-083 — Enter Card Collection

**Module ID:** PAY-008  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to record card collections received during the shift.

### Card Collection Information

- Terminal ID or Machine Reference, where applicable
- Total Card Amount
- Settlement or Batch Reference, where applicable
- Remarks

### Acceptance Criteria

- Amount must be zero or greater.
- Multiple card-terminal entries may be recorded.
- Each entry shall belong to the correct employee and shift.
- Card totals shall be included in reconciliation.

---

## FR-084 — Calculate Employee Card Total

**Module ID:** PAY-009  
**Priority:** Critical

### Business Requirement

The system shall calculate the total card collection for each employee.

### Calculation

```text
Card Total =
    Sum of all Card Collection Entries
```

### Acceptance Criteria

- The total updates whenever card entries change.
- Individual card entries remain available for audit.
- The total is included in employee reconciliation.

---

## FR-085 — Enter Credit Sale

**Module ID:** PAY-010  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to record fuel sales made on credit.

### Credit Sale Information

- Customer Name
- Customer or Account Reference
- Vehicle Number, where applicable
- Credit Amount
- Remarks

### Acceptance Criteria

- Customer Name or approved customer reference is mandatory.
- Credit Amount must be greater than zero.
- Multiple credit sales may be recorded.
- Credit entries shall belong to the correct employee and shift.
- Credit sales shall be included in the accounted amount.

---

## FR-086 — Calculate Employee Credit Total

**Module ID:** PAY-011  
**Priority:** Critical

### Business Requirement

The system shall calculate the total credit sales recorded for each employee.

### Calculation

```text
Credit Total =
    Sum of all Credit Sale Amounts
```

### Acceptance Criteria

- The total updates whenever credit entries change.
- Individual credit details remain available for review.
- The total is included in employee reconciliation.

---

## FR-087 — Display Employee Collection Summary

**Module ID:** PAY-012  
**Priority:** Critical

### Business Requirement

The system shall display a consolidated collection summary for each employee.

### Summary Information

- Cash Total
- UPI Total
- Card Total
- Credit Total
- Gross Collection Total

### Calculation

```text
Gross Collection Total =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Total
```

### Acceptance Criteria

- All source entries remain accessible.
- Totals update when source values change.
- The summary clearly identifies incomplete collection categories.

---

## FR-088 — Save Collection Entry as Draft

**Module ID:** PAY-013  
**Priority:** High  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to save incomplete collection entries and continue later.

### Acceptance Criteria

- Draft entries remain available after logout.
- Draft entries are not treated as submitted.
- The user can resume from the saved values.
- Required validation is enforced before final submission.

---

## FR-089 — Validate Collection Completeness

**Module ID:** PAY-014  
**Priority:** Critical

### Business Requirement

The system shall validate that all required collection information has been completed before reconciliation submission.

### Acceptance Criteria

- Missing mandatory entries are clearly identified.
- Invalid values prevent submission.
- Zero collection values may be accepted only where permitted.
- The validation result shall be available per employee.

---

# 9.14 Adjustment Management Module

## FR-090 — Enter Expense

**Module ID:** ADJ-001  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to enter an expense incurred during the shift.

### Expense Information

- Expense Type
- Amount
- Description
- Reference Number, where applicable
- Supporting Remarks
- Date and Time

### Acceptance Criteria

- Amount must be greater than zero.
- Description is mandatory.
- Expenses requiring approval shall be marked accordingly.
- The expense shall be associated with the relevant employee and shift.

---

## FR-091 — Enter Positive Adjustment

**Module ID:** ADJ-002  
**Priority:** High  
**Primary Actors:** Employee, Reviewer, Manager

### Business Requirement

The system shall allow an authorized user to record an approved amount that must be added to the accounted amount.

### Acceptance Criteria

- Adjustment Type is mandatory.
- Amount must be greater than zero.
- Description and business reason are mandatory.
- Approval shall be required where configured.

---

## FR-092 — Enter Deductible Adjustment

**Module ID:** ADJ-003  
**Priority:** High  
**Primary Actors:** Employee, Reviewer, Manager

### Business Requirement

The system shall allow an authorized user to record an amount that must be deducted from the accounted amount.

### Possible Types

- Expense
- Fuel Testing
- Calibration
- Other Approved Deduction

### Acceptance Criteria

- Amount is stored as a positive value.
- Adjustment direction determines the financial effect.
- Reason and description are mandatory.
- The adjustment remains traceable in audit history.

---

## FR-093 — Record Cash Deposit Adjustment

**Module ID:** ADJ-004  
**Priority:** High

### Business Requirement

The system shall allow an authorized user to record cash deposited or transferred during the shift.

### Acceptance Criteria

- Deposit Amount must be greater than zero.
- Deposit Reference is mandatory where available.
- The business effect of the deposit shall follow the configured adjustment rule.
- Deposit details shall be available during review.

---

## FR-094 — Record Fuel Testing or Calibration

**Module ID:** ADJ-005  
**Priority:** High

### Business Requirement

The system shall allow authorized users to record fuel used for testing or calibration.

### Information

- Nozzle
- Fuel Type
- Quantity, where available
- Amount
- Description
- Approval Reference

### Acceptance Criteria

- The entry shall identify the relevant nozzle or fuel type where applicable.
- Quantity and amount shall use precise decimal values.
- Approval requirements shall be applied.
- The entry shall be included in reconciliation according to the approved business rule.

---

## FR-095 — Approve or Reject Adjustment

**Module ID:** ADJ-006  
**Priority:** Critical  
**Primary Actors:** Reviewer, Approver

### Business Requirement

The system shall allow an authorized reviewer or approver to approve or reject adjustments requiring authorization.

### Acceptance Criteria

- Approval or rejection remarks are mandatory where configured.
- The reviewing user and timestamp are recorded.
- Rejected adjustments are excluded from final reconciliation.
- Approved adjustments are included according to their direction.
- The approval history remains available.

---

## FR-096 — Calculate Adjustment Summary

**Module ID:** ADJ-007  
**Priority:** Critical

### Business Requirement

The system shall calculate adjustment totals for each employee and shift.

### Calculation

```text
Net Adjustment =
    Positive Adjustment Total
  - Deductible Adjustment Total
```

### Acceptance Criteria

- Only valid and approved adjustments are included in final reconciliation.
- Pending adjustments are clearly identified.
- Individual adjustment records remain accessible.

---

# 9.15 Reconciliation Module

## FR-097 — Calculate Employee Expected Sales Amount

**Module ID:** REC-001  
**Priority:** Critical

### Business Requirement

The system shall calculate the expected fuel-sales amount for each employee.

### Calculation

```text
Employee Expected Sales Amount =
    Sum of Sales Amounts from Assigned Nozzles
```

### Acceptance Criteria

- Shift nozzle-assignment snapshots are used.
- Every assigned nozzle is included exactly once.
- The total matches the employee fuel-sales summary.

---

## FR-098 — Calculate Employee Accounted Amount

**Module ID:** REC-002  
**Priority:** Critical

### Business Requirement

The system shall calculate the amount accounted for by each employee.

### Calculation

```text
Employee Accounted Amount =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Total
  + Positive Adjustment Total
  - Deductible Adjustment Total
```

### Acceptance Criteria

- Only approved adjustments are included in the final value.
- Source totals remain visible.
- The calculation uses precise decimal arithmetic.

---

## FR-099 — Calculate Employee Reconciliation Difference

**Module ID:** REC-003  
**Priority:** Critical

### Business Requirement

The system shall calculate the reconciliation difference for each employee.

### Calculation

```text
Difference =
    Employee Accounted Amount
  - Employee Expected Sales Amount
```

### Acceptance Criteria

- A negative result represents a shortage.
- A positive result represents an excess.
- A zero or tolerated result represents a match.
- The result is retained with the calculation date and version.

---

## FR-100 — Apply Reconciliation Tolerance

**Module ID:** REC-004  
**Priority:** Critical

### Business Requirement

The system shall apply a configurable reconciliation tolerance when determining reconciliation status.

### Rules

```text
Absolute Difference <= Allowed Tolerance
    → MATCHED
```

```text
Difference < -Allowed Tolerance
    → SHORTAGE
```

```text
Difference > Allowed Tolerance
    → EXCESS
```

### Acceptance Criteria

- The tolerance value is configurable.
- The effective tolerance used is stored with the reconciliation.
- The client-approved tolerance value may be configured later without changing application code.
- Only authorized users may modify tolerance configuration.

---

## FR-101 — Determine Employee Reconciliation Status

**Module ID:** REC-005  
**Priority:** Critical

### Business Requirement

The system shall determine the reconciliation status for each employee.

### Supported Statuses

- Matched
- Shortage
- Excess
- Pending Review

### Acceptance Criteria

- Status is derived from calculated values.
- Users cannot manually overwrite the calculated status.
- Missing or unapproved information produces Pending Review.
- Status changes after recalculation are audited.

---

## FR-102 — Calculate Shift Expected Sales Amount

**Module ID:** REC-006  
**Priority:** Critical

### Business Requirement

The system shall calculate the expected sales amount for the complete shift.

### Calculation

```text
Shift Expected Sales Amount =
    Sum of Employee Expected Sales Amounts
```

### Acceptance Criteria

- All participating employees are included.
- Shift total equals the sum of employee totals.
- Missing employee calculations prevent finalization.

---

## FR-103 — Calculate Shift Accounted Amount

**Module ID:** REC-007  
**Priority:** Critical

### Business Requirement

The system shall calculate the accounted amount for the complete shift.

### Calculation

```text
Shift Accounted Amount =
    Sum of Employee Accounted Amounts
```

### Acceptance Criteria

- The total equals the sum of employee reconciliation values.
- All collection and adjustment categories are represented.
- Incomplete employee reconciliation prevents finalization.

---

## FR-104 — Calculate Shift Reconciliation Difference

**Module ID:** REC-008  
**Priority:** Critical

### Business Requirement

The system shall calculate the reconciliation difference for the complete shift.

### Calculation

```text
Shift Difference =
    Shift Accounted Amount
  - Shift Expected Sales Amount
```

### Acceptance Criteria

- The same configured tolerance rules are applied.
- Employee-level and shift-level results remain visible.
- The result is retained for approval and reporting.

---

## FR-105 — Display Employee Reconciliation Summary

**Module ID:** REC-009  
**Priority:** Critical

### Business Requirement

The system shall display a complete employee reconciliation summary.

### Displayed Information

- Employee
- Assigned Nozzles
- Quantity Sold by Fuel Type
- Expected Sales Amount
- Cash Total
- UPI Total
- Card Total
- Credit Total
- Positive Adjustments
- Deductible Adjustments
- Accounted Amount
- Difference
- Tolerance
- Reconciliation Status

### Acceptance Criteria

- All values can be traced to their source entries.
- Shortage and excess results are clearly highlighted.
- The summary is available before submission.

---

## FR-106 — Display Shift Reconciliation Summary

**Module ID:** REC-010  
**Priority:** Critical

### Business Requirement

The system shall display the complete shift-level reconciliation.

### Displayed Information

- Station
- DU Serial Number
- Business Date
- Shift Number
- Employees
- Fuel Quantity by Fuel Type
- Expected Sales Amount
- Collection Totals
- Adjustment Totals
- Accounted Amount
- Difference
- Tolerance
- Overall Status

### Acceptance Criteria

- Employee totals reconcile to shift totals.
- Inconsistent values are clearly identified.
- The summary is available to employees, reviewers and approvers according to role.

---

## FR-107 — Recalculate Reconciliation

**Module ID:** REC-011  
**Priority:** Critical

### Business Requirement

The system shall recalculate reconciliation whenever an authorized change affects fuel sales, collections or adjustments.

### Acceptance Criteria

- Previous approved values shall not be silently overwritten.
- Recalculation creates a new traceable result or version.
- Submission status is reset where required.
- The reason and initiating user are recorded.

---

## FR-108 — Submit Reconciliation for Review

**Module ID:** REC-012  
**Priority:** Critical  
**Primary Actor:** Employee

### Business Requirement

The system shall allow an employee to submit a completed reconciliation for Level-1 review.

### Preconditions

- Receipt readings are confirmed.
- Fuel-sales calculation is complete.
- Collection entries are complete.
- Required adjustments are resolved.
- Reconciliation has been calculated.

### Acceptance Criteria

- Incomplete reconciliation cannot be submitted.
- The employee can review the final summary before submission.
- Submission date, time and user are recorded.
- Submitted data becomes protected from ordinary editing.
- The workflow moves to Level-1 Review.

---

# 9.16 Approval Workflow Module

## Overview

The Fuel Station Shift Reconciliation System shall support a configurable two-level approval workflow.

The workflow ensures that every completed reconciliation is independently reviewed before the shift is permanently closed.

The approval workflow shall support:

- Level-1 Review
- Return to Employee
- Employee Resubmission
- Level-2 Approval
- Final Approval
- Final Rejection

---

## FR-109 — Assign Level-1 Reviewer

**Module ID:** APR-001

**Priority:** Critical

### Business Requirement

The system shall determine the Level-1 Reviewer responsible for reviewing the submitted reconciliation.

### Acceptance Criteria

- Reviewer assignment shall be configurable.
- Reviewer shall belong to the same organization.
- Reviewer assignment shall be recorded.
- Changes shall be audited.

---

## FR-110 — Review Submitted Reconciliation

**Module ID:** APR-002

**Priority:** Critical

### Primary Actor

Reviewer

### Business Requirement

The reviewer shall review:

- OCR readings
- Fuel calculations
- Collections
- Adjustments
- Reconciliation Difference

before taking an approval decision.

### Acceptance Criteria

Reviewer shall have read-only access until an action is selected.

---

## FR-111 — Approve Matching Reconciliation

**Module ID:** APR-003

**Priority:** Critical

### Business Requirement

If reconciliation status is MATCHED, the reviewer may approve the reconciliation.

### Acceptance Criteria

- Reviewer remarks optional.
- Status changes to

```text
LEVEL_1_APPROVED
```

- Workflow proceeds to Level-2 Approval.

---

## FR-112 — Return Shortage Reconciliation

**Module ID:** APR-004

**Priority:** Critical

### Business Requirement

If shortage is detected, the reviewer may return the reconciliation to the employee.

### Mandatory Information

- Return Reason
- Reviewer Remarks

### Acceptance Criteria

Status becomes

```text
RETURNED_TO_EMPLOYEE
```

Employee receives notification within the application.

---

## FR-113 — Return Excess Reconciliation

**Module ID:** APR-005

**Priority:** Critical

### Business Requirement

If excess is detected, the reviewer may return the reconciliation to the employee.

### Acceptance Criteria

Return reason is mandatory.

Reviewer remarks are mandatory.

Status changes to

```text
RETURNED_TO_EMPLOYEE
```

---

## FR-114 — Employee Resubmission

**Module ID:** APR-006

**Priority:** Critical

### Primary Actor

Employee

### Business Requirement

The employee shall review reviewer remarks, make corrections and resubmit the reconciliation.

### Acceptance Criteria

System records:

- Resubmission Number
- User
- Date
- Time

Status becomes

```text
RESUBMITTED
```

---

## FR-115 — Approve with Remarks

**Module ID:** APR-007

**Priority:** Critical

### Business Requirement

If a shortage or excess still exists after resubmission, the reviewer may approve with mandatory remarks.

### Mandatory Fields

- Remarks
- Justification

### Acceptance Criteria

Status becomes

```text
LEVEL_1_APPROVED_WITH_REMARKS
```

Workflow proceeds to Level-2 Approval.

---

## FR-116 — Assign Level-2 Approver

**Module ID:** APR-008

**Priority:** Critical

### Business Requirement

The system shall assign the reconciliation to a Level-2 Approver.

### Acceptance Criteria

Assignment shall be configurable.

Assignment shall be audited.

---

## FR-117 — Review Level-2 Approval

**Module ID:** APR-009

**Priority:** Critical

### Primary Actor

Approver

### Business Requirement

The Level-2 Approver shall review:

- Reconciliation
- Reviewer Remarks
- Employee Corrections
- Audit History

before taking a decision.

---

## FR-118 — Final Approval

**Module ID:** APR-010

**Priority:** Critical

### Business Requirement

The Level-2 Approver may approve the reconciliation.

### Acceptance Criteria

Status becomes

```text
APPROVED
```

Shift becomes eligible for closure.

Approval details recorded.

---

## FR-119 — Final Rejection

**Module ID:** APR-011

**Priority:** Critical

### Business Requirement

The Level-2 Approver may reject the reconciliation.

### Mandatory Fields

- Rejection Reason
- Remarks

### Acceptance Criteria

Status becomes

```text
RETURNED_TO_EMPLOYEE
```

Employee shall correct and resubmit.

---

## FR-120 — Maintain Approval History

**Module ID:** APR-012

**Priority:** Critical

### Business Requirement

The system shall maintain complete approval history.

### Approval History

- Reviewer
- Approver
- Action
- Remarks
- Date
- Time
- Previous Status
- New Status

### Acceptance Criteria

Approval history shall never be deleted.

Approval history shall be available in reports.

---

# 10 Business Rules

## BR-001

Start and End Reading Receipts shall belong to the same DU Serial Number.

---

## BR-002

End VTOT shall not be less than Start VTOT.

---

## BR-003

End ATOT shall not be less than Start ATOT.

---

## BR-004

Fuel Quantity Sold shall be calculated using

```text
End VTOT − Start VTOT
```

---

## BR-005

Expected Sales Amount shall use the effective fuel price applicable during the shift.

---

## BR-006

Only confirmed OCR readings shall participate in calculations.

---

## BR-007

Each nozzle shall belong to only one employee during a shift.

---

## BR-008

Historical shift assignments shall never change after shift closure.

---

## BR-009

Every OCR correction shall be audited.

---

## BR-010

Every approval shall be audited.

---

## BR-011

Employee reconciliation shall be completed before shift reconciliation.

---

## BR-012

Configured reconciliation tolerance shall determine MATCHED, SHORTAGE or EXCESS.

---

## BR-013

Data retention period shall be fourteen (14) months.

---

## BR-014

Approved shifts shall become read-only.

---

## BR-015

Deleted business transactions are not permitted.

Business records shall be retained for audit purposes.

---

# 11. Non-Functional Requirements

## 11.1 Introduction

This section defines the quality, security, usability, performance, availability and operational requirements of the Fuel Station Shift Reconciliation System.

These requirements apply across all functional modules unless explicitly stated otherwise.

---

# 11.2 Usability and Responsive Access

## NFR-001 — Responsive Web Application

**Priority:** Critical

The application shall provide a responsive user interface suitable for:

- Desktop computers
- Laptop computers
- Tablets
- Mobile phones

### Acceptance Criteria

- Primary workflows shall be usable without mandatory horizontal scrolling.
- Controls shall resize appropriately for different screen sizes.
- Mobile users shall be able to complete receipt upload and reconciliation workflows.
- Important information shall remain readable on supported devices.

---

## NFR-002 — Mobile Receipt Capture

**Priority:** Critical

The application shall support receipt-image selection and camera-based capture on compatible mobile devices.

### Acceptance Criteria

- Users can capture a new image using the device camera.
- Users can select an existing image.
- Users can preview the selected image.
- Users can replace the image before submission.
- Unsupported devices shall still provide a standard file-upload option.

---

## NFR-003 — User-Friendly Navigation

**Priority:** High

The application shall provide clear and consistent navigation appropriate to the user’s assigned role.

### Acceptance Criteria

- Users can identify their current module and workflow stage.
- Frequently used actions are easily accessible.
- Navigation options unavailable to the user’s role are hidden or disabled.
- Users receive confirmation before performing critical actions.

---

## NFR-004 — Clear Validation Messages

**Priority:** High

The application shall display clear, business-friendly messages when information is missing, incorrect or requires review.

### Acceptance Criteria

- Messages identify the affected field or activity.
- Technical exception details are not shown to ordinary users.
- Validation messages explain how the user can correct the issue.
- Errors shall not remove previously entered valid information.

---

## NFR-005 — Accessibility

**Priority:** Medium

The application should support reasonable accessibility practices.

### Acceptance Criteria

- Form controls have meaningful labels.
- Status shall not be communicated using colour alone.
- Keyboard navigation shall be supported for major desktop workflows.
- Text and controls shall maintain readable contrast.

---

# 11.3 Browser and Device Compatibility

## NFR-006 — Supported Browsers

**Priority:** High

The application shall support current client-approved versions of:

- Google Chrome
- Microsoft Edge
- Mobile Chrome
- Other browsers confirmed during deployment planning

### Acceptance Criteria

- Core workflows behave consistently on supported browsers.
- Unsupported browsers receive an appropriate message where necessary.
- Browser compatibility shall be verified before production release.

---

## NFR-007 — Device Compatibility

**Priority:** High

The application shall support commonly used desktop and Android mobile devices approved by the client.

### Acceptance Criteria

- Receipt upload works on approved devices.
- Denomination and collection-entry screens are usable on mobile devices.
- Reconciliation summaries remain readable across supported screen sizes.

---

# 11.4 Performance Requirements

## NFR-008 — Standard Page Response Time

**Priority:** High

Under normal operating conditions, ordinary application pages should load within three seconds, excluding network delays beyond the system’s control.

### Acceptance Criteria

- Dashboard and data-entry pages meet the agreed response target under expected load.
- Performance shall be measured in the approved deployment environment.

---

## NFR-009 — Save Operation Response Time

**Priority:** High

Ordinary save and update operations should complete within three seconds under normal operating conditions.

### Acceptance Criteria

- The user receives visible confirmation after a successful save.
- Repeated clicks shall not create duplicate transactions.
- Long-running operations shall display progress or processing status.

---

## NFR-010 — OCR Processing Time

**Priority:** High

Receipt processing should complete within an acceptable operational period based on image size, image quality and server capacity.

### Initial Target

A standard receipt should normally be processed within thirty seconds.

### Acceptance Criteria

- The user can see the processing status.
- The browser remains usable while processing occurs.
- Failed or delayed processing can be retried.
- The final target shall be validated during performance testing.

---

## NFR-011 — Concurrent Users

**Priority:** High

The application shall support multiple users working concurrently without corrupting or overwriting business data.

### Acceptance Criteria

- One user’s actions do not incorrectly affect another user’s session.
- Concurrent updates are detected and handled.
- Expected user and station volumes shall be confirmed before performance testing.

---

## NFR-012 — Duplicate Submission Prevention

**Priority:** Critical

The application shall prevent accidental duplicate submission caused by repeated clicks, browser refresh or delayed network responses.

### Acceptance Criteria

- Duplicate shifts, receipts, payments and approvals are prevented.
- Users receive the result of the original successful action where appropriate.

---

# 11.5 Availability and Reliability

## NFR-013 — Business Availability

**Priority:** High

The application shall be available during the client’s agreed operating hours, excluding approved maintenance periods.

### Acceptance Criteria

- Planned maintenance is communicated in advance.
- Availability targets shall be finalized after the hosting model is approved.
- Unexpected failures shall be recorded and investigated.

---

## NFR-014 — Transaction Integrity

**Priority:** Critical

Critical business operations shall either complete fully or leave the system in a valid recoverable state.

### Critical Operations

- Shift creation
- Receipt confirmation
- Fuel-sales calculation
- Collection submission
- Reconciliation calculation
- Approval
- Shift closure

### Acceptance Criteria

- Partial database updates shall not remain after a failed transaction.
- Users receive an appropriate failure message.
- Retrying an operation shall not create duplicate records.

---

## NFR-015 — Data Consistency

**Priority:** Critical

Employee totals, shift totals and approval information shall remain internally consistent.

### Acceptance Criteria

- Shift totals equal the sum of employee totals.
- Reconciliation values can be reproduced from source entries.
- Inconsistent data prevents final approval.
- System-calculated values cannot be manually overwritten.

---

## NFR-016 — Concurrent Update Protection

**Priority:** Critical

The application shall detect when another user has modified a record being edited.

### Acceptance Criteria

- The later user is notified of the conflict.
- Existing changes are not silently overwritten.
- The user can reload the latest information before continuing.

---

## NFR-017 — Error Recovery

**Priority:** High

The system shall support safe recovery from recoverable technical errors.

### Acceptance Criteria

- Uploaded receipts remain available after OCR failure.
- Draft collection entries remain available after logout or connection interruption where successfully saved.
- Failed processing can be retried by an authorized user.

---

# 11.6 Data Accuracy and Precision

## NFR-018 — Monetary Precision

**Priority:** Critical

All monetary calculations shall use precise decimal arithmetic.

### Initial Precision

- Monetary amounts: two decimal places
- Fuel prices: up to three decimal places

### Acceptance Criteria

- Binary floating-point calculations shall not be used for business amounts.
- Rounding rules are applied consistently.
- Final rounding rules shall be confirmed with the client.

---

## NFR-019 — Fuel-Volume Precision

**Priority:** Critical

Fuel-volume readings and calculated quantities shall use precise decimal arithmetic.

### Initial Precision

Fuel volume shall support at least three decimal places.

### Acceptance Criteria

- Start and End VTOT values retain the required precision.
- Quantity calculations do not lose significant decimal values.
- The client-approved rounding rule shall be configurable where applicable.

---

## NFR-020 — Reconciliation Tolerance Configuration

**Priority:** Critical

The application shall support a configurable reconciliation tolerance.

### Acceptance Criteria

- The tolerance value can be changed by an authorized administrator.
- Application code changes are not required to update the tolerance.
- The effective tolerance used for each reconciliation is retained.
- The initial production tolerance remains pending client confirmation.

---

# 11.7 OCR Quality Requirements

## NFR-021 — OCR Accuracy

**Priority:** Critical

The application shall aim to extract required receipt fields with sufficient accuracy for operational use.

### Acceptance Criteria

- DU Serial Number, Nozzle Number, ATOT and VTOT are individually validated.
- Low-confidence fields require manual review.
- OCR performance is evaluated using representative client receipt samples.
- Final acceptance targets shall be defined after sample-image testing.

---

## NFR-022 — OCR Confidence Threshold

**Priority:** High

The confidence threshold used to request manual review shall be configurable.

### Acceptance Criteria

- Authorized users can update the threshold.
- The effective threshold is consistently applied.
- Mandatory validation rules override confidence values where necessary.

---

## NFR-023 — Preserve Original OCR Information

**Priority:** Critical

Original OCR results shall be retained even when users correct extracted values.

### Acceptance Criteria

- Original extracted text remains available.
- Corrected values are separately recorded.
- Correction history identifies the user, reason and timestamp.

---

# 11.8 Maintainability and Supportability

## NFR-024 — Configurable Business Settings

**Priority:** High

Frequently changing business settings shall be configurable without source-code changes.

### Configurable Settings May Include

- Reconciliation tolerance
- OCR confidence threshold
- Upload size limit
- Supported image formats
- Session timeout
- Cash denominations
- Retention period
- Station-level settings

---

## NFR-025 — Application Logging

**Priority:** High

The application shall maintain logs needed for operational support and technical troubleshooting.

### Acceptance Criteria

- Errors include sufficient diagnostic context.
- Sensitive credentials and passwords are never written to logs.
- Log access is restricted.
- Log retention is configurable.

---

## NFR-026 — Modular Design

**Priority:** High

The application shall be designed so that receipt processing, reconciliation, payment collection and reporting can be maintained independently.

### Acceptance Criteria

- Business rules are not permanently tied to the user interface.
- OCR technology can be enhanced or replaced without redesigning the complete application.
- New stations and nozzle configurations do not require code changes.

---

## NFR-027 — Database Schema Version Control

**Priority:** High

Database structural changes shall be version-controlled and consistently applied across environments.

### Acceptance Criteria

- Every database change has an identifiable version.
- Previously deployed database changes are not silently modified.
- Database upgrades can be verified before production deployment.

---

# 12. Security Requirements

## SEC-001 — Authentication Required

**Priority:** Critical

All business functions shall require authenticated access, except explicitly approved public technical endpoints.

---

## SEC-002 — Secure Password Storage

**Priority:** Critical

Passwords shall never be stored or transmitted as plain text.

### Acceptance Criteria

- Passwords are stored using an approved secure password-hashing method.
- Users and administrators cannot retrieve existing passwords.
- Password reset creates a new credential rather than revealing the old password.

---

## SEC-003 — Role-Based Authorization

**Priority:** Critical

The system shall authorize functions based on assigned user roles.

### Initial Roles

- Employee
- Reviewer
- Approver
- Administrator
- Auditor

### Acceptance Criteria

- Employees cannot perform approval functions.
- Reviewers cannot perform Level-2 approval unless separately authorized.
- Auditors receive read-only access to approved data.
- Administrators cannot bypass business approval rules unless explicitly authorized and audited.

---

## SEC-004 — Station-Level Access Restriction

**Priority:** Critical

Users shall only access stations assigned to them unless organization-wide access is granted.

### Acceptance Criteria

- Direct web-address access shall not bypass station restrictions.
- Search results and reports only display permitted station data.
- Unauthorized access attempts are rejected and logged.

---

## SEC-005 — Session Security

**Priority:** High

User sessions shall be securely created, maintained and terminated.

### Acceptance Criteria

- Sessions expire after the configured inactivity period.
- Logout invalidates the active session.
- Authentication information is protected during transmission.
- Session identifiers are not exposed in insecure locations.

---

## SEC-006 — Account Locking

**Priority:** High

The system shall lock or temporarily restrict an account after a configurable number of unsuccessful login attempts.

### Acceptance Criteria

- Failed attempts are recorded.
- The lock threshold is configurable.
- Authorized administrators can unlock an account.
- Security events are audited.

---

## SEC-007 — Secure Communication

**Priority:** Critical

Production access shall use encrypted HTTPS communication.

### Acceptance Criteria

- User credentials and business data are encrypted during transmission.
- Unencrypted production access is redirected or blocked.
- Certificates are maintained according to the hosting policy.

---

## SEC-008 — Uploaded File Security

**Priority:** Critical

Uploaded receipt files shall be validated and stored securely.

### Acceptance Criteria

- Unsupported and potentially unsafe files are rejected.
- Original filenames are not directly used as physical storage paths.
- Users cannot access receipt files outside their permitted stations.
- Upload size limits are enforced.
- Path-traversal attempts are prevented.

---

## SEC-009 — Audit Trail Protection

**Priority:** Critical

Audit records shall be protected against ordinary user modification or deletion.

### Acceptance Criteria

- Audit events cannot be edited through standard business screens.
- Access to audit information is role-controlled.
- Significant actions identify the responsible user and timestamp.

---

## SEC-010 — Sensitive Data Protection

**Priority:** High

Sensitive configuration and credentials shall not be stored in source-code repositories.

### Acceptance Criteria

- Database passwords are externally configured.
- Production secrets are not committed to Git.
- Access to secrets follows the approved deployment policy.

---

## SEC-011 — Approval Segregation

**Priority:** Critical

The approval workflow shall enforce separation between employee submission, Level-1 review and Level-2 approval.

### Acceptance Criteria

- An employee cannot approve their own reconciliation.
- Level-1 and Level-2 actions are performed by appropriately authorized users.
- Any permitted exception is explicitly authorized and audited.

---

## SEC-012 — Security Event Recording

**Priority:** High

The system shall record important security events.

### Events Include

- Successful login
- Failed login
- Account lock
- Password change
- Unauthorized-access attempt
- Role change
- Account activation or deactivation

---

# 13. Data Retention and Archival Requirements

## RET-001 — Fourteen-Month Operational Retention

**Priority:** Critical

The system shall retain relevant operational data for at least fourteen months from the applicable business date or transaction date.

### Data Includes

- Shifts
- Receipt images
- OCR results
- Receipt readings
- Manual corrections
- Fuel-sales calculations
- Cash denomination entries
- UPI terminal entries
- Card collections
- Credit sales
- Adjustments
- Reconciliations
- Approval history
- Generated report metadata
- Audit events

---

## RET-002 — Retention Calculation

**Priority:** High

Retention eligibility shall be calculated using a clearly defined business date or event timestamp.

### Acceptance Criteria

- The retention calculation is consistent.
- Records are not removed before completing fourteen months.
- Records involved in an active investigation or hold shall not be removed.

---

## RET-003 — Archival Before Deletion

**Priority:** High

Where required by client policy, eligible records shall be archived before permanent deletion.

### Acceptance Criteria

- Archive output is complete and verifiable.
- Receipt images and related database information remain associated.
- Archived records can be retrieved through an authorized process.
- The final archive-versus-delete policy requires client approval.

---

## RET-004 — Controlled Data Disposal

**Priority:** Critical

Expired business data shall not be deleted through ordinary user screens.

### Acceptance Criteria

- Disposal is performed only by an authorized scheduled or administrative process.
- Deletion or archival activity is audited.
- Related records and receipt files are handled consistently.
- Failed disposal does not leave partially removed business records.

---

## RET-005 — Retention Configuration

**Priority:** High

The retention period shall be configurable by an authorized administrator, subject to client policy.

### Acceptance Criteria

- The initial value is fourteen months.
- Reducing the period shall require explicit authorization.
- Changing the setting shall not immediately delete data without a controlled process.
- Configuration changes are audited.

---

# 14. Backup and Recovery Requirements

## BCK-001 — Database Backup

**Priority:** Critical

The production database shall be backed up according to an approved schedule.

### Acceptance Criteria

- Backup frequency and retention are documented.
- Backup failures generate an operational alert or support notification.
- Restore procedures are tested periodically.

---

## BCK-002 — Receipt File Backup

**Priority:** Critical

Uploaded receipt files shall be included in the production backup strategy.

### Acceptance Criteria

- Receipt files and database records can be restored consistently.
- A database backup alone shall not be considered a complete system backup.
- Backup access is restricted.

---

## BCK-003 — Recovery Procedure

**Priority:** Critical

A documented recovery process shall exist for database, receipt-file and application failures.

### Acceptance Criteria

- Recovery responsibilities are identified.
- Recovery steps are tested before production approval.
- Recovery-time and recovery-point expectations shall be confirmed with the client.

---

# 15. Hosting and Deployment Requirements

## HST-001 — Centralized Web Deployment

**Priority:** High

The system is intended to operate as a centralized web application accessible through approved networks and browsers.

### Business Benefit

- Centralized updates
- Shared reporting
- Multi-station expansion
- No desktop installation for normal users

---

## HST-002 — Hosting Model Confirmation

**Priority:** Critical

The final hosting model shall be confirmed by the client before production deployment.

### Possible Models

- Client office server
- Client data-centre server
- Central head-office server
- Cloud-hosted server
- Approved managed hosting environment

### Current Status

Pending client confirmation.

---

## HST-003 — Production Environment Components

**Priority:** High

The production environment shall provide the components required for:

- Web application access
- Backend business processing
- Database operation
- Receipt-file storage
- HTTPS security
- Backup and recovery
- Monitoring and logs

The final infrastructure sizing will depend on expected stations, users, receipts and concurrent activity.

---

## HST-004 — Environment Separation

**Priority:** High

Separate environments should be maintained for:

- Development
- Testing or UAT
- Production

### Acceptance Criteria

- Test data does not accidentally enter production.
- Production credentials are not used in development.
- Deployment changes are validated before production release.

---

## HST-005 — Production Monitoring

**Priority:** High

The production deployment shall provide operational monitoring appropriate to the selected hosting model.

### Monitoring Should Include

- Application availability
- Application errors
- Database connectivity
- Storage availability
- Backup status
- OCR processing failures
- Resource usage where available

---

## HST-006 — Capacity Planning

**Priority:** High

Server and storage capacity shall be planned using expected business volumes.

### Client Inputs Required

- Number of stations
- Number of dispenser units
- Number of employees
- Number of shifts per day
- Average receipt-image size
- Expected concurrent users
- Expected future growth

---

# 16. Compliance and Audit Requirements

## CMP-001 — Complete Business Audit Trail

**Priority:** Critical

The system shall retain a traceable history of important business actions.

### Audited Activities Include

- Master-data changes
- Shift opening and cancellation
- Receipt upload
- OCR completion and failure
- Manual correction
- Collection entry
- Adjustment entry
- Reconciliation calculation
- Submission
- Reviewer action
- Approver action
- Shift closure

---

## CMP-002 — Audit Information

Each audit record should contain:

- User
- Action
- Date and Time
- Affected Record
- Previous Value, where applicable
- New Value, where applicable
- Remarks or Reason, where applicable
- Source information such as IP address, where available

---

## CMP-003 — Historical Reproducibility

**Priority:** Critical

The system shall retain sufficient information to reproduce and explain a completed reconciliation.

### Acceptance Criteria

An authorized reviewer can identify:

- Receipt readings used
- Fuel prices used
- Nozzle assignments used
- Collections entered
- Adjustments included
- Tolerance applied
- Approval actions completed

---

## CMP-004 — Read-Only Approved Records

**Priority:** Critical

Approved and closed shifts shall be read-only during normal operation.

### Acceptance Criteria

- Ordinary users cannot modify approved results.
- Authorized corrections follow a controlled process.
- The original approved information remains traceable.

---

# 17. Business Process Workflows

## 17.1 Shift Reconciliation Workflow

The complete shift-reconciliation process shall follow this sequence:

```text
Employee Login
      |
      v
Open Shift
      |
      v
Upload Start Reading Receipt
      |
      v
Receipt Processing and Review
      |
      v
Fuel Dispensing Operations
      |
      v
Upload End Reading Receipt
      |
      v
Receipt Processing and Review
      |
      v
Confirm Start and End Readings
      |
      v
Calculate Nozzle-Wise Fuel Sales
      |
      v
Allocate Sales to Employees
      |
      v
Enter Cash Denominations
      |
      v
Enter UPI Terminal Collections
      |
      v
Enter Card Collections
      |
      v
Enter Credit Sales
      |
      v
Enter Expenses and Adjustments
      |
      v
Calculate Employee Reconciliation
      |
      v
Calculate Shift Reconciliation
      |
      v
Submit for Level-1 Review
      |
      v
Level-1 Review
      |
      v
Level-2 Approval
      |
      v
Close Shift
```

---

## 17.2 Start Receipt Workflow

```text
Employee Selects Open Shift
      |
      v
Selects Start Receipt Upload
      |
      v
Captures Photo or Selects Image
      |
      v
Previews Image
      |
      v
Replaces Image if Required
      |
      v
Submits Image
      |
      v
File Validation
      |
      +---- Invalid ----> Display Reason and Request Replacement
      |
      v
Receipt Processing
      |
      +---- Failed -----> Retry or Manual Review
      |
      v
Display Extracted Values
      |
      v
Employee or Reviewer Confirms Values
      |
      v
Start Receipt Confirmed
```

---

## 17.3 End Receipt Workflow

The End Receipt workflow shall follow the same upload and review process as the Start Receipt.

Additional validation shall ensure:

- Start Receipt already exists.
- End Receipt belongs to the same shift.
- DU Serial Number matches the Start Receipt.
- End Receipt time follows the Start Receipt time, subject to approved exceptions.
- Required nozzle readings are present.
- End ATOT is not lower than Start ATOT.
- End VTOT is not lower than Start VTOT.

---

## 17.4 Receipt Review Workflow

```text
Display Receipt Image
      |
      v
Display Extracted Fields
      |
      v
Check Missing or Low-Confidence Values
      |
      +---- No Issues ----> Confirm Readings
      |
      v
User Reviews Highlighted Field
      |
      v
Enter Corrected Value
      |
      v
Enter Correction Reason
      |
      v
Save Correction and Audit History
      |
      v
Confirm Readings
```

---

## 17.5 Collection Entry Workflow

```text
Select Employee
      |
      v
Enter Cash Denomination Counts
      |
      v
System Calculates Cash Total
      |
      v
Enter UPI TID and Total Amount
      |
      v
Enter Card Collection Details
      |
      v
Enter Credit Sales
      |
      v
Enter Expenses and Adjustments
      |
      v
Review Collection Summary
      |
      v
Save Draft or Complete Entry
```

---

## 17.6 Reconciliation Workflow

```text
Confirmed Fuel Sales
      |
      v
Completed Collection Entry
      |
      v
Approved Adjustments
      |
      v
Calculate Expected Sales Amount
      |
      v
Calculate Accounted Amount
      |
      v
Calculate Difference
      |
      v
Apply Configured Tolerance
      |
      +---- Within Tolerance ----> MATCHED
      |
      +---- Negative Difference -> SHORTAGE
      |
      +---- Positive Difference -> EXCESS
      |
      v
Display Employee and Shift Summary
      |
      v
Employee Submits for Review
```

---

## 17.7 Level-1 Review Workflow

### Scenario A — Reconciliation Matched

```text
Employee Submits
      |
      v
Level-1 Reviewer Reviews
      |
      v
Reviewer Approves
      |
      v
Forward to Level-2 Approver
```

### Scenario B — Initial Shortage

```text
Employee Submits Shortage
      |
      v
Level-1 Reviewer Reviews
      |
      v
Reviewer Rejects with Remarks
      |
      v
Returned to Employee
      |
      v
Employee Corrects and Resubmits
```

### Scenario C — Shortage Still Exists After Resubmission

```text
Employee Resubmits
      |
      v
Level-1 Reviewer Reviews
      |
      v
Reviewer Approves with Mandatory Remarks
      |
      v
Forward to Level-2 Approver
```

### Scenario D — Initial Excess

```text
Employee Submits Excess
      |
      v
Level-1 Reviewer Reviews
      |
      v
Reviewer Rejects with Remarks
      |
      v
Returned to Employee
      |
      v
Employee Corrects and Resubmits
```

### Scenario E — Excess Still Exists After Resubmission

```text
Employee Resubmits
      |
      v
Level-1 Reviewer Reviews
      |
      v
Reviewer Approves with Mandatory Remarks
      |
      v
Forward to Level-2 Approver
```

---

## 17.8 Level-2 Approval Workflow

### Matched Reconciliation

```text
Level-2 Approver Reviews
      |
      v
Approve
      |
      v
Shift Eligible for Closure
```

### Shortage or Excess Reconciliation

```text
Level-2 Approver Reviews
      |
      +---- Approve with Mandatory Remarks
      |           |
      |           v
      |     Shift Eligible for Closure
      |
      +---- Reject with Mandatory Remarks
                  |
                  v
           Return to Employee
                  |
                  v
          Correction and Resubmission
```

---

## 17.9 Shift Closure Workflow

```text
Level-2 Approval Completed
      |
      v
System Validates Final Status
      |
      v
Shift Marked Approved
      |
      v
Shift Closed
      |
      v
Records Become Read-Only
      |
      v
Reports Available
```

---

# 18. Screen Specifications

## 18.1 Screen Catalogue

| Screen ID | Screen Name | Primary Users |
|---|---|---|
| SCR-001 | Login | All Users |
| SCR-002 | Employee Dashboard | Employee |
| SCR-003 | Reviewer Dashboard | Reviewer |
| SCR-004 | Approver Dashboard | Approver |
| SCR-005 | Administration Dashboard | Administrator |
| SCR-006 | Organization Management | Administrator |
| SCR-007 | Fuel Station Management | Administrator |
| SCR-008 | Dispenser Unit Management | Administrator |
| SCR-009 | Nozzle Management | Administrator |
| SCR-010 | Employee Management | Administrator |
| SCR-011 | Nozzle Assignment | Administrator |
| SCR-012 | Fuel Type Management | Administrator |
| SCR-013 | Fuel Price Management | Administrator, Manager |
| SCR-014 | Open Shift | Employee |
| SCR-015 | Shift Details | Employee, Reviewer, Approver |
| SCR-016 | Start Receipt Upload | Employee |
| SCR-017 | End Receipt Upload | Employee |
| SCR-018 | Receipt Review | Employee, Reviewer |
| SCR-019 | Fuel Sales Calculation | Employee, Reviewer |
| SCR-020 | Cash Denomination Entry | Employee |
| SCR-021 | UPI Terminal Entry | Employee |
| SCR-022 | Card Collection Entry | Employee |
| SCR-023 | Credit Sale Entry | Employee |
| SCR-024 | Expense and Adjustment Entry | Employee, Reviewer |
| SCR-025 | Employee Reconciliation | Employee, Reviewer |
| SCR-026 | Shift Reconciliation | Employee, Reviewer, Approver |
| SCR-027 | Level-1 Review | Reviewer |
| SCR-028 | Level-2 Approval | Approver |
| SCR-029 | Approval History | Reviewer, Approver, Auditor |
| SCR-030 | Reports | Manager, Auditor, Administrator |
| SCR-031 | Audit History | Auditor, Administrator |
| SCR-032 | Application Configuration | Administrator |
| SCR-033 | User and Role Management | Administrator |

---

## 18.2 SCR-001 — Login

### Purpose

Allow an authorized user to access the application.

### Main Fields

- Username
- Password

### Main Actions

- Login
- Reset Password, where enabled

### Business Validation

- Username and password are mandatory.
- Locked or inactive accounts cannot log in.
- Successful login redirects the user to the correct role-based dashboard.

---

## 18.3 SCR-002 — Employee Dashboard

### Purpose

Provide the employee with a summary of assigned and recent work.

### Information

- Open Shifts
- Pending Start Receipt
- Pending End Receipt
- Receipt Review Required
- Pending Collection Entry
- Pending Reconciliation
- Returned for Correction
- Submitted Reconciliations
- Approved Shifts

### Main Actions

- Open Shift
- Continue Shift
- View Reviewer Remarks
- View Reconciliation

---

## 18.4 SCR-003 — Reviewer Dashboard

### Purpose

Display reconciliations awaiting Level-1 review.

### Information

- Newly Submitted Reconciliations
- Resubmitted Reconciliations
- Matched Cases
- Shortage Cases
- Excess Cases
- Pending Adjustment Approvals
- Receipt Review Cases

### Main Actions

- Review
- Approve
- Approve with Remarks
- Return to Employee
- View History

---

## 18.5 SCR-004 — Approver Dashboard

### Purpose

Display reconciliations awaiting Level-2 approval.

### Information

- Matched Reconciliations
- Shortage Reconciliations
- Excess Reconciliations
- Level-1 Reviewer Remarks
- Resubmission History

### Main Actions

- Approve
- Approve with Remarks
- Reject and Return
- View Audit History

---

## 18.6 SCR-014 — Open Shift

### Purpose

Allow an employee to open a new operational shift.

### Main Fields

- Station
- Dispenser Unit
- DU Serial Number
- Business Date
- Shift Number
- Start Time
- Participating Employees
- Assigned Nozzles

### Business Validation

- Station and DU must be active.
- Required nozzle assignments must exist.
- Required fuel prices must exist.
- Duplicate shift numbers shall be prevented.

---

## 18.7 SCR-016 and SCR-017 — Receipt Upload

### Purpose

Allow the employee to upload Start or End Reading Receipts.

### Main Components

- Capture Photo
- Select Existing Image
- Receipt Preview
- Replace Image
- Upload Button
- Upload Status
- Validation Message

### Business Validation

- File type is supported.
- File size is within limit.
- Image is readable.
- Duplicate receipt is not accepted.
- Correct shift and receipt type are used.

---

## 18.8 SCR-018 — Receipt Review

### Purpose

Allow authorized users to review and confirm extracted receipt readings.

### Layout

The screen should display:

- Receipt image
- Extracted DU Serial Number
- Receipt Date and Time
- Nozzle Number
- ATOT
- VTOT
- ECAL
- Warning indicators
- Correction fields
- Correction reason
- Confirm button

### Main Actions

- Zoom Receipt
- Retry Processing
- Correct Value
- Save Correction
- Confirm Readings

---

## 18.9 SCR-019 — Fuel Sales Calculation

### Purpose

Display nozzle-wise and employee-wise sales calculations.

### Displayed Values

- Nozzle
- Employee
- Fuel Type
- Start ATOT
- End ATOT
- Amount Difference
- Start VTOT
- End VTOT
- Quantity Sold
- Fuel Price
- Calculated Sales Amount
- Variance

---

## 18.10 SCR-020 — Cash Denomination Entry

### Purpose

Allow an employee to enter physical cash held.

### Initial Denominations

- ₹500
- ₹200
- ₹100
- ₹50
- ₹20
- ₹10
- ₹5
- ₹2
- ₹1

### Columns

- Denomination
- Quantity
- Calculated Amount

### Summary

- Total Number of Notes and Coins
- Cash Total

---

## 18.11 SCR-021 — UPI Terminal Entry

### Purpose

Allow an employee to enter UPI collections by terminal.

### Main Fields

- UPI Provider or Machine Name
- Terminal ID (TID)
- Total Amount Received
- Remarks

### Main Actions

- Add Terminal
- Edit Entry
- Remove Draft Entry
- Save

### Summary

- Number of TIDs Entered
- Total UPI Amount

---

## 18.12 SCR-022 — Card Collection Entry

### Main Fields

- Terminal ID or Machine Reference
- Card Amount
- Settlement or Batch Reference
- Remarks

### Summary

- Total Card Amount

---

## 18.13 SCR-023 — Credit Sale Entry

### Main Fields

- Customer Name
- Customer or Account Reference
- Vehicle Number
- Credit Amount
- Remarks

### Summary

- Total Credit Amount

---

## 18.14 SCR-024 — Expense and Adjustment Entry

### Main Fields

- Adjustment Type
- Adjustment Direction
- Amount
- Description
- Reference Number
- Date and Time
- Approval Status
- Approval Remarks

### Main Actions

- Add
- Edit Draft
- Submit for Approval
- Approve
- Reject

---

## 18.15 SCR-025 — Employee Reconciliation

### Displayed Information

- Employee
- Assigned Nozzles
- Fuel Quantity by Fuel Type
- Expected Sales Amount
- Cash Total
- UPI Total
- Card Total
- Credit Total
- Positive Adjustments
- Deductible Adjustments
- Accounted Amount
- Difference
- Tolerance
- Status

### Main Actions

- Recalculate
- Save Draft
- Submit for Review

---

## 18.16 SCR-026 — Shift Reconciliation

### Displayed Information

- Station
- DU Serial Number
- Business Date
- Shift Number
- Employee Summaries
- Fuel Totals
- Expected Sales Total
- Collection Total
- Adjustment Total
- Accounted Amount
- Difference
- Tolerance
- Overall Status

---

## 18.17 SCR-027 — Level-1 Review

### Main Review Areas

- Receipt Images
- Confirmed Readings
- Manual Corrections
- Fuel Sales
- Collections
- Adjustments
- Employee Reconciliation
- Shift Reconciliation
- Previous Remarks

### Available Actions

- Approve
- Approve with Remarks
- Return to Employee

### Validation

- Remarks are mandatory for shortage or excess approval.
- Return reason is mandatory when returning to employee.

---

## 18.18 SCR-028 — Level-2 Approval

### Main Review Areas

- Reconciliation Summary
- Level-1 Decision
- Reviewer Remarks
- Employee Resubmission History
- Audit Events
- Shortage or Excess Explanation

### Available Actions

- Approve
- Approve with Remarks
- Reject and Return to Employee

---

## 18.19 SCR-029 — Approval History

### Displayed Information

- Level
- User
- Action
- Previous Status
- New Status
- Remarks
- Date and Time
- Resubmission Number

---

## 18.20 SCR-032 — Application Configuration

### Configurable Items

- Reconciliation Tolerance
- Receipt Upload Size
- Supported Image Formats
- OCR Confidence Threshold
- Session Timeout
- Data Retention Period
- Cash Denominations
- Other approved operational settings

---

# 19. Report Specifications

## 19.1 Report Catalogue

| Report ID | Report Name |
|---|---|
| RPT-001 | Employee Shift Reconciliation Report |
| RPT-002 | Shift Reconciliation Report |
| RPT-003 | Station Daily Sales Summary |
| RPT-004 | Fuel-Type Sales Summary |
| RPT-005 | Shortage and Excess Report |
| RPT-006 | Cash Denomination Summary |
| RPT-007 | UPI Terminal Collection Report |
| RPT-008 | Card Collection Report |
| RPT-009 | Credit Sales Report |
| RPT-010 | Expense and Adjustment Report |
| RPT-011 | Receipt Processing Report |
| RPT-012 | Manual Correction Report |
| RPT-013 | Approval History Report |
| RPT-014 | Audit Report |
| RPT-015 | Shift Status Report |

---

## 19.2 RPT-001 — Employee Shift Reconciliation Report

### Purpose

Provide a complete reconciliation summary for one employee and shift.

### Report Information

- Organization
- Station
- DU Serial Number
- Business Date
- Shift Number
- Employee
- Assigned Nozzles
- Fuel Quantity by Fuel Type
- Expected Sales Amount
- Cash Total
- UPI Total
- Card Total
- Credit Total
- Adjustment Totals
- Accounted Amount
- Difference
- Tolerance
- Status
- Reviewer and Approver Information

### Formats

- PDF
- Excel

---

## 19.3 RPT-002 — Shift Reconciliation Report

### Purpose

Provide consolidated reconciliation for the complete shift.

### Report Information

- Shift Information
- Employee Summaries
- Nozzle-Wise Sales
- Fuel-Type Totals
- Collection Totals
- Adjustment Totals
- Difference
- Approval History
- Final Status

---

## 19.4 RPT-003 — Station Daily Sales Summary

### Filters

- Organization
- Station
- Business Date
- Dispenser Unit

### Information

- Number of Shifts
- Fuel Quantity by Fuel Type
- Sales Amount by Fuel Type
- Total Collections
- Shortage Total
- Excess Total
- Approved and Pending Shifts

---

## 19.5 RPT-004 — Fuel-Type Sales Summary

### Information

- Station
- Date Range
- Fuel Type
- Quantity Sold
- Expected Sales Amount
- Receipt Amount Difference
- Variance

---

## 19.6 RPT-005 — Shortage and Excess Report

### Filters

- Station
- Employee
- Business Date Range
- Status
- Approval Status

### Information

- Shift
- Employee
- Expected Amount
- Accounted Amount
- Difference
- Reviewer Remarks
- Approver Remarks
- Final Decision

---

## 19.7 RPT-006 — Cash Denomination Summary

### Information

- Shift
- Employee
- Denomination
- Quantity
- Calculated Amount
- Cash Total

---

## 19.8 RPT-007 — UPI Terminal Collection Report

### Information

- Station
- Shift
- Employee
- UPI Provider
- Terminal ID
- Amount
- Entry Date and Time
- Total UPI Amount

---

## 19.9 RPT-008 — Card Collection Report

### Information

- Station
- Shift
- Employee
- Terminal Reference
- Batch or Settlement Reference
- Amount
- Total Card Amount

---

## 19.10 RPT-009 — Credit Sales Report

### Information

- Station
- Shift
- Employee
- Customer
- Account Reference
- Vehicle Number
- Amount
- Settlement Status, where applicable

---

## 19.11 RPT-010 — Expense and Adjustment Report

### Information

- Station
- Shift
- Employee
- Adjustment Type
- Direction
- Amount
- Description
- Approval Status
- Approved By
- Approval Date and Time

---

## 19.12 RPT-011 — Receipt Processing Report

### Information

- Shift
- Receipt Type
- Filename
- Upload Time
- Processing Status
- DU Serial Number
- Confidence
- Number of Processing Attempts
- Failure Reason, where applicable

---

## 19.13 RPT-012 — Manual Correction Report

### Information

- Receipt
- Nozzle
- Field
- Original Value
- Corrected Value
- Reason
- Corrected By
- Corrected Date and Time

---

## 19.14 RPT-013 — Approval History Report

### Information

- Reconciliation
- Approval Level
- User
- Action
- Remarks
- Previous Status
- New Status
- Date and Time

---

## 19.15 RPT-014 — Audit Report

### Filters

- Date Range
- User
- Station
- Action
- Entity Type

### Information

- User
- Action
- Record
- Previous Value
- New Value
- Date and Time
- Source Information, where available

---

## 19.16 RPT-015 — Shift Status Report

### Information

- Station
- DU Serial Number
- Business Date
- Shift Number
- Employee
- Current Status
- Pending Activity
- Last Updated Time
- Assigned Reviewer or Approver

---

## 19.17 Common Report Requirements

All reports shall:

- Respect user role and station access.
- Support appropriate date and station filters.
- Display generation date and time.
- Display the user who generated the report.
- Use consistent monetary and quantity formatting.
- Support PDF or Excel where approved.
- Avoid exposing sensitive information to unauthorized users.

---

# 20. Assumptions

The following assumptions apply to the initial release.

## ASM-001 — Receipt Availability

Employees will obtain readable Start and End Reading Receipts from the dispenser unit for every shift.

## ASM-002 — Receipt Format

The initial OCR solution will be optimized for the receipt formats and sample images supplied by the client.

## ASM-003 — Device Availability

Employees will have access to a supported desktop or mobile device with a modern web browser.

## ASM-004 — Network Availability

Users will have sufficient network connectivity to access the centralized application and upload receipt images.

## ASM-005 — Master Data Accuracy

Station, dispenser-unit, nozzle, employee, assignment and fuel-price information will be configured accurately before operational use.

## ASM-006 — User Responsibility

Employees will enter cash, UPI, card, credit and adjustment information accurately.

## ASM-007 — Approval Availability

Authorized Level-1 Reviewers and Level-2 Approvers will be available to complete the approval workflow.

## ASM-008 — Supported Currency

The initial release will use Indian Rupees as the operational currency.

## ASM-009 — Initial Fuel Types

The initial implementation will support Petrol and Diesel. Additional fuel types may be introduced later.

## ASM-010 — Centralized Deployment

The application is expected to use a centralized server and database, subject to final hosting approval.

## ASM-011 — Receipt Storage

Receipt images will initially be stored in secured file storage, with associated metadata retained in the database.

## ASM-012 — Client-Supplied Test Data

The client will provide sufficient representative receipt samples, including clear, blurred, rotated and low-quality images, for OCR testing.

---

# 21. Constraints

## CON-001 — Receipt Image Quality

OCR accuracy depends on receipt condition, image resolution, lighting, focus, orientation and print quality.

## CON-002 — Receipt Format Changes

Changes to dispenser receipt layouts may require OCR and parser configuration updates.

## CON-003 — Network Dependence

The centralized web application requires network access unless an offline capability is added in a future release.

## CON-004 — Device Capability

Camera capture and file-selection behaviour may vary across devices and browsers.

## CON-005 — Client Infrastructure

Performance and availability depend on the final hosting environment, network and server capacity.

## CON-006 — Manual Information

Cash, UPI, card, credit and adjustment totals depend on accurate employee entry unless external systems are integrated later.

## CON-007 — Approval Turnaround

Shift closure may be delayed if reviewers or approvers do not complete actions promptly.

## CON-008 — Historical Data Volume

The fourteen-month retention requirement will influence database and receipt-storage capacity.

## CON-009 — External Integration

Automatic UPI, card, bank and ERP verification are outside the initial release.

## CON-010 — Browser Support

Only client-approved browser versions will be formally tested and supported.

---

# 22. Project and Business Risks

| Risk ID | Risk | Impact | Mitigation |
|---|---|---|---|
| RSK-001 | Poor receipt-image quality | Incorrect OCR values | Image validation, preprocessing and manual review |
| RSK-002 | Receipt layout changes | Extraction failures | Template-based parsing and configurable OCR profiles |
| RSK-003 | Incorrect master configuration | Wrong employee allocation or price calculation | Validation, approval and configuration audit |
| RSK-004 | Incorrect collection entry | Reconciliation mismatch | Entry validation, summaries and reviewer verification |
| RSK-005 | Network failure during upload | Interrupted workflow | Draft saving, retry and resumable workflow where feasible |
| RSK-006 | Unauthorized access | Data exposure or improper approval | Authentication, roles, station restrictions and audit |
| RSK-007 | Insufficient hosting capacity | Slow response or failure | Capacity planning and performance testing |
| RSK-008 | Delayed client decisions | Schedule impact | Maintain an open-decision register and target dates |
| RSK-009 | Limited OCR training samples | Lower initial accuracy | Obtain representative client samples early |
| RSK-010 | Approval delays | Shift remains pending | Dashboards, pending queues and future notifications |
| RSK-011 | Incomplete backup | Loss of database or receipt files | Coordinated database and file-storage backups |
| RSK-012 | Requirement changes after approval | Rework and timeline impact | Formal change-control process |

---

# 23. Future Enhancements

The following capabilities may be considered for later releases:

- Native Android and iOS applications
- Offline receipt capture and synchronization
- Automatic UPI settlement integration
- Automatic card-terminal integration
- Bank deposit reconciliation
- Credit-customer master and settlement management
- ERP and accounting integration
- Tank inventory reconciliation
- Fuel-delivery and stock management
- SMS, email and push notifications
- Multi-language interface
- Multi-organization support
- Advanced dashboards and analytics
- Scheduled report delivery
- Cloud object storage
- Electronic signatures
- Fraud and anomaly detection
- Machine-learning-assisted OCR correction
- Automatic fuel-price synchronization
- Biometric authentication
- Additional fuel types and alternate-energy products

Future enhancements shall be evaluated through a formal change request and estimation process.

---

# 24. Open Business Decisions

| Decision ID | Topic | Current Status | Required Client Decision |
|---|---|---|---|
| DEC-001 | UPI Entry Model | Confirmed | Capture TID and total amount for each UPI terminal |
| DEC-002 | Approval Levels | Confirmed | Two-level review and approval |
| DEC-003 | Data Retention | Confirmed | Retain operational data for fourteen months |
| DEC-004 | Reconciliation Tolerance | Pending Value | Confirm initial amount and configuration level |
| DEC-005 | Hosting Model | Pending | Confirm office server, head-office server, data centre or cloud |
| DEC-006 | Card Entry Model | Pending Confirmation | Total by terminal or individual transactions |
| DEC-007 | Adjustment Approval | Pending Confirmation | Identify adjustment types requiring approval |
| DEC-008 | Rounding Rules | Pending Confirmation | Confirm quantity, price and monetary rounding |
| DEC-009 | Receipt Limits | Pending Confirmation | Confirm file formats, maximum size and minimum resolution |
| DEC-010 | Archive or Delete | Pending Confirmation | Decide handling of records after fourteen months |
| DEC-011 | Credit Settlement | Pending Confirmation | Confirm whether settlement is part of Version 1.0 |
| DEC-012 | Approved Shift Reopening | Pending Confirmation | Define roles and workflow for reopening |
| DEC-013 | Production User Volume | Pending | Confirm stations, employees and concurrent users |
| DEC-014 | Notification Requirements | Pending Confirmation | Confirm whether alerts are required in Version 1.0 |
| DEC-015 | OCR Correction Permission | Pending Confirmation | Employee, reviewer or supervisor access |
| DEC-016 | Approval Remarks | Partially Confirmed | Confirm whether remarks are mandatory for matched cases |
| DEC-017 | Retention Start Date | Pending Confirmation | Business date, closure date or approval date |
| DEC-018 | Deployment Availability | Pending Confirmation | Confirm operating hours and availability target |

Open decisions shall be reviewed before the relevant design or implementation is finalized.

---

# 25. Acceptance Criteria

The first production release shall be considered functionally acceptable when the following criteria are met.

## AC-001 — Master Configuration

Authorized users can configure:

- Organization
- Fuel Station
- Dispenser Unit
- Nozzles
- Employees
- Nozzle Assignments
- Fuel Types
- Fuel Prices
- Users and Roles

## AC-002 — Shift Creation

An employee can open a valid shift using configured station, DU, employees and nozzle assignments.

## AC-003 — Start Receipt Processing

The employee can upload, process, review and confirm a Start Reading Receipt.

## AC-004 — End Receipt Processing

The employee can upload, process, review and confirm an End Reading Receipt.

## AC-005 — Receipt Validation

The system validates the DU Serial Number, nozzles, ATOT and VTOT values for both receipts.

## AC-006 — Manual Correction

Authorized users can correct OCR values while preserving the original value, reason, user and timestamp.

## AC-007 — Fuel Sales Calculation

The system calculates:

- Quantity Sold
- Receipt Amount Difference
- Price-Based Sales Amount
- Amount Variance

## AC-008 — Employee Allocation

Nozzle sales are allocated to the employee assigned for the shift.

## AC-009 — Cash Entry

Employees can enter denomination quantities, and the system calculates the cash total.

## AC-010 — UPI Entry

Employees can enter UPI Terminal ID and total amount for one or more terminals.

## AC-011 — Card Entry

Employees can enter card collection details and totals.

## AC-012 — Credit Entry

Employees can record credit sales with the required customer information.

## AC-013 — Adjustment Entry

Employees and authorized reviewers can record and approve applicable expenses and adjustments.

## AC-014 — Employee Reconciliation

The system calculates expected amount, accounted amount, difference and status for each employee.

## AC-015 — Shift Reconciliation

The system calculates the complete shift-level reconciliation.

## AC-016 — Configurable Tolerance

The system applies a configured reconciliation tolerance without requiring source-code changes.

## AC-017 — Level-1 Review

A Reviewer can:

- Approve a matched reconciliation
- Return shortage or excess to the employee
- Approve a resubmitted shortage or excess with remarks

## AC-018 — Level-2 Approval

An Approver can:

- Approve a reconciliation
- Approve shortage or excess with remarks
- Reject and return the reconciliation to the employee

## AC-019 — Approval History

Every submission, return, resubmission, approval and rejection is retained.

## AC-020 — Shift Closure

A fully approved shift can be closed and becomes read-only.

## AC-021 — Reports

Authorized users can generate the approved reconciliation, sales, collection, adjustment and audit reports.

## AC-022 — Responsive Access

Primary employee, reviewer and approver workflows are usable from supported desktop and mobile browsers.

## AC-023 — Data Retention

Operational data is retained for at least fourteen months.

## AC-024 — Security

The system enforces authentication, roles, station restrictions and approval segregation.

## AC-025 — Auditability

An authorized auditor can trace a completed reconciliation to its source receipts, readings, prices, collections, adjustments and approval actions.

## AC-026 — User Acceptance Testing

The client completes User Acceptance Testing and formally approves the agreed test scenarios.

---

# 26. Glossary

| Term | Definition |
|---|---|
| Accounted Amount | Total cash, UPI, card, credit and applicable adjustments recorded for reconciliation |
| Adjustment | Approved financial or operational value added to or deducted from the accounted amount |
| Approver | User authorized to perform Level-2 approval |
| ATOT | Accumulated monetary total printed on the dispenser receipt |
| BRD | Business Requirements Document |
| Business Date | Operational date associated with a shift |
| Cash Denomination | Currency-note or coin value used to calculate physical cash |
| Credit Sale | Fuel sale for which payment is not received immediately |
| Dispenser Unit | Fuel-dispensing unit identified by a DU Serial Number |
| DU | Dispenser Unit |
| DU Serial Number | Unique serial number printed on the Electronic Totalizer receipt |
| ECAL | Calibration-related factor printed on certain receipts |
| Employee Reconciliation | Comparison of one employee’s expected sales with accounted collections |
| End Reading Receipt | Receipt captured at the end of a shift |
| Expected Sales Amount | Fuel-sales amount calculated from assigned nozzle readings |
| Fuel Price | Effective selling price per litre for a fuel type |
| Fuel Type | Petrol, Diesel or another configured fuel product |
| OCR | Optical Character Recognition |
| Nozzle | Individual fuel-dispensing outlet |
| OCR Confidence | Indicator of recognition certainty used to trigger review |
| Reconciliation | Comparison between expected fuel sales and accounted collections |
| Reconciliation Tolerance | Permitted difference treated as a match |
| Reviewer | User authorized to conduct Level-1 review |
| Shift | Operational reconciliation period for a station and dispenser unit |
| Shift Reconciliation | Consolidated reconciliation covering all employees in a shift |
| Start Reading Receipt | Receipt captured at the beginning of a shift |
| TID | Terminal ID used to identify a UPI or payment machine |
| UPI | Unified Payments Interface |
| VTOT | Accumulated fuel-volume total printed on the receipt |

---

# 27. Appendix

## 27.1 Core Calculation Formulas

### Fuel Quantity

```text
Quantity Sold =
    End VTOT
  - Start VTOT
```

### Receipt Amount

```text
Receipt Amount Difference =
    End ATOT
  - Start ATOT
```

### Price-Based Sales

```text
Calculated Sales Amount =
    Quantity Sold
  × Effective Price Per Litre
```

### Cash Denomination

```text
Denomination Amount =
    Denomination Value
  × Quantity
```

### Employee Accounted Amount

```text
Employee Accounted Amount =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Total
  + Positive Adjustment Total
  - Deductible Adjustment Total
```

### Reconciliation Difference

```text
Difference =
    Accounted Amount
  - Expected Sales Amount
```

### Reconciliation Status

```text
Absolute Difference <= Allowed Tolerance
    → MATCHED

Difference < -Allowed Tolerance
    → SHORTAGE

Difference > Allowed Tolerance
    → EXCESS
```

---

## 27.2 Confirmed Client Decisions

| Topic | Confirmed Decision |
|---|---|
| UPI Collection | Record TID and total amount for each UPI terminal |
| Approval Workflow | Two approval levels |
| Initial Shortage or Excess | Return to employee for correction |
| Shortage or Excess After Resubmission | Level-1 Reviewer may approve with remarks and forward |
| Level-2 Decision | Approve with remarks or reject and return |
| Data Retention | Fourteen months |
| Reconciliation Tolerance | Configurable; initial value pending |

---

## 27.3 Requirement Identification

| Prefix | Meaning |
|---|---|
| FR | Functional Requirement |
| NFR | Non-Functional Requirement |
| SEC | Security Requirement |
| RET | Retention Requirement |
| BCK | Backup Requirement |
| HST | Hosting Requirement |
| CMP | Compliance Requirement |
| SCR | Screen Specification |
| RPT | Report Specification |
| BR | Business Rule |
| AC | Acceptance Criterion |
| DEC | Open Decision |
| RSK | Risk |
| ASM | Assumption |
| CON | Constraint |

---

# 28. Client Approval

## 28.1 Document Status

```text
DRAFT FOR CLIENT REVIEW
```

This document becomes the approved business baseline only after authorized client sign-off.

---

## 28.2 Approval Record

| Role | Name | Organization | Decision | Signature | Date |
|---|---|---|---|---|---|
| Business Owner | | | Approved / Rejected | | |
| Operations Representative | | | Approved / Rejected | | |
| Project Sponsor | | | Approved / Rejected | | |
| Prepared By | Sivakumar Mani | Project Team | Submitted | | |

---

## 28.3 Client Review Comments

| Comment ID | Section | Client Comment | Resolution | Status |
|---|---|---|---|---|
| | | | | |

---

## 28.4 Approval Statement

By approving this document, the client confirms that:

- The business requirements accurately represent the agreed operational needs.
- Open decisions are acknowledged and will be resolved through documented follow-up.
- Changes after approval may affect project scope, cost and delivery timeline.
- Approved changes shall follow the agreed change-control process.

---

# 29. Document Conclusion

This Business Requirements Document defines the initial business scope for the Fuel Station Shift Reconciliation System.

The approved BRD will be used as the baseline for:

- Project estimation
- Delivery planning
- Solution design
- Database design
- User-interface design
- Development
- Testing
- User Acceptance Testing
- Deployment
- Training

Any material requirement introduced after approval shall be evaluated through formal change control.

---

# Final Table of Contents

1. Executive Summary  
2. Business Background  
3. Current Business Process  
4. Problems in Existing Process  
5. Proposed Solution  
6. Business Objectives  
7. Project Scope  
8. Stakeholders  
9. Functional Requirements  
10. Business Rules  
11. Non-Functional Requirements  
12. Security Requirements  
13. Data Retention and Archival Requirements  
14. Backup and Recovery Requirements  
15. Hosting and Deployment Requirements  
16. Compliance and Audit Requirements  
17. Business Process Workflows  
18. Screen Specifications  
19. Report Specifications  
20. Assumptions  
21. Constraints  
22. Project and Business Risks  
23. Future Enhancements  
24. Open Business Decisions  
25. Acceptance Criteria  
26. Glossary  
27. Appendix  
28. Client Approval  
29. Document Conclusion  

---

> **Document Status:** Draft for Client Review  
> **Version:** 1.0  
> **Retention Requirement:** Fourteen Months  
> **Open Decisions:** Reconciliation tolerance value, hosting model and other items listed in Section 24