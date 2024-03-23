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
public class Invoice {

    private int invoiceID, clientID;
    private LocalDate date;
    private int trayTypeID, quantity, dicountPercentage;
    
    /**
     * Constructor method for the invoice class
     * @param invoiceID - id for database to identify the invoice
     * @param clientID - id for the database to identify the client
     * @param date - date the invoice was made
     * @param trayTypeID - the id for the database to identify the trayType
     * @param quantity - the quantity of the certain trayType in the order
     * @param dicountPercentage - the percentage they get off the original price of the tray
     */

    public Invoice(int invoiceID, int clientID, LocalDate date, int trayTypeID, int quantity, int dicountPercentage) {
        this.invoiceID = invoiceID;
        this.clientID = clientID;
        this.date = date;
        this.trayTypeID = trayTypeID;
        this.quantity = quantity;
        this.dicountPercentage = dicountPercentage;
    }

    /**
     *Constructor method for the invoice class Will only be used for
     * inserting new invoices
     *
     * @param clientID - id for the database to identify the client
     * @param date - date the invoice was made
     * @param trayTypeID - the id for the database to identify the trayType
     * @param quantity - the quantity of the certain trayType in the order
     * @param dicountPercentage - the percentage they get off the original price of the tray
     */
    public Invoice(int clientID, LocalDate date, int trayTypeID, int quantity, int dicountPercentage) {
        this.clientID = clientID;
        this.date = date;
        this.trayTypeID = trayTypeID;
        this.quantity = quantity;
        this.dicountPercentage = dicountPercentage;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public int getClientID() {
        return clientID;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTrayTypeID() {
        return trayTypeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDicountPercentage() {
        return dicountPercentage;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceID=" + invoiceID + ", clientID=" + clientID + ", date=" + date + ", trayTypeID=" + trayTypeID + ", quantity=" + quantity + ", dicountPercentage=" + dicountPercentage + '}';
    }
    
    

}
