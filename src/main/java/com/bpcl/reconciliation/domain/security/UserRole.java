package com.bpcl.reconciliation.domain.security;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "user_role",
        schema = "reconciliation"
)
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @MapsId("userId")
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private ApplicationUser user;

    @MapsId("roleId")
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "role_id",
            nullable = false
    )
    private Role role;

    protected UserRole() {
    }

    public UserRole(
            ApplicationUser user,
            Role role) {

        this.user = user;
        this.role = role;

        this.id = new UserRoleId(
                user.getId(),
                role.getId());
    }

    public UserRoleId getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }
}