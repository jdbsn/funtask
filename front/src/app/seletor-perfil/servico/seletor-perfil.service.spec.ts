import { TestBed } from '@angular/core/testing';

import { SeletorPerfilService } from './seletor-perfil.service';

describe('SeletorPerfilService', () => {
  let service: SeletorPerfilService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeletorPerfilService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
