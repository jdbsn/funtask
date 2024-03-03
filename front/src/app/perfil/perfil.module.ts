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

@NgModule({
  declarations: [
    PerfilResponsavelComponent,
    DialogoAdicionarCriancaComponent
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
    NgxMaskDirective
  ],
  providers: [provideNgxMask()]
})
export class PerfilModule { }
