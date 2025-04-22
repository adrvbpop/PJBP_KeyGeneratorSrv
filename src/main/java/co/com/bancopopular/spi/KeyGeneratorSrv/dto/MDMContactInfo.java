package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import java.util.List;

public class MDMContactInfo {
    private final List<MDMContacto> celulares;
    private final List<MDMContacto> correos;

    public MDMContactInfo(List<MDMContacto> celulares, List<MDMContacto> correos) {
        this.celulares = celulares;
        this.correos = correos;
    }

    public List<MDMContacto> getCelulares() {
        return celulares;
    }

    public List<MDMContacto> getCorreos() {
        return correos;
    }
}

