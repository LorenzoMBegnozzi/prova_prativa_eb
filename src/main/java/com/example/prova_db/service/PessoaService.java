package com.example.prova_db.service;

import com.example.prova_db.dto.PessoaDTO;
import com.example.prova_db.entity.Emprego;
import com.example.prova_db.entity.Pessoa;
import com.example.prova_db.repository.EmpregoRepository;
import com.example.prova_db.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmpregoRepository empregoRepository;

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(PessoaDTO dto) {
        Emprego emprego = empregoRepository.findById(dto.getEmpregoId()).orElse(null);
        Pessoa pessoa = new Pessoa(null, dto.getNome(), dto.getIdade(), emprego);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizar(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        Emprego emprego = empregoRepository.findById(dto.getEmpregoId()).orElse(null);
        pessoa.setNome(dto.getNome());
        pessoa.setIdade(dto.getIdade());
        pessoa.setEmprego(emprego);
        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
