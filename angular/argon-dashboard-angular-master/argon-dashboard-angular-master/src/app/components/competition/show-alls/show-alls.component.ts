import { Component, OnInit } from '@angular/core';
import { CompetitionService } from 'src/app/services/competition.service';
import { Competition } from 'src/app/model/competition.model';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-show-alls',
  templateUrl: './show-alls.component.html',
  styleUrls: ['./show-alls.component.css']
})
export class ShowAllsComponent implements OnInit {
   competitions? : Competition[]; //un tableau de competitions

  constructor(private competitionService:CompetitionService,  private fb: FormBuilder) { }
  listOfCompetitions:Competition[];
  competitionForm: FormGroup;
  show = false;
  ngOnInit(): void {
   
    this.competitionService.fetchAll().subscribe(competition => this.listOfCompetitions=competition);
    this.competitionForm = this.fb.group({
  
      idCompetition : [''],
      nameComp : [''],
      startTime : [''] ,
      endTime : [''],
    });

  



  }

  delete(idCompetition: number) {
    this.competitionService.delete(idCompetition).subscribe();
    this.ngOnInit();
  }

}

