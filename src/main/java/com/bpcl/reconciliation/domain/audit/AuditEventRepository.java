package com.bpcl.reconciliation.domain.audit;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository
        extends JpaRepository<AuditEvent, Long> {

    List<AuditEvent>
            findByOrganization_IdOrderByEventTimestampDesc(
                    Long organizationId);

    List<AuditEvent>
            findByFuelStation_IdOrderByEventTimestampDesc(
                    Long fuelStationId);

    List<AuditEvent>
            findByUser_IdOrderByEventTimestampDesc(
                    Long userId);

    List<AuditEvent>
            findByActionCodeOrderByEventTimestampDesc(
                    String actionCode);

    List<AuditEvent>
            findByEntityTypeAndEntityIdOrderByEventTimestampAsc(
                    String entityType,
                    Long entityId);

    List<AuditEvent>
            findByEventTimestampBetweenOrderByEventTimestampAsc(
                    OffsetDateTime from,
                    OffsetDateTime to);

    List<AuditEvent>
            findByCorrelationIdOrderByEventTimestampAsc(
                    String correlationId);
}