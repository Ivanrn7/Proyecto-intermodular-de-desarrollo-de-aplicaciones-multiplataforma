
package es.citafacil.api.controller;

import es.citafacil.api.dto.ServicioRegistroRequest;
import es.citafacil.api.dto.ServicioResponse;
import es.citafacil.api.service.ServicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@RestController // Indica a Spring que esta clase recibe peticiones HTTP y que sus resultados se devuelven como respuestas.
@RequestMapping("/api/negocios/{idNegocio}/servicios") //ruta base compartida en lso endpoints
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping // Creación de servicios HTTP 201
    @ResponseStatus(HttpStatus.CREATED)
    public ServicioResponse registrarServicio(
            @PathVariable Long idNegocio, //Obtiene el ID del negocio de la URL
            @Valid @RequestBody ServicioRegistroRequest request, // valida el objeto y convierte el JSON en un objeto Java
            // información sobre el usuario autenticado en la petición
            Authentication authentication) {

        return servicioService.registrarServicio(
                idNegocio,
                request,
                authentication.getName()
        );
    }
    @GetMapping // lista de objetos servicio para el negocio indicado
    public java.util.List<ServicioResponse> listarServicios(
            @PathVariable Long idNegocio) {

        return servicioService.listarServicios(idNegocio);
    }

    @PutMapping("/{idServicio}") // Actualización del servicio
    public ServicioResponse actualizarServicio(
            @PathVariable Long idNegocio,
            @PathVariable Long idServicio,
            @Valid @RequestBody ServicioRegistroRequest request,
            Authentication authentication) {

        return servicioService.actualizarServicio(
                idNegocio,
                idServicio,
                request,
                authentication.getName()
        );
    }

    @DeleteMapping("/{idServicio}")  //Eliminación del servicio
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarServicio(
            @PathVariable Long idNegocio,
            @PathVariable Long idServicio,
            Authentication authentication) {

        servicioService.eliminarServicio(
                idNegocio,
                idServicio,
                authentication.getName()
        );

    }

    @PatchMapping("/{idServicio}/estado")
    public ServicioResponse cambiarEstadoServicio(
            @PathVariable Long idNegocio,
            @PathVariable Long idServicio,
            @RequestParam boolean estado,
            Authentication authentication) {

        return servicioService.cambiarEstadoServicio(
                idNegocio,
                idServicio,
                estado,
                authentication.getName()
        );
    }

}
