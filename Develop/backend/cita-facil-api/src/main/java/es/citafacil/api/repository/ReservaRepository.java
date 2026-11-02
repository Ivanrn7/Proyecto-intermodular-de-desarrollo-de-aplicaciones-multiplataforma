
package es.citafacil.api.repository;

import es.citafacil.api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;
import es.citafacil.api.entity.Usuario;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioIdUsuario(Long idUsuario);

    List<Reserva> findByServicioIdServicio(Long idServicio);

    List<Reserva> findByEstado(String estado);

    Optional<Reserva> findByIdReservaAndUsuarioIdUsuario(
            Long idReserva,
            Long idUsuario
    );


    @Query("""
        SELECT COUNT(r)
        FROM Reserva r
        JOIN r.servicio s
        WHERE s.negocio.idNegocio = :idNegocio
          AND r.estado IN :estados
          AND r.fechaServicio < :finNuevaReserva
          AND FUNCTION('TIMESTAMPADD', MINUTE, s.duracionMinutos, r.fechaServicio) > :inicioNuevaReserva
        """)
    long contarReservasSolapadas(
            @Param("idNegocio") Long idNegocio,
            @Param("estados") List<String> estados,
            @Param("inicioNuevaReserva") LocalDateTime inicioNuevaReserva,
            @Param("finNuevaReserva") LocalDateTime finNuevaReserva
    );


}
