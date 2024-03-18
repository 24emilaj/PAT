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

    public Price(int priceID, int traytypeID, LocalDate dateUpdated, double price) {
        this.priceID = priceID;
        this.traytypeID = traytypeID;
        this.dateUpdated = dateUpdated;
        this.price = price;
    }


}
