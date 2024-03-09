import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilCriancaComponent } from './perfil-crianca.component';

describe('PerfilCriancaComponent', () => {
  let component: PerfilCriancaComponent;
  let fixture: ComponentFixture<PerfilCriancaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PerfilCriancaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PerfilCriancaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
