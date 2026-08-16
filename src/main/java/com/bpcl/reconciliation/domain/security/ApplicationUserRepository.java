package com.bpcl.reconciliation.domain.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository
        extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser>
            findByOrganizationIdAndUsername(
                    Long organizationId,
                    String username);

    boolean existsByOrganizationIdAndUsername(
            Long organizationId,
            String username);

    Optional<ApplicationUser>
            findByEmployeeId(
                    Long employeeId);

    List<ApplicationUser>
            findByOrganizationIdAndActiveTrueOrderByDisplayNameAsc(
                    Long organizationId);

    List<ApplicationUser>
            findByOrganizationIdAndAccountLockedTrueOrderByUsernameAsc(
                    Long organizationId);
}