package com.styleme.projeto.repository;

import com.styleme.projeto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByEmail(String email);
    void deleteByEmail(String email);
}
