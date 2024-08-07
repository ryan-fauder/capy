import {FormControl} from "@angular/forms";

export enum Estilo {
  CASUAL='Casual',
  ESPORTIVO="Esportivo",
  FORMAL="Formal",
  ELEGANTE="Elegante",
}

export enum Genero {
  MASCULINO="Masculino",
  FEMININO="Feminino",
  UNISSEX="Unissex",
}

export enum Tamanho {
  PP="PP",
  P="P",
  M="M",
  G="G",
  GG="GG",
  XGG="XGG"
}

export interface ProdutoResponse {
  id: number,
  codigo: string,
  nome: string,
  marca: string,
  material: string,
  descricao: string,
  estilo: Estilo,
  genero: Genero,
  tamanho: Tamanho,
  cor: string,
  valorVendaPorPeca: number,
  valorCustoPorPeca: number,
  [key: string]: any,
}

export type ProdutoResponseKeys = keyof ProdutoResponse;

export interface ProdutoFormGroup {
  codigo: FormControl<string>;
  nome: FormControl<string>;
  marca: FormControl<string>;
  material: FormControl<string>;
  descricao: FormControl<string>;
  estilo: FormControl<string>;
  genero: FormControl<string>;
  tamanho: FormControl<string>;
  cor: FormControl<string>;
  valorVendaPorPeca: FormControl<number>;
  valorCustoPorPeca: FormControl<number>;
}

export interface ProdutoRequest {
  codigo: string;
  nome: string;
  marca: string;
  material: string;
  descricao: string;
  estilo: Estilo;
  genero: Genero;
  tamanho: Tamanho;
  cor: string;
  valorVendaPorPeca: number;
  valorCustoPorPeca: number;
  // estoque: Estoque;
}
