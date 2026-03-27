package co.com.iasaws.controller;


import co.com.iasaws.Documento;
import co.com.iasaws.cargar.CargarDocumentoUseCase;
import co.com.iasaws.descargar.GenerarUrlDescargaUseCase;
import co.com.iasaws.dto.request.DocumentoRequestDto;
import co.com.iasaws.dto.response.DocumentoResponseDto;
import co.com.iasaws.mapper.DocumentoRestMapper;
import co.com.iasaws.registrar.RegistrarDocumentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final RegistrarDocumentoUseCase registrarDocumentoUseCase;
    private final CargarDocumentoUseCase cargarDocumentoUseCase;
    private final GenerarUrlDescargaUseCase generarUrlDescargaUseCase;

    @PostMapping
    public DocumentoResponseDto registrarDocumento(@RequestBody DocumentoRequestDto documentoRequestDto){
        Documento documento = new Documento(
                documentoRequestDto.getClienteId(),
                documentoRequestDto.getNombreArchivo(),
                documentoRequestDto.getTipo()
        );
        return DocumentoRestMapper.toResponse(registrarDocumentoUseCase.registrar(documento));
    }

    @PostMapping(value = "/{id}/cargar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DocumentoResponseDto cargarDocumento(
            @PathVariable String id,
            @RequestPart("file") MultipartFile file
    ) throws IOException {

        Documento documento = cargarDocumentoUseCase.cargar(
                id,
                file.getBytes(),
                file.getContentType()
        );

        return DocumentoRestMapper.toResponse(documento);
    }

    @GetMapping("/{id}/descargar")
    public ResponseEntity<String> descargar(@PathVariable String id) {

        String url = generarUrlDescargaUseCase.generarUrlDescarga(id);

        return ResponseEntity.ok(url);
    }

}
