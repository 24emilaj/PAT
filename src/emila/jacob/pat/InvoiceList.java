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
public class InvoiceList {
    //clientName,contactName,contactNumber, paymentContact, deliveryAddress,
//tbltraytypes.type, quantity, paymentType,
//tblprice.price*tblinvoice.discountPercentage/100 AS Price,
//delivered, paid
    private int invoiceID, clientID;
    private String clientName,contactName,contactNumber, paymentContact, deliveryAddress,type;
    private String quantity;
    private String paymentType;
    private LocalDate date;
    private double price;
    private boolean delivered,paid;

    public InvoiceList(int invoiceID, int clientID, String clientName, String contactName, String contactNumber, String paymentContact, String deliveryAddress, String type, String quantity, String paymentType, LocalDate date, double price, boolean delivered, boolean paid) {
        this.invoiceID = invoiceID;
        this.clientID = clientID;
        this.clientName = clientName;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.paymentContact = paymentContact;
        this.deliveryAddress = deliveryAddress;
        this.type = type;
        this.quantity = quantity;
        this.paymentType = paymentType;
        this.date = date;
        this.price = price;
        this.delivered = delivered;
        this.paid = paid;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPaymentContact() {
        return paymentContact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public boolean isPaid() {
        return paid;
    }



    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InvoiceList{" + "invoiceID=" + invoiceID + ", clientID=" + clientID + ", clientName=" + clientName + ", contactName=" + contactName + ", contactNumber=" + contactNumber + ", paymentContact=" + paymentContact + ", deliveryAddress=" + deliveryAddress + ", type=" + type + ", quantity=" + quantity + ", paymentType=" + paymentType + ", date=" + date + ", price=" + price + ", delivered=" + delivered + ", paid=" + paid + '}';
    }
    
    
    

  



    
    
}
