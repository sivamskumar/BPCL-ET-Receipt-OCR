package com.bpcl.reconciliation.domain.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelSaleRepository
        extends JpaRepository<FuelSale, Long> {

    Optional<FuelSale>
            findByShiftNozzleAssignmentIdAndCalculationVersion(
                    Long shiftNozzleAssignmentId,
                    Integer calculationVersion);

    List<FuelSale>
            findByShiftIdAndEmployeeIdOrderByIdAsc(
                    Long shiftId,
                    Long employeeId);

    List<FuelSale>
            findByShiftIdOrderByIdAsc(
                    Long shiftId);

    List<FuelSale>
            findByShiftIdAndFuelTypeIdOrderByIdAsc(
                    Long shiftId,
                    Long fuelTypeId);

    List<FuelSale>
            findByNozzleIdOrderByCalculatedAtDesc(
                    Long nozzleId);
}