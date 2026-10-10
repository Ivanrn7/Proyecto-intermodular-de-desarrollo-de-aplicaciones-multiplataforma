
package es.citafacil.api.repository;

import es.citafacil.api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioIdUsuario(Long idUsuario);

    List<Reserva> findByServicioIdServicio(Long idServicio);

    List<Reserva> findByEstado(String estado);
}

