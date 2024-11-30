package com.bovintech.versionone.domain.record.model.dto;

import com.bovintech.versionone.domain.cattle.model.dto.CattleWithOutRelationsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Record {

    private Long id;
    private String img;
    private Integer weight;
    private Date dateOfRecord;

    private CattleWithOutRelationsDto cattle;
}
