import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-apps',
  templateUrl: './apps.component.html',
  styleUrls: ['./apps.component.css']
})
export class AppsComponent implements OnInit {

  
  title = 'EmailTemplate';

  dataset: Details = {
    name:'',
    age:null,
    country:'',
    email:''
  };
  ngOnInit(): void {
   
      
  }

  constructor(private https: HttpClient){ }

  onSubmit()
  {
    this.https.post<Details>('http://localhost:8083/PIDEV/testapp/getdetails', this.dataset).subscribe(
      res => {
        this.dataset = res;
        console.log(this.dataset);
        alert('Email Sent successfully');
        this.dataset.age = null;
        this.dataset.name = '';
        this.dataset.country = '';
        this.dataset.email = '';

      });
  }
}

interface Details
{
  name:string;
  age:number;
  country:string;
  email:string;
  










}
