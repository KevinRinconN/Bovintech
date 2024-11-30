package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import com.bovintech.versionone.domain.cattle.service.CattleAllService;
import com.bovintech.versionone.domain.cattle.service.CattleCreateService;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetAllUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CattleBean {

    @Bean
    public CattleAllService cattleAllService (CattleGetAllUseCase cattleGetAllUseCase){
        return new CattleAllService(cattleGetAllUseCase);
    }

    @Bean
    public CattleGetAllUseCase cattleGetAllUseCase (ICattleRepository cattleRepository){
        return new CattleGetAllUseCase(cattleRepository);
    }

    @Bean
    public CattleCreateService cattleCreateService(ICattleRepository cattleRepository){
        return new CattleCreateService(cattleRepository);
    }


}
