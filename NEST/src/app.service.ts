import { Injectable } from '@nestjs/common';
import { Nota } from './types/nota';

@Injectable()
export class AppService {
  notas: Nota[] = [];

  getNotas(): Nota[] {
    return this.notas;
  }

  getNota(): string {
    // buscar uma nota e retornar
    return 'Retornar nota';
  }

  createNota(nota: Nota): string {
    this.notas.push(nota);
    // console.log(this.notas);
    return 'Nota criada com sucesso';
  }

  updateNota(id: number, titulo: string, texto: string): string {
    // atualizar uma nota pelo id da nota
    for (let i = 0; i < this.notas.length; i++) {
      if (this.notas[i].id == id) {
        this.notas[i].titulo = titulo;
        this.notas[i].texto = texto;
        return `Nota atualizada com sucesso ${id}`;
      }
    }
    console.log(this.notas);
  }

  deleteNota(id: number): string {
    console.log(id);
    for (let i = 0; i < this.notas.length; i++) {
      if (this.notas[i].id == id) {
        this.notas.splice(i, 1);
        return `Nota deletada com sucesso ${id}`;
      }
    }
    console.log(this.notas);
    return `Nota com ID ${id} não encontrada`;
  }
}
