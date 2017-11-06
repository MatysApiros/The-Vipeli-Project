package br.com.matysapiros.bookchooser.view;

import br.com.matysapiros.bookchooser.controler.InsertsControler;
import br.com.matysapiros.bookchooser.controler.ListsControler;
import br.com.matysapiros.bookchooser.controler.SelectsControler;
import br.com.matysapiros.bookchooser.database.BookDAO;
import br.com.matysapiros.bookchooser.database.GenreDAO;
import br.com.matysapiros.bookchooser.model.Book;
import br.com.matysapiros.bookchooser.model.BooksException;
import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    BookDAO bookDAO = new BookDAO();
    GenreDAO genreDAO = new GenreDAO();
    ListsControler listsControler = new ListsControler();
    SelectsControler selectsControler = new SelectsControler();
    InsertsControler insertsControler = new InsertsControler();

    public void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("Opções:");
        System.out.println("1 - Menu de Gerenciamento de Informações;");
        System.out.println("2 - Menu de Gerenciamento de Pesquisas;");
        System.out.println("3 - Finallizar Aplicação;" + "\n");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 1:
                managementMenu();
                return;
            case 2:
                selectMenu();
                return;
            case 3:
                System.exit(0);
            default:
                System.out.println("\n");
                menuPrincipal();
                break;
        }
    }

    public void managementMenu(){
        System.out.println("\nSelecione a funcionalidade que deseja utilizar!\n");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Inserir Livros;");
        System.out.println("2 - Adicionar Gênero do Livro;");
        System.out.println("3 - Adicionar Tipo;");
        System.out.println("4 - Alterar a Avaliação do Livro");
        System.out.println("5 - Alterar o Tipo do Livro;");
        System.out.println("6 - Deletar um Livro;\n");
        int entrada = teclado.nextInt();

        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                System.out.println("\n");
                insertsControler.insertBook(insertBookData());
                System.out.println("Livro inserido com sucesso;\n");
                managementMenu();
                return;
            case 2:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId = teclado.nextInt();
                System.out.println("Insira o ID do Gênero(*Caso não saiba o ID, consulte o ID do Gênero através de uma das opções de pesquisa!*)");
                int genreId = teclado.nextInt();
                insertsControler.insertBookGenre(bookId, genreId);
                System.out.println("\n");
                managementMenu();
                return;
            case 3:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId2 = teclado.nextInt();
                System.out.println("Insira o ID do Tipo(*Caso não saiba o ID, consulte o ID do Tipo através de uma das opções de pesquisa!*)");
                int typeId = teclado.nextInt();
                insertsControler.insertBookType(bookId2, typeId);
                System.out.println("\n");
                managementMenu();
            case 4:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId3 = teclado.nextInt();
                System.out.println("Insira a nova nota de Avaliação do Livro:");
                double evaluation = teclado.nextDouble();
                insertsControler.updateEvaluation(bookId3,evaluation);
                System.out.println("\n");
                managementMenu();
            case 5:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId4 = teclado.nextInt();
                System.out.println("Insira o ID do Tipo(*Caso não saiba o ID, consulte o ID do Tipo através de uma das opções de pesquisa!*)");
                int typeId2 = teclado.nextInt();
                insertsControler.insertBookType(bookId4, typeId2);
                System.out.println("\n");
                managementMenu();
            case 6:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId5 = teclado.nextInt();
                insertsControler.deleteBook(bookId5);
                System.out.println("\n");
                managementMenu();
                return;
            default:
                System.out.println("\n");
                managementMenu();
                break;
        }
    }

    public void selectMenu(){
        System.out.println("\nSelecione a funcionalidade que deseja utilizar!\n");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Pesquisar Livro por Título;");
        System.out.println("2 - Pesquisar Livro por ID;");
        System.out.println("3 - Retornar lista de todos os Livros no sistema;");
        System.out.println("4 - Retornar lista de todos os Gêneros no sistema;");
        System.out.println("5 - Retornar lista de todos os Tipos no sistema;");
        System.out.println("6 - Retorna um Livro e seus Gêneros;\n");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                System.out.println("\n");
                System.out.println("Insira o Título do Livro:");
                String title = teclado.next();
                System.out.println(selectsControler.selectBookByTitle(title));
                selectMenu();
                return;
            case 2:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId = teclado.nextInt();
                System.out.println(selectsControler.selectBookByID(bookId));
                selectMenu();
                return;
            case 3:
                System.out.println("\n");
                try{
                    System.out.println(listsControler.listOfBooks());
                    selectMenu();
                }catch(BooksException excption){
                    System.out.println(excption);
                }
                return;
            case 4:
                System.out.println("\n");
                try{
                    System.out.println(listsControler.listOfGenres());
                    selectMenu();
                }catch(BooksException excption){
                    System.out.println(excption);
                }
                return;
            case 5:
                System.out.println("\n");
                try{
                    System.out.println(listsControler.listOfTypes());
                    selectMenu();
                }catch(BooksException excption){
                    System.out.println(excption);
                }
                return;
            case 6:
                System.out.println("\n");
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId2 = teclado.nextInt();
                System.out.println(selectsControler.selectBookWithGenre(bookId2) + "\n");
            default:
                System.out.println("\n");
                selectMenu();
                break;
        }
    }

    public Book insertBookData(){
        System.out.println("Insira o Titulo do Livro:");
        String titulo = teclado.next();
        System.out.println("Insira a Numeração do Livro:");
        int numeracao = teclado.nextInt();
        System.out.println("Insira a Avaliação do Livro (*Caso não haja avaliação, dar nota 1,00*)");
        double avaliacao = teclado.nextDouble();
        System.out.println("Insira o número de vezes que o você leu o Livro:");
        int vezesLido = teclado.nextInt();
        Book book = new Book(titulo,numeracao,avaliacao,vezesLido);
        return book;
    }
}