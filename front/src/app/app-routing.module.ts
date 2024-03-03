import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResponsavelGuard } from './guard/responsavel.guard';

const routes: Routes = [
  {
    path: 'selecionar-perfil',
    loadChildren: () => import('./seletor-perfil/seletor-perfil.module').then(m => m.SeletorPerfilModule)
  },
  {
    path: 'responsavel-atividades',
    loadChildren: () => import('./atividades-responsavel/atividades-responsavel.module').then(m => m.AtividadesResponsavelModule)
  },
  {
    path: 'responsavel',
    canActivate: [ResponsavelGuard],
    loadChildren: () => import('./perfil/perfil.module').then(m => m.PerfilModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
