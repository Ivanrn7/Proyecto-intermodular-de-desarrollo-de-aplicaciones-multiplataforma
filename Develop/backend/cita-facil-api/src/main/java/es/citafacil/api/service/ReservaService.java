
package es.citafacil.api.service;


import es.citafacil.api.entity.Reserva;
import es.citafacil.api.entity.Servicio;
import es.citafacil.api.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import es.citafacil.api.repository.ReservaRepository;
import es.citafacil.api.repository.ServicioRepository;
import es.citafacil.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import es.citafacil.api.exception.ReservaSolapadaException;

import java.util.List;


@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ServicioRepository servicioRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            ServicioRepository servicioRepository,
            UsuarioRepository usuarioRepository) {

        this.reservaRepository = reservaRepository;
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public Reserva registrarReserva(
            Long idServicio,
            LocalDateTime fechaServicio,
            String notas,
            String emailUsuario) {

        Usuario usuario = usuarioRepository
                .findByEmailIgnoreCase(emailUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El usuario no existe"));

        Servicio servicio = servicioRepository
                .findById(idServicio)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El servicio no existe"));

        if (!Boolean.TRUE.equals(servicio.getEstado())) {
            throw new IllegalArgumentException(
                    "No se puede reservar un servicio desactivado");
        }

        if (fechaServicio == null
                || !fechaServicio.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "La fecha de la reserva debe ser futura");
        }
        LocalDateTime finNuevaReserva = fechaServicio.plusMinutes(
                servicio.getDuracionMinutos()
        );

        long reservasSolapadas = reservaRepository.contarReservasSolapadas(
                servicio.getNegocio().getIdNegocio(),
                List.of("PENDIENTE", "CONFIRMADA"),
                fechaServicio,
                finNuevaReserva
        );

        if (reservasSolapadas > 0) {
            throw new ReservaSolapadaException(
                    "Ya existe una reserva en ese horario");
        }

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setServicio(servicio);
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setFechaServicio(fechaServicio);
        reserva.setPrecioTotal(servicio.getPrecio());
        reserva.setNotas(notas);
        reserva.setEstado("PENDIENTE");
        reserva.setEnviadoNotRecordatorio(false);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservasUsuario(String emailUsuario) {

        Usuario usuario = usuarioRepository
                .findByEmailIgnoreCase(emailUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El usuario no existe"));

        return reservaRepository.findByUsuarioIdUsuario(
                usuario.getIdUsuario()
        );
    }

    @Transactional
    public Reserva cancelarReserva(Long idReserva, String emailUsuario) {

        Usuario usuario = usuarioRepository
                .findByEmailIgnoreCase(emailUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException("El usuario no existe"));

        Reserva reserva = reservaRepository
                .findByIdReservaAndUsuarioIdUsuario(
                        idReserva,
                        usuario.getIdUsuario()
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "La reserva no existe o no te pertenece"));

        if ("CANCELADA".equals(reserva.getEstado())) {
            throw new IllegalArgumentException(
                    "La reserva ya está cancelada");
        }

        if ("COMPLETADA".equals(reserva.getEstado())) {
            throw new IllegalArgumentException(
                    "No se puede cancelar una reserva completada");
        }

        reserva.setEstado("CANCELADA");

        return reservaRepository.save(reserva);
    }

}
