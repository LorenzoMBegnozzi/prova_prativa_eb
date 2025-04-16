package com.example.prova_db.controller;

import com.example.prova_db.dto.EmpregoDTO;
import com.example.prova_db.entity.Emprego;
import com.example.prova_db.service.EmpregoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empregos")
public class EmpregoController {

    @Autowired
    private EmpregoService empregoService;

    @GetMapping
    public List<Emprego> listarTodos() {
        return empregoService.listarTodos();
    }

    @PostMapping
    public Emprego criar(@RequestBody EmpregoDTO dto) {
        return empregoService.salvar(dto);
    }

    @PutMapping("/{id}")
    public Emprego atualizar(@PathVariable Long id, @RequestBody EmpregoDTO dto) {
        return empregoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empregoService.deletar(id);
    }
}
