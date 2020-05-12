import { Component, OnInit } from '@angular/core';
import {Secteur} from '../model/secteur';
import {SecteurService} from '../service/secteur-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SousSecteur} from '../model/sous-secteur';
import {SousSecteurService} from '../service/sous-secteur.service';
import {MetierService} from '../service/metier.service';

@Component({
  selector: 'app-sous-secteur-list',
  templateUrl: './sous-secteur-list.component.html',
  styleUrls: ['./sous-secteur-list.component.scss']
})
export class SousSecteurListComponent implements OnInit {

  /*Cet objet une fois rempli, va être affiché sous forme de liste par le html du component*/
  sousSecteurs: SousSecteur[];

  constructor(private sousSecteurService: SousSecteurService
    ,private route: ActivatedRoute, private _router: Router) {
  }

  ngOnInit() {
    const sectCode = this.route.snapshot.queryParams['SECT'];

    /*On utilise "subscribe" car les sous-secteurs sont soumis à divers changement, et on veut pouvoir notifier les objets ("sousSecteurs") qui ont besoin de savoir ce qui a changé*/
    this.sousSecteurService.findSSOfSecteur(sectCode).subscribe(data => {
      this.sousSecteurs = data;
      console.log('On a récup ' + this.sousSecteurs.length + ' sous-secteurs');
    });
  }


  onSousSecteurClick(code : String){
    console.log("On a cliqué sur le sous-secteur de code : "+code);
    /*On navig vers le component ayant pour rôle l'affichage des sous-secteurs + on mets le code du secteur en param*/
    this._router.navigate(["/metiers"], {
      relativeTo: this.route,
      queryParams: {
        SS: code
      }
    });
  }

}
