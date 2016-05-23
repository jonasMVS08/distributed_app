/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonas
 */
@Entity
@DiscriminatorValue(value="G")
public class Games extends MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String publisher;
    @Enumerated
    private ConsoleType consoleType;

    public Games() {
    }

    public Games(int id, String publisher, char mtype, String title, float price, String genre, int published, ConsoleType consoleType) {
        super(id, mtype, title, price, genre, published);
        this.publisher = publisher;
        this.consoleType = consoleType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public ConsoleType getConsoleType() {
        return consoleType;
    }

    public void setConsoleType(ConsoleType consoleType) {
        this.consoleType = consoleType;
    }

        
}
