package br.com.matysapiros.bookchooser.testes;

import br.com.matysapiros.bookchooser.dados.Conexao;

public class TestaConexao{

    public static void main (String [] args){
        Conexao.getConexao();
        System.out.println(Conexao.status);
    }
}
