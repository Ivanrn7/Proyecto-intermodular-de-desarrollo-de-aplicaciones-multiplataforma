
package es.citafacil.api.controller;

import es.citafacil.api.dto.UsuarioRegistroRequest;
import es.citafacil.api.dto.UsuarioResponse;
import es.citafacil.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRegistroController {

    private final UsuarioService usuarioService;

    public UsuarioRegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> registrarUsuario(
            @Valid @RequestBody UsuarioRegistroRequest request) {

        UsuarioResponse usuario =
                usuarioService.registrarUsuario(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
