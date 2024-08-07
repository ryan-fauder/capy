import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Estilo, Genero, ProdutoRequest, Tamanho} from '../../services/interfaces/produtos.interface';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule, CurrencyPipe} from "@angular/common";
import {
  TuiDataListWrapperModule,
  TuiInputModule,
  TuiInputNumberModule,
  TuiSelectModule,
  TuiTextareaModule
} from "@taiga-ui/kit";
import {TuiDataListModule, TuiTextfieldControllerModule} from "@taiga-ui/core";

@Component({
  selector: 'app-produtos-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    TuiInputModule,
    TuiSelectModule,
    TuiDataListModule,
    TuiInputNumberModule,
    TuiDataListWrapperModule,
    TuiTextareaModule,
    TuiTextfieldControllerModule,
  ],
  templateUrl: './produtos-form.component.html',
  styleUrl: './produtos-form.component.scss',
  providers: [CurrencyPipe],
})
export class ProdutosFormComponent {
  @Input() title: string = "Adicionar produto";
  @Input() buttonTitle: string = "Salvar produto";

  @Input() form!: FormGroup;

  @Output() submitEmit = new EventEmitter<void>();
  @Output() cancelEmit = new EventEmitter<void>();

  estilos = Object.keys(Estilo);
  generos = Object.keys(Genero);
  tamanhos = Object.keys(Tamanho);

  submit() {
    if (this.form.valid) {
      this.submitEmit.emit();
    }
  }

  cancel() {
    this.cancelEmit.emit();
  }
}
