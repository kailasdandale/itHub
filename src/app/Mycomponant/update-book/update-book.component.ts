import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit {

  
  

  private host6:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/"
  books:any[]=[];
  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }

   bookId:any=(this.a.snapshot.paramMap.get("id"));

  getData(id:any){
    this.http.get("http://ctsjava884.iiht.tech:1212/api/books/v1/Books/"+id)
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
   updateBook(data:any){
     
    this.http.post('http://ctsjava884.iiht.tech:1212/api/books/v1/Books/addBook',data)
    .subscribe((result)=>{
      console.warn("result",result)
      alert("Book updated")
    })
    console.warn(data)
  
  }
   
  
  ngOnInit(): void {
    this.a.paramMap.subscribe(d=>console.log(d.get("id")))
  }

}
