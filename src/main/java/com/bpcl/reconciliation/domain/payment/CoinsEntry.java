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
        name = "coins_entry",
        schema = "reconciliation"
)
public class CoinsEntry {

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

    @Column(
            name = "amount",
            nullable = false,
            precision = 14,
            scale = 2
    )
    private BigDecimal amount;

    @Column(
            name = "entered_at",
            nullable = false
    )
    private OffsetDateTime enteredAt;

    @Column(
            name = "entered_by",
            nullable = false
    )
    private Long enteredBy;

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

    protected CoinsEntry() {
    }

    public CoinsEntry(
            Shift shift,
            Employee employee,
            BigDecimal amount,
            Long enteredBy) {

        this.shift = shift;
        this.employee = employee;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public OffsetDateTime getEnteredAt() {
        return enteredAt;
    }

    public Long getEnteredBy() {
        return enteredBy;
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

    public void updateAmount(
            BigDecimal amount,
            Long updatedBy) {

        this.amount = amount;
        this.updatedBy = updatedBy;
        this.updatedAt = OffsetDateTime.now();
    }
}