import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { Evaluation } from '../models/evaluation.model';
const httpOptions ={
  Headers: new HttpHeaders({'content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class EvaluationService {
  api: string = 'http://localhost:8089/PIDEV/evaluation'
  evaluation : Evaluation[];

      constructor(private http: HttpClient) { }
  //json-server --watch db.json
  
  listeEvaluation(): Observable<Evaluation[]> {
    return this.http.get<Evaluation[]>(this.api)
  }
  getevaluationById(id: number) {
    return this.http.get<Evaluation>(this.api + '/' + id)
  }
  addEvaluation(evaluation: Evaluation) {
    return this.http.post(this.api, Evaluation);
  }

  deleteEvaluation (id: number) {
    return this.http.delete(this.api + '/' + id)
  }
}

// function deleteEvaluation(id: any, any: any) {
//   throw new Error('Function not implemented.');
// }

