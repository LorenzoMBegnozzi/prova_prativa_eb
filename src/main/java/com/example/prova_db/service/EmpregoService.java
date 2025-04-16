package com.example.prova_db.service;

import com.example.prova_db.dto.EmpregoDTO;
import com.example.prova_db.entity.Emprego;
import com.example.prova_db.repository.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregoService {

    @Autowired
    private EmpregoRepository empregoRepository;

    public List<Emprego> listarTodos() {
        return empregoRepository.findAll();
    }

    public Emprego salvar(EmpregoDTO dto) {
        Emprego emprego = new Emprego(null, dto.getEndereco());
        return empregoRepository.save(emprego);
    }

    public Emprego atualizar(Long id, EmpregoDTO dto) {
        Emprego emprego = empregoRepository.findById(id).orElseThrow();
        emprego.setEndereco(dto.getEndereco());
        return empregoRepository.save(emprego);
    }

    public void deletar(Long id) {
        empregoRepository.deleteById(id);
    }
}
