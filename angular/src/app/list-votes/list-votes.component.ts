import { Component, OnInit } from '@angular/core';
import { Votes } from '../models/votes';
import { VotesService } from '../services/votes.service';

@Component({
  selector: 'app-list-votes',
  templateUrl: './list-votes.component.html',
  styleUrls: ['./list-votes.component.scss']
})
export class ListVotesComponent implements OnInit {
  votes?: Votes[];
  currentVotes: Votes = {};
  currentIndex = -1;
  Nbvotes = '';
  retrierveVotes: any;

  constructor(private votesservice : VotesService) { }

  ngOnInit(): void {
    this.retrierveVotes();
  }
  retrieveVotes(): void {
    this.votesservice.getAllVotes()
      .subscribe({
        next: (Nbvotes) => {
          this.votes = Nbvotes;
          console.log(Nbvotes);
        }
        });
      }
       refreshList(): void {
       this.retrieveVotes();
          this.currentVotes = {};
          this.currentIndex = -1;
        }
        setActivevotes(votes: Votes, index: number): void {
          this.currentVotes = votes;
          this.currentIndex = index;
        }
  }
function refreshList() {
  throw new Error('Function not implemented.');
}

