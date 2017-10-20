package br.com.matysapiros.bookchooser;

public class Genre {
    private double principal;
    private double secundarios;
    private double sequncia;

    public  Genre(){
        this.principal = 5.75;
        this.secundarios = 3.55;
        this.sequncia = 1.0;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getSecundarios() {
        return secundarios;
    }

    public double getSequncia() {
        return sequncia;
    }
}
