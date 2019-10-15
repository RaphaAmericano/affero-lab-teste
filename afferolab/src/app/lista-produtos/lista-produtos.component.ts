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
  constructor(private service: AfferolabService ) { }

  ngOnInit() {
    this.service.changeDBAlert.subscribe( value => { 
      if( value === true ){
        this.carregarLista();
      }
    });
    this.carregarLista();
  }

  carregarLista() {
    this.service.getAllProdutos().toPromise().then(
      (res) => { 
        this.produtos = res 
      }
    )
  }

}
