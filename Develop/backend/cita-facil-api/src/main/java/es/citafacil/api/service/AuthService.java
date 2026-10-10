
package es.citafacil.api.service;

import es.citafacil.api.dto.LoginRequest;
import es.citafacil.api.dto.LoginResponse;
import es.citafacil.api.entity.Usuario;
import es.citafacil.api.exception.EmailYaRegistradoException;
import es.citafacil.api.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse iniciarSesion(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByEmail(request.email().trim().toLowerCase())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Correo o contraseña incorrectos"));

        if (!passwordEncoder.matches(
                request.password(),
                usuario.getPassword())) {
            throw new IllegalArgumentException(
                    "Correo o contraseña incorrectos");
        }

        String token = jwtService.generarToken(usuario.getEmail());

        return new LoginResponse(
                token,
                "Bearer",
                3600
        );
    }
}
