import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Votes } from '../models/votes';
const httpOptions ={
  Headers: new HttpHeaders({'content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class VotesService {
  api: string = 'http://localhost:8089/PIDEV/votes'

  constructor(private http: HttpClient) { }
  getAllVotes(): Observable<Votes[]> {
    return this.http.get<Votes[]>(this.api);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${this.api}/${id}` );
}
}