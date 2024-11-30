package com.bovintech.versionone.infrastructure.event.adapter.specificacion;

import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;

public class EventSpecifications {
    public static Specification<EventEntity> eventsFromNow() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("eventDate"))); // Ordenar por fecha ascendente (opcional: usa desc si quieres los más cercanos primero)
            return criteriaBuilder.greaterThanOrEqualTo(root.get("eventDate"), LocalDateTime.now()); // Filtrar solo los eventos a partir de ahora
        };
    }

    // Eventos con fecha en el pasado (finalizados)
    public static Specification<EventEntity> pastEvents() {
        return (root, query, cb) -> cb.lessThan(root.get("eventDate"), LocalDateTime.now());
    }

    // Eventos cancelados
    public static Specification<EventEntity> canceledEvents() {
        return (root, query, cb) -> cb.equal(root.get("status"), EventStatus.CANCELLED);
    }

    public static Specification<EventEntity> eventsByOwner(String ownerUsername) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("owner").get("id"), ownerUsername);
        };
    }

    public static Specification<EventEntity> eventsByOperator(String username) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("operators").get("username"), username);
        };
    }


    public static Specification<EventEntity> hasType(List<EventType> types) {
        return (root, query, criteriaBuilder) -> {
            if (types == null || types.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.get("eventType").in(types);
        };
    }

    public static Specification<EventEntity> hasOperators(List<String> operators) {
        return (root, query, criteriaBuilder) -> {
            if (operators == null || operators.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.join("operators").get("id").in(operators);
        };
    }

    public static Specification<EventEntity> hasLots(List<Long> lots) {
        return (root, query, criteriaBuilder) -> {
            if (lots == null || lots.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.join("lots").get("id").in(lots);
        };
    }

}
