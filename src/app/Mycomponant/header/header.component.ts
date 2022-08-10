import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  books:any[]=[];
  constructor(public service:BookServiceService,private r:Router) { }

  findAllBooks(){
    this.service.findAll()
    .subscribe({
      next: (res:any)=>{
        console.log(res);
        this.books=res;
      },
      error: (err:any)=>{
        console.log(err)
      }
    })
  }
  buyBook(bookId:number){

    this.r.navigate(['reader',bookId])
    
  }


  ngOnInit(): void {
    this.findAllBooks();
  }

}
