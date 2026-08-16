package com.bpcl.reconciliation.domain.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "role",
        schema = "reconciliation"
)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "role_code",
            nullable = false,
            length = 50,
            unique = true
    )
    private String roleCode;

    @Column(
            name = "role_name",
            nullable = false,
            length = 100
    )
    private String roleName;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected Role() {
    }

    public Role(
            String roleCode,
            String roleName) {

        this.roleCode = roleCode;
        this.roleName = roleName;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
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