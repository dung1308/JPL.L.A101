/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.training.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public class Book extends Publication{

    private String isbn;
    private Set<String> author;
    private String publicationPlace;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    public Book() {
        this.author = new HashSet<String>();
    }

    public Book(String isbn, Set<String> author, String publicationPlace, int pulibcationYear, String publisher, Date publicationDate) {
        super(pulibcationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }

    public void createBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter isbn:");
        String isbn = sc.next();
        this.isbn = isbn;
        System.out.println("How many authors:");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Author:");
            this.author.add(sc.next());
        }
        System.out.println("Enter place of publication:");
        String publicationPlace = sc.next();
        this.publicationPlace = publicationPlace;
        super.input();
    }
    public void createAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Author:");
        String author = sc.next();
        this.author.add(author);
    }
    
    
    @Override
    public void display() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Book{ ");
        System.out.println("Author:");
        for (String s : this.author) {
            System.out.println(s);
        }
        System.out.println("isbn:"+this.isbn+", publicationPlace:"+this.publicationPlace+
                ", Year of publication:"+super.getPulibcationYear()+", publisher:"+super.getPublisher()+
                ", Date of publication:" + formatter.format(super.getPublicationDate())+"}");
    }
}
