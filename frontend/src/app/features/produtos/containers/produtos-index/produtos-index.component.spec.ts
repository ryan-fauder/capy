import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutosIndexComponent } from './produtos-index.component';

describe('ProdutosIndexComponent', () => {
  let component: ProdutosIndexComponent;
  let fixture: ComponentFixture<ProdutosIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProdutosIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutosIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
