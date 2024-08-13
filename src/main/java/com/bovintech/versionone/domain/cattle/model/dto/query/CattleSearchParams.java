package com.bovintech.versionone.domain.cattle.model.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CattleSearchParams {
    private String gender;
    private String breed;
}
