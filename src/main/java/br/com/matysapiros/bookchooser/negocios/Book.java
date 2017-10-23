package br.com.matysapiros.bookchooser.negocios;

public class Book{

    private String nome;
    private int numeracao;
    private double avaliacao;
    private String genero;
    private String subGenero;
    private String tipo;



    public Book(String nome, int numeracao, double avaliacao, String genero, String subGenero, String tipo) {
        this.nome = nome;
        this.numeracao = numeracao;
        this.avaliacao = avaliacao;
        this.genero = genero;
        this.subGenero = subGenero;
        this.tipo = tipo;
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

    public String getGenero() {
        return genero;
    }

    public String getSubGenero() {
        return subGenero;
    }

    public String getTipo(){
        return tipo;
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

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSubGenero(String subGenero) {

        this.subGenero = subGenero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
