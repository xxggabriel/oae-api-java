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


    public Optional<Event> findById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
