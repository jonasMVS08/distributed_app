/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author SLAM
 */
public class InterceptorManager implements PhaseListener {
       @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
    
        @Override
    public void beforePhase(PhaseEvent event) {
       
            System.out.println("Before - " + event.getPhaseId().toString());
        
        
    }
    
    // When add to shopping cart is clicked
    // And if chart has more than X items
    @Override
    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("after - " + event.getPhaseId().toString());
        }
    } 

    
}