package com.bovintech.versionone.domain.cattle.model.dto.Birth;

import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.dto.CattleWithOutRelationsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class BirthDto {
    private Long id;
    private LocalDate birthDate;
    private LocalDate inseminationDate;
    private CattleWithOutRelationsDto dam;
    private CattleWithOutRelationsDto sire;
    private CattleWithOutRelationsDto calf;
    private BirthStatus status;
    private boolean isAbortion;
    private String abortionReason;
}
