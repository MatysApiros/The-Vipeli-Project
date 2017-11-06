package br.com.matysapiros.bookchooser.model;

public class BooksWithGenres extends Book{

    private String nome;
    private String genre;

    public BooksWithGenres(String nome, String genre){
        super();
        this.nome = nome;
        this.genre = genre;
    }

    public BooksWithGenres(){

    }

    public String getNome() {
        return super.getNome();
    }

    public String getGenre() {
        return super.getGenre();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setGenre(String genre) {
        super.setGenre(genre);
    }

    @Override
    public String toString() {
        return ("\nNome: " + nome + "\nGênero: " + genre + "\n");
    }
}
