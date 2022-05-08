import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Badges } from '../models/badges';
const httpOptions ={
  Headers: new HttpHeaders({'content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class BadgesService {
  api: string = 'http://localhost:8087/badges'
  badges : Badges[];

      constructor(private http: HttpClient) { }
  //json-server --watch db.json
  getBadge (): Observable<Badges[]> {
    return this.http.get<Badges[]>(this.api +'/retrieve-All-Badges')
  }
  // badgesList(): Observable<Badges[]> {
  //   return this.http.get<Badges[]>(this.api)
  // }
  
  // addBadge (badges : any ) {
  //   return this.http.post(this.api + '/add-Badge', badges);
  // }
  // deleteBadge (id: number) {
  //   return this.http.delete(this.api + '/' + id)
  // }
  // putBadge (badges : any) {
  //   return this.http.put(this.api +'/modify-Badges', badges)
  // }
}



