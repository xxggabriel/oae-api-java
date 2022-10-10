package br.estacio.campos.estacao.oae.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name="athletics")
public class Athletic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private String description;

    public Athletic() {

    }

    public Athletic(Long id, String image, String name, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athletic event = (Athletic) o;
        return Objects.equals(id, event.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
