import { Component, OnInit } from '@angular/core';
import {Metier} from '../model/metier';
import {MetierService} from '../service/metier.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Formation} from '../model/formation';
import {FormationService} from '../service/formation.service';

@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.scss']
})
export class FormationListComponent implements OnInit {

  /*Cet objet une fois rempli, va être affiché sous forme de liste par le html du component*/
  formations: Formation[];

  constructor(private formationService : FormationService
    ,private route: ActivatedRoute, private _router : Router) {
  }

  ngOnInit() {
    const ssCode = this.route.snapshot.queryParams['SS'];
    const metierCode = this.route.snapshot.queryParams['metier'];

    /*On utilise "subscribe" car les sous-secteurs sont soumis à divers changement, et on veut pouvoir notifier les objets ("sousSecteurs") qui ont besoin de savoir ce qui a changé*/
    this.formationService.findFormationsOfMetierInSS(ssCode, metierCode).subscribe(data => {
      this.formations = data;
      console.log('On a récup ' + this.formations.length + ' formations');
    });
  }



}
