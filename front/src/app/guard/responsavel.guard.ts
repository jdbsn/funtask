import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { SeletorPerfilService } from '../seletor-perfil/servico/seletor-perfil.service';

export const ResponsavelGuard: CanActivateFn = (route, state) => {
  const router: Router = inject(Router);
  const autenticado: boolean = inject(SeletorPerfilService).estaAutenticado();

  return autenticado || router.navigate(['selecionar-perfil']);
}
