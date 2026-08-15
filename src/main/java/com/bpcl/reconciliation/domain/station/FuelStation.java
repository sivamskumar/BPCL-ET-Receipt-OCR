package com.bpcl.reconciliation.domain.station;

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
        name = "fuel_station",
        schema = "reconciliation"
)
public class FuelStation extends BaseEntity {

    public static final String DEFAULT_TIME_ZONE = "Asia/Kolkata";

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
            name = "station_code",
            nullable = false,
            length = 30
    )
    private String stationCode;

    @Column(
            name = "station_name",
            nullable = false,
            length = 150
    )
    private String stationName;

    @Column(
            name = "address_line_1",
            length = 200
    )
    private String addressLine1;

    @Column(
            name = "address_line_2",
            length = 200
    )
    private String addressLine2;

    @Column(
            name = "city",
            length = 100
    )
    private String city;

    @Column(
            name = "state",
            length = 100
    )
    private String state;

    @Column(
            name = "postal_code",
            length = 20
    )
    private String postalCode;

    @Column(
            name = "time_zone",
            nullable = false,
            length = 60
    )
    private String timeZone = DEFAULT_TIME_ZONE;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected FuelStation() {
    }

    public FuelStation(
            Organization organization,
            String stationCode,
            String stationName) {

        this.organization = organization;
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.timeZone = DEFAULT_TIME_ZONE;
        this.active = true;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
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