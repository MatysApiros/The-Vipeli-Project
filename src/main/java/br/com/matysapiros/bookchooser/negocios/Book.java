package br.com.matysapiros.bookchooser.negocios;

public class Book{

    private String nome;
    private int numeracao;
    private double avaliacao;
    private int vezesLido;



    public Book(String nome, int numeracao, double avaliacao, String tipo, int vezesLido) {
        this.nome = nome;
        this.numeracao = numeracao;
        this.avaliacao = avaliacao;
        this.vezesLido = vezesLido;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public int getVezesLido() {
        return vezesLido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setVezesLido(int vezesLido) {
        this.vezesLido = vezesLido;
    }
}
