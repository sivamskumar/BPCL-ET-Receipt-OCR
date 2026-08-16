package com.bpcl.reconciliation.domain.receipt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualCorrectionRepository
        extends JpaRepository<ManualCorrection, Long> {

    List<ManualCorrection>
            findByReceiptIdOrderByCorrectedAtAsc(
                    Long receiptId);

    List<ManualCorrection>
            findByReceiptNozzleReadingIdOrderByCorrectedAtAsc(
                    Long receiptNozzleReadingId);

    List<ManualCorrection>
            findByCorrectedByOrderByCorrectedAtDesc(
                    Long correctedBy);
}