import { Component, Inject } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-adicionar-crianca',
  templateUrl: './dialogo-adicionar-crianca.component.html',
  styleUrl: './dialogo-adicionar-crianca.component.scss'
})
export class DialogoAdicionarCriancaComponent {

  msgErro: string;
  form: FormGroup;
  nomeFotoSelecionado: string | null = null;

  constructor(@Inject(MAT_DIALOG_DATA) public data: string, private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      pin: [null]
    });
    this.msgErro = '';
  }

  onArquivoFoto(event: any) {
    const foto = event.target.files[0];

    if (foto) {
      const reader = new FileReader();

      reader.onload = (e) => {
        if (e.target) {
          const fileContentArrayBuffer = e.target.result as ArrayBuffer;

          const byteArray = new Uint8Array(fileContentArrayBuffer);

          this.form.patchValue({
            arquivo: Array.from(byteArray),
          });

          this.nomeFotoSelecionado = foto.name;
        }
      };

      reader.readAsArrayBuffer(foto);
    }
  }

}
