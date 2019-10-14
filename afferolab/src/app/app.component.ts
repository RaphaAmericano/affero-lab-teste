import { Component, OnInit } from '@angular/core';
import { AfferolabService } from './afferolab.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  public produtos:any;

  displayedColumns: string[] = ['id', 'nome', 'descricao', 'categoria'];

  constructor(private service: AfferolabService){

  }

  ngOnInit(){
    this.service.getAllProdutos().toPromise().then(
      (res) => { 
        this.produtos = res;
        console.log(res);
      }
    );
  }
}
