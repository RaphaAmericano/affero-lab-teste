import { Component, OnInit} from '@angular/core';
import { AfferolabService } from '../afferolab.service';
import { FormGroup, FormBuilder,  Validators } from '@angular/forms';

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
        nome: [null, Validators.required],
        cod_barras:[null, Validators.required],
        quantidade: [0],
        descricao:[null, Validators.required],
        categoria:[null, Validators.required] 
      });
      this.service.changeDBAlert.subscribe( value => {
        if(value === true ){
          this.service.getAllCategorias().toPromise().then(
            (res) => { 
            console.log(res);
            this.listaCategorias = res 
          });
        }
      });
  }

  public onSubmit() {
    if(this.formulario.valid){
      this.submit();
    }
  }

  public submit(){
    
    let send = this.formulario.value;
    console.log(send);
    this.service.cadastrarProduto(send).subscribe((data) => {
      console.log("Envido produto", data );
      this.resetar();
      this.service.changeDB();
    },
      error => {
        console.log("Erro:", error);
      })
  }

  public resetar(){
    this.formulario.reset();
  }

}
