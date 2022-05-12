import { Injectable } from '@angular/core';
import { Event } from '../model/event.model';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
providedIn: 'root'
})
export class EventService {
   
  url: string = 'http://localhost:8083/PIDEV/'

constructor(private http: HttpClient) {}

fetchAll(): Observable<Event[]> {

  return this.http.get<Event[]>(this.url + 'events');
}
AjouterEvent( event: Event):Observable<Event>{
  return this.http.post<Event>(this.url + 'AjouterEvent' , event);
  }

  public deleteEvent(idEvent: number) {
    return this.http.delete<Event>(this.url + 'deleteEvent/' + idEvent);
  }
  public updateEvent(idEvent: number, event: Event) {
    return this.http.put<Event>(this.url + 'updateE/' + idEvent, event);
  }

  public findByIdE(idEvent: number) {
    return this.http.get<Event>(this.url + 'findbyidE/' + idEvent);
  }

}