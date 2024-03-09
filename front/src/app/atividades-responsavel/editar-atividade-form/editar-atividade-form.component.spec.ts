import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarAtividadeFormComponent } from './editar-atividade-form.component';

describe('EditarAtividadeFormComponent', () => {
  let component: EditarAtividadeFormComponent;
  let fixture: ComponentFixture<EditarAtividadeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditarAtividadeFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditarAtividadeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
