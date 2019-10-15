import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AfferolabService {

  constructor(private http: HttpClient ) { }

  private urlService: 'http://localhost:8080/';

  public getAllProdutos(){
    return this.http.get(`http://localhost:8080/produtos`);
  }

  public getProdutoById(id){
    return this.http.get(`http://localhost:8080/produtos/${id}`);
  }

  public deleteProduto(id){
    return this.http.delete(`http://localhost:8080/produtos/${id}`);
  }


  public getAllCategorias(){
    return this.http.get(`http://localhost:8080/categorias`);
  }

  public cadastrarProduto(formulario:any){
    return this.http.post(`http://localhost:8080/produtos`, formulario);
  }


}
