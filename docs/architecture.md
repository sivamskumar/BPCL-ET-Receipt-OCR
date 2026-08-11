# Fuel Station Shift Reconciliation System
## Architecture Document

## 1. Purpose

The Fuel Station Shift Reconciliation System is a web-based application used to calculate and validate daily fuel sales for pumping stations.

The system processes start-reading and end-reading Electronic Totalizer receipts, calculates nozzle-wise fuel sales, maps sales to employees, captures cash and non-cash collections, and performs reconciliation.

The application is designed to support:

- Multiple fuel stations
- Multiple DU serial numbers
- Multiple employees
- Configurable nozzle assignments
- Petrol and diesel sales
- Cash, UPI, card and credit collections
- Expenses and other approved adjustments
- Desktop, tablet and mobile access
- Centralized reporting and audit history
- Employee profile management
- Employee shift-hours tracking
- Consolidated Coins entry
- Incoming fuel stock management
- OCR-assisted incoming fuel invoice capture
- Two-level reconciliation approval workflow
- Configurable operational data retention

OCR is an infrastructure capability within the larger reconciliation system.

---

## 2. System Name

### Business name

```text
Fuel Station Shift Reconciliation System
```

### Current repository name

```text
BPCL-ET-Receipt-OCR
```

The existing repository name may be retained during the initial development phase.

The project may be renamed later when the broader application scope is stable.

---

## 3. Architectural Goals

The architecture must provide:

- Clear separation between business logic and technical frameworks
- Responsive web access from desktop and mobile devices
- Centralized PostgreSQL database
- Configurable station and nozzle assignments
- Reliable OCR processing
- Accurate monetary calculations
- Complete auditability
- Testable business rules
- Support for future integrations
- Easy deployment and maintenance
- Secure handling of employee personal information and photographs
- Traceable employee working-hour records
- Separation of OCR-extracted data from confirmed business data
- Multi-level approval workflow with immutable decision history
- - Configurable operational data retention with an initial minimum period of fourteen months

---

## 4. Technology Stack

### Backend

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming language |
| Spring Boot | Web application and REST API framework |
| Spring MVC | HTTP request handling |
| Spring Security | Authentication and authorization |
| Maven | Build and dependency management |
| JDBC | Database access |
| HikariCP | Database connection pooling |
| Flyway | Database schema migration |
| PostgreSQL | Production database |
| H2 | Automated tests and local isolated testing |
| SLF4J | Logging API |
| Logback | Logging implementation |
| JUnit 5 | Unit and integration testing |
| Mockito | Mock-based testing |
| AssertJ | Fluent test assertions |

### OCR and image processing

| Technology | Purpose |
|---|---|
| Tess4J | Java integration with Tesseract OCR |
| OpenCV | Image preprocessing |
| Tesseract | Optical character recognition |

### Frontend

| Technology | Purpose |
|---|---|
| React | Responsive web user interface |
| Bootstrap | Mobile-first layout and UI components |
| JavaScript or TypeScript | Frontend application logic |
| npm | Frontend dependency and build management |

### Reporting

| Technology | Purpose |
|---|---|
| Apache POI | Excel report generation |
| Apache PDFBox | PDF report generation |

---

## 5. High-Level Architecture

```text
Desktop / Tablet / Mobile Browser
                |
                v
        React Web Application
                |
           HTTPS / REST
                |
                v
       Spring Boot Backend API
                |
    +-----------+------------+----------------+
    |                        |                |
    v                        v                v
Application Services     OCR Services    Reporting Services
    |                        |                |
    |              +---------+---------+      |
    |              |                   |      |
    |              v                   v      |
    |        Receipt OCR        Invoice OCR   |
    |                                             |
    +---------------------+-----------------------+
                          |
                          v
                    Domain Layer
                          |
                          v
                 Repository Interfaces
                          |
                          v
                Infrastructure Adapters
                          |
                 +--------+--------+
                 |                 |
                 v                 v
          PostgreSQL Database   File Storage
```

---

## 6. Architectural Style

The backend will follow:

- Domain-Driven Design principles
- Layered architecture
- Ports and adapters concepts
- Dependency inversion
- Separation of concerns

The business domain must not depend directly on:

- Spring MVC controllers
- Database-specific code
- OCR libraries
- React
- File-system implementation details

Technical frameworks must depend on the domain, not the other way around.

---

## 7. Backend Layers

### 7.1 Presentation layer

Responsibilities:

- REST controllers
- Request validation
- Response formatting
- Authentication context
- HTTP status handling
- File upload endpoints

Example packages:

```text
presentation
web
controller
dto
```

This layer must not contain fuel sales calculation or reconciliation logic.

---

### 7.2 Application layer

Responsibilities:

- Execute business use cases
- Coordinate domain objects
- Manage transactions
- Call repositories
- Invoke OCR and reporting ports
- Handle application workflows

Example use cases:

- Create fuel station
- Configure nozzle assignment
- Open shift
- Upload start receipt
- Upload end receipt
- Process receipt OCR
- Confirm receipt readings
- Enter payment collections
- Calculate reconciliation
- Submit reconciliation for Level-1 review
- Return reconciliation to employee for correction
- Resubmit reconciliation
- Perform Level-1 review
- Approve with remarks where required
- Forward reconciliation for Level-2 approval
- Perform Level-2 approval
- Reject or return reconciliation at Level-2
- Generate reports
- Maintain employee profile
- Record employee working period
- Correct employee shift hours
- Enter consolidated Coins amount
- Upload incoming fuel invoice
- Process incoming fuel invoice OCR
- Review extracted invoice information
- Correct extracted invoice information
- Confirm incoming fuel invoice
- Search incoming fuel invoices
- View incoming fuel stock history

Example packages:

```text
application
service
command
query
```

---

### 7.3 Domain layer

Responsibilities:

- Business entities
- Value objects
- Domain services
- Business rules
- Domain exceptions
- Reconciliation calculations
- Validation logic

The domain layer must be implemented using plain Java wherever possible.

Principal domain concepts include:

```text
FuelStation
DispenserUnit
Employee
EmployeeShiftHours
Nozzle
NozzleAssignment
Shift
Receipt
ReceiptReading
FuelPrice
FuelSale
Payment
CashDenomination
CashDenominationEntry
CoinsEntry
Adjustment
Reconciliation
ReconciliationSubmission
ApprovalDecision
ApprovalWorkflowStatus
ApprovalLevel
ApprovalAction
IncomingFuelInvoice
IncomingFuelInvoiceItem
IncomingFuelInvoiceDocument
IncomingFuelInvoiceOcrResult
IncomingFuelInvoiceOcrField
IncomingFuelInvoiceReview
```

All monetary and fuel-volume calculations must use `BigDecimal`.

---

### 7.4 Infrastructure layer

Responsibilities:

- PostgreSQL access
- JDBC repository implementations
- HikariCP configuration
- Flyway migrations
- OCR integration
- OpenCV integration
- Tesseract integration
- File storage
- Excel generation
- PDF generation
- Email or external integrations in future
- Incoming fuel invoice document storage
- Incoming fuel invoice OCR integration
- Invoice OCR field extraction and normalization

Example packages:

```text
infrastructure
persistence
ocr
storage
reporting
configuration
```

---

## 8. Domain Boundaries

The application will be divided into the following business areas.

### 8.1 Station management

Responsibilities:

- Fuel station configuration
- DU serial number management
- Nozzle configuration
- Fuel-type assignment
- Station activation and deactivation

Principal entities:

```text
FuelStation
DispenserUnit
Nozzle
FuelType
```

---

### 8.2 Employee and assignment management

Responsibilities:

- Employee profile management
- Employee contact and address information
- Employee photograph management
- Employment lifecycle management
- Date of joining and date of leaving
- Employee activation and deactivation
- Nozzle-to-employee assignments
- Effective date handling
- Assignment history
- Employee working-period tracking
- Employee shift-hours correction history

Principal entities:

```text
Employee
EmployeeShiftHours
EmployeeShiftHoursCorrection
NozzleAssignment
```

Employee profiles may contain sensitive personal information and must only be accessible through authorized application operations.

Employee photographs shall be stored securely and shall not be publicly accessible.

Nozzle assignment must not be permanently hardcoded.

Historical employee, assignment and working-hour information must remain traceable when an employee becomes inactive or leaves the organization.


### Aadhaar

Notice that I have deliberately **not written Aadhaar directly into this architecture subsection**.

The architecture should establish:

```text
sensitive employee personal information
        ↓
controlled access
        ↓
secure storage
        ↓
no unrestricted logging/reporting
```
The exact field belongs in the BRD/domain/database design, where we already modeled it.

---

### 8.3 Shift management

Responsibilities:

- Shift opening
- Shift closing
- Business date
- Assigned employees
- Employee participation tracking
- Employee working-period tracking
- Shift status
- Start and end receipt association


Principal entity:

```text
Shift
```

Suggested shift statuses:

```text
OPEN
START_RECEIPT_UPLOADED
END_RECEIPT_UPLOADED
OCR_COMPLETED
READINGS_CONFIRMED
PAYMENTS_ENTERED
RECONCILED
SUBMITTED_FOR_LEVEL_1_REVIEW
RETURNED_TO_EMPLOYEE
RESUBMITTED
LEVEL_1_APPROVED
LEVEL_1_APPROVED_WITH_REMARKS
FORWARDED_FOR_LEVEL_2_APPROVAL
APPROVED
CLOSED
CANCELLED
```

Shift workflow rules:

- A reconciled shift must be submitted before Level-1 review.
- A returned shift may be corrected and resubmitted by the employee.
- Persistent shortage or excess may proceed from Level-1 only with appropriate remarks.
- Final approval requires Level-2 approval.
- Only an approved shift may normally transition to Closed.
- Closed and cancelled shifts are read-only during normal operation.
- Every workflow transition must be auditable.

---

### 8.4 Receipt processing

Responsibilities:

- Receipt image upload
- Image validation
- OCR processing
- Receipt parsing
- DU serial number extraction
- Nozzle reading extraction
- OCR confidence tracking
- Manual correction
- Duplicate receipt detection

Principal entities and value objects:

```text
Receipt
ReceiptImage
ReceiptReading
OcrResult
ReceiptType
```

Receipt types:

```text
START
END
```

---

### 8.5 Fuel sales calculation

Responsibilities:

- Calculate quantity sold
- Calculate receipt amount difference
- Calculate price-based amount
- Group sales by employee
- Group sales by fuel type
- Detect invalid or decreasing readings

Core calculations:

```text
Quantity Sold = End VTOT - Start VTOT
```

```text
Receipt Amount Difference = End ATOT - Start ATOT
```

```text
Calculated Sales Amount = Quantity Sold × Price Per Litre
```

---

### 8.6 Payment and collection management

Responsibilities:

- Currency-note denomination entry
- Consolidated Coins Amount entry
- Cash-total calculation
- UPI TID capture
- UPI amount entry
- Card collection entry
- Credit sale entry
- Payment-reference storage
- Employee-wise payment grouping

Principal entities:

```text
Payment
CashDenomination
CashDenominationEntry
CoinsEntry
CreditSale
PaymentReference
```

Payment types:

```text
CASH
UPI
CARD
CREDIT
```

Cash collection shall distinguish between currency-note denomination entries and a directly entered consolidated Coins Amount.

```text
Notes Total =
    SUM(Denomination Value × Quantity)

Cash Total =
    Notes Total
  + Coins Amount
```

Individual ₹5, ₹2 and ₹1 denomination quantities are not required.

---

### 8.7 Adjustment management

Responsibilities:

- Expenses
- Cash deposits
- Fuel testing
- Calibration usage
- Fuel returns
- Other approved adjustments
- Approval metadata

Principal entity:

```text
Adjustment
```

Each adjustment must record:

- Adjustment type
- Amount
- Direction
- Description
- Reference number
- Approved by
- Date and time

---

### 8.8 Reconciliation

Responsibilities:

- Calculate expected fuel sales amount
- Calculate accounted amount
- Apply adjustments
- Calculate difference
- Determine calculated reconciliation status
- Apply configurable reconciliation tolerance
- Support employee-wise and shift-wise reconciliation
- Maintain reconciliation submission history
- Maintain two-level approval workflow state
- Preserve Reviewer and Approver decisions
- Support return, correction and resubmission
- Preserve final approval information

Core formula:

```text
Accounted Amount =
    Cash Total
  + UPI Total
  + Card Total
  + Credit Sales Total
  + Positive Adjustments
  - Deductible Expenses
```

```text
Difference =
    Accounted Amount
  - Expected Fuel Sales Amount
```

Calculated reconciliation statuses:

```text
PENDING
MATCHED
SHORTAGE
EXCESS
PENDING_REVIEW
```

Approval workflow statuses:

```text
NOT_SUBMITTED
PENDING_LEVEL_1_REVIEW
RETURNED_TO_EMPLOYEE
RESUBMITTED
LEVEL_1_APPROVED
LEVEL_1_APPROVED_WITH_REMARKS
PENDING_LEVEL_2_APPROVAL
APPROVED
REJECTED
```

Principal concepts:

```text
Reconciliation
EmployeeReconciliation
ReconciliationSubmission
ApprovalDecision
ApprovalWorkflowStatus
```

---

### 8.9 Incoming fuel stock management

Incoming fuel stock management is a separate business area from employee shift reconciliation.

Responsibilities:

- Capture incoming Petrol and Diesel stock
- Upload or photograph incoming fuel invoices
- Store source invoice documents securely
- Process invoice documents through OCR
- Extract invoice header information
- Extract multiple fuel-product lines
- Capture Invoice Number
- Capture Invoice Date and Time
- Capture Product Description
- Capture Product Code where available
- Capture Quantity
- Capture Product Value
- Track OCR confidence
- Present extracted information for user review
- Allow authorized correction before confirmation
- Confirm reviewed invoice information
- Search historical incoming fuel invoices
- Support incoming fuel stock reporting
- Preserve invoice, OCR and review history

Principal entities and concepts:

```text
IncomingFuelInvoice
IncomingFuelInvoiceItem
IncomingFuelInvoiceDocument
IncomingFuelInvoiceOcrResult
IncomingFuelInvoiceOcrField
IncomingFuelInvoiceReview
```

One incoming fuel invoice may contain multiple fuel-product items.

OCR-extracted information is not authoritative business data until it has been reviewed and confirmed by an authorized user.

The original invoice document shall remain available for traceability according to the applicable retention policy.

Incoming fuel stock records shall remain independent from operational employee shift reconciliation.

---

### 8.10 Reporting and audit

Responsibilities:

- Shift reconciliation reports
- Employee reconciliation reports
- Station reports
- Excel exports
- PDF exports
- Audit-event storage
- Manual correction history
- Retention-aware historical search
- Authorized access to retained operational history
- Preservation of audit history throughout the applicable retention period

Principal concepts:

```text
AuditEvent
ManualCorrection
GeneratedReport
```

---

## 9. Frontend Architecture

The frontend will be a responsive React application.

Suggested frontend structure:

```text
frontend
├── src
│   ├── api
│   ├── components
│   ├── features
│   │   ├── authentication
│   │   ├── stations
│   │   ├── employees
│   │   ├── shifts
│   │   ├── receipts
│   │   ├── incomingFuelStock
│   │   ├── payments
│   │   ├── reconciliation
│   │   └── reports
│   ├── layouts
│   ├── pages
│   ├── routes
│   ├── hooks
│   ├── utils
│   └── validation
└── package.json
```

The UI must be mobile-first.

Important mobile requirements:

- Camera-based receipt capture
- Receipt preview
- Large touch-friendly controls
- Minimal mandatory typing
- Clear OCR validation messages
- Responsive denomination-entry grid
- Reconciliation summary visible without horizontal scrolling
- Support for poor or unstable network conditions in future
- Employee profile and photograph capture where authorized
- Employee working-time entry and review
- Consolidated Coins Amount entry
- Camera-based incoming fuel invoice capture
- Incoming fuel invoice preview
- Replace poor-quality invoice image
- OCR-extracted invoice review
- Touch-friendly invoice field correction
- Multiple product-line review

---

## 10. Suggested Web Screens

### Employee screens

```text
Login
Dashboard
Open Shift
Record Working Period
Upload Start Receipt
Upload End Receipt
Review OCR Readings
Enter Cash Denominations
Enter Coins Amount
Enter UPI Collections
Enter Card Collections
Enter Credit Sales
Enter Expenses and Adjustments
View Reconciliation Result
Submit Shift
```

### Manager screens

```text
Manager Dashboard
Station Management
DU Management
Employee Management
Nozzle Assignment
Fuel Price Management
Open Shift Monitoring
Reconciliation Exceptions
Level-1 Review Monitoring
Level-2 Approval Monitoring
Historical Reports
Audit History
Employee Profile Management
Employee Shift Hours Report
```

### Reviewer screens

```text
Reviewer Dashboard
Level-1 Review Queue
Reconciliation Review Details
Return Reconciliation for Correction
Approve Matched Reconciliation
Approve Shortage or Excess with Remarks
Review Submission History
Review Approval History
```

### Approver screens

```text
Approver Dashboard
Level-2 Approval Queue
Reconciliation Approval Details
Approve Reconciliation
Reject or Return Reconciliation with Remarks
Review Submission History
Review Approval History
```

### Incoming fuel stock screens

```text
Incoming Fuel Stock Dashboard
Capture Incoming Fuel Invoice
Preview Incoming Fuel Invoice
Review Invoice OCR Results
Correct Invoice Information
Confirm Incoming Fuel Invoice
Incoming Fuel Stock History
Incoming Fuel Stock Report
View Source Invoice
```

---

## 11. Database Architecture

PostgreSQL will be the production database.

HikariCP will manage database connections.

Flyway will manage schema versions.

H2 may be used for automated tests where PostgreSQL-specific behavior is not required.

The database must retain:

- Master data
- Employee profile data
- Employee shift-hours history
- Employee shift-hours correction history
- Shift transactions
- Receipt metadata
- OCR results
- Parsed readings
- Manual corrections
- Payment entries
- Consolidated Coins entries
- Adjustments
- Reconciliation results
- Reconciliation submission history
- Approval decision history
- Audit events
- Incoming fuel invoice headers
- Incoming fuel invoice product items
- Incoming fuel invoice document metadata
- Incoming fuel invoice OCR attempts
- Incoming fuel invoice OCR field results
- Incoming fuel invoice review history

Receipt image files should initially be stored outside the database.

The database should retain image metadata such as:

```text
Storage path
Original filename
Content type
File size
SHA-256 hash
Upload timestamp
```

Incoming fuel invoice files should also initially be stored outside the database.

The database shall retain invoice-document metadata and maintain relationships between:

```text
Incoming Fuel Invoice
        |
        +-- Product Items
        |
        +-- Source Documents
        |
        +-- OCR Attempts
        |       |
        |       +-- OCR Field Results
        |
        +-- Review History
```

### Data retention architecture

Operational and transaction data shall be retained for at least fourteen months according to the approved business requirement.

The retention period shall be configurable by an authorized administrator, subject to client policy.

Retention eligibility shall use a clearly defined business date or applicable transaction/event timestamp.

Changing the configured retention period shall not immediately delete existing data.

Records involved in an active investigation, audit requirement or authorized hold shall not be removed by the normal retention process.

Expired data shall only be archived or deleted through an authorized controlled process.

The final archive-versus-delete policy after the retention period remains subject to client confirmation.

Retention processing must preserve referential consistency between related business records and externally stored documents.

For example:

```text
Shift
    +-- Receipt metadata
    +-- Receipt images
    +-- OCR results
    +-- Payment entries
    +-- Reconciliation
    +-- Submission and approval history
    +-- Audit history

Incoming Fuel Invoice
    +-- Product items
    +-- Source invoice documents
    +-- OCR results
    +-- Review history
```

---

## 12. Repository Pattern

The domain and application layers will depend on repository interfaces.

Example:

```java
public interface ShiftRepository {

    Shift save(Shift shift);

    Optional<Shift> findById(ShiftId shiftId);
}
```

The JDBC or Spring Data implementation will exist in the infrastructure layer.

This enables:

- Easier testing
- Database replacement
- Framework independence
- Clear dependency direction

---

## 13. OCR Architecture

OCR processing will be exposed through an application port.

Example:

```java
public interface ReceiptOcrService {

    OcrResult process(ReceiptImage receiptImage);
}
```

The implementation may use:

- OpenCV for preprocessing
- Tess4J for OCR
- A receipt-template parser
- Confidence scoring
- Field normalization

The domain layer must not directly import OpenCV or Tess4J classes.

```java
public interface IncomingFuelInvoiceOcrService {

    IncomingFuelInvoiceOcrResult process(
            IncomingFuelInvoiceDocument invoiceDocument);
}
```

OCR infrastructure may use:

- OpenCV for image preprocessing
- Tess4J for OCR
- Tesseract
- Document-specific parsers
- Confidence scoring
- Field normalization

Receipt OCR and incoming fuel invoice OCR shall use separate application contracts because they extract different business structures.

```text
Receipt OCR
    → DU serial number
    → nozzle readings
    → VTOT / ATOT

Incoming Fuel Invoice OCR
    → invoice number
    → invoice date and time
    → product description
    → product code
    → quantity
    → product value
```
The domain layer must not directly import OpenCV, Tess4J or Tesseract-specific classes.


### Why two interfaces?

This is important.

We should **not** create one generic interface such as:

```java
OcrService.process(file)
```

because the resulting business models are fundamentally different.

We want:

ReceiptOcrService
        ↓
Receipt-specific result

IncomingFuelInvoiceOcrService
        ↓
Invoice-specific result

while still allowing infrastructure reuse underneath.

---

## 14. Security Architecture

The system will eventually support role-based access.

Suggested roles:

```text
EMPLOYEE
REVIEWER
APPROVER
SUPERVISOR
MANAGER
ADMINISTRATOR
AUDITOR
```

Security responsibilities include:

- Authentication
- Password storage
- Role-based authorization
- Station-level access restrictions
- Audit logging
- Approval permissions
- Session or token management
- Protection of employee personal information
- Controlled access to employee photographs
- Prevention of sensitive employee information in application logs
- Authorization of retention-policy configuration
- Protection of retained and archived operational information
- Restricted access to backup and recovery data

Approval-security rules:

- Employees must not approve their own reconciliations.
- Level-1 review actions require Reviewer authorization.
- Level-2 approval actions require Approver authorization.
- Administrative roles shall not automatically bypass approval segregation.
- Users may only access reconciliation records within their permitted organization and station scope.
- Return and rejection actions require the appropriate business reason.
- Approval with remarks requires remarks where required by the workflow.
- Authorization must be enforced by the backend and must not rely only on frontend controls.

Retention configuration changes, archival operations and controlled data-disposal operations must require appropriate authorization and must be auditable.

Backup copies and archived business information must receive security protection appropriate to the sensitivity of the original production data.

Spring Security shall enforce authentication and coarse-grained authorization.

Business-level approval rules, including current workflow state, approval level, segregation of duties and permitted transitions, shall be enforced by the application/domain workflow logic rather than by role checks alone.

Sensitive employee information shall only be exposed to users with an authorized business requirement.

Employee photographs and protected personal information shall not be directly exposed through public file-system paths.

Spring Security will provide the security framework.

---

## 15. Audit Requirements

The system should record important events, including:

- User login
- Shift creation
- Receipt upload
- OCR completion
- Manual reading correction
- Payment entry
- Adjustment entry
- Reconciliation calculation
- Reconciliation submission
- Reconciliation return to employee
- Reconciliation resubmission
- Level-1 approval
- Level-1 approval with remarks
- Level-2 approval
- Level-2 rejection or return
- Shift closure
- Report generation
- Employee profile creation and update
- Employee activation/deactivation
- Employee working-period completion
- Employee shift-hours correction
- Cash denomination entry
- Coins Amount entry or correction
- Incoming fuel invoice upload
- Incoming fuel invoice document replacement
- Invoice OCR processing
- Invoice OCR failure
- Invoice field correction
- Incoming fuel invoice review
- Incoming fuel invoice confirmation
- Incoming fuel invoice cancellation
- Retention configuration change
- Data archival execution
- Controlled data-disposal execution
- Backup or recovery administrative activity where applicable

Retention and disposal audit information must identify the acting user or system process, action performed, applicable data scope, date and time, and result.

Retention-policy changes shall not silently alter or remove historical audit evidence.

Audit records should include:

```text
User
Action
Entity type
Entity identifier
Old value where applicable
New value where applicable
Date and time
IP address where available
```

Approval audit records must preserve:

```text
Reconciliation
Submission number
Approval level
Action
Acting user
Previous workflow status
New workflow status
Remarks or reason where applicable
Date and time
```

---

## 16. Deployment Architecture

The initial centralized deployment model will be:

```text
Browser
   |
   v
Reverse Proxy / HTTPS
   |
   v
Spring Boot Backend
   |
   +---- React Static Application
   |
   +---- PostgreSQL
   |
   +---- Document File Storage
          |
          +---- Receipt Images
          |
          +---- Incoming Fuel Invoices
```

The application is intended to operate as a centralized web application accessible through approved networks and supported browsers.

Receipt images and incoming fuel invoice documents may initially share the same secured document-storage infrastructure while remaining logically separated by document type and storage path.

The storage abstraction should permit future migration to cloud object storage without changing domain logic.

Production deployment must provide:

- HTTPS
- Secure application configuration
- Protected database connectivity
- Protected document storage
- Backup and recovery capability
- Application and operational logging
- Environment-specific secrets
- Appropriate monitoring
- Controlled administrative access

The final production hosting model remains subject to client confirmation.

Possible hosting models include:

- Client office server
- Client data-centre server
- Central head-office server
- Cloud-hosted server
- Approved managed hosting environment

The architecture shall avoid unnecessary coupling to a specific hosting provider until the hosting decision is finalized.

### Backup and recovery architecture

A complete production backup must include both database data and externally stored business documents.

Backup scope shall include:

```text
PostgreSQL Database
Receipt Image Storage
Incoming Fuel Invoice Document Storage
Application Configuration required for recovery
```

A database backup alone is not a complete system backup because receipt images and incoming fuel invoice documents are stored externally.

Database records and document storage should be backed up in a manner that permits consistent restoration.

Production backup and recovery design must define:

Backup frequency
Backup retention
Backup access controls
Encryption where appropriate
Restore procedures
Restore testing
Recovery responsibilities
Backup-failure monitoring
Point-in-time recovery where required

Recovery-time and recovery-point objectives shall be finalized with the client before production deployment.

---

## 17. Proposed Repository Structure

The repository should evolve toward:

```text
BPCL-ET-Receipt-OCR
│
├── backend
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   └── resources
│       └── test
│
├── frontend
│   ├── package.json
│   └── src
│
├── docs
│   ├── business-requirements.md
│   ├── architecture.md
│   ├── domain-model.md
│   └── database-design.md
│
├── database
├── docker
├── scripts
├── README.md
└── .gitignore
```

The current repository will be restructured incrementally to avoid unnecessary disruption.

---

## 18. Backend Package Structure

The future backend package root should be:

```text
com.bpcl.reconciliation
```

Suggested structure:

```text
com.bpcl.reconciliation
├── bootstrap
├── shared
├── station
│   ├── domain
│   ├── application
│   └── infrastructure
├── employee
│   ├── domain
│   ├── application
│   └── infrastructure
├── shift
│   ├── domain
│   ├── application
│   └── infrastructure
├── receipt
├── incomingfuel
│   ├── domain
│   ├── application
│   └── infrastructure
├── sales
├── payment
├── adjustment
├── reconciliation
├── reporting
├── security
└── web
```

The `reconciliation` business area shall contain the two-level approval workflow components, including reconciliation submission, approval decisions and workflow-transition rules.

Application orchestration may expose an `ApprovalApplicationService`, while workflow-validity rules should remain in domain services or domain objects rather than REST controllers.

The existing package structure will be migrated carefully in a later commit.

---

## 19. Testing Strategy

The system will include:

### Unit tests

- Domain calculations
- Reconciliation logic
- Value-object validation
- Receipt parsing rules
- Nozzle-assignment rules
- Employee working-duration calculations
- Employee shift-hours correction rules
- Cash denomination calculations
- Consolidated Coins calculations
- Incoming fuel invoice validation
- Invoice product-line validation
- Invoice OCR field normalization
- Invoice OCR confidence handling
- Reconciliation status calculation independent of approval state
- Level-1 workflow transition rules
- Level-2 workflow transition rules
- Return and resubmission rules
- Mandatory remarks for persistent shortage or excess
- Approval segregation rules
- Prevention of invalid workflow transitions
- Retention eligibility calculation
- Retention hold/exclusion rules
- Retention configuration validation

### Integration tests

- PostgreSQL repositories
- Flyway migrations
- REST controllers
- OCR workflow
- File upload
- Authentication
- Employee profile persistence
- Employee shift-hours persistence and correction history
- Coins entry persistence
- Incoming fuel invoice persistence
- Incoming fuel invoice document storage
- Invoice OCR workflow
- Invoice review and confirmation workflow
- Reconciliation submission persistence
- Approval-decision history persistence
- Reviewer authorization
- Approver authorization
- Workflow-state updates
- Approval audit-event persistence
- Retention configuration persistence
- Retention eligibility queries
- Controlled archival/disposal workflow
- Database and document-storage consistency

### Frontend tests

- Form validation
- Payment calculations
- Reconciliation summaries
- Responsive behavior
- Employee profile validation
- Employee working-time validation
- Coins Amount validation
- Incoming fuel invoice capture validation
- Invoice OCR review
- Multiple product-line editing
- Invoice confirmation validation
- Reviewer queue behavior
- Approver queue behavior
- Return-to-employee validation
- Mandatory approval remarks validation
- Role-specific approval controls

### End-to-end approval tests

Matched reconciliation:

```text
Login as Employee
Open Shift
Complete Shift
Enter Collections
Calculate Reconciliation
Submit Reconciliation
Login as Reviewer
Approve Level-1
Login as Approver
Approve Level-2
Close Shift
```

Shortage or excess correction flow:

```text
Employee submits reconciliation
Reviewer returns reconciliation
Employee corrects permitted information
Employee resubmits reconciliation
Reviewer reviews again
Reviewer approves with remarks where required
Approver reviews reconciliation
Approver approves or returns/rejects with remarks
```

Incoming fuel stock workflow:

```text
Login
Capture incoming fuel invoice
Preview invoice
Submit invoice
Process invoice OCR
Review extracted information
Correct information where required
Confirm incoming fuel invoice
Search confirmed invoice
View incoming fuel stock report
```

### Operational recovery tests

Production-readiness testing shall include:

- Database backup verification
- Receipt-document backup verification
- Incoming fuel invoice document backup verification
- Database restore testing
- Document-storage restore testing
- Database/document consistency verification after recovery

---

## 20. Important Design Decisions

### Decision 1: Web application instead of Swing

Reason:

- Mobile access
- No desktop installation
- Centralized updates
- Multi-user operation
- Easier remote access

### Decision 2: React frontend

Reason:

- Interactive user experience
- Reusable components
- Mobile-friendly workflows
- Future mobile-client compatibility

### Decision 3: Spring Boot backend

Reason:

- Mature Java web ecosystem
- REST API support
- Security support
- Database integration
- Production deployment support

### Decision 4: PostgreSQL

Reason:

- Existing team knowledge
- Transactional reliability
- Strong SQL support
- Suitable for centralized deployment

### Decision 5: Flyway

Reason:

- Repeatable schema versioning
- Controlled database upgrades
- Environment consistency
- Migration audit history

### Decision 6: HikariCP

Reason:

- Efficient database connection pooling
- Production readiness
- Strong integration with Spring Boot

### Decision 7: Domain-Driven Design

Reason:

- Business complexity extends beyond OCR
- Clear domain boundaries
- Maintainable business rules
- Better long-term extensibility

### Decision 8: `BigDecimal` for quantity and money

Reason:

- Avoid floating-point errors
- Preserve financial precision
- Support configurable rounding

### Decision 9: Separate OCR contracts for receipts and incoming fuel invoices

Reason:

- Receipt OCR and invoice OCR extract different business structures
- Receipt OCR is reading-oriented
- Invoice OCR includes header and multiple product-line extraction
- Separate contracts prevent business-specific parsing logic from becoming coupled
- Shared OCR infrastructure can still be reused internally
- Future OCR-provider replacement remains isolated from domain logic

### Decision 10: Separate reconciliation result from approval workflow state

Reason:

- MATCHED, SHORTAGE and EXCESS are calculated financial outcomes
- Approval is a business workflow performed after calculation
- Approval actions must not overwrite calculated reconciliation results
- Separate states improve auditability and reporting
- Submission and approval history can be preserved independently
- Two-level approval transitions can evolve without changing reconciliation formulas

### Decision 11: Preserve approval decisions as append-only workflow history

Reason:

- Client requirements require traceability of Reviewer and Approver actions
- Return and resubmission cycles must remain historically visible
- Previous decisions must not be silently overwritten
- Audit and dispute investigation require actor, timestamp, reason and workflow transition history

### Decision 12: Configurable retention with controlled archival or disposal

Reason:

- The approved initial operational retention period is at least fourteen months
- Retention must be configurable subject to client policy
- Configuration changes must not immediately delete business data
- Records under investigation or authorized hold must be protected
- Archival and disposal must be controlled and auditable
- The final archive-versus-delete policy remains subject to client confirmation

### Decision 13: Abstract document storage from physical hosting

Reason:

- Receipt images and incoming fuel invoices are stored outside PostgreSQL
- Initial deployment may use secured file-system storage
- The final production hosting model remains subject to client confirmation
- Future cloud object storage should not require domain-layer changes
- Backup and recovery must include both database records and external documents

---

## 21. Future Enhancements

The architecture should support future capabilities such as:

- Multiple organizations
- Multiple fuel-station chains
- Android or iOS mobile applications
- Offline receipt and invoice capture
- Cloud object storage
- Email and SMS notifications
- Advanced automated approval recommendations and configurable approval levels beyond the initial two-level workflow
- ERP integration
- Payment-gateway reconciliation
- Dashboard analytics
- Role-specific reports
- Machine-learning OCR correction
- Multi-language support

---

## 22. Documentation and Implementation Roadmap

The core business and technical design baseline currently includes:

```text
docs/business-requirements.md
docs/architecture.md
docs/domain-model.md
docs/database-design.md
```

The next detailed design documents should include:

```text
docs/api-design.md
docs/security-design.md
```
Additional implementation-oriented documentation may be introduced as required, including:

```text
docs/deployment-design.md
docs/backup-recovery-design.md
docs/testing-strategy.md
```

After the architecture, domain model and database design are synchronized with the approved business requirements, the implementation can proceed with:

Backend and frontend project restructuring.
Spring Boot backend configuration.
React frontend initialization.
PostgreSQL and Flyway integration.
Security foundation.
Initial database migrations.
Repository and persistence adapters.
REST API design and implementation.
OCR infrastructure integration.
Incremental business-feature implementation and testing.

Open business decisions must be resolved before implementation of the affected areas is finalized.






