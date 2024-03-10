import { Component } from '@angular/core';
import { Atividade } from '../modelo/atividade';
import { AtividadesService } from '../servico/atividades.service';
import { Observable } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { AtividadeFormComponent } from '../../atividade/atividade-form/atividade-form.component';
import { DialogoStatusAtvComponent } from '../../perfil/dialogo-status-atv/dialogo-status-atv.component';
import { EditarAtividadeFormComponent } from '../editar-atividade-form/editar-atividade-form.component';

@Component({
  selector: 'app-lista-atividades',
  templateUrl: './lista-atividades.component.html',
  styleUrl: './lista-atividades.component.scss'
})

export class ListaAtividadesComponent {

  atividades: Observable<Atividade[]>;
  displayedColumns = ['status', 'titulo', 'valorCredito', 'valorDebito', 'frequencia', 'botoes'];

  constructor(private atividadeService: AtividadesService, private dialogo: MatDialog) {
    this.atividades = this.atividadeService.listarAtividades();
  }

  criarAtividade() {
    this.dialogo.open(AtividadeFormComponent, {
      enterAnimationDuration:'500ms',
      exitAnimationDuration:'500ms'
    });
  }

  onStatus(idAtividade: String, tituloAtividade: String, ) {
    this.dialogo.open(DialogoStatusAtvComponent, {
      data: {
        id: idAtividade,
        titulo: tituloAtividade
      },
      enterAnimationDuration:'500ms',
      exitAnimationDuration:'500ms'
    });
  }

  onEditarAtividade(id: string) {
    this.dialogo.open(EditarAtividadeFormComponent, {
      data: { id: id },
      enterAnimationDuration:'500ms',
      exitAnimationDuration:'500ms'
    });
  }

  onApagarAtividade(id: string) {
    this.atividadeService.apagarAtividade(id).subscribe(
      () => console.log('Atividade excluída com sucesso'),
      error => console.error('Erro ao excluir atividade', error)
    );
  }

}
