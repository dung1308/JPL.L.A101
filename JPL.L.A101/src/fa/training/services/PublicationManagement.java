/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class PublicationManagement {
    private ArrayList<Publication> publication;
    Scanner sc = new Scanner(System.in);

    public ArrayList<Publication> getPublication() {
        return publication;
    }

    public void setPublication(ArrayList<Publication> publication) {
        this.publication = publication;
    }

    public PublicationManagement(){
        this.publication = new ArrayList<Publication>();
    }
    
    public PublicationManagement(ArrayList<Publication> publication) {
        this.publication = publication;
    }
    public void display(){
        if(this.publication.size() < 1){
            System.out.println("Empty!");
            System.out.println("---------------------");
            return;
        }
        System.out.println("------LIST OF library publication------");
        for(Publication x:this.publication){
            x.display();
        }
    }
    public void addBook(){
        Publication book = new Book();
        ((Book)book).createBook();
        this.publication.add(book);
    }
    public void addMagazine(){
        Publication magazine = new Magazine();
        ((Magazine)magazine).createMagazine();
        this.publication.add(magazine);
    }
    public void addAuthor(){
        System.out.println("Enter isbn:");
        String isbn = sc.next();
        System.out.println("-------------");
        for(Publication x:this.publication){
            if(x instanceof Book){
                if(((Book) x).getIsbn().equalsIgnoreCase(isbn)){
                    ((Book) x).createAuthor();
                }
            }
        }
        System.out.println("---------------");
    }
    public void displayTopTen(){
        int i =0;
        Collections.sort(this.publication,Magazine.soSanhVol);
        for(Publication y:this.publication){
            if(y instanceof Magazine){
                y.display();
                i++;
            }
            if(i>=10){
                return;
            }
        }
    }
    public void searchISBN(){
        System.out.println("Enter isbn:");
        String isbn = sc.next();
        for(Publication z:this.publication){
            if(z instanceof Book){
                if(((Book) z).getIsbn().equalsIgnoreCase(isbn)){
                    z.display();
                }
            }
        }
    }
    public void searchAuthor(){
        System.out.println("Enter author:");
        String author = sc.next();
        for(Publication z:this.publication){
            if(z instanceof Book){
                for(String s: ((Book) z).getAuthor()){
                    if(s.equalsIgnoreCase(author)){
                        z.display();
                    }
                }
            }
        }
    }
    public void searchPublisher(){
        System.out.println("Enter publisher:");
        String publisher = sc.next();
        for(Publication z:this.publication){
            if(z instanceof Book){
                if(((Book) z).getPublisher().equalsIgnoreCase(publisher)){
                    z.display();
                }
            }
        }
    }
}
