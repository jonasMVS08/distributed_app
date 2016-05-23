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
@DiscriminatorValue(value="D")
public class Dvd extends MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String director;

    public Dvd() {
    }

    public Dvd(int id, String director, char mtype, String title, float price, String genre, int published) {
        super(id, mtype, title, price, genre, published);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }    
}
