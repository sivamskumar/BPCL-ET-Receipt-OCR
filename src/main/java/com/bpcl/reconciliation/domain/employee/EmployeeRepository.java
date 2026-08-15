package com.bpcl.reconciliation.domain.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    Optional<Employee> findByOrganizationIdAndEmployeeCode(
            Long organizationId,
            String employeeCode);

    boolean existsByOrganizationIdAndEmployeeCode(
            Long organizationId,
            String employeeCode);

    List<Employee> findByOrganizationIdAndEmploymentStatus(
            Long organizationId,
            EmploymentStatus employmentStatus);

    List<Employee> findByOrganizationIdAndEmploymentStatusOrderByEmployeeNameAsc(
            Long organizationId,
            EmploymentStatus employmentStatus);
}