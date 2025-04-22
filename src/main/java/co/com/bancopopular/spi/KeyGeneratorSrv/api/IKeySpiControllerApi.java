package co.com.bancopopular.spi.KeyGeneratorSrv.api;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.ConstantsApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Key SPI API", description = "API para gestionar claves")
public interface IKeySpiControllerApi {
//Generación de llave alfanumérica
    @Operation(summary = "Generación de llave alfanumérica", description = ConstantsApi.API_OPERACION_GENERACION)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ConstantsApi.API_RESPUESTA_200,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = KeyGenerationResponse.class))),
            @ApiResponse(responseCode = "206", description = ConstantsApi.API_RESPUESTA_206,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = ConstantsApi.API_RESPUESTA_400,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = ConstantsApi.API_RESPUESTA_404,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = ConstantsApi.API_RESPUESTA_500,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")))
    })
    @PostMapping(value = "/generate", consumes = "application/json", produces = "application/json;charset=UTF-8")
    ResponseEntity<?> generateKey(
            @Validated(GenericResponseDto.OtrasSolicitudes.class) @RequestBody KeyGenerationRequest request,
            @RequestHeader("X-Request-ID") String requestId);
//Registro de llave alfanumérica
    @Operation(summary = "Registro de llave alfanumérica", description = ConstantsApi.API_OPERACION_REGISTRO)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ConstantsApi.API_RESPUESTA_200,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = keySaveResponse.class))),
            @ApiResponse(responseCode = "206", description = ConstantsApi.API_RESPUESTA_206,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = ConstantsApi.API_RESPUESTA_400,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = ConstantsApi.API_RESPUESTA_404,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = ConstantsApi.API_RESPUESTA_500,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")))
    })
    @PostMapping(value = "/persistKey", consumes = "application/json", produces = "application/json")
    ResponseEntity<?> storeGeneratedKey(
            @Validated(GenericResponseDto.OtrasSolicitudes.class) @RequestBody keySaveRequest request,
            @RequestHeader("X-Request-ID") String requestId);
//Cancelación de llave alfanumérica
    @Operation(summary = "Cancelación de llave alfanumérica", description = ConstantsApi.API_OPERACION_ELIMINACION)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ConstantsApi.API_RESPUESTA_200,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = KeyCancelResponse.class))),
            @ApiResponse(responseCode = "206", description = ConstantsApi.API_RESPUESTA_206,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = ConstantsApi.API_RESPUESTA_400,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = ConstantsApi.API_RESPUESTA_404,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = ConstantsApi.API_RESPUESTA_500,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")))
    })
    @PostMapping(value = "/cancel", consumes = "application/json", produces = "application/json")
    ResponseEntity<KeyCancelResponse> cancelKey(
            @Validated(GenericResponseDto.OtrasSolicitudes.class) @RequestBody KeyCancelRequest request,
            @RequestHeader("X-Request-ID") String requestId);
//Validación de dato de MDM
    @Operation(summary = "Validación de dato de MDM", description = ConstantsApi.API_OPERACION_VALIDACION_DATO_ASOCIADO)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ConstantsApi.API_RESPUESTA_200,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MDMResponseFormat.class))),
            @ApiResponse(responseCode = "206", description = ConstantsApi.API_RESPUESTA_206,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = ConstantsApi.API_RESPUESTA_400,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = ConstantsApi.API_RESPUESTA_404,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = ConstantsApi.API_RESPUESTA_500,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDTO.class),
                            examples = @ExampleObject(value = "{ \"code\": 500, \"message\": \"An unexpected server error occurred\" }")))
    })
    @PostMapping(value = "/validateMDMData", consumes = "application/json", produces = "application/json")
    ResponseEntity<MDMResponseFormat> processMDM(
            @Validated(GenericResponseDto.OtrasSolicitudes.class) @RequestBody MDMRequest request,
            @RequestHeader("X-Request-ID") String requestId);
}
