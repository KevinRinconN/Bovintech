package com.bovintech.versionone.domain.cattle.mapper;
import com.bovintech.versionone.domain.cattle.model.dto.*;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.record.model.dto.Record;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CattleMapperDomain {

    CattleMapperDomain INSTANCE = Mappers.getMapper(CattleMapperDomain.class);

    @Mapping(target = "lastWeight", expression = "java(getLastWeightDetails(cattle.getRecords()).getWeight())")
    @Mapping(target = "lastWeightImage", expression = "java(getLastWeightDetails(cattle.getRecords()).getImageUrl())")
    @Mapping(target = "stage", expression = "java(getStage(cattle.getDateOfBirth()))")
    CattleShowDto toCattleShow(Cattle cattle);

    @Mapping(target = "lastWeight", expression = "java(getLastWeightDetails(cattle.getRecords()).getWeight())")
    @Mapping(target = "lastWeightImage", expression = "java(getLastWeightDetails(cattle.getRecords()).getImageUrl())")
    @Mapping(target = "stage", expression = "java(getStage(cattle.getDateOfBirth()))")
    @Mapping(target = "offspring", expression = "java(getOffspring(cattle.getOffspring(), cattle.getOffspringDam()))")
    @Mapping(source = "sire", target = "sire")
    @Mapping(source = "dam", target = "dam")
    CattleShowByIdDto toCattleShowById(Cattle cattle);
    
    @Mapping(target = "lastWeightImage", expression = "java(getLastWeightDetails(cattle.getRecords()).getImageUrl())")
    CattleParentShowDto toCattleParentShowDto(Cattle cattle);


    CattleCreateDTO toCattleCreateDto (CattleBirthRecord cattleBirthRecord);

    CattleWithOutRelationsDto withOutRelations (Cattle cattle);


    default Integer getOffspring (List<Cattle> offspring, List<Cattle> offspringDam){
        return offspring != null ||  offspringDam != null ? offspring.size() + offspringDam.size() : 0;
    }


    default LastWeightDetails getLastWeightDetails(List<Record> records) {
        Optional<Record> lastRecord = records.stream()
                .max(Comparator.comparing(Record::getDateOfRecord)
                        .thenComparing(Record::getId));

        if (lastRecord.isPresent()) {
            Record record = lastRecord.get();
            return new LastWeightDetails(record.getWeight(), record.getImg());
        }

        return new LastWeightDetails(null, null);
    }

    default String getStage(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        int ageInMonths = Period.between(dateOfBirth, today).getMonths() + (Period.between(dateOfBirth, today).getYears() * 12);

        if (ageInMonths <= 6) {
            return "Cría";
        } else if (ageInMonths <= 18) {
            return "Levante";
        } else {
            return "Ceba";
        }
    }

     @Getter
     static class LastWeightDetails {
        private final Integer weight;
        private final String imageUrl;

        public LastWeightDetails(Integer weight, String imageUrl) {
            this.weight = weight;
            this.imageUrl = imageUrl;
        }

     }

}
