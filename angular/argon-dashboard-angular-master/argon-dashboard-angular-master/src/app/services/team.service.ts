import { Injectable } from '@angular/core';
import { Team } from '../model/team.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
providedIn: 'root'
})
export class TeamService {
  url: string = 'http://localhost:8083/PIDEV/'

constructor(private http: HttpClient) {}

  public fetchAll(): Observable<Team[]> {

    return this.http.get<Team[]>(this.url + 'teams');
}
public addEvent(team: Team) {

  return this.http.post<Team>(this.url + 'addteams', team);
}

  
}
