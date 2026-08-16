package com.bpcl.reconciliation.domain.payment;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.shift.Shift;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(
        name = "credit_sale",
        schema = "reconciliation"
)
public class CreditSale {

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
            name = "customer_name",
            nullable = false,
            length = 200
    )
    private String customerName;

    @Column(
            name = "customer_reference",
            length = 150
    )
    private String customerReference;

    @Column(
            name = "vehicle_number",
            length = 50
    )
    private String vehicleNumber;

    @Column(
            name = "amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal amount;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

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

    @Enumerated(EnumType.STRING)
    @Column(
            name = "settlement_status",
            nullable = false,
            length = 30
    )
    private CreditSaleSettlementStatus settlementStatus =
            CreditSaleSettlementStatus.OUTSTANDING;

    @Column(
            name = "settled_at"
    )
    private OffsetDateTime settledAt;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    protected CreditSale() {
    }

    public CreditSale(
            Shift shift,
            Employee employee,
            String customerName,
            String customerReference,
            String vehicleNumber,
            BigDecimal amount,
            String remarks,
            Long enteredBy) {

        this.shift = shift;
        this.employee = employee;
        this.customerName = customerName;
        this.customerReference = customerReference;
        this.vehicleNumber = vehicleNumber;
        this.amount = amount;
        this.remarks = remarks;
        this.enteredBy = enteredBy;
        this.settlementStatus =
                CreditSaleSettlementStatus.OUTSTANDING;
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

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public Long getEnteredBy() {
        return enteredBy;
    }

    public OffsetDateTime getEnteredAt() {
        return enteredAt;
    }

    public CreditSaleSettlementStatus getSettlementStatus() {
        return settlementStatus;
    }

    public OffsetDateTime getSettledAt() {
        return settledAt;
    }

    public Long getVersion() {
        return version;
    }

    public void markPartiallySettled() {
        this.settlementStatus =
                CreditSaleSettlementStatus.PARTIALLY_SETTLED;
        this.settledAt = null;
    }

    public void markSettled(OffsetDateTime settledAt) {
        this.settlementStatus =
                CreditSaleSettlementStatus.SETTLED;
        this.settledAt = settledAt;
    }

    public void cancel() {
        this.settlementStatus =
                CreditSaleSettlementStatus.CANCELLED;
        this.settledAt = null;
    }
}