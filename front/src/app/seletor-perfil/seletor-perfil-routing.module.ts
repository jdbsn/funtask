import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeletorPerfilComponent } from './seletor-perfil/seletor-perfil.component';

const routes: Routes = [
  {path: '', component: SeletorPerfilComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class SeletorPerfilRoutingModule { }
