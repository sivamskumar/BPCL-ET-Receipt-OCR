package com.bpcl.reconciliation.domain.shift;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeShiftHoursRepository
        extends JpaRepository<EmployeeShiftHours, Long> {

    Optional<EmployeeShiftHours>
            findByShiftIdAndEmployeeId(
                    Long shiftId,
                    Long employeeId);

    Optional<EmployeeShiftHours>
            findByShiftEmployeeId(
                    Long shiftEmployeeId);

    boolean existsByShiftIdAndEmployeeId(
            Long shiftId,
            Long employeeId);

    List<EmployeeShiftHours>
            findByShiftIdOrderByStartedAtAsc(
                    Long shiftId);

    List<EmployeeShiftHours>
            findByEmployeeIdOrderByStartedAtDesc(
                    Long employeeId);
}