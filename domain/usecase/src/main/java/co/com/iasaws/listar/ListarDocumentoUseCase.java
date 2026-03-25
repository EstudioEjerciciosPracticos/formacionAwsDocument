package co.com.iasaws.listar;

import co.com.iasaws.Documento;
import co.com.iasaws.gateway.DocumentoRepository;

import java.util.List;

public class ListarDocumentoUseCase{
    DocumentoRepository documentoRepository;

    public ListarDocumentoUseCase(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public List<Documento> listarDocumentos(String clienteId) {
        return documentoRepository.buscarPorCliente(clienteId);
    }
}
