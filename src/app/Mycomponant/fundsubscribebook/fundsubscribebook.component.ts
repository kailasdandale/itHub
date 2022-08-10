import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BookServiceService } from '../book-service.service';
import { ReaderComponent } from '../reader/reader.component';

@Component({
  selector: 'app-fundsubscribebook',
  templateUrl: './fundsubscribebook.component.html',
  styleUrls: ['./fundsubscribebook.component.scss']
})
export class FundsubscribebookComponent implements OnInit {

  books:any[]=[];
  constructor(public service:BookServiceService,private http:HttpClient ) { }

  find(e:any){
   this.http.get("http://ctsjava884.iiht.tech:1313/api/books/v1/reader/findsubscribeBook/"+e)
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
  ngOnInit(): void {
   
  }

}
