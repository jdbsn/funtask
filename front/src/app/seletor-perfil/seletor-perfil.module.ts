import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SeletorPerfilComponent } from './seletor-perfil/seletor-perfil.component';
import { SeletorPerfilRoutingModule } from './seletor-perfil-routing.module';

@NgModule({
  declarations: [
    SeletorPerfilComponent
  ],
  imports: [
    CommonModule,
    SeletorPerfilRoutingModule
  ]
})
export class SeletorPerfilModule { }
