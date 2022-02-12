package br.com.viittor.cloudgames.repository;

import br.com.viittor.cloudgames.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.nome like %:valor%")
    Optional<Usuario> findByNome(String valor);

    @Query("SELECT u FROM Usuario u WHERE u.email like %:valor%")
    Optional<Usuario> findByEmail(String valor);
}
