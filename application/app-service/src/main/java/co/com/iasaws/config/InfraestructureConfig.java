package co.com.iasaws.config;

import co.com.iasaws.DocumentoPostgresAdapter;
import co.com.iasaws.S3StorageAdapter;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import co.com.iasaws.gateway.DocumentoRepository;
import co.com.iasaws.repository.DocumentoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@RequiredArgsConstructor
public class InfraestructureConfig {

    private final DocumentoJpaRepository documentoJpaRepository;
    private final S3Client s3Client;
    private AwsS3Config awsS3Config;

    @Bean
    public DocumentoRepository getDocumentoJpaRepository() {
        return new DocumentoPostgresAdapter(documentoJpaRepository);
    }

    @Bean
    public AlmacenamientoRepository almacenamientoRepository(){
        return new S3StorageAdapter(s3Client, awsS3Config);
    }
}
