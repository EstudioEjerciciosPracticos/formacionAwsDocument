package co.com.iasaws.cargar;

import co.com.iasaws.Documento;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import co.com.iasaws.gateway.DocumentoRepository;

import java.io.InputStream;

public class CargarDocumentoUseCase {
    private final DocumentoRepository documentoRepository;
    private final AlmacenamientoRepository almacenamientoRepository;

    public CargarDocumentoUseCase(DocumentoRepository documentoRepository, AlmacenamientoRepository almacenamientoRepository) {
        this.documentoRepository = documentoRepository;
        this.almacenamientoRepository = almacenamientoRepository;
    }

    public void cargar(String documentoId, InputStream archivo) {
        Documento documento = documentoRepository.buscarDocumentoPorId( documentoId)
                .orElseThrow( () -> new RuntimeException("Documento no encontrado") );

        try {
            almacenamientoRepository.subirArchivo(documento.getStorageKey(), archivo);
            documento.marcarComoCargado();
        }catch (Exception e){
            documento.marcarComoError();
            throw new RuntimeException( "Error al cargar Archivo", e );
        }
    }
}
