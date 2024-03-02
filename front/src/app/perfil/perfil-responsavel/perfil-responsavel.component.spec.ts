import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilResponsavelComponent } from './perfil-responsavel.component';

describe('PerfilResponsavelComponent', () => {
  let component: PerfilResponsavelComponent;
  let fixture: ComponentFixture<PerfilResponsavelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PerfilResponsavelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PerfilResponsavelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
