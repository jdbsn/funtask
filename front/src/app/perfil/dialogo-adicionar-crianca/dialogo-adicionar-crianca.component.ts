import { ResponsavelService } from './../servico/responsavel.service';
import { Component, Inject } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo-adicionar-crianca',
  templateUrl: './dialogo-adicionar-crianca.component.html',
  styleUrl: './dialogo-adicionar-crianca.component.scss'
})
export class DialogoAdicionarCriancaComponent {

  msgErro: string;
  form: FormGroup;
  nomeFotoSelecionado: string | null = null;

  constructor(@Inject(MAT_DIALOG_DATA) public data: string,
    private formBuilder: FormBuilder,
    private responsavelService: ResponsavelService,
    private dialogRef: MatDialogRef<DialogoAdicionarCriancaComponent>) {
      this.form = this.formBuilder.group({
        nome: [null],
        pin: [null],
        mesada: [null],
        foto: [null]
      });
      this.msgErro = '';
  }

  onAdicionar() {
    var mesada = this.form.value.mesada;
    var nome = this.form.value.nome;
    var pin = this.form.value.pin;
    var foto = this.form.value.pin;

    this.responsavelService.adicionarCrianca(nome, mesada, pin, foto).subscribe(
      {
        next: () => {
          this.dialogRef.close();
        },
        error: (erro) => {
          this.msgErro = erro.error;
        }
      });

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
            foto: Array.from(byteArray),
          });

          this.nomeFotoSelecionado = foto.name;
        }
      };

      reader.readAsArrayBuffer(foto);
    }
  }

}
