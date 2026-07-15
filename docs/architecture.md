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
    +------------+-----------+----------------+
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
- Approve reconciliation
- Generate reports

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
Nozzle
NozzleAssignment
Shift
Receipt
ReceiptReading
FuelPrice
FuelSale
Payment
CashDenomination
Adjustment
Reconciliation
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

- Employee master data
- Nozzle-to-employee assignments
- Effective date handling
- Assignment history

Principal entities:

```text
Employee
NozzleAssignment
```

Nozzle assignment must not be permanently hardcoded.

---

### 8.3 Shift management

Responsibilities:

- Shift opening
- Shift closing
- Business date
- Assigned employees
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
APPROVED
CLOSED
CANCELLED
```

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

- Cash denomination entry
- UPI amount entry
- Card collection entry
- Credit sale entry
- Payment-reference storage
- Employee-wise payment grouping

Principal entities:

```text
Payment
CashDenominationEntry
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
- Determine reconciliation status
- Support configurable tolerance
- Support employee-wise and shift-wise reconciliation

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

Statuses:

```text
MATCHED
SHORTAGE
EXCESS
PENDING_REVIEW
APPROVED
```

---

### 8.9 Reporting and audit

Responsibilities:

- Shift reconciliation reports
- Employee reconciliation reports
- Station reports
- Excel exports
- PDF exports
- Audit-event storage
- Manual correction history
- Historical search

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

---

## 10. Suggested Web Screens

### Employee screens

```text
Login
Dashboard
Open Shift
Upload Start Receipt
Upload End Receipt
Review OCR Readings
Enter Cash Denominations
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
Approval Queue
Historical Reports
Audit History
```

---

## 11. Database Architecture

PostgreSQL will be the production database.

HikariCP will manage database connections.

Flyway will manage schema versions.

H2 may be used for automated tests where PostgreSQL-specific behavior is not required.

The database must retain:

- Master data
- Shift transactions
- Receipt metadata
- OCR results
- Parsed readings
- Manual corrections
- Payment entries
- Adjustments
- Reconciliation results
- Approval history
- Audit events

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

---

## 14. Security Architecture

The system will eventually support role-based access.

Suggested roles:

```text
EMPLOYEE
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
- Approval
- Shift closure
- Report generation

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
   +---- Receipt File Storage
```

Possible deployment environments:

- Local office server
- Company data centre
- Cloud virtual machine
- Containerized Docker deployment

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
├── sales
├── payment
├── adjustment
├── reconciliation
├── reporting
├── security
└── web
```

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

### Integration tests

- PostgreSQL repositories
- Flyway migrations
- REST controllers
- OCR workflow
- File upload
- Authentication

### Frontend tests

- Form validation
- Payment calculations
- Reconciliation summaries
- Responsive behavior

### End-to-end tests

- Login
- Open shift
- Upload receipts
- Enter collections
- Reconcile
- Submit and approve

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

---

## 21. Future Enhancements

The architecture should support future capabilities such as:

- Multiple organizations
- Multiple fuel-station chains
- Android or iOS mobile applications
- Offline receipt capture
- Cloud object storage
- Email and SMS notifications
- Automated approval rules
- ERP integration
- Payment-gateway reconciliation
- Dashboard analytics
- Role-specific reports
- Machine-learning OCR correction
- Multi-language support

---

## 22. Next Design Documents

The following documents should be created next:

```text
docs/domain-model.md
docs/database-design.md
docs/api-design.md
docs/security-design.md
```

The immediate next step is to design the domain model before restructuring the Java project.