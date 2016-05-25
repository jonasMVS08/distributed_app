/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.Cd;
import entity.MediaType;
import entity.Track;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.RequestScoped;
import session.CdFacade;
import session.MediaTypeFacade;

/**
 *
 * @author Jonas
 */

@ManagedBean
@RequestScoped
public class DetailsManager implements Serializable{

    @EJB
    private CdFacade cdFacade;
    @EJB
    private MediaTypeFacade mediaTypeFacade;
    private MediaType media;
    private Track tracks;
    private Cd cd;
    private List<String> listSongs = new ArrayList<String>();

    
    @ManagedProperty(value="#{param.medTypeId}")
    private int medTypeId;

    @PostConstruct
    public void init() {
        media = mediaTypeFacade.find(medTypeId);
        if(media.getMtype()=='C'){
            cd = cdFacade.find(medTypeId);
            List<Track> lt = cd.getTracks();
            Track t;
            for(int i=0;i<lt.size();i++){
                t = lt.get(i);
                listSongs.add(t.getTrackTitle());
            }
        }   
    }

    public MediaType getMedia() {
        return media;
    }

    public List<String> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<String> listSongs) {
        this.listSongs = listSongs;
    }

    public void setMedia(MediaType media) {
        this.media = media;
    }

    public int getMedTypeId() {
        return medTypeId;
    }

    public void setMedTypeId(int medTypeId) {
        this.medTypeId = medTypeId;
    }

    public Track getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }    
}
