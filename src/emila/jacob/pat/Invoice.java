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
private int invoiceID, clientID, trayTypeID, dicountPercentage;
private LocalDate date;

    public Invoice(int invoiceID, int clientID, int trayTypeID, int dicountPercentage, LocalDate date) {
        this.invoiceID = invoiceID;
        this.clientID = clientID;
        this.trayTypeID = trayTypeID;
        this.dicountPercentage = dicountPercentage;
        this.date = date;
    }


}
