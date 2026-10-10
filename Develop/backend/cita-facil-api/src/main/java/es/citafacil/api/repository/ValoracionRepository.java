
package es.citafacil.api.repository;

import es.citafacil.api.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionRepository
        extends JpaRepository<Valoracion, Long> {

    List<Valoracion> findByNegocioIdNegocio(Long idNegocio);

    List<Valoracion> findByUsuarioIdUsuario(Long idUsuario);

    List<Valoracion> findByReservaIdReserva(Long idReserva);
}

