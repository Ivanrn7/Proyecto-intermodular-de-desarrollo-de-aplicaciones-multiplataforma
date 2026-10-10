
package es.citafacil.api.repository;

import es.citafacil.api.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository
        extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByUsuarioIdUsuario(Long idUsuario);

    List<Notificacion> findByUsuarioIdUsuarioAndLeidaFalse(Long idUsuario);

    List<Notificacion> findByReservaIdReserva(Long idReserva);
}
