/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.Category;
import entity.Cd;
import entity.MediaType;
import entity.Track;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import session.CategoryFacade;
import session.CdFacade;
import session.MediaTypeFacade;
import session.TrackFacade;

/**
 *
 * @author karelwinderickx
 */

@ManagedBean
@RequestScoped
public class CategoryManager implements Serializable{

    private List<Category> categories;
    private List<MediaType> mediaTypes;
    @EJB
    CategoryFacade categoryFacade;
    @EJB
    MediaTypeFacade mediaTypeFacade;
    @EJB
    CdFacade cdFacade;
    @EJB
    TrackFacade trackFacade;
    
    @ManagedProperty(value="#{param.catId}")
    private char catId;
    
    @PostConstruct
    public void init() {
        categories = categoryFacade.findAll();   
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    
    public char getCatId() {
        return catId;
    }

    public void setCatId(char catId) {
        this.catId = catId;
    }
        
    public List<MediaType> getMediaTypes() {        
        mediaTypes = mediaTypeFacade.getCollection(catId);
        return mediaTypes;
    }
    
}
