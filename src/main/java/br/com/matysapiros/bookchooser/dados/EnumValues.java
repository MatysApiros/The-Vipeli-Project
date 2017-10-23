package br.com.matysapiros.bookchooser.dados;

public enum EnumValues{

    PRINCIPAL(5.75),
    SECUNDARIO(3.55),
    PREFERENCIA(10.5),
    SEQUENCIA(2.75),
    ESTUDOSOBRIGATORIO(4.5),
    ESTUDOSCASUAL(4.15),
    INTERESSE(3.75),
    CASUAL(3.25);
    public double value;

    EnumValues(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
