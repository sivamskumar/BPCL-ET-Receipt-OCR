package com.bpcl.reconciliation.domain.sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.dispenser.Nozzle;
import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.fuel.FuelPrice;
import com.bpcl.reconciliation.domain.fuel.FuelType;
import com.bpcl.reconciliation.domain.receipt.ReceiptNozzleReading;
import com.bpcl.reconciliation.domain.shift.Shift;
import com.bpcl.reconciliation.domain.shift.ShiftNozzleAssignment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "fuel_sale",
        schema = "reconciliation"
)
public class FuelSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_id",
            nullable = false
    )
    private Shift shift;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_nozzle_assignment_id",
            nullable = false
    )
    private ShiftNozzleAssignment shiftNozzleAssignment;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_id",
            nullable = false
    )
    private Employee employee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "nozzle_id",
            nullable = false
    )
    private Nozzle nozzle;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_type_id",
            nullable = false
    )
    private FuelType fuelType;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "start_receipt_reading_id",
            nullable = false
    )
    private ReceiptNozzleReading startReceiptReading;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "end_receipt_reading_id",
            nullable = false
    )
    private ReceiptNozzleReading endReceiptReading;

    @Column(
            name = "start_vtot",
            nullable = false,
            precision = 19,
            scale = 3
    )
    private BigDecimal startVtot;

    @Column(
            name = "end_vtot",
            nullable = false,
            precision = 19,
            scale = 3
    )
    private BigDecimal endVtot;

    @Column(
            name = "quantity_sold",
            nullable = false,
            precision = 19,
            scale = 3
    )
    private BigDecimal quantitySold;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_price_id",
            nullable = false
    )
    private FuelPrice fuelPrice;

    @Column(
            name = "price_per_litre",
            nullable = false,
            precision = 12,
            scale = 3
    )
    private BigDecimal pricePerLitre;

    @Column(
            name = "calculated_sales_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal calculatedSalesAmount;

    @Column(
            name = "calculated_at",
            nullable = false
    )
    private OffsetDateTime calculatedAt;

    @Column(
            name = "calculation_version",
            nullable = false
    )
    private Integer calculationVersion = 1;

    protected FuelSale() {
    }

    public FuelSale(
            Shift shift,
            ShiftNozzleAssignment shiftNozzleAssignment,
            Employee employee,
            Nozzle nozzle,
            FuelType fuelType,
            ReceiptNozzleReading startReceiptReading,
            ReceiptNozzleReading endReceiptReading,
            FuelPrice fuelPrice,
            Integer calculationVersion) {

        this.shift = shift;
        this.shiftNozzleAssignment = shiftNozzleAssignment;
        this.employee = employee;
        this.nozzle = nozzle;
        this.fuelType = fuelType;
        this.startReceiptReading = startReceiptReading;
        this.endReceiptReading = endReceiptReading;
        this.fuelPrice = fuelPrice;
        this.calculationVersion = calculationVersion;

        this.startVtot = startReceiptReading.getVtot();
        this.endVtot = endReceiptReading.getVtot();

        this.quantitySold =
                this.endVtot.subtract(this.startVtot);

        this.pricePerLitre =
                fuelPrice.getPricePerLitre();

        this.calculatedSalesAmount =
                this.quantitySold
                        .multiply(this.pricePerLitre)
                        .setScale(
                                2,
                                RoundingMode.HALF_UP);
    }

    @PrePersist
    protected void onCreate() {
        if (calculatedAt == null) {
            calculatedAt = OffsetDateTime.now();
        }

        if (calculationVersion == null) {
            calculationVersion = 1;
        }
    }

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public ShiftNozzleAssignment getShiftNozzleAssignment() {
        return shiftNozzleAssignment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public ReceiptNozzleReading getStartReceiptReading() {
        return startReceiptReading;
    }

    public ReceiptNozzleReading getEndReceiptReading() {
        return endReceiptReading;
    }

    public BigDecimal getStartVtot() {
        return startVtot;
    }

    public BigDecimal getEndVtot() {
        return endVtot;
    }

    public BigDecimal getQuantitySold() {
        return quantitySold;
    }

    public FuelPrice getFuelPrice() {
        return fuelPrice;
    }

    public BigDecimal getPricePerLitre() {
        return pricePerLitre;
    }

    public BigDecimal getCalculatedSalesAmount() {
        return calculatedSalesAmount;
    }

    public OffsetDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public Integer getCalculationVersion() {
        return calculationVersion;
    }
}