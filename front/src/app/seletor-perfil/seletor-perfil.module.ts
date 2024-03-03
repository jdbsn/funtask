import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';

import { DialogoPinComponent } from './dialogo-pin/dialogo-pin.component';
import { SeletorPerfilRoutingModule } from './seletor-perfil-routing.module';
import { SeletorPerfilComponent } from './seletor-perfil/seletor-perfil.component';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

  @NgModule({
    declarations: [
      SeletorPerfilComponent,
      DialogoPinComponent
    ],
    imports: [
      CommonModule,
      SeletorPerfilRoutingModule,
      MatCardModule,
      MatButtonToggleModule,
      MatDialogModule,
      MatButtonModule,
      MatInputModule,
      ReactiveFormsModule,
      NgxMaskDirective
    ],
    providers: [provideNgxMask()]
  })
  export class SeletorPerfilModule { }
