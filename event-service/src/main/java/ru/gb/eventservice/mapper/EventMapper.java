package ru.gb.eventservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.gb.eventservice.domain.Event;
import ru.gb.eventservice.dto.EventDto;

import java.util.List;

@Mapper(imports = {ru.gb.eventservice.domain.Tag.class, java.util.stream.Collectors.class})
public interface EventMapper {
    EventMapper MAPPER = Mappers.getMapper(EventMapper.class);
    @Mappings(
            {@Mapping(target="tags", expression= "java( event.getTags().stream().map(Tag::getName).collect(Collectors.toList()) )")}
    )
    EventDto fromEvent(Event event);
}
