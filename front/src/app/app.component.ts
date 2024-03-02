import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';
  logado = false;
  mostrarBarra = false;

  constructor(private router: Router) {
    this.router.events.pipe(
      filter((event: any): event is NavigationEnd => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.mostrarBarra = event.url === '/';
      this.logado = event.url === '/responsavel';
    });
  }

  onLogin() {
    this.router.navigate(['selecionar-perfil']);
  }

  onCadastro() {
    this.router.navigate(['selecionar-perfil']);
  }

  onTrocarPerfil() {
    localStorage.setItem('autenticado', 'false');
    this.router.navigate(['selecionar-perfil']);
  }

  onLogout() {
    this.router.navigate(['']);
  }

}
