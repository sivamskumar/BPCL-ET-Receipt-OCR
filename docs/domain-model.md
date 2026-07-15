# Fuel Station Shift Reconciliation System
## Domain Model

## 1. Purpose

This document defines the core business model for the Fuel Station Shift Reconciliation System.

The domain model represents the real-world fuel station workflow:

- Fuel station and dispenser configuration
- Employee and nozzle assignments
- Shift opening and closing
- Start and end receipt processing
- Nozzle-wise fuel sales calculation
- Payment and adjustment capture
- Employee-wise and shift-wise reconciliation
- Approval and audit tracking

The domain model must remain independent of:

- Spring Boot controllers
- React components
- PostgreSQL-specific implementation
- OCR libraries
- File-system implementation
- Reporting libraries

---

## 2. Domain-Driven Design Approach

The application will use Domain-Driven Design principles.

The domain will be divided into bounded business areas:

```text
Station Management
Employee Management
Shift Management
Receipt Processing
Sales Calculation
Payment Management
Adjustment Management
Reconciliation
Reporting and Audit
Security
```

Each business area may contain:

```text
domain
application
infrastructure
presentation
```

The domain layer contains the business rules and must use plain Java wherever possible.

---

## 3. Aggregate Overview

The principal aggregate roots are:

```text
FuelStation
Employee
Shift
Reconciliation
ApplicationUser
```

Other entities and value objects belong to these aggregate roots.

```text
FuelStation
├── DispenserUnit
│   └── Nozzle
└── NozzleAssignment

Shift
├── ShiftEmployee
├── Receipt
│   └── ReceiptReading
├── Payment
├── CashDenominationEntry
├── CreditSale
├── Adjustment
└── FuelSale

Reconciliation
├── EmployeeReconciliation
└── ReconciliationLine
```

---

# 4. Shared Value Objects

## 4.1 Identifier value objects

Each principal entity should use a strongly typed identifier instead of exposing raw database numbers throughout the domain.

Examples:

```text
FuelStationId
DispenserUnitId
NozzleId
EmployeeId
ShiftId
ReceiptId
PaymentId
AdjustmentId
ReconciliationId
UserId
```

Example conceptual Java representation:

```java
public record EmployeeId(Long value) {

    public EmployeeId {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be positive");
        }
    }
}
```

Database-generated identifiers may remain unavailable until persistence.

---

## 4.2 Money

Represents a monetary amount.

Properties:

```text
amount
currency
```

Rules:

- Must use `BigDecimal`
- Currency should initially be INR
- Scale should normally be 2
- Rounding mode must be explicitly defined
- Null amounts are not allowed

Example:

```text
Money(1250.50, INR)
```

Operations:

```text
add
subtract
multiply
absoluteValue
compareTo
isPositive
isNegative
isZero
```

---

## 4.3 FuelVolume

Represents fuel quantity in litres.

Properties:

```text
litres
```

Rules:

- Must use `BigDecimal`
- Recommended scale: 3
- Negative values are not valid for recorded readings
- Calculated differences may only be negative when validation fails

Example:

```text
FuelVolume(125.750 litres)
```

---

## 4.4 FuelPrice

Represents price per litre.

Properties:

```text
fuelType
pricePerLitre
effectiveFrom
effectiveTo
```

Rules:

- Must use `BigDecimal`
- Must be greater than zero
- Effective periods must not overlap for the same station and fuel type
- One active price must exist for every fuel type used in a shift

---

## 4.5 DuSerialNumber

Represents the DU serial number printed on the totalizer receipt.

Rules:

- Cannot be blank
- Must be normalized before comparison
- Start and end receipts must have the same normalized DU serial number
- Must uniquely identify a configured dispenser unit

Possible normalization:

```text
Trim whitespace
Convert to uppercase
Remove known OCR separators where safe
Preserve significant letters and digits
```

---

## 4.6 NozzleNumber

Represents a nozzle position on a dispenser unit.

Rules:

- Must be positive
- Must be unique within one dispenser unit
- Current stations are expected to contain four nozzles
- The model should not permanently limit the system to four nozzles

---

## 4.7 BusinessDate

Represents the operational date of a shift.

A business date may differ from the calendar date if a shift crosses midnight.

Rules:

- Must be present
- Used for price selection
- Used for nozzle-assignment selection
- Used for reporting and reconciliation

---

## 4.8 Percentage

Used for OCR confidence or future percentage-based settings.

Rules:

- Must use `BigDecimal`
- Valid range: 0 to 100

---

## 4.9 FileHash

Represents the SHA-256 hash of an uploaded receipt.

Purpose:

- Duplicate upload detection
- File integrity
- Audit tracking

---

# 5. Enumerations

## 5.1 FuelType

```text
PETROL
DIESEL
```

Future values may include:

```text
PREMIUM_PETROL
PREMIUM_DIESEL
CNG
LPG
```

The system must not assume only two fuel types at infrastructure level.

---

## 5.2 ReceiptType

```text
START
END
```

---

## 5.3 ReceiptProcessingStatus

```text
UPLOADED
VALIDATING_IMAGE
IMAGE_VALIDATED
PREPROCESSING
OCR_IN_PROGRESS
OCR_COMPLETED
PARSING
PARSED
REVIEW_REQUIRED
CONFIRMED
FAILED
REJECTED
```

---

## 5.4 ShiftStatus

```text
OPEN
START_RECEIPT_UPLOADED
END_RECEIPT_UPLOADED
OCR_COMPLETED
READINGS_CONFIRMED
PAYMENTS_ENTERED
RECONCILED
SUBMITTED
APPROVED
CLOSED
CANCELLED
```

---

## 5.5 PaymentType

```text
CASH
UPI
CARD
CREDIT
```

Future values may include:

```text
BANK_TRANSFER
WALLET
VOUCHER
```

---

## 5.6 AdjustmentType

```text
EXPENSE
CASH_DEPOSIT
FUEL_TESTING
CALIBRATION
FUEL_RETURN
OTHER
```

---

## 5.7 AdjustmentDirection

```text
ADD_TO_ACCOUNTED_AMOUNT
DEDUCT_FROM_ACCOUNTED_AMOUNT
```

The direction must be explicit. The sign of an amount must not be used alone to infer business meaning.

---

## 5.8 ReconciliationStatus

```text
PENDING
MATCHED
SHORTAGE
EXCESS
PENDING_REVIEW
SUBMITTED
APPROVED
REJECTED
```

---

## 5.9 UserRole

```text
EMPLOYEE
SUPERVISOR
MANAGER
ADMINISTRATOR
AUDITOR
```

---

# 6. Station Management Domain

## 6.1 FuelStation — Aggregate Root

Represents a physical fuel station.

Properties:

```text
fuelStationId
stationCode
stationName
address
active
dispenserUnits
```

Rules:

- Station code must be unique
- Station name cannot be blank
- An inactive station cannot open a new shift
- A station may have one or more dispenser units

Responsibilities:

- Register dispenser units
- Activate or deactivate station
- Validate station-level configuration

---

## 6.2 DispenserUnit — Entity

Represents a pumping or dispensing unit identified by DU Serial Number.

Properties:

```text
dispenserUnitId
fuelStationId
duSerialNumber
displayName
active
nozzles
```

Rules:

- DU serial number must be unique across active dispenser units
- Inactive dispenser units cannot be selected for new shifts
- A dispenser unit must have at least one nozzle

---

## 6.3 Nozzle — Entity

Represents one nozzle point.

Properties:

```text
nozzleId
dispenserUnitId
nozzleNumber
fuelType
active
```

Rules:

- Nozzle number must be unique within the dispenser unit
- Fuel type must be configured
- Inactive nozzles must not participate in new shifts
- A nozzle belongs to exactly one dispenser unit

---

## 6.4 NozzleAssignment — Entity

Maps a nozzle to an employee for an effective period.

Properties:

```text
nozzleAssignmentId
nozzleId
employeeId
effectiveFrom
effectiveTo
active
```

Rules:

- One nozzle cannot be assigned to multiple employees for overlapping periods
- Effective date range must be valid
- The employee and nozzle must both be active
- Historical assignments must be retained
- Assignment used for reconciliation is determined by shift business date

Example:

```text
Nozzle 1 → Sujith → Petrol
Nozzle 2 → Sujith → Diesel
Nozzle 3 → Sonu   → Petrol
Nozzle 4 → Sonu   → Diesel
```

The example is configuration data, not a hardcoded business rule.

---

# 7. Employee Domain

## 7.1 Employee — Aggregate Root

Represents an employee responsible for nozzle operations and collection entry.

Properties:

```text
employeeId
employeeCode
employeeName
mobileNumber
active
```

Rules:

- Employee code must be unique
- Employee name cannot be blank
- Inactive employees cannot be assigned to new shifts
- Historical shift records must retain employee identity

Responsibilities:

- Maintain employee profile
- Activate or deactivate employee
- Participate in nozzle assignments and shifts

---

# 8. Shift Management Domain

## 8.1 Shift — Aggregate Root

Represents one operational shift at one dispenser unit.

Properties:

```text
shiftId
fuelStationId
dispenserUnitId
businessDate
startedAt
endedAt
status
employees
startReceipt
endReceipt
fuelSales
payments
cashDenominations
creditSales
adjustments
```

Rules:

- A shift belongs to one fuel station and one dispenser unit
- A shift must have one business date
- A shift can have only one confirmed start receipt
- A shift can have only one confirmed end receipt
- Start and end receipts must refer to the same DU serial number
- End readings must not be lower than start readings
- Payment entry cannot be finalized before readings are confirmed
- Reconciliation cannot be finalized before payment entry
- A closed shift cannot be modified except through an authorized correction process

Responsibilities:

```text
open shift
attach start receipt
attach end receipt
confirm readings
calculate fuel sales
record payments
record adjustments
perform reconciliation
submit
approve
close
cancel
```

---

## 8.2 ShiftEmployee — Entity

Represents an employee participating in a shift.

Properties:

```text
shiftEmployeeId
shiftId
employeeId
assignedNozzles
```

Purpose:

- Preserve the employee assignments used for that shift
- Prevent later master-data changes from altering historical results

Rules:

- Employee must have at least one assigned nozzle for the shift
- A nozzle may belong to only one employee in a shift
- Snapshot assignments should be retained after shift creation

---

# 9. Receipt Processing Domain

## 9.1 Receipt — Entity

Represents one uploaded Electronic Totalizer receipt.

Properties:

```text
receiptId
shiftId
receiptType
duSerialNumber
receiptDateTime
originalFilename
storagePath
contentType
fileSize
fileHash
ocrRawText
ocrConfidence
processingStatus
readings
manualCorrectionApplied
uploadedBy
uploadedAt
```

Rules:

- Receipt type must be START or END
- File hash must be checked for duplicate upload
- DU serial number must be present after processing
- Receipt must contain required nozzle readings
- A receipt requiring review cannot be automatically confirmed
- Manual correction must be audited

---

## 9.2 ReceiptReading — Entity

Represents readings for one nozzle on one receipt.

Properties:

```text
receiptReadingId
receiptId
nozzleNumber
atot
vtot
ecalFactor
ocrConfidence
manuallyCorrected
originalAtotText
originalVtotText
```

Rules:

- Nozzle number must be unique within a receipt
- ATOT and VTOT must use `BigDecimal`
- Values cannot be negative
- Confidence below configured threshold must trigger review
- Corrected values must preserve original OCR values for audit

---

## 9.3 OcrResult — Value Object

Represents OCR processing output.

Properties:

```text
rawText
averageConfidence
fieldResults
processingDuration
warnings
```

A field result may include:

```text
fieldName
recognizedText
normalizedText
confidence
boundingRegion
```

---

## 9.4 ReceiptImage — Value Object

Properties:

```text
originalFilename
contentType
fileSize
storagePath
fileHash
```

Rules:

- Must be an allowed image type
- Must remain within configured size limit
- Must pass minimum resolution checks
- Duplicate hashes may be rejected or flagged

---

# 10. Sales Domain

## 10.1 FuelSale — Entity

Represents calculated sales for one nozzle during one shift.

Properties:

```text
fuelSaleId
shiftId
employeeId
nozzleId
fuelType
startAtot
endAtot
startVtot
endVtot
quantitySold
receiptAmountDifference
pricePerLitre
calculatedSalesAmount
amountVariance
```

Calculations:

```text
Quantity Sold = End VTOT - Start VTOT
```

```text
Receipt Amount Difference = End ATOT - Start ATOT
```

```text
Calculated Sales Amount =
    Quantity Sold × Price Per Litre
```

```text
Amount Variance =
    Receipt Amount Difference - Calculated Sales Amount
```

Rules:

- End readings must be greater than or equal to start readings
- Fuel price must be effective for the shift business date
- Amount variance must be compared against configured tolerance
- Calculation inputs and results must be retained for audit

---

## 10.2 EmployeeFuelSalesSummary — Value Object

Properties:

```text
employeeId
petrolQuantity
dieselQuantity
totalQuantity
petrolAmount
dieselAmount
expectedSalesAmount
```

The design must support additional fuel types without changing the reconciliation formula.

A map-based internal representation may be used:

```text
FuelType → Quantity
FuelType → Amount
```

---

# 11. Payment Domain

## 11.1 Payment — Entity

Represents a non-denomination collection entry.

Properties:

```text
paymentId
shiftId
employeeId
paymentType
amount
referenceNumber
remarks
enteredBy
enteredAt
```

Rules:

- Amount must be greater than or equal to zero
- Payment type must not be CASH when detailed denomination entry is used
- UPI and card entries should support reference details
- Credit sales should support customer information in future
- Payments must belong to an employee participating in the shift

---

## 11.2 CashDenominationEntry — Entity

Represents a count for one currency denomination.

Properties:

```text
cashDenominationEntryId
shiftId
employeeId
denominationValue
quantity
calculatedAmount
```

Calculation:

```text
Calculated Amount =
    Denomination Value × Quantity
```

Rules:

- Denomination value must be positive
- Quantity must be a non-negative whole number
- Calculated amount must be derived, not manually entered
- Duplicate denomination rows for the same employee and shift are not allowed

Suggested initial denominations:

```text
500
200
100
50
20
10
5
2
1
```

The available denomination list should be configurable.

---

## 11.3 CreditSale — Entity

Represents a credit transaction.

Properties:

```text
creditSaleId
shiftId
employeeId
customerName
customerReference
amount
remarks
enteredAt
```

Rules:

- Amount must be positive
- Customer or credit reference should be captured
- Credit entries should remain available for later settlement tracking

---

## 11.4 PaymentSummary — Value Object

Properties:

```text
cashTotal
upiTotal
cardTotal
creditTotal
totalCollections
```

Calculation:

```text
Total Collections =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Total
```

---

# 12. Adjustment Domain

## 12.1 Adjustment — Entity

Represents an approved financial or operational adjustment.

Properties:

```text
adjustmentId
shiftId
employeeId
adjustmentType
direction
amount
description
referenceNumber
approvedBy
occurredAt
createdBy
```

Rules:

- Amount must be positive
- Direction determines whether amount is added or deducted
- Description is mandatory
- Approval may be mandatory depending on adjustment type
- Adjustments cannot silently alter original fuel sales

Examples:

```text
Expense
Cash deposit
Fuel testing
Calibration usage
Fuel return
Other approved correction
```

---

## 12.2 AdjustmentSummary — Value Object

Properties:

```text
positiveAdjustmentTotal
deductibleExpenseTotal
netAdjustment
```

Calculation:

```text
Net Adjustment =
    Positive Adjustment Total
  - Deductible Expense Total
```

---

# 13. Reconciliation Domain

## 13.1 Reconciliation — Aggregate Root

Represents the final accounting comparison for one shift.

Properties:

```text
reconciliationId
shiftId
expectedSalesAmount
cashTotal
upiTotal
cardTotal
creditTotal
positiveAdjustmentTotal
expenseTotal
accountedAmount
differenceAmount
allowedTolerance
status
calculatedAt
submittedAt
approvedAt
approvedBy
remarks
employeeReconciliations
```

Calculation:

```text
Accounted Amount =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Total
  + Positive Adjustment Total
  - Expense Total
```

```text
Difference Amount =
    Accounted Amount
  - Expected Sales Amount
```

Status rule:

```text
Absolute Difference <= Allowed Tolerance
    → MATCHED

Difference < -Allowed Tolerance
    → SHORTAGE

Difference > Allowed Tolerance
    → EXCESS
```

Rules:

- Reconciliation must be reproducible from source data
- Calculated values must not be manually overwritten
- A recalculation must create audit history
- Approval must record user and timestamp
- Closed reconciliation records are immutable except through controlled correction

---

## 13.2 EmployeeReconciliation — Entity

Represents reconciliation for one employee within a shift.

Properties:

```text
employeeReconciliationId
reconciliationId
employeeId
expectedSalesAmount
cashTotal
upiTotal
cardTotal
creditTotal
adjustmentTotal
accountedAmount
differenceAmount
status
```

This supports employees such as Sujith and Sonu being reconciled independently.

Shift reconciliation is the sum of all employee reconciliations.

Rules:

- Each participating employee must have one reconciliation record
- Employee totals must sum to shift-level totals
- Nozzle sales must be allocated only to the assigned employee

---

# 14. Security Domain

## 14.1 ApplicationUser — Aggregate Root

Represents an authenticated system user.

Properties:

```text
userId
username
passwordHash
displayName
active
roles
employeeId
lastLoginAt
```

Rules:

- Username must be unique
- Password must never be stored in plain text
- An employee user may be linked to an Employee record
- Inactive users cannot authenticate
- Authorization is determined by assigned roles

---

# 15. Audit Domain

## 15.1 AuditEvent — Entity

Properties:

```text
auditEventId
userId
action
entityType
entityIdentifier
oldValue
newValue
occurredAt
ipAddress
```

Examples of audited actions:

```text
SHIFT_OPENED
RECEIPT_UPLOADED
OCR_COMPLETED
READING_CORRECTED
PAYMENT_ENTERED
ADJUSTMENT_ADDED
RECONCILIATION_CALCULATED
RECONCILIATION_APPROVED
SHIFT_CLOSED
```

---

## 15.2 ManualCorrection — Entity

Properties:

```text
manualCorrectionId
receiptId
receiptReadingId
fieldName
originalValue
correctedValue
reason
correctedBy
correctedAt
```

Rules:

- Original value must be preserved
- Correction reason is mandatory
- Correction user and timestamp are mandatory
- Corrections must never silently replace OCR data

---

# 16. Aggregate Boundaries

## FuelStation aggregate

Owns:

```text
FuelStation
DispenserUnit
Nozzle
```

Nozzle assignments may be managed through a dedicated assignment service because they reference Employee.

---

## Employee aggregate

Owns:

```text
Employee
```

Historical nozzle and shift references are maintained outside the aggregate.

---

## Shift aggregate

Owns:

```text
Shift
ShiftEmployee
Receipt
ReceiptReading
FuelSale
Payment
CashDenominationEntry
CreditSale
Adjustment
```

Because this aggregate may become large, persistence implementations may store child entities separately while maintaining domain consistency through application services.

---

## Reconciliation aggregate

Owns:

```text
Reconciliation
EmployeeReconciliation
```

The reconciliation aggregate references a completed Shift by identifier and reads immutable shift calculation inputs.

---

# 17. Domain Services

Some business logic does not naturally belong to one entity.

Suggested domain services:

## FuelSalesCalculator

Responsibilities:

```text
Compare start and end readings
Calculate quantity sold
Calculate receipt amount difference
Apply effective fuel price
Calculate sales amount
Calculate amount variance
```

---

## NozzleAssignmentResolver

Responsibilities:

```text
Resolve employee assignment for nozzle
Use shift business date
Reject overlapping assignments
Create assignment snapshot for shift
```

---

## PaymentSummaryCalculator

Responsibilities:

```text
Calculate cash denomination total
Aggregate UPI payments
Aggregate card payments
Aggregate credit sales
```

---

## AdjustmentCalculator

Responsibilities:

```text
Aggregate positive adjustments
Aggregate deductible expenses
Calculate net adjustment
```

---

## ReconciliationCalculator

Responsibilities:

```text
Calculate expected amount
Calculate accounted amount
Calculate difference
Apply tolerance
Determine status
Build employee and shift summaries
```

---

## ReceiptValidationService

Responsibilities:

```text
Validate matching DU serial numbers
Validate required nozzle readings
Validate start/end sequence
Validate decreasing readings
Validate duplicate receipt
Validate OCR confidence
```

---

# 18. Application Services

Suggested application services:

```text
FuelStationApplicationService
EmployeeApplicationService
NozzleAssignmentApplicationService
ShiftApplicationService
ReceiptUploadApplicationService
ReceiptProcessingApplicationService
ReadingConfirmationApplicationService
PaymentEntryApplicationService
AdjustmentApplicationService
ReconciliationApplicationService
ApprovalApplicationService
ReportApplicationService
```

Application services orchestrate use cases but must delegate business calculations to domain objects or domain services.

---

# 19. Repository Interfaces

Suggested domain repository interfaces:

```text
FuelStationRepository
DispenserUnitRepository
EmployeeRepository
NozzleAssignmentRepository
ShiftRepository
ReceiptRepository
FuelPriceRepository
PaymentRepository
AdjustmentRepository
ReconciliationRepository
ApplicationUserRepository
AuditEventRepository
```

Repository interfaces belong to the domain or application layer.

Database implementations belong to infrastructure.

---

# 20. Important Domain Invariants

The following rules must always hold:

1. A shift references one station and one dispenser unit.
2. Start and end receipts belong to the same shift.
3. Start and end receipts have the same DU serial number.
4. A receipt contains at most one reading for each nozzle number.
5. End ATOT cannot be lower than Start ATOT.
6. End VTOT cannot be lower than Start VTOT.
7. Each nozzle is assigned to only one employee for a shift.
8. Fuel price exists for every sold fuel type.
9. Monetary and volume calculations use `BigDecimal`.
10. Cash totals are derived from denomination values and quantities.
11. Reconciliation values are derived from source transactions.
12. Manual corrections retain original OCR values.
13. Approved and closed records cannot be silently modified.
14. All significant operations are audited.

---

# 21. Example Shift Scenario

## Station configuration

```text
Station: Central Fuel Station
DU Serial Number: DU-10001
```

## Nozzle assignment

| Nozzle | Employee | Fuel Type |
|---:|---|---|
| 1 | Sujith | Petrol |
| 2 | Sujith | Diesel |
| 3 | Sonu | Petrol |
| 4 | Sonu | Diesel |

## Receipt calculation

```text
Nozzle 1 Quantity =
    End VTOT - Start VTOT

Nozzle 1 Amount =
    Quantity × Petrol Price
```

The same calculation is performed for all nozzles.

## Employee calculation

```text
Sujith Expected Amount =
    Nozzle 1 Petrol Amount
  + Nozzle 2 Diesel Amount
```

```text
Sonu Expected Amount =
    Nozzle 3 Petrol Amount
  + Nozzle 4 Diesel Amount
```

## Accounted collection

```text
Employee Accounted Amount =
    Cash
  + UPI
  + Card
  + Credit
  + Positive Adjustments
  - Expenses
```

## Result

```text
Difference =
    Accounted Amount
  - Expected Amount
```

The employee result is classified as:

```text
MATCHED
SHORTAGE
EXCESS
```

The shift-level result is calculated from the employee-level results.

---

# 22. Future Domain Extensions

The model should allow future support for:

- Multiple shifts per business date
- Multiple dispenser units per station
- Additional fuel types
- Tank inventory reconciliation
- Credit customer management
- Payment settlement tracking
- Bank deposit verification
- Multi-level approval
- Multi-organization tenancy
- Offline mobile receipt capture
- Automated price synchronization
- ERP and accounting integration