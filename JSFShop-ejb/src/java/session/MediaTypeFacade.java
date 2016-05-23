/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.MediaType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonas
 */
@Stateless
public class MediaTypeFacade extends AbstractFacade<MediaType> {

    @PersistenceContext(unitName = "JSFShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediaTypeFacade() {
        super(MediaType.class);
    }
    
    public List<MediaType> getCollection(char type){
        List<MediaType> results = em.createQuery("SELECT m FROM mediatype m WHERE m.mtype='"+type+"'").getResultList();
        return results;
    }
    
}
