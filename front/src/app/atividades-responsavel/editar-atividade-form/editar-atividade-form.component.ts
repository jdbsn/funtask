import { Component, Inject } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule, MatDialogTitle, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { AtividadesService } from '../servico/atividades.service';

@Component({
  selector: 'app-editar-atividade-form',
  templateUrl: './editar-atividade-form.component.html',
  styleUrl: './editar-atividade-form.component.scss',
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
export class EditarAtividadeFormComponent {
  editarAtividadeForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dialog: MatDialogRef<EditarAtividadeFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { id: string },
    private atividadeServico: AtividadesService
    ) { }


  ngOnInit(): void {
      this.editarAtividadeForm = this.formBuilder.group({
        id: this.data.id,
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
    this.editarAtividadeForm.reset();
  }

  emEditar() {
    this.atividadeServico.editarAtividade(this.editarAtividadeForm.value).subscribe({
      next: () => {
        this.dialog.close();
        this.editarAtividadeForm.reset();
      },
      error: (erro) => {
        console.log(erro);
      }
    });
  }
}
