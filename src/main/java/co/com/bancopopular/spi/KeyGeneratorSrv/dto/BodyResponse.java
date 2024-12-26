package co.com.bancopopular.spi.KeyGeneratorSrv.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "BodyResponse", description = "Cuerpo de la respuesta")
public class BodyResponse {

    private String llaveGenerada;
    private String accion;
    private String nombreDeArchivo;
    private int numeroLineaDeRegistro;
    private String estadoLlaveBanco;
    private String tipoLlave;
    private String numeroLlave;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String tipoDePersona;
    private String nombrePersonaJuridica;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long nitEntidadEmisora;
    private String tipoMedioDePago;
    private Long numeroMedioDePago;

    @Schema(description = "Fecha de creación", example = "2024-12-22T18:07:58.489Z")
    private LocalDateTime fechaCreacion;

    private String fechaModificacion;
    private String estadoLlave;
    private int codigoBancoAval;
    private String llaveFavorita;

    public String getLlaveGenerada() {
        return llaveGenerada;
    }

    public void setLlaveGenerada(String llaveGenerada) {
        this.llaveGenerada = llaveGenerada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public int getNumeroLineaDeRegistro() {
        return numeroLineaDeRegistro;
    }

    public void setNumeroLineaDeRegistro(int numeroLineaDeRegistro) {
        this.numeroLineaDeRegistro = numeroLineaDeRegistro;
    }

    public String getEstadoLlaveBanco() {
        return estadoLlaveBanco;
    }

    public void setEstadoLlaveBanco(String estadoLlaveBanco) {
        this.estadoLlaveBanco = estadoLlaveBanco;
    }

    public String getTipoLlave() {
        return tipoLlave;
    }

    public void setTipoLlave(String tipoLlave) {
        this.tipoLlave = tipoLlave;
    }

    public String getNumeroLlave() {
        return numeroLlave;
    }

    public void setNumeroLlave(String numeroLlave) {
        this.numeroLlave = numeroLlave;
    }

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

    public String getTipoDePersona() {
        return tipoDePersona;
    }

    public void setTipoDePersona(String tipoDePersona) {
        this.tipoDePersona = tipoDePersona;
    }

    public String getNombrePersonaJuridica() {
        return nombrePersonaJuridica;
    }

    public void setNombrePersonaJuridica(String nombrePersonaJuridica) {
        this.nombrePersonaJuridica = nombrePersonaJuridica;
    }

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

    public Long getNitEntidadEmisora() {
        return nitEntidadEmisora;
    }

    public void setNitEntidadEmisora(Long nitEntidadEmisora) {
        this.nitEntidadEmisora = nitEntidadEmisora;
    }

    public String getTipoMedioDePago() {
        return tipoMedioDePago;
    }

    public void setTipoMedioDePago(String tipoMedioDePago) {
        this.tipoMedioDePago = tipoMedioDePago;
    }

    public Long getNumeroMedioDePago() {
        return numeroMedioDePago;
    }

    public void setNumeroMedioDePago(Long numeroMedioDePago) {
        this.numeroMedioDePago = numeroMedioDePago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstadoLlave() {
        return estadoLlave;
    }

    public void setEstadoLlave(String estadoLlave) {
        this.estadoLlave = estadoLlave;
    }

    public int getCodigoBancoAval() {
        return codigoBancoAval;
    }

    public void setCodigoBancoAval(int codigoBancoAval) {
        this.codigoBancoAval = codigoBancoAval;
    }

    public String getLlaveFavorita() {
        return llaveFavorita;
    }

    public void setLlaveFavorita(String llaveFavorita) {
        this.llaveFavorita = llaveFavorita;
    }
}
