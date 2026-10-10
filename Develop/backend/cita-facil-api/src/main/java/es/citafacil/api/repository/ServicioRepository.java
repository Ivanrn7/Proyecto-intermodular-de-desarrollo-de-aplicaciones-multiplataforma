
package es.citafacil.api.repository;

import es.citafacil.api.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    List<Servicio> findByNegocioIdNegocio(Long idNegocio);

    List<Servicio> findByNegocioIdNegocioAndEstadoTrue(Long idNegocio);
}
