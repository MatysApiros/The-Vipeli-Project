package br.com.matysapiros.bookchooser.dados;

import br.com.matysapiros.bookchooser.negocios.Book;

import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    BookDAO bookDAO = new BookDAO();

    public void menuPrincipal() {
        System.out.println("BookBank:");
        System.out.println("Menu Principal");
        System.out.println("Opções:");
        System.out.println("Selecione a funcionalidade que deseja utilizar!");
        System.out.println("1 - Inserir Livros;");
        System.out.println("2 - Pesquisar Livros;");
        int entrada = teclado.nextInt();

        switch (entrada){
            case 1:
                bookDAO.insertBook(insertBookData());
                return;
            case 2:
                System.out.println(bookDAO.selectBookByTitle(buscarPorNome()));

        }
    }

    public Book insertBookData(){
        System.out.println("Insira o Titulo do Livro:");
        String titulo = teclado.next();teclado.nextLine();
        System.out.println("Insira a Numeração do Livro:");
        int numeracao = teclado.nextInt();teclado.nextLine();
        System.out.println("Insira a Avaliação do Livro (*Caso não haja avaliação, dar nota 1,00)");
        double avaliacao = teclado.nextDouble();teclado.nextLine();
        System.out.println("Insira o número de Vezes Lido:");
        int vezesLido = teclado.nextInt();teclado.nextLine();
        Book book = new Book(titulo,numeracao,avaliacao,vezesLido);
        return book;
    }

    public String buscarPorNome(){
        System.out.println("Insira o Titulo do Livro desejado:");
        String titulo =  teclado.next();teclado.nextLine();
        return titulo;
    }
}

