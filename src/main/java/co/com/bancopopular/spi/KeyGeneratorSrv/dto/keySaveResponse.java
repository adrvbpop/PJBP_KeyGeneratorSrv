package co.com.bancopopular.spi.KeyGeneratorSrv.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "keySaveResponse", description = "Respuesta del servicio")
public class keySaveResponse {

    private MsgHdrResponse msgHdrResponse;

    public MsgHdrResponse getMsgHdrResponse() {
        return msgHdrResponse;
    }

    public void setMsgHdrResponse(MsgHdrResponse msgHdrResponse) {
        this.msgHdrResponse = msgHdrResponse;
    }
}
