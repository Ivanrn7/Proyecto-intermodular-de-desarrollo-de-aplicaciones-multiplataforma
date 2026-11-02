
package es.citafacil.api.service;

import es.citafacil.api.dto.NegocioRegistroRequest;
import es.citafacil.api.dto.NegocioResponse;
import es.citafacil.api.entity.Negocio;
import es.citafacil.api.entity.Usuario;
import es.citafacil.api.repository.NegocioRepository;
import es.citafacil.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NegocioService {

    private final NegocioRepository negocioRepository;
    private final UsuarioRepository usuarioRepository;

    public NegocioService(
            NegocioRepository negocioRepository,
            UsuarioRepository usuarioRepository) {
        this.negocioRepository = negocioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<NegocioResponse> listarMisNegocios(
            String emailUsuario) {

        return negocioRepository
                .findByUsuarioIdUsuario(
                        usuarioRepository.findByEmail(emailUsuario)
                                .orElseThrow(() ->
                                        new IllegalArgumentException(
                                                "El usuario autenticado no existe"))
                                .getIdUsuario())
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    @Transactional
    public NegocioResponse registrarNegocio(
            NegocioRegistroRequest request,
            String emailUsuario) {

        Usuario propietario = usuarioRepository
                .findByEmail(emailUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El usuario autenticado no existe"));

        Negocio negocio = new Negocio();

        negocio.setUsuario(propietario);
        negocio.setNombreNegocio(request.nombreNegocio().trim());
        negocio.setDescripcion(request.descripcion());
        negocio.setDireccion(request.direccion().trim());
        negocio.setTelefono(request.telefono());
        negocio.setEmail(request.email());
        negocio.setFechaRegistro(LocalDateTime.now());

        Negocio guardado = negocioRepository.save(negocio);

        // Asignar el rol NEGOCIO al propietario
        if (!"ADMIN".equals(propietario.getRol())) {
            propietario.setRol("NEGOCIO");
            usuarioRepository.save(propietario);
        }

        return convertirAResponse(guardado);
    }

    private NegocioResponse convertirAResponse(Negocio negocio) {

        return new NegocioResponse(
                negocio.getIdNegocio(),
                negocio.getUsuario().getIdUsuario(),
                negocio.getNombreNegocio(),
                negocio.getDescripcion(),
                negocio.getDireccion(),
                negocio.getTelefono(),
                negocio.getEmail(),
                negocio.getFechaRegistro()
        );
    }
}
