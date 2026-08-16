package com.bpcl.reconciliation.domain.payment;

import java.math.BigDecimal;

import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "cash_denomination",
        schema = "reconciliation"
)
public class CashDenomination extends BaseEntity {

    @Column(
            name = "currency_code",
            nullable = false,
            length = 3
    )
    private String currencyCode;

    @Column(
            name = "denomination_value",
            nullable = false,
            precision = 12,
            scale = 2
    )
    private BigDecimal denominationValue;

    @Column(
            name = "display_order",
            nullable = false
    )
    private Integer displayOrder;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected CashDenomination() {
    }

    public CashDenomination(
            String currencyCode,
            BigDecimal denominationValue,
            Integer displayOrder) {

        this.currencyCode = currencyCode;
        this.denominationValue = denominationValue;
        this.displayOrder = displayOrder;
        this.active = true;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getDenominationValue() {
        return denominationValue;
    }

    public void setDenominationValue(BigDecimal denominationValue) {
        this.denominationValue = denominationValue;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}