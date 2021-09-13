/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.training.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Magazine extends Publication implements Comparable{

    private String author;
    private int volumn;
    private int edition;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volumn) {
        this.volumn = volumn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Magazine() {

    }

    public Magazine(String author, int volumn, int edition, int pulibcationYear, String publisher, Date publicationDate) {
        super(pulibcationYear, publisher, publicationDate);
        this.author = author;
        this.volumn = volumn;
        this.edition = edition;
    }
    
    public void createMagazine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter author:");
        String author = sc.next();
        this.author = author;
        System.out.println("Enter volumn:");
        int volumn = sc.nextInt();
        this.volumn = volumn;
        System.out.println("Enter edition:");
        int edition = sc.nextInt();
        this.edition = edition;
        super.input();
    }
    @Override
    public void display() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Magazine{ author:"+this.author+", volumn:"+this.volumn+", edition:"+this.edition+
                ", year of publication:" +super.getPulibcationYear()+", publisher:"+super.getPublisher()+
                ", date of publication:"+formatter.format(super.getPublicationDate())+"}");
    }

    @Override
    public int compareTo(Object ds) {
       return this.author.compareTo(((Magazine)ds).getAuthor()); //To change body of generated methods, choose Tools | Templates.
    }
    public static Comparator soSanhVol = new Comparator(){
        @Override
        public int compare(Object m1,Object m2){
            Magazine nv1 = (Magazine) m1;
            Magazine nv2 = (Magazine) m2;
            double k= ((Magazine)nv1).getVolumn() - ((Magazine)nv2).getVolumn();
            if(k>0) return -1;
            if(k==0) return ((Magazine)nv1).author.compareTo(((Magazine)nv2).author);
            return 1;
        }
    };
}
