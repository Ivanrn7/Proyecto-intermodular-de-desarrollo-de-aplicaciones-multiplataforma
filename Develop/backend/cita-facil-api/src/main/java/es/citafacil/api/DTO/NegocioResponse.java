
package es.citafacil.api.dto;

import java.time.LocalDateTime;

public record NegocioResponse(
        Long idNegocio,
        Long idUsuario,
        String nombreNegocio,
        String descripcion,
        String direccion,
        String telefono,
        String email,
        LocalDateTime fechaRegistro
) {
}
