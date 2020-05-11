import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecteurListComponent } from './secteur-list/secteur-list.component';
import {Secteur} from './model/secteur';
import {SousSecteurListComponent} from './sous-secteur-list/sous-secteur-list.component';

const routes: Routes = [
  { path: 'secteurs', component: SecteurListComponent },
  { path: 'sous-secteurs', component: SousSecteurListComponent }
];

/*On répertorie toutes nos routes ici*/

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
