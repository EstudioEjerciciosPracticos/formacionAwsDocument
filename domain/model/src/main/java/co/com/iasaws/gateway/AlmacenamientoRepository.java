package co.com.iasaws.gateway;

import java.io.InputStream;
import java.time.Duration;

public interface AlmacenamientoRepository {

    void subirArchivo(String storageKey, byte[] archivo, String contentType);

    String generarUrlTemporal(String storageKey, Duration duracion);

    boolean existeArchivo(String storageKey);
}