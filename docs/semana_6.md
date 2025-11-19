# Semana 6 - Tratamento de Exceções em Java

## 1. Conceito de Exceção

Uma exceção em Java representa um evento anormal que interrompe o fluxo normal de execução de um programa. Quando ocorre, a JVM cria um objeto derivado da classe `Throwable` e o "lança". O sistema de execução então busca, na pilha de chamadas, o primeiro bloco `catch` capaz de tratar esse tipo de exceção. Se nenhum tratamento for ecnontrado até o método `main`, o programa é encerrado com um rastreamento de pilha (`stack trace`). O tratamento adequado de exceções permite substituir mensagens técnicas por respostas compreensíveis, aumentando a robustez e experiência do usuário.

## 2. Erro vs Exceção

- **Erro (`Error`):** Representa falhas graves no ambiente de execução (ex: `OutOfMemoryError`, `StackOverflowError`). São condições **não recuperáveis** e, por isso, **não devem ser tratadas** em código de aplicação.
- **Exceção (`Exception`):** Representa situações anormais, mas **potencialmente recuperáveis**, como divisão por zero ou leitura de arquivo inexistente. São eventos que o programador pode antecipar e tratar de forma controlada.

## 3. Hierarquia de Exceções

A raiz da hierarquia é a classe `Throwable`. Dela derivam duas subclasses principais:

- **`Error`:** Falhas do sistema/JVM
- **`Exception`:** Condições tratáveis pelo programa.

`Exception` se ramifica em:

- **Exceções verificadas (checked):** todas as subclasses de `Exception` **exceto** as que herdam de `RuntimeException`.
- **Exceções não verificadas (unchecked):** incluem `RuntimeException` e `Error`.

Essa distinção determina se o compilador exige tratamento explícito.

## 4. Exceções Verificadas (Checked Exceptions)

São exceções que o compilador **obriga a tratar ou declarar**. Representam situações externas ao controle direto do código (ex: falhas de I/O, ausência de rede). Devem ser capturadas com `try-catch` ou repassadas com `throws`. Esse mecanismo força o programador a considerar cenários de falha desde o projeto.

### Exemplo de Código

```Java
// Exemplo: IOException é uma exceção verificada
public void lerArquivo() throws IOException {
    FileReader reader = new FileReader("dados.txt");
    // ...
}
```

## 5. Exceções Não Verificadas (Unchecked Exceptions)

Incluem `RuntimeException` e suas subclasses (Ex: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`).

Decorrem, na maioria dos casos, de **falhas lógicas** (ex: usar referência nula, índice inválido). Embora o compilador não as exija, boas práticas recomendam tratá-las quando há risco previsível.

```Java
// Exemplo: ArithmeticException (não verificada)
public int dividir (int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Divisão por zero.");
    }
    return a / b;
}
```

## 6. Estrutura `try-catch-finally`

- **`try`:** Delimita o bloco de código passível de lançar exceções.
- **`catch`:** Define rotinas de tratamento para tipos específicos de exceção. Pode haver múltiplos blocos e, desde o Java7, é possível tratar vários tipos no mesmo bloco com sintaxe `catch(TipoA | TipoB e)`.
- **`finally`:** Bloco **sempre executado**, independentemente de exceção, `return` ou `break`. É o local ideal para **liberação de recursos** (ex: fechar streams). Só é ignorado se o programa for encerrado abruptamente com `System.exit()`.

### Exemplo de Código

```Java
Scanner scanner = new Scanner (System.in);
try {
    int valor = scanner.nextInt();
    System.out.printf("Valor lido: %d%n", valor);
}
catch (InputMismatchException e) {
    System.err.println("Entrada inválida: esperado um número inteiro.");
}
finally {
    scanner.close(); // Liberação garantida
}
```

## 7. Repasse com `throws` e Lançamento com `throw`

- **`throws`:** Declaração na assinatura do método indicando que ele **pode lançar** uma exceção verificada. Transfere a responsabilidade de tratamento ao chamador. Obrigatório para exceções verificadas; opcional (e documental) para não verificadas.
- **`throw`:** Instrução que **lança explicitamente** um objeto de exceção em tempo de execução. Pode ser usada para **validar** pré-condições, por exemplo.

### Exemplo de Código

```Java
public void validarIdade(int idade) throws IllegalArgumentException {
    if (idade < 0) {
        throw new IllegalArgumentException("Idade não pode ser negativa.");
    }
}
```

## 8. Exceções Personalizadas

Para modelar condições específicas de domínio, define-se uma nova classe de exceção:

- Herdar de `Exception`: Exceção verificada.
- Herdar de `RuntimeException`: Exceção não verificada.
- Nome deve terminar em "Exception" (convenção).
- Recomenda-se incluir:
    - Construtor padrão;
    - Construtor com mensagem (`String`);
    - Construtor com mensagem e causa (`String`, `Throwable`) - para suporte a encadeamento

### Exemplo de Código

```Java
// Exemplo: exceção personalizada não verificada
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException (String mensagem) {
        super(mensagem);
    }
}
```

## 9. Exceções Encadeadas (Chained Exceptions)

Quando uma camada do sistema captura uma exceção de baixo nível e lança outra mais contextualizada, o **encadeamento** preserva o histórico original. Isso é feito passando a exceção original como argumento ao construtor da nova exceção. O rastreamento resultante mostra claramente a cadeia causal com linhas "Caused by", facilitando a depuração.

### Exemplo de Código

```Java
try {
    // operação que lança IOException
}
catch (IOException causa) {
    throw new MinhaExcecaoNegocio ("Falha ao processar arquivo", causa);
}
```

## 10. Modelo de Terminação

Java adota o **modelo de terminação:** após o tratamento em um bloco `catch`, a execução **não** retorna ao ponto onde a exceção foi lançada. Em vez disso, prossegue após o bloco `try-catch-finally`. Isso implica que qualquer lógica condicional precisa ser estruturada para continuar após o tratamento, não dentro do `try`.

## 11. Desempilhamento da Pilha (Stack Unwinding)

Quando uma exceção não é tratada em um método, ele é **encerrado imediatamente**, suas variáveis locais são descartadas e a exceção sobe para o método chamador. Esse processo repete-se até que um `catch` apropriado seja encontrado ou o programa termine. Esse mecanismo permite **centralizar o tratamento** em pontos estratégicos da aplicação.

## 12. Métodos de Diagnóstico em `Throwable`

Todo objeto de exceção herda métodos úteis para diagnóstico:
- **`getMessage()`:** Retorna a mensagem descritiva associada à exceção.
- **`printStackTrace()`:** Imprime a pilha de chamadas completa no fluxo de erro (`System.err`).
- **`getStackTrace()`:** Retorna um array de `StackTraceElement`, permitindo **log personalizado** ou análise programática.

### Exemplo de Código

```Java
try {
    // ...
}
catch (Exception e) {
    System.err.printf("Erro: %s%n", e.getMessage());
    e.printStackTrace(); // Para depuração
}
```