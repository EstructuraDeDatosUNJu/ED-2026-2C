package ed2026.TP1_2020;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.ArrayList;
import java.util.Objects;

public class Book {

    //region Attributes
    private String title;
    private String author;
    private ArrayList<String> authors;
    private String editorial;
    private Integer yearOfPublication;
    private Double price;
    //endregion

    //region Getters and Setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        StringBuilder sb = new StringBuilder();
        if (this.authors.size() > 0) {
            sb.append(this.authors.get(0));
            for (int i = 1; i < this.authors.size(); ++i) {
                sb.append("; ");
                sb.append(this.authors.get(i));
            }
        }
        return sb.toString();
    }

    public void setAuthor(String authorsString) {
        String[] authorsArray = authorsString.split(";");
        this.authors = new ArrayList<String>();
        for (String author : authorsArray) {
            this.authors.add(author);
        }
    }

    public ArrayList<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getYearOfPublication() {
        return this.yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    //endregion

    //region Constructors
    public Book() {
        this("sin título", "sin autor", "sin editorial", 0, 0.0);
    }

    public Book(String title, String author) {
        this(title, author, "sin editorial", 0, 0.0);
    }

    public Book(String title, ArrayList<String> authors) {
        this(title, authors, "sin editorial", 0, 0.0);
    }

    public Book(String title, String author, Integer yearOfPublication) {
        this(title, author, "sin editorial", yearOfPublication, 0.0);
    }

    public Book(String title, ArrayList<String> authors, Integer yearOfPublication) {
        this(title, authors, "sin editorial", yearOfPublication, 0.0);
    }

    public Book(String title, String author, Integer yearOfPublication, Double price) {
        this(title, author, "sin editorial", yearOfPublication, price);
    }

    public Book(String title, ArrayList<String> authors, Integer yearOfPublication, Double price) {
        this(title, authors, "sin editorial", yearOfPublication, price);
    }

    public Book(String title, String author, Double price) {
        this(title, author, "sin editorial", 0, price);
    }

    public Book(String title, ArrayList<String> authors, Double price) {
        this(title, authors, "sin editorial", 0, price);
    }

    public Book(String title, String author, String editorial) {
        this(title, author, editorial, 0, 0.0);
    }

    public Book(String title, ArrayList<String> authors, String editorial) {
        this(title, authors, editorial, 0, 0.0);
    }

    public Book(String title, String author, String editorial, Integer yearOfPublication) {
        this(title, author, editorial, yearOfPublication, 0.0);
    }

    public Book(String title, ArrayList<String> authors, String editorial, Integer yearOfPublication) {
        this(title, authors, editorial, yearOfPublication, 0.0);
    }

    public Book(String title, String author, String editorial, Double price) {
        this(title, author, editorial, 0, price);
    }

    public Book(String title, ArrayList<String> authors, String editorial, Double price) {
        this(title, authors, editorial, 0, price);
    }

    public Book(String title, String author, String editorial, Integer yearOfPublication, Double price) {
        setTitle(title); // doble encapsulamiento
        setAuthor(author);
        setEditorial(editorial);
        setYearOfPublication(yearOfPublication);
        setPrice(price);
    }

    public Book(String title, ArrayList<String> authors, String editorial, Integer yearOfPublication, Double price) {
        setTitle(title); // doble encapsulamiento
        setAuthors(authors);
        setEditorial(editorial);
        setYearOfPublication(yearOfPublication);
        setPrice(price);
    }
    //endregion

    //region Override Object basic methods
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getEditorial(), book.getEditorial()) &&
                Objects.equals(getYearOfPublication(), book.getYearOfPublication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getEditorial(), getYearOfPublication());
    }

    @Override
    public String toString() {
        return "Libro " +
                "Título='" + getTitle() + '\'' +
                ", Autor='" + getAuthor() + '\'' +
                ", Editorial='" + getEditorial() + '\'' +
                ", Año de Publicación=" + getYearOfPublication() +
                ", Precio=" + String.format("%.2f", getPrice()) +
                '\n';
    }
    //endregion
}
