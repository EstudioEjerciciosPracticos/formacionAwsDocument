package co.com.iasaws.dto.request;

import lombok.Data;

@Data
public class DocumentoRequestDto {

    private String clienteId;
    private String nombreArchivo;
    private String tipo;

}
