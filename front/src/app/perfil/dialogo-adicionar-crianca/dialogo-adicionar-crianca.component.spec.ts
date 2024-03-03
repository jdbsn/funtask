import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoAdicionarCriancaComponent } from './dialogo-adicionar-crianca.component';

describe('DialogoAdicionarCriancaComponent', () => {
  let component: DialogoAdicionarCriancaComponent;
  let fixture: ComponentFixture<DialogoAdicionarCriancaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DialogoAdicionarCriancaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DialogoAdicionarCriancaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
