package com.bovintech.versionone.domain.cattle.model.dto.Birth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class BirthRecords {

    private LocalDate lastBirth;
    private LocalDate estimatedDateBirth;
    private Integer offspring;
    private Integer abortions;
    private BirthDto birth;
}
