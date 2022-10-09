package br.estacio.campos.estacao.oae.model;

import br.estacio.campos.estacao.oae.dto.enums.DayOfWeek;
import br.estacio.campos.estacao.oae.dto.enums.EventPlace;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cod;
    private String image;
    private String title;
    private String content;
    private String description;
    private int expectedHours;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GTM")
    private Instant startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GTM")
    private Instant endDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GTM")
    private Instant cancellationLimit;

    public Event() {

    }

    public Event(Long id, String cod, String image, String title, String content, String description, int expectedHours, Instant startDate, Instant endDate, Instant cancellationLimit) {
        this.id = id;
        this.cod = cod;
        this.image = image;
        this.title = title;
        this.content = content;
        this.description = description;
        this.expectedHours = expectedHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationLimit = cancellationLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
