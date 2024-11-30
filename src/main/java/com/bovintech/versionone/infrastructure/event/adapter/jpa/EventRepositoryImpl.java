package com.bovintech.versionone.infrastructure.event.adapter.jpa;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.dto.EventGetSearchParamsDto;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import com.bovintech.versionone.infrastructure.event.adapter.mapper.EventMapperRep;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import com.bovintech.versionone.infrastructure.event.adapter.specificacion.EventSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements IEventRepository {

    private final IEventJpaRepository iEventJpaRepository;
    private final EventMapperRep eventMapper;

    @Override
    public EventDto save(EventDto dto) {
        return eventMapper.toDomain(iEventJpaRepository.save(eventMapper.toDbo(dto)));
    }

    @Override
    public List<EventDto> findAllSearch(String username, EventGetSearchParamsDto searchParamsDto) {
        Specification<EventEntity> specification = Specification.where(searchParamsDto.isOperator() ? EventSpecifications.eventsByOperator(username) : EventSpecifications.eventsByOwner(username))
                .and(EventSpecifications.hasType(searchParamsDto.getType()))
                .and(EventSpecifications.hasOperators(searchParamsDto.getOperators()))
                .and(EventSpecifications.hasLots(searchParamsDto.getLots()));

        // Filtra según el tipo (próximos, pasados, cancelados)
        if ("upcoming".equalsIgnoreCase(searchParamsDto.getFilter())) {
            specification = specification.and(EventSpecifications.eventsFromNow());
        } else if ("past".equalsIgnoreCase(searchParamsDto.getFilter())) {
            specification = specification.and(EventSpecifications.pastEvents());
        } else if ("canceled".equalsIgnoreCase(searchParamsDto.getFilter())) {
            specification = specification.and(EventSpecifications.canceledEvents());
        }

        return iEventJpaRepository.findAll(specification).stream().map(eventMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<EventDto> findById(Long id) {
        return iEventJpaRepository.findById(id).map(eventMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        iEventJpaRepository.deleteById(id);
    }
}
