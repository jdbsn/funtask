import { inject } from '@angular/core';
import { CanActivateFn, NavigationEnd, Router } from '@angular/router';
import { SeletorPerfilService } from '../seletor-perfil/servico/seletor-perfil.service';
import { filter } from 'rxjs';

export const ResponsavelGuard: CanActivateFn = (route, state) => {
  const autenticado: boolean = inject(SeletorPerfilService).estaAutenticadoResponsavel();
  const router: Router = inject(Router);

  router.events.pipe(
    filter((event): event is NavigationEnd => event instanceof NavigationEnd)
  ).subscribe((event: NavigationEnd) => {
    if (event.url !== '/perfil/responsavel') {
      localStorage.clear();
    }
  });

  if (autenticado) {
    return true;
  } else {
    router.navigate(['selecionar-perfil']);
    return false;
  }
};
