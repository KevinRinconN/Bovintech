package com.bovintech.versionone.domain.event.usecases;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.usecases.OperatorGetAllByIdUseCase;
import com.bovintech.versionone.domain.auth.usecases.UserGetByIdUseCase;
import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.mapper.LotMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetAllByIdUseCase;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import com.bovintech.versionone.domain.cattle.usecases.LotGetAllListUseCase;
import com.bovintech.versionone.domain.event.mapper.EventMapper;
import com.bovintech.versionone.domain.event.model.dto.EventCreateDto;
import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.exception.EventBadRequest;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import com.bovintech.versionone.domain.record.RecordMapper;
import com.bovintech.versionone.domain.record.model.dto.Record;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EventCreateUseCase {

    private final IEventRepository iEventRepository;
    private final CattleGetAllByIdUseCase cattleGetAllByIdUseCase;
    private final OperatorGetAllByIdUseCase operatorGetAllByIdUseCase;
    private final LotGetAllListUseCase lotGetAllListUseCase;
    private final UserGetByIdUseCase userGetByIdUseCase;

    public EventDto execute (String owner, EventCreateDto eventCreateDto){
        if (eventCreateDto.getEventDate().toLocalDate().isBefore(LocalDate.now())) {
            throw new EventBadRequest("La fecha del evento no puede ser en el pasado.");
        }

        EventDto eventToSave = EventMapper.INSTANCE.createEventDtoToEvent(eventCreateDto);

        if(eventCreateDto.getCattleIds() != null && !eventCreateDto.getCattleIds().isEmpty()){
            List<Cattle> cattleList = cattleGetAllByIdUseCase.execute(eventCreateDto.getCattleIds());
            eventToSave.setCattle(cattleList.stream().map(CattleMapperDomain.INSTANCE::withOutRelations).collect(Collectors.toList()));
        }



        if(eventCreateDto.getLotsId() != null && !eventCreateDto.getLotsId().isEmpty()){
            List<LotDto>  lots = lotGetAllListUseCase.execute(eventCreateDto.getLotsId());
            eventToSave.setLots(lots.stream().map(LotMapperDomain.INSTANCE::toLotShow).collect(Collectors.toList()));
        }

        User user = userGetByIdUseCase.execute(owner);
        if (eventCreateDto.isOperator()){
            eventToSave.setOwner(user.getOwner());
            eventToSave.setOperators(Collections.singletonList(LotMapperDomain.INSTANCE.toUseShow(user)));
        }else {

            if(eventCreateDto.getOperatorUsernames() != null && !eventCreateDto.getOperatorUsernames().isEmpty()){
                List<User>  operators = operatorGetAllByIdUseCase.execute(eventCreateDto.getOperatorUsernames());
                eventToSave.setOperators(operators.stream().map(LotMapperDomain.INSTANCE::toUseShow).collect(Collectors.toList()));
            }

            eventToSave.setOwner(LotMapperDomain.INSTANCE.toUseShow(user));
        }



        return iEventRepository.save(eventToSave);
    }

}
