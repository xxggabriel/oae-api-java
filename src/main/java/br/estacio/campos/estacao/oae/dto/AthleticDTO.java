package br.estacio.campos.estacao.oae.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class AthleticDTO  implements Serializable {

    private Long id;
    private String image;
    private String name;
    private String description;
}
