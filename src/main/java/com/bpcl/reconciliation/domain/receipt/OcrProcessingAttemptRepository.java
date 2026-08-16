package com.bpcl.reconciliation.domain.receipt;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrProcessingAttemptRepository
        extends JpaRepository<OcrProcessingAttempt, Long> {

    List<OcrProcessingAttempt>
            findByReceiptIdOrderByAttemptNumberAsc(
                    Long receiptId);

    Optional<OcrProcessingAttempt>
            findFirstByReceiptIdOrderByAttemptNumberDesc(
                    Long receiptId);

    Optional<OcrProcessingAttempt>
            findByReceiptIdAndAttemptNumber(
                    Long receiptId,
                    Integer attemptNumber);

    boolean existsByReceiptIdAndAttemptNumber(
            Long receiptId,
            Integer attemptNumber);
}