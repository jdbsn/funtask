import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'selecionar-perfil',
    loadChildren: () => import('./seletor-perfil/seletor-perfil.module').then(m => m.SeletorPerfilModule)
  },
  {
    path: 'responsavel-atividades',
    loadChildren: () => import('./atividades-responsavel/atividades-responsavel.module').then(m => m.AtividadesResponsavelModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
