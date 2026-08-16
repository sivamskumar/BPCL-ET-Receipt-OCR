package com.bpcl.reconciliation.domain.reconciliation;

import java.math.BigDecimal;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.shift.ShiftEmployee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "employee_reconciliation",
        schema = "reconciliation"
)
public class EmployeeReconciliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "reconciliation_id",
            nullable = false
    )
    private Reconciliation reconciliation;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_employee_id",
            nullable = false
    )
    private ShiftEmployee shiftEmployee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_id",
            nullable = false
    )
    private Employee employee;

    @Column(
            name = "expected_sales_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal expectedSalesAmount;

    @Column(
            name = "total_notes_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal totalNotesAmount;

    @Column(
            name = "coins_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal coinsTotal;

    @Column(
            name = "cash_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal cashTotal;

    @Column(
            name = "tid_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal tidTotal;

    @Column(
            name = "credit_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal creditTotal;

    @Column(
            name = "additive_adjustment_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal additiveAdjustmentTotal;

    @Column(
            name = "deductive_adjustment_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal deductiveAdjustmentTotal;

    @Column(
            name = "accounted_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal accountedAmount;

    @Column(
            name = "difference_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal differenceAmount;

    @Column(
            name = "allowed_tolerance",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal allowedTolerance;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "reconciliation_status",
            nullable = false,
            length = 40
    )
    private ReconciliationStatus reconciliationStatus;

    protected EmployeeReconciliation() {
    }

    public EmployeeReconciliation(
            Reconciliation reconciliation,
            ShiftEmployee shiftEmployee,
            Employee employee,
            BigDecimal expectedSalesAmount,
            BigDecimal totalNotesAmount,
            BigDecimal coinsTotal,
            BigDecimal tidTotal,
            BigDecimal creditTotal,
            BigDecimal additiveAdjustmentTotal,
            BigDecimal deductiveAdjustmentTotal,
            BigDecimal allowedTolerance) {

        this.reconciliation = reconciliation;
        this.shiftEmployee = shiftEmployee;
        this.employee = employee;

        this.expectedSalesAmount = expectedSalesAmount;
        this.totalNotesAmount = totalNotesAmount;
        this.coinsTotal = coinsTotal;
        this.tidTotal = tidTotal;
        this.creditTotal = creditTotal;
        this.additiveAdjustmentTotal = additiveAdjustmentTotal;
        this.deductiveAdjustmentTotal = deductiveAdjustmentTotal;
        this.allowedTolerance = allowedTolerance;

        this.cashTotal =
                totalNotesAmount.add(coinsTotal);

        this.accountedAmount =
                this.cashTotal
                        .add(tidTotal)
                        .add(creditTotal)
                        .add(additiveAdjustmentTotal)
                        .subtract(deductiveAdjustmentTotal);

        this.differenceAmount =
                this.accountedAmount.subtract(expectedSalesAmount);

        this.reconciliationStatus =
                determineStatus(
                        this.differenceAmount,
                        allowedTolerance);
    }

    private ReconciliationStatus determineStatus(
            BigDecimal differenceAmount,
            BigDecimal allowedTolerance) {

        if (differenceAmount.abs()
                .compareTo(allowedTolerance) <= 0) {

            return ReconciliationStatus.MATCHED;
        }

        if (differenceAmount.signum() < 0) {
            return ReconciliationStatus.SHORTAGE;
        }

        return ReconciliationStatus.EXCESS;
    }

    public Long getId() {
        return id;
    }

    public Reconciliation getReconciliation() {
        return reconciliation;
    }

    public ShiftEmployee getShiftEmployee() {
        return shiftEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getExpectedSalesAmount() {
        return expectedSalesAmount;
    }

    public BigDecimal getTotalNotesAmount() {
        return totalNotesAmount;
    }

    public BigDecimal getCoinsTotal() {
        return coinsTotal;
    }

    public BigDecimal getCashTotal() {
        return cashTotal;
    }

    public BigDecimal getTidTotal() {
        return tidTotal;
    }

    public BigDecimal getCreditTotal() {
        return creditTotal;
    }

    public BigDecimal getAdditiveAdjustmentTotal() {
        return additiveAdjustmentTotal;
    }

    public BigDecimal getDeductiveAdjustmentTotal() {
        return deductiveAdjustmentTotal;
    }

    public BigDecimal getAccountedAmount() {
        return accountedAmount;
    }

    public BigDecimal getDifferenceAmount() {
        return differenceAmount;
    }

    public BigDecimal getAllowedTolerance() {
        return allowedTolerance;
    }

    public ReconciliationStatus getReconciliationStatus() {
        return reconciliationStatus;
    }
}