package com.bpcl.reconciliation.domain.receipt;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "ocr_field_result",
        schema = "reconciliation"
)
public class OcrFieldResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "ocr_processing_attempt_id",
            nullable = false
    )
    private OcrProcessingAttempt ocrProcessingAttempt;

    @Column(
            name = "field_name",
            nullable = false,
            length = 100
    )
    private String fieldName;

    @Column(
            name = "nozzle_number"
    )
    private Integer nozzleNumber;

    @Column(
            name = "recognized_text",
            length = 500
    )
    private String recognizedText;

    @Column(
            name = "normalized_text",
            length = 500
    )
    private String normalizedText;

    @Column(
            name = "confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal confidence;

    @Column(
            name = "bounding_x"
    )
    private Integer boundingX;

    @Column(
            name = "bounding_y"
    )
    private Integer boundingY;

    @Column(
            name = "bounding_width"
    )
    private Integer boundingWidth;

    @Column(
            name = "bounding_height"
    )
    private Integer boundingHeight;

    @Column(
            name = "warning_message",
            length = 1000
    )
    private String warningMessage;

    protected OcrFieldResult() {
    }

    public OcrFieldResult(
            OcrProcessingAttempt ocrProcessingAttempt,
            String fieldName,
            Integer nozzleNumber,
            String recognizedText,
            String normalizedText,
            BigDecimal confidence) {

        this.ocrProcessingAttempt = ocrProcessingAttempt;
        this.fieldName = fieldName;
        this.nozzleNumber = nozzleNumber;
        this.recognizedText = recognizedText;
        this.normalizedText = normalizedText;
        this.confidence = confidence;
    }

    public Long getId() {
        return id;
    }

    public OcrProcessingAttempt getOcrProcessingAttempt() {
        return ocrProcessingAttempt;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Integer getNozzleNumber() {
        return nozzleNumber;
    }

    public String getRecognizedText() {
        return recognizedText;
    }

    public String getNormalizedText() {
        return normalizedText;
    }

    public BigDecimal getConfidence() {
        return confidence;
    }

    public Integer getBoundingX() {
        return boundingX;
    }

    public Integer getBoundingY() {
        return boundingY;
    }

    public Integer getBoundingWidth() {
        return boundingWidth;
    }

    public Integer getBoundingHeight() {
        return boundingHeight;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setBoundingBox(
            Integer boundingX,
            Integer boundingY,
            Integer boundingWidth,
            Integer boundingHeight) {

        this.boundingX = boundingX;
        this.boundingY = boundingY;
        this.boundingWidth = boundingWidth;
        this.boundingHeight = boundingHeight;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }
}