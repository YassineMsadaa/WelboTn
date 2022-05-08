import { Component, OnInit } from '@angular/core';
import { Badges } from '../models/badges';
import { BadgesService } from '../services/badges.service';


@Component({
  selector: 'app-badges',
  templateUrl: './badges.component.html',
  styleUrls: ['./badges.component.scss']
})
export class BadgesComponent implements OnInit {
  badges : Badges[];

  constructor( private badgesservice : BadgesService) { }

  ngOnInit(): void {
    this.getBadge ();
  }
  private getBadge(){
    this.badgesservice.getBadge().subscribe(data => { this.badges = data;
    });
    // this.badges= [{
    //   "id":1,
    //   "nom":"chef service",
    //   "Data":"",
    //   "FileName":"",
    //   "Description":"Get promotion"
    // }];  
      
//     this.badgesservice.badgesList().subscribe(badg =>{console.log(badg);
//       this.badges = badg
//   });

}
}
