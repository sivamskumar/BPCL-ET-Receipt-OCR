package com.bpcl.reconciliation.domain.receipt;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptNozzleReadingRepository
        extends JpaRepository<ReceiptNozzleReading, Long> {

    Optional<ReceiptNozzleReading>
            findByReceiptIdAndNozzleNumber(
                    Long receiptId,
                    Integer nozzleNumber);

    boolean existsByReceiptIdAndNozzleNumber(
            Long receiptId,
            Integer nozzleNumber);

    List<ReceiptNozzleReading>
            findByReceiptIdOrderByNozzleNumberAsc(
                    Long receiptId);

    List<ReceiptNozzleReading>
            findByNozzleIdOrderByReceiptIdDesc(
                    Long nozzleId);
}