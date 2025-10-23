package src.semana3;

// Exercício de atividade complementar: ProfessorConcursado.java
// Exercitando conceito de herança e polimorfismo em POO

public class ProfessorConcursado extends Professor {

    // Atributo do salário fixo

    private double salarioFixo;

    // Construtor da subclasse adicionando o construtor do salário fixo

    public ProfessorConcursado(int matricula, String nome, double salarioFixo) {
        super(matricula, nome);
        this.salarioFixo = salarioFixo;
    }

    // Get e Set

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    // Método de cálculo do salário fixo

    @Override
    public double calcularSalario(){
        return salarioFixo;
    }
}
    