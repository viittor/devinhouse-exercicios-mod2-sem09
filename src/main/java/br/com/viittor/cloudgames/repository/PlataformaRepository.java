package br.com.viittor.cloudgames.repository;

import br.com.viittor.cloudgames.model.Plataforma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends CrudRepository<Plataforma, Long> {
}
