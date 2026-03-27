package co.com.iasaws;

import co.com.iasaws.config.AwsS3Config;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;
import java.time.Duration;

@RequiredArgsConstructor
public class S3StorageAdapter implements AlmacenamientoRepository {

    private final S3Client s3Client;
    private final AwsS3Config awsS3Config;

    @Override
    public void subirArchivo(String storageKey, byte[] archivo, String contentType) {

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(awsS3Config.getBucket())
                .key(storageKey)
                .contentType(contentType)
                .build();

        try {
            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromBytes(archivo)
            );
        } catch (Exception e) {
            throw new RuntimeException("Error subiendo archivos a S3" + e);
        }
    }

    @Override
    public String generarUrlTemporal(String storageKey, Duration duracion) {
        return "https://fake-url/" + storageKey;
    }

    @Override
    public boolean existeArchivo(String storageKey) {

        try{
            s3Client.headObject( builder -> builder.bucket(awsS3Config.getBucket()).key(storageKey) );
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
