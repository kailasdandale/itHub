import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-newauthor',
  templateUrl: './newauthor.component.html',
  styleUrls: ['./newauthor.component.scss']
})
export class NewauthorComponent implements OnInit {

  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }

  onSubmit(data:any){

    this.http.post('http://ctsjava884.iiht.tech:1010/api/books/v1/author/sinup',data)
    .subscribe((result)=>{
      console.warn("result",result)
      alert("Account Created")
    })
    console.warn(data)
  }

  ngOnInit(): void {
  }

}
