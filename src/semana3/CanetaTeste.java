package src.semana3;

// Exercício de atividade complementar: CanetaTeste.java
// Exercitando conceito de herança e polimorfismo em POO

public class CanetaTeste extends Caneta {
    // Construtor da subclasse que chama o construtor da superclasse
    public CanetaTeste(String marca, String cor, double tamanho){
        super(marca, cor, tamanho);
    }
    
    // Método principal para execução do programa
    public static void main (String[] args) {
        // 1. Cria o objeto do tipo CanetaTeste
        CanetaTeste caneta1 = new CanetaTeste("bic", "azul", 0.7);
        // 2. Imprime o objeto (Java chama o método toString() automaticamente)
        System.out.println(caneta1);
    }
}
