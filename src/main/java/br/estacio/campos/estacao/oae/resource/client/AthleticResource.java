package br.estacio.campos.estacao.oae.resource.client;

import br.estacio.campos.estacao.oae.dto.AthleticDTO;
import br.estacio.campos.estacao.oae.mapper.AthleticMapper;
import br.estacio.campos.estacao.oae.model.Athletic;
import br.estacio.campos.estacao.oae.service.AthletocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/v1/athletics")
@RestController("ClientAthleticResource")
public class AthleticResource {

    @Autowired
    private AthletocService athleticService;

    @GetMapping()
    public List<AthleticDTO> index() {
        return AthleticMapper.toDTO(athleticService.listAll());

    }

    @GetMapping(value = "/{athleticId}")
    public ResponseEntity<Athletic> show(@PathVariable("athleticId") Long athleticId){
        return athleticService.findById(athleticId)
                .map(athletic -> {
                    return ResponseEntity.ok().body(athletic);
                }).orElse(ResponseEntity.notFound().build());
    }
}
