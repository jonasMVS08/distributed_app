/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonas
 */
@Entity(name="category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char cat_type;
    private String media;

    public Category() {
    }

    public Category(int id, char cat_type, String media) {
        this.id = id;
        this.cat_type = cat_type;
        this.media = media;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public char getCat_type() {
        return cat_type;
    }

    public void setCat_type(char cat_type) {
        this.cat_type = cat_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entity.Category[ id=" + id + " ]";
    }
    
}
