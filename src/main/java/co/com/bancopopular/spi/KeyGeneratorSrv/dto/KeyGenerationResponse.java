package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "KeyGeneratorResponse", description = "Respuesta del servicio Key Generator")
public class KeyGenerationResponse {


    private MsgHdrResponse msgHdrResponse;
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