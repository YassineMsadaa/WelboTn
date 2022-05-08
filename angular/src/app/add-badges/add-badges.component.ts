import { Component, OnInit } from '@angular/core';
import { Badges } from '../models/badges';

@Component({
  selector: 'app-add-badges',
  templateUrl: './add-badges.component.html',
  styleUrls: ['./add-badges.component.scss']
})
export class AddBadgesComponent implements OnInit {

  badge : Badges = new Badges();

  constructor() { }

  ngOnInit(): void {
  }
onSubmit(){
  
}
}
