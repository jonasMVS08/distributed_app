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
import javax.faces.bean.SessionScoped;
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
    
    @EJB
    CategoryFacade categoryFacade;
    
    @PostConstruct
    public void init() {
        categories = categoryFacade.getCollection();
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    
}
