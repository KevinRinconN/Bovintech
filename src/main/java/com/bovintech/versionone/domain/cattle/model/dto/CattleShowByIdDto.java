package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CattleShowByIdDto {
    private Long id;
    private Date dateOfBirth;
    private String distinctiveTrait;
    private String gender;
    private String breed;
    private String brand;
    private Integer lastWeight;
    private String lastWeightImage;
    private String stage;
    private Integer offspring;
    private CattleParentShowDto sire; //padre
    private CattleParentShowDto dam; //madre
}


