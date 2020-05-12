import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {SousSecteur} from '../model/sous-secteur';

@Injectable({
  providedIn: 'root'
})
export class SousSecteurService {


  private sousSecteursUrl: string;

  constructor(private http: HttpClient) {
    this.sousSecteursUrl = 'http://localhost:8095/sousSecteursList';
  }

  public findSSOfSecteur(codeS : String): Observable<SousSecteur[]> {
    console.log('On demande tous les sous-secteurs du secteur de code');
    const params = new HttpParams({fromString: "codeS="+codeS});
    return this.http.get<SousSecteur[]>(this.sousSecteursUrl, {params});
  }
}
