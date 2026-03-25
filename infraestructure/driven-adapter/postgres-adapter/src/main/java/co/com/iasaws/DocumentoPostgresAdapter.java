package co.com.iasaws;

import co.com.iasaws.gateway.DocumentoRepository;
import co.com.iasaws.mapper.DocumentoMapper;
import co.com.iasaws.repository.DocumentoJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DocumentoPostgresAdapter implements DocumentoRepository {

    private final DocumentoJpaRepository documentoJpaRepository;

    @Override
    public Documento guardar(Documento documento) {
        return DocumentoMapper.toDomain(
                documentoJpaRepository.save(DocumentoMapper.fromDomain(documento))
        );
    }

    @Override
    public Optional<Documento> buscarDocumentoPorId(String id) {
        return documentoJpaRepository.findById(id)
                .map(DocumentoMapper::toDomain);
    }

    @Override
    public List<Documento> buscarPorCliente(String clienteId) {
        return documentoJpaRepository.findByClienteId(clienteId)
                .stream()
                .map(DocumentoMapper::toDomain)
                .toList();
    }
}
