# Semana 1 - Paradigmas de Programação; Introdução ao Paradigma Orientado a Objetos; Java e Frameworks de Desenvolvimento

## Aula 1 - Paradigmas de Programação e Introdução à POO

### Paradigmas de Programação

- Forma de **classificar** as linguagens de programação baseada em suas **funcionalidades:**
   - **Procedural:** Baseado em uma sequência de procedimentos ou rotinas. Um conjunto de passos computacionais a serem executados.
    - **Funcional:** Trata a computação como uma avaliação de funções matemáticas. Sequência de funções executadas de modo empilhado.
    - **Declarativo:** Focado em "o que" fazer, e não em "como" fazer. Programador modela o problema por meio de assertivas em relação aos objetos do universo em questão(ex:SQL, HTML).
    - **Programação Orientada a Objetos:** é baseado na composição e interação entre várias unidades conhecidas como objetos.


### Conceitos Chave da POO

- Todos os componentes de um programa são considerados objetos. Os programas acabam sendo basicamente interações entre objetos, o que faz com que surjam padrões comuns.
- **Objeto:** Possui estado, identidade e comportamento.
- **Abstração:** O conceito de esconder detalhes irrelevantes e focar no essencial (ex: um usuário não precisa saber de mecânica para dirigir um carro).
- **Encapsulamento:** Proteger a parte interna de um código, expondo apenas uma interface bem definida para interação.

## Aula 2 - Java e Frameworks de Desenvolvimento

- Linguagem que é orientada a objetos, foi desenvolvida pela Sun (hoje Oracle), modelada no C++ e projetada para ser portável (funcionar em diferentes OS).
- **Processo de Compilação:**
    1. **Edição:** Inserção do código usando um editor em arquivo **.java**.
    2. **Compilação:** O compilador (**javac**) transforma o código em **bytecodes**, que são salvos em um arquivo **.class**. Representam as tarefas a serem executadas na fase de execução.
    3. **Carrega o programa Java em memória:** A **JVM** (Java Virtual Machine) armazena o programa em memória para executá-lo, efetuando o seu carregamento.
    4. **Verificar os bytecodes:** Enquanto as classes são carregadas, o verificados examina seus bytecodes para t er certeza que são válidas.
    5. **Execução:** A JVM carrega os bytecodes e os interpreta ou compila (usando JIT - Just-in-Time) para a linguagem de máquina do computador, executando o programa
- **Ambiente de Desenvolvimento**
    - **JDK (Java Development Kit):** é o kit de desenvolvimento essencial. Contém o **compilador(javac)**, a **máquina virtual(java/JVM)** e as bibliotecas padrão. É a "caixa de ferramentas" obrigatória para programar em Java.
    - **IDE (Integrated Development Environment):** É o software que facilita a escrita do código. No caso, optamos por usar o **VSCode**.
