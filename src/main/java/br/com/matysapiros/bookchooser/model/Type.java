package br.com.matysapiros.bookchooser.model;

public class Type {
    int typeId;
    String type;

    public Type(int typeId, String type){
        this.typeId = typeId;
        this.type = type;
    }

    public Type(){

    }

    public int getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ("\nType: " + type + "\nType ID: " + typeId + "\n");
    }
}
