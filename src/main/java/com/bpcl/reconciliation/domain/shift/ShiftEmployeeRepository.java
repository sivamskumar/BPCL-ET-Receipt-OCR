package com.bpcl.reconciliation.domain.shift;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftEmployeeRepository
        extends JpaRepository<ShiftEmployee, Long> {

    Optional<ShiftEmployee>
            findByShiftIdAndEmployeeId(
                    Long shiftId,
                    Long employeeId);

    boolean existsByShiftIdAndEmployeeId(
            Long shiftId,
            Long employeeId);

    List<ShiftEmployee>
            findByShiftIdOrderByEmployeeNameSnapshotAsc(
                    Long shiftId);

    List<ShiftEmployee>
            findByEmployeeIdOrderByCreatedAtDesc(
                    Long employeeId);
}