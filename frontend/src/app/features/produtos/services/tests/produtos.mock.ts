import {Estilo, Genero, ProdutoResponse, Tamanho} from "../interfaces/produtos.interface";

export const mockProdutos: ProdutoResponse[] = [
  {
    id: 1,
    codigo: 'A123',
    nome: 'Camiseta Básica',
    marca: 'Marca A',
    material: 'Algodão',
    descricao: 'Camiseta básica feita de algodão 100%.',
    estilo: Estilo.CASUAL,
    genero: Genero.MASCULINO,
    tamanho: Tamanho.M,
    cor: 'Branco',
    valorVendaPorPeca: 29.99,
    valorCustoPorPeca: 15.00
  },
  {
    id: 2,
    codigo: 'B456',
    nome: 'Calça Jeans',
    marca: 'Marca B',
    material: 'Jeans',
    descricao: 'Calça jeans de alta qualidade com design moderno.',
    estilo: Estilo.CASUAL,
    genero: Genero.FEMININO,
    tamanho: Tamanho.G,
    cor: 'Azul',
    valorVendaPorPeca: 89.99,
    valorCustoPorPeca: 45.00
  },
  {
    id: 3,
    codigo: 'C789',
    nome: 'Blazer Formal',
    marca: 'Marca C',
    material: 'Poliéster',
    descricao: 'Blazer formal ideal para ocasiões especiais.',
    estilo: Estilo.FORMAL,
    genero: Genero.UNISSEX,
    tamanho: Tamanho.GG,
    cor: 'Preto',
    valorVendaPorPeca: 199.99,
    valorCustoPorPeca: 100.00
  }
];
