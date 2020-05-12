import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecteurListComponent } from './secteur-list/secteur-list.component';
import {SousSecteurListComponent} from './sous-secteur-list/sous-secteur-list.component';
import {MetierListComponent} from './metier-list/metier-list.component';
import {FormationListComponent} from './formation-list/formation-list.component';

const routes: Routes = [
  { path: 'secteurs', component: SecteurListComponent },
  { path: 'sous-secteurs', component: SousSecteurListComponent },
  { path: 'metiers', component: MetierListComponent },
  { path: 'formations', component: FormationListComponent }
];

/*On répertorie toutes nos routes ici*/

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
