package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import com.bovintech.versionone.domain.cattle.service.CattleAllService;
import com.bovintech.versionone.domain.cattle.service.CattleCreateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CattleBean {

    @Bean
    public CattleAllService cattleAllService (ICattleRepository cattleRepository){
        return new CattleAllService(cattleRepository);
    }

    @Bean
    public CattleCreateService cattleCreateService(ICattleRepository cattleRepository){
        return new CattleCreateService(cattleRepository);
    }


}
