package src.semana1;

// Exemplo 1 do texto-base: Account.java
/* Classe Account que contém uma variável de instância name
 * e métodos para configurar e obter seu valor
 */

public class Account { // classe de entidade ou classe de modelo
    private String name; // variável de instância

    // o constutor inicializa name com o nome do parâmetro
    public Account(String name) {
        this.name = name;
    }

    // construtor vazio para indicar que a primeira resposta pode ser nula
    public Account() {
    
    }

    // método para definir ou alterar o valor da variável name
    public void setName(String name) { // cabeçalho do método
        this.name = name; // armazena o nome
    }

    // método para recuperar o nome do objeto
    public String getName() {
        return name; // retorna valor do nome para o chamador
    }    
} // fim da classe Account
