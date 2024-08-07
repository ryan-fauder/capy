import { Component, Input, OnInit } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { Router, RouterModule} from '@angular/router';
import { CommonModule } from '@angular/common';
import { TuiLinkModule } from '@taiga-ui/core';
import {TuiIconModule} from "@taiga-ui/experimental";

export interface SideBarItem {
  id: string,
  label: string,
  icon: string,
  route: string,
  disable: boolean,
}

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    NavbarComponent,
    TuiLinkModule,
    TuiIconModule,
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent implements OnInit {
  @Input() itemSelected!: SideBarItem;
  @Input() items: SideBarItem[] = [];

  private _selectedItemStyle = "bg-orange-600 bg-opacity-30 text-orange-800";
  private _itemStyle = "";

  public currentUrl: string = '';
  constructor(private _router: Router) {}

  public ngOnInit(): void {
   this.currentUrl = this._router.url;
  }

  public classByRoute(item: SideBarItem){
    return item.route === this.currentUrl ? this._selectedItemStyle : this._itemStyle;
  }
}
