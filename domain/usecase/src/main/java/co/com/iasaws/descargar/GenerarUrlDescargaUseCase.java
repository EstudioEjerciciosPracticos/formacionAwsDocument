package co.com.iasaws.descargar;

import co.com.iasaws.Documento;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import co.com.iasaws.gateway.DocumentoRepository;

import java.time.Duration;

public class GenerarUrlDescargaUseCase{

    private final DocumentoRepository documentoRepository;
    private final AlmacenamientoRepository almacenamientoRepository;

    public GenerarUrlDescargaUseCase(DocumentoRepository documentoRepository, AlmacenamientoRepository almacenamientoRepository) {
        this.documentoRepository = documentoRepository;
        this.almacenamientoRepository = almacenamientoRepository;
    }


    public String generarUrlDescarga(String documentoId) {
        Documento documento = documentoRepository.buscarDocumentoPorId(documentoId)
                .orElseThrow( () -> new RuntimeException("Documento no encontrado"));

        if(!almacenamientoRepository.existeArchivo(documento.getStorageKey())){
            throw new RuntimeException("El archivo no esta disponible para descargar");
        }

        return almacenamientoRepository.generarUrlTemporal(documento.getStorageKey(), Duration.ofMinutes(10));
    }
}
