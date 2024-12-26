package co.com.bancopopular.spi.KeyGeneratorSrv.controller;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.service.KeyGenerationService;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.Exception;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/keys")
public class KeyGenerationController {

    private final KeyGenerationService keyService;

    public KeyGenerationController(KeyGenerationService keyService) {
        this.keyService = keyService;
    }

    @PostMapping("/generate")
    @Operation(summary = "Creación de llave alfanumérica", description = "Genera una nueva llave")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Llave generada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = KeyGenerationResponse.class)),
                    headers = @io.swagger.v3.oas.annotations.headers.Header(name = "X-Request-ID", description = "Identificador único de la solicitud", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")),
                    headers = @io.swagger.v3.oas.annotations.headers.Header(name = "X-Request-ID", description = "Identificador único de la solicitud", schema = @Schema(type = "string")))
    })
public ResponseEntity<?> generateKey(@RequestBody KeyGenerationRequest request) {
        if (request == null ) {
            throw new IllegalArgumentException("Request cannot be empty");
        } else if (request.getNumeroIdentificacion().isEmpty()) {
            throw new Exception("El numero de identificacion es obligatorio");
        }
        KeyGenerationResponse response = (KeyGenerationResponse) keyService.generateKey(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/persistKey")
    @Operation(summary = "Almacenar llave generada", description = "Almacena una llave generada previamente en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Llave almacenada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = keySaveResponse.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")))
    })
    public ResponseEntity<?> storeGeneratedKey(@RequestBody keySaveRequest keyRequest, HttpServletRequest hdrRequest ) {
        if (keyRequest == null ) {
            throw new IllegalArgumentException("Request cannot be empty");
        } else if (keyRequest.getNumeroIdentificacion().isEmpty()) {
            throw new Exception("El numero de identificacion es obligatorio");
        }
        String requestId = hdrRequest.getHeader("X-Request-ID");
        keySaveResponse response = (keySaveResponse) keyService.storeKey(keyRequest, requestId );
        return ResponseEntity.ok(response);
    }



}