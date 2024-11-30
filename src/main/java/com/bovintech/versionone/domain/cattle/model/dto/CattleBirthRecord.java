package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Getter
@Setter
public class CattleBirthRecord {
    private LocalDate dateOfBirth;
    private String brand;
    private String gender;
    private String breed;
    private String distinctiveTrait;

    private MultipartFile img;
    private Integer weight;
    private LocalDate dateOfRecord;
}
