import { Component, OnInit } from '@angular/core';
import { AfferolabService } from '../afferolab.service';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.scss']
})
export class ListaProdutosComponent implements OnInit {

  public produtos:any;
  public edicaoAtiva:boolean = false;
  constructor(private service: AfferolabService) { }

  ngOnInit() {
    this.carregarLista();
  }

  habilitarDesabilitarEdicao(){
    if(this.edicaoAtiva == false ){
      this.edicaoAtiva = true;
    } else {
      this.edicaoAtiva = false;
    }
    console.log(this.edicaoAtiva);
  }

  carregarLista() {
    this.service.getAllProdutos().toPromise().then(
      (res) => { 
        console.log(res);
        this.produtos = res 
      }
    )
  }

  deletarProduto(id){
    this.service.deleteProduto(id).subscribe(
    (data) => {
      console.log(data);
      this.carregarLista();
    }, 
    (error) => {
      console.log(error);
    })
  }

  submitEdicao(){
    //requisicao e bla bla bla
  }

}
