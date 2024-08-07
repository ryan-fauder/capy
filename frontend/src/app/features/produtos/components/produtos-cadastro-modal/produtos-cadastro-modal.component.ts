import {Component, Inject} from '@angular/core';
import {ProdutosFormComponent} from "../produtos-form/produtos-form.component";
import {POLYMORPHEUS_CONTEXT} from "@tinkoff/ng-polymorpheus";
import {TuiDialogContext} from "@taiga-ui/core";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {ProdutosService} from "../../services/produtos.service";
import {NotificationService} from "../../../shared/services/notification.service";

@Component({
  selector: 'app-produtos-cadastro-modal',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    ProdutosFormComponent
  ],
  templateUrl: './produtos-cadastro-modal.component.html',
  styleUrl: './produtos-cadastro-modal.component.scss'
})
export class ProdutosCadastroModalComponent {
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

  constructor(
    @Inject(POLYMORPHEUS_CONTEXT) private readonly context: TuiDialogContext<void>,
    private readonly _service: ProdutosService,
    private readonly _notification: NotificationService
  ) {}

  public closeDialog() {
    this.context.completeWith();
  }

  public salvarProduto() {
      this._service.create(this.form.value).subscribe(
        response => {
          this._notification.showNotification(`Produto ${response.nome} criado com sucesso!`, 'success');
          this.closeDialog();
        },
        error => {
          this._notification.showNotification(`Error: ${error}`, 'error');
          this.closeDialog();
        }
      );
  }
}
