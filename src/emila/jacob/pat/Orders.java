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
/**
 * Constructor method for orders class
 * @param trackingID - id used to find order in database
 * @param invoiceID - id used to find the invoice in the database
 * @param paid - boolean for whether or not client has paid for order
 * @param delivered - boolean for whether or not order has been delivered to client
 */
    public Orders(int trackingID, int invoiceID, boolean paid, boolean delivered) {
        this.trackingID = trackingID;
        this.invoiceID = invoiceID;
        this.paid = paid;
        this.delivered = delivered;
    }

   /**
 * Constructor method for orders class used for insert method
 * @param invoiceID - id used to find the invoice in the database
 * @param paid - boolean for whether or not client has paid for order
 * @param delivered - boolean for whether or not order has been delivered to client
    */ 
    public Orders(int invoiceID, boolean paid, boolean delivered) {
        this.invoiceID = invoiceID;
        this.paid = paid;
        this.delivered = delivered;
    }

    public int getTrackingID() {
        return trackingID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Orders{" + "trackingID=" + trackingID + ", invoiceID=" + invoiceID + ", paid=" + paid + ", delivered=" + delivered + '}';
    }
    
    

}
