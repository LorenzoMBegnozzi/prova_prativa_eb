package com.example.prova_db.repository;

import com.example.prova_db.entity.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregoRepository extends JpaRepository<Emprego, Long> {
}
