import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { ConfirmarModalComponent } from './components/confirmar-modal/confirmar-modal.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    NavbarComponent,
    SidebarComponent,
    ConfirmarModalComponent
  ],
  exports: [
    NavbarComponent,
    SidebarComponent,
    ConfirmarModalComponent
  ]
})
export class SharedModule { }
