package co.com.iasaws.config;

import co.com.iasaws.cargar.CargarDocumentoUseCase;
import co.com.iasaws.descargar.GenerarUrlDescargaUseCase;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import co.com.iasaws.gateway.DocumentoRepository;
import co.com.iasaws.listar.ListarDocumentoUseCase;
import co.com.iasaws.registrar.RegistrarDocumentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public RegistrarDocumentoUseCase registrarDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new RegistrarDocumentoUseCase(documentoRepository);
    }

    @Bean
    public CargarDocumentoUseCase cargarDocumentoUseCase(DocumentoRepository documentoRepository, AlmacenamientoRepository almacenamientoRepository) {
        return new CargarDocumentoUseCase(documentoRepository, almacenamientoRepository);
    }

    @Bean
    public ListarDocumentoUseCase listarDocumentoUseCase(DocumentoRepository documentoRepository) {
        return new ListarDocumentoUseCase(documentoRepository);
    }

/*    @Bean
    public GenerarUrlDescargaUseCase generarUrlDescargaUseCase(DocumentoRepository documentoRepository, AlmacenamientoRepository almacenamientoRepository) {
        return new GenerarUrlDescargaUseCase(documentoRepository, almacenamientoRepository);
    }*/

}
