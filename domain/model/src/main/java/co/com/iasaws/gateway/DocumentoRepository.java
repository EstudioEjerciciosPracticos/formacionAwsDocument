package co.com.iasaws.gateway;

import co.com.iasaws.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoRepository {

    Documento guardar(Documento documento);

    Optional<Documento> buscarDocumentoPorId(String id);

    List<Documento> buscarPorCliente(String clienteId);

}
