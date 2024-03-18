/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

/**
 *
 * @author 24emilaj
 */
public class Orders {
private int trackingID, invoiceID;
private boolean paid, delivered;

    public Orders(int trackingID, int invoiceID, boolean paid, boolean delivered) {
        this.trackingID = trackingID;
        this.invoiceID = invoiceID;
        this.paid = paid;
        this.delivered = delivered;
    }

}
