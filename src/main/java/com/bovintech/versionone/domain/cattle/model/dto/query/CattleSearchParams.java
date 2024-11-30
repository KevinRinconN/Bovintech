package com.bovintech.versionone.domain.cattle.model.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CattleSearchParams {
    private Long lotId;
    private String gender;
    private List<String> breed;
    private String brand;

}
