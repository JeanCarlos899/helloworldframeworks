import {
  Body,
  Controller,
  Delete,
  Get,
  Param,
  Post,
  Put,
} from '@nestjs/common';
import { AppService } from './app.service';
import { Nota } from './types/nota';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('notas')
  getNotas(): Nota[] {
    return this.appService.getNotas();
  }

  @Get('notas/:id')
  getNota(): string {
    return this.appService.getNota();
  }

  @Post('notas')
  createNota(@Body() nota: Nota): string {
    return this.appService.createNota(nota);
  }

  @Put('notas/:id')
  updateNota(
    @Param('id') id: number,
    @Body('titulo') titulo: string,
    @Body('texto') texto: string,
  ): string {
    return this.appService.updateNota(id, titulo, texto);
  }

  @Delete('notas/:id')
  deleteNota(@Param('id') id: number): string {
    return this.appService.deleteNota(id);
  }
}
