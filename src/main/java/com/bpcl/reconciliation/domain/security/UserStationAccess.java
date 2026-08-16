package com.bpcl.reconciliation.domain.security;

import com.bpcl.reconciliation.domain.station.FuelStation;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "user_station_access",
        schema = "reconciliation"
)
public class UserStationAccess {

    @EmbeddedId
    private UserStationAccessId id;

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

    @MapsId("fuelStationId")
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_station_id",
            nullable = false
    )
    private FuelStation fuelStation;

    protected UserStationAccess() {
    }

    public UserStationAccess(
            ApplicationUser user,
            FuelStation fuelStation) {

        this.user = user;
        this.fuelStation = fuelStation;

        this.id = new UserStationAccessId(
                user.getId(),
                fuelStation.getId());
    }

    public UserStationAccessId getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }
}