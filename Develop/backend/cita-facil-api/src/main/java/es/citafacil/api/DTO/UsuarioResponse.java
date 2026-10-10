
package es.citafacil.api.dto;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long idUsuario,
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String rol,
        LocalDateTime fechaRegistro
) {
}

