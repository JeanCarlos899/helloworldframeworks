package com.jk.first_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.first_app.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
  Nota findById(long id);
  List<Nota> findByTitulo(String titulo);
}