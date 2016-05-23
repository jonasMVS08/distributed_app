/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonas
 */
@Entity
@DiscriminatorValue(value="B")
public class Book extends MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String isbn;
    private String author;
    private int pages;

    public Book() {
    }

    public Book(int id, String isbn, String author, int pages, char mtype, String title, float price, String genre, int published) {
        super(id, mtype, title, price, genre, published);
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }    
}
