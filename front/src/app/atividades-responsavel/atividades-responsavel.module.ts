import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AtividadesResponsavelRoutingModule } from './atividades-responsavel-routing.module';
import { ListaAtividadesComponent } from './lista-atividades/lista-atividades.component';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { EditarAtividadeFormComponent } from './editar-atividade-form/editar-atividade-form.component';

@NgModule({
  declarations: [


  ],
  imports: [
    CommonModule,
    AtividadesResponsavelRoutingModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    EditarAtividadeFormComponent
  ]
})
export class AtividadesResponsavelModule { }
