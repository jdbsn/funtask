import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';

import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    SharedModule,
    MatFormFieldModule
  ]
})
export class AtividadeModule { }
