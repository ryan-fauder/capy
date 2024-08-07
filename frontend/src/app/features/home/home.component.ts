import {Component, Input, OnInit} from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import {Router, RouterModule} from '@angular/router';
import {SideBarItem} from "../shared/components/sidebar/sidebar.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    SharedModule,
    RouterModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  @Input() items: SideBarItem[] = [
    {
      id: 'vendas',
      label: 'Vendas',
      icon: 'tuiIconTag',
      route: '/vendas',
      disable: true,
    },
    {
      id: 'produtos',
      label: 'Produtos',
      icon: 'tuiIconShoppingBag',
      route: '/produtos',
      disable: false,
    },
    {
      id: 'estoque',
      label: 'Estoque',
      icon: 'tuiIconArchive',
      route: '/estoque',
      disable: true,
    },
    {
      id: 'cupom',
      label: 'Cupons',
      icon: 'tuiIconDollarSign',
      route: '/cupons',
      disable: true,
    },
  ];

  public get title() {
    return this.itemSelected.label;
  }

  public currentUrl: string = '';
  public itemSelected: SideBarItem = this.items[1];
  constructor(private _router: Router) {}

  public ngOnInit(): void {
    this.currentUrl = this._router.url;
    this.itemSelected = this.items.find(item => item.route === this.currentUrl) || this.items[1];
  }

}
