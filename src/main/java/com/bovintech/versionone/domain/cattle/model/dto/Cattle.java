package com.bovintech.versionone.domain.cattle.model.dto;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class Cattle {
    private Long id;
    private LocalDate dateOfBirth;
    private String distinctiveTrait;
    private String gender;
    private String breed;
    private String brand;

    @JsonIgnore
    private Cattle sire; //padre
    @JsonIgnore
    private Cattle dam; //madre
    @JsonIgnore
    private List<Cattle> offspring;
    @JsonIgnore
    private List<Cattle> offspringDam;
    @JsonIgnore
    private List<Record> records;
    @JsonIgnore
    private List<EventDto> events;

}
