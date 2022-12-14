package br.estacio.campos.estacao.oae.config;

import br.estacio.campos.estacao.oae.dto.enums.DayOfWeek;
import br.estacio.campos.estacao.oae.dto.enums.EventPlace;
import br.estacio.campos.estacao.oae.model.Athletic;
import br.estacio.campos.estacao.oae.model.Event;
import br.estacio.campos.estacao.oae.repository.AthleticRepository;
import br.estacio.campos.estacao.oae.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AthleticRepository athleticRepository;

    @Override
    public void run(String... args) throws Exception {
        String eventImage = "https://inovaprudente.com.br/img/noticias/1476.jpg";
        Event event1 = new Event(null, "3354", eventImage, "Título", "Conteúdo", "Descrição", "Campus Estácio Estação",4, Instant.parse("2022-10-20T19:30:00Z"), Instant.parse("2022-10-20T21:30:00Z"), null);
        eventRepository.saveAll(Arrays.asList(event1));

        String imageAthletic = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhiX0AzY7ZHQ69ufgzuZ5v-Vd4EjqxcQWXVpn6zrGWnDZOsO10cL0SKa1VrUeIXQEXmVE&usqp=CAU";
        Athletic athletic1 = new Athletic(null, imageAthletic, "Agrarias", "Agronomia e Zootecnia - ENESA");
        athleticRepository.saveAll(Arrays.asList(athletic1));
    }
}
