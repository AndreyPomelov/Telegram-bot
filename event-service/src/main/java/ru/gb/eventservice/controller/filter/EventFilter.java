package ru.gb.eventservice.controller.filter;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.gb.eventservice.domain.Event;
import ru.gb.eventservice.repository.specification.EventSpecification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Getter
public class EventFilter {
    private Specification<Event> spec;

    public EventFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        if (map.containsKey("fromdate") && !map.get("fromdate").isEmpty()) {
            LocalDate date = LocalDate.parse(map.get("fromdate"));
            LocalDateTime from_date = date.atStartOfDay();
            spec = spec.and(EventSpecification.dataGreaterOrEqualsThan("date_start", from_date));
        }
        if (map.containsKey("todate") && !map.get("todate").isEmpty()) {
            LocalDate date = LocalDate.parse(map.get("todate"));
            LocalDateTime to_date = date.atTime(23, 59, 59);
            spec = spec.and(EventSpecification.dataLessOrEqualsThan("date_end", to_date));
        }
    }

}
