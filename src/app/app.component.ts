import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookServiceService } from './Mycomponant/book-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'DigitalBooks';
  // myimage:string="assets\bookimeg.jpg";
  books:any[]=[];
  constructor(public service:BookServiceService,private r:Router) { }

  serch(msg:any){
    // console.log(msg)
    this.r.navigate(['search',msg])
    
  }
  
}


