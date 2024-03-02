import { Component } from '@angular/core';
import { Atividade } from '../modelo/atividade';
import { AtividadesService } from '../servico/atividades.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-atividades',
  templateUrl: './lista-atividades.component.html',
  styleUrl: './lista-atividades.component.scss'
})
export class ListaAtividadesComponent {

  atividades: Observable<Atividade[]>;
  displayedColumns = ['descricao', 'valorCredito', 'valorDebito', 'frequencia', 'crianca'];

  constructor(private atividadeService: AtividadesService) {
    this.atividades = this.atividadeService.listarAtividades();
  }

}
