package br.estacio.campos.estacao.oae.mapper;

import br.estacio.campos.estacao.oae.dto.AthleticDTO;
import br.estacio.campos.estacao.oae.dto.EventDTO;
import br.estacio.campos.estacao.oae.model.Athletic;
import br.estacio.campos.estacao.oae.model.Event;

import java.util.List;
import java.util.stream.Collectors;

public final class AthleticMapper {

    private AthleticMapper() {
    }

    public static Athletic from(AthleticDTO dto) {
        final Athletic athletic = new Athletic();
        athletic.setId(dto.getId());
        athletic.setImage(dto.getImage());
        athletic.setName(dto.getName());
        athletic.setDescription(dto.getDescription());
        return athletic;
    }

    public static AthleticDTO toDTO(Athletic athletic){

        if(athletic == null) {
            return null;
        }

        final AthleticDTO dto = new AthleticDTO();
        dto.setId(athletic.getId());
        dto.setImage(athletic.getImage());
        dto.setName(athletic.getName());
        dto.setDescription(athletic.getDescription());

        return dto;
    }

    public static List<AthleticDTO> toDTO(List<Athletic> athletics) {
        return athletics.stream().map(AthleticMapper::toDTO).collect(Collectors.toList());
    }
}
