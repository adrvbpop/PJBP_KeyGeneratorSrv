package co.com.bancopopular.spi.KeyGeneratorSrv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LLAVES_SPI")
public class LlaveSpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_LLAVE", unique = true, nullable = false)
    private String numeroLlave;

    @Column(name = "TIPO_LLAVE")
    private String tipoLlave;

    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;

    @Column(name = "TIPO_DE_PERSONA")
    private String tipoDePersona;

    @Column(name = "NOMBRE_PERSONA_JURIDICA")
    private String nombrePersonaJuridica;

    @Column(name = "PRIMER_NOMBRE_PN")
    private String primerNombrePn;

    @Column(name = "SEGUNDO_NOMBRE_PN")
    private String segundoNombrePn;

    @Column(name = "PRIMER_APELLIDO_PN")
    private String primerApellidoPn;

    @Column(name = "SEGUNDO_APELLIDO_PN")
    private String segundoApellidoPn;

    @Column(name = "NIT_ENTIDAD_EMISORA")
    private Long nitEntidadEmisora;

    @Column(name = "TIPO_MEDIO_DE_PAGO")
    private String tipoMedioDePago;

    @Column(name = "NUMERO_MEDIO_DE_PAGO")
    private Long numeroMedioDePago;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private String fechaModificacion;

    @Column(name = "ESTADO_DE_LLAVE")
    private String estadoDeLlave;

    @Column(name = "CODIGO_BANCO_AVAL")
    private Integer codigoBancoAval;

    @Column(name = "LLAVE_FAVORITA")
    private String llaveFavorita;

    @Column(name = "ACCION")
    private String accion;

    @Column(name = "NOMBRE_DE_ARCHIVO")
    private String nombreDeArchivo;

    @Column(name = "NUMERO_LINEA_DE_REGISTRO")
    private Integer numeroLineaDeRegistro;

    @Column(name = "ESTADO_LLAVE_BANCO")
    private String estadoLlaveBanco;

    public LlaveSpi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPrimerNombrePn() {
        return primerNombrePn;
    }

    public void setPrimerNombrePn(String primerNombrePn) {
        this.primerNombrePn = primerNombrePn;
    }

    public String getSegundoNombrePn() {
        return segundoNombrePn;
    }

    public void setSegundoNombrePn(String segundoNombrePn) {
        this.segundoNombrePn = segundoNombrePn;
    }

    public String getPrimerApellidoPn() {
        return primerApellidoPn;
    }

    public void setPrimerApellidoPn(String primerApellidoPn) {
        this.primerApellidoPn = primerApellidoPn;
    }

    public String getSegundoApellidoPn() {
        return segundoApellidoPn;
    }

    public void setSegundoApellidoPn(String segundoApellidoPn) {
        this.segundoApellidoPn = segundoApellidoPn;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstadoDeLlave() {
        return estadoDeLlave;
    }

    public void setEstadoDeLlave(String estadoDeLlave) {
        this.estadoDeLlave = estadoDeLlave;
    }

    public Integer getCodigoBancoAval() {
        return codigoBancoAval;
    }

    public void setCodigoBancoAval(Integer codigoBancoAval) {
        this.codigoBancoAval = codigoBancoAval;
    }

    public String getLlaveFavorita() {
        return llaveFavorita;
    }

    public void setLlaveFavorita(String llaveFavorita) {
        this.llaveFavorita = llaveFavorita;
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

    public Integer getNumeroLineaDeRegistro() {
        return numeroLineaDeRegistro;
    }

    public void setNumeroLineaDeRegistro(Integer numeroLineaDeRegistro) {
        this.numeroLineaDeRegistro = numeroLineaDeRegistro;
    }

    public String getEstadoLlaveBanco() {
        return estadoLlaveBanco;
    }

    public void setEstadoLlaveBanco(String estadoLlaveBanco) {
        this.estadoLlaveBanco = estadoLlaveBanco;
    }
}