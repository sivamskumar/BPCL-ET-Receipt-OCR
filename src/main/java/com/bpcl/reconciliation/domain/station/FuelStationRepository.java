package com.bpcl.reconciliation.domain.station;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelStationRepository
        extends JpaRepository<FuelStation, Long> {

    Optional<FuelStation> findByOrganizationIdAndStationCode(
            Long organizationId,
            String stationCode);

    boolean existsByOrganizationIdAndStationCode(
            Long organizationId,
            String stationCode);

    List<FuelStation> findByOrganizationIdAndActiveTrue(
            Long organizationId);
}