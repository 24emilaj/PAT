/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emila.jacob.pat;

/**
 *
 * @author JJacob
 */
public class salesAnalysis {
                //SELECT clientName, price, quantity, discountPercentage, invoiceid
            //FROM chickenfarmdb.tblinvoice, chickenfarmdb.tblclients, chickenfarmdb.tblprice
            //WHERE tblinvoice.clientID = tblclients.clientID
            //AND tblprice.dateUpdated = tblinvoice.date
private String clientName;
private double price;
private int quantity, discountPercentage, invoiceID;
 

//private int numOrders;
//private double totalIncome;
//
//private Client[] clients;
//private Orders[] orders;
//private Invoice[] invoices;



//    public salesAnalysis() {
//        
//      //  String [][] arrays = new String[][]{clients,orders,invoices};
//        DataHandler dh = new DataHandler();
//       // Client clients = new Client();
//        for (int i = 0; i < dh.getAllClients().size(); i++) {
//          //  clientName = dh.getAllClients().;
//            //currently gets num of all orders and needs orders from 1 client if client id = id
////            if (clients[i].getClientID() == ) {
////                
////            }
//            numOrders = dh.getAllOrders().size();
//          //  totalIncome = dh.getAllInvoices();
//          
//          
//        }
//        
//    }

    public salesAnalysis(String clientName, double price, int quantity, int discountPercentage, int invoiceID) {
        this.clientName = clientName;
        this.price = price;
        this.quantity = quantity;
        this.discountPercentage = discountPercentage;
        this.invoiceID = invoiceID;
    }

    public String getClientName() {
        return clientName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    @Override
    public String toString() {
        return "salesAnalysis{" + "clientName=" + clientName + ", price=" + price + ", quantity=" + quantity + ", discountPercentage=" + discountPercentage + ", invoiceID=" + invoiceID + '}';
    }
    
    


}
