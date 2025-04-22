package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Encabezado de la respuesta")
public class MsgHdrResponse {

    @Schema(description  = "Clave generada", example = "12345ABC")
    private String requestId;

    @Schema(description  = "Mensaje de respuesta", example = "Operación exitosa")
    private String mensajeRespuesta;

    @Schema(description  = "Código de estado", example = "200")
    private int codigoRespuesta;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
}
