/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.time.LocalDate;

/**
 *
 * @author 24emilaj
 */
public class Price {

    private int priceID, traytypeID;
    private LocalDate dateUpdated;
    private double price;

    /**
     * Constructor method for the price class
     *
     * @param priceID - id for that price
     * @param traytypeID - id for type of tray (tray size)
     * @param dateUpdated - date at which prices were updated
     * @param price - price of egg tray
     */
    public Price(int priceID, int traytypeID, LocalDate dateUpdated, double price) {
        this.priceID = priceID;
        this.traytypeID = traytypeID;
        this.dateUpdated = dateUpdated;
        this.price = price;
    }

    /**
     * Constructor method for the price class Will only be used for inserting
     * new prices
     *
     * @param traytypeID - id for type of tray (tray size)
     * @param dateUpdated - date at which prices were updated
     * @param price - price of egg tray
     */
    public Price(int traytypeID, LocalDate dateUpdated, double price) {
        this.traytypeID = traytypeID;
        this.dateUpdated = dateUpdated;
        this.price = price;
    }

    public int getPriceID() {
        return priceID;
    }

    public int getTraytypeID() {
        return traytypeID;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Price{" + "priceID=" + priceID + ", traytypeID=" + traytypeID + ", dateUpdated=" + dateUpdated + ", price=" + price + '}';
    }
    
    

}
