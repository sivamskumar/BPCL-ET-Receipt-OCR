package com.bpcl.reconciliation.domain.payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashDenominationRepository
        extends JpaRepository<CashDenomination, Long> {

    Optional<CashDenomination>
            findByCurrencyCodeAndDenominationValue(
                    String currencyCode,
                    BigDecimal denominationValue);

    boolean existsByCurrencyCodeAndDenominationValue(
            String currencyCode,
            BigDecimal denominationValue);

    List<CashDenomination>
            findByCurrencyCodeAndActiveTrueOrderByDisplayOrderAsc(
                    String currencyCode);
}