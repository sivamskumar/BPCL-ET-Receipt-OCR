# Fuel Station Shift Reconciliation System

# Business Requirements Document (BRD)

---

## Document Information

| Item | Details |
|------|----------|
| Project Name | Fuel Station Shift Reconciliation System |
| Document Name | Business Requirements Document |
| Version | 1.0 |
| Status | Draft |
| Prepared By | Sivakumar Mani |
| Reviewed By | To Be Confirmed |
| Approved By | Client |
| Document Date | July 2026 |

---

# Revision History

| Version | Date | Author | Description |
|---------|------|--------|-------------|
| 0.1 | July 2026 | Sivakumar Mani | Initial Draft |
| 1.0 | Pending | Pending | Client Approved Version |

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