import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '', 
        pathMatch: 'prefix',
        loadChildren: () => import('./features/home/home-routing.module').then(feature => feature.HomeRoutingModule)
    },
];
