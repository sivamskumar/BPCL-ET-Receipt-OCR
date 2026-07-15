# BPCL Electronic Totalizer OCR
## Business Requirements

## 1. Purpose

The application validates daily fuel sales by comparing Electronic Totalizer receipt readings with collections entered by the assigned employee.

## 2. Pumping Station Identification

Each pumping station is identified using the DU Serial Number printed on the receipt.

A receipt comparison is valid only when the Start Reading and End Reading receipts contain the same DU Serial Number.

## 3. Nozzle Configuration

Each pumping station contains four nozzle points.

Each nozzle is assigned to:

- One employee
- One fuel type
- One nozzle number

Example configuration:

| Nozzle | Employee | Fuel Type |
|---|---|---|
| 1 | Sujith | Petrol |
| 2 | Sujith | Diesel |
| 3 | Sonu | Petrol |
| 4 | Sonu | Diesel |

The assignment must be configuration-driven and must not be permanently hardcoded.

## 4. Daily Receipt Workflow

At the beginning of the day, the employee obtains the Start Reading receipt.

At the end of the day, the employee obtains the End Reading receipt from the same pumping station.

The employee uploads both receipts into the application.

## 5. Receipt Validation

The application must validate:

- DU Serial Number is present
- Start and End DU Serial Numbers match
- All required nozzle readings are present
- End readings are not lower than Start readings
- Nozzle numbers are unique
- Numeric values are valid
- OCR confidence meets the configured threshold

## 6. Fuel Quantity Calculation

For each nozzle:

```text
Quantity Sold = End VTOT - Start VTOT