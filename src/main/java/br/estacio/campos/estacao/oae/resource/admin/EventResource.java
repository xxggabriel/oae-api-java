package br.estacio.campos.estacao.oae.resource.admin;

import br.estacio.campos.estacao.oae.dto.EventDTO;
import br.estacio.campos.estacao.oae.mapper.EventMapper;
import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdminEventResource")
@RequestMapping(value = "/api/v1/admins/events")
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

    @PostMapping()
    public EventDTO save(@RequestBody EventDTO eventDTO){
        return EventMapper.toDTO(eventService.save(EventMapper.from(eventDTO)));
    }

    @PutMapping(value = "/{eventId}")
    public ResponseEntity<Event> update(@PathVariable Long eventId, @RequestBody EventDTO eventDTO){

        return eventService.findById(eventId)
                .map(event -> {
                    event.setCod(eventDTO.getCod());
                    event.setContent(eventDTO.getContent());
                    event.setDescription(eventDTO.getDescription());
                    event.setImage(eventDTO.getImage());
                    event.setTitle(eventDTO.getTitle());
                    event.setExpectedHours(eventDTO.getExpectedHours());
                    event.setPeriodOf(eventDTO.getPeriodOf());
                    event.setPeriodUntil(eventDTO.getPeriodUntil());

                    Event updated = eventService.save(event);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{eventId}")
    public ResponseEntity<?> delete(@PathVariable Long eventId) {
        return eventService.findById(eventId)
                .map(event -> {
                    eventService.deleteById(eventId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
