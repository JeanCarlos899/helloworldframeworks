package com.jk.first_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.first_app.repository.NotaRepository;
import com.jk.first_app.dto.NotaDto;
import com.jk.first_app.model.Nota;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {

  @Autowired
  private NotaRepository notaRepository;

  public List<NotaDto> listarNotas() {
    List<Nota> notas = notaRepository.findAll();
    return notas.stream().map(n -> new NotaDto(n.getId(), n.getTitulo(), n.getTexto())).collect(Collectors.toList());
  }

  public NotaDto buscarNotaPorId(Long id) {
    Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    return new NotaDto(nota.getId(), nota.getTitulo(), nota.getTexto());
  }

  public NotaDto adicionarNota(NotaDto notaDto) {
    Nota nota = new Nota(notaDto.getTitulo(), notaDto.getTexto());
    Nota notaSalva = notaRepository.save(nota);
    return new NotaDto(notaSalva.getId(), notaSalva.getTitulo(), notaSalva.getTexto());
  }

  public void deletarNota(Long id) {
    if (!notaRepository.existsById(id)) {
      throw new RuntimeException("Nota não encontrada");
    }
    notaRepository.deleteById(id);
  }

  public NotaDto atualizarNota(Long id, NotaDto notaDto) {
    Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    nota.setTitulo(notaDto.getTitulo());
    nota.setTexto(notaDto.getTexto());
    Nota notaAtualizada = notaRepository.save(nota);
    return new NotaDto(notaAtualizada.getId(), notaAtualizada.getTitulo(), notaAtualizada.getTexto());
  }
}
