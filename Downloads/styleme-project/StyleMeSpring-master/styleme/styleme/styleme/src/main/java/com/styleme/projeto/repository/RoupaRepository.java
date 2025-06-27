package com.styleme.projeto.repository;

import com.styleme.projeto.entity.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RoupaRepository extends JpaRepository<Roupa, UUID> {
}
