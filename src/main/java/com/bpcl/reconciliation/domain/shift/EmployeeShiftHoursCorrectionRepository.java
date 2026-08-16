package com.bpcl.reconciliation.domain.shift;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeShiftHoursCorrectionRepository
        extends JpaRepository<EmployeeShiftHoursCorrection, Long> {

    List<EmployeeShiftHoursCorrection>
            findByEmployeeShiftHoursIdOrderByCorrectedAtAsc(
                    Long employeeShiftHoursId);

    List<EmployeeShiftHoursCorrection>
            findByCorrectedByOrderByCorrectedAtDesc(
                    Long correctedBy);
}