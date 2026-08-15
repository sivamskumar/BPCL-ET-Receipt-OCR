package com.bpcl.reconciliation.domain.fuel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository
        extends JpaRepository<FuelType, Long> {

    Optional<FuelType> findByFuelCode(
            String fuelCode);

    boolean existsByFuelCode(
            String fuelCode);

    List<FuelType> findByActiveTrue();
}