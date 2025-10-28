# Semana 2 - Classes e Objetos; Encapsulamento e Ocultação da Informação

## A Ideia Central

A POO busca organizar o software de uma forma que espelhe o mundo real. Em vez de uma longa sequência de comandos, criamos "entidades" autônomas que possuem características e sabem executar tarefas.

- **Classe:** É o molde, a planta baixa, a abstração. Ela define um tipo de coisa, especificando quais características (atributos) ela terá e quais ações (métodos) ela poderá realizar. Uma classe não é algo concreto, é apenas o projeto.
- **Objeto:** É a instância, a coisa real, construída a partir do molde. Se a classe `Carro` é o projeto, um "Fusca azul, placa ABC-1234" é um objeto. Podemos criar múltiplos objetos a partir da mesma classe, cada um com sua própria identidade e estado.

## Anatomia de uma Classe

Uma classe é um bloco de código que agrupa atributos e métodos.

- **Atributos (Variáveis de Instância):** São as variáveis declaradas dentro da classe, mas fora de qualquer método. Elas definem o estado de um objeto. Cada objeto criado terá sua própria cópias desses atributos.

```Java
public class Pessoa {
    private String nome; // Atributo
    private int idade; // Atributo
}
```
- **Métodos:** São os blocos de código que definem o comportamento de um objeto. São as ações que o objeto pode executar, geralmente para manipular seus próprios atributos.

```Java
public class Pessoa {
    // ...atributos...
    public void fazerAniversario() { // Método
        this.idade = this.idade + 1;
    }
}
```

## Encapsulamento

Conceito crucial da POO, se baseia em duas ideias complementares:
- **Encapsulamento:** É o ato de "encapsular", de agrupar atributos e métodos relacionados dentro da mesma unidade (a classe). É como colocar o motor, as rodas e o volante juntos para formar o "carro".
- **Ocultação da Informação:** Este é o objetivo do encapsulamento. A ideia é proteger os dados internos (atributos) de um objeto contra acesso direto e manipulação indevida. O objeto deve ser como uma "caixa-preta": você sabe o que ele faz (sua interface pública), mas não precisa saber como ele faz.

## Modificadores de Acesso

- **`public`:** Visível para todos, em qualquer classe ou pacote. Usado em construtores, getters, setters e outros métodos que formam a "interface" do objeto.
- **`private`:** Visível apenas dentro da própria classe. Usado em atributos.
- **`protected`:** Visível na classe, no mesmo pacote e para classes filhas. Tem relação com a herança em POO.
- **`default`:** Visível apenas para classes dentro do mesmo pacote. Usado em classes auxiliares que só fazem sentido dentro de um mesmo "módulo".

## Getters e Setters

Para permitir um acesso seguro aos atributos `private`, criamos métodos `public` específicos:

- **Getters:** Métodos que retornam o valor de um atributo. Não recebem parâmetros. Usa-se `is` em vez de `get` para `booleanos`.
- **Setters:** Métodos que alteram o valor de um atributo. recebem um parâmetro com o novo valor e geralmente não retornam nada (`void`).

```Java
public class Pessoa {
    private String nome;

    // Getter para o atributo "nome"
    public String getNome() {
        return this.nome;
    }

    // Setter para o atributo "nome"
    public void setNome(String nome) {
        this.nome = nome; // "this" diferencia o atributo do parâmetro
    }
}
```

## Criando e Usando Objetos

- **Instanciação:** É o ato de criar um objeto a partir de uma classe. Usamos a palavra-chave  `new`.

```Java
// Sintaxe: NomeDaClasse nomeDaVariavel = new NomeDaClasse();
Carro meuCarro = new Carro();
```
- **Construtores:** São métodos especiais com o mesmo nome da classe, sem tipo de retorno. São executados automaticamente quando um objeto é criado com `new`. Sua principal função é inicializar os atributos, garantindo que o objeto já nasça em um estado válido e consistente. O Java fornece um **construtor padrão** (sem parâmetros) automaticamente.
    - **Sobrecarga de Construtores:** É possível ter vários construtores na mesma classe, desde que suas listas de parâmetros sejam diferentes. isso é uma forma de **Polimorfismo**.
    - **Chamando Construtores com `this()`:** Um construtor pode chamar outro construtor da mesma classe usando `this(...)`. Isso deve ser a primeira linha de código e serve para reaproveitar lógica e evitar código repetido.

### Exemplo de Sobrecarga

```Java
public class Pessoa {
    private String nome;
    private int idade;

    // Construtor padrão
    public Pessoa() {
        this.nome = "Sem nome";
        this.idade = 0;
    }

    // Construtor com parâmetros
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Construtor chamando outro com this()
    public Pessoa(String nome) {
        this(nome, 0); // Chama o construtor acima
    }
}
```