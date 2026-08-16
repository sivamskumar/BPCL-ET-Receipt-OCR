package com.bpcl.reconciliation.domain.receipt;

import java.math.BigDecimal;

import com.bpcl.reconciliation.domain.dispenser.Nozzle;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "receipt_nozzle_reading",
        schema = "reconciliation"
)
public class ReceiptNozzleReading extends BaseEntity {

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
    @JoinColumn(name = "nozzle_id")
    private Nozzle nozzle;

    @Column(
            name = "nozzle_number",
            nullable = false
    )
    private Integer nozzleNumber;

    @Column(
            name = "atot",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal atot;

    @Column(
            name = "vtot",
            nullable = false,
            precision = 19,
            scale = 3
    )
    private BigDecimal vtot;

    @Column(
            name = "ecal_factor",
            precision = 12,
            scale = 6
    )
    private BigDecimal ecalFactor;

    @Column(
            name = "atot_ocr_text",
            length = 100
    )
    private String atotOcrText;

    @Column(
            name = "vtot_ocr_text",
            length = 100
    )
    private String vtotOcrText;

    @Column(
            name = "ecal_ocr_text",
            length = 100
    )
    private String ecalOcrText;

    @Column(
            name = "atot_confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal atotConfidence;

    @Column(
            name = "vtot_confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal vtotConfidence;

    @Column(
            name = "ecal_confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal ecalConfidence;

    @Column(
            name = "manually_corrected",
            nullable = false
    )
    private boolean manuallyCorrected = false;

    protected ReceiptNozzleReading() {
    }

    public ReceiptNozzleReading(
            Receipt receipt,
            Integer nozzleNumber,
            BigDecimal atot,
            BigDecimal vtot) {

        this.receipt = receipt;
        this.nozzleNumber = nozzleNumber;
        this.atot = atot;
        this.vtot = vtot;
        this.manuallyCorrected = false;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public void setNozzle(Nozzle nozzle) {
        this.nozzle = nozzle;
    }

    public Integer getNozzleNumber() {
        return nozzleNumber;
    }

    public BigDecimal getAtot() {
        return atot;
    }

    public BigDecimal getVtot() {
        return vtot;
    }

    public BigDecimal getEcalFactor() {
        return ecalFactor;
    }

    public String getAtotOcrText() {
        return atotOcrText;
    }

    public String getVtotOcrText() {
        return vtotOcrText;
    }

    public String getEcalOcrText() {
        return ecalOcrText;
    }

    public BigDecimal getAtotConfidence() {
        return atotConfidence;
    }

    public BigDecimal getVtotConfidence() {
        return vtotConfidence;
    }

    public BigDecimal getEcalConfidence() {
        return ecalConfidence;
    }

    public boolean isManuallyCorrected() {
        return manuallyCorrected;
    }

    public void updateExtractedValues(
            BigDecimal atot,
            BigDecimal vtot,
            BigDecimal ecalFactor,
            String atotOcrText,
            String vtotOcrText,
            String ecalOcrText,
            BigDecimal atotConfidence,
            BigDecimal vtotConfidence,
            BigDecimal ecalConfidence) {

        this.atot = atot;
        this.vtot = vtot;
        this.ecalFactor = ecalFactor;

        this.atotOcrText = atotOcrText;
        this.vtotOcrText = vtotOcrText;
        this.ecalOcrText = ecalOcrText;

        this.atotConfidence = atotConfidence;
        this.vtotConfidence = vtotConfidence;
        this.ecalConfidence = ecalConfidence;
    }

    public void markManuallyCorrected() {
        this.manuallyCorrected = true;
    }

    public void correctAtot(BigDecimal correctedAtot) {
        this.atot = correctedAtot;
        this.manuallyCorrected = true;
    }

    public void correctVtot(BigDecimal correctedVtot) {
        this.vtot = correctedVtot;
        this.manuallyCorrected = true;
    }

    public void correctEcalFactor(
            BigDecimal correctedEcalFactor) {

        this.ecalFactor = correctedEcalFactor;
        this.manuallyCorrected = true;
    }
}