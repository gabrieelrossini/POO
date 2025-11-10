# Semana 1 - Paradigmas de Programação; Introdução ao Paradigma Orientado a Objetos; Java e Frameworks de Desenvolvimento

## Paradigmas de Programação e Introdução à POO

### Paradigmas de Programação

Forma de **classificar** as linguagens de programação baseada em suas **funcionalidades:**

- **Procedural:** Baseado em uma sequência de procedimentos ou rotinas. Um conjunto de passos computacionais a serem executados.
- **Funcional:** Trata a computação como uma avaliação de funções matemáticas. Sequência de funções executadas de modo empilhado.
- **Declarativo:** Focado em "o que" fazer, e não em "como" fazer. Programador modela o problema por meio de assertivas em relação aos objetos do universo em questão(ex:SQL, HTML).
- **Programação Orientada a Objetos:** é baseado na composição e interação entre várias unidades conhecidas como objetos.


### Conceitos Chave da POO

Todos os componentes de um programa são considerados objetos. Os programas acabam sendo basicamente interações entre objetos, o que faz com que surjam padrões comuns.

- **Objeto:** Possui estado, identidade e comportamento.
- **Abstração:** O conceito de esconder detalhes irrelevantes e focar no essencial (ex: um usuário não precisa saber de mecânica para dirigir um carro).
- **Encapsulamento:** Proteger a parte interna de um código, expondo apenas uma interface bem definida para interação.
- **Herança:** Uma classe mais específica (subclasse/filha) herda atributos e métodos de uma classe mais genérica (superclasse/mãe).
- **Polimorfismo:** Capacidade de objetos de diferentes classes responderem à mesma mensagem (chamada de método) de maneiras específicas para cada classe.

## Java e Frameworks de Desenvolvimento

Linguagem que é orientada a objetos, foi desenvolvida pela Sun (hoje Oracle), modelada no C++ e projetada para ser portável (funcionar em diferentes OS).

- **Processo de Compilação:**

    1. **Edição:** Inserção do código usando um editor em arquivo `.java`.
    2. **Compilação:** O compilador (`javac`) transforma o código em **bytecodes**, que são salvos em um arquivo `.class`. Representam as tarefas a serem executadas na fase de execução.
    3. **Carrega o programa Java em memória:** A **JVM** (Java Virtual Machine) armazena o programa em memória para executá-lo, efetuando o seu carregamento.
    4. **Verificar os bytecodes:** Enquanto as classes são carregadas, o verificados examina seus bytecodes para ter certeza que são válidas.
    5. **Execução:** A JVM carrega os bytecodes e os interpreta ou compila (usando JIT - Just-in-Time) para a linguagem de máquina do computador, executando o programa

- **Ambiente de Desenvolvimento**

    - **JDK (Java Development Kit):** é o kit de desenvolvimento essencial. Contém o **compilador**(`javac`), a máquina virtual(`java`/**JVM**) e as bibliotecas padrão. É a "caixa de ferramentas" obrigatória para programar em Java.
    - **IDE (Integrated Development Environment):** É o software que facilita a escrita do código. No caso, optamos por usar o **VSCode**.

- **Como Compilar o Código**

    1. **Escrever o Código:** Criar o arquivo de texto com o código-fonte (ex:`Teste.java`).
    2. **Abrir o Terminal:** Navegar até a pasta raiz do projeto.
    3. **Compilar:** Executar o comando `javac`.
        - **Exemplo:** `javac src/Teste.java`
        - **O que faz:** Invoca o compilador do JDK, que lê o arquivo `.java`, verifica se há erros de sintaxe e, se estiver tudo certo, traduz para `bytecode`, criando o arquivo `Teste.class` na mesma pasta.
    4. **Executar:** Executar o comando `java`.
        - **Exemplo:** `java src.Teste`
        - **O que faz:** Invoca a JVM, que carrega o `bytecode` do arquivo `.class`, verifica, e o executa.(Lembre-se: no comando `java`, usamos o nome do pacote e da classe, sem a extensao `.class`).

### Exemplo de Código

```Java
// Meu primeiro programa em Java

public class Teste {
    public static void main(String[] args) {
        System.out.println("É apenas um teste!");
    }
}
```

**Análise do Código:**
- `public class Teste`:
    - `class`: Palavra-chave que define o início de uma **classe**. Pense na classe como um **molde** ou um projeto para criar objetos. Todo código em Java deve estar dentro de uma classe.
    - `Teste`: É o nome que demos à nossa classe. Por convenção, nomes de classes sempre começam com letra maiúscula. O nome do arquivo (`.java`) deve ser idêntico ao nome da classe pública.
    - `public`: É um "modificador de acesso". `public` significa que esta classe pode ser acessada por qualquer outra parte do seu projeto.
- `public static void main(String[] args)`:
    - Esta linha inteira define o **método principal** (main method). É o **ponto de partida** do programa. Quando você manda executar o código, é aqui que a JVM começa a trabalhar.
    - `public`: Assim como na classe, significa que este método pode ser chamado de qualquer lugar.
    - `static`: Significa que o método pertence à classe `Teste` em si, não a um objeto criado a partir dela. Isso permite que a JVM execute o método sem precisar criar uma instância da classe `Teste` primeiro.
    - `void`: Indica que este método **não retorna** nenhum valor após sua execução.
    - `main`: É o nome padrão que a JVM procura para iniciar a execução.
    - `(Strings[] args)`: Define um parâmetro para o método. Ele permite que o programa receba argumentos da linha de comando (algo que não usaremos agora, mas é obrigatório na assinatura do método).
- `System.out.println("É apenas um teste!);`:
    - Esta é a instrução que **efetivamente realiza uma ação**.
    - `System`: É uma **classe nativa do Java** que nos dá acesso a recursos do sistema.
    - `out`: É um objeto dentro da classe `System` que representa a saída padrão (geralmente, o terminal ou console).
    - `println()`: É um **método** do objeto `out` que imprime o texto passado entre parênteses no console e depois pula uma linha (`ln` = line).
    - `;`: Todo comando ou instrução em Java deve terminar com um ponto e vírgula.