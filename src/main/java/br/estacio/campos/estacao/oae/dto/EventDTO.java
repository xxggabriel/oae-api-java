package br.estacio.campos.estacao.oae.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter @Setter

public class EventDTO implements Serializable {

    private Long id;
    private String cod;
    private String image;
    private String title;
    private String content;
    private String description;
    private int expectedHours;
    private Instant startDate;
    private Instant endDate;
    private Instant cancellationLimit;

}
