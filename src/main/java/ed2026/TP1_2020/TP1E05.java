package ed2026.TP1_2020;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
/*
 * Escribir un programa que permita ingresar la información de muchos libros de acuerdo a la
 * implementación
 * del caso ejemplo c) ; luego el usuario podrá indicar un rango de precios en particular y el
 * programa deberá
 * mostrar los libros cuyos precios se encuentren dentro del rango especificado.
 * 
 * Indicaciones :
 * Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se
 * espera que el
 * código controle los problemas que normalmente ocurren al operar con la consola o teclado.
 * Se espera una correcta modularización entre el código que realiza el ingreso y validación de los
 * datos
 * respecto del código que hace lo que se solicita en el ejercicio.
 * 
 */

import java.util.ArrayList;

public class TP1E05 {

    public void Run() {

        ArrayList<Book> books = getBooks();

        System.out.println("\nIngrese el rango de precios a buscar");
        Double fromPrice = 0.0;
        Double toPrice = 0.0;

        while (true) {
            fromPrice = Helper.getDouble("Desde qué Precio.: ");
            if (fromPrice < 0.0) {
                System.out.println("Ingrese un precio correcto");
                continue;
            }
            break;
        }
        while (true) {
            toPrice = Helper.getDouble("Hasta qué Precio.: ");
            if (toPrice < fromPrice) {
                System.out.println("Ingrese un precio correcto");
                continue;
            }
            break;
        }

        Double price;
        for (Book book : books) {
            price = book.getPrice();
            if (price >= fromPrice && price <= toPrice) {
                System.out.println(book);
            }
        }

    }

    private ArrayList<Book> getBooks() {

        Integer option;
        while (true) {
            System.out.println(
                    "\nTrabajo Práctico Nº 1 - Ejercicio 5\n" +
                            "\nOpciones" +
                            "\n 1. Ingresa valores por consola" +
                            "\n 2. Genera valores aleatorios");
            option = Helper.getInteger("\nSu opción: ");

            switch (option) {
                case 1:
                    return consoleInput();
                case 2:
                    return randomCreate();
            }
        }
    }

    private ArrayList<Book> consoleInput() {

        ArrayList<Book> books = new ArrayList<Book>();

        do {
            books.add(getBook());
        } while (Character.toUpperCase(Helper.getCharacter("Ingresa más libros (S/N): ")) != 'N');

        return books;
    }

    private Book getBook() {
        String title;
        String author;
        String editorial;
        Integer yearOfPublication;
        Double price;

        System.out.print("Ingrese la información del libro\n");
        while (true) {
            System.out.print("Título.............: ");
            title = Helper.scanner.nextLine();
            if (title.isBlank()) {
                System.out.println("Ingrese un título correcto");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Autor..............: ");
            author = Helper.scanner.nextLine();
            if (author.isBlank()) {
                System.out.println("Ingrese un autor correcto");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Editorial..........: ");
            editorial = Helper.scanner.nextLine();
            if (editorial.isBlank()) {
                System.out.println("Ingrese una editorial correcta");
                continue;
            }
            break;
        }

        while (true) {
            yearOfPublication = Helper.getInteger("Año de Publicación.: ");
            if (yearOfPublication < 0) {
                System.out.println("Ingrese un año correcto");
                continue;
            }
            break;
        }

        while (true) {
            price = Helper.getDouble("Precio.............: ");
            if (price < 0.0) {
                System.out.println("Ingrese un precio correcto");
                continue;
            }
            break;
        }

        return new Book(title, author, editorial, yearOfPublication, price);
    }

    private ArrayList<Book> randomCreate() {

        ArrayList<Book> books = new ArrayList<Book>();

        String title;
        String author;
        String editorial;
        Integer yearOfPublication;
        Double price;

        for (int count = Helper.random.nextInt(10) + 1; count > 0; --count) {
            title = someTitles[Helper.random.nextInt(someTitles.length)];
            author = someAuthors[Helper.random.nextInt(someAuthors.length)];
            editorial = someEditorials[Helper.random.nextInt(someEditorials.length)];
            yearOfPublication = Helper.random.nextInt(2020);
            price = Helper.random.nextDouble() * 1000;

            books.add(new Book(title, author, editorial, yearOfPublication, price));
        }

        return books;
    }

    //region Datos para Simular
    private static String[] someTitles = {
            "Foundations of Computer Science. C Edition",
            "Estructura de Datos y Algoritmos",
            "Python no Muerde Yo Sí",
            "Curso Python para Principiantes",
            "Organization and Maintenance of Large Ordered Indexes",
            "Algoritmos y Estructura de Datos",
            "Algorithmics Theory and Practice",
            "Fundamentals of Algorithmics",
            "Introduction to Algorithms",
            "Data Structures and Algorithms in Python",
            "C++ How to Progrmam Instructor's Manual Contents",
            "Cómo Programar en C, C++ y Java",
            "Cómo Programar en C#",
            "Java Cómo Programar",
            "Java How to Program",
            "Data Structures and Algorithms in C++",
            "Thinking in C++, Volume 1",
            "Thinking in C++, Volume 2",
            "Estructuras de datos en Java",
            "Estructura de datos en C++",
            "Algorithm Design",
            "The Art of Computer Programming Volume 1 Fundamental Algorithms 2nd Edition",
            "Learning Python",
            "Programming Python",
            "Introduction to Theory of Computation",
            "Fundamentos de Programación en Java",
            "Handbook of Data Structures and Applications",
            "Open Data Structures (in Java)",
            "The C++ Programming Language",
            "Python Tutorial. Release 3.2.3",
            "El tutorial de Python"
    };

    private static String[] someAuthors = {
            "Aho, Alfred V",
            "2Ullman, Jeffrey D",
            "Alsina, Roberto",
            "Bahit, Eugenia",
            "Bayer, Rudolf",
            "Brassard, Gilles",
            "Bratley, Paul",
            "Brucker, Peter",
            "Cabanes, Nacho",
            "Christian Charras",
            "Cormen, Thomas H",
            "Deitel, Harvey M",
            "Deitel, Paul J",
            "Drozdek, Adam",
            "Eckel, Bruce",
            "Joyanes Aguilar, Luis",
            "Zahonero Martínez, Ignacio",
            "Knuth Donald E",
            "Lutz, Mark",
            "Morin, Pat",
            "Sedgewick, Robert",
            "Flajolet, Philippe",
            "Skiena, Steven S",
            "Stroustrup, Bjarne",
            "van Rossum, Guido",
            "Wachenchauzer, Rosita"
    };

    private static String[] someEditorials = {
            "Alianza Editorial",
            "Milky Way Edici",
            "Planeta Cómic",
            "Ivrea España",
            "Astiberri Edici",
            "Blackie Books",
            "Editorial Anagr",
            "Nova",
            "Austral Editorial",
            "Alfaguara",
            "Nórdica Libros",
            "Roca Editorial",
            "Alpha Decay",
            "Ediciones Kiwi",
            "Periscopi",
            "Editorial Minú",
            "Zorro Rojo",
            "Gallo Nero Edic",
            "Oreilly",
            "Apress",
            "Packt Publishing",
            "Wrox",
            "Manning Press",
            "Pragmatic BookShelf",
            "SitePoint"
    };
    //endregion

}
