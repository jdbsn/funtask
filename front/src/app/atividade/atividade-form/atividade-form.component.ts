import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit} from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatDialogActions, MatDialogClose, MatDialogContent, MatDialogModule, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { AtividadeService } from '../servico/atividade.service';
import { ReactiveFormsModule, FormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'atividade-form',
  templateUrl: './atividade-form.component.html',
  styleUrl: './atividade-form.component.scss',
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  imports: [
    MatCardModule,
    MatDialogModule,
    MatDialogTitle,
    MatDialogActions,
    MatDialogClose,
    MatButtonModule,
    MatDialogContent,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule
  ],
  standalone: true
})

export class AtividadeFormComponent implements OnInit {
  atividadeForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dialog: MatDialogRef<AtividadeFormComponent>,
    private atividadeServico: AtividadeService
    ) { }


  ngOnInit(): void {
      this.atividadeForm = this.formBuilder.group({
        titulo: ['', [Validators.required, Validators.minLength(5)]],
        valorCredito: [0, [Validators.required, Validators.min(0)]],
        valorDebito: [0, [Validators.required, Validators.min(0)]],
        frequencia: ['', [Validators.required]],
        descricao: [''],
        idResponsavel: "8fa13d0e-6905-455e-9001-a27ca60790f6"
      })
  }

  emCancelar(): void {
    this.dialog.close();
    this.atividadeForm.reset();
  }

  emSalvar() {
    this.atividadeServico.postAtividade(this.atividadeForm.value).subscribe({
      next: () => {
        this.dialog.close();
        this.atividadeForm.reset();
      },
      error: (erro) => {
        console.log(erro);
      }
    });
  }
}
