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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
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
    @Size(min = 2, max = 16, message = "Fill in a name\n")
    private String name;
    @NotNull
    @Email(message = "Invalid email address\n")
    @Size(min = 4, max = 30, message = "Invalid email address\n")
    private String email;
    @NotNull
    @Size(min = 9, max = 14, message = "Invalid phone number\n")
    private String phone;
    @NotNull
    @Size(min = 5, max = 32, message = "Invalid address\n")
    private String address;
    @NotNull
    @Size(min = 4, max = 6, message = "Invalid city region\n")
    private String cityRegion;
    @NotNull
    @Size(min = 16, max = 19, message = "Invalid creditcard number\n")
    private String ccNumber;
    private Integer uId;
    
    private float shippingCost = 3;
    
    @EJB
    private ShoppingCartRemote shoppingCart;

    @EJB
    private CustomerFacade customerFacade;

    public void submit() {
        uId = shoppingCart.getUid();
        customer = new Customer();
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
    
    public float getShippingCost() {
        return shippingCost;
    }
    
    public float getTotalPrice() {
        float price = shoppingCart.getTotalPrice() + shippingCost;
        return price;
    }
}
