import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }

  onSubmit(data:any){

    this.http.post('http://ctsjava884.iiht.tech:1212/api/books/v1/Books/addBook',data)
    .subscribe((result)=>{
      console.warn("result",result)
      alert("Book Added")
    })
    console.warn(data)
  }

  ngOnInit(): void {
  }

}
