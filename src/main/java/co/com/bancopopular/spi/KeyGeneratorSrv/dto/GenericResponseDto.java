    package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

    import java.util.List;

    import io.swagger.v3.oas.annotations.media.Schema;
    import org.springframework.validation.ObjectError;

    @Schema(description = "Respuesta genérica de la API")
    public class GenericResponseDto {

        @Schema(description = "Código de respuesta", required = true, example = "200")
        private String codigo;

        @Schema(description = "Código HTTP de la respuesta", required = true, example = "200")
        private Integer codigoHttp;

        @Schema(description = "Tipo de respuesta", required = true, example = "success")
        private String tipo;

        @Schema(description = "Mensaje asociado a la respuesta", required = true, example = "Operación exitosa")
        private String mensaje;

        @Schema(description = "Lista de errores, si los hubiera")
        private List<ObjectError> errores;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public Integer getCodigoHttp() {
            return codigoHttp;
        }

        public void setCodigoHttp(Integer codigoHttp) {
            this.codigoHttp = codigoHttp;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public List<ObjectError> getErrores() {
            return errores;
        }

        public void setErrores(List<ObjectError> errores) {
            this.errores = errores;
        }

        public interface OtrasSolicitudes {}

    }