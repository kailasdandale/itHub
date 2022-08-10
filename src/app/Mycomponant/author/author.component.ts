import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {

  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }

  onSubmit(data:any){

    this.http.post('http://ctsjava884.iiht.tech:1010/authenticate',data)
    .subscribe((result)=>{
      console.warn("result",result)
      alert("Token genarate Sucssefully!!!")
    })
    console.warn(data)
  }

  ngOnInit(): void {
  }

}
