import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-pin',
  templateUrl: './dialogo-pin.component.html',
  styleUrl: './dialogo-pin.component.scss'
})
export class DialogoPinComponent {

  form: FormGroup;

  constructor(
    @Inject(MAT_DIALOG_DATA) public id: string,
    private formBuilder: FormBuilder) {

      this.form = this.formBuilder.group({
        pin: [null]
      });

  }

  onEnviar() {
    console.log('ID: ' + this.id + ' | PIN: ' + this.form.value.pin);
  }

}
