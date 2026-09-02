package ed2026.TP1_2020;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
/*
 * Modificar la implementación del tipo Libro de los ejercicios anteriores de manera que cada libro
 * pueda
 * tener más de un autor.
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

public class TP1E06 {

    public static void Run() {

        String title;
        ArrayList<String> authors;
        String editorial;
        Integer yearOfPublication;
        Double price;

        ArrayList<Book> books = new ArrayList<Book>();

        for (int count = Helper.random.nextInt(5) + 1; count > 0; --count) {
            title = someTitles[Helper.random.nextInt(someTitles.length)];

            authors = new ArrayList<String>();
            for (int i = Helper.random.nextInt(5) + 1; i > 0; --i) {
                authors.add(someAuthors[Helper.random.nextInt(someAuthors.length)]);
            }

            editorial = someEditorials[Helper.random.nextInt(someEditorials.length)];
            yearOfPublication = Helper.random.nextInt(2020);
            price = Helper.random.nextDouble() * 1000;

            books.add(new Book(title, authors, editorial, yearOfPublication, price));
        }

        for (Book book : books) {
            System.out.println(book);
        }

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
            "Ullman, Jeffrey D",
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
