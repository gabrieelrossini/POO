package src.semana1;

// Exemplo 3 do texto base: AccountTest2.java
// Usar o construtor de Account para inicializar a instância name

public class AccountTest2 {
    public static void main(String[] args) {
        // cria dois objetos Account
        Account account1 = new Account("Gabriel Marvullo");
        Account account2 = new Account("Francisco Rossini");

        // exibe o valor inicial de nome para cada Account
        System.out.printf("O primeiro nome é: %s%n", account1.getName());
        System.out.printf("O segundo nome é: %s%n", account2.getName());
    }
}
