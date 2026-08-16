package com.bpcl.reconciliation.domain.receipt;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository
        extends JpaRepository<Receipt, Long> {

    Optional<Receipt>
            findByShiftEmployeeIdAndReceiptTypeAndActiveTrue(
                    Long shiftEmployeeId,
                    ReceiptType receiptType);

    boolean existsByShiftEmployeeIdAndReceiptTypeAndActiveTrue(
            Long shiftEmployeeId,
            ReceiptType receiptType);

    List<Receipt>
            findByShiftEmployeeIdOrderByUploadedAtAsc(
                    Long shiftEmployeeId);

    List<Receipt>
            findByShiftIdAndReceiptTypeAndActiveTrue(
                    Long shiftId,
                    ReceiptType receiptType);

    List<Receipt>
            findBySha256Hash(
                    String sha256Hash);

    List<Receipt>
            findByProcessingStatusOrderByUploadedAtAsc(
                    ReceiptProcessingStatus processingStatus);
}