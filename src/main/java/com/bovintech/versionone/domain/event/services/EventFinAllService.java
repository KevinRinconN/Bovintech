package com.bovintech.versionone.domain.event.services;

import com.bovintech.versionone.domain.event.mapper.EventMapper;
import com.bovintech.versionone.domain.event.model.dto.*;
import com.bovintech.versionone.domain.event.usecases.EventFindAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EventFinAllService {
    private final EventFindAllUseCase eventFindAllUseCase;

    public List<MonthlyEventsDTO> execute (String username, EventGetSearchParamsDto searchParamsDto){
        List<EventDto> events = eventFindAllUseCase.execute(username, searchParamsDto);
        return groupAndMapToDTO(events);
    }

    public List<MonthlyEventsDTO> groupAndMapToDTO(List<EventDto> events) {
        // Agrupar por mes y año
        Map<String, List<EventDto>> groupedByMonth = events.stream()
                .collect(Collectors.groupingBy(
                        event -> {
                            String month = event.getEventDate().getMonth()
                                    .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                            String year = String.valueOf(event.getEventDate().getYear());
                            return month + " " + year;
                        },
                        LinkedHashMap::new, // Respetar el orden de llegada
                        Collectors.toList()
                ));


        return groupedByMonth.entrySet().stream()
                .map(entry -> {
                    String[] parts = entry.getKey().split(" ");
                    String month = parts[0];
                    String year = parts[1];
                    List<EventDto> eventList = entry.getValue();

                    // Agrupar los eventos por día

                    Map<String, List<EventDto>> groupedByDay = eventList.stream()
                            .collect(Collectors.groupingBy(
                                    event -> String.valueOf(event.getEventDate().getDayOfMonth()),
                                    LinkedHashMap::new, // Usar LinkedHashMap para respetar el orden de llegada
                                    Collectors.toList()
                            ));
                    // Crear los DayEventsDto
                    List<DayEventsDto> dayEventsDtos = groupedByDay.entrySet().stream()
                            .map(dayEntry -> {
                                String day = dayEntry.getKey();
                                List<EventToShowDto> eventToShowList = dayEntry.getValue().stream()
                                        .map(EventMapper.INSTANCE::toShow)
                                        .collect(Collectors.toList());

                                return new DayEventsDto(day, eventToShowList);
                            })
                            .collect(Collectors.toList());

                    return new MonthlyEventsDTO(month, year, dayEventsDtos);
                })
                .collect(Collectors.toList());
        }
    }
