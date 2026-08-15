package com.bpcl.reconciliation.domain.organization;

import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "organization",
        schema = "reconciliation"
)
public class Organization extends BaseEntity {

    @Column(
            name = "organization_code",
            nullable = false,
            length = 30,
            unique = true
    )
    private String organizationCode;

    @Column(
            name = "organization_name",
            nullable = false,
            length = 150
    )
    private String organizationName;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected Organization() {
    }

    public Organization(
            String organizationCode,
            String organizationName) {

        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.active = true;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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