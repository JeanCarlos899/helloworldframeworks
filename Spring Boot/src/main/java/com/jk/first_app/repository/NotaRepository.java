package com.jk.first_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.first_app.model.Nota;

// O repository é responsável por realizar as operações de persistência no banco de dados.
// Ele é responsável por realizar as operações de CRUD (Create, Read, Update, Delete).

public interface NotaRepository extends JpaRepository<Nota, Long> {
  Nota findById(long id);
  List<Nota> findByTitulo(String titulo);
}