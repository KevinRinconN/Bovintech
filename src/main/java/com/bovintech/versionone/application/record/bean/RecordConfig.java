package com.bovintech.versionone.application.record.bean;

import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import com.bovintech.versionone.domain.file.usecases.FileUploadUseCase;
import com.bovintech.versionone.domain.record.port.repository.IRecordRepository;
import com.bovintech.versionone.domain.record.services.CreateRecordService;
import com.bovintech.versionone.domain.record.services.RecordGetByCattleIdService;
import com.bovintech.versionone.domain.record.services.RecordGetPerMonthService;
import com.bovintech.versionone.domain.record.usecases.CreateRecordUseCase;
import com.bovintech.versionone.domain.record.usecases.RecordGetByCattleIdUseCase;
import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecordConfig {
    @Bean
    public CreateRecordUseCase createRecordUseCase (IRecordRepository iRecordRepository, CattleGetByIdUseCase cattleGetByIdUseCase, FileUploadUseCase fileUploadUseCase){
        return new CreateRecordUseCase(iRecordRepository, cattleGetByIdUseCase, fileUploadUseCase);
    }

    @Bean
    public CreateRecordService createRecordService (CreateRecordUseCase createRecordUseCase){
        return new CreateRecordService(createRecordUseCase);
    }

    @Bean
    public RecordGetByCattleIdUseCase recordGetByCattleIdUseCase(CattleGetByIdUseCase cattleGetByIdUseCase){
        return new RecordGetByCattleIdUseCase(cattleGetByIdUseCase);
    }

    @Bean
    public RecordGetByCattleIdService recordGetByCattleIdService(RecordGetByCattleIdUseCase recordGetByCattleIdUseCase){
        return new RecordGetByCattleIdService(recordGetByCattleIdUseCase);
    }


    @Bean
    public FileUploadUseCase fileUploadUseCase (Cloudinary cloudinary){
        return new FileUploadUseCase(cloudinary);
    }

    @Bean
    public RecordGetPerMonthService recordGetPerMonthService (IRecordRepository iRecordRepository){
        return new RecordGetPerMonthService(iRecordRepository);
    }
}
