import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AtividadesResponsavelRoutingModule } from './atividades-responsavel-routing.module';
import { ListaAtividadesComponent } from './lista-atividades/lista-atividades.component';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';


@NgModule({
  declarations: [
    ListaAtividadesComponent
  ],
  imports: [
    CommonModule,
    AtividadesResponsavelRoutingModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule
  ]
})
export class AtividadesResponsavelModule { }
