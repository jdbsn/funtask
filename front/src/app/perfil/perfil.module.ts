import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

import { DialogoAdicionarCriancaComponent } from './dialogo-adicionar-crianca/dialogo-adicionar-crianca.component';
import { PerfilResponsavelComponent } from './perfil-responsavel/perfil-responsavel.component';
import { PerfilRoutingModel } from './perfil-routing.module';
import { ListaAtividadesComponent } from '../atividades-responsavel/lista-atividades/lista-atividades.component';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { DialogoStatusAtvComponent } from './dialogo-status-atv/dialogo-status-atv.component';

@NgModule({
  declarations: [
    PerfilResponsavelComponent,
    DialogoAdicionarCriancaComponent,
    ListaAtividadesComponent,
    DialogoStatusAtvComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    PerfilRoutingModel,
    MatButtonModule,
    MatInputModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatGridListModule,
    NgxMaskDirective,
    MatTableModule,
    MatToolbarModule,
    MatIconModule
  ],
  providers: [provideNgxMask()]
})
export class PerfilModule { }
