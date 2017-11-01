package br.com.matysapiros.bookchooser.model;

public class Genre {
    int genreID;
    String genre;

    public Genre(int genreID,String genre){
        this.genreID = genreID;
        this.genre = genre;
    }

    public Genre(){

    }

    public int getGenreID(){
        return genreID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
