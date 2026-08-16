package com.bpcl.reconciliation.domain.receipt;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.dispenser.DispenserSide;
import com.bpcl.reconciliation.domain.shift.Shift;
import com.bpcl.reconciliation.domain.shift.ShiftDispenserUnit;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(
        name = "receipt",
        schema = "reconciliation"
)
public class Receipt {

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
            name = "shift_employee_id",
            nullable = false
    )
    private ShiftEmployee shiftEmployee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_dispenser_unit_id",
            nullable = false
    )
    private ShiftDispenserUnit shiftDispenserUnit;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "dispenser_side_id",
            nullable = false
    )
    private DispenserSide dispenserSide;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "receipt_type",
            nullable = false,
            length = 20
    )
    private ReceiptType receiptType;

    @Column(
            name = "du_serial_number",
            length = 100
    )
    private String duSerialNumber;

    @Column(
            name = "normalized_du_serial_number",
            length = 100
    )
    private String normalizedDuSerialNumber;

    @Column(
            name = "receipt_datetime"
    )
    private OffsetDateTime receiptDatetime;

    @Column(
            name = "original_filename",
            nullable = false,
            length = 255
    )
    private String originalFilename;

    @Column(
            name = "stored_filename",
            nullable = false,
            length = 255
    )
    private String storedFilename;

    @Column(
            name = "storage_path",
            nullable = false,
            length = 1000
    )
    private String storagePath;

    @Column(
            name = "content_type",
            nullable = false,
            length = 100
    )
    private String contentType;

    @Column(
            name = "file_size",
            nullable = false
    )
    private Long fileSize;

    @Column(
            name = "sha256_hash",
            nullable = false,
            length = 64
    )
    private String sha256Hash;

    @Column(
            name = "image_width"
    )
    private Integer imageWidth;

    @Column(
            name = "image_height"
    )
    private Integer imageHeight;

    @Column(
            name = "ocr_raw_text",
            columnDefinition = "TEXT"
    )
    private String ocrRawText;

    @Column(
            name = "ocr_confidence",
            precision = 5,
            scale = 2
    )
    private BigDecimal ocrConfidence;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "processing_status",
            nullable = false,
            length = 40
    )
    private ReceiptProcessingStatus processingStatus;

    @Column(
            name = "manual_correction_applied",
            nullable = false
    )
    private boolean manualCorrectionApplied = false;

    @Column(
            name = "uploaded_by",
            nullable = false
    )
    private Long uploadedBy;

    @Column(
            name = "uploaded_at",
            nullable = false
    )
    private OffsetDateTime uploadedAt;

    @Column(
            name = "confirmed_by"
    )
    private Long confirmedBy;

    @Column(
            name = "confirmed_at"
    )
    private OffsetDateTime confirmedAt;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "replaced_receipt_id")
    private Receipt replacedReceipt;

    @Column(
            name = "replacement_reason",
            length = 1000
    )
    private String replacementReason;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    protected Receipt() {
    }

    public Receipt(
            Shift shift,
            ShiftEmployee shiftEmployee,
            ShiftDispenserUnit shiftDispenserUnit,
            DispenserSide dispenserSide,
            ReceiptType receiptType,
            String originalFilename,
            String storedFilename,
            String storagePath,
            String contentType,
            Long fileSize,
            String sha256Hash,
            Long uploadedBy) {

        this.shift = shift;
        this.shiftEmployee = shiftEmployee;
        this.shiftDispenserUnit = shiftDispenserUnit;
        this.dispenserSide = dispenserSide;
        this.receiptType = receiptType;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.storagePath = storagePath;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.sha256Hash = sha256Hash;
        this.uploadedBy = uploadedBy;

        this.processingStatus = ReceiptProcessingStatus.UPLOADED;
        this.manualCorrectionApplied = false;
        this.active = true;
    }

    @PrePersist
    protected void onCreate() {
        if (uploadedAt == null) {
            uploadedAt = OffsetDateTime.now();
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

    public ShiftEmployee getShiftEmployee() {
        return shiftEmployee;
    }

    public ShiftDispenserUnit getShiftDispenserUnit() {
        return shiftDispenserUnit;
    }

    public DispenserSide getDispenserSide() {
        return dispenserSide;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public String getDuSerialNumber() {
        return duSerialNumber;
    }

    public String getNormalizedDuSerialNumber() {
        return normalizedDuSerialNumber;
    }

    public OffsetDateTime getReceiptDatetime() {
        return receiptDatetime;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public String getStoredFilename() {
        return storedFilename;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public String getContentType() {
        return contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getSha256Hash() {
        return sha256Hash;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public String getOcrRawText() {
        return ocrRawText;
    }

    public BigDecimal getOcrConfidence() {
        return ocrConfidence;
    }

    public ReceiptProcessingStatus getProcessingStatus() {
        return processingStatus;
    }

    public boolean isManualCorrectionApplied() {
        return manualCorrectionApplied;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public OffsetDateTime getUploadedAt() {
        return uploadedAt;
    }

    public Long getConfirmedBy() {
        return confirmedBy;
    }

    public OffsetDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public boolean isActive() {
        return active;
    }

    public Receipt getReplacedReceipt() {
        return replacedReceipt;
    }

    public String getReplacementReason() {
        return replacementReason;
    }

    public Long getVersion() {
        return version;
    }

    public void updateExtractedReceiptDetails(
            String duSerialNumber,
            String normalizedDuSerialNumber,
            OffsetDateTime receiptDatetime) {

        this.duSerialNumber = duSerialNumber;
        this.normalizedDuSerialNumber = normalizedDuSerialNumber;
        this.receiptDatetime = receiptDatetime;
    }

    public void updateImageDimensions(
            Integer imageWidth,
            Integer imageHeight) {

        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public void updateOcrResult(
            String ocrRawText,
            BigDecimal ocrConfidence) {

        this.ocrRawText = ocrRawText;
        this.ocrConfidence = ocrConfidence;
    }

    public void changeProcessingStatus(
            ReceiptProcessingStatus processingStatus) {

        this.processingStatus = processingStatus;
    }

    public void markManualCorrectionApplied() {
        this.manualCorrectionApplied = true;
    }

    public void confirm(
            Long confirmedBy,
            OffsetDateTime confirmedAt) {

        this.confirmedBy = confirmedBy;
        this.confirmedAt = confirmedAt;
        this.processingStatus = ReceiptProcessingStatus.CONFIRMED;
    }

    public void replaceWith(
            String replacementReason) {

        this.active = false;
        this.replacementReason = replacementReason;
    }

    public void setReplacedReceipt(
            Receipt replacedReceipt) {

        this.replacedReceipt = replacedReceipt;
    }
}