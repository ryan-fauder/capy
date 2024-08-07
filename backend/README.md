# capy

![Capy Logo](/assets/logo_cropped.png "Capy - Logo")

Loja de roupas online - Capy

## Protótipo FIGMA

[Acesse o protótipo aqui](https://www.figma.com/design/IVNxMSQZsT2tb0I9FftoTw/Capy---Dashboard?node-id=0-1&t=xdsRXq5AJqaC7UId-0)


## Sobre a loja

A loja de e-commerce é uma plataforma online que oferece uma ampla variedade de produtos de moda, focando especialmente em roupas para diversos públicos, como homens, mulheres e crianças. Fundada com a missão de proporcionar uma experiência de compra conveniente e satisfatória, a loja oferece uma seleção cuidadosamente curada de itens de vestuário de marcas renomadas e designers emergentes.

Com um catálogo abrangente que inclui desde roupas casuais até peças de moda festa, a loja atende às diversas necessidades e estilos dos clientes, garantindo que todos encontrem algo que os represente. Além disso, a plataforma é constantemente atualizada com as últimas tendências da moda, permitindo que os clientes acompanhem as novidades e renovem seus guarda-roupas de acordo com as estações e ocasiões.

Para garantir uma experiência de compra fluida e segura, a loja de e-commerce investe em recursos como carrinho de compras intuitivo, métodos de pagamento seguros e eficientes, além de uma política de devolução flexível. Os clientes também têm a oportunidade de deixar avaliações e comentários sobre os produtos, contribuindo para uma comunidade engajada e transparente.

Além disso, a loja valoriza a personalização e a praticidade, oferecendo recursos como filtros de busca avançados, recomendações de produtos personalizadas e a possibilidade de criar listas de desejos para facilitar a compra futura. Com um compromisso com a qualidade, autenticidade e satisfação do cliente, a loja de e-commerce busca constantemente superar as expectativas e se tornar o destino preferido dos amantes da moda online.

##  Diagrama

![Capy Diagrama de Classe](/assets/capy.jpg "Capy Diagrama de Classe")

```jsx

classDiagram
    class Endereco {
        +cidade: string
        +estado: string
        +cep: string
        +complemento: string
        +numero: string
        +logradouro: string
    }

    class Cupom {
        +codigo: string
        +desconto: BigDecimal
        +dataValidade: LocalDate
    }

    class Usuario {
        +contato: string
        +nome: string
        +email: string
        +senha: string
        +adicionarAoCarrinho()
        +fazerPedido()
        +deixarAvaliacao()
    }

    class Avaliacao {
        +classificacao: int
        +comentario: string
    }

    class CarrinhoDeCompra {
        +adicionarItem()
        +removerItem()
        +calcularTotal()
    }

    class Pedido {
        +status: string
        +adicionarItem()
        +removerItem()
        +calcularTotal()
    }

    class PagamentoCartao {
        +numeroCartao: string
        +dataValidade: string
    }

    class ItemPedido {
        +quantidadeProduto: int
    }

    class Produto {
        +codigo: string
        +nome: string
        +marca: string
        +material: string
        +descricao: string
    }

    class Funcionario {
        +nome: string
        +email: string
        +senha: string
        +cadastrarProduto()
        +atualizarProduto()
        +removerProduto()
        +adicionarProdutoEstoque()
        +removerProdutoEstoque()
        +adicionarCategoria()
        +cadastrarCupom()
        +removerCupom()
        +enviarFeedbackAvaliacao()
        +atualizarStatusPedido()
    }

    class Estoque {
        +quantidadeDisponivel: int
        +origem: string
        +cor: string
        +valorVendaPorPeca: BigDecimal
        +updatedAt: LocalDate
        +valorCustoPorPeca: BigDecimal
    }

    class Estilo {
        <<enumeration>>
        CASUAL
        ESPORTIVO
        FORMAL
        ELEGANTE
    }

    class TamanhoPeca {
        <<enumeration>>
        PP
        P
        M
        G
        GG
        XGG
    }

    class Genero {
        <<enumeration>>
        MASCULINO
        FEMININO
        UNISSEX
    }

    class Cargo {
        <<enumeration>>
        ATENDENTE
        PROPRIETARIO
        GESTOR
    }

    Endereco "1" -- "1" Usuario : Contém
    Cupom "n" -- "n" CarrinhoDeCompra : Aplica
    Usuario "1" -- "n" Pedido : Realiza
    Usuario "1" -- "n" CarrinhoDeCompra : Realiza
    Usuario "1" -- "n" Avaliacao : Realiza
    Pedido "1" -- "n" PagamentoCartao : Contém
    Pedido "1" -- "n" ItemPedido : Contém
    ItemPedido "1" -- "1" Produto : Contém
    CarrinhoDeCompra "1" -- "n" ItemPedido : Contém
    Produto "1" -- "1" Estilo : Possui
    Produto "1" -- "1" Genero : Pertence
    Produto "1" -- "n" Estoque : Possui
    Funcionario "1" -- "1" Cargo : Possui
    Funcionario "1" -- "n" Produto : Cadastra
    Produto "1" -- "1" TamanhoPeca : Possui

```

## Classes

### Descrição das Classes

**Endereco**
- A classe `Endereco` representa o endereço de um usuário, contendo detalhes como cidade, estado, CEP, complemento, número e logradouro. Esta classe é utilizada para armazenar e manipular informações de localização do usuário.

**Cupom**
- A classe `Cupom` representa um cupom de desconto que pode ser aplicado a uma compra. Inclui informações como código do cupom, valor do desconto e data de validade. Os cupons são usados para fornecer descontos aos usuários nas suas compras.

**Usuario**
- A classe `Usuario` representa um cliente do sistema. Inclui atributos como contato, nome, email e senha. Possui métodos para adicionar itens ao carrinho, fazer pedidos e deixar avaliações. Esta classe gerencia as interações do usuário com o sistema de compras.

**Avaliacao**
- A classe `Avaliacao` permite que os usuários deixem feedback sobre produtos. Inclui atributos como classificação (rating) e comentário. Esta classe ajuda a coletar opiniões dos usuários sobre os produtos oferecidos.

**CarrinhoDeCompra**
- A classe `CarrinhoDeCompra` representa o carrinho de compras de um usuário, onde os itens podem ser adicionados, removidos e o total calculado. Esta classe é fundamental para a etapa de pré-compra, permitindo ao usuário selecionar os produtos que deseja comprar.

**Pedido**
- A classe `Pedido` representa um pedido realizado por um usuário. Inclui atributos como status do pedido e possui métodos para adicionar itens, remover itens e calcular o total do pedido. Esta classe gerencia o ciclo de vida do pedido desde a criação até a conclusão.

**PagamentoCartao**
- A classe `PagamentoCartao` armazena informações de pagamento realizadas com cartão de crédito ou débito. Inclui atributos como número do cartão e data de validade. Esta classe é usada para processar pagamentos de pedidos.

**ItemPedido**
- A classe `ItemPedido` representa um item específico em um pedido. Inclui a quantidade do produto pedido. Esta classe permite o detalhamento dos produtos incluídos em um pedido.

**Produto**
- A classe `Produto` representa os produtos disponíveis para compra no sistema. Inclui atributos como código, nome, marca, material e descrição. Esta classe define as características dos produtos oferecidos aos usuários.

**Funcionario**
- A classe `Funcionario` representa um funcionário do sistema, responsável por gerenciar produtos, estoques e cupons, além de enviar feedback sobre avaliações e atualizar o status dos pedidos. Inclui atributos como nome, email e senha. Os funcionários desempenham funções administrativas no sistema.

**Estoque**
- A classe `Estoque` controla a disponibilidade de produtos no estoque. Inclui atributos como quantidade disponível, origem, cor, valor de venda por peça, data da última atualização e valor de custo por peça. Esta classe ajuda a gerenciar o inventário de produtos.

**Estilo**
- A enumeração `Estilo` define os diferentes estilos de produtos que podem ser oferecidos, como casual, esportivo, formal e elegante. Esta enumeração ajuda a categorizar produtos com base em seu estilo.

**TamanhoPeca**
- A enumeração `TamanhoPeca` define os diferentes tamanhos de peças de roupas, como PP, P, M, G, GG e XGG. Esta enumeração é usada para especificar as variações de tamanho dos produtos.

**Genero**
- A enumeração `Genero` define os diferentes gêneros para os quais os produtos podem ser destinados, como masculino, feminino e unissex. Esta enumeração ajuda a categorizar produtos com base no gênero.

**Cargo**
- A enumeração `Cargo` define os diferentes cargos que um funcionário pode ocupar, como atendente, proprietário e gestor. Esta enumeração é usada para diferenciar as responsabilidades e funções dos funcionários no sistema.