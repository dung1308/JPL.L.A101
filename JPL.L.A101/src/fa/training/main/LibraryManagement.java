/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.training.main;

import fa.training.services.PublicationManagement;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PublicationManagement libr = new PublicationManagement();
        int choice=0;
        do{
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volumn");
            System.out.println("6. Search book by (isbn,author, publisher");
            System.out.println("7. Exit");
            boolean checkId = false;
            do{
                try{
                    System.out.println("Choice:");
                    choice = Integer.parseInt(sc.nextLine());
                    checkId = true;
                }catch(NumberFormatException e){
                    System.out.println("Errror");
                }
            }while(checkId == false);
            switch(choice){
                case 1:
                    libr.addBook();
                    break;
                case 2:
                    libr.addMagazine();
                    break;
                case 3:
                    libr.display();
                    break;
                case 4:
                    libr.addAuthor();
                    break;
                case 5:
                    libr.displayTopTen();
                    break;
                case 6:
                    System.out.println("1. Isbn");
                    System.out.println("2. Author");
                    System.out.println("3. Publisher");
                    checkId=false;
                    do{
                        try{
                            System.out.println("Choice:");
                            choice = Integer.parseInt(sc.nextLine());
                            checkId = true;
                        }catch(NumberFormatException e){
                            System.out.println("Errror");
                        }
                    }while(checkId == false);
                    switch(choice){
                        case 1:
                            libr.searchISBN();
                            break;
                        case 2:
                            libr.searchAuthor();
                            break;
                        case 3:
                            libr.searchPublisher();
                            break;
                    }
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }while(choice!=7);
    }
}
