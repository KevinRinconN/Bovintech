package com.bovintech.versionone.infrastructure.cattle.adapter.jpa.specification;

import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import org.springframework.data.jpa.domain.Specification;

public class CattleSpecification {
    public static Specification<CattleEntity> hasGender(String gender) {
        return (root, query, criteriaBuilder) -> {
            if (gender == null || gender.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return criteriaBuilder.equal(root.get("gender"), gender);
        };
    }

    public static Specification<CattleEntity> hasBreed(String breed) {
        return (root, query, criteriaBuilder) -> {
            if (breed == null || breed.isEmpty()) {
                return criteriaBuilder.conjunction(); // No agrega ninguna condición
            }
            return criteriaBuilder.equal(root.get("breed"), breed);
        };
    }
}
