import { Component, OnInit } from '@angular/core';
import { EvaluationService } from '../services/evaluation.service';
import { Evaluation } from 'c:/angular/argon-dashboard-angular-master/src/app/models/evaluation.model';
@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.scss']
})
export class EvaluationComponent implements OnInit {
  evaluation : Evaluation[];

  constructor(private evaluationService: EvaluationService) { }

  ngOnInit(): void {
    // this.evaluationService.listeEvaluation().subscribe(evals =>{console.log(evals);
    //  this.evaluation = evals
    // });
  }

}
