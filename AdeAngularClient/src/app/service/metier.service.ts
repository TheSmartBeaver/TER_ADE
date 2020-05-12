import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {SousSecteur} from '../model/sous-secteur';
import {Metier} from '../model/metier';

@Injectable({
  providedIn: 'root'
})
export class MetierService {

  private metiersUrl: string;

  constructor(private http: HttpClient) {
    this.metiersUrl = 'http://localhost:8095/metiersList';
  }

  public findMetierOfSS(codeSS : String): Observable<Metier[]> {
    console.log('On demande tous les sous-secteurs du secteur de code');
    const params = new HttpParams({fromString: "codeSS="+codeSS});
    return this.http.get<Metier[]>(this.metiersUrl, {params});
  }
}
