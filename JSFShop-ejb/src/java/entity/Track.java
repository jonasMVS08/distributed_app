/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jonas
 */
@Entity
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int track_id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private Cd cd;
    private String track_title;

    public Track() {
    }

    public Track(int track_id, Cd cd, String track_title) {
        this.track_id = track_id;
        this.cd = cd;
        this.track_title = track_title;
    }

    public String getTrackTitle() {
        return track_title;
    }

    public void setTrackTitle(String track_title) {
        this.track_title = track_title;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

    public int getTrackId() {
        return track_id;
    }

    public void setTrackId(int track_id) {
        this.track_id = track_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) track_id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if (this.track_id != other.track_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Track[ id=" + track_id + " ]";
    }    
}
