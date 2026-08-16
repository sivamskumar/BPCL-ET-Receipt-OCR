package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShiftNozzleAssignmentRepository
        extends JpaRepository<ShiftNozzleAssignment, Long> {

    List<ShiftNozzleAssignment>
            findByShiftIdAndEmployeeIdOrderByNozzleNumberSnapshotAsc(
                    Long shiftId,
                    Long employeeId);

    List<ShiftNozzleAssignment>
            findByShiftEmployeeIdOrderByNozzleNumberSnapshotAsc(
                    Long shiftEmployeeId);

    List<ShiftNozzleAssignment>
            findByShiftIdAndNozzleIdOrderByAssignedAtAsc(
                    Long shiftId,
                    Long nozzleId);

    @Query("""
            SELECT sna
            FROM ShiftNozzleAssignment sna
            WHERE sna.shift.id = :shiftId
              AND sna.nozzle.id = :nozzleId
              AND sna.assignedAt <= :effectiveAt
              AND (
                    sna.releasedAt IS NULL
                    OR sna.releasedAt > :effectiveAt
                  )
            ORDER BY sna.assignedAt DESC
            """)
    List<ShiftNozzleAssignment> findEffectiveAssignments(
            @Param("shiftId") Long shiftId,
            @Param("nozzleId") Long nozzleId,
            @Param("effectiveAt") OffsetDateTime effectiveAt);
}