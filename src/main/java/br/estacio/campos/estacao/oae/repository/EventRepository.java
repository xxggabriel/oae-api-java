package br.estacio.campos.estacao.oae.repository;

import br.estacio.campos.estacao.oae.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
