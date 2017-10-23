package br.com.matysapiros.bookchooser.dados;

public enum EnumGenre {

    COMEDIA("Comédia"),
    TERROR("Terror"),
    FICCAO("Ficção"),
    FARSA("Farsa"),
    MELODRAMA("Melodrama"),
    PANTOMIMA("Pantomima"),
    PERFORMANCE("Performance"),
    TEATRO("Teatro"),
    TRAGEDIA("Tragédia"),
    TRAGICOMEDIA("Tragicomédia"),
    EPOPEIA("Epopéia"),
    CONTO("Conto"),
    NOVELA("Novela"),
    ROMANCE("Romance"),
    CRONICA("Crônica"),
    FABULA("Fabula"),
    MISTERIO("Mistério"),
    ENSAIO("Ensaio"),
    SATIRA("Sátira"),
    RELIGIAO("Religião");
    private String genre;

    EnumGenre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
