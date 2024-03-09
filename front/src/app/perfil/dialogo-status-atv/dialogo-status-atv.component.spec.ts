import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoStatusAtvComponent } from './dialogo-status-atv.component';

describe('DialogoStatusAtvComponent', () => {
  let component: DialogoStatusAtvComponent;
  let fixture: ComponentFixture<DialogoStatusAtvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DialogoStatusAtvComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DialogoStatusAtvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
