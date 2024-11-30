package com.bovintech.versionone.domain.record.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShowRecordDto {
    private Long id;
    private String img;
    private Integer weight;
    private Date dateOfRecord;
}
