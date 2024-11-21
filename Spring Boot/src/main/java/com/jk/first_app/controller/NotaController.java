package com.jk.first_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jk.first_app.repository.NotaRepository;
import com.jk.first_app.dto.NotaDto;
import com.jk.first_app.model.Nota;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notas")
public class NotaController {
  @Autowired
  private NotaRepository notaRepository;

  @GetMapping
  public List<NotaDto> listar() {
    List<Nota> notas = notaRepository.findAll();
    return notas.stream().map(n -> new NotaDto(n.getId(), n.getTitulo(), n.getTexto())).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public NotaDto buscarPorId(@PathVariable Long id) {
    Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    return new NotaDto(nota.getId(), nota.getTitulo(), nota.getTexto());
  }

  @PostMapping
  public ResponseEntity<NotaDto> adicionar(@RequestBody NotaDto notaDto) {
    Nota nota = new Nota(notaDto.getTitulo(), notaDto.getTexto());
    notaRepository.save(nota);
    return ResponseEntity.status(201).body(notaDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<NotaDto> deletar(@PathVariable Long id) {
    notaRepository.deleteById(id);
    return ResponseEntity.status(204).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<NotaDto> atualizar(@PathVariable Long id, @RequestBody NotaDto notaDto) {
    Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    nota.setTitulo(notaDto.getTitulo());
    nota.setTexto(notaDto.getTexto());
    notaRepository.save(nota);
    return ResponseEntity.status(200).body(notaDto);
  }
}
