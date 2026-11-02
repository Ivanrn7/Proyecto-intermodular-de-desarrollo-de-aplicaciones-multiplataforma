
package es.citafacil.api.dto;

import java.math.BigDecimal;

public record ServicioResponse(
        Long idServicio,
        Long idNegocio,
        String nombre,
        String descripcion,
        Integer duracionMinutos,
        BigDecimal precio,
        Boolean estado
) {
}