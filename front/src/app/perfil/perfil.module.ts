import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilResponsavelComponent } from './perfil-responsavel/perfil-responsavel.component';

import { MatCardModule } from '@angular/material/card';
import { PerfilRoutingModel } from './perfil-routing.module';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    PerfilResponsavelComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    PerfilRoutingModel,
    MatButtonModule
  ]
})
export class PerfilModule { }
