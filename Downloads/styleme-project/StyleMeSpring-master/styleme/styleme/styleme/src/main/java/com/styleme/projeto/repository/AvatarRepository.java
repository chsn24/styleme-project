package com.styleme.projeto.repository;

import com.styleme.projeto.entity.Avatar;
import com.styleme.projeto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AvatarRepository extends JpaRepository<Avatar, UUID> {
    Optional<Avatar> findByCliente(Cliente cliente);
}

