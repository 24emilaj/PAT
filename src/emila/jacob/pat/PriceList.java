/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emila.jacob.pat;

import java.time.LocalDate;

/**
 *
 * @author JJacob
 */
public class PriceList {
    private String trayType;
    private double price;
    private LocalDate dateImplemented;

    public PriceList(String trayType, double price, LocalDate dateImplemented) {
        this.trayType = trayType;
        this.price = price;
        this.dateImplemented = dateImplemented;
    }

    public String getTrayType() {
        return trayType;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDateImplemented() {
        return dateImplemented;
    }

    @Override
    public String toString() {
        return "PriceList{" + "trayType=" + trayType + ", price=" + price + ", dateImplemented=" + dateImplemented + '}';
    }
    
    
}
