import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';

import { SharedModule } from '../shared/shared.module';
import { AtividadesResponsavelRoutingModule } from './atividades-responsavel-routing.module';
import { EditarAtividadeFormComponent } from './editar-atividade-form/editar-atividade-form.component';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    SharedModule,
    AtividadesResponsavelRoutingModule,
    MatTableModule,
    MatToolbarModule,
    MatIconModule,
    EditarAtividadeFormComponent
  ]
})
export class AtividadesResponsavelModule { }
