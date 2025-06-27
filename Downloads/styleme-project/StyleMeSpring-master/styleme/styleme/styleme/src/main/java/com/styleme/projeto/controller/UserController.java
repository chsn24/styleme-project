package com.styleme.projeto.controller;

import com.styleme.projeto.entity.Cliente;
import com.styleme.projeto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE - Registrar novo usuário
    @PostMapping
    public ResponseEntity<Cliente> createUser(@RequestBody Cliente cliente) {
        Cliente novoCliente = userService.createUser(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    // READ - Buscar todos os usuários
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // READ - Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateUser(@PathVariable UUID id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = userService.updateUser(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // DELETE - Remover usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}