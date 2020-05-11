import {Component, OnInit} from '@angular/core';
import {Secteur} from '../model/secteur';
import {SecteurService} from '../service/secteur-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './secteur-list.component.html',
  styleUrls: ['./secteur-list.component.scss']
})
export class SecteurListComponent implements OnInit {

  /*Cet objet une fois rempli, va être affiché sous forme de liste par le html du component*/
  secteurs: Secteur[];

  constructor(private secteurService: SecteurService
    ,private route: ActivatedRoute, private _router: Router) {
  }

  ngOnInit() {
    const sectCode = this.route.snapshot.queryParams['SECT'];
    /*On capte bien le param "?SECT=" !!*/
    console.log("Un param secteur recup ??" + sectCode)

    /*On utilise "subscribe" car les secteurs sont soumis à divers changement, et on veut pouvoir notifier les objets ("secteurs") qui ont besoin de savoir ce qui a changé*/
    this.secteurService.findAll().subscribe(data => {
      this.secteurs = data;
      console.log('On a récup ' + this.secteurs.length + ' secteurs');
    });
  }

  onSecteurClick(code : String){
    console.log("On a cliqué sur le secteur de code : "+code);
    /*On navig vers le component ayant pour rôle l'affichage des sous-secteurs + on mets le code du secteur en param*/
    this._router.navigate(["/sous-secteurs"], {
      relativeTo: this.route,
      queryParams: {
        SECT: code
      }
    });
  }
}
