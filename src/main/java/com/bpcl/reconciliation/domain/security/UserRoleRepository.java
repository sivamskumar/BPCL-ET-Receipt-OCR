package com.bpcl.reconciliation.domain.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository
        extends JpaRepository<UserRole, UserRoleId> {

    List<UserRole> findByUser_Id(
            Long userId);

    List<UserRole> findByRole_Id(
            Long roleId);

    boolean existsByUser_IdAndRole_Id(
            Long userId,
            Long roleId);

    void deleteByUser_IdAndRole_Id(
            Long userId,
            Long roleId);
}