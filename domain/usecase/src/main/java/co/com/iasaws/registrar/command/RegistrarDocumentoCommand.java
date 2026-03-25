package co.com.iasaws.registrar.command;

public class RegistrarDocumentoCommand {

    private final String clienteId;
    private final String nombreOriginal;
    private final String tipo;

    public RegistrarDocumentoCommand(String clienteId, String nombreOriginal, String tipo) {
        this.clienteId = clienteId;
        this.nombreOriginal = nombreOriginal;
        this.tipo = tipo;
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
}
