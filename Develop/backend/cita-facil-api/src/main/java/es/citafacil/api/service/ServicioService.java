
package es.citafacil.api.service;

import es.citafacil.api.dto.ServicioRegistroRequest;
import es.citafacil.api.dto.ServicioResponse;
import es.citafacil.api.entity.Negocio;
import es.citafacil.api.entity.Servicio;
import es.citafacil.api.repository.NegocioRepository;
import es.citafacil.api.repository.ServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;
    private final NegocioRepository negocioRepository;

    public ServicioService(
            ServicioRepository servicioRepository,
            NegocioRepository negocioRepository) {
        this.servicioRepository = servicioRepository;
        this.negocioRepository = negocioRepository;
    }

    @Transactional
    public ServicioResponse registrarServicio(
            Long idNegocio,
            ServicioRegistroRequest request,
            String emailUsuario) {

        Negocio negocio = negocioRepository
                .findById(idNegocio)
                .filter(n -> n.getUsuario() != null
                        && n.getUsuario().getEmail()
                        .equalsIgnoreCase(emailUsuario))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El negocio no existe o no te pertenece"));

        Servicio servicio = new Servicio();

        servicio.setNegocio(negocio);
        servicio.setNombre(request.nombre().trim());
        servicio.setDescripcion(request.descripcion());
        servicio.setDuracionMinutos(request.duracionMinutos());
        servicio.setPrecio(request.precio());
        servicio.setEstado(true);

        Servicio guardado = servicioRepository.save(servicio);

        return convertirAResponse(guardado);
    }

    private ServicioResponse convertirAResponse(Servicio servicio) {
        return new ServicioResponse(
                servicio.getIdServicio(),
                servicio.getNegocio().getIdNegocio(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getDuracionMinutos(),
                servicio.getPrecio(),
                servicio.getEstado()
        );
    }

    @Transactional(readOnly = true)
    public java.util.List<ServicioResponse> listarServicios(Long idNegocio) {
        return servicioRepository
                .findByNegocioIdNegocioAndEstadoTrue(idNegocio)
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    @Transactional
    public ServicioResponse actualizarServicio(
            Long idNegocio,
            Long idServicio,
            ServicioRegistroRequest request,
            String emailUsuario) {

        Servicio servicio = servicioRepository
                .findById(idServicio)
                .filter(s -> s.getNegocio() != null
                        && s.getNegocio().getIdNegocio()
                        .equals(idNegocio))
                .filter(s -> s.getNegocio().getUsuario() != null
                        && s.getNegocio().getUsuario().getEmail()
                        .equalsIgnoreCase(emailUsuario))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El servicio no existe o no te pertenece"));

        servicio.setNombre(request.nombre().trim());
        servicio.setDescripcion(request.descripcion());
        servicio.setDuracionMinutos(request.duracionMinutos());
        servicio.setPrecio(request.precio());

        Servicio actualizado = servicioRepository.save(servicio);

        return convertirAResponse(actualizado);
    }


    @Transactional
    public void eliminarServicio(
            Long idNegocio,
            Long idServicio,
            String emailUsuario) {

        Servicio servicio = servicioRepository
                .findById(idServicio)
                .filter(s -> s.getNegocio() != null
                        && s.getNegocio().getIdNegocio()
                        .equals(idNegocio))
                .filter(s -> s.getNegocio().getUsuario() != null
                        && s.getNegocio().getUsuario().getEmail()
                        .equalsIgnoreCase(emailUsuario))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El servicio no existe o no te pertenece"));

        servicioRepository.delete(servicio);
    }

    @Transactional
    public ServicioResponse cambiarEstadoServicio(
            Long idNegocio,
            Long idServicio,
            boolean estado,
            String emailUsuario) {

        Servicio servicio = servicioRepository
                .findById(idServicio)
                .filter(s -> s.getNegocio() != null
                        && s.getNegocio().getIdNegocio()
                        .equals(idNegocio))
                .filter(s -> s.getNegocio().getUsuario() != null
                        && s.getNegocio().getUsuario().getEmail()
                        .equalsIgnoreCase(emailUsuario))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El servicio no existe o no te pertenece"));

        servicio.setEstado(estado);

        Servicio actualizado = servicioRepository.save(servicio);

        return convertirAResponse(actualizado);
    }


}