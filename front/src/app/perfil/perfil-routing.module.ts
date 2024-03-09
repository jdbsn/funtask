import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PerfilResponsavelComponent } from './perfil-responsavel/perfil-responsavel.component';
import { PerfilCriancaComponent } from './perfil-crianca/perfil-crianca.component';
import { ResponsavelGuard } from '../guard/responsavel.guard';

const routes: Routes = [
  {
    path: 'responsavel',
    canActivate: [ResponsavelGuard],
    component: PerfilResponsavelComponent },
  {
    path: 'crianca',
    component: PerfilCriancaComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PerfilRoutingModel { }
