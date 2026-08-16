package com.bpcl.reconciliation.domain.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStationAccessRepository
        extends JpaRepository<
                UserStationAccess,
                UserStationAccessId> {

    List<UserStationAccess> findByUser_Id(
            Long userId);

    List<UserStationAccess> findByFuelStation_Id(
            Long fuelStationId);

    boolean existsByUser_IdAndFuelStation_Id(
            Long userId,
            Long fuelStationId);

    void deleteByUser_IdAndFuelStation_Id(
            Long userId,
            Long fuelStationId);
}