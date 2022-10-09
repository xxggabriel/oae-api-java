package br.estacio.campos.estacao.oae.mapper;

import br.estacio.campos.estacao.oae.dto.EventDTO;
import br.estacio.campos.estacao.oae.model.Event;

import java.util.List;
import java.util.stream.Collectors;

public final class EventMapper {

    private EventMapper() {
    }

    public static Event from(EventDTO dto) {
        final Event event = new Event();
        event.setId(dto.getId());
        event.setCod(dto.getCod());
        event.setContent(dto.getContent());
        event.setDescription(dto.getDescription());
        event.setImage(dto.getImage());
        event.setTitle(dto.getTitle());
        event.setExpectedHours(dto.getExpectedHours());
        event.setPeriodOf(dto.getPeriodOf());
        event.setPeriodUntil(dto.getPeriodUntil());
        return event;
    }

    public static EventDTO toDTO(Event event){

        if(event == null) {
            return null;
        }

        final EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setCod(event.getCod());
        dto.setImage(event.getImage());
        dto.setDescription(event.getDescription());
        dto.setContent(event.getContent());
        dto.setExpectedHours(event.getExpectedHours());
        dto.setTitle(event.getTitle());
        dto.setPeriodOf(event.getPeriodOf());
        dto.setPeriodUntil(event.getPeriodUntil());

        return dto;
    }

    public static List<EventDTO> toDTO(List<Event> events) {
        return events.stream().map(EventMapper::toDTO).collect(Collectors.toList());
    }
}
