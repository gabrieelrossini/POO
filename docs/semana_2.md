# Semana 2 - Classes e Objetos; Encapsulamento e Ocultação da Informação

## Conceitos-Chave

### Classe

- **Definição:** É um "molde" ou um modelo que descreve as características (**atributos**) e os comportamentos (**métodos**) que um conjunto de objetos semelhantes terá. É uma abstração, não algo concreto.
- **Exemplo:** Em um sistema de cadastro, a classe `Cliente` define que todo cliente terá um `nome`, um `cpf` e um `email` (atributos). Ela também define que será possível `fazerLogin()` e `atualizarEndereco()` (métodos).
- **Conexão:** A classe é o ponto de partida. Sem ela, não podemos criar objetos. Ela é o "tipo" do objeto.

### Objeto

- **Definição:** É uma entidade econcreta, uma "instância" de uma classe. Enquanto a classe é o molde, o objeto é o item real criado a partir dele. Cada objeto tem sua própria identidade, estado (valores dos atributos) e comportamento.
- **Exemplo:** `cliente1 = new Cliente()` cria um objeto concreto do tipo `Cliente`. Este `cliente1` pode ter o nome "João Silva", enquanto outro objeto, `cliente2`, pode ter o nome "Maria Souza". Ambos são do tipo `Cliente`, mas são instâncias independentes.
- **Conexão:** Objetos são a materialização das classes e são eles que efetivamente executam as ações e armazenam as informações em um programa.

### Atributos e Métodos

- **Definição:** Atributos (também chamados de variáveis de instância) definem o estado de um objeto (suas características). Métodos definem o comportamento de um objeto (o que ele pode fazer).
- **Exemplo:** Na classe `Carro`, os atributos seriam `cor`, `velocidadeAtual` e `tamanhoDoTanque`. Os métodos seriam `acelerar()`, `frear()` e `abastecer()`.
- **Conexão:** Atributos e métodos estão intrinsecamente ligados. Os métodos geralmente servem para manipular ou consultar os valores dos atributos (por exemplo, o método `acelerar()` modifica o atributo `velocidadeAtual`).

### Encapsulamento e Ocultação da Informação (Information Hiding)

- **Definição:** Encapsulamento significa agrupar atributos e métodos dentro de uma classe, tratando-os como uma única unidade. A ocultação da informação é o princípio de proteger os dados (atributos) de acesso direto e indevido, forçando a interação através de métodos públicos (`getters` e `setters`).
- **Exemplo:** Um atributo `salario` em uma classe `Funcionario` é declarado como `private`. Para acessá-lo ou modificá-lo, outras partes do programa devem usar os métodos públicos `getSalario()` e `setSalario()`.
- **Conexão:** O encapsulamento é o ato de "encapsular" tudo que está relacionado em um só lugar (classe), já ocultação da informação é a ideia de esconder a complexidade interna de um objeto do mundo exterior e proteger os dados internos contra manipulações indevidas.

### Construtores

- **Definição:** É um tipo especial de método que tem o mesmo nome da classe e é chamado automaticamente quando um objeto é criado (com a palavra chave `new`). Sua função é inicializar os atributos do objeto.
- **Exemplo:** `public Conta(String nomeCliente, double saldoInicial)` é um construtor que garante que todo novo objeto `Conta` já seja criado com um nome e um saldo definidos.
- **Conexão:** Construtores asseguram que um objeto já nasça em um estado válido e consistente.

### Pontos de Atenção

- **`private` vs `public`:** Entender modificadores de acesso é crucial. Dados (`atributos`) devem ser quase sempre `private`. Métodos que outras partes do sistema precisam usar (`serviços`) devem ser `public`.
- **A palavra-chave `this`:** Dentro de um método ou construtor, `this` é usado para se referir ao objeto atual. É frequentemente usado para diferenciar uma variável de instância de um parâmetro de método com o mesmo nome (ex: `this.name = name;).
- **Diferença entre Tipos Primitivos e Tipos por Referência:** Variáveis de tipos primitivos (`int`, `double`, `boolean`) armazenam o valor diretamente. Variáveis de tipos por referência (`String`, `Scanner`, ou qualquer objeto que você criar) armazenam o endereço de memória onde o objeto está. Isso tem implicações importantes em como os dados são passados para os métodos.
- **Métodos `set` e `get` (Setters e Getters):** Forma padrão de implementar o encapsulamento, permitindo acesso controlado aos atributos privados.

### Modificadores de Acesso em Java

- **`public`:** Visível para qualquer outra classe, em qualquer pacote, é o nível menos restritivo. Usado em métodos que formam a interface do seu objeto (os "serviços" que ele oferece), como `getters`, `setters` e construtores.
- **`private`:** Visível apenas dentro da pŕopria classe onde foi declarado. Nenhuma outra classe pode ver ou acessar. Usado em atributos (variáveis de instância). Isso força o uso de métodos `public` (get/set) para manipular os dados, garantindo a ocultação da informação.
- **`protected`:** Visível dentro da própria classe, para outras classes no mesmo pacote e para **subclasses (herdeiros)**, mesmo que estejam em pacotes diferentes. Usado em herança, quando você quer que a classe filha tenha acesso direto a um método ou atributo da classe mãe, mas ainda quer protegê-la do resto do mundo.
- **`default` ou `package-private`:** Modificador padrão. Visível para todas as classes que estão no mesmo pacote. Útil para classes ou membros que são "ajudantes" e só precisam ser vistos por outras classes dentro do mesmo conjunto lógico de funcionalidades (pacote).

### Síntese Final

- **Classes** são os **moldes** e **Objetos** são as **intâncias concretas criadas** a partir desses moldes. O poder da POO vem de agrupar dados (atributos) e comportamentos (métodos) juntos e protegê-los com o encapsulamento, tornando o código mais seguro e reutilizável.
- **Obs:** O texto-base utilizado nessa semana foi o mesmo da semana anterior.