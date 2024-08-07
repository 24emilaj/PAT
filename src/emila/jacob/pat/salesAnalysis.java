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
private double totalIncome;
private int numOrders;

    public salesAnalysis(String clientName, double totalIncome, int numOrders) {
        this.clientName = clientName;
        this.totalIncome = totalIncome;
        this.numOrders = numOrders;
    }

    

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    @Override
    public String toString() {
        return "salesAnalysis{" + "clientName=" + clientName + ", totalIncome=" + totalIncome + ", numOrders=" + numOrders + '}';
    }

 


 


    
    


}
