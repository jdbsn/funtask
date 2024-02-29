import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SeletorPerfilComponent } from './seletor-perfil/seletor-perfil.component';
import { SeletorPerfilRoutingModule } from './seletor-perfil-routing.module';

import { MatCardModule } from '@angular/material/card';
import { MatButtonToggleModule } from '@angular/material/button-toggle';

@NgModule({
  declarations: [
    SeletorPerfilComponent
  ],
  imports: [
    CommonModule,
    SeletorPerfilRoutingModule,
    MatCardModule,
    MatButtonToggleModule
  ]
})
export class SeletorPerfilModule { }
