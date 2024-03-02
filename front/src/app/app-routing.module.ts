import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'selecionar-perfil',
    loadChildren: () => import('./seletor-perfil/seletor-perfil.module').then(m => m.SeletorPerfilModule)
  },
  {
    path: 'responsavel',
    loadChildren: () => import('./perfil/perfil.module').then(m => m.PerfilModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
