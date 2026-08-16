package com.bpcl.reconciliation.domain.security;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserStationAccessId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "fuel_station_id")
    private Long fuelStationId;

    protected UserStationAccessId() {
    }

    public UserStationAccessId(
            Long userId,
            Long fuelStationId) {

        this.userId = userId;
        this.fuelStationId = fuelStationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFuelStationId() {
        return fuelStationId;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof UserStationAccessId other)) {
            return false;
        }

        return Objects.equals(userId, other.userId)
                && Objects.equals(
                        fuelStationId,
                        other.fuelStationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                userId,
                fuelStationId);
    }
}