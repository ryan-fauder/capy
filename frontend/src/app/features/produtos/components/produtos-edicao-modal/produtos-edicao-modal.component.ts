import {Component, Inject, OnInit} from '@angular/core';
import {POLYMORPHEUS_CONTEXT} from "@tinkoff/ng-polymorpheus";
import {TuiDialogContext} from "@taiga-ui/core";
import {ProdutosFormComponent} from "../produtos-form/produtos-form.component";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProdutosService} from "../../services/produtos.service";
import {ProdutoFormGroup} from "../../services/interfaces/produtos.interface";
import {NotificationService} from "../../../shared/services/notification.service";

@Component({
  selector: 'app-produtos-edicao-modal',
  standalone: true,
  imports: [
    ProdutosFormComponent
  ],
  templateUrl: './produtos-edicao-modal.component.html',
  styleUrl: './produtos-edicao-modal.component.scss'
})
export class ProdutosEdicaoModalComponent implements OnInit {
  public form = new FormGroup<any>({
    codigo:  new FormControl('', Validators.required),
    nome: new FormControl('', Validators.required),
    marca: new FormControl('', Validators.required),
    material: new FormControl('', Validators.required),
    descricao: new FormControl('', Validators.required),
    estilo: new FormControl('', Validators.required),
    genero: new FormControl('', Validators.required),
    tamanho: new FormControl('', Validators.required),
    cor: new FormControl('', Validators.required),
    valorVendaPorPeca: new FormControl(0, Validators.required),
    valorCustoPorPeca: new FormControl(0, Validators.required),
  });


  public get id(): number {
    return this.context.data;
  }

  constructor(
    @Inject(POLYMORPHEUS_CONTEXT) private readonly context: TuiDialogContext<void, number>,
    private readonly _service: ProdutosService,
    private readonly _notification: NotificationService
  ) {}

  public ngOnInit(): void {
    this._service.get(this.id).subscribe(
      response => {
        this.form.patchValue(response);
      },
      error => {
        this._notification.showNotification(`Error: ${error}`, 'error');
        this.closeDialog();
      }
    );
  }

  public atualizarProduto() {
    this._service.update(this.id, this.form.value)
      .subscribe(
      response => {
        this._notification.showNotification(`Produto ${response.nome} atualizado com sucesso!`, 'success');
        this.closeDialog();
      },
      error => {
        this._notification.showNotification(`Error: ${error}`, 'error');
        this.closeDialog();
      }
    );
  }

  public closeDialog() {
    this.context.completeWith();
  }
}
