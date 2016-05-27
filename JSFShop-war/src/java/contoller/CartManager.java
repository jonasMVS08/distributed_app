/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import session.ShoppingCartRemote;

/**
 *
 * @author Jonas
 */
@Named(value = "cartManager")
@ManagedBean
@SessionScoped
public class CartManager implements Serializable{

    @EJB
    ShoppingCartRemote shoppingCart;
    private int product;
    private int cartSize;
       
    public CartManager() {
    }
    
    public void addToCart(int productId){
        int j = shoppingCart.getUid();
        if(shoppingCart.getUid() == 0 && productId != 0){
            shoppingCart.init();
            int u = shoppingCart.getUid();
            shoppingCart.addToCart(productId);
            int aantal = shoppingCart.numberOfItems();
            System.out.println("Product added: " + productId);
        } else if(shoppingCart.getUid() != null && productId != 0) {
            shoppingCart.addToCart(productId);
            int aantal = shoppingCart.numberOfItems();
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
