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
public class OrderContents {
private int invoiceID, clientID, typeID, quantity, dicountPercentage;    
private LocalDate date;

    public OrderContents(int invoiceID, int clientID, int typeID, int quantity, int dicountPercentage, LocalDate date) {
        this.invoiceID = invoiceID;
        this.clientID = clientID;
        this.typeID = typeID;
        this.quantity = quantity;
        this.dicountPercentage = dicountPercentage;
        this.date = date;
    }

    
}
