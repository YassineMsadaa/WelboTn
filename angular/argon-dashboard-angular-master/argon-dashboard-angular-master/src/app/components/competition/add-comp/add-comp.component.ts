import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';
import { Competition } from 'src/app/model/competition.model';


@Component({
  selector: 'app-add-comp',
  templateUrl: './add-comp.component.html'
  
})
export class AddCompComponent implements OnInit {

  newCompetition = new Competition();
 

  constructor(private competitionService:CompetitionService,  private router : Router) { }

  ngOnInit(): void {
    
      

  }
  addCompetition(){
    this.competitionService.AjouterCompetition(this.newCompetition)
    .subscribe(competition => {
    console.log(competition);
    this.router.navigate(['showAlls']);
    });
    }


}
