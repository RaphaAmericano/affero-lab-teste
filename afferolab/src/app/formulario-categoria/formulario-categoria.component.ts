import { Component, OnInit } from '@angular/core';
import { AfferolabService } from '../afferolab.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-categoria',
  templateUrl: './formulario-categoria.component.html',
  styleUrls: ['./formulario-categoria.component.scss']
})
export class FormularioCategoriaComponent implements OnInit {

  public formularioCategoria:FormGroup;

  constructor(private service:AfferolabService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.formularioCategoria = this.formBuilder.group({
      nome:[null, [Validators.required, Validators.minLength(3)]]
    })
  }

  public submitCategoria(){
    let cat_nome = this.formularioCategoria.value['nome'];
    this.service.cadastrarCategoria(cat_nome).subscribe(
      (data) => { 
        console.log("Cadastro de Categoria", data)
        this.resetar();
        this.service.changeDB();
       }, 
      (error) => { console.log("Erro:", error )}
    );
  }
  public resetar(){
    this.formularioCategoria.reset();
  }
}
