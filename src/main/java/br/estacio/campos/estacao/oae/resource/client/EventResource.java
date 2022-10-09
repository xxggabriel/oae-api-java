package br.estacio.campos.estacao.oae.resource.client;

import br.estacio.campos.estacao.oae.dto.EventDTO;
import br.estacio.campos.estacao.oae.mapper.EventMapper;
import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/v1/events")
@RestController("ClientEventResource")
public class EventResource {

    @Autowired
    private EventService eventService;

    @GetMapping()
    public List<EventDTO> index() {
        return EventMapper.toDTO(eventService.listAll());

    }

    @GetMapping(value = "/{eventId}")
    public ResponseEntity<Event> show(@PathVariable("eventId") Long eventId){
        return eventService.findById(eventId)
                .map(event -> {
                    return ResponseEntity.ok().body(event);
                }).orElse(ResponseEntity.notFound().build());
    }

}
