package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Cuerpo de la respuesta")
public class MDMResponseFormat {

    @Schema(description = "Encabezado de la respuesta", required = true)
    private MsgHdrResponse msgHdrResponse;

    @Schema(description = "Cuerpo de la respuesta", required = true)
    private MDMResponse body;

    public MsgHdrResponse getMsgHdrResponse() {
        return msgHdrResponse;
    }

    public void setMsgHdrResponse(MsgHdrResponse msgHdrResponse) {
        this.msgHdrResponse = msgHdrResponse;
    }

    public MDMResponse getBody() {
        return body;
    }

    public void setBody(MDMResponse body) {
        this.body = body;
    }


}
