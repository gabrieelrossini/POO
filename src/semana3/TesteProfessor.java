package src.semana3;

public class TesteProfessor{

    public static void main (String[] args) {
        ProfessorConcursado textoConcursado = new ProfessorConcursado(72345, "Joelson", 4000 );
        System.out.printf("A matrícula %d pertence ao professor %s, concursado, com salário de %.2f%n", textoConcursado.getMatricula(), textoConcursado.getNome(), textoConcursado.calcularSalario());
        ProfessorHorista textoHorista = new ProfessorHorista(93247, "Zacarias", 50.00, 40);
        System.out.printf("A matrícula %d pertence ao professor %s, horista, com salário de %.2f%n", textoHorista.getMatricula(), textoHorista.getNome(), textoHorista.calcularSalario());
    }
    
}
