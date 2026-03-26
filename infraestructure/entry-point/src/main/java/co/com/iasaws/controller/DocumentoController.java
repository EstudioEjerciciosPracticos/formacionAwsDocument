package co.com.iasaws.controller;


import co.com.iasaws.Documento;
import co.com.iasaws.dto.request.DocumentoRequestDto;
import co.com.iasaws.dto.response.DocumentoResponseDto;
import co.com.iasaws.registrar.RegistrarDocumentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final RegistrarDocumentoUseCase registrarDocumentoUseCase;

    @PostMapping
    public DocumentoResponseDto registrarDocumento(@RequestBody DocumentoRequestDto documentoRequestDto){
        Documento documento = registrarDocumentoUseCase.registrar(
                documentoRequestDto.getClienteId(),
                documentoRequestDto.getNombreArchivo(),
                documentoRequestDto.getTipo()

        );
    }




}
