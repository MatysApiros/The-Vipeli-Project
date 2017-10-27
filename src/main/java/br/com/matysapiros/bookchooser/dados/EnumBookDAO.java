package br.com.matysapiros.bookchooser.dados;

public enum EnumBookDAO {
    INSERT("insert into books (title,numeracao,avaliacao,read_flag) values(?,?,?,?);"),
    SELECTALL("select * from books"),
    SELECTBYNAME("select * from books where title like ?"),
    SELECTBYID("select * from books where book_id = ?");

    private String comandoSQL;

    EnumBookDAO(String comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    public String getComandoSQL(){
        return comandoSQL;
    }
}
