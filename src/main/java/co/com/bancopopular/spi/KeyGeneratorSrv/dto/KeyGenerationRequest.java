package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Entidad del usuario que representa a un usuario en el sistema")
public class KeyGenerationRequest {

    @Schema(description = "ID del usuario", example = "123456789", required = true)
    private String numeroIdentificacion;

    @Schema(description = "Tipo de medio de pago del usuario", example = "CreditCard", required = true)
    private String tipoMediodePago;

    @Schema(description = "Número de medio de pago del usuario", example = "987654321", required = true)
    private Long numeroMediodePago;

    @Schema(description = "Primer nombre del usuario", example = "John", required = true)
    private String primerNombre;

    @Schema(description = "Segundo nombre del usuario", example = "Michael")
    private String segundoNombre;

    @Schema(description = "Primer apellido del usuario", example = "Doe", required = true)
    private String primerApellido;

    @Schema(description = "Segundo apellido del usuario", example = "Smith")
    private String segundoApellido;

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

    public String getTipoMediodePago() {
        return tipoMediodePago;
    }

    public void setTipoMediodePago(String tipoMediodePago) {
        this.tipoMediodePago = tipoMediodePago;
    }

    public Long getNumeroMediodePago() {
        return numeroMediodePago;
    }

    public void setNumeroMediodePago(Long numeroMediodePago) {
        this.numeroMediodePago = numeroMediodePago;
    }
}
