package co.com.bancopopular.spi.KeyGeneratorSrv.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Cuerpo de la respuesta")
public class BodyResponse {

    @Schema(description = "Llave generada", example = "ABC123DEF456")
    private String llaveGenerada;

    public String getLlaveGenerada() {
        return llaveGenerada;
    }

    public void setLlaveGenerada(String llaveGenerada) {
        this.llaveGenerada = llaveGenerada;
    }
}
