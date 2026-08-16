package com.bpcl.reconciliation.domain.payment;

import com.bpcl.reconciliation.domain.organization.Organization;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "adjustment_type",
        schema = "reconciliation"
)
public class AdjustmentType extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "organization_id",
            nullable = false
    )
    private Organization organization;

    @Column(
            name = "adjustment_type_code",
            nullable = false,
            length = 50
    )
    private String adjustmentTypeCode;

    @Column(
            name = "adjustment_type_name",
            nullable = false,
            length = 150
    )
    private String adjustmentTypeName;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "direction",
            nullable = false,
            length = 40
    )
    private AdjustmentDirection direction;

    @Column(
            name = "requires_approval",
            nullable = false
    )
    private boolean requiresApproval = true;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected AdjustmentType() {
    }

    public AdjustmentType(
            Organization organization,
            String adjustmentTypeCode,
            String adjustmentTypeName,
            AdjustmentDirection direction,
            boolean requiresApproval) {

        this.organization = organization;
        this.adjustmentTypeCode = adjustmentTypeCode;
        this.adjustmentTypeName = adjustmentTypeName;
        this.direction = direction;
        this.requiresApproval = requiresApproval;
        this.active = true;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getAdjustmentTypeCode() {
        return adjustmentTypeCode;
    }

    public void setAdjustmentTypeCode(
            String adjustmentTypeCode) {

        this.adjustmentTypeCode = adjustmentTypeCode;
    }

    public String getAdjustmentTypeName() {
        return adjustmentTypeName;
    }

    public void setAdjustmentTypeName(
            String adjustmentTypeName) {

        this.adjustmentTypeName = adjustmentTypeName;
    }

    public AdjustmentDirection getDirection() {
        return direction;
    }

    public void setDirection(
            AdjustmentDirection direction) {

        this.direction = direction;
    }

    public boolean isRequiresApproval() {
        return requiresApproval;
    }

    public void setRequiresApproval(
            boolean requiresApproval) {

        this.requiresApproval = requiresApproval;
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