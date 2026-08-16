package com.bpcl.reconciliation.domain.security;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.organization.Organization;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "application_user",
        schema = "reconciliation"
)
public class ApplicationUser extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "organization_id",
            nullable = false
    )
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(
            name = "username",
            nullable = false,
            length = 100
    )
    private String username;

    @Column(
            name = "password_hash",
            nullable = false,
            length = 255
    )
    private String passwordHash;

    @Column(
            name = "display_name",
            nullable = false,
            length = 150
    )
    private String displayName;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    @Column(
            name = "account_locked",
            nullable = false
    )
    private boolean accountLocked = false;

    @Column(
            name = "password_change_required",
            nullable = false
    )
    private boolean passwordChangeRequired = true;

    @Column(
            name = "failed_login_count",
            nullable = false
    )
    private Integer failedLoginCount = 0;

    @Column(
            name = "last_login_at"
    )
    private OffsetDateTime lastLoginAt;

    protected ApplicationUser() {
    }

    public ApplicationUser(
            Organization organization,
            Employee employee,
            String username,
            String passwordHash,
            String displayName) {

        this.organization = organization;
        this.employee = employee;
        this.username = username;
        this.passwordHash = passwordHash;
        this.displayName = displayName;

        this.active = true;
        this.accountLocked = false;
        this.passwordChangeRequired = true;
        this.failedLoginCount = 0;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(
            Organization organization) {

        this.organization = organization;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public boolean isPasswordChangeRequired() {
        return passwordChangeRequired;
    }

    public Integer getFailedLoginCount() {
        return failedLoginCount;
    }

    public OffsetDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void changePassword(
            String passwordHash,
            boolean passwordChangeRequired) {

        this.passwordHash = passwordHash;
        this.passwordChangeRequired =
                passwordChangeRequired;
    }

    public void requirePasswordChange() {
        this.passwordChangeRequired = true;
    }

    public void markPasswordChanged(
            String passwordHash) {

        this.passwordHash = passwordHash;
        this.passwordChangeRequired = false;
    }

    public void recordFailedLogin() {
        this.failedLoginCount =
                this.failedLoginCount + 1;
    }

    public void recordSuccessfulLogin(
            OffsetDateTime loginAt) {

        this.failedLoginCount = 0;
        this.lastLoginAt = loginAt;
    }

    public void lockAccount() {
        this.accountLocked = true;
    }

    public void unlockAccount() {
        this.accountLocked = false;
        this.failedLoginCount = 0;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}