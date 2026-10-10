
package es.citafacil.api.dto;

public record LoginResponse(
        String token,
        String tipo,
        long expiraEn
) {
}
