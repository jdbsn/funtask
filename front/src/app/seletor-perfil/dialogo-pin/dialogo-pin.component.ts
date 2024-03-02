import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SeletorPerfilService } from '../servico/seletor-perfil.service';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-pin',
  templateUrl: './dialogo-pin.component.html',
  styleUrl: './dialogo-pin.component.scss'
})
export class DialogoPinComponent {

  form: FormGroup;
  msgErro: string;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: {
      id: string,
      responsavel: boolean
    },
    private formBuilder: FormBuilder,
    private seletorPerfilService: SeletorPerfilService,
    private router: Router,
    private dialogRef: MatDialogRef<DialogoPinComponent>) {

      this.form = this.formBuilder.group({
        pin: [null]
      });
      this.msgErro = '';
  }

  onEnviar() {
    this.seletorPerfilService
      .autenticarPin(this.data.id, this.form.value.pin, this.data.responsavel)
      .subscribe(
        {
          next: () => {
            this.dialogRef.close();

            if(this.data.responsavel) {
              this.router.navigate(['responsavel'])
            } else {
              this.router.navigate([''])
            }

          },
          error: (erro) => {
            this.msgErro = erro.error;
          }
        }
      );
  }

}
