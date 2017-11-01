package br.com.matysapiros.bookchooser.view;

import br.com.matysapiros.bookchooser.controler.BookDAO;
import br.com.matysapiros.bookchooser.controler.BookGenreDAO;
import br.com.matysapiros.bookchooser.model.Book;

import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    BookDAO bookDAO = new BookDAO();
    BookGenreDAO bookGenreDAO = new BookGenreDAO();

    public void menuPrincipal() {
        System.out.println("BookBank:");
        System.out.println("Menu Principal");
        System.out.println("Opções:");
        System.out.println("1 - Menu Inserir;");
        System.out.println("2 - Menu Pesquisar;");
        System.out.println("3 - Finallizar Aplicação;");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 1:
                insertMenu();
                return;
            case 2:
                selectMenu();
                return;
            case 3:
                System.exit(0);
            default:
                menuPrincipal();
                break;
        }
    }

    public void insertMenu(){
        System.out.println("Selecione a funcionalidade que deseja utilizar!");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Inserir Livros;");
        System.out.println("2 - Adicionar Gênero do Livro;");
        System.out.println("3 - Adicionar Tipo;");
        int entrada = teclado.nextInt();

        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                bookDAO.insertBook(insertBookData());
                System.out.println("Livro inserido com sucesso;");
                insertMenu();
                return;
            case 2:
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId = teclado.nextInt();
                System.out.println("Insira o ID do Gênero(*Caso não saiba o ID, consulte o ID do Gênero através de uma das opções de pesquisa!*)");
                int genreId = teclado.nextInt();
                bookGenreDAO.insertBookGenre(bookId, genreId);
                insertMenu();
                return;
            case 3:
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId2 = teclado.nextInt();
                System.out.println("Insira o ID do Tipo(*Caso não saiba o ID, consulte o ID do Tipo através de uma das opções de pesquisa!*)");
                int typeId = teclado.nextInt();
                bookDAO.insertBookType(bookId2, typeId);
                insertMenu();
            default:
                insertMenu();
                break;
        }
    }

    public void selectMenu(){
        System.out.println("Selecione a funcionalidade que deseja utilizar!");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Pesquisar Livros por Título;");
        System.out.println("2 - Pesquisar Livros por ID;");
        System.out.println("3 - Retornar lista de todos os Livros no sistema;");
        System.out.println("4 - Retornar lista de todos os Gêneros no sistema;");
        System.out.println("5 - Retornar lista de todos os Tipos no sistema;");
        System.out.println("6 - Retorna um Livro e seus Gêneros;");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                System.out.println("Insira o Título do Livro:");
                String title = teclado.next();

                System.out.println(bookDAO.selectBookByTitle(title) + "\n");
                selectMenu();
                return;
            case 2:
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId = teclado.nextInt();
                System.out.println(bookDAO.selectBookByID(bookId) + "\n");
                selectMenu();
                return;
            case 3:
                System.out.println(bookDAO.selectAllBooks() + "\n");
                selectMenu();
                return;
            case 4:
                System.out.println(bookGenreDAO.selectAllGenres() + "\n");
                selectMenu();
                return;
            case 5:
                System.out.println(bookDAO.selectAllTypes() + "\n");
                selectMenu();
                return;
            case 6:
                System.out.println("Insira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int bookId2 = teclado.nextInt();
                System.out.println(bookDAO.selectBooksAndGenres(bookId2) + "\n");
            default:
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
        System.out.println("Insira o número de Vezes Lido:");
        int vezesLido = teclado.nextInt();
        Book book = new Book(titulo,numeracao,avaliacao,vezesLido);
        return book;
    }
}

