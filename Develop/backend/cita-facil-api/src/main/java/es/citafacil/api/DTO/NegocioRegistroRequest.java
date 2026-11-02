
package es.citafacil.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NegocioRegistroRequest(

        @NotBlank(message = "El nombre del negocio es obligatorio")
        @Size(max = 150, message = "El nombre no puede superar los 150 caracteres")
        String nombreNegocio,

        @Size(max = 1000, message = "La descripción no puede superar los 1000 caracteres")
        String descripcion,

        @NotBlank(message = "La dirección es obligatoria")
        String direccion,

        String telefono,

        @Email(message = "El correo electrónico no es válido")
        String email

) {
}
