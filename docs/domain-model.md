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
Incoming Fuel Stock Management
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
IncomingFuelInvoice
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
│   └── EmployeeShiftHours
├── Receipt
│   └── ReceiptReading
├── Payment
├── CashDenominationEntry
├── CoinsEntry
├── CreditSale
├── Adjustment
└── FuelSale

Reconciliation
├── EmployeeReconciliation
└── ReconciliationLine

IncomingFuelInvoice
├── IncomingFuelInvoiceItem
├── IncomingFuelInvoiceDocument
└── IncomingFuelInvoiceOcrResult

FuelStation
│
├── DispenserUnit
│   └── Nozzle
│
├── Shift
│
└── IncomingFuelInvoice
    ├── IncomingFuelInvoiceDocument
    ├── IncomingFuelInvoiceItem [1..n]
    ├── IncomingFuelInvoiceOcrResult
    └── IncomingFuelInvoiceReview
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
IncomingFuelInvoiceId
IncomingFuelInvoiceItemId
IncomingFuelInvoiceDocumentId
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

## 4.10 AadhaarNumber

Represents the Aadhaar Number associated with an employee profile.

Rules:

- Must be treated as sensitive personal information.
- Must not be written to ordinary application logs.
- Full value must only be exposed to appropriately authorized users.
- Masked representation should be used where full disclosure is unnecessary.
- Storage and protection must follow the approved security design.
- Validation rules shall follow the applicable business and regulatory requirements.

Example masked representation:

```text
XXXX XXXX 1234
```

---

## 4.11 InvoiceNumber

Represents the business invoice number associated with an incoming fuel delivery.

Properties:

```text
value
```

Rules:

- Cannot be blank.
- Leading and trailing whitespace shall be removed.
- The original business representation shall be preserved.
- Duplicate handling shall follow station, supplier and business-date rules defined during detailed design.
- Invoice Number shall be available before an incoming fuel invoice can be confirmed.

Example:

```text
1352393838
```

---

## 4.12 UnitOfMeasurement

Represents the unit in which an incoming fuel quantity is expressed.

Initial examples:

```text
KL
LITRE
```

Rules:

- The original invoice unit should be retained where available.
- Conversion rules, where required, shall be explicit.
- Quantity shall not silently change unit during OCR processing.

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

## 5.10 EmployeeStatus

Represents the current employment state of an employee.

```text
ACTIVE
INACTIVE
LEFT
```

Rules:

- ACTIVE employees may participate in new operational activities subject to valid assignments.
- INACTIVE employees must not participate in new shifts or receive new nozzle assignments until reactivated.
- LEFT employees must not participate in new shifts or receive new nozzle assignments.
- Historical shift records must retain employee identityLEFT employees must have a Date of Leaving.
- Historical information must remain available regardless of the employee's current status.

---

## 5.11 EmployeeShiftHoursStatus

```text
STARTED
COMPLETED
CORRECTED
```
Meaning:

- STARTED — Employee working period has begun but has not yet ended.
- COMPLETED — Employee working period contains valid start and end date/time.
- CORRECTED — A completed working period has subsequently been corrected through an authorized process.

---

## 5.12 IncomingFuelInvoiceStatus

Represents the lifecycle of an incoming fuel invoice.

```text
DRAFT
UPLOADED
OCR_PROCESSING
OCR_COMPLETED
REVIEW_REQUIRED
CONFIRMED
FAILED
CANCELLED
```

Meaning:

- `DRAFT` — Invoice capture has started but is not yet submitted.
- `UPLOADED` — Source invoice document has been stored.
- `OCR_PROCESSING` — OCR processing is in progress.
- `OCR_COMPLETED` — OCR processing finished successfully.
- `REVIEW_REQUIRED` — Extracted information requires user verification.
- `CONFIRMED` — Authorized user has verified and confirmed the invoice.
- `FAILED` — OCR processing or invoice processing failed.
- `CANCELLED` — Invoice processing was intentionally cancelled.

Rules:

- OCR completion shall not automatically imply confirmation.
- Only reviewed invoice data may become CONFIRMED.
- CONFIRMED invoices shall follow controlled correction rules.

---

## 5.13 IncomingFuelInvoiceReviewStatus

```text
PENDING
IN_REVIEW
CORRECTED
CONFIRMED
REJECTED
```

Rules:

- `PENDING` means review has not started.
- `IN_REVIEW` means an authorized user is verifying extracted values.
- `CORRECTED` means one or more extracted values were changed.
- `CONFIRMED` means the reviewed values are accepted as business data.
- `REJECTED` means the invoice requires replacement or cannot be accepted.

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

Represents an employee who participates in fuel-station operations and whose employment profile is maintained by the organization.

Properties:

```text
employeeId
employeeCode
employeeName
mobileNumber
aadhaarNumber
address
photographReference
dateOfJoining
dateOfLeaving
employmentStatus
```

Rules:

- Employee code must be unique within the organization.
- Employee name cannot be blank.
- Date of Joining is mandatory.
- Date of Leaving is optional while the employee is ACTIVE.
- Date of Leaving cannot be earlier than Date of Joining.
- An employee with status LEFT must have a Date of Leaving.
- INACTIVE employees cannot participate in new shifts or receive new nozzle assignments.
- LEFT employees cannot participate in new shifts or receive new nozzle assignments.
- Historical employee information must remain available after an employee becomes INACTIVE or LEFT.
- Employee records referenced by historical business transactions must not be physically deleted through normal business operations.
- Aadhaar Number must be treated as sensitive personal information.
- Employee photograph access must follow employee-profile authorization rules.

Responsibilities:

```text
maintain employee profile
activate employee
deactivate employee
mark employee as left
validate employment dates
determine operational eligibility
```

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
cashDenominationEntries
coinsEntries
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

- Employee must be ACTIVE when added to a new shift.
- Employee must have at least one assigned nozzle for the shift where nozzle assignment is required.
- A nozzle may belong to only one employee in a shift.
- Snapshot assignments must be retained after shift creation.
- Later changes to the Employee master record must not alter historical shift participation.
- Employee working hours must be maintained independently from the overall operational shift start and end times.

---

## 8.3 EmployeeShiftHours — Entity

Represents the actual recorded working period of one employee participating in an operational shift.

Properties:

```text
employeeShiftHoursId
shiftId
shiftEmployeeId
employeeId
startedAt
endedAt
totalDuration
status
remarks
```

Purpose:

- Record employee-specific working time.
- Allow employee working hours to differ from the overall operational shift duration.
- Support employee shift-hours reporting.
- Preserve historical working-hour information.

Calculation:

```text
Total Duration =
    Employee Shift End Date/Time
  - Employee Shift Start Date/Time
```

Rules:

- The employee must participate in the associated operational shift.
- Employee Shift Start Date and Time are mandatory when employee work begins.
- Employee Shift End Date and Time cannot precede Employee Shift Start Date and Time.
- Total Duration can only be finalized when both start and end date/time are available.
- Total Duration must be derived from start and end date/time.
- Working periods crossing midnight are valid.
- Employee working times do not have to equal the operational Shift start and end times.
- Changes to completed working-time records require authorization.
- Corrections must include a reason.
- Previous values must remain available through audit history.
- Historical working-hour records remain available when an employee later becomes INACTIVE or LEFT.

Responsibilities:

```text
start employee work period
end employee work period
calculate working duration
validate working period
apply authorized correction
```

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

# 10. Incoming Fuel Stock Domain

## 10.1 IncomingFuelInvoice — Aggregate Root

Represents one incoming fuel delivery invoice received by a fuel station.

The aggregate maintains invoice-level information separately from individual fuel-product items.

Properties:

```text
incomingFuelInvoiceId
fuelStationId
invoiceNumber
invoiceDate
invoiceTime
receivedDate
totalInvoiceAmount
status
sourceDocument
items
ocrResult
confirmedBy
confirmedAt
createdBy
createdAt
lastUpdatedBy
lastUpdatedAt
```

Optional information may include:

```text
shipmentDocumentNumber
deliveryNumber
transportInformation
```

These optional fields remain subject to final client confirmation.

Rules:

- Fuel Station is mandatory.
- Invoice Number is mandatory before confirmation.
- Invoice Date is mandatory before confirmation.
- A confirmed invoice must contain at least one valid product item.
- OCR-extracted values shall not become authoritative until reviewed and confirmed.
- The original source document must remain associated with the invoice.
- Confirmed invoice data shall not be silently changed.
- Corrections to confirmed data must be authorized and auditable.
- Incoming fuel invoices are independent of operational Shift reconciliation.
- Historical invoices must remain available according to the retention policy.

Responsibilities:

```text
attach source invoice
start OCR processing
record OCR result
add invoice item
remove incorrect draft item
update extracted values
mark review required
confirm invoice
record authorized correction
cancel processing
```

---

## 10.2 IncomingFuelInvoiceItem — Entity

Represents one product line belonging to an incoming fuel invoice.

Properties:

```text
incomingFuelInvoiceItemId
incomingFuelInvoiceId
productDescription
productCode
fuelType
quantity
unitOfMeasurement
ratePerUnit
productValue
taxOrOtherCharges
```

Rules:

- Every item belongs to exactly one IncomingFuelInvoice.
- Product Description is mandatory before confirmation.
- Quantity is mandatory before confirmation.
- Quantity must be greater than zero.
- Unit of Measurement should be retained where provided by the invoice.
- Product Code should be retained where available.
- Fuel Type should be resolved where the product can be mapped to a configured fuel type.
- Rate Per Unit must use precise decimal arithmetic.
- Product Value must use Money.
- Tax or Other Charges may be retained where the client requires them.
- OCR-extracted values remain editable until invoice confirmation.
- Corrections after confirmation require authorization and audit history.

Example:

```text
Product Description : MS
Product Code        : 32420
Quantity            : 15
Unit                : KL
Rate Per Unit       : 81374.42
Product Value       : 1220616.33
```

Another item in the same invoice may represent Diesel or another configured product.

---

## 10.3 IncomingFuelInvoiceDocument — Entity

Represents the original uploaded or photographed invoice used for OCR-assisted incoming fuel stock entry.

Properties:

```text
incomingFuelInvoiceDocumentId
incomingFuelInvoiceId
originalFilename
storedFilename
contentType
fileSize
storagePath
fileHash
uploadedBy
uploadedAt
```

Rules:

- The original source document must remain unchanged during normal business correction.
- Supported file types and size limits shall follow application configuration.
- Stored physical filenames shall be generated safely.
- File hash may be used for duplicate detection.
- Document access must follow organization and station authorization.
- Source invoice documents must not be publicly accessible.
- Replacing a document shall be auditable.

---

## 10.4 IncomingFuelInvoiceOcrResult — Entity

Represents OCR processing output for an incoming fuel invoice.

Properties:

```text
incomingFuelInvoiceOcrResultId
incomingFuelInvoiceId
rawText
averageConfidence
processingStatus
processingStartedAt
processingCompletedAt
processingDuration
headerFieldResults
itemFieldResults
warnings
failureReason
```

Purpose:

- Preserve the original machine-extracted information.
- Distinguish OCR output from user-confirmed business data.
- Support review and audit.
- Support OCR quality improvement later.

Rules:

- OCR output shall not directly overwrite confirmed invoice data.
- Original recognized text must remain available.
- Low-confidence or missing required values must trigger review.
- Multiple processing attempts may be retained where required.
- OCR failure must not delete the source invoice document.

---

## 10.5 InvoiceOcrFieldResult — Value Object

Represents one field extracted from an incoming fuel invoice.

Properties:

```text
fieldName
recognizedText
normalizedValue
confidence
pageOrRegion
reviewRequired
```

Examples:

```text
INVOICE_NUMBER
INVOICE_DATE
INVOICE_TIME
PRODUCT_DESCRIPTION
PRODUCT_CODE
QUANTITY
UNIT
RATE_PER_UNIT
PRODUCT_VALUE
TOTAL_INVOICE_AMOUNT
```

Rules:

- Original recognized text must be preserved.
- Normalized value may differ from raw OCR text.
- Confidence shall use the Percentage value object where applicable.
- Fields below the configured threshold may be marked for review.

---

## 10.6 IncomingFuelInvoiceReview — Entity

Represents an authorized review of OCR-extracted incoming fuel invoice information.

Properties:

```text
incomingFuelInvoiceReviewId
incomingFuelInvoiceId
reviewedBy
reviewedAt
reviewStatus
remarks
correctionsApplied
```

Purpose:

- Record that OCR-extracted information was reviewed.
- Preserve who performed the review.
- Support correction and confirmation traceability.

Rules:

- OCR-extracted information cannot become authoritative without review.
- Required fields must be valid before confirmation.
- Corrections made during review must remain traceable.
- Review shall not alter the original source invoice document.

---

# 11. Sales Domain

## 11.1 FuelSale — Entity

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

## 11.2 EmployeeFuelSalesSummary — Value Object

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

# 12. Payment Domain

## 12.1 Payment — Entity

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

## 12.2 CashDenominationEntry — Entity

Represents the quantity and calculated monetary amount for one supported currency-note denomination held by an employee during a shift.

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
    Denomination Value
  × Quantity
```

Rules:

- Denomination Value must be positive.
- Quantity must be a non-negative whole number.
- Calculated Amount must be derived and must not be manually entered.
- Duplicate denomination rows for the same employee and shift are not allowed.
- Only configured note denominations may be used.
- Individual ₹5, ₹2 and ₹1 coin denominations shall not be represented as CashDenominationEntry records.
- Historical denomination entries shall remain unchanged when denomination configuration changes.

Initial supported note denominations:

```text
500
200
100
50
20
10
```

The available note-denomination list should remain configurable.

---

## 12.3 CoinsEntry — Entity

Represents the consolidated monetary value of all coins held by an employee during a shift.

Properties:

```text
coinsEntryId
shiftId
employeeId
amount
enteredBy
enteredAt
```

Purpose:

- Avoid denomination-wise entry for ₹5, ₹2 and ₹1 coins.
- Record the total monetary value of all coins as one amount.
- Participate directly in the employee Cash Total.

Rules:

- Amount must use the Money value object.
- Amount must be zero or greater.
- The employee shall not be required to enter individual coin quantities.
- Only one active CoinsEntry shall exist for one employee and shift.
- The Coins amount is entered directly and is not calculated from denomination value and quantity.
- Changes before final submission may update the entry.
- Changes after protected workflow stages must follow the applicable correction and audit rules.

---

## 12.4 CreditSale — Entity

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

## 12.5 CashSummary — Value Object

Represents the calculated physical cash total for one employee and shift.

Properties:

```text
totalNotesAmount
coinsAmount
cashTotal
```

Calculation:

```text
Cash Total =
    Total Notes Amount
  + Coins Amount
```

Where:

```text
Total Notes Amount =
    Sum of all CashDenominationEntry calculated amounts
```

Rules:

- Total Notes Amount is derived from note-denomination entries.
- Coins Amount is taken from the employee's CoinsEntry.
- Cash Total must be derived and must not be manually overwritten.
- Missing cash categories may be interpreted according to the applicable collection-completeness rules.

---

## 12.6 PaymentSummary — Value Object

Represents the consolidated collection summary for one employee and shift.

Properties:

```text
cashSummary
upiTotal
cardTotal
creditTotal
totalCollections
```

Calculation:

```text
Total Collections =
    Cash Summary.Cash Total
  + UPI Total
  + Card Total
  + Credit Total
```

Rules:

- Cash Total must originate from CashSummary.
- UPI Total must equal the sum of applicable UPI payment entries.
- Card Total must equal the sum of applicable card payment entries.
- Credit Total must equal the sum of CreditSale amounts.
- Total Collections must be derived and must not be manually overwritten.

---

# 13. Adjustment Domain

## 13.1 Adjustment — Entity

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

## 13.2 AdjustmentSummary — Value Object

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

# 14. Reconciliation Domain

## 14.1 Reconciliation — Aggregate Root

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

## 14.2 EmployeeReconciliation — Entity

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

# 15. Security Domain

## 15.1 ApplicationUser — Aggregate Root

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

# 16. Audit Domain

## 16.1 AuditEvent — Entity

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
EMPLOYEE_PROFILE_CREATED
EMPLOYEE_PROFILE_UPDATED
EMPLOYEE_STATUS_CHANGED
EMPLOYEE_PHOTOGRAPH_CHANGED
EMPLOYEE_SHIFT_STARTED
EMPLOYEE_SHIFT_ENDED
EMPLOYEE_SHIFT_HOURS_CORRECTED
CASH_DENOMINATION_ENTERED
COINS_AMOUNT_ENTERED
CASH_ENTRY_UPDATED
INCOMING_FUEL_INVOICE_UPLOADED
INCOMING_FUEL_INVOICE_OCR_STARTED
INCOMING_FUEL_INVOICE_OCR_COMPLETED
INCOMING_FUEL_INVOICE_OCR_FAILED
INCOMING_FUEL_INVOICE_REVIEWED
INCOMING_FUEL_INVOICE_CORRECTED
INCOMING_FUEL_INVOICE_CONFIRMED
INCOMING_FUEL_INVOICE_CANCELLED
INCOMING_FUEL_INVOICE_DOCUMENT_REPLACED
```

---

## 16.2 ManualCorrection — Entity

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

# 17. Aggregate Boundaries

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
EmployeeShiftHours
Receipt
ReceiptReading
FuelSale
Payment
CashDenominationEntry
CoinsEntry
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

## IncomingFuelInvoice aggregate

Owns:

```text
IncomingFuelInvoice
IncomingFuelInvoiceItem
IncomingFuelInvoiceDocument
IncomingFuelInvoiceOcrResult
IncomingFuelInvoiceReview
```

Rules:

- Invoice items cannot exist independently of their invoice.
- Source documents remain linked to the invoice.
- OCR results are subordinate processing records.
- User-confirmed values remain the authoritative business state.
- The aggregate does not belong to Shift and shall not modify reconciliation transactions.

---

# 18. Domain Services

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
Calculate note-denomination amounts
Calculate total notes amount
Include consolidated Coins amount
Calculate employee cash total
Aggregate UPI payments
Aggregate card payments
Aggregate credit sales
Build employee payment summary
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

## IncomingFuelInvoiceValidationService

Responsibilities:

```text
Validate invoice number
Validate invoice date
Validate required product items
Validate positive quantities
Validate product codes where configured
Validate invoice confirmation readiness
Detect missing required information
```

---

## IncomingFuelInvoiceOcrService

Responsibilities:

```text
Process invoice document
Extract invoice header fields
Extract multiple product items
Normalize extracted values
Produce field confidence information
Flag uncertain values for review
Preserve original OCR output
```

One important DDD note:

The **interface** for OCR capability may belong to the domain/application layer, but the actual Tesseract or other OCR implementation belongs to infrastructure.

---

# 19. Application Services

Suggested application services:

```text
FuelStationApplicationService
EmployeeApplicationService
NozzleAssignmentApplicationService
ShiftApplicationService
EmployeeShiftHoursApplicationService
ReceiptUploadApplicationService
ReceiptProcessingApplicationService
ReadingConfirmationApplicationService
IncomingFuelInvoiceApplicationService
IncomingFuelInvoiceOcrApplicationService
IncomingFuelInvoiceReviewApplicationService
PaymentEntryApplicationService
AdjustmentApplicationService
ReconciliationApplicationService
ApprovalApplicationService
ReportApplicationService
```

Application services orchestrate use cases but must delegate business calculations to domain objects or domain services.

---

# 20. Repository Interfaces

Suggested domain repository interfaces:

```text
FuelStationRepository
DispenserUnitRepository
EmployeeRepository
NozzleAssignmentRepository
ShiftRepository
ReceiptRepository
FuelPriceRepository
IncomingFuelInvoiceRepository
PaymentRepository
AdjustmentRepository
ReconciliationRepository
ApplicationUserRepository
AuditEventRepository
```

Repository interfaces belong to the domain or application layer.

Database implementations belong to infrastructure.

---

# 21. Important Domain Invariants

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
10. Note amounts are derived from denomination values and quantities, while the Coins amount is entered directly.
11. Reconciliation values are derived from source transactions.
12. Manual corrections retain original OCR values.
13. Approved and closed records cannot be silently modified.
14. All significant operations are audited.
15. Only ACTIVE employees may participate in new operational shifts or receive new nozzle assignments.
16. Date of Leaving cannot be earlier than Date of Joining.
17. An employee with status LEFT must have a Date of Leaving.
18. Employee working hours are maintained independently from the operational shift duration.
19. Employee Shift End Date/Time cannot precede Employee Shift Start Date/Time.
20. Employee Shift Duration is derived from employee start and end date/time.
21. Historical employee and employee-shift information must remain unchanged by later employee-status changes.
22. Employee Cash Total equals the sum of all calculated note-denomination amounts plus the consolidated Coins amount.
23. Individual ₹5, ₹2 and ₹1 coin quantities are not required by the cash-entry domain model.
24. Only one consolidated Coins entry may apply to one employee within one shift.
25. Incoming fuel invoices remain independent of operational shift reconciliation.
26. One IncomingFuelInvoice may contain one or more IncomingFuelInvoiceItem entities.
27. Every IncomingFuelInvoiceItem belongs to exactly one IncomingFuelInvoice.
28. A confirmed incoming fuel invoice must contain an Invoice Number and Invoice Date.
29. A confirmed incoming fuel invoice must contain at least one valid product item.
30. Every confirmed product item must have a Quantity greater than zero.
31. OCR-extracted invoice information is not authoritative until reviewed and confirmed.
32. Original invoice documents must remain unchanged during normal data correction.
33. Confirmed invoice corrections must be authorized and auditable.
34. Original OCR values must remain traceable after user correction.

---

# 22. Example Shift Scenario

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

# 23. Future Domain Extensions

The model should allow future support for:

- Multiple shifts per business date
- Multiple dispenser units per station
- Additional fuel types
- Tank inventory reconciliation
- Credit customer management
- Payment settlement tracking
- Bank deposit verification
- Multi-organization tenancy
- Offline mobile receipt capture
- Automated price synchronization
- ERP and accounting integration