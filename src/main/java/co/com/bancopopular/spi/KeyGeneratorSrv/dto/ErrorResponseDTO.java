package co.com.bancopopular.spi.KeyGeneratorSrv.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Estructura de error")
public class ErrorResponseDTO {

    @Schema(description = "Encabezado del mensaje de respuesta", required = true)
    private MsgHdrResponse msgHdrResp;

    @Schema(description = "Código de error HTTP", example = "400", required = true)
    private int code;

    @Schema(description = "Mensaje de error detallado", example = "Request cannot be empty", required = true)
    private String message;

    public ErrorResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponseDTO() {
    }

    public MsgHdrResponse getMsgHdrResp() {
        return msgHdrResp;
    }

    public void setMsgHdrResp(MsgHdrResponse msgHdrResp) {
        this.msgHdrResp = msgHdrResp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
