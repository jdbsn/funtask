import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';

  constructor(private router: Router) {

  }

  onLogin() {
    this.router.navigate(['selecionar-perfil'])
  }

  onCadastro() {
    this.router.navigate(['selecionar-perfil'])
  }

}
