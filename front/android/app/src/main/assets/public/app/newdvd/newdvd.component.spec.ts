import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewdvdComponent } from './newdvd.component';

describe('NewdvdComponent', () => {
  let component: NewdvdComponent;
  let fixture: ComponentFixture<NewdvdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewdvdComponent]
    });
    fixture = TestBed.createComponent(NewdvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
