import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private host4:string="http://ctsjava884.iiht.tech:8890/api/books/v1/reader/findAll";
 private host:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/getAllBooks";
 private host1:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/6";
 private host2:string="http://ctsjava884.iiht.tech:8890/api/books/v1/reader/search"
 private host3:string="http://ctsjava884.iiht.tech:8890/api/books/v1/reader/findsubscribeBook/"
 private host5:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/"

   books:any[]=[];
  constructor(private http:HttpClient) { }


  findAll(){
    return this.http.get(this.host4);
  }
  getById(id:number){
    return this.http.get(this.host1);
  }

  serchMethod(msg:any){
    return this.http.get(this.host2+"/"+msg);
  }
  find(ee:any){
   // console.log("http://ctsjava884.iiht.tech:1313/api/books/v1/reader/findsubscribeBook/"+ee)
    return this.http.get(this.host3+ee)
  }

  
 
  search(msg:any){

    return this.http.get(this.host1+msg);
  }
  findById(id:any){
    console.log("http://ctsjava884.iiht.tech:1212/api/books/v1/Books/2") 
    }
  

}
