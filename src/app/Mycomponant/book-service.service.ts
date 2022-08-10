import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

 private host:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/getAllBooks";
 private host1:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/6";
 private host2:string="http://ctsjava884.iiht.tech:1212/api/books/v1/Books/search?query"
 private host3:string="http://ctsjava884.iiht.tech:1313/api/books/v1/reader/findsubscribeBook/"
  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get(this.host);
  }
  getById(id:number){
    return this.http.get(this.host1);
  }

  serchMethod(msg:any){
    return this.http.get(this.host2+"="+msg);
  }
  find(ee:any){
   // console.log("http://ctsjava884.iiht.tech:1313/api/books/v1/reader/findsubscribeBook/"+ee)
    return this.http.get(this.host3+ee)
  }

  createBooks(b:any){

    let myHeader:HttpHeaders=new HttpHeaders();
    myHeader.append("content-Type","application/json");
    myHeader.append("Accept","application/json");
    return this.http.post(this.host,b,{headers:myHeader});
    
  }
 
  search(msg:any){

    return this.http.get(this.host1+msg);
  }


}
