/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.Category;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import session.CategoryFacade;

/**
 *
 * @author karelwinderickx
 */

@ManagedBean
@ViewScoped
public class CategoryManager implements Serializable{
    private List<Category> categories;
    private String media;
    private char cat_type;
    
    @EJB
    CategoryFacade categoryFacade;
    
    @PostConstruct
    public void init() {
        categories = categoryFacade.findAll();
        
        //categories = categoryFacade.getCollection();
    }
    
    public List<Category> getCategories() {
        return categories;
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
    
}
