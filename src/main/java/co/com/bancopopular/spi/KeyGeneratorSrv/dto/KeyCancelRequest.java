package co.com.bancopopular.spi.KeyGeneratorSrv.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Schema(description = "Solicitud de cancelación de clave")
public class KeyCancelRequest {

    @NotNull(message = "tipo identificación es obligatorio")
    @Schema(description = "Tipo de identificación del usuario", required = true, example = "CC")
    private String tipoIdentificacion;

    @NotBlank(message = "numero de identificación es obligatorio")
    @Schema(description = "Número de identificación del usuario", required = true, example = "123456789")
    private String numeroIdentificacion;

    @NotNull(message = "numero de cuenta es obligatorio")
    @Schema(description = "Número de cuenta del usuario", required = true, example = "123456789012")
    private Long numeroCuenta;

    @NotEmpty(message = "TAG AVAL es obligatorio")
    @Schema(description = "Etiqueta del aval de la clave", required = true, example = "TAG1234")
    private String llaveTagAval;

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getLlaveTagAval() {
        return llaveTagAval;
    }

    public void setLlaveTagAval(String llaveTagAval) {
        this.llaveTagAval = llaveTagAval;
    }

}