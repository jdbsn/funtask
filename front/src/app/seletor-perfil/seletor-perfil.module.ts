import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

import { SharedModule } from '../shared/shared.module';
import { DialogoPinComponent } from './dialogo-pin/dialogo-pin.component';
import { SeletorPerfilRoutingModule } from './seletor-perfil-routing.module';
import { SeletorPerfilComponent } from './seletor-perfil/seletor-perfil.component';

  @NgModule({
    declarations: [
      SeletorPerfilComponent,
      DialogoPinComponent
    ],
    imports: [
      CommonModule,
      SharedModule,
      SeletorPerfilRoutingModule,
      MatButtonToggleModule,
      ReactiveFormsModule,
      NgxMaskDirective
    ],
    providers: [provideNgxMask()]
  })
  export class SeletorPerfilModule { }
