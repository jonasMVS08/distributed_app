/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.xml.ws.Action;
import session.ShoppingCartRemote;

/**
 *
 * @author Jonas
 */
@Named(value = "cartManager")
@ManagedBean
@RequestScoped
public class CartManager implements Serializable{

    @EJB
    ShoppingCartRemote shoppingCart;
    private int product;
    private int cartSize;
       
    public CartManager() {
    }
    
    public void addToCart(int productId){
        if(shoppingCart.getUid() == null && productId == 0){
            shoppingCart.init(productId);
            System.out.println("Product added: " + productId);
        } else {
            System.out.println("Product added: " + productId);
        }
    }

    public int getCartSize() {
        cartSize = shoppingCart.numberOfItems();
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    public int getProduct() {
        return product;
    }

    /*public void setProduct(int product) {
        if(shoppingCart.getUid() == null && medTypeId != 0){
            shoppingCart.init(medTypeId);
        }
    }   */
}
