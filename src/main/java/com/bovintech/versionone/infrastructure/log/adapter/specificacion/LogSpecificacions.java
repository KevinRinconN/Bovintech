package com.bovintech.versionone.infrastructure.log.adapter.specificacion;

import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import com.bovintech.versionone.infrastructure.log.adapter.model.LogEntity;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LogSpecificacions {
    public static Specification<LogEntity>  LogsByOwner(String ownerUsername) {
        return (root, query, criteriaBuilder) -> {
            // Realiza un join con la tabla de usuarios
            Join<LogEntity, UserEntity> userJoin = root.join("user");

            // Crea una subconsulta para obtener los operadores del dueño
            query.distinct(true);
            return criteriaBuilder.or(
                    // Condición para el dueño
                    criteriaBuilder.equal(userJoin.get("username"), ownerUsername),
                    // Condición para los operadores del dueño
                    userJoin.get("owner").get("username").in(ownerUsername)
            );
        };
    }

    public static Specification<LogEntity> LogsByOperator(String username) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("user").get("owner").get("username"), username);
        };
    }

    public static Specification<LogEntity> hasDate(LocalDateTime dateTime) {
        return (root, query, criteriaBuilder) -> {
            if (dateTime == null) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición si `dateTime` es nulo
            }

            // Calcula el inicio y fin del día de la fecha proporcionada
            LocalDate date = dateTime.toLocalDate();
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.plusDays(1).atStartOfDay().minusSeconds(1);

            // Devuelve la condición para el rango de fechas
            return criteriaBuilder.between(root.get("timestamp"), startOfDay, endOfDay);
        };
    }

    public static Specification<LogEntity> hasAction(List<ActionType> actions) {
        return (root, query, criteriaBuilder) -> {
            if (actions == null || actions.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.get("action").in(actions);
        };
    }

    public static Specification<LogEntity> hasModule(List<ModuleType> module) {
        return (root, query, criteriaBuilder) -> {
            if (module == null || module.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.get("module").in(module);
        };
    }

    public static Specification<LogEntity> hasOperators(List<String> operators) {
        return (root, query, criteriaBuilder) -> {
            if (operators == null || operators.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return root.get("user").get("username").in(operators);
        };
    }
}
