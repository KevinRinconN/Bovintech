package com.bovintech.versionone.domain.cattle.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class Cattle {
    private Long id;
    private Date  dateOfBirth;
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

}
