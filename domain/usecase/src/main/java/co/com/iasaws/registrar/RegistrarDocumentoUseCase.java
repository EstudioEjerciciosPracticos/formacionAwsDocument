package co.com.iasaws.registrar;

import co.com.iasaws.Documento;
import co.com.iasaws.gateway.DocumentoRepository;
import co.com.iasaws.registrar.command.RegistrarDocumentoCommand;

public class RegistrarDocumentoUseCase{
    private final DocumentoRepository documentoRepository;

    public RegistrarDocumentoUseCase(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public Documento registrar(Documento documento) {

        return documentoRepository.guardar(documento);
    }

}
