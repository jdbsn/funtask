import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoPinComponent } from './dialogo-pin.component';

describe('DialogoPinComponent', () => {
  let component: DialogoPinComponent;
  let fixture: ComponentFixture<DialogoPinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DialogoPinComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DialogoPinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
