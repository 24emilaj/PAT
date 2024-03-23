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
     * clientname,contactname,contactNum, deliveryAddress, area, email
     */
    private int clientID;
    private String clientname, contactname, contactNum, deliveryAddress, area, email;

    /**
     * Constructor method for the client class
     *
     * @param clientID - the id the database gives the client
     * @param clientname - name of client
     * @param contactname - name to contact client by
     * @param contactNum - number used to contact client
     * @param deliveryAddress - where the client wants the eggs delivered
     */

    public Client(int clientID, String clientname, String contactname, String contactNum, String deliveryAddress, String area, String email) {
        this.clientID = clientID;
        this.clientname = clientname;
        this.contactname = contactname;
        this.contactNum = contactNum;
        this.deliveryAddress = deliveryAddress;
        this.area = area;
        this.email = email;
    }


    /**
     * Constructor method for the client class 
     * Will only be used for inserting new clients
     *
     * @param clientname - name of client
     * @param contactname - name to contact client by
     * @param contactNum - number used to contact client
     * @param deliveryAddress - where the client wants the eggs delivered
     */

    public Client(String clientname, String contactname, String contactNum, String deliveryAddress, String area, String email) {
        this.clientname = clientname;
        this.contactname = contactname;
        this.contactNum = contactNum;
        this.deliveryAddress = deliveryAddress;
        this.area = area;
        this.email = email;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return clientID + ", " + clientname + ", " + contactname + ", " + contactNum + ", " + deliveryAddress + ", " + area + ", " + email;
    }

}
