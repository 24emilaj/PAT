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
public class Client {

    /**
     * initializes int clientID initializes String
     * clientname,contactname,contactNum, paymentContact, deliveryAddress, area,
     * email
     */
    private int clientID;
    private String clientname, contactname, contactNum, paymentContact, deliveryAddress, area, email;

    /**
     * Constructor method for the client class
     *
     * @param clientID - the id the database gives the client
     * @param clientname - name of client
     * @param contactname - name to contact client by
     * @param contactNum - number used to contact client
     * @param deliveryAddress - where the client wants the eggs delivered
     * @param area - area in which eggs need to be delivered
     * @param email - email address of the client
     */

    

    public Client(int clientID, String clientname, String contactname, String contactNum, String paymentContact, String deliveryAddress, String area, String email) {
        this.clientID = clientID;
        this.clientname = clientname;
        this.contactname = contactname;
        this.contactNum = contactNum;
        this.paymentContact = paymentContact;
        this.deliveryAddress = deliveryAddress;
        this.area = area;
        this.email = email;
    }



    /**
     * Constructor method for the client class Will only be used for inserting
     * new clients
     *
     * @param clientname - name of client
     * @param contactname - name to contact client by
     * @param contactNum - number used to contact client
     * @param paymentContact - the name of the person to contact for payment
     * @param deliveryAddress - where the client wants the eggs delivered
     * @param area - area in which eggs need to be delivered
     * @param email - email address of the client
      */
    
    public Client(String clientname, String contactname, String contactNum, String paymentContact, String deliveryAddress, String area, String email) {
        this.clientname = clientname;
        this.contactname = contactname;
        this.contactNum = contactNum;
        this.paymentContact = paymentContact;
        this.deliveryAddress = deliveryAddress;
        this.area = area;
        this.email = email;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientname() {
        return clientname;
    }

    public String getContactname() {
        return contactname;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getPaymentContact() {
        return paymentContact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getArea() {
        return area;
    }

    public String getEmail() {
        return email;
    }




    @Override
    public String toString() {
        return clientID + ", " + clientname + ", " + contactname + ", " + contactNum + ", " + paymentContact + ", " + deliveryAddress + ", " + area + ", " + email;
    }

}
