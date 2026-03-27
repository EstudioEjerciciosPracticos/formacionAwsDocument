package co.com.iasaws.mapper;

import co.com.iasaws.Documento;
import co.com.iasaws.dto.response.DocumentoPorclienteResponseDto;

public class DocumentoClienteRespMapper {

    public static DocumentoPorclienteResponseDto toResponse(Documento documento){
        return DocumentoPorclienteResponseDto.builder()
                .id(documento.getId())
                .clienteId(documento.getClienteId())
                .nombre(documento.getNombreOriginal())
                .tipo(documento.getTipo())
                .build();
    }
}
