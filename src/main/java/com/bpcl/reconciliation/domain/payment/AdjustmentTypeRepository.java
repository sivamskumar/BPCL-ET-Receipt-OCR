package com.bpcl.reconciliation.domain.payment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjustmentTypeRepository
        extends JpaRepository<AdjustmentType, Long> {

    Optional<AdjustmentType>
            findByOrganizationIdAndAdjustmentTypeCode(
                    Long organizationId,
                    String adjustmentTypeCode);

    boolean existsByOrganizationIdAndAdjustmentTypeCode(
            Long organizationId,
            String adjustmentTypeCode);

    List<AdjustmentType>
            findByOrganizationIdAndActiveTrueOrderByAdjustmentTypeNameAsc(
                    Long organizationId);
}