package com.bovintech.versionone.domain.record;

import com.bovintech.versionone.domain.cattle.model.dto.CattleBirthRecord;
import com.bovintech.versionone.domain.record.model.dto.CreateRecordDto;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface RecordMapper {
    RecordMapper INSTANCE = Mappers.getMapper( RecordMapper.class );
    @Mapping(target = "img", ignore = true)
    Record createRecordDtoToRecord (CreateRecordDto recordDto);

    CreateRecordDto toCreateRecordDto (CattleBirthRecord cattleBirthRecord);

    ShowRecordDto toShow (Record record);
}
