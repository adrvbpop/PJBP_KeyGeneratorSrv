package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Información de contacto del cliente")
public class MDMResponse {

    @Schema(description = "Lista de celulares asociados al cliente", required = true)
    private List<MDMContacto> celulares = new ArrayList<>();

    @Schema(description = "Lista de correos electrónicos asociados al cliente", required = true)
    private List<MDMContacto> correos = new ArrayList<>();
}
