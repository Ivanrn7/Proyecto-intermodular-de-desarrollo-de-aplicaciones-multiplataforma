
package es.citafacil.api.service;

import es.citafacil.api.dto.UsuarioRegistroRequest;
import es.citafacil.api.dto.UsuarioResponse;
import es.citafacil.api.entity.Usuario;
import es.citafacil.api.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import es.citafacil.api.exception.EmailYaRegistradoException;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioResponse registrarUsuario(UsuarioRegistroRequest request) {

        if (usuarioRepository.findByEmail(
                request.email().trim().toLowerCase()).isPresent()) {

            throw new EmailYaRegistradoException(
                    "Ya existe un usuario con ese correo electrónico");
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(request.nombre().trim());
        usuario.setApellidos(request.apellidos().trim());
        usuario.setEmail(request.email().trim().toLowerCase());
        usuario.setTelefono(request.telefono());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setRol("CLIENTE");
        usuario.setFechaRegistro(LocalDateTime.now());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return new UsuarioResponse(
                usuarioGuardado.getIdUsuario(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getApellidos(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getTelefono(),
                usuarioGuardado.getRol(),
                usuarioGuardado.getFechaRegistro()
        );
    }
}
