import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SecteurListComponent } from './secteur-list/secteur-list.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {SecteurService} from './service/secteur-service.service';
import {SousSecteurService} from './service/sous-secteur.service';
import { SousSecteurListComponent } from './sous-secteur-list/sous-secteur-list.component';
import { MetierListComponent } from './metier-list/metier-list.component';
import { FormationListComponent } from './formation-list/formation-list.component';

/*On déclare tous les "components", tous les modules et services utilisés par ces "components"*/

@NgModule({
  declarations: [
    AppComponent,
    SecteurListComponent,
    SousSecteurListComponent,
    MetierListComponent,
    FormationListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SecteurService, SousSecteurService],
  bootstrap: [AppComponent]
})
export class AppModule { }
