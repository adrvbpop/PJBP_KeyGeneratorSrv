package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Respuesta del servicio Key Generator")
public class KeyGenerationResponse {

    @Schema(description = "Encabezado de la respuesta", required = true)
    private MsgHdrResponse msgHdrResponse;

    @Schema(description = "Cuerpo de la respuesta", required = true)
    private BodyResponse body;

    public MsgHdrResponse getMsgHdrResponse() {
        return msgHdrResponse;
    }

    public void setMsgHdrResponse(MsgHdrResponse msgHdrResponse) {
        this.msgHdrResponse = msgHdrResponse;
    }

    public BodyResponse getBody() {
        return body;
    }

    public void setBody(BodyResponse body) {
        this.body = body;
    }
}
