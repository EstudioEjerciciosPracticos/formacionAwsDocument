package co.com.iasaws.mapper;

import co.com.iasaws.Documento;
import co.com.iasaws.dto.response.DocumentoResponseDto;

public class DocumentoRestMapper {

    public static DocumentoResponseDto toResponse(Documento documento){
        return DocumentoResponseDto.builder()
                .id(documento.getId())
                .nombre(documento.getNombreOriginal())
                .estado(documento.getEstado().name())
                .build();
    }
}
