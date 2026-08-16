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
        name = "tid_collection",
        schema = "reconciliation"
)
public class TidCollection {

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
            name = "terminal_identifier",
            nullable = false,
            length = 100
    )
    private String terminalIdentifier;

    @Column(
            name = "amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal amount;

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

    protected TidCollection() {
    }

    public TidCollection(
            Shift shift,
            Employee employee,
            String terminalIdentifier,
            BigDecimal amount,
            Long enteredBy) {

        this.shift = shift;
        this.employee = employee;
        this.terminalIdentifier = terminalIdentifier;
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

    public String getTerminalIdentifier() {
        return terminalIdentifier;
    }

    public BigDecimal getAmount() {
        return amount;
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

    public void update(
            String terminalIdentifier,
            BigDecimal amount,
            Long updatedBy) {

        this.terminalIdentifier = terminalIdentifier;
        this.amount = amount;
        this.updatedBy = updatedBy;
        this.updatedAt = OffsetDateTime.now();
    }
}