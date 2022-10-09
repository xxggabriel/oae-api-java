package br.estacio.campos.estacao.oae.resource.client;

import br.estacio.campos.estacao.oae.dto.EventDTO;
import br.estacio.campos.estacao.oae.mapper.EventMapper;
import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @GetMapping()
    public List<EventDTO> index() {
        return EventMapper.toDTO(eventService.listAll());
    }

    @GetMapping(value = "/{eventId}")
    public EventDTO show(@PathVariable("eventId") Long eventId) {
        EventDTO event = EventMapper.toDTO(eventService.findById(eventId));

        return event;
    }

}
