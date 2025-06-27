package com.styleme.projeto.controller;

import com.styleme.projeto.entity.Avatar;
import com.styleme.projeto.service.AvatarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avatars")
public class AvatarController {

    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    // CREATE - Registrar um avatar
    @PostMapping
    public ResponseEntity<Avatar> createAvatar(@RequestBody Avatar avatar) {
        return ResponseEntity.ok(avatarService.createAvatar(avatar));
    }

    // READ - Buscar todos os avatares
    @GetMapping
    public ResponseEntity<List<Avatar>> getAllAvatars() {
        return ResponseEntity.ok(avatarService.getAllAvatars());
    }

    // READ - Buscar avatar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Avatar> getAvatarById(@PathVariable UUID id) {
        return avatarService.getAvatarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Atualizar avatar
    @PutMapping("/{id}")
    public ResponseEntity<Avatar> updateAvatar(@PathVariable UUID id, @RequestBody Avatar avatar) {
        return ResponseEntity.ok(avatarService.updateAvatar(id, avatar));
    }

    // DELETE - Remover avatar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvatar(@PathVariable UUID id) {
        avatarService.deleteAvatar(id);
        return ResponseEntity.noContent().build();
    }
}