package com.jk.first_app.dto;

import com.jk.first_app.model.Nota;

// DTO (Data Transfer Object) é um padrão de projeto que tem como objetivo transferir dados entre
// subsistemas de um software. Ele é utilizado para encapsular os dados que serão transferidos.

public class NotaDto {
  private Long id;
  private String titulo;
  private String texto;

  public NotaDto(Long id, String titulo, String texto) {
    this.id = id;
    this.titulo = titulo;
    this.texto = texto;
  }

  public Nota toEntity() {
    return new Nota(titulo, texto);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }
}


