package com.bovintech.versionone.infrastructure.cattle.adapter.jpa.specification;

import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CattleSpecification {
    public static Specification<CattleEntity> hasGender(String gender) {
        return (root, query, criteriaBuilder) -> {
            if (gender == null || gender.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return criteriaBuilder.equal(root.get("gender"), gender);
        };
    }

    public static Specification<CattleEntity> hasBreed(List<String> breeds) {
        return (root, query, criteriaBuilder) -> {
            if (breeds == null || breeds.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            List<Predicate> predicates = breeds.stream()
                    .map(breed -> criteriaBuilder.like(root.get("breed"), "%" + breed + "%"))
                    .toList();
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<CattleEntity> hasBrand(String brand) {
        return (root, query, criteriaBuilder) -> {
            if (brand == null || brand.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return criteriaBuilder.like(root.get("brand"), "%" + brand + "%");
        };
    }

    public static Specification<CattleEntity> belongsToLot(Long lotId) {
        return (root, query, criteriaBuilder) -> {
            if (lotId == null) {
                return criteriaBuilder.conjunction(); // No aplica ningún filtro si lotId es nulo
            }
            return criteriaBuilder.equal(root.get("lot").get("id"), lotId);
        };
    }


}
