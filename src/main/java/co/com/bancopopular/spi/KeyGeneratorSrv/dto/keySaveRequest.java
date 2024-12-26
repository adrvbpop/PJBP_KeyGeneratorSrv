package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

public class keySaveRequest {


    private String numeroIdentificacion;
    private String numeroLlave;

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroLlave() {
        return numeroLlave;
    }

    public void setNumeroLlave(String numeroLlave) {
        this.numeroLlave = numeroLlave;
    }
}
