package com.bpcl.reconciliation.domain.audit;

import java.time.OffsetDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.bpcl.reconciliation.domain.organization.Organization;
import com.bpcl.reconciliation.domain.security.ApplicationUser;
import com.bpcl.reconciliation.domain.station.FuelStation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "audit_event",
        schema = "reconciliation"
)
public class AuditEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_station_id")
    private FuelStation fuelStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @Column(
            name = "actor_username_snapshot",
            length = 100
    )
    private String actorUsernameSnapshot;

    @Column(
            name = "action_code",
            nullable = false,
            length = 100
    )
    private String actionCode;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "event_outcome",
            nullable = false,
            length = 20
    )
    private AuditEventOutcome eventOutcome =
            AuditEventOutcome.SUCCESS;

    @Column(
            name = "entity_type",
            length = 100
    )
    private String entityType;

    @Column(
            name = "entity_id"
    )
    private Long entityId;

    @Column(
            name = "event_description",
            length = 1000
    )
    private String eventDescription;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(
            name = "old_value_json",
            columnDefinition = "jsonb"
    )
    private String oldValueJson;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(
            name = "new_value_json",
            columnDefinition = "jsonb"
    )
    private String newValueJson;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(
            name = "additional_data_json",
            columnDefinition = "jsonb"
    )
    private String additionalDataJson;

    @Column(
            name = "event_timestamp",
            nullable = false
    )
    private OffsetDateTime eventTimestamp;

    @Column(
            name = "ip_address",
            columnDefinition = "inet"
    )
    private String ipAddress;

    @Column(
            name = "correlation_id",
            length = 100
    )
    private String correlationId;

    protected AuditEvent() {
    }

    public AuditEvent(
            Organization organization,
            FuelStation fuelStation,
            ApplicationUser user,
            String actorUsernameSnapshot,
            String actionCode,
            AuditEventOutcome eventOutcome,
            String entityType,
            Long entityId,
            String eventDescription,
            String correlationId) {

        this.organization = organization;
        this.fuelStation = fuelStation;
        this.user = user;
        this.actorUsernameSnapshot = actorUsernameSnapshot;
        this.actionCode = actionCode;
        this.eventOutcome = eventOutcome;
        this.entityType = entityType;
        this.entityId = entityId;
        this.eventDescription = eventDescription;
        this.correlationId = correlationId;
    }

    @PrePersist
    protected void onCreate() {
        if (eventTimestamp == null) {
            eventTimestamp = OffsetDateTime.now();
        }

        if (eventOutcome == null) {
            eventOutcome = AuditEventOutcome.SUCCESS;
        }
    }

    public Long getId() {
        return id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public String getActorUsernameSnapshot() {
        return actorUsernameSnapshot;
    }

    public String getActionCode() {
        return actionCode;
    }

    public AuditEventOutcome getEventOutcome() {
        return eventOutcome;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getOldValueJson() {
        return oldValueJson;
    }

    public String getNewValueJson() {
        return newValueJson;
    }

    public String getAdditionalDataJson() {
        return additionalDataJson;
    }

    public OffsetDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setStateSnapshots(
            String oldValueJson,
            String newValueJson) {

        this.oldValueJson = oldValueJson;
        this.newValueJson = newValueJson;
    }

    public void setAdditionalDataJson(
            String additionalDataJson) {

        this.additionalDataJson = additionalDataJson;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}