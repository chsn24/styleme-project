package com.styleme.projeto.controller;

import com.styleme.projeto.entity.Camisa;
import com.styleme.projeto.entity.Calca;
import com.styleme.projeto.entity.Roupa;
import com.styleme.projeto.service.RoupaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roupas")
public class RoupaController {

    private final RoupaService roupaService;

    public RoupaController(RoupaService roupaService) {
        this.roupaService = roupaService;
    }

    @PostMapping("/camisa")
    public ResponseEntity<Camisa> cadastrarCamisa(@RequestBody Camisa camisa) {
        return ResponseEntity.ok(roupaService.cadastrarCamisa(camisa));
    }

    @PostMapping("/calca")
    public ResponseEntity<Calca> cadastrarCalca(@RequestBody Calca calca) {
        return ResponseEntity.ok(roupaService.cadastrarCalca(calca));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Roupa> cadastrarRoupa(@RequestBody Roupa roupa) {
        return ResponseEntity.ok(roupaService.cadastrarRoupa(roupa));
    }
}