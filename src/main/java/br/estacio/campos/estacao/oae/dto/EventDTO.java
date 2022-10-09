package br.estacio.campos.estacao.oae.dto;

import br.estacio.campos.estacao.oae.model.Event;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class EventDTO {

    private Long id;
    private String cod;
    private String image;
    private String title;
    private String content;
    private String description;
    private int expectedHours;
    private int periodOf;
    private int periodUntil;

}
