package ru.gb.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {
    private Long id;
    private String name;
    private String description;
    private String link;
    private LocalDateTime date_start;
    private LocalDateTime date_end;
    private List<String> tags;

}
