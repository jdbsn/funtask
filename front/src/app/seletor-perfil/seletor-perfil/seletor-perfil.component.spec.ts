import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeletorPerfilComponent } from './seletor-perfil.component';

describe('SeletorPerfilComponent', () => {
  let component: SeletorPerfilComponent;
  let fixture: ComponentFixture<SeletorPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SeletorPerfilComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SeletorPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
