# Fuel Station Shift Reconciliation System
## Business Requirements Document

## 1. Document Purpose

This document defines the business requirements for the Fuel Station Shift Reconciliation System.

The system is intended to calculate and validate fuel sales for employees operating fuel-dispensing nozzles during a shift.

It will use start-reading and end-reading Electronic Totalizer receipts, payment collections, expenses and other approved adjustments to determine whether the collections entered by an employee match the expected fuel sales amount.

This document is intended for client review and confirmation before detailed development begins.

---

## 2. Business Objective

The primary objective of the application is to:

1. Read start-of-shift and end-of-shift fuel-dispenser receipts.
2. Extract nozzle-wise accumulated volume and amount readings.
3. Calculate the quantity and value of petrol and diesel sold.
4. Allocate nozzle sales to the responsible employees.
5. Capture collections received through cash, UPI, card and credit.
6. Capture expenses and approved adjustments.
7. Compare the expected fuel-sales amount with the accounted collection amount.
8. Identify whether the shift is:
   - Matched
   - Short
   - Excess
   - Pending review
9. Maintain an auditable history of receipts, readings, corrections, payments and approvals.

---

## 3. Application Scope

The application will be a centralized, responsive web application.

It must be usable from:

- Desktop computers
- Laptop computers
- Tablets
- Mobile phones

Users will access the system through a supported web browser.

No separate desktop installation should be required for normal users.

---

## 4. Supported Organizations and Stations

The system should support:

- One or more operating organizations
- Multiple fuel stations
- Multiple dispenser units within a station
- Multiple employees
- Multiple shifts
- Configurable nozzle assignments
- Multiple supported fuel types

The initial implementation may begin with one organization and a limited number of stations, but the design must support future expansion.

---

## 5. Fuel Station Identification

Each fuel station will have a unique station code and name.

Each pumping or dispenser unit will be identified by the **DU Serial Number** printed on the Electronic Totalizer receipt.

The DU Serial Number will be used to:

- Identify the correct dispenser unit
- Validate the uploaded receipts
- Load the configured nozzles
- Load the assigned employees
- Ensure start and end receipts belong to the same dispenser unit

The Start Reading and End Reading receipts must contain the same normalized DU Serial Number.

If the DU Serial Numbers do not match, reconciliation must not proceed without authorized review.

---

## 6. Dispenser Unit and Nozzle Configuration

A dispenser unit may contain one or more nozzles.

The current business scenario contains four nozzle points.

Example:

| Nozzle | Employee | Fuel Type |
|---:|---|---|
| 1 | Sujith | Petrol |
| 2 | Sujith | Diesel |
| 3 | Sonu | Petrol |
| 4 | Sonu | Diesel |

This is an example configuration only.

The application must not permanently hardcode:

- Employee names
- Number of nozzles
- Nozzle-to-employee mapping
- Fuel type assigned to a nozzle

All assignments must be configurable.

---

## 7. Employee Management

The system must maintain employee information including:

- Employee code
- Employee name
- Mobile number, where required
- Active or inactive status
- Assigned station or stations
- Assigned nozzle or nozzles
- Assignment effective date
- Assignment end date, where applicable

Historical assignments must be preserved.

Changing a nozzle assignment must not alter previously completed shift records.

---

## 8. Nozzle Assignment Rules

A nozzle may be assigned to one employee for a given effective period.

An employee may be assigned multiple nozzles.

For example, one employee may operate:

- One petrol nozzle
- One diesel nozzle

The application must ensure:

- One nozzle is not assigned to multiple employees for the same shift
- Assignment periods do not overlap
- Only active employees and active nozzles are used
- Shift records preserve the assignments effective on the shift date

---

## 9. Fuel Types

The initial fuel types are:

- Petrol
- Diesel

The system should support additional fuel types in the future without major redesign.

Possible future fuel types may include:

- Premium Petrol
- Premium Diesel
- CNG
- LPG

---

## 10. Fuel Price Management

Fuel prices must be configurable by:

- Fuel station
- Fuel type
- Effective date and time

The application must retain fuel-price history.

A shift must use the fuel price that was effective for the applicable business date and time.

Overlapping active price periods for the same station and fuel type must not be allowed.

---

## 11. Shift Management

A shift represents one operational reconciliation period for a dispenser unit.

A shift should capture:

- Station
- Dispenser unit
- DU Serial Number
- Business date
- Shift number
- Start date and time
- End date and time
- Participating employees
- Assigned nozzles
- Start receipt
- End receipt
- Payment entries
- Adjustments
- Reconciliation result
- Approval status

Suggested shift statuses are:

- Open
- Start Receipt Uploaded
- End Receipt Uploaded
- OCR Completed
- Readings Confirmed
- Payments Entered
- Reconciled
- Submitted
- Approved
- Closed
- Cancelled

---

## 12. Start Reading Receipt

At the beginning of the shift, the employee obtains an Electronic Totalizer receipt from the dispenser unit.

This receipt is the **Start Reading Receipt**.

The receipt is expected to contain:

- DU Serial Number
- Receipt date and time
- Nozzle number
- ATOT reading
- VTOT reading
- ECAL factor, where available
- Other dispenser-generated information

The employee uploads the receipt into the application.

On a mobile device, the user should be able to:

- Take a new photo using the camera
- Select an existing image
- Preview the image
- Replace a poor-quality image
- Submit the image for processing

---

## 13. End Reading Receipt

At the end of the shift, the employee obtains a second Electronic Totalizer receipt from the same dispenser unit.

This receipt is the **End Reading Receipt**.

The End Reading Receipt must relate to:

- The same station
- The same dispenser unit
- The same DU Serial Number
- The same shift
- The same configured nozzle set

The employee uploads the End Reading Receipt using the same process as the Start Reading Receipt.

---

## 14. Receipt Image Validation

Before OCR processing, the application should validate:

- Supported file type
- Maximum file size
- Minimum image resolution
- File is not empty
- Image is readable
- Duplicate file is not already uploaded
- Image orientation is suitable or can be corrected

Supported initial image formats may include:

- JPEG
- JPG
- PNG

Receipt image limits must be configurable.

---

## 15. OCR Processing

The application will use OCR to extract text and numeric values from uploaded receipt images.

The OCR process should include:

- Image resizing
- Grayscale conversion
- Contrast enhancement
- Noise removal
- Thresholding
- Deskewing
- Perspective correction, where needed
- Region-of-interest processing
- Text recognition
- Field extraction
- Confidence scoring
- OCR normalization

The OCR engine should be optimized for Electronic Totalizer receipts rather than using only generic text recognition.

---

## 16. Receipt Data Extraction

The application should extract the following fields where present:

- DU Serial Number
- Receipt date
- Receipt time
- Nozzle number
- ATOT
- VTOT
- ECAL factor
- Other required receipt identifiers

For each extracted field, the application should retain:

- Original OCR text
- Normalized value
- OCR confidence
- Warning information
- Manual correction status

---

## 17. OCR Review and Manual Correction

If OCR confidence is below the configured threshold or a required value is missing, the application must request manual review.

The user should be able to view:

- Uploaded receipt image
- OCR-extracted values
- Confidence or warning indicators
- Original OCR text

Authorized users may correct an OCR value.

Each correction must retain:

- Original value
- Corrected value
- Correction reason
- User who corrected it
- Date and time of correction

Manual correction must never silently overwrite the original OCR result.

---

## 18. Receipt Validation Rules

The application must validate:

1. DU Serial Number is present.
2. Start and End DU Serial Numbers match.
3. Required nozzle readings are present.
4. Nozzle numbers are unique within a receipt.
5. ATOT and VTOT are valid numeric values.
6. End ATOT is not lower than Start ATOT.
7. End VTOT is not lower than Start VTOT.
8. Start receipt date and time precede the end receipt date and time, subject to authorized exceptions.
9. Receipt readings correspond to configured nozzles.
10. OCR confidence meets the configured threshold or values are manually confirmed.
11. Duplicate receipt images are not processed as new receipts.

A receipt requiring review must not be automatically finalized.

---

## 19. Fuel Quantity Calculation

For each nozzle:

```text
Quantity Sold =
    End VTOT
  - Start VTOT
```

The result represents the quantity of fuel sold through that nozzle during the shift.

The application must retain:

- Start VTOT
- End VTOT
- Calculated quantity sold
- Nozzle
- Fuel type
- Assigned employee

Fuel quantity calculations must use precise decimal arithmetic.

---

## 20. Receipt Amount Difference

For each nozzle:

```text
Receipt Amount Difference =
    End ATOT
  - Start ATOT
```

This represents the amount recorded by the dispenser totalizer.

The application must retain:

- Start ATOT
- End ATOT
- Receipt Amount Difference

---

## 21. Price-Based Sales Calculation

The application must independently calculate the expected sales amount:

```text
Calculated Sales Amount =
    Quantity Sold
  × Effective Price Per Litre
```

For each nozzle, the application will compare:

```text
Receipt Amount Difference
```

with:

```text
Calculated Sales Amount
```

The difference is:

```text
Amount Variance =
    Receipt Amount Difference
  - Calculated Sales Amount
```

A configurable tolerance may be applied for permissible rounding differences.

A material variance should be flagged for review.

---

## 22. Employee-Wise Fuel Sales

Sales must be allocated based on the nozzle assignment effective for the shift.

For example:

```text
Sujith Expected Sales =
    Sales from Nozzle 1
  + Sales from Nozzle 2
```

```text
Sonu Expected Sales =
    Sales from Nozzle 3
  + Sales from Nozzle 4
```

For each employee, the system should display:

- Assigned nozzles
- Petrol quantity sold
- Diesel quantity sold
- Quantity sold by other fuel types, where applicable
- Petrol sales amount
- Diesel sales amount
- Total expected sales amount

---

## 23. Cash Denomination Entry

The employee must be able to enter cash by denomination.

Initial denominations may include:

- ₹500
- ₹200
- ₹100
- ₹50
- ₹20
- ₹10
- ₹5
- ₹2
- ₹1

For each denomination, the employee enters the quantity.

The application calculates:

```text
Denomination Amount =
    Denomination Value
  × Quantity
```

The cash total is:

```text
Cash Total =
    Sum of all denomination amounts
```

The backend must calculate the total and must not rely only on values calculated in the browser.

Available denominations should be configurable.

---

## 24. UPI Collection Entry

The employee must be able to enter UPI collections.

The first release may support either:

- One total UPI amount for the employee and shift, or
- Multiple individual UPI entries

The final approach must be confirmed by the client.

An individual UPI entry may capture:

- Amount
- Transaction reference
- Payer name, where required
- Remarks
- Date and time

---

## 25. Card Collection Entry

The employee must be able to enter card collections.

The first release may support either:

- One total card amount for the employee and shift, or
- Multiple individual card entries

The final approach must be confirmed by the client.

A card entry may capture:

- Amount
- Reference number
- Terminal reference
- Remarks
- Date and time

---

## 26. Credit Sales

The employee must be able to record fuel sold on credit.

A credit-sale entry should capture:

- Customer name
- Customer or account reference
- Vehicle number, where required
- Amount
- Remarks
- Employee
- Date and time

Credit sales will be included in the accounted amount for reconciliation.

Future releases may support:

- Outstanding credit tracking
- Partial settlement
- Full settlement
- Credit-customer master data

---

## 27. Expenses and Adjustments

The system must support itemized expenses and other approved adjustments.

Supported adjustment types may include:

- Expense
- Cash Deposit
- Fuel Testing
- Calibration
- Fuel Return
- Other Approved Adjustment

Each adjustment should capture:

- Employee, where applicable
- Adjustment type
- Direction
- Amount
- Description
- Reference number
- Date and time
- Created by
- Approval status
- Approved by
- Approval date and time

Adjustment direction must be explicit:

- Add to Accounted Amount
- Deduct from Accounted Amount

The amount itself should be entered as a positive value.

The adjustment direction determines its effect.

---

## 28. Accounted Amount Calculation

For each employee:

```text
Accounted Amount =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Sales Total
  + Positive Adjustments
  - Deductible Expenses
```

The system should also calculate a shift-level Accounted Amount by adding all employee-level totals.

---

## 29. Reconciliation Calculation

For each employee:

```text
Difference =
    Accounted Amount
  - Expected Fuel Sales Amount
```

A configurable allowed tolerance will be applied.

Status rules:

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

The application may use:

```text
PENDING_REVIEW
```

when required inputs are incomplete, unconfirmed or materially inconsistent.

---

## 30. Employee Reconciliation Summary

For each employee, the application must display:

- Employee code
- Employee name
- Assigned nozzles
- Petrol quantity sold
- Diesel quantity sold
- Quantity of any other fuel type
- Expected sales amount
- Cash total
- UPI total
- Card total
- Credit total
- Positive adjustment total
- Expense total
- Accounted amount
- Difference amount
- Allowed tolerance
- Reconciliation status
- Review or approval status

---

## 31. Shift-Level Reconciliation Summary

The application must display:

- Organization
- Station
- DU Serial Number
- Business date
- Shift number
- Shift start time
- Shift end time
- Participating employees
- Total fuel quantity by fuel type
- Total expected fuel-sales amount
- Total cash collection
- Total UPI collection
- Total card collection
- Total credit sales
- Total positive adjustments
- Total expenses
- Total accounted amount
- Total difference
- Overall reconciliation status

Employee totals must add up to the shift total.

---

## 32. Reconciliation Tolerance

The system must support a configurable allowed difference.

Example:

```text
Allowed Tolerance = ₹1.00
```

The tolerance may be configured at one of the following levels:

- Organization
- Station
- Shift

The final configuration level should be confirmed by the client.

The effective tolerance used for a completed reconciliation must be retained for audit purposes.

---

## 33. Reconciliation Submission

After entering all payment and adjustment information, the employee may submit the reconciliation.

Before submission, the system must verify:

- Start receipt exists
- End receipt exists
- Receipt readings are confirmed
- Sales calculations are completed
- Employee payment entries are complete
- Required expense approvals are available
- Reconciliation has been calculated
- Required comments are entered for shortage or excess, where configured

Submitted reconciliations should be protected from unauthorized changes.

---

## 34. Approval Workflow

The system should support approval by an authorized supervisor or manager.

The reviewer should be able to:

- View receipt images
- View OCR readings
- View manual corrections
- View fuel sales calculations
- View cash denominations
- View UPI, card and credit entries
- View expenses and adjustments
- View reconciliation difference
- Approve
- Reject
- Return for correction
- Enter remarks

Approval actions must record:

- Action
- User
- Date and time
- Remarks

The final approval workflow and number of approval levels must be confirmed by the client.

---

## 35. User Roles

Suggested roles are:

### Employee

May:

- Open or access assigned shifts
- Upload receipts
- Review OCR results
- Enter collections
- Enter permitted adjustments
- Calculate reconciliation
- Submit reconciliation

### Supervisor

May:

- Review employee shifts
- Review corrections
- Review adjustments
- Return a shift for correction
- Approve within assigned authority

### Manager

May:

- Approve reconciliations
- Review shortages and excesses
- Manage fuel prices
- View station reports
- View audit history

### Administrator

May:

- Manage organizations
- Manage stations
- Manage dispenser units
- Manage employees
- Manage nozzle assignments
- Manage users and roles
- Manage application configuration

### Auditor

May:

- View completed reconciliations
- View receipts
- View correction history
- View audit history
- Generate audit reports

Detailed permissions will be confirmed during security design.

---

## 36. Authentication and Security

The system must require authenticated access.

The system should support:

- Username and password
- Secure password hashing
- Role-based authorization
- Account activation and deactivation
- Account lock after repeated failed logins
- Password reset
- Station-level access restriction
- Session timeout
- Secure HTTPS deployment
- Audit of important user actions

Passwords must never be stored in plain text.

---

## 37. Audit Requirements

The system must record important actions, including:

- User login
- Shift creation
- Start receipt upload
- End receipt upload
- OCR processing
- OCR failure
- Manual correction
- Fuel-sales calculation
- Payment entry
- Credit entry
- Adjustment entry
- Reconciliation calculation
- Reconciliation submission
- Approval
- Rejection
- Shift closure
- Report generation

Audit entries should include:

- User
- Action
- Entity type
- Entity identifier
- Old value, where applicable
- New value, where applicable
- Date and time
- IP address, where available
- Other relevant metadata

---

## 38. Receipt and File Storage

Receipt images will initially be stored outside the database.

The database should retain:

- Original filename
- Generated storage filename
- Storage path
- Content type
- File size
- SHA-256 file hash
- Image dimensions
- Upload timestamp
- Uploading user

The system must protect against:

- Path traversal
- Unsupported file types
- Duplicate uploads
- Excessive file size
- Malicious file content

The receipt-retention period must be confirmed before production deployment.

---

## 39. Reports

The application should support the following reports:

- Employee Shift Reconciliation Report
- Shift Reconciliation Report
- Station Daily Summary
- Fuel-Type Sales Summary
- Shortage and Excess Report
- Payment Collection Summary
- Credit Sales Report
- Expense and Adjustment Report
- Manual Correction Report
- Audit Report

Supported export formats should include:

- PDF
- Excel
- CSV, where appropriate

---

## 40. Dashboard Requirements

The employee dashboard should display:

- Open shifts
- Pending receipt uploads
- Pending payment entry
- Pending reconciliation
- Submitted shifts
- Returned-for-correction shifts

The manager dashboard should display:

- Open station shifts
- Pending approvals
- Matched reconciliations
- Shortage cases
- Excess cases
- OCR review cases
- Unapproved adjustments
- Daily station totals

---

## 41. Responsive Web UI Requirements

The UI must be mobile-first and responsive.

It should provide:

- Large touch-friendly buttons
- Camera-based receipt capture
- Image preview
- Clear validation errors
- Minimal mandatory typing
- Responsive denomination-entry controls
- Accessible form labels
- Loading indicators during OCR processing
- Clear matched, shortage and excess status indicators
- No mandatory horizontal scrolling for primary mobile workflows

The system should work on supported modern versions of:

- Google Chrome
- Microsoft Edge
- Mobile Chrome
- Other browsers approved by the client

---

## 42. Performance Requirements

Initial performance expectations:

- Standard pages should load within an acceptable response time under normal network conditions.
- Saving ordinary entries should complete within a few seconds.
- OCR processing may take longer and should display progress or processing status.
- Long-running OCR operations should not freeze the browser.
- The system should support multiple concurrent users.

Detailed capacity and response-time targets must be confirmed before production deployment.

---

## 43. Reliability Requirements

The application should:

- Use database transactions for critical operations
- Prevent duplicate submission
- Prevent accidental overwrite of another user's changes
- Preserve completed transaction history
- Log technical errors
- Display user-friendly error messages
- Support retry of failed OCR processing
- Avoid data loss when validation fails

---

## 44. Data Precision Requirements

All monetary calculations must use precise decimal arithmetic.

The system must not use binary floating-point types for:

- Money
- Fuel volume
- Fuel price
- Reconciliation difference

Suggested precision:

```text
Money and ATOT         2 decimal places
Fuel volume and VTOT   3 decimal places
Fuel price             Up to 3 decimal places
OCR confidence         2 decimal places
```

Final scales and rounding rules should be confirmed with the client.

---

## 45. Database Requirements

PostgreSQL will be the production database.

The database must support:

- Master-data history
- Transaction records
- Shift data
- Receipt metadata
- OCR output
- Manual corrections
- Payment collections
- Credit sales
- Adjustments
- Reconciliation versions
- Approval history
- Audit events
- Generated report metadata

Database changes will be version-controlled using schema migrations.

---

## 46. Deployment Requirements

The initial deployment will use a centralized server model.

Users will access the application through a browser.

The deployment may contain:

- React frontend
- Spring Boot backend
- PostgreSQL database
- Receipt file storage
- HTTPS reverse proxy

Possible deployment locations include:

- Company office server
- Company data centre
- Cloud virtual machine
- Containerized environment

The final hosting environment must be confirmed by the client.

---

## 47. Backup and Recovery

The production solution must include:

- PostgreSQL database backup
- Receipt-file backup
- Backup-retention policy
- Restore procedure
- Periodic restore testing
- Disaster-recovery responsibilities

Database backup without receipt-image backup is incomplete.

---

## 48. Out-of-Scope Items for Initial Release

Unless explicitly approved, the following may be treated as future enhancements:

- Native Android application
- Native iOS application
- Offline synchronization
- Automatic UPI settlement integration
- Automatic card-terminal integration
- ERP integration
- Bank reconciliation
- Tank inventory reconciliation
- Credit-customer settlement module
- SMS notifications
- Email notifications
- Multi-language interface
- AI-based fraud detection
- Advanced analytics
- Automatic fuel-price synchronization

---

## 49. Future Enhancements

The architecture should support future capabilities such as:

- Multiple organizations
- Multiple station chains
- Additional fuel types
- Multiple dispenser units per shift
- Offline mobile receipt capture
- Native mobile application
- Object-storage integration
- ERP and accounting integration
- Payment-gateway integration
- Bank deposit verification
- Credit settlement
- Tank stock reconciliation
- Multi-level approval
- Notification services
- Dashboard analytics
- Machine-learning-based OCR correction

---

## 50. Client Decisions Required

The following points require client confirmation:

1. Can a shift contain one dispenser unit only, or multiple dispenser units?
2. Can one employee work across more than one dispenser unit in the same shift?
3. Should UPI be entered as one total or as individual transactions?
4. Should card collections be entered as one total or as individual transactions?
5. Is credit-customer settlement included in the first release?
6. Which expense and adjustment types require manager approval?
7. How many approval levels are required?
8. What reconciliation tolerance is allowed?
9. Is tolerance configured by organization, station or shift?
10. What rounding rules should be used for fuel and money?
11. What receipt-image formats and maximum sizes are allowed?
12. How long should receipt images be retained?
13. How long should audit records be retained?
14. Can submitted shifts be edited before approval?
15. Can approved shifts ever be reopened?
16. Which browsers and mobile devices must be supported?
17. Where will the production application be hosted?
18. How many stations, users and shifts are expected initially?
19. Is multi-organization support required in the first release?
20. Are notifications required in the first release?
21. Should shortage or excess require mandatory employee remarks?
22. Should the application allow cash deposits made during the shift?
23. Should fuel testing and calibration quantities be recorded separately from financial adjustments?
24. Should reports require digital approval or signature?
25. Should receipt OCR data be editable only by supervisors, or also by employees?

---

## 51. Acceptance Summary

The initial system will be considered functionally successful when it can:

1. Configure stations, dispenser units, nozzles, employees and assignments.
2. Open an operational shift.
3. Upload Start and End Electronic Totalizer receipts.
4. Extract and confirm DU Serial Number, ATOT and VTOT values.
5. Calculate nozzle-wise quantity and sales amount.
6. Allocate sales to employees.
7. Capture cash denominations.
8. Capture UPI, card and credit collections.
9. Capture expenses and approved adjustments.
10. Calculate employee-level reconciliation.
11. Calculate shift-level reconciliation.
12. Identify matched, shortage and excess results.
13. Submit and approve the reconciliation.
14. Generate a reconciliation report.
15. Retain a complete audit history.

---

## 52. Client Approval

### Client name

```text
To be confirmed
```

### Reviewed by

```text
To be confirmed
```

### Review date

```text
To be confirmed
```

### Approval status

```text
DRAFT / REVIEWED / APPROVED
```

### Comments

```text
To be completed during client review
```