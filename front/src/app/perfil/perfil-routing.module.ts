import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PerfilResponsavelComponent } from './perfil-responsavel/perfil-responsavel.component';

const routes: Routes = [
  {path: '', component: PerfilResponsavelComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PerfilRoutingModel { }
