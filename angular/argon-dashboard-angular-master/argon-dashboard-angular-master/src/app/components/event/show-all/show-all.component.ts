import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/services/event.service';
import { Event } from 'src/app/model/event.model';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  constructor(private eventService:EventService,  private fb: FormBuilder ) { }
  listOfEvents:Event[];
  eventForm: FormGroup;
  show = false;

  ngOnInit(): void {
    this.eventService.fetchAll().subscribe(event => this.listOfEvents=event);
    this.eventForm = this.fb.group({
      name: [''],
      description: [''],
      time: [''],
      categorie: [''],
      image: [''],

    });
  
  
  
  
  }
  handelSubmit() {
    this.eventService.AjouterEvent(this.eventForm.value).subscribe();
    this.ngOnInit();
    
  }
  
  showAddEvent() {
    this.show = !this.show;


  }

  deleteEvent(idEvent: number) {
    this.eventService.deleteEvent(idEvent).subscribe();
    this.ngOnInit();
  }








}
