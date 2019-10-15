import { Component, OnInit } from '@angular/core';
import { AfferolabService } from '../afferolab.service';
import { FormGroup, FormBuilder, FormArray, Validators } from '@angular/forms';
import { catchError, map } from 'rxjs/operators';

@Component({
  selector: 'app-formulario-produto',
  templateUrl: './formulario-produto.component.html',
  styleUrls: ['./formulario-produto.component.scss']
})
export class FormularioProdutoComponent implements OnInit {

  public formulario: FormGroup;

  public listaCategorias:any;



  constructor(private service:AfferolabService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.service.getAllCategorias().toPromise().then(
      (res) => { 
        console.log(res);
        this.listaCategorias = res 
      });

      this.formulario = this.formBuilder.group({
        nome: [null, Validators.required, Validators.maxLength(3)],
        cod_barras:[null, Validators.required],
        quantidade: [0],
        descricao:[null, Validators.required],
        categoria:[null, Validators.required], 
      });
  }

  onSubmit() {
    if(this.formulario.valid){
      this.submit();
    }
    console.log("Submit");
  }

  public submit(){
    
    let send = this.formulario.value;
    console.log(send);
    this.service.cadastrarProduto(send).subscribe((data) => {
      console.log("Envido produto", data )
    },
      error => {
        console.log("Erro:", error);
      })
  }

  resetar(){
    this.formulario.reset();
  }

}
