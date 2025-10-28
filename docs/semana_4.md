# Semana 4 - Métodos e Framework de Coleções em Java

## 1. Métodos Genéricos

**Conceito:** Os Generics (Tipos Genéricos) são um recurso essencial do Java que permite que tipos, como classes e interfaces, sejam utilizados como parâmetros na definição de outras classes, interfaces e métodos. O objetivo principal é criar códigos que possam ser reutilizados para diferentes tipos de dados, ao mesmo tempo que garantem a segurança de tipo (type safety) em tempo de compilação.

Antes da introdução dos Generics, classes de coleções como `ArrayList` armazenavam referências do tipo `Object`. Como `Object` é a superclasse de todos os objetos em Java, isso permitia que qualquer tipo de dado fosse inserido em uma mesma lista (por exemplo, um `Integer` e uma `String`). Isso criava dois problemas: primeiro, exigia uma conversão explícita (casting) ao recuperar os elementos (ex: `String s = (String)lista.get(0);`); segundo, podia causar erros em tempo de execução (`ClassCastException`) se o tipo recuperado não fosse o esperado. Com Generics, um programador pode declarar `List<String>`. O compilador então garante que apenas objetos `String` sejam adicionados, eliminando a necessidade de casting e movendo a verificação de tipo do tempo de execução para o tempo de compilação.

**Sintaxe e Classes Empacotadoras:** A sintaxe dos genéricos utiliza colchetes angulares (`<>`). Por exemplo, uma classe genérica simples pode ser definida como `public class Caixa<T> { ... }`, onde `T` é o parâmetro de tipo, Ao instanciar, o tipo real é fornecido: `Caixa<Integer> c = new Caixa<Integer>();`. Uma limitação importante é que Generics não aceitam tipos primitivos (como `int` ou `double`). Para contornar isso, devem ser usadas as classes empacotadoras (wrapper) correspondentes (como `Integer` ou `Double`). O Java facilita esse processo através do *autoboxing* (a conversão automática de um primitivo para seu objeto empacotador, ex: `int` para `Integer`) e *auto-boxing* (a conversão inversa, ex: `Integer` para `int`).

**Métodos Genéricos e Herança:** Métodos também podem ser genéricos, independentemente de sua classe ser genérica. Isso é feito declarando um parâmetro de tipo antes do tipo de retorno do método (por exemplo, `public static <T> void imprimirArray(T[] array)`). No que tange à herança, é possível herdar de classes genéricas. Por exemplo, a classe `ArrayList<E>` implementa a interface `List<E>`, que por sua vez herda de `Collection<E>`. É fundamental notar que não há relação de herança entre os tipos genéricos em si; por exemplo, um `List<Integer>` *não* é considerado uma subclasse de `List<Number>`, embora `Integer` seja uma subclasse de `Number`.

### Exemplo de Generics ###

```Java
// 1. Usando Genercis em Coleções (Segurança de Tipo)
List<String> nomes = new ArrayList<String>();
nomes.add("Maria");
nomes.add("João");
// nomes.add(10); // Erro de compilação! O compilador protege a lista.

String primeiroNome = nomes.get(0); // Não precisa de (String) casting.
System.out.println(primeiroNome.toUpperCase()); // Saída: MARIA

// 2. Usando Generics com Autoboxing
List<Integer> numeros = new ArrayList<>();
numeros.add(10); // Autoboxing: o int 10 vira um objeto Integer
int primeiroNumero = numeros.get(0); // Auto-unboxing: o Integer vira int
```

## 2. Framework de Coleções (Collections Framework)

**Conceito:** O Framework de Coleções, localizado no pacote `java.util`, é uma arquitetura unificada e robusta para armazenar e manipular grupos de objetos. Ele é composto por interfaces (que definem os tipos abstratos de coleções), implementações (as classes concretas que fornecem as estruturas de dados, como listas ou conjuntos) e algoritmos (métodos estáticos para realizar operações como classificação ou busca). Diferente dos arrays, as coleções são estruturas de dados dinâmicas, podendo crescer ou diminuir de tamanho conforme a necessidade.

**Interface `Collection`:** Esta é a interface raiz da hierarquia (excluindo `Map`). Ela define os métodos comuns que todas as coleções devem implementar, como `add(E elemento)`, `remove(Object elemento)`, `size()` e `isEmpty()`. As principais subinterfaces que herdam dela são `List`, `Set` e `Queue`.

**Interface `List`:** Representa uma coleção ordenada (também chamada de sequência) que permite o armazenamento de elementos duplicados. Sua principal característica é o controle preciso sobre a posição dos elementos através de um índice numérico (baseado em zero), similar a um array.
- **Implementações:** As duas implementações mais comuns são `ArrayList` e `LinkedList`.
    - `ArrayList`: É baseada internamente em um array redimensionável. Oferece acesso aleatório muito rápido (operações `get` e `set` pelo índice), mas é mais lenta para inserções e remoções no meio da lista.
    - `LinkedList`: É baseada em uma lista duplamente encadeada. É extremamente eficiente para inserções e remoções em qualquer ponto da lista (especialmente no início e no fim), mas é lenta para acesso aleatório, pois pode exigir a travessia da lista.

**Interface `Set`:** Representa uma coleção que não permite elementos duplicados, modelando a abstração matemática de um conjunto.
- **Implementações:** A implementação mais comum é `HashSet`, que utiliza uma tabela de hash para armazenar seus elementos. Ela oferece desempenho muito rápido para adição (`add`) e verificação de contenção (`contains`), mas não oferece nenhuma garantia sobre a ordem de iteração dos elementos. `LinkedHashSet` é uma alternativa que mantém a ordem em que os elementos foram inseridos.

**Interface `Queue`:** É uma coleção projetada para manter elementos antes de seu processamento. Geralmente, mas não obrigatoriamente, segue a ordem FIFO (First-In, First-Out).

**Interface `Map`:** Embora não herde diretamente da interface `Collection`, a `Map` é uma parte essencial do framework. Ela mapeia chaves únicas e valores (pares chave-valor) e não pode conter chaves duplicadas. Implementações comuns incluem `HashMap` (baseada em hash, não ordenada), `TreeMap` (baseada em árvore, armazena chaves ordenadas) e `Hashtable` (uma implementação legada e sincronizada).

### Exemplo de Coleções (List vs Set)

```Java
// 1. Exemplo de List (permite duplicatas e mantém ordem de inserção)
List<String> listaNomes = new ArrayList<>();
listaNomes.add("Ana");
listaNomes.add("Carlos");
listaNomes.add("Ana"); // Duplicata permitida
System.out.println(listaNomes); // Saída: [Ana, Carlos, Ana]

// 2. Exemplo de Set (não permite duplicatas e não garante ordem)
Set<String> setNomes = new HashSet<>();
setNomes.add("Ana");
setNomes.add("Carlos");
setNomes.add("Ana"); // Duplicata ignorada
System.out.println(setNomes); // Saída (ordem não garantida): [Ana, Carlos]
```

## 3. Manipulação de Coleções: Iteradores e Algoritmos

**Iteradores(`Iterator`):** A interface `Iterator` fornece uma maneira uniforme e padronizada de percorrer os elementos de qualquer coleção, independentemente de sua implementação concreta (`ArrayList`, `HashSet`, etc). Um iterador é obtido chamando o método `iterator()` em qualquer objeto `Collection`.
- **Métodos Principais:** Seus três métodos são `boolean hasNext()`, que retorna `true`se houver mais elementos na iteração; `E next()`, que retorna o próximo elemento; e `void remove()`, que remove da coleção o último elemento retornado por `next`.
- **Remoção Segura:** O método `remove()` do `Iterator` é a **única maneira segura** de remover elementos de uma coleção *enquanto* ela está sendo iterada. Tentar remover elementos usando o método `remove()` da própria coleção dentro de um loop (`for` ou `while`) pode causar um comportamento indefinido ou lançar uma `ConcurrentModificationException`.

**A Classe `Collections`:** É importante não confundir com a interface `Collection`. A classe `java.util.Collections` (com "s" no final) é uma classe utilitária final que consiste exclusivamente em métodos estáticos, chamados de algoritmos polimórficos, que operam sobre coleções.
- **Algoritmos Comuns:**
    - `sort(List<T> list)`: Classifica (ordena) os elementos de uma `List` em ordem ascendente.
    - `binarySearch(List list, T key)`: Realiza uma busca binária de alta eficiência em uma `List` que deve estar *previamente ordenada*.
    - `reverse(List<?> list)`: Inverte a ordem dos elementos na lista.
    - `shuffle(List<?> lista)`: Reordena aleatoriamente os elementos da lista (útil para jogos ou simulações).
    - `fill(List list, T obj)`: Substitui todos os elementos existentes na lista por um objeto especificado.
    - `frequency(Collection c, Object o)`: Conta o número de vezes que um elemento específico aparece na coleção.
    - `copy(List dest, List src)`: Copia os elementos da lista de origem (`src`) para a lista de destino (`dest`).

### Exemplo de Iterador e Algoritmo

```Java
List<String> frutas = new ArrayList<>();
frutas.add("Banana");
frutas.add("Maçã");
frutas.add("Uva");

// 1. Exemplo de Algoritmo (Collections.sort)
Collections.sort(frutas); // Ordena a lista
System.out.println(frutas); // Saída: [Banana, Maçã, Uva]

// 2. Exemplo de Iterador (para percorrer)
Iterator<String> itr = frutas.iterator();
while (itr.hasNext()) {
    String fruta = itr.next();
    System.out.println(fruta);
    /* if (fruta.equals("Maçã")) {
            itr.remove(); // Esta é a forma correta de remover durante a iteração
       } */
}
```