package co.com.iasaws;

import co.com.iasaws.config.AwsS3Config;
import co.com.iasaws.gateway.AlmacenamientoRepository;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.time.Duration;

@RequiredArgsConstructor
public class S3StorageAdapter implements AlmacenamientoRepository {

    private final S3Client s3Client;
    private final AwsS3Config awsS3Config;
    private final S3Presigner s3Presigner;

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

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(awsS3Config.getBucket())
                .key(storageKey)
                .build();

        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(duracion)
                .getObjectRequest(getObjectRequest)
                .build();

        PresignedGetObjectRequest presignedGetObjectRequest = s3Presigner.presignGetObject(getObjectPresignRequest);

        return presignedGetObjectRequest.url().toString();
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
