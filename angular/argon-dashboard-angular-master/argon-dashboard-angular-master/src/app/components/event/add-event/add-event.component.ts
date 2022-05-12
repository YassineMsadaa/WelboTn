import { Component, OnInit,Inject } from '@angular/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { Event } from 'src/app/model/event.model';
import { EventService } from 'src/app/services/Event.service';

import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }
from '@angular/forms';
import { Router } from '@angular/router';

import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {
  userFile ;
  newEvent = new Event ;
  public imagePath;
  imgURL: any;
  public message: string;
  
  uploadedImage: File;  
  dbImage: any; 
  postResponse: any;
  successResponse: string;
  image: any;

 

  constructor(private eventService:EventService,  private router : Router, ) { }
  httpClient: HttpClient ;
  ngOnInit(): void {
  }
  public onImageUpload(event) {    
    this.uploadedImage = event.target.image[0];
  }

 




  addEvent(){
    this.eventService.AjouterEvent(this.newEvent)
    .subscribe(event => {
    console.log(event);
    this.router.navigate(['showAll']);
    });
    
    }

  onSelectFile(event) {
    if (event.target.files.length > 0)
    {
      const image = event.target.files[0];
      this.userFile = image;
     // this.f['profile'].setValue(file);
 
    var mimeType = event.target.files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = "Only images are supported.";
      return;
    }
 
    var reader = new FileReader();
    
    this.imagePath = image;
    reader.readAsDataURL(image); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result; 
    }
  }
     
      
    }


}
