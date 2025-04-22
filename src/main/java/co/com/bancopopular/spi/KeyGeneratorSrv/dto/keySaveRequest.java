package co.com.bancopopular.spi.KeyGeneratorSrv.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for saving a key")
public class keySaveRequest {


    @Schema(description = "Type of key", required = true, example = "P")
    private String tipoLlave;  // OBLIGATORIO

    @Schema(description = "Key number", required = true, example = "@BPJMDS789")
    private String numeroLlave;  // OBLIGATORIO

    @Schema(description = "Type of identification", required = true, example = "CC")
    private String tipoIdentificacion;  // OBLIGATORIO

    @Schema(description = "Identification number", required = true, example = "123456789")
    private String numeroIdentificacion;  // OBLIGATORIO

    @Schema(description = "Type of person", example = "PN")
    private String tipoDePersona;

    @Schema(description = "First name", example = "John")
    private String primerNombre;

    @Schema(description = "Second name", example = "Doe")
    private String segundoNombre;

    @Schema(description = "First last name", example = "Smith")
    private String primerApellido;

    @Schema(description = "Second last name", example = "Johnson")
    private String segundoApellido;

    @Schema(description = "Type of account", example = "Savings")
    private String tipoCuenta;

    @Schema(description = "Account number", example = "987654321")
    private String numeroCuenta;

    @Schema(description = "Issuer entity NIT", required = true, example = "900123456")
    private Long nitEntidadEmisora;  // OBLIGATORIO

    @Schema(description = "Payment method type", required = true, example = "Card")
    private String tipoMedioDePago;  // OBLIGATORIO

    @Schema(description = "Payment method number", required = true, example = "456789123")
    private Long numeroMedioDePago;  // OBLIGATORIO

    @Schema(description = "Creation date", required = true, example = "2024-12-22T18:07:58.489Z")
    private String fechaCreacion;  // OBLIGATORIO

    @Schema(description = "Modification date", example = "2025-01-01T12:00:00.000Z")
    private String fechaModificacion;

    @Schema(description = "Key status", required = true, example = "Active")
    private String estadoLlave;  // OBLIGATORIO

    @Schema(description = "Bank code in Aval system", required = true, example = "123")
    private int codigoBancoAval;  // OBLIGATORIO

    @Schema(description = "Is this a favorite key", required = true, example = "N")
    private String llaveFavorita;  // OBLIGATORIO

    @Schema(description = "Action to be performed", required = true, example = "I")
    private String accion;  // OBLIGATORIO                     // OBLIGATORIO

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getLlaveFavorita() {
        return llaveFavorita;
    }

    public void setLlaveFavorita(String llaveFavorita) {
        this.llaveFavorita = llaveFavorita;
    }

    public int getCodigoBancoAval() {
        return codigoBancoAval;
    }

    public void setCodigoBancoAval(int codigoBancoAval) {
        this.codigoBancoAval = codigoBancoAval;
    }

    public String getEstadoLlave() {
        return estadoLlave;
    }

    public void setEstadoLlave(String estadoLlave) {
        this.estadoLlave = estadoLlave;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getNumeroMedioDePago() {
        return numeroMedioDePago;
    }

    public void setNumeroMedioDePago(Long numeroMedioDePago) {
        this.numeroMedioDePago = numeroMedioDePago;
    }

    public String getTipoMedioDePago() {
        return tipoMedioDePago;
    }

    public void setTipoMedioDePago(String tipoMedioDePago) {
        this.tipoMedioDePago = tipoMedioDePago;
    }

    public Long getNitEntidadEmisora() {
        return nitEntidadEmisora;
    }

    public void setNitEntidadEmisora(Long nitEntidadEmisora) {
        this.nitEntidadEmisora = nitEntidadEmisora;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getTipoDePersona() {
        return tipoDePersona;
    }

    public void setTipoDePersona(String tipoDePersona) {
        this.tipoDePersona = tipoDePersona;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroLlave() {
        return numeroLlave;
    }

    public void setNumeroLlave(String numeroLlave) {
        this.numeroLlave = numeroLlave;
    }

    public String getTipoLlave() {
        return tipoLlave;
    }

    public void setTipoLlave(String tipoLlave) {
        this.tipoLlave = tipoLlave;
    }
}
