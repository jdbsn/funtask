import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

import { ListaAtividadesComponent } from '../atividades-responsavel/lista-atividades/lista-atividades.component';
import { SharedModule } from '../shared/shared.module';
import { DialogoAdicionarCriancaComponent } from './dialogo-adicionar-crianca/dialogo-adicionar-crianca.component';
import { DialogoStatusAtvComponent } from './dialogo-status-atv/dialogo-status-atv.component';
import { PerfilCriancaComponent } from './perfil-crianca/perfil-crianca.component';
import { PerfilResponsavelComponent } from './perfil-responsavel/perfil-responsavel.component';
import { PerfilRoutingModel } from './perfil-routing.module';

@NgModule({
  declarations: [
    PerfilResponsavelComponent,
    DialogoAdicionarCriancaComponent,
    ListaAtividadesComponent,
    DialogoStatusAtvComponent,
    PerfilCriancaComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    PerfilRoutingModel,
    ReactiveFormsModule,
    MatGridListModule,
    NgxMaskDirective,
    MatTableModule,
    MatToolbarModule,
    MatIconModule,
    MatSelectModule,
    MatRadioModule,
    MatMenuModule
  ],
  providers: [provideNgxMask()]
})
export class PerfilModule { }
