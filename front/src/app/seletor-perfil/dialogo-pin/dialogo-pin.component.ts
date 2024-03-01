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

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: string,
    private formBuilder: FormBuilder,
    private seletorPerfilService: SeletorPerfilService,
    private router: Router,
    private dialogRef: MatDialogRef<DialogoPinComponent>) {

      this.form = this.formBuilder.group({
        pin: [null]
      });

  }

  onEnviar() {
    this.seletorPerfilService
            .autenticarPin(this.data, this.form.value.pin)
            .subscribe(_r => {
              this.dialogRef.close();
              this.router.navigate([''])
            });
  }

}
