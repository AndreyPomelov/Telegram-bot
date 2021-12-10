package ru.gb.eventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.eventservice.controller.filter.EventFilter;
import ru.gb.eventservice.domain.Event;
import ru.gb.eventservice.dto.EventDto;
import ru.gb.eventservice.service.EventService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    @Autowired
    void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<EventDto>> index(@RequestParam Map<String, String> requestParams){
        EventFilter eventFilter = new EventFilter(requestParams);
        return ResponseEntity.ok().body(eventService.findAllDto(eventFilter.getSpec()));
    }


}
