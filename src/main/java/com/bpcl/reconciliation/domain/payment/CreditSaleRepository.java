package com.bpcl.reconciliation.domain.payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditSaleRepository
        extends JpaRepository<CreditSale, Long> {

    List<CreditSale>
            findByShiftIdAndEmployeeIdOrderByEnteredAtAsc(
                    Long shiftId,
                    Long employeeId);

    List<CreditSale>
            findByShiftIdAndSettlementStatusOrderByEnteredAtAsc(
                    Long shiftId,
                    CreditSaleSettlementStatus settlementStatus);

    List<CreditSale>
            findBySettlementStatusOrderByEnteredAtAsc(
                    CreditSaleSettlementStatus settlementStatus);
}