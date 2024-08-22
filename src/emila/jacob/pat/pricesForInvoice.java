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
public class pricesForInvoice {

    private int invoiceID, trayTypeID;
    private String type;
    private double price;
    private LocalDate dateUpdated;
    private int discountPercentage, quantity;

    public pricesForInvoice(int invoiceID, int trayTypeID, String type, double price, LocalDate dateUpdated, int discountPercentage, int quantity) {
        this.invoiceID = invoiceID;
        this.trayTypeID = trayTypeID;
        this.type = type;
        this.price = price;
        this.dateUpdated = dateUpdated;
        this.discountPercentage = discountPercentage;
        this.quantity = quantity;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public int getTrayTypeID() {
        return trayTypeID;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "pricesForInvoice{" + "invoiceID=" + invoiceID + ", trayTypeID=" + trayTypeID + ", type=" + type + ", price=" + price + ", dateUpdated=" + dateUpdated + ", discountPercentage=" + discountPercentage + ", quantity=" + quantity + '}';
    }

}
