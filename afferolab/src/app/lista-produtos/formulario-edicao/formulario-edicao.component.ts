import { Component, OnInit, Input, Output } from '@angular/core';
import { AfferolabService } from 'src/app/afferolab.service';
import { EventEmitter } from 'protractor';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Produto } from 'src/app/model/produto';

@Component({
  selector: 'app-formulario-edicao',
  templateUrl: './formulario-edicao.component.html',
  styleUrls: ['./formulario-edicao.component.scss']
})
export class FormularioEdicaoComponent implements OnInit {
  
  @Input() public id_produto: number;
  //@Output() atualizacao = new EventEmitter();
  public edicaoAtiva:boolean;
  public deleteAtiva:boolean;
  public categorias:any;
  public formularioEdicao:FormGroup =  new FormGroup({
      nome: new FormControl('',Validators.required),
      cod_barras:new FormControl('',Validators.required),
      quantidade: new FormControl(0),
      descricao:new FormControl('',Validators.required),
      categoria:new FormControl('',Validators.required),
  });

  constructor(private service: AfferolabService, private formbuilder: FormBuilder) { }

  ngOnInit() {
    this.edicaoAtiva = false;
    this.deleteAtiva = false;
    this.service.getAllCategorias().toPromise().then( res => this.categorias = res )
    this.service.getProdutoById(this.id_produto).toPromise().then(
      res => { 
        this.formularioEdicao.setValue({
          nome: res['nome'],
          cod_barras: res['cod_barras'],
          quantidade: res['quantidade'],
          descricao: res['descricao'],
          categoria: res['categoria']['id']
        })  
      },
      error => { console.log(error)}
      );
  }

  habilitarDesabilitarEdicao(){
    if(this.edicaoAtiva == false ){
      this.edicaoAtiva = true;
    } else {
      this.edicaoAtiva = false;
    }
  }

  habilitarDesabilitarDelete(){
    if(this.deleteAtiva == false ){
        this.deleteAtiva = true;
    } else {
      this.deleteAtiva = false;
    }
  }

  deletarProduto(id){
    this.service.deleteProduto(id).subscribe(
    (data) => {
      console.log(data);
      this.service.changeDB();
      //this.carregarLista();
    }, 
    (error) => {
      console.log(error);
    })
  }

  submitEdicao(id){
    this.service.updateProduto(id, this.formularioEdicao.value).subscribe(
      data => { console.log(data) }, 
      error => { console.log(error)} 
      )
  }
}
