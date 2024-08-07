import {CommonModule} from '@angular/common';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {TuiTableModule} from '@taiga-ui/addon-table';
import {TuiLinkModule, TuiScrollbarModule} from '@taiga-ui/core';
import {
  TuiBadgeModule,
  TuiDataListWrapperModule,
  TuiItemsWithMoreModule,
  TuiRadioListModule,
  TuiRadioModule
} from '@taiga-ui/kit';
import {
  TuiAutoColorModule,
  TuiAvatarModule,
  TuiButtonModule,
  TuiCellModule,
  TuiIconModule,
  TuiInitialsModule,
  TuiStatusModule
} from "@taiga-ui/experimental";
import {FormsModule} from "@angular/forms";
import {CdkFixedSizeVirtualScroll, CdkVirtualScrollViewport} from "@angular/cdk/scrolling";
import {Estilo, ProdutoResponse, Tamanho} from "../../services/interfaces/produtos.interface";
import {mockProdutos} from "../../services/tests/produtos.mock";
import {IntersectionObserverModule} from "@ng-web-apis/intersection-observer";
import {ProdutosService} from "../../services/produtos.service";

@Component({
  selector: 'app-produtos-table',
  standalone: true,
  imports: [
    CommonModule,
    TuiItemsWithMoreModule,
    TuiBadgeModule,
    TuiRadioModule,
    TuiLinkModule,
    TuiTableModule,
    TuiCellModule,
    FormsModule,
    TuiIconModule,
    TuiAvatarModule,
    TuiInitialsModule,
    TuiAutoColorModule,
    TuiRadioListModule,
    TuiStatusModule,
    TuiButtonModule,
    TuiDataListWrapperModule,
    TuiScrollbarModule,
    CdkVirtualScrollViewport,
    CdkFixedSizeVirtualScroll,
    IntersectionObserverModule
  ],
  templateUrl: './produtos-table.component.html',
  styleUrl: './produtos-table.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProdutosTableComponent {
  public readonly columnsTitle: any[] = [
    'Código',
    'Nome',
    'Marca',
    'Material',
    'Estilo',
    'Gênero',
    'Tamanho',
    'Cor',
    'Valor Custo',
    'Valor Venda',
    'Descrição',
    'Ações'
  ];
  @Input() public data: ProdutoResponse[] = mockProdutos;

  @Output() editarEmit = new EventEmitter<number>();
  @Output() removerEmit = new EventEmitter<number>();

  public editar(id: number) {
    this.editarEmit.emit(id);
  }

  public remover(id: number) {
    this.removerEmit.emit(id);
  }
}
