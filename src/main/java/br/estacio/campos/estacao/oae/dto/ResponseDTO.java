package br.estacio.campos.estacao.oae.dto;

import java.util.HashSet;
import java.util.Set;

public class ResponseDTO<T> {
    
    private Set<T> data = new HashSet<>();

    ResponseDTO(Set<T> data) {
        this.data = data;
    }
}
