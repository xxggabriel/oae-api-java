package br.estacio.campos.estacao.oae.service;

import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> listAll(){
        return eventRepository.findAll();
    }


    public Event findById(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.get();
    }

}
