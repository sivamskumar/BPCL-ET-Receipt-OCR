package com.bpcl.reconciliation.domain.receipt;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
        name = "ocr_processing_attempt",
        schema = "reconciliation"
)
public class OcrProcessingAttempt {

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

    @Column(
            name = "attempt_number",
            nullable = false
    )
    private Integer attemptNumber;

    @Column(
            name = "preprocessing_profile",
            length = 100
    )
    private String preprocessingProfile;

    @Column(
            name = "raw_text",
            columnDefinition = "TEXT"
    )
    private String rawText;

    @Column(
            name = "average_confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal averageConfidence;

    @Column(
            name = "processing_duration_ms"
    )
    private Long processingDurationMs;

    @Column(
            name = "successful",
            nullable = false
    )
    private boolean successful = false;

    @Column(
            name = "error_message",
            columnDefinition = "TEXT"
    )
    private String errorMessage;

    @Column(
            name = "started_at",
            nullable = false
    )
    private OffsetDateTime startedAt;

    @Column(
            name = "completed_at"
    )
    private OffsetDateTime completedAt;

    protected OcrProcessingAttempt() {
    }

    public OcrProcessingAttempt(
            Receipt receipt,
            Integer attemptNumber,
            String preprocessingProfile,
            OffsetDateTime startedAt) {

        this.receipt = receipt;
        this.attemptNumber = attemptNumber;
        this.preprocessingProfile = preprocessingProfile;
        this.startedAt = startedAt;
        this.successful = false;
    }

    public Long getId() {
        return id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public String getPreprocessingProfile() {
        return preprocessingProfile;
    }

    public String getRawText() {
        return rawText;
    }

    public BigDecimal getAverageConfidence() {
        return averageConfidence;
    }

    public Long getProcessingDurationMs() {
        return processingDurationMs;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    public void completeSuccessfully(
            String rawText,
            BigDecimal averageConfidence,
            Long processingDurationMs,
            OffsetDateTime completedAt) {

        this.rawText = rawText;
        this.averageConfidence = averageConfidence;
        this.processingDurationMs = processingDurationMs;
        this.completedAt = completedAt;

        this.successful = true;
        this.errorMessage = null;
    }

    public void completeWithFailure(
            String rawText,
            Long processingDurationMs,
            String errorMessage,
            OffsetDateTime completedAt) {

        this.rawText = rawText;
        this.processingDurationMs = processingDurationMs;
        this.errorMessage = errorMessage;
        this.completedAt = completedAt;

        this.successful = false;
    }
}