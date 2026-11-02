
package es.citafacil.api.controller;

import es.citafacil.api.dto.ReservaRegistroRequest;
import es.citafacil.api.entity.Reserva;
import es.citafacil.api.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva registrarReserva(
            @Valid @RequestBody ReservaRegistroRequest request,
            Authentication authentication) {

        return reservaService.registrarReserva(
                request.idServicio(),
                request.fechaServicio(),
                request.notas(),
                authentication.getName()
        );
    }
    @GetMapping("/mis-reservas")
    public List<Reserva> listarMisReservas(
            Authentication authentication) {

        return reservaService.listarReservasUsuario(
                authentication.getName()
        );
    }


    @PatchMapping("/{idReserva}/cancelar")
    public Reserva cancelarReserva(
            @PathVariable Long idReserva,
            Authentication authentication) {

        return reservaService.cancelarReserva(
                idReserva,
                authentication.getName()
        );
    }

}
