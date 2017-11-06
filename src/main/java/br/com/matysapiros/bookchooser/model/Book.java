package br.com.matysapiros.bookchooser.model;

public class Book{

    private String nome;
    private int id;
    public String genre;
    private int numeracao;
    private double avaliacao;
    private String tipo;
    private int vezesLido;

    public Book(String nome, int numeracao, double avaliacao, int vezesLido) {
        this.nome = nome;
        this.id = id;
        this.genre = genre;
        this.numeracao = numeracao;
        this.avaliacao = avaliacao;
        this.tipo = tipo;
        this.vezesLido = vezesLido;
    }

    public Book(){

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVezesLido() {
        return vezesLido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVezesLido(int vezesLido) {
        this.vezesLido = vezesLido;
    }

    public String bookAndType(){
        return ("\nTipo: " + tipo + "\n");
    }

    @Override
    public String toString() {
        return ("\nNome: " + nome + "\nNumeracao: " + numeracao + "\nAvaliação: " + avaliacao + "\nNúmero devezes que o Livro foi lido: " + vezesLido + "\n");
    }
}
