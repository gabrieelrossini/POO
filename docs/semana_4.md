# Semana 4 - Métodos e Framework de Coleções em Java

## 1. Generics (Tipos Genéricos, Métodos e Curingas)

**Conceito:** Generics (Tipos Genéricos) é um recurso essencial do Java que permite que tipos (classes e interfaces) sejam usados como parâmetros na definição de outras classes, interfaces e métodos. O objetivo principal é criar códigos que possam ser reutilizados para diferentes tipos de dados, garantindo a segurança de tipo (type safety) em tempo de compilação. Antes dos Generics, coleções como `ArrayList` armazenavam referências do tipo `Object`, o que permitia misturar tipos (ex: `Integer` e `String`) e exigia uma conversão explícita (casting) ao recuperar elementos (ex: `String s = (String)lista.get(0);`). Isso era perigoso, pois podia causar erros em tempo de execução (`ClassCastException`). Com Generics, ao declarar `List<String>`, o compilador garante que apenas *strings* sejam adicionados, eliminando a necessidade de casting e movendo a verificação de tipo para a compilação.

A sintaxe usa colchetes angulares (`<>`), onde `T` é um parâmetro de tipo comum (ex: `public class Caixa<T> { ... }`). Generics não aceitam tipos primitivos (como `int`); devem ser usadas as classes empacotadoras (wrapper) correspondentes (como `Integer`). O Java facilita isso com *autoboxing* (conversão automatica de `int` para `integer`) e *unboxing* (de `Integer` para `int`). É possível definir métodos genéricos (declarando o tipo antes do retorno, ex: `public <T> void imprimirArray(T[] array)`) e classes genéricas.

É crucial entender que não há relação de herança entre os tipos genéricos; por exemplo, `List<Integer>` *não* é uma subclasse de `List<Number>`. Para lidar com essa e outras limitações de herança, o Java usa Curingas (Wildcards):
- **`<?>` (Curinga Irrestrito):** Significa "uma lista de tipo desconhecido". Útil para métodos que apenas leem de forma genérica.
- **`<? extends Classe>` (Limite Superior):** Significa "qualquer tipo que seja `Classe` ou uma *subclasse* dela". É usado quando se deseja *ler* elementos de uma estrutura (ex:`List<? extends Number>` pode aceitar uma `List<Integer>` ou `List<Double>` para leitura).
- **`<? super Classe>` (Limite Inferior):** Significa "qualquer tipo que seja `Classe` ou uma *superclasse* dela". É usado quando se deseja *escrever* (adicionar) elementos em uma estrutura.

### Exemplos de Código:

```Java
// 1. Segurança de Tipo em Coleções
List<String> nomes = new ArrayList<>();
nomes.add("Maria");
// nomes.add(10); --> Erro de compilação!
String nome = nomes.get(0); // Sem necessidade de casting

// 2. Método Genérico
public <T> void imprimirArray (T[] arrayDeEntrada) {
    for (T elemento: arrayDeEntrada) {
        System.out.printf("%s%n ", elemento);
    }
}

// 3. Classe Genérica (Caixa)
public class Caixa<T> {
    private T conteudo;
    public void set(T conteudo) {
        this.conteudo = conteudo;
    }
    public T get() {
        return conteudo;
    }
}

// 4. Curinga (Wildcard) com Limite Superior
// Este método pode imprimir uma lista de Integers, Doubles, etc
public void imprimirLista(List<? extends Number> lista) {
    for (Number n: lista) {
        System.out.println(n);
    }
}
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
- **Métodos Principais:** Seus três métodos são `boolean hasNext()`, que retorna `true` se houver mais elementos na iteração; `E next()`, que retorna o próximo elemento; e `void remove()`, que remove da coleção o último elemento retornado por `next`.
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