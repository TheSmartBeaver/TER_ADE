import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Metier} from '../model/metier';
import {Formation} from '../model/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  private formationsUrl: string;

  constructor(private http: HttpClient) {
    this.formationsUrl = 'http://localhost:8095/formationsList';
  }

  public findFormationsOfMetierInSS(ssCode : String, metierCode : String): Observable<Formation[]> {
    console.log('On demande tous les sous-secteurs du secteur de code');
    const params = new HttpParams({fromString: "codeSS="+ssCode+"&metierCode="+metierCode});
    return this.http.get<Formation[]>(this.formationsUrl, {params});
  }
}
