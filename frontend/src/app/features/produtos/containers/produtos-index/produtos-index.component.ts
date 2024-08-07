import {Component, Inject, Injector, OnInit} from '@angular/core';
import { ProdutosTableComponent } from "../../components/produtos-table/produtos-table.component";
import {TuiButtonModule, TuiTitleModule} from "@taiga-ui/experimental";
import {ProdutosFormComponent} from "../../components/produtos-form/produtos-form.component";
import {TuiAlertService, TuiDialogModule, TuiDialogService, TuiNotification, TuiRootModule} from "@taiga-ui/core";
import {
  ProdutosCadastroModalComponent
} from "../../components/produtos-cadastro-modal/produtos-cadastro-modal.component";
import { PolymorpheusComponent } from '@tinkoff/ng-polymorpheus';
import {ProdutosService} from "../../services/produtos.service";
import {ConfirmarModalComponent} from "../../../shared/components/confirmar-modal/confirmar-modal.component";
import {ProdutosEdicaoModalComponent} from "../../components/produtos-edicao-modal/produtos-edicao-modal.component";
import {NotificationService} from "../../../shared/services/notification.service";
import {ReactiveFormsModule} from "@angular/forms";
import {TuiInputModule} from "@taiga-ui/kit";
import {ProdutoResponse} from "../../services/interfaces/produtos.interface";

@Component({
  selector: 'app-produtos-index',
  standalone: true,
  imports: [
    ProdutosTableComponent,
    TuiTitleModule,
    TuiButtonModule,
    TuiRootModule,
    TuiDialogModule,
    ReactiveFormsModule,
    TuiInputModule,
  ],
  templateUrl: './produtos-index.component.html',
  styleUrl: './produtos-index.component.scss'
})
export class ProdutosIndexComponent implements OnInit {
  public produtos: ProdutoResponse[] = [];

  constructor(
    private readonly dialogService: TuiDialogService,
    @Inject(Injector) private readonly injector: Injector,
    private readonly _service: ProdutosService,
    private readonly _notification: NotificationService
  ) {}

  ngOnInit(): void {
    this.buscar();
  }

  public criar(): void {
    this.openDialog();
  }

  public openDialog(): void {
    this.dialogService
      .open<ProdutosFormComponent>(
        new PolymorpheusComponent(ProdutosCadastroModalComponent, this.injector),
        {
          dismissible: true,
          size: 'm',
        }
      )
      .subscribe(() => {
        this.buscar()
      });
  }


  public buscar(){
    this._service.list().subscribe(response => {
      this.produtos = response;
    })
  }

  public onRemoverEmitted(id: number){
    this.openConfirmationDialog(id);
  }

  public openConfirmationDialog(id: number){
    this.dialogService.open<boolean>(new PolymorpheusComponent(ConfirmarModalComponent), {
      label: 'Confirmação',
      size: 's',
      closeable: false,
      data: { id }
    }).subscribe({
      next: (confirmed: boolean) => {
        if (confirmed) {
          this._service.delete(id).subscribe(
            () => {
              this.buscar();
              this._notification.showNotification('Item removido com sucesso!', 'success');
            },
            error => {
              this._notification.showNotification('Erro ao remover o item!', 'error');
            }
          );
        }
      }
    });
  }

  public onEditarEmitted(id: number) {
    this.dialogService
      .open<ProdutosFormComponent>(
        new PolymorpheusComponent(ProdutosEdicaoModalComponent, this.injector),
        {
          data: id,
          dismissible: true,
          size: 'm',
        }
      )
      .subscribe(() => {
        this.buscar()
      });
  }
}
