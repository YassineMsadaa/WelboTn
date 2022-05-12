import { Component, OnInit } from '@angular/core';
import { Competition } from '../model/competition.model';
import { CompetitionService } from 'src/app/services/competition.service';
@Component({
  selector: 'app-recherche-par-nom',
  templateUrl: './recherche-par-nom.component.html',
  styles: [
  ]
})
export class RechercheParNomComponent implements OnInit {
  nameComp! : string;
  competitions!: Competition[];
  allCompetitions!: Competition[];
  searchTerm!: string;
  
  constructor(private competitionService : CompetitionService) { }

  ngOnInit(): void {
    this.competitionService.fetchAll().subscribe(prods => {
      console.log(prods);
      this.competitions = prods;
      });
      
  }

  rechercherProds(){
    this.competitionService.rechercherParNom(this.nameComp).
    subscribe(prods => {
      console.log(prods);
      this.competitions=prods;});
  }

}
