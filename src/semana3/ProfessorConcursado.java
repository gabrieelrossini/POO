package src.semana3;

public class ProfessorConcursado extends Professor {

    private double salarioFixo;

    public ProfessorConcursado(double matricula, String nome, double salarioFixo) {
        super(matricula, nome);
        this.salarioFixo = salarioFixo;
    }

    @Override
    public double calcularSalario(){
        return salarioFixo;
    }
}
    