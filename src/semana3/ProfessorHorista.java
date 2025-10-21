package src.semana3;

public class ProfessorHorista extends Professor {

    private double valorHora;
    private double qntHora;

    public ProfessorHorista(int matricula, String nome, double valorHora, double qntHora) {
        super(matricula, nome);
        this.valorHora = valorHora;
        this.qntHora = qntHora;
    }

    // Get e Set

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getQntHora() {
        return qntHora;
    }

    public void setQntHora(double qntHora) {
        this.qntHora = qntHora;
    }

    @Override
    public double calcularSalario(){
        return valorHora * qntHora;
    }
    
}