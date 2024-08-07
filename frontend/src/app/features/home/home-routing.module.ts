import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutosIndexComponent } from '../produtos/containers/produtos-index/produtos-index.component';
import { HomeComponent } from './home.component';

const routes: Routes = [
  {
    path: '', pathMatch: 'prefix', component: HomeComponent, children: [
      {
        path: '', pathMatch: 'full', redirectTo:'produtos'
      },
      {
        path: 'produtos', pathMatch: 'full', loadComponent: () => ProdutosIndexComponent,
      },
      {
        path: '**',
        redirectTo: ''
      }
    ]

  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
