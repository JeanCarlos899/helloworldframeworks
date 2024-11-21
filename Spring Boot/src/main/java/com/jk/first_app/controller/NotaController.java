package com.jk.first_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jk.first_app.service.NotaService;
import com.jk.first_app.dto.NotaDto;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

  @Autowired
  private NotaService notaService;

  @GetMapping
  public List<NotaDto> listar() {
    return notaService.listarNotas();
  }

  @GetMapping("/{id}")
  public NotaDto buscarPorId(@PathVariable Long id) {
    return notaService.buscarNotaPorId(id);
  }

  @PostMapping
  public ResponseEntity<NotaDto> adicionar(@RequestBody NotaDto notaDto) {
    NotaDto notaCriada = notaService.adicionarNota(notaDto);
    return ResponseEntity.status(201).body(notaCriada);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    notaService.deletarNota(id);
    return ResponseEntity.status(204).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<NotaDto> atualizar(@PathVariable Long id, @RequestBody NotaDto notaDto) {
    NotaDto notaAtualizada = notaService.atualizarNota(id, notaDto);
    return ResponseEntity.status(200).body(notaAtualizada);
  }
}
