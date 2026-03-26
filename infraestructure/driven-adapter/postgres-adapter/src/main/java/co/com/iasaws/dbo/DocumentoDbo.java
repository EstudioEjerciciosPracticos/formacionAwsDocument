package co.com.iasaws.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "documentos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentoDbo {
    @Id
    private String id;
    private String clienteId;
    private String nombreOriginal;
    private String tipo;
    private LocalDateTime fechaRegistro;
    private String estado;
    private String storageKey;
}
