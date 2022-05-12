import { Component, OnInit } from '@angular/core';
import { Competition } from 'src/app/model/competition.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CompetitionService } from 'src/app/services/competition.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-update-competition',
  templateUrl: './update-competition.component.html',
  styleUrls: ['./update-competition.component.css']
})
export class UpdateCompetitionComponent implements OnInit {

  competitionToBeUpdated: Competition;

  updatedForm: FormGroup;

  show: boolean = false;

  constructor(private competitionService: CompetitionService, private fb: FormBuilder, private rout: ActivatedRoute) { }


  ngOnInit(): void {

    const idCompetition = this.rout.snapshot.paramMap.get('idCompetition');
    this.competitionService.findById(+idCompetition).subscribe(competition => this.competitionToBeUpdated = competition);


    this.updatedForm = this.fb.group({
      nameComp: [''],
      startTime: [''],
      endTime: [''],
    
    });
  }



  handelSubmitUpdate() {
    this.competitionService.update(this.competitionToBeUpdated.idCompetition, this.updatedForm.value).subscribe();
  }



  update() {
    this.updatedForm.setValue({
      nameComp: this.competitionToBeUpdated.nameComp,
      startTime: this.competitionToBeUpdated.startTime,
      endTime: this.competitionToBeUpdated.endTime,
   
    });

    this.show = !this.show;

  }

}
