import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AfferolabService {

  public changeDBAlert:BehaviorSubject<boolean> = new BehaviorSubject(false);
  

  constructor(private http: HttpClient ) { }

  public changeDB(){
    this.changeDBAlert.next(true);
  }


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

  public cadastrarCategoria(formulario:any){
    return this.http.post('http://localhost:8080/categorias', formulario )
  }

  public cadastrarProduto(formulario:any){
    return this.http.post(`http://localhost:8080/produtos`, formulario);
  }

  public updateProduto(id:any, formulario:any) {
    return this.http.put(`http://localhost:8080/produtos/${id}`, formulario);
  }

}
