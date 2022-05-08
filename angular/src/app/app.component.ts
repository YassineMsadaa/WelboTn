import { Component } from '@angular/core';
import { Badges } from './models/badges';
import { BadgesService } from './services/badges.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'well being at work';
//   badgesservice: any;
//   badges: any;
//   submitBadge(value: Badges) {
//     let body = {
//     id: value.id,
//     nom: value.nom,
//     Data: value.Data,
//     FileName: value.FileName,
//     Description: value.Description,
//     }
//     this.badgesservice.addBadge(this.badges)
// .subscribe(response => {
//     console.log(response)
// })

  }

