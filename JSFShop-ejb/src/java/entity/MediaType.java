/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Jonas
 */
@Entity(name="mediatype")
@Table(name="MEDIATYPE")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="mtype")

public abstract class MediaType implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char mtype;
    private String title;
    private float price;
    private String genre;
    private int published;
    @ManyToMany(mappedBy="products")
    private List<Order> orders;

    public MediaType() {
    }

    public MediaType(int id, char mtype, String title, float price, String genre, int published) {
        this.id = id;
        this.mtype = mtype;
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.published = published;
    }
    
    public char getMtype() {
        return mtype;
    }

    public void setMtype(char mtype) {
        this.mtype = mtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "entity.MediaType[ id=" + id + " ]";
    }
    
}
