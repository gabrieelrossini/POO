# Semana 5 - Conjuntos e Mapas

## 1. A Interface Set (Conjuntos)

**Conceito:** A interface `Set`, encontrada no pacote `java.util`, define uma coleção que funciona de forma análoga aos conjuntos da matemática, pois sua característica fundamental é não permitir a inclusão de elementos duplicados. Se for tentada a inserção de um resgistro que já existe (conforme determinado pelo método `equals` do objeto), a operação é simplesmente ignorada e o elemento duplicado não é adicionado. Esta interface estende `Collection` e, diferentemente de `List`, não exige uma posição específica para a inserção de elementos. A interface `Set` também estabelece um contrato mais forte sobre os métodos `equals` e `hashCode`, garantindo que implementações diferentes de `Set` possam ser comparadas significativamente se contiverem os mesmos elementos

## 2. A Implementação HashSet

**Conceito:** A classe `HashSet` é a implementação mais comum e de melhor desempenho da interface `Set`. Ela armazena seus elementos internamente utilizando uma Tabela Hash (ou *hashing*), baseando-se no `hashCode` do elemento para determinar onde amarzená-lo. Essa estrutura permite operações de adição, remoção e verificação de existência (métodos  `contains`) em tempo médio constante, O(1), desde que a função de hash seja bem distribuída. A principal consequência do uso de *hashing* é que o `HashSet` não oferece absolutamente nenhuma garantia quanto à ordem de iteração dos elementos; a ordem pode parecer aleatória e mudar conforme novos elementos são adicionados. O `HashSet` permite a inclusão de, no máximo, um elemento nulo.

### Exemplo de Código:

```Java
// HashSet ignora duplicatas e não garante a ordem
Set<String> meuSet = new HashSet<>();
meuSet.add("Maçã");
meuSet.add("Banana");
meuSet.add("Maçã"); // Esta adição será ignorada
// A ordem de impressão não é garantida: [Banana, Maçã] ou [Maçã, Banana]
System.out.println(meuSet);
```

## 3. A Implementação LinkedHashSet

**Conceito:** A classe `LinkedHashSet` é uma implementação especializada que estende  `HashSet`. Ela utiliza internamente a mesma Tabela Hash para garantir a performance e a unicidade dos elementos, mas adiciona uma estrutura de dados secundária: uma lista duplamente encadeada (ligada) que conecta os elementos. O propósito dessa lista é manter e iterar sobre os elementos na ordem exata em que eles foram inseridos no conjunto. Portanto, embora tenha uma performance de inserção ligeiramente inferior ao `HashSet` (devido à manutenção da lista), ela garante que a ordem de iteração será previsível e idêntica à ordem de inserção.

### Exemplo de Código:

```Java
// LinkedHashSet mantém a ordem de inserção
Set<String> meuSet = new LinkedHashSet<>();
meuSet.add("Vermelho");
meuSet.add("Verde");
meuSet.add("Azul");
// A impressão respeita a ordem de inserção: [Vermelho, Verde, Azul]
System.out.println(meuSet);
```

## 4. A Implementação TreeSet (e SortedSet)

**Conceito:** A classe `TreeSet` é a principal implementação da interface `SortedSet`, que por sua vez estende `Set`. Sua característica distintiva é que ela armazena os elementos em uma estrutura de árvore balanceada (especificamente, uma árvore rubro-negra). O resultado é que o `TreeSet` mantém seus elementos *sempre* em ordem classificada, seja pela ordem natual dos elementos (como a ordem alfabética para `String` ou numérica para `Integer`) ou por um `Comparator` fornecido no momento da criação do conjunto. Por garantir a ordem, suas operações (adição, remoção) são mais lentas que as do `HashSet`, geralmente com custo O(logn). Como implementa `SortedSet`, ela oferece métodos adicionais para navegação baseada na ordem, como `first()` (menor elemento), `last()` (maior elemento), `headSet()` (elementos menores que um valor específico) e `tailSet()` (elementos maiores ou iguais a um valor específico).

### Exemplo de Código:

```Java
// TreeSet mantém a ordem natural (alfabética, neste caso)
Set<String> meuSet = new TreeSet<>();
meuSet.add("Zebra");
meuSet.add("Macaco");
meuSet.add("Baleia");
// A impressão é em ordem natural: [Baleia, Macaco, Zebra]
System.out.println(meuSet);
```

## 5. A interface Map (Mapas)

**Conceito:** A interface `Map`, diferentemente de `Set`, não estende a interface `Collection` e modela um conceito diferente: um objeto que armazena associações entre chave-valor. Ela é equivalente ao conceito de "dicionário" ou "array associativo" de outras linguagens. A característica central de um `Map` é que ele não pode conter chaves duplicadas; cada chave mapeia para, no máximo, um valor. Se um novo valor par é inserido com uma chave que já existe, o valor antigo associado àquela chave é substituído. O principal caso de uso dos mapas é a busca eficiente de um objeto (valor) quando se tem uma informação específica sobre ele (chave), como buscar dados de um carro (valor) usando sua placa (chave).

## 6. A Implementação HashMap

**Conceito:** O `HashMap` é a implementação mais comum de `Map` e funciona de maneira análoga ao `HashSet`. Ele armazena os pares chave-valor em uma Tabela Hash, baseando-se no `hashCode` da *chave* para determinar a localização do par. Assim como o `HashSet`, o `HashMap` oferece excelente desempenho (tempo médio O(1)) para inserção (`put`) e recuperação (`get`), mas não fornece nenhuma garantia sobre a ordem de iteração dos pares chave-valor. O `HashMap` permite uma chave nula e múltiplos valores nulos. Uma implementação mais antiga e semelhante é a `Hashtable`, que também usa *hashing*, mas é sincronizada (thread-safe) e, diferentemente do `HashMap`, não permite chaves ou valores nulos.

### Exemplo de Código:

```Java
// HashMap associa chaves a valores; não garante ordem
Map<String, String> meuMapa = new HashMap<>();
meuMapa.put("SP", "São Paulo");
meuMapa.put("RJ", "Rio de Janeiro");
// A ordem de impressão não é garantida
System.out.printf("Conteúdo do mapa: %s%n", meuMapa);
// Buscando um valor pela chave:
System.out.printf("A sigla %s corresponde a: %s%n", "RJ", meuMapa.get("RJ"));

meuMapa.containsKey("SP");    // verifica se chave existe
meuMapa.containsValue("Rio"); // verifica se valor existe
meuMapa.remove("RJ");         // remove por chave
meuMapa.size();               // número de pares
```

## 7. A Implementação TreeMap (e SortedMap)

**Conceito:** O `TreeMap` é a implementação da interface `SortedMap` (que estende `Map`). De forma análoga ao `TreeSet`, ele armazena seus pares chave-valor em uma árvore rubro-negra, ordenada de acordo com as *chaves*. Isso garante que, ao iterar sobre o mapa (por exemplo, sobre seu `keySet()` ou `entrySet()`), as chaves serão apresentadas em ordem classificada (natural ou por `Comparator`). Assim como o `TreeSet`, suas operações são mais lentas que as do `HashMap` (custo O(logn)), sendo a escolha ideal quando a ordem de classificação das chaves é um requisito.

### Exemplo de Código:

```Java
// TreeMap ordena os pares pela chave
Map<Integer, String> meuMapa = new TreeMap<>();
meuMapa.put(3, "Item C");
meuMapa.put(1, "Item A");
meuMapa.put(2, "Item B");
// A impressão é ordenada pelas chaves: {1=Item A, 2=Item B, 3=Item C}
System.out.println(meuMapa);
```