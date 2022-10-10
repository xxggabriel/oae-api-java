package br.estacio.campos.estacao.oae.service;

import br.estacio.campos.estacao.oae.model.Athletic;
import br.estacio.campos.estacao.oae.repository.AthleticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AthletocService {

    @Autowired
    private AthleticRepository athleticRepository;

    public List<Athletic> listAll(){
        return athleticRepository.findAll();
    }


    public Optional<Athletic> findById(Long athleticId) {
        return athleticRepository.findById(athleticId);
    }

    public Athletic save(Athletic athletic) {
        return athleticRepository.save(athletic);
    }

    public void deleteById(Long athleticId) {
        athleticRepository.deleteById(athleticId);
    }
}
