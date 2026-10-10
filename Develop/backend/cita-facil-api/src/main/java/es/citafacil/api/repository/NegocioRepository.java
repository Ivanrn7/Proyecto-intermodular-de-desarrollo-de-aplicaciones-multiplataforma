
package es.citafacil.api.repository;

import es.citafacil.api.entity.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NegocioRepository extends JpaRepository<Negocio, Long> {

    List<Negocio> findByNombreNegocioContainingIgnoreCase(String nombreNegocio);

    List<Negocio> findByUsuarioIdUsuario(Long idUsuario);
}
