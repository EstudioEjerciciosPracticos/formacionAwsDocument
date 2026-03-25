package co.com.iasaws.mapper;

import co.com.iasaws.Documento;
import co.com.iasaws.EstadoDocumento;
import co.com.iasaws.dbo.DocumentoDbo;

public class DocumentoMapper {

    public static DocumentoDbo fromDomain(Documento documento) {
        return DocumentoDbo.builder()
                .id(documento.getId())
                .clienteId(documento.getClienteId())
                .nombreOriginal(documento.getNombreOriginal())
                .tipo(documento.getTipo())
                .fechaRegistro(documento.getFechaRegistro())
                .estado(documento.getEstado().name())
                .storageKey(documento.getStorageKey())
                .build();
    }

    public static Documento toDomain(DocumentoDbo documentoDbo) {

        return new Documento(
                documentoDbo.getId(),
                documentoDbo.getClienteId(),
                documentoDbo.getNombreOriginal(),
                documentoDbo.getTipo(),
                documentoDbo.getFechaRegistro(),
                EstadoDocumento.valueOf(documentoDbo.getEstado()),
                documentoDbo.getStorageKey()
        );

    }
}
