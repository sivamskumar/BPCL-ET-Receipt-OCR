# Fuel Station Shift Reconciliation System
## UI/UX Prototype Plan

**Project:** Fuel Station Shift Reconciliation System
**UI Prototype Baseline Date:** 17-Aug-2026
**Current UI Milestone:** Milestone 1D.1 — UI/UX Prototype Foundation
**Target Client UI Review:** Late Aug-2026
**Target Production Release:** 31-Oct-2026

---

# 1. Purpose

This document defines the UI/UX prototype strategy for the
Fuel Station Shift Reconciliation System.

The prototype work shall run in parallel with backend development so that
client feedback on navigation, terminology, workflow, layout and mobile
usability can be obtained before significant frontend implementation is
finalized.

The UI prototype shall be treated as a functional design baseline rather
than final production code.

---

# 2. UI/UX Objectives

The user interface shall be designed to provide:

- clear role-based navigation;
- simple operational workflows;
- responsive desktop, tablet and mobile layouts;
- minimal typing for fuel-station employees;
- fast receipt capture and review;
- clear reconciliation information;
- strong visibility of shortage, excess and matched conditions;
- clear reviewer and approver actions;
- consistent validation and error presentation;
- easy access to operational history;
- professional administration screens;
- client-friendly dashboards;
- accessibility and readability;
- consistent use of terminology across all modules.

---

# 3. User Roles

The UI shall support the following finalized application roles:

- EMPLOYEE;
- REVIEWER;
- APPROVER;
- ADMINISTRATOR.

Each role shall see only the functions relevant to its responsibilities.

Role-based visibility shall be enforced by the backend security model and
reflected by the frontend navigation.

---

# 4. Application Navigation Model

The application shall use role-based navigation.

```text
Application
│
├── Login
│
├── Administrator
│   ├── Dashboard
│   ├── Organization
│   ├── Fuel Stations
│   ├── Dispenser Units
│   ├── Dispenser Sides
│   ├── Nozzles
│   ├── Fuel Types
│   ├── Fuel Prices
│   ├── Employees
│   ├── Shift Definitions
│   ├── Users
│   ├── Roles
│   ├── Station Access
│   ├── Reports
│   └── Audit History
│
├── Employee
│   ├── Dashboard
│   ├── Current Shift
│   ├── Receipt Capture
│   ├── OCR Review
│   ├── Collections
│   ├── Adjustments
│   ├── Reconciliation
│   └── Shift History
│
├── Reviewer
│   ├── Dashboard
│   ├── Pending Reviews
│   ├── Reconciliation Review
│   ├── Returned Cases
│   └── Review History
│
└── Approver
    ├── Dashboard
    ├── Pending Approvals
    ├── Final Approval
    └── Approval History
```

---

# 5. UI Design Principles

## 5.1 Operational Simplicity

The interface shall prioritize operational clarity over decorative design.

Fuel-station employees shall be able to complete common activities with
minimal navigation and minimal data entry.

---

## 5.2 Professional Visual Style

The system shall use a clean professional operations-dashboard style.

Recommended characteristics:

- white/light content surfaces;
- restrained blue or teal accent colours;
- clear typography;
- compact but readable forms;
- clear tables;
- high-visibility status badges;
- consistent action buttons;
- minimal decorative graphics;
- limited gradients;
- limited unnecessary whitespace.

The final branding colours shall be confirmed with the client.

---

## 5.3 Responsive Design

The application shall adapt according to device size.

### Desktop

Recommended layout:

```text
┌───────────────────────────────────────────────────────────┐
│ Header                                                    │
├───────────────┬───────────────────────────────────────────┤
│               │                                           │
│ Sidebar       │ Main Content                              │
│ Navigation    │                                           │
│               │                                           │
│               │                                           │
└───────────────┴───────────────────────────────────────────┘
```

Desktop usage shall primarily support:

- administration;
- reviewer functions;
- approver functions;
- reports;
- audit history.

---

### Tablet

Recommended behavior:

- collapsible sidebar;
- responsive dashboard cards;
- scrollable tables;
- touch-friendly forms;
- simplified toolbar.

---

### Mobile

Recommended layout:

```text
┌─────────────────────────────┐
│ Header / Current Shift      │
├─────────────────────────────┤
│                             │
│ Main Operational Content    │
│                             │
│ Large Touch Actions         │
│                             │
├─────────────────────────────┤
│ Compact / Bottom Navigation │
└─────────────────────────────┘
```

Mobile usage shall primarily support:

- employee login;
- current shift;
- assigned nozzle information;
- receipt capture;
- OCR review;
- collection entry;
- reconciliation submission.

---

# 6. Employee Experience Principle

The employee interface shall be designed around the current shift rather
than around multiple disconnected menus.

Recommended workflow:

```text
Employee Login
      ↓
Current Shift
      ↓
Assigned Nozzles
      ↓
Capture START Receipt
      ↓
OCR Processing
      ↓
Review / Correct
      ↓
Confirm START Reading
      ↓
Shift Operations
      ↓
Capture END Receipt
      ↓
OCR Processing
      ↓
Review / Correct
      ↓
Confirm END Reading
      ↓
Enter Collections
      ↓
Employee Reconciliation
      ↓
Submit
```

The employee should always be able to clearly understand:

- which shift is active;
- which station is active;
- which dispenser/nozzles are assigned;
- which receipt step is pending;
- whether OCR requires review;
- whether collection entry is complete;
- whether reconciliation is matched, shortage or excess;
- whether submission is pending or returned.

---

# 7. Administrator Experience

The Administrator interface shall use a structured desktop-first
administration workspace.

Recommended navigation groups:

```text
Dashboard

Organization Setup
├── Organization
├── Fuel Stations
└── Shift Definitions

Fuel Configuration
├── Fuel Types
└── Fuel Prices

Dispenser Configuration
├── Dispenser Units
├── Dispenser Sides
├── Nozzles
└── Nozzle Fuel Assignment

People
├── Employees
├── Users
├── Roles
└── Station Access

Operations
├── Current Shifts
├── Reconciliation
└── Reports

Governance
└── Audit History
```

Administration screens should use consistent patterns:

```text
Page Title
    ↓
Search / Filters
    ↓
Primary Action
    ↓
Data Table
    ↓
View / Edit / Activate / Deactivate
```

---

# 8. Reviewer Experience

The Reviewer dashboard shall focus on work requiring attention.

Recommended dashboard information:

- pending employee reconciliations;
- shortages;
- excess cases;
- returned/resubmitted cases;
- ageing of pending reviews;
- recent reviewer decisions.

Recommended workflow:

```text
Pending Review
      ↓
Employee Reconciliation
      ↓
Sales / Collection Comparison
      ↓
Difference
      ↓
Supporting Receipts
      ↓
Adjustment Details
      ↓
Decision
      ├── Return to Employee
      ├── Approve
      └── Approve with Remarks
```

The reviewer shall be able to see the supporting evidence without opening
many unrelated screens.

---

# 9. Approver Experience

The Approver interface shall focus on final decisions.

Recommended workflow:

```text
Pending Level-2 Approval
        ↓
Employee / Shift Summary
        ↓
Level-1 Decision
        ↓
Difference / Tolerance
        ↓
Remarks / Evidence
        ↓
Final Decision
        ├── Return / Reject
        └── Approve
```

The final approval screen shall clearly show:

- employee;
- station;
- shift;
- expected sales;
- accounted amount;
- difference;
- allowed tolerance;
- reconciliation status;
- Level-1 reviewer;
- Level-1 remarks;
- previous returns/resubmissions;
- relevant audit history.

---

# 10. Status Presentation

Status shall be visually consistent throughout the application.

Examples:

```text
MATCHED
SHORTAGE
EXCESS

DRAFT
PENDING REVIEW
RETURNED
RESUBMITTED
APPROVED

ACTIVE
INACTIVE
LEFT

UPLOADED
OCR IN PROGRESS
REVIEW REQUIRED
CONFIRMED
FAILED
```

Status presentation shall use:

- text;
- consistent badge style;
- accessible contrast;
- icon where useful.

Colour alone shall not be the only indicator.

---

# 11. Form Design

Forms shall follow consistent rules.

## Required Fields

Required fields shall be clearly marked.

## Validation

Validation messages shall:

- appear close to the corresponding field;
- use business-friendly language;
- avoid displaying raw technical exceptions;
- retain entered values when possible.

## Actions

Recommended button hierarchy:

```text
Primary
    Save
    Submit
    Confirm
    Approve

Secondary
    Cancel
    Back
    Preview

Destructive / High Risk
    Delete
    Reject
    Return
    Deactivate
```

Destructive/high-risk actions shall require confirmation where
appropriate.

---

# 12. Table Design

Administration and reporting tables should support:

- sorting;
- filtering;
- pagination;
- status indicators;
- clear empty-state messages;
- responsive behavior;
- contextual row actions.

On mobile devices, large tables should not simply shrink.

Possible alternatives include:

- horizontal scrolling;
- responsive cards;
- reduced priority columns;
- expandable rows.

---

# 13. Mobile Receipt Capture Prototype

Receipt capture is one of the highest-priority UI workflows.

Recommended flow:

```text
Current Shift
     ↓
START / END Receipt Required
     ↓
Take Photo / Select Image
     ↓
Preview
     ↓
Use Photo / Replace
     ↓
Upload
     ↓
OCR Processing
     ↓
OCR Review
     ↓
Confirm
```

The capture screen shall clearly show:

- employee;
- current shift;
- dispenser;
- side;
- receipt type;
- image preview;
- upload status.

---

# 14. OCR Review Prototype

The OCR review screen shall provide:

- receipt image;
- extracted values;
- confidence indicators;
- editable correction fields;
- warning messages;
- nozzle identification;
- ATOT;
- VTOT;
- ECAL where applicable;
- confirmation action.

Recommended concept:

```text
┌──────────────────┬─────────────────────────┐
│ Receipt Image    │ Extracted Values        │
│                  │                         │
│                  │ N1                      │
│                  │ ATOT: ...               │
│                  │ VTOT: ...               │
│                  │ ECAL: ...               │
│                  │                         │
│                  │ N2                      │
│                  │ ATOT: ...               │
│                  │ VTOT: ...               │
│                  │ ECAL: ...               │
└──────────────────┴─────────────────────────┘

        [Correct]     [Confirm]
```

On mobile, the image and values may be stacked vertically.

---

# 15. Collection Entry Prototype

Employee collection entry shall include:

```text
Collections
│
├── Cash Notes
│   ├── denomination
│   ├── quantity
│   └── calculated total
│
├── Coins
│
├── TID / Digital Collection
│
├── Credit Sales
│
└── Adjustments
```

The system shall continuously show a collection summary where practical.

---

# 16. Reconciliation Prototype

The reconciliation screen shall clearly answer:

```text
How much should the employee account for?
                vs
How much has the employee accounted for?
```

Recommended summary:

```text
Expected Sales        ₹ xxx,xxx.xx

Cash                  ₹ xxx,xxx.xx
TID                   ₹ xxx,xxx.xx
Credit                ₹ xxx,xxx.xx
Add Adjustments       ₹ xxx,xxx.xx
Less Adjustments      ₹ xxx,xxx.xx
-----------------------------------
Accounted Amount      ₹ xxx,xxx.xx

Difference            ₹   x,xxx.xx
Tolerance             ₹     xxx.xx

Status                MATCHED / SHORTAGE / EXCESS
```

The primary action shall depend on workflow state:

```text
Save Draft
Submit
Resubmit
```

---

# 17. Prototype Screens for Client UI Review #1

The first UI review shall focus on approximately the following screens.

## Screen 1 — Login

Purpose:

- establish branding;
- confirm login simplicity;
- establish initial visual style.

---

## Screen 2 — Administrator Dashboard

Purpose:

- establish desktop application shell;
- confirm navigation;
- confirm dashboard information.

---

## Screen 3 — Fuel Station Management

Purpose:

- confirm master-data screen pattern;
- confirm table/forms;
- confirm terminology.

---

## Screen 4 — Employee Management

Purpose:

- confirm employee information layout;
- confirm photograph handling;
- confirm employment status presentation.

---

## Screen 5 — Shift Setup / Shift Opening

Purpose:

- validate the operational setup workflow.

---

## Screen 6 — Employee Mobile Dashboard

Purpose:

- confirm employee mobile experience;
- confirm Current Shift concept;
- confirm assigned-nozzle presentation.

---

## Screen 7 — Mobile Receipt Capture

Purpose:

- validate photograph capture workflow.

---

## Screen 8 — OCR Review / Correction

Purpose:

- validate extracted-reading presentation;
- validate correction interaction.

---

## Screen 9 — Reviewer Dashboard

Purpose:

- confirm review queue and decision visibility.

---

## Screen 10 — Approver Dashboard

Purpose:

- confirm final approval workflow presentation.

---

# 18. Client Questions for UI Review #1

The client shall be asked to confirm or comment on the following.

## Branding

- Does the client require fuel-station branding?
- Should BPCL branding be represented?
- Are there preferred colours?
- Is a custom application/product logo required?

## Navigation

- Is the role-based navigation understandable?
- Are the menu names familiar to operational users?
- Are any important shortcuts missing?

## Administrator Dashboard

- What should an administrator see immediately after login?
- Which alerts or pending tasks are important?

## Employee Dashboard

- What should an employee see immediately after login?
- Should employee workflow begin directly with the current shift?

## Receipt Capture

- Will employees primarily use Android phones?
- Is camera capture preferred over selecting an existing image?
- Is receipt replacement before submission required?
- Is image cropping/rotation expected?

## OCR Review

- Which receipt values should be highlighted most prominently?
- How should low-confidence fields be presented?
- Should employees see raw OCR text?

## Reconciliation

- Which values must appear prominently?
- How should shortage/excess be visually represented?

## Reviewer / Approver

- What summary does the reviewer need before making a decision?
- What summary does the final approver need?
- Should supporting receipt images be visible directly on the review screen?

## Reports

- Which reports should be available directly from dashboards?

---

# 19. Prototype Technology Strategy

The first prototype phase does not require complete backend integration.

Possible prototype approaches include:

- static HTML/CSS prototype;
- React prototype using static/mock data;
- design mockups;
- interactive browser prototype.

The selected approach should allow rapid client feedback without creating
throwaway architecture.

The production frontend technology shall be finalized before full
frontend implementation begins.

---

# 20. Prototype Data

Prototype screens shall use representative sample data.

Example:

```text
Organization
ABC Fuels

Station
ABC Fuels - Main Road

Shift
Shift 1

Employees
Sujith
Sonu

Dispenser
DU-001

Nozzles
N1 Petrol
N2 Diesel
N3 Petrol
N4 Diesel
```

Prototype data is illustrative and shall not be treated as production
configuration.

---

# 21. UI Prototype Acceptance Criteria

Milestone 1D.1 shall be considered complete when:

- UI/UX design principles are established;
- responsive design strategy is established;
- role-based navigation is defined;
- employee current-shift workflow is defined;
- administration navigation is defined;
- reviewer navigation is defined;
- approver navigation is defined;
- prototype screen list is agreed;
- client-review questions are prepared;
- initial prototype technology approach is selected;
- first prototype screens are ready to begin.

---

# 22. Initial Prototype Implementation Sequence

Recommended sequence:

```text
1D.1
UI/UX Prototype Foundation
        ↓
Login Prototype
        ↓
Administrator Application Shell
        ↓
Administrator Dashboard
        ↓
Employee Mobile Application Shell
        ↓
Employee Dashboard
        ↓
Receipt Capture
        ↓
OCR Review
        ↓
Reviewer Dashboard
        ↓
Approver Dashboard
        ↓
Client UI Review #1
```

---

# 23. Current Status

**Milestone:** 1D.1 — UI/UX Prototype Foundation
**Status:** IN PROGRESS
**Start Date:** 17-Aug-2026

Parallel backend milestone:

**Milestone 1C.3 — Administration and Master Data APIs**

---

# 24. Next Action

After this UI prototype plan is reviewed and committed:

1. finalize prototype technology;
2. define the initial visual style;
3. create the Login prototype;
4. create the Administrator application shell;
5. create the Administrator Dashboard prototype;
6. create the Employee mobile dashboard prototype;
7. review the first prototype set internally;
8. prepare for Client UI Review #1.