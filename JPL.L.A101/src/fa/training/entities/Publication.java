/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.training.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public abstract class Publication {
    private int pulibcationYear;
    private String publisher;
    private Date publicationDate;

    public int getPulibcationYear() {
        return pulibcationYear;
    }

    public void setPulibcationYear(int pulibcationYear) {
        this.pulibcationYear = pulibcationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Publication(){
        
    }
    
    public Publication(int pulibcationYear, String publisher, Date publicationDate) {
        this.pulibcationYear = pulibcationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year of publication:");
        int year = sc.nextInt();
        this.pulibcationYear = year;
        System.out.println("Enter publisher:");
        String publisher = sc.next();
        this.publisher = publisher;
        boolean checkDate = false;
        do{
            try {
                System.out.println("Enter date of publication:");
                String date = sc.next();
                Date formattedDate = new SimpleDateFormat("dd/MM").parse(date);
                //System.out.println(formattedDate.toString());
                checkDate = true;
                this.publicationDate = formattedDate;
            } catch (ParseException e) {
                System.out.println("Error! Must enter dd/MM");
            }
        }while(checkDate == false);
        
    }
    
    public abstract void display();
}
