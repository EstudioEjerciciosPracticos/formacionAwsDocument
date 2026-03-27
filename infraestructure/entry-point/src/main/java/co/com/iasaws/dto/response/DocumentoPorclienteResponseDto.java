package co.com.iasaws.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoPorclienteResponseDto {

    private String id;
    private String clienteId;
    private String nombre;
    private String tipo;
}
