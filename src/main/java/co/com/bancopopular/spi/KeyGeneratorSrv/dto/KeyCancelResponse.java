package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta para la cancelación de clave")
public class KeyCancelResponse {

    @Schema(description = "Código de la respuesta", example = "200", required = true)
    private String codigo;

    @Schema(description = "Mensaje detallado de la respuesta", example = "Cancelación exitosa", required = true)
    private String message;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}