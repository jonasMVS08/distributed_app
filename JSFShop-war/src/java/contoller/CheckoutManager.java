/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import entity.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import session.CustomerFacade;
import session.ShoppingCartRemote;

/**
 *
 * @author karelwinderickx
 */
@Named(value = "checkoutManager")
@ManagedBean
@RequestScoped
public class CheckoutManager implements Serializable {

    private Customer customer;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String cityRegion;
    @NotNull
    private String ccNumber;
    
    @EJB
    private ShoppingCartRemote shoppingCart;

    @EJB
    private CustomerFacade customerFacade;

    public void submit() {
        Integer uId = shoppingCart.getUid();
        customer.setId(uId);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCcNumber(ccNumber);
        customer.setCityRegion(cityRegion);
        customerFacade.create(customer);
        System.out.println("Customer " + name + " added to database!");
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCityRegion() {
        return cityRegion;
    }
    
    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }
    
    public String getCcNumber() {
        return ccNumber;
    }
    
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
}
