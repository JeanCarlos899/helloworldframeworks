package com.jk.first_app.dto;

public class NotaDto {
  private Long id;
  private String titulo;
  private String texto;

  public NotaDto(Long id, String titulo, String texto) {
    this.id = id;
    this.titulo = titulo;
    this.texto = texto;
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


