package src.semana3;

// Exercício de atividade complementar: Caneta.java
// Exercitando conceito de herança e polimorfismo em POO

public class Caneta {

    // Atributos

    private String marca;
    private String cor;
    private double tamanho;
    
    // Construtor

    public Caneta(String marca, String cor, double tamanho) {
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    // Métodos get e set
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    // Método toString

    @Override
    public String toString() {
        return String.format ("A caneta é da marca %s, da cor %s e tem %.2f de tamanho", marca, cor, tamanho);
    }
}
