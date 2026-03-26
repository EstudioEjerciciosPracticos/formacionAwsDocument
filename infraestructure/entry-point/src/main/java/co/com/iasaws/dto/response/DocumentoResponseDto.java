package co.com.iasaws.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoResponseDto {

    private String id;
    private String nombre;
    private String estado;
}
