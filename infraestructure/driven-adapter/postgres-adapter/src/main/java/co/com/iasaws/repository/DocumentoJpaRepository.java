package co.com.iasaws.repository;

import co.com.iasaws.dbo.DocumentoDbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoJpaRepository extends JpaRepository<DocumentoDbo, String> {
    List<DocumentoDbo> findByClienteId(String clienteId);
}
