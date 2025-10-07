package src.semana1;

// Exercício de atividade complementar: ConversorTemp.java
// Convertendo C em F e viceversa.

import java.util.Scanner;

public class ConversorTemp {
    // método main inicia a execução do aplicativo Java
    public static void main (String[] args) {
        // cria Scanner para obter entrada a partir da linha de comando
        Scanner input = new Scanner(System.in);

        String escolha;

        System.out.print("Digite C para Celsius ou F para Fahrenheit: ");
        escolha = input.next();

        if (escolha.equalsIgnoreCase("C")) {
            System.out.print("Digite o valor da temperatura: ");
            double tempC = input.nextDouble();
            double resultadoF = ((tempC / 5.0) * 9.0) + 32;
            System.out.printf("A temperatura de %.2f °C é de %.2f °F.%n", tempC, resultadoF);
        }
        else if (escolha.equalsIgnoreCase("F")) {
            System.out.print("Digite o valor da temperatura: ");
            double tempF = input.nextDouble();
            double resultadoC = ((tempF - 32) / 9.0) * 5.0;
            System.out.printf("A temperatura de %.2f °F é de %.2f °C.%n", tempF, resultadoC);

        }
        else {
            System.out.println("Erro, reinicie o programa.");
        }       
        input.close();
    } 
}