package com.bovintech.versionone.domain.cattle.model.dto.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CattleCreateDTO {

    @NotNull(message = "dateOfBirth is required")
    @Past(message = "Date of birth must be in the past")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @NotEmpty(message = "Distinctive trait is required")
    @Size(min = 3, max = 255, message = "Distinctive trait must be between 3 and 255 characters")
    @JsonProperty("distinctive_trait")
    private String distinctiveTrait;

    @Pattern(regexp = "BULL|COW", message = "Gender must be 'BULL', 'COW'")
    private String gender;

    @NotEmpty(message = "Breed is required")
    private String breed;

    @Size(max = 255, message = "Brand must be less than 255 characters")
    private String brand;

    private Long sireId;
    private Long damId;
}
