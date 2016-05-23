/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonas
 */
@Entity
@DiscriminatorValue(value="C")
public class Cd extends MediaType  {

    @Id
    @OneToMany(mappedBy="track")
    private List tracks;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String artist;

    public Cd() {
    }

    public Cd(int id, String artist, char mtype, String title, float price, String genre, int published) {
        super(id, mtype, title, price, genre, published);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }    
    
    public List getTracks() {
        return tracks;
    }

    public void setTracks(List tracks) {
        this.tracks = tracks;
    }
}
