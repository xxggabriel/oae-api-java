package br.estacio.campos.estacao.oae.config;

import br.estacio.campos.estacao.oae.dto.enums.DayOfWeek;
import br.estacio.campos.estacao.oae.dto.enums.EventPlace;
import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String... args) throws Exception {

        Event event1 = new Event(null, "3354", null, "Título", "Conteúdo", "Descrição", 1, null, null, null);
        eventRepository.saveAll(Arrays.asList(event1));
    }
}
