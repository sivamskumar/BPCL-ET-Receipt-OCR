package com.bpcl.reconciliation.domain.organization;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository
        extends JpaRepository<Organization, Long> {

    Optional<Organization> findByOrganizationCode(
            String organizationCode);

    boolean existsByOrganizationCode(
            String organizationCode);
}