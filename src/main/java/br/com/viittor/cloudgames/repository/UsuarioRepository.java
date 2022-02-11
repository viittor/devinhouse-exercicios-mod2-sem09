package br.com.viittor.cloudgames.repository;

import br.com.viittor.cloudgames.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
}