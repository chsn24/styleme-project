package com.styleme.projeto.service;

import com.styleme.projeto.entity.Avatar;
import com.styleme.projeto.repository.AvatarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    // CREATE
    public Avatar createAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    // READ - Buscar todos
    public List<Avatar> getAllAvatars() {
        return avatarRepository.findAll();
    }

    // READ - Buscar por ID
    public Optional<Avatar> getAvatarById(UUID id) {
        return avatarRepository.findById(id);
    }

    // UPDATE
    public Avatar updateAvatar(UUID id, Avatar avatar) {
        return avatarRepository.findById(id)
                .map(avatarExistente -> {
                    avatarExistente.setTorax(avatar.getTorax());
                    avatarExistente.setTorso(avatar.getTorso());
                    avatarExistente.setBraco(avatar.getBraco());
                    avatarExistente.setCintura(avatar.getCintura());
                    avatarExistente.setQuadril(avatar.getQuadril());
                    avatarExistente.setPerna(avatar.getPerna());
                    return avatarRepository.save(avatarExistente);
                }).orElseThrow(() -> new IllegalArgumentException("Avatar não encontrado"));
    }

    // DELETE
    public void deleteAvatar(UUID id) {
        avatarRepository.deleteById(id);
    }
}
