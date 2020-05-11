import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Secteur } from '../model/secteur';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SecteurService {

  /*Ici on communique avec le back-end, pour récupérer les secteurs du Repository dédié aux secteurs*/

  private secteursUrl: string;

  constructor(private http: HttpClient) {
    this.secteursUrl = 'http://localhost:8095/secteursList'; /*URL vers un REST Controller retournant tous les secteurs existants*/
  }

  public findAll(): Observable<Secteur[]> {
    console.log('On demande tous les secteurs');
    return this.http.get<Secteur[]>(this.secteursUrl);
  }

}
