package com.bpcl.reconciliation.domain.receipt;

public enum ReceiptProcessingStatus {

    UPLOADED,
    VALIDATING_IMAGE,
    IMAGE_VALIDATED,
    PREPROCESSING,
    OCR_IN_PROGRESS,
    OCR_COMPLETED,
    PARSING,
    PARSED,
    REVIEW_REQUIRED,
    CONFIRMED,
    FAILED,
    REJECTED
}