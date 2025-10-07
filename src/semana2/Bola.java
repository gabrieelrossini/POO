package src.semana2;

// Exercício de atividade complementar: Bola.java
// Exercitando conceito de encapsulamento em POO

// A palavra-chave 'public' significa que esta classe pode ser acessada por qualquer outra classe no projeto.
// 'class Bola' declara um novo "molde" para criar objetos do tipo Bola.
public class Bola {

    // --- ATRIBUTOS ---
    // Atributos são as variáveis que definem as características de cada objeto Bola.
    // Usamos 'private' para aplicar o encapsulamento, protegendo os dados de acesso direto.
    // Só os métodos da própria classe podem manipular estes atributos.
    private String material;
    private String cor;
    private int tamanho;
    private boolean cheia; // true para cheia, false para vazia

    // --- CONSTRUTORES ---
    // Construtores são métodos especiais responsáveis por criar e inicializar os objetos.

    /**
     * Construtor Padrão (ou Default).
     * Cria um objeto Bola com os valores padrão do Java (null, null, 0, false).
     * Útil para criar o objeto primeiro e configurá-lo depois usando os setters.
     */
    public Bola() {
        // Vazio, pois a inicialização padrão do Java é suficiente aqui.
    }

    /**
     * Construtor Completo.
     * Recebe todos os valores necessários para criar um objeto Bola totalmente configurado.
     * 'this' é usado para diferenciar o atributo da classe (ex: this.material) do parâmetro do método (ex: material).
     */
    public Bola(String material, String cor, int tamanho, boolean cheia) {
        this.material = material;
        this.cor = cor;
        this.tamanho = tamanho;
        this.cheia = cheia;
    }

    /**
     * Construtor Sobrecarregado (ou de Conveniência).
     * Uma forma mais simples de criar uma bola, especificando apenas a cor e o tamanho.
     * 'this("couro", cor, tamanho, true);' é uma chamada para o construtor completo desta mesma classe.
     * Isso evita a repetição de código, assumindo valores padrão para 'material' e 'cheia'.
     */
    public Bola(String cor, int tamanho) {
        this("couro", cor, tamanho, true);
    }

    // --- MÉTODOS GETTERS E SETTERS ---
    // Métodos públicos que servem como "porteiros" para os atributos privados.

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    // Para booleanos, a convenção em Java é usar 'is' no lugar de 'get'.
    public boolean isCheia() {
        return cheia;
    }

    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }

    // --- MÉTODOS DE COMPORTAMENTO ---
    // Ações que o objeto Bola pode realizar.

    
    // Altera a cor da bola. Funciona de forma similar ao setCor.
    
    public void pintar(String novaCor) {
        this.cor = novaCor;
    }

    /**
     * Define o estado da bola como 'cheia'.
     * Atribui diretamente 'true' ao atributo 'cheia'.
     */
    public void encher() {
        this.cheia = true;
    }

    /**
     * Define o estado da bola como 'vazia'.
     * Atribui diretamente 'false' ao atributo 'cheia'.
     */
    public void esvaziar() {
        this.cheia = false;
    }
}
