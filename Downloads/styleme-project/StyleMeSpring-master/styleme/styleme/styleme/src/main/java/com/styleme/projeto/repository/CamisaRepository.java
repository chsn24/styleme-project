package com.styleme.projeto.repository;

import com.styleme.projeto.entity.Camisa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface CamisaRepository extends JpaRepository<Camisa, UUID> {
    Optional<Camisa> findByTamanho(String tamanho);
}

