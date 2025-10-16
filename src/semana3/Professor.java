package src.semana3;

public class Professor {
    
    // Atributos

    private double matricula;
    private String nome;

    // Construtor

    public Professor(double matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    // Get e Set

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula){
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double calcularSalario() {
        return 0.0;
    }
}
