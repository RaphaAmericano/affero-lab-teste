import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioEdicaoComponent } from './formulario-edicao.component';

describe('FormularioEdicaoComponent', () => {
  let component: FormularioEdicaoComponent;
  let fixture: ComponentFixture<FormularioEdicaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioEdicaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioEdicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
