import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutosEdicaoModalComponent } from './produtos-edicao-modal.component';

describe('ProdutosEdicaoModalComponent', () => {
  let component: ProdutosEdicaoModalComponent;
  let fixture: ComponentFixture<ProdutosEdicaoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProdutosEdicaoModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutosEdicaoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
