package ru.gb.eventservice.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.eventservice.domain.Event;
import ru.gb.eventservice.dto.EventDto;

import java.util.List;

@Service
public interface EventService {
    List<Event> findAll();
    List<EventDto> findAllDto(Specification<Event> specification);
    Event findById(Long id);
    Event saveOrUpdate(Event event);
}
