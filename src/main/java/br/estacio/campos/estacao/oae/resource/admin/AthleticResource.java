package br.estacio.campos.estacao.oae.resource.admin;

import br.estacio.campos.estacao.oae.dto.AthleticDTO;
import br.estacio.campos.estacao.oae.mapper.AthleticMapper;
import br.estacio.campos.estacao.oae.model.Athletic;
import br.estacio.campos.estacao.oae.service.AthletocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdminAthleticResource")
@RequestMapping(value = "/api/v1/admins/athletics")
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

    @PostMapping()
    public AthleticDTO save(@RequestBody AthleticDTO AthleticDTO){
        return AthleticMapper.toDTO(athleticService.save(AthleticMapper.from(AthleticDTO)));
    }

    @PutMapping(value = "/{athleticId}")
    public ResponseEntity<Athletic> update(@PathVariable Long athleticId, @RequestBody AthleticDTO AthleticDTO){

        return athleticService.findById(athleticId)
                .map(athletic -> {
                    athletic.setName(AthleticDTO.getName());
                    athletic.setDescription(AthleticDTO.getDescription());
                    athletic.setImage(AthleticDTO.getImage());

                    Athletic updated = athleticService.save(athletic);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{athleticId}")
    public ResponseEntity<?> delete(@PathVariable Long athleticId) {
        return athleticService.findById(athleticId)
                .map(athletic -> {
                    athleticService.deleteById(athleticId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
