/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import session.MediaTypeFacade;
import session.ShoppingCartRemote;

/**
 *
 * @author Jonas
 */
@Named(value = "cartManager")
@ManagedBean
@ApplicationScoped
public class CartManager implements Serializable{

    @EJB
    ShoppingCartRemote shoppingCart;
    @EJB
    MediaTypeFacade mediaTypeFacade;
    private int product;
    private int cartSize;
    private int quantity;
    private ArrayList<MediaType> products;
    private String totalPrice;
    private boolean discount = false;
    private String shipping;
       
    public void addToCart(int productId){
        int j = shoppingCart.getUid();
        if(shoppingCart.getUid() == 0 && productId != 0){
            shoppingCart.init();
            int u = shoppingCart.getUid();
            shoppingCart.addToCart(productId);
            shoppingCart.setTotalPrice(mediaTypeFacade.find(productId).getPrice());
        } else if(shoppingCart.getUid() != null && productId != 0) {
            shoppingCart.addToCart(productId);
            shoppingCart.setTotalPrice(mediaTypeFacade.find(productId).getPrice());
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

    public ArrayList<MediaType> getProducts() {
        return shoppingCart.getProducts();
    }

    public void setProducts(ArrayList<MediaType> products) {
        this.products = products;
    }

    public int getQuantity(int productId) {
        return shoppingCart.getQuantity(productId);
    }

    public void setQuantity(int productId, int quantity) {
        shoppingCart.setQuantity(productId, quantity);
    }
    
    public boolean getDiscount() {
        discount = shoppingCart.getDiscount();
        return discount;
    }
    
    public void setDiscount(boolean disc) {
        discount = disc;
        shoppingCart.setDiscount(disc);
    }

    public void clearCart(){
        shoppingCart.clearCart();
    }

    public String getTotalPrice() {
        return String.format("%.2f",shoppingCart.getTotalPrice());
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = Float.toString(totalPrice);
    }

    public String getShipping() {
        return String.format("%.2f",(shoppingCart.getTotalPrice() + 3));
    }
    
}