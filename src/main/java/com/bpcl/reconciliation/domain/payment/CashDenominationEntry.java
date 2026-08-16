package com.bpcl.reconciliation.domain.payment;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.shift.Shift;

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
import jakarta.persistence.Version;

@Entity
@Table(
        name = "cash_denomination_entry",
        schema = "reconciliation"
)
public class CashDenominationEntry {

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
            name = "employee_id",
            nullable = false
    )
    private Employee employee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "cash_denomination_id",
            nullable = false
    )
    private CashDenomination cashDenomination;

    @Column(
            name = "denomination_value_snapshot",
            nullable = false,
            precision = 12,
            scale = 2
    )
    private BigDecimal denominationValueSnapshot;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    @Column(
            name = "calculated_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal calculatedAmount;

    @Column(
            name = "entered_by",
            nullable = false
    )
    private Long enteredBy;

    @Column(
            name = "entered_at",
            nullable = false
    )
    private OffsetDateTime enteredAt;

    @Column(
            name = "updated_at"
    )
    private OffsetDateTime updatedAt;

    @Column(
            name = "updated_by"
    )
    private Long updatedBy;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    protected CashDenominationEntry() {
    }

    public CashDenominationEntry(
            Shift shift,
            Employee employee,
            CashDenomination cashDenomination,
            Integer quantity,
            Long enteredBy) {

        this.shift = shift;
        this.employee = employee;
        this.cashDenomination = cashDenomination;
        this.denominationValueSnapshot =
                cashDenomination.getDenominationValue();

        this.quantity = quantity;
        this.calculatedAmount =
                this.denominationValueSnapshot.multiply(
                        BigDecimal.valueOf(quantity));

        this.enteredBy = enteredBy;
    }

    @PrePersist
    protected void onCreate() {
        if (enteredAt == null) {
            enteredAt = OffsetDateTime.now();
        }

        if (version == null) {
            version = 0L;
        }
    }

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public CashDenomination getCashDenomination() {
        return cashDenomination;
    }

    public BigDecimal getDenominationValueSnapshot() {
        return denominationValueSnapshot;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public Long getEnteredBy() {
        return enteredBy;
    }

    public OffsetDateTime getEnteredAt() {
        return enteredAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public Long getVersion() {
        return version;
    }

    public void updateQuantity(
            Integer quantity,
            Long updatedBy) {

        this.quantity = quantity;

        this.calculatedAmount =
                this.denominationValueSnapshot.multiply(
                        BigDecimal.valueOf(quantity));

        this.updatedBy = updatedBy;
        this.updatedAt = OffsetDateTime.now();
    }
}