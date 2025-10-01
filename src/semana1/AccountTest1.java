package src.semana1;

// Exemplo 2 do texto-base: AccountTest1.java
// cria e manipula um objeto Account

import java.util.Scanner;

public class AccountTest1
{
    public static void main(String[] args)
    {
        // cria um objeto Scanner para obter entrada a partir da janela de comando
        Scanner input = new Scanner(System.in);

        // cria um objeto Account e o atribui a myAccount
        Account myAccount = new Account();

        // exibe o valor inicial do nome (null) usando o objeto (myAccount)
        System.out.printf("Nome inicial é: %s%n%n", myAccount.getName());

        // solicita e lê o nome
        System.out.print("Digite o nome: ");
        String theName = input.nextLine(); // lê uma linha de texto
        myAccount.setName(theName); // insere theName em myAccount
        System.out.println(); // gera saída de uma linha em branco

        // exibe o nome armazenado no objeto MyAccount
        System.out.printf("Nome no objeto myAccount é: %s%n", myAccount.getName());

        input.close();
    }
}
