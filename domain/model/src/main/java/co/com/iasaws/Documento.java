package co.com.iasaws;

import java.time.LocalDateTime;
import java.util.UUID;

public class Documento {
    private String id;
    private String clienteId;
    private String nombreOriginal;
    private String tipo;
    private LocalDateTime fechaRegistro;
    private EstadoDocumento estado;
    private String storageKey;

    public Documento(String id, String clienteId, String nombreOriginal, String tipo, LocalDateTime fechaRegistro, EstadoDocumento estado, String storageKey) {
        this.id = id;
        this.clienteId = clienteId;
        this.nombreOriginal = nombreOriginal;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.storageKey = storageKey;
    }

    public Documento(String clienteId, String nombreOriginal, String tipo) {

        validar(clienteId, nombreOriginal, tipo);

        this.id = UUID.randomUUID().toString();
        this.clienteId = clienteId;
        this.nombreOriginal = nombreOriginal;
        this.tipo = tipo;
        this.fechaRegistro = LocalDateTime.now();
        this.estado = EstadoDocumento.RESGISTRADO;
        this.storageKey = generarStorageKey(clienteId, nombreOriginal, tipo);
    }

    private void validar(String clienteId, String nombreOriginal, String tipo){

        if(clienteId == null || clienteId.isBlank()){
            throw new IllegalArgumentException("El cliente es obligatorio");
        }

        if(tipo == null || tipo.isBlank()){
            throw new IllegalArgumentException("El tipo de documento es obligatorio");
        }

        if(nombreOriginal == null || nombreOriginal.isBlank()){
            throw new IllegalArgumentException("El nombre del archivo es obligatorio");
        }

    }

    private String generarStorageKey(String clienteId, String nombreOriginal, String tipo){
        String uuid = UUID.randomUUID().toString();
        return clienteId + "/" + tipo + "/" + uuid + "/" + nombreOriginal ;
    }

    public void marcarComoCargado(){
        this.estado = EstadoDocumento.CARGADO;
    }

    public void marcarComoError(){
        this.estado = EstadoDocumento.ERROR_CARGA;
    }

    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public String getStorageKey() {
        return storageKey;
    }
}
