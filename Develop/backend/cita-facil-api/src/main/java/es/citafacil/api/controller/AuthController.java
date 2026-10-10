
package es.citafacil.api.controller;

import es.citafacil.api.dto.LoginRequest;
import es.citafacil.api.dto.UsuarioResponse;
import es.citafacil.api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.citafacil.api.dto.LoginResponse;

@RestController
@RequestMapping("/api/usuarios")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> iniciarSesion(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse respuesta = authService.iniciarSesion(request);

        return ResponseEntity.ok(respuesta);
    }
}

