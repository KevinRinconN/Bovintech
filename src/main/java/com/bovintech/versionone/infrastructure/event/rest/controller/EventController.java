package com.bovintech.versionone.infrastructure.event.rest.controller;

import com.bovintech.versionone.application.event.command.EventCreateHandler;
import com.bovintech.versionone.application.event.command.EventDeleteByIdHandler;
import com.bovintech.versionone.application.event.command.EventUpdateStatusHandler;
import com.bovintech.versionone.application.event.query.EventFinAllHandler;
import com.bovintech.versionone.application.log.command.LoggerHandler;
import com.bovintech.versionone.domain.cattle.usecases.LotCreateUseCase;
import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.bovintech.versionone.domain.event.model.dto.EventCreateDto;
import com.bovintech.versionone.domain.event.model.dto.EventGetSearchParamsDto;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.model.dto.MonthlyEventsDTO;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventCreateHandler eventCreateHandler;
    private final EventUpdateStatusHandler eventUpdateStatusHandler;
    private final EventDeleteByIdHandler eventDeleteByIdHandler;
    private final EventFinAllHandler eventFinAllHandler;
    private final LotCreateUseCase lotCreateUseCase;

    private final LoggerHandler loggerHandler;

    @PostMapping()
    public ResponseHandler<EventToShowDto> create (@Valid @RequestBody EventCreateDto eventCreateDto){

        EventToShowDto event = eventCreateHandler.execute(eventCreateDto);
        loggerHandler.info("Evento: "+event.getName()+" creado correctamente", ModuleType.EVENT,  ActionType.CREATE);
        return ResponseHandler.success("Evento creado con éxito", event);
    }

    @PatchMapping("/{eventId}/status")
    public ResponseHandler<EventToShowDto> updateEventStatus(@PathVariable Long eventId, @RequestParam EventStatus status) {
        EventToShowDto updatedEvent = eventUpdateStatusHandler.execute(eventId, status);
        return ResponseHandler.success("Estado del evento actualizado con éxito", updatedEvent);
    }

    @GetMapping()
    public ResponseHandler<List<MonthlyEventsDTO>> findAll (@RequestParam(required = false, defaultValue = "upcoming") String filter,
                                                            @RequestParam(required = false) List<EventType> type,
                                                            @RequestParam(required = false) List<String> operators,
                                                            @RequestParam(required = false) List<Long> lots){
        return ResponseHandler.success("Eventos cargados con exito", eventFinAllHandler.execute(new EventGetSearchParamsDto(filter, type, operators, lots)));
    }

    @DeleteMapping("/{id}")
    public ResponseHandler<Void> deleteById(@PathVariable Long id){
        eventDeleteByIdHandler.execute(id);
        return  ResponseHandler.success("Evento con el id: "+id+" borrado satisfactoriamente");
    }
}
