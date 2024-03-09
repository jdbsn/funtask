import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs';
import { DomSanitizer, Title } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';
  logado = false;
  mostrarBarra = false;

  constructor(
    private router: Router,
    private titleService: Title,
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer) {

    this.router.events.pipe(
      filter((event: any): event is NavigationEnd => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.mostrarBarra = event.url === '/';
      this.logado = event.url === '/perfil/responsavel';
    });

    this.titleService.setTitle('FunTask');

    this.matIconRegistry.addSvgIcon(
      "perfil",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../assets/user_icon.svg")
    );
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
