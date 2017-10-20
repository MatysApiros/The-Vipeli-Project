package br.com.matysapiros.bookchooser;

public class Classification{
    private double preferencia; // Genre that user set to be the preferential genre to be read next;

    public Classification(){ this.preferencia = 10.0; }   // Value for the preferential genre;

    public double getPreferencia() { // Return the variable 'preferencia';
        return preferencia;
    }
}
