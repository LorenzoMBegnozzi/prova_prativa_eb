package com.example.prova_db.controller;

import com.example.prova_db.dto.PessoaDTO;
import com.example.prova_db.entity.Pessoa;
import com.example.prova_db.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarTodos() {
        return pessoaService.listarTodos();
    }

    @PostMapping
    public Pessoa criar(@RequestBody PessoaDTO dto) {
        return pessoaService.salvar(dto);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return pessoaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }
}
