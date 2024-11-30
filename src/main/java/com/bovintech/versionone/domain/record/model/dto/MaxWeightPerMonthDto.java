package com.bovintech.versionone.domain.record.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxWeightPerMonthDto {
    private String month;
    private Integer maxWeight;

    public MaxWeightPerMonthDto(String month, Integer maxWeight) {
        this.month = month;
        this.maxWeight = maxWeight;
    }


    // Getters y setters (deben ser públicos)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }
}