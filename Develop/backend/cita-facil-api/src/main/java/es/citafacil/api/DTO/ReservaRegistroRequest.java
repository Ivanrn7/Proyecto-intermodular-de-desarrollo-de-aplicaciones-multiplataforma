
package es.citafacil.api.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ReservaRegistroRequest(

        @NotNull(message = "El servicio es obligatorio")
        Long idServicio,

        @NotNull(message = "La fecha de la cita es obligatoria")
        @Future(message = "La fecha de la cita debe ser futura")
        LocalDateTime fechaServicio,

        @Size(max = 500, message = "Las notas no pueden superar 500 caracteres")
        String notas

) {
}
