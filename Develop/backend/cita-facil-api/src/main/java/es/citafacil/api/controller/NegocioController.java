
package es.citafacil.api.controller;

import es.citafacil.api.dto.NegocioRegistroRequest;
import es.citafacil.api.dto.NegocioResponse;
import es.citafacil.api.service.NegocioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/negocios")
public class NegocioController {

    private final NegocioService negocioService;

    public NegocioController(NegocioService negocioService) {
        this.negocioService = negocioService;
    }

    @PostMapping
    public ResponseEntity<NegocioResponse> registrarNegocio(
            @Valid @RequestBody NegocioRegistroRequest request,
            Authentication authentication) {

        NegocioResponse negocio = negocioService.registrarNegocio(
                request,
                authentication.getName()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(negocio);
    }


    @GetMapping("/mis-negocios")
    public ResponseEntity<java.util.List<NegocioResponse>> listarMisNegocios(
            Authentication authentication) {

        return ResponseEntity.ok(
                negocioService.listarMisNegocios(authentication.getName())
        );
    }

}
