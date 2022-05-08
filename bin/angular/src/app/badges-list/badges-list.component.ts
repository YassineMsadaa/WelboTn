import { Component, OnInit } from '@angular/core';
import { Badges } from '../models/badges';
@Component({
  selector: 'app-badges-list',
  templateUrl: './badges-list.component.html',
  styleUrls: ['./badges-list.component.scss']
})
export class BadgesListComponent implements OnInit {

  badgesList : Badges[];

  constructor() { }

  ngOnInit(): void {
    this.badgesList = [
      {id: 1, nom: "chef service", Data: " ", FileName:"", Description:"get promotion"},
      {id: 2, nom: "Directeur", Data: " ", FileName:"", Description:"no promotion"},
      {id: 3, nom: "ouvrier", Data: " ", FileName:"", Description:"no promotion"},
      {id: 4, nom: "sous-directeur", Data: " ", FileName:"", Description:"get promotion"}
    ];
  }

}
