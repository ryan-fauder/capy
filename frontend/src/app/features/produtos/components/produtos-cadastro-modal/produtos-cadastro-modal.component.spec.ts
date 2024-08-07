import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutosCadastroModalComponent } from './produtos-cadastro-modal.component';

describe('ProdutosCadastroModalComponent', () => {
  let component: ProdutosCadastroModalComponent;
  let fixture: ComponentFixture<ProdutosCadastroModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProdutosCadastroModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutosCadastroModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
