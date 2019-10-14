import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AfferolabService {

  constructor(private http: HttpClient ) { }

  private urlService: 'http://localhost:8080/';

  public getAllProdutos(){
    return this.http.get(`http://localhost:8080/produtos`);
  }

}
