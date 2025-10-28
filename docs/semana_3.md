# Semana 3 - Herança e Polimorfismo

## 1. Herança

**Conceito:** A herança descreve uma relação "é um" entre classes, onde uma classe mais específica (subclasse/filha) herda atributos e métodos de uma classe mais genérica (superclasse/mãe). Isso permite que características comuns sejam definidas uma única vez na superclasse e reutilizadas pelas subclasses. As subclasses podem então adicionar seus próprios atributos e métodos, tornando-se versões especializadas da superclasse.

**Implementação em Java:** A palaca chave `extends` é usada para estabelecer a herança.

``` Java
public class Pessoa {
    // ... atributos e métodos ...
}

public class Estudante extends Pessoa {
    // ... atributos e métodos adicionais ...
}
```

Aqui, `Estudante` herda de `Pessoa`.

**Regras e Vantagens:**

- **Reuso de Código:** Evita a repetição de código comum.
- **Especialização:** Permite adicionar características específicas às subclasses.
- **Relação "É um":** Todo objeto da subclasse é também um objeto da superclasse (mas o contrário não é válido). Por exemplo, um `Estudante` é uma `Pessoa`.
- **Membros Herdados:** A classe filha herda todos os membros `public` e `protected` da classe mãe. Membros `private` são herdados, mas ficam "ocultos", não sendo acessíveis diretamente.
- **Construtores:** Não são herdados. A subclasse *deve* chamar um construtor da superclasse usando `super()` se a superclasse tiver um construtor explícito.
- **Hierarquia:** A herança pode ocorrer em cascata (Ex: `Animal` -> `Cachorro` -> `CachorroComPedigree`).

## 2. Polimorfismo

**Conceito:** Significa "muitas formas". É a capacidade de objetos de diferentes classes responderem à mesma mensagem (chamada de método) de maneiras específicas para cada classe. Isso aumenta a flexibilidade e extensibilidade do código.

### Tipos Principais em Java:

- **Sobrescrita (Overriding - Polimorfismo Dinâmico):**
    - Ocorre quando uma subclasse redefine um método herdado da superclasse, mantendo **exatamente a mesma assinatura** (mesmo nome, mesmos tipos e ordem de parâmetros) e mesmo tipo de retorno.
    - **Comportamento:** A implementação da subclasse tem precedência e passa a ser o comportamento padrão para objetos dessa subclasse.
    - **Busca da JVM:** Em tempo de execução, a JVM procura o método começando pela classe do objeto e subindo na hierarquia até encontrar a primeira implementação.
    - **Palavra `super`:** Dentro do método sobrescrito na subclasse, `super.nomeDoMetodo()` pode ser usado para invocar a implementação original da superclasse.
- **Sobrecarga (Overloading - Polimorfismo Estático):**
    - Ocorre quando existem vários métodos com o **mesmo nome** dentro da **mesma classe**, mas com **assinaturas diferentes**(diferente número, tipo, ou ordem de parâmetros).
    - **Comportamento:** Permite que um mesmo nome de método realize operações ligeiramente diferentes dependendo dos argumentos fornecidos.
    - **Decisão:** O compilador decide qual método chamar com base nos argumentos fornecidos na chamada (em tempo de compilação).

## 3. Palavras-Chave Importantes (`this` e `super`):

- **`this`:** Refere-se à instância atual do objeto. É usado principalmente para:
    - Desambiguar entre atributos da classe e parâmetros de métodos/construtores com o mesmo nome (Ex: `this.nome = nome`.)
    - Chamar outro construtor da mesma classe (`this(...)`).
- **`super`:** Refere-se à superclasse imediata. É usado principalmente para:
    - Chamar o construtor da superclasse a partir do construtor da subclasse(`super(...)`).
    - Chamar um método da superclasse que foi sobrescrito na subclasse(`super.nomeDoMetodo()`).

## 4. Restringindo Modificações: Classes e Métodos `final`

- **Conceito:** O modificador `final` impede alterações.
- **Atributos `final`:** Tornam-se constantes após a inicialização (seja na declaração, em um bloco de inicialização ou no construtor).
- **Métodos  `final`:** Não podem ser sobrescritos por subclasses. Garante que o comportamento do método não será alterado na hierarquia. Métodos `private` são implicitamente `final`.
- **Classes  `final`:** Não podem ser herdadas (estendidas). Útil para classes cujo design não prevê especialização.

O modificador `final` pode ser aplicado a classes, métodos e atributos.

## 5. Abstração: Classes Abstratas e Interfaces

### Classes Abstratas:

- Declaradas com `abstract`. Não podem ser instanciadas.
- Servem como superclasses para fornecer uma estrutura comum e compartilhar código (atributos e métodos concretos).
- Podem conter **métodos abstratos** (declarados com `abstract` e sem corpo).
- Subclasses concretas **devem** implementar todos os métodos abstratos herdados.

### Interfaces:

- Definem um "contrato" de métodos que uma classe deve implementar (usando `implements`).
- Garantem que classes diferentes possam ser tratadas de forma polimórfica se implementarem a mesma interface.
- Uma classe pode implementar **múltiplas** interfaces.
- Tradicionalmente continham apenas constantes e métodos abstratos, mas versões mais recentes do Java permitem métodos `default` e `static` com implementação.
- Diferentes classes podem implementar os métodos da interface de maneiras completamente distintas.