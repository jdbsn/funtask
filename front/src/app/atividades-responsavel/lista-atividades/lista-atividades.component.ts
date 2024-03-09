import { Component } from '@angular/core';
import { Atividade } from '../modelo/atividade';
import { AtividadesService } from '../servico/atividades.service';
import { Observable } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { AtividadeFormComponent } from '../../atividade/atividade-form/atividade-form.component';

@Component({
  selector: 'app-lista-atividades',
  templateUrl: './lista-atividades.component.html',
  styleUrl: './lista-atividades.component.scss'
})

export class ListaAtividadesComponent {

  atividades: Observable<Atividade[]>;
  displayedColumns = ['titulo', 'valorCredito', 'valorDebito', 'frequencia', 'botoes'];

  constructor(private atividadeService: AtividadesService, private dialogo:MatDialog) {
    this.atividades = this.atividadeService.listarAtividades();
  }

  criarAtividade() {
    let _popup = this.dialogo.open(AtividadeFormComponent, {
      enterAnimationDuration:'500ms',
      exitAnimationDuration:'500ms'
    })
    _popup.afterClosed().subscribe(item=>{
      console.log(item);
    })
  }

  editarAtividade() {
    console.log("editar");
  }

  apagarAtividade() {
    console.log("apagar");
  }
}
