package com.bpcl.reconciliation.domain.receipt;

import java.time.OffsetDateTime;

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
        name = "manual_correction",
        schema = "reconciliation"
)
public class ManualCorrection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "receipt_id",
            nullable = false
    )
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_nozzle_reading_id")
    private ReceiptNozzleReading receiptNozzleReading;

    @Column(
            name = "field_name",
            nullable = false,
            length = 100
    )
    private String fieldName;

    @Column(
            name = "original_value",
            length = 500
    )
    private String originalValue;

    @Column(
            name = "corrected_value",
            nullable = false,
            length = 500
    )
    private String correctedValue;

    @Column(
            name = "reason",
            nullable = false,
            length = 1000
    )
    private String reason;

    @Column(
            name = "corrected_by",
            nullable = false
    )
    private Long correctedBy;

    @Column(
            name = "corrected_at",
            nullable = false
    )
    private OffsetDateTime correctedAt;

    protected ManualCorrection() {
    }

    public ManualCorrection(
            Receipt receipt,
            ReceiptNozzleReading receiptNozzleReading,
            String fieldName,
            String originalValue,
            String correctedValue,
            String reason,
            Long correctedBy) {

        this.receipt = receipt;
        this.receiptNozzleReading = receiptNozzleReading;
        this.fieldName = fieldName;
        this.originalValue = originalValue;
        this.correctedValue = correctedValue;
        this.reason = reason;
        this.correctedBy = correctedBy;
    }

    @PrePersist
    protected void onCreate() {
        if (correctedAt == null) {
            correctedAt = OffsetDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public ReceiptNozzleReading getReceiptNozzleReading() {
        return receiptNozzleReading;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public String getCorrectedValue() {
        return correctedValue;
    }

    public String getReason() {
        return reason;
    }

    public Long getCorrectedBy() {
        return correctedBy;
    }

    public OffsetDateTime getCorrectedAt() {
        return correctedAt;
    }
}