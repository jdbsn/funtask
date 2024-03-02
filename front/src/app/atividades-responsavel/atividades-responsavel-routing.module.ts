import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaAtividadesComponent } from './lista-atividades/lista-atividades.component';

const routes: Routes = [
  {path: '', component: ListaAtividadesComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AtividadesResponsavelRoutingModule { }
