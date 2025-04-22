package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Detalle del contacto del cliente (celular o correo electrónico)")
public class MDMContacto {

    @Schema(description = "Tipo de contacto", example = "Teléfono celular contacto", required = true)
    private String tipo;

    @Schema(description = "Valor del contacto", example = "3143496905", required = true)
    private String valor;
}
