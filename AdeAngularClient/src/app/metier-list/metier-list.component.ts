import { Component, OnInit } from '@angular/core';
import {MetierService} from '../service/metier.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Metier} from '../model/metier';

@Component({
  selector: 'app-metier-list',
  templateUrl: './metier-list.component.html',
  styleUrls: ['./metier-list.component.scss']
})
export class MetierListComponent implements OnInit {

  /*Cet objet une fois rempli, va être affiché sous forme de liste par le html du component*/
  metiers: Metier[];
  sectCode;

  constructor(private metierService : MetierService
    ,private route: ActivatedRoute, private _router: Router) {
  }

  ngOnInit() {
    this.sectCode = this.route.snapshot.queryParams['SS'];

    /*On utilise "subscribe" car les sous-secteurs sont soumis à divers changement, et on veut pouvoir notifier les objets ("sousSecteurs") qui ont besoin de savoir ce qui a changé*/
    this.metierService.findMetierOfSS(this.sectCode).subscribe(data => {
      this.metiers = data;
      console.log('On a récup ' + this.metiers.length + ' sous-secteurs');
    });
  }

  onMetierClick(code : String){
    console.log("On a cliqué sur le métier de code : "+code);
    /*On navig vers le component ayant pour rôle l'affichage des sous-secteurs + on mets le code du secteur en param*/

    this._router.navigate(["/formations"], {
      relativeTo: this.route,
      queryParams: {
        SS: this.sectCode,
        metier: code
      }
    });
  }


}
