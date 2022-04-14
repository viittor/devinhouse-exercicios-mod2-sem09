package br.com.viittor.cloudgames.repository;

import br.com.viittor.cloudgames.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelatorioRepository {

    @Query("SELECT j FROM jogo j WHERE genero like %:valor%")
    Optional<Usuario> findByGender(String valor);


}
