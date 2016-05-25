/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author karelwinderickx
 */
@Stateful
public class ShoppingCart implements ShoppingCartRemote {

    private Integer uid;
    private ArrayList<Integer> products;

    @PostConstruct
    private void create() {
        products = new ArrayList<Integer>();
    }

    @Override
    public void init(Integer id) {
        if (id == null) {
            uid = id;
        }
    }

    @Override
    public void addToCart(int productId) {
        products.add(productId);
    }

    @Override
    public void removeFromCart(int productId) {
        products.remove(productId);
    }

}
