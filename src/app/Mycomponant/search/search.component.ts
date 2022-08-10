import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {


  
  books:any=[];

  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }
 
  private host1:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/6";
  bd:any=(this.a.snapshot.paramMap.get("id"));
 
    onSerch(msg:any){
    console.log("kailas")
    console.log(msg)
  return  this.http.get("http://ctsjava884.iiht.tech:1212/api/books/v1/Books/"+msg)
   
 
  
  
  }
  ngOnInit(): void {
    console.log("kailas")

    console.log(this.bd)
    
    this.service.serchMethod(this.bd).subscribe(d=>{
      console.log(d)
      this.books=d
    })
   
   
  }

}
