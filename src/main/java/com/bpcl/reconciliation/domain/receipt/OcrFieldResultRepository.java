package com.bpcl.reconciliation.domain.receipt;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrFieldResultRepository
        extends JpaRepository<OcrFieldResult, Long> {

    List<OcrFieldResult>
            findByOcrProcessingAttemptIdOrderByIdAsc(
                    Long ocrProcessingAttemptId);

    List<OcrFieldResult>
            findByOcrProcessingAttemptIdAndFieldName(
                    Long ocrProcessingAttemptId,
                    String fieldName);

    List<OcrFieldResult>
            findByOcrProcessingAttemptIdAndNozzleNumberOrderByIdAsc(
                    Long ocrProcessingAttemptId,
                    Integer nozzleNumber);

    List<OcrFieldResult>
            findByFieldNameAndConfidenceLessThanOrderByConfidenceAsc(
                    String fieldName,
                    BigDecimal confidence);
}