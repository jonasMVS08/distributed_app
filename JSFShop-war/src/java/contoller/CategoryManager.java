/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.Category;
import entity.MediaType;
import entity.Order;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import session.CategoryFacade;
import session.CdFacade;
import session.MediaTypeFacade;
import session.OrderFacade;
import session.TrackFacade;

/**
 *
 * @author karelwinderickx
 */
@Named(value = "categoryManager")
@ManagedBean
@RequestScoped
public class CategoryManager implements Serializable{

    @EJB
    OrderFacade orderFacade;

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
    @ManagedProperty(value="#{param.addId}")
    private int addId = 0;
    
    @PostConstruct
    public void init() {
        int in = 1;
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

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }
}
