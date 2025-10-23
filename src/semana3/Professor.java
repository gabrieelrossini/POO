package src.semana3;

// Exercício de atividade complementar: Professor.java
// Exercitando conceito de herança e polimorfismo em POO

public class Professor {
    
    // Atributos

    private int matricula;
    private String nome;

    // Construtor

    public Professor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    // Get e Set

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método de cálculo do salário

    public double calcularSalario() {
        return 0.0;
    }
}
