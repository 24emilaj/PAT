/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emila.jacob.pat;

/**
 *
 * @author JJacob
 */
public class InvoiceList {
    //clientName,contactName,contactNumber, paymentContact, deliveryAddress,
//tbltraytypes.type, quantity, paymentType,
//tblprice.price*tblinvoice.discountPercentage/100 AS Price,
//delivered, paid
    private String clientName,contactName,contactNumber, paymentContact, deliveryAddress,type;
    private int quantity;
    private String paymentType;
    private double price;
    private boolean delivered,paid;

    public InvoiceList(String clientName, String contactName, String contactNumber, String paymentContact, String deliveryAddress, String type, int quantity, String paymentType, double price, boolean delivered, boolean paid) {
        this.clientName = clientName;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.paymentContact = paymentContact;
        this.deliveryAddress = deliveryAddress;
        this.type = type;
        this.quantity = quantity;
        this.paymentType = paymentType;
        this.price = price;
        this.delivered = delivered;
        this.paid = paid;
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

    public int getQuantity() {
        return quantity;
    }

    public String getPaymentType() {
        return paymentType;
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

    @Override
    public String toString() {
        return "InvoiceList{" + "clientName=" + clientName + ", contactName=" + contactName + ", contactNumber=" + contactNumber + ", paymentContact=" + paymentContact + ", deliveryAddress=" + deliveryAddress + ", type=" + type + ", quantity=" + quantity + ", paymentType=" + paymentType + ", price=" + price + ", delivered=" + delivered + ", paid=" + paid + '}';
    }
    
    
}
