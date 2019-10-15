import { Categoria } from './categoria';

export class Produto {
    id:number;
    cod_barras:number;
    nome:string;
    descricao:string;
    quantidade:number;
    categoria: Categoria;
}
