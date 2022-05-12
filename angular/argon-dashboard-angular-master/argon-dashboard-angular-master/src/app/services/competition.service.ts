import { Injectable } from '@angular/core';
import { Competition } from '../model/competition.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



const httpOptions = {
headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
providedIn: 'root'
})
export class CompetitionService {
  

  
  url: string = 'http://localhost:8083/PIDEV/'

constructor(private http: HttpClient) {}

fetchAll(): Observable<Competition[]> {

  return this.http.get<Competition[]>(this.url + 'competitions');
}
AjouterCompetition( competition: Competition):Observable<Competition>{
  return this.http.post<Competition>(this.url + 'AjouterCompetition' , competition);
  }

  public delete(idCompetition: number) {
    return this.http.delete<Competition>(this.url + 'deleteCompetition/' + idCompetition);
  }
  public update(idCompetition: number, competition: Competition) {
    return this.http.put<Competition>(this.url + 'update/' + idCompetition, competition);
  }

  public findById(idCompetition: number) {
    return this.http.get<Competition>(this.url + 'findbyid/' + idCompetition);
  }
  rechercherParNom(nameComp: string):Observable< Competition[]> {
    const url = (this.url + 'prodsByName/' + nameComp);
    return this.http.get<Competition[]>(url);
    }

  
}