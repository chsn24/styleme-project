package com.styleme.projeto.repository;

import com.styleme.projeto.entity.Calca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface CalcaRepository extends JpaRepository<Calca, UUID> {
    Optional<Calca> findByTamanho(String tamanho);
}
