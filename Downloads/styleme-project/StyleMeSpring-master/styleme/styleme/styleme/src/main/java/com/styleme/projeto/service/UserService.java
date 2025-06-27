package com.styleme.projeto.service;

import com.styleme.projeto.entity.Cliente;
import com.styleme.projeto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public Cliente createUser(Cliente cliente) {
        return userRepository.save(cliente);
    }

    // READ - Buscar todos
    public List<Cliente> getAllUsers() {
        return userRepository.findAll();
    }

    // READ - Buscar por ID
    public Optional<Cliente> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    // UPDATE
    public Cliente updateUser(UUID id, Cliente cliente) {
        return userRepository.findById(id)
                .map(userExistente -> {
                    userExistente.setNome(cliente.getNome());
                    userExistente.setEmail(cliente.getEmail());
                    userExistente.setCpf(cliente.getCpf());
                    userExistente.setSenha(cliente.getSenha());
                    return userRepository.save(userExistente);
                }).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    // DELETE
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
