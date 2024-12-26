package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "User entity representing a user in the system")
public class KeyGenerationRequest {
    @Schema(description = "requestId")
    private String requestId;
    @Schema(description = "firstname")
    private String primerNombre;
    @Schema(description = "secondName")
    private String segundoNombre;
    @Schema(description = "first Last Name")
    private String primerApellido;
    @Schema(description = "Second Last Name")
    private String segundoApellido;
    @Schema(description = "Type ID of the user")
    private String numeroIdentificacion;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}