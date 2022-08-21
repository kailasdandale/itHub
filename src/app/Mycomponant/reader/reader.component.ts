import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.scss']
})
export class ReaderComponent implements OnInit {
  books:any[]=[];
  constructor(public service:BookServiceService,private a:ActivatedRoute,private http:HttpClient){ }

   bookId:any=(this.a.snapshot.paramMap.get("id"));
 


  onSubmit(data:any){

    this.http.post('http://ctsjava884.iiht.tech:1313/api/books/v1/reader/subscribe',data)
    .subscribe((result)=>{
      console.warn("result",result)
      alert("SucsessFully Subcribe")
    })
    console.warn(data)
  }
  find(ms:any){
    
  }


  ngOnInit(): void {
  
    console.log(this.bookId)
    this.a.paramMap.subscribe(d=>console.log(d.get("id")))

  }

 
 
 

}
