package com.bovintech.versionone.application.event.bean;

import com.bovintech.versionone.domain.auth.usecases.OperatorGetAllByIdUseCase;
import com.bovintech.versionone.domain.auth.usecases.UserGetByIdUseCase;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetAllByIdUseCase;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import com.bovintech.versionone.domain.cattle.usecases.LotGetAllListUseCase;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import com.bovintech.versionone.domain.event.services.EventCreateService;
import com.bovintech.versionone.domain.event.services.EventDeleteByIdService;
import com.bovintech.versionone.domain.event.services.EventFinAllService;
import com.bovintech.versionone.domain.event.services.EventUpdateStatusService;
import com.bovintech.versionone.domain.event.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    @Bean
    public EventCreateService eventCreateService (EventCreateUseCase eventCreateUseCase){
        return new EventCreateService(eventCreateUseCase);
    }

    @Bean
    public EventCreateUseCase eventCreateUseCase (IEventRepository iEventRepository, CattleGetAllByIdUseCase cattleGetAllByIdUseCase, OperatorGetAllByIdUseCase operatorGetAllByIdUseCase, UserGetByIdUseCase userGetByIdUseCase, LotGetAllListUseCase lotGetAllListUseCase){
        return new EventCreateUseCase(iEventRepository, cattleGetAllByIdUseCase, operatorGetAllByIdUseCase, lotGetAllListUseCase, userGetByIdUseCase);
    }

    @Bean
    public EventUpdateStatusService eventUpdateStatusService (EventUpdateStatusUseCase eventUpdateStatusUseCase){
        return new EventUpdateStatusService(eventUpdateStatusUseCase);
    }

    @Bean
    public EventUpdateStatusUseCase eventUpdateStatusUseCase(IEventRepository iEventRepository, EventGetByIdUseCase eventGetByIdUseCase){
        return new EventUpdateStatusUseCase(iEventRepository, eventGetByIdUseCase);
    }

    @Bean
    public EventGetByIdUseCase eventGetByIdUseCase (IEventRepository iEventRepository){
        return new EventGetByIdUseCase(iEventRepository);
    }

    @Bean
    public EventDeleteByIdService eventDeleteByIdService (EventDeleteByIdUseCase eventDeleteByIdUseCase){
        return new EventDeleteByIdService(eventDeleteByIdUseCase);
    }

    @Bean
    public EventDeleteByIdUseCase eventDeleteByIdUseCase (IEventRepository iEventRepository, EventGetByIdUseCase eventGetByIdUseCase){
        return new EventDeleteByIdUseCase(iEventRepository, eventGetByIdUseCase);
    }

    @Bean
    public EventFinAllService eventFinAllService (EventFindAllUseCase eventFindAllUseCase){
        return new EventFinAllService(eventFindAllUseCase);
    }

    @Bean
    public EventFindAllUseCase eventFindAllUseCase (IEventRepository iEventRepository){
        return new EventFindAllUseCase(iEventRepository);
    }
}
