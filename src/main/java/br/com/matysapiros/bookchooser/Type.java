package br.com.matysapiros.bookchooser;

public class Type {
    private double estudoObrigatorio;
    private double estudoCasual;
    private double interesseImediato;
    private double interesseSimples;


    public Type() {
        this.estudoObrigatorio = 3.5;
        this.estudoCasual = 3.25;
        this.interesseImediato = 3.25;
        this.interesseSimples = 2.5;
    }

    public double getEstudoObrigatorio() {
        return estudoObrigatorio;
    }

    public double getEstudoCasual() {
        return estudoCasual;
    }

    public double getInteresseImediato() {
        return interesseImediato;
    }

    public double getInteresseSimples() {
        return interesseSimples;
    }
}
