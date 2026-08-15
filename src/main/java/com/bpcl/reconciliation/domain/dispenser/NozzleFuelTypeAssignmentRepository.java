package com.bpcl.reconciliation.domain.dispenser;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NozzleFuelTypeAssignmentRepository
        extends JpaRepository<NozzleFuelTypeAssignment, Long> {

    List<NozzleFuelTypeAssignment> findByNozzleIdOrderByEffectiveFromDesc(
            Long nozzleId);

    Optional<NozzleFuelTypeAssignment>
            findFirstByNozzleIdAndEffectiveFromLessThanEqualAndActiveTrueOrderByEffectiveFromDesc(
                    Long nozzleId,
                    OffsetDateTime effectiveAt);
}