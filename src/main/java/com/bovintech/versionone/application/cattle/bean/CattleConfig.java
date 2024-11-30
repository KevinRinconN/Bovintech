package com.bovintech.versionone.application.cattle.bean;

import com.bovintech.versionone.application.cattle.query.CattleGetByIdHandler;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import com.bovintech.versionone.domain.cattle.port.repository.ILotRespository;
import com.bovintech.versionone.domain.cattle.service.*;
import com.bovintech.versionone.domain.cattle.usecases.*;
import com.bovintech.versionone.domain.record.usecases.CreateRecordUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CattleConfig {
    @Bean
    public CattleGetByIdUseCase cattleGetByIdUseCase (ICattleRepository iCattleRepository){
        return new CattleGetByIdUseCase(iCattleRepository);
    }

    @Bean
    public CattleGetByIdService cattleGetByIdService (CattleGetByIdUseCase cattleGetByIdUseCase){
        return new CattleGetByIdService(cattleGetByIdUseCase);
    }

    @Bean
    public CattleGetOffSpringUseCase cattleGetOffSpringUseCase (ICattleRepository iCattleRepository){
        return new CattleGetOffSpringUseCase(iCattleRepository);
    }

    @Bean
    public CattleGetOffSpringService cattleGetOffSpringService(CattleGetOffSpringUseCase cattleGetOffSpringUseCase){
        return new CattleGetOffSpringService(cattleGetOffSpringUseCase);
    }

    @Bean
    public CattleGetByIdDamUseCase cattleGetByIdDamUseCase (ICattleRepository iCattleRepository){
        return new CattleGetByIdDamUseCase(iCattleRepository);
    }

    @Bean
    public CattleGetByIdSireUseCase cattleGetByIdSireUseCase (ICattleRepository iCattleRepository){
        return new CattleGetByIdSireUseCase(iCattleRepository);
    }

    @Bean
    public CattleGetOngoingBirthUseCase cattleGetOngoingBirthUseCase (IBirthRepository iBirthRepository, CattleGetByIdDamUseCase cattleGetByIdDamUseCase, CattleGetByIdSireUseCase cattleGetByIdSireUseCase){
        return new CattleGetOngoingBirthUseCase(iBirthRepository, cattleGetByIdDamUseCase, cattleGetByIdSireUseCase);
    }

    @Bean
    public BirthCreateUseCase birthCreateUseCase (CattleGetByIdDamUseCase cattleGetByIdDamUseCase,CattleGetByIdSireUseCase cattleGetByIdSireUseCase,  IBirthRepository iBirthRepository){
        return new BirthCreateUseCase(cattleGetByIdDamUseCase, cattleGetByIdSireUseCase , iBirthRepository);
    }

    @Bean
    public BirthGetByIdUseCase birthGetByIdUseCase (IBirthRepository iBirthRepository){
        return new BirthGetByIdUseCase(iBirthRepository);
    }

    @Bean
    public CattleRegisterBirthUseCase cattleRegisterBirthUseCase (BirthGetByIdUseCase birthGetByIdUseCase, CattleCreateService cattleCreateService, CreateRecordUseCase createRecordUseCase, IBirthRepository iBirthRepository){
        return new CattleRegisterBirthUseCase(birthGetByIdUseCase,cattleCreateService, createRecordUseCase, iBirthRepository);
    }

    @Bean
    public LotGetAllUseCase lotGetAllUseCase (ILotRespository iLotRespository){
        return new LotGetAllUseCase(iLotRespository);
    }

    @Bean
    public LotGetAllService lotGetAllService (LotGetAllUseCase lotGetAllUseCase){
        return new LotGetAllService(lotGetAllUseCase);
    }

    @Bean
    public LotGetAllByOperatorUseCase lotGetAllByOperatorUseCase (ILotRespository iLotRespository){
        return new LotGetAllByOperatorUseCase(iLotRespository);
    }

    @Bean
    public LotGetAllByOperatorService lotGetAllByOperatorService (LotGetAllByOperatorUseCase lotGetAllByOperatorUseCase){
        return new LotGetAllByOperatorService(lotGetAllByOperatorUseCase);
    }

    @Bean
    public CattleGetAllByIdUseCase cattleGetAllByIdUseCase (ICattleRepository iCattleRepository){
        return new CattleGetAllByIdUseCase(iCattleRepository);
    }

    @Bean
    public LotGetAllListUseCase lotGetAllListUseCase (ILotRespository iLotRespository){
        return new LotGetAllListUseCase(iLotRespository);
    }
}
