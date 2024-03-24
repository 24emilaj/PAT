/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author 24emilaj
 */
public class DataHandler {

    //Client
    /**
     * This method gets all of the clients in the database makes client objects
     * from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Client> - contains all clients in the database
     */
    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblclients";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int clientID = rs.getInt("clientID");
                String clientname = rs.getString("clientName");
                String contactname = rs.getString("contactName");
                String contactNum = rs.getString("contactNum");
                String deliveryAddress = rs.getString("deliveryAddress");
                String area = rs.getString("Area");
                String email = rs.getString("Email");

                Client c = new Client(clientID, clientname, contactname, contactNum, deliveryAddress, area, email);
                clients.add(c);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return clients;
    }

    /**
     * take a client as a parameter and insert it into the database
     *
     * @param c - the client to be inserted
     * @return number of rows changed
     */
    public int insertNewClient(Client c) {
        int numRows = 0;
        try {
            //INSERT INTO tblClients(clientName,contactName,contactNum,deliveryAddress,Area,Email)VALUES ( "Major Frasers","Julian","046-0040006, 0766406139","Opp the Arch, Somerset Str, Grahamstown","GHT","chef@majorfrasers.co.za");
            String sql = "INSERT INTO tblClients(clientName,contactName,contactNum,deliveryAddress,Area,Email)VALUES (\"" + c.getClientname() + "\",\"" + c.getContactname() + "\",\"" + c.getContactNum() + "\",\"" + c.getDeliveryAddress() + "\",\"" + c.getArea() + "\",\"" + c.getEmail() + "\")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes client from the database
     *
     * @param c - the client to be deleted
     * @return number of rows changed
     */
    public int deleteClient(Client c) {
        int numRows = 0;
        try {
            //DELETE FROM tblClients WHERE clientID =6
            String sql = "DELETE FROM tblClients WHERE clientID = " + c.getClientID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a client as a parameter and updates in the database
     *
     * @param c - the client to be updated
     * @return number of rows changed
     */
    public int updateClient(Client c) {
        int numRows = 0;
        try {
            //UPDATE tblClients SET clientName = "George", contactName = "G", contactNum = "123456", deliveryAddress = "there" , Area = "NAM", Email = "life@food.com" WHERE clientID = 7
            String sql = "UPDATE tblClients SET clientName = \"" + c.getClientname() + "\", contactName = \"" + c.getContactNum()
                    + "\", contactNum = \"" + c.getContactNum() + "\", deliveryAddress = \"" + c.getDeliveryAddress() + "\", Area = \""
                    + c.getArea() + "\", Email = \"" + c.getEmail() + "\" WHERE clientID = " + c.getClientID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }
    //********************************************************************************************************************************
    //Price
    /**
     * This method gets all of the prices in the database makes Price objects
     * from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Price> - contains all prices in the database
     */
    public ArrayList<Price> getAllPrices() {
        ArrayList<Price> prices = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblprice";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int priceID = rs.getInt("priceID");
                int trayTypeID = rs.getInt("trayTypeID");
                LocalDate dateUpdated = rs.getDate("dateUpdated").toLocalDate();
                double price = rs.getDouble("price");
                Price p = new Price(priceID, trayTypeID, dateUpdated, price);
                //System.out.println(p);
                prices.add(p);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return prices;
    }

    /**
     * take a price as a parameter and insert it into the database
     *
     * @param p - the price to be inserted
     * @return number of rows changed
     */
    public int insertNewPrice(Price p) {
        int numRows = 0;
        try {
            //INSERT INTO tblPrice(trayTypeID,dateUpdated,price) VALUES(1,"2023-09-16",2.56)
            String sql = "INSERT INTO tblPrice(trayTypeID,dateUpdated,price) VALUES(" + p.getTraytypeID() + ",\"" + p.getDateUpdated() + "\"," + p.getPrice() + ")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes price from the database
     *
     * @param p - the price to be deleted
     * @return number of rows changed
     */
    public int deletePrice(Price p) {
        int numRows = 0;
        try {
            //DELETE FROM tblPrice WHERE priceID = 5
            String sql = "DELETE FROM tblPrice WHERE priceID =" + p.getPriceID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a price as a parameter and updates in the database
     *
     * @param p - the price to be updated
     * @return number of rows changed
     */
    public int updatePrice(Price p) {
        int numRows = 0;
        try {
            //UPDATE tblPrice SET trayTypeID = 3, dateUpdated = "2024-12-12", price = 2.33 WHERE priceID = 6
            String sql = "UPDATE tblPrice SET trayTypeID = " + p.getTraytypeID() + ", dateUpdated = \"" + p.getDateUpdated() 
                    + "\", price = " + p.getPrice() + " WHERE priceID = " + p.getPriceID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }
    //********************************************************************************************************************************
    //Eggs
    /**
     * This method gets all of the eggs in the database makes eggs objects from
     * data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Eggs> - contains all eggs in the database
     */
    public ArrayList<Eggs> getAllEggs() {
        ArrayList<Eggs> eggs = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tbleggs";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int eggBatchID = rs.getInt("eggBatchID");
                LocalDate date = rs.getDate("date").toLocalDate();
                int amount = rs.getInt("amount");
                Eggs egg = new Eggs(eggBatchID,date,amount);
                eggs.add(egg);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return eggs;
    }
       /**
     * take a eggBatch as a parameter and insert it into the database
     *
     * @param egg - the eggBatch to be inserted
     * @return number of rows changed
     */
    public int insertEggs(Eggs egg) {
        int numRows = 0;
        try {
            //INSERT INTO tblEggs(date,amount) VALUES("2024-03-23",2345)
            String sql = "INSERT INTO tblEggs(date,amount) VALUES(\"" + egg.getDate() + "\", "+  egg.getAmount() + ")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes eggBatch from the database
     *
     * @param egg - the eggBatch to be deleted
     * @return number of rows changed
     */
    public int deleteEggs(Eggs egg) {
        int numRows = 0;
        try {
            //DELETE FROM tblEggs WHERE eggBatchID = 4
            String sql = "DELETE FROM tblEggs WHERE eggBatchID = " + egg.getEggBatchID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a eggBatch as a parameter and updates in the database
     *
     * @param egg - the eggBatch to be updated
     * @return number of rows changed
     */
    public int updateEggs(Eggs egg) {
        int numRows = 0;
        try {
            //UPDATE tblEggs SET date = "2024-03-23", amount = 1234 WHERE eggBatchID = 4
            String sql = "UPDATE tblEggs SET date = \"" + egg.getDate()+ "\", amount = " + egg.getAmount()
                    + "WHERE eggBatchID = " + egg.getEggBatchID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }
    

    
    //********************************************************************************************************************************
    //Invoice
    /**
     * This method gets all of the invoices in the database makes invoice
     * objects from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Invoice> - contains all invoices in the database
     */
    public ArrayList<Invoice> getAllInvoices() {
        ArrayList<Invoice> invoices = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblinvoice";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int invoiceID = rs.getInt("invoiceID");
                int clientID = rs.getInt("clientID");
                LocalDate date = rs.getDate("date").toLocalDate();
                int trayTypeID = rs.getInt("trayTypeID");
                int quantity = rs.getInt("quantity");
                int discountPercentage = rs.getInt("discountPercentage");
                Invoice i = new Invoice(invoiceID, clientID, date, trayTypeID, quantity, discountPercentage);
                invoices.add(i);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return invoices;
    }
    
           /**
     * take a invoice as a parameter and insert it into the database
     *
     * @param i - the invoice to be inserted
     * @return number of rows changed
     */
    public int insertInvoice(Invoice i) {
        int numRows = 0;
        try {
            //INSERT INTO tblInvoice(clientID,date,trayTypeID,quantity,discountPercentage) VALUES (3,"2019-06-20",2,6,15)
            String sql = "INSERT INTO tblInvoice(clientID,date,trayTypeID,quantity,discountPercentage) VALUES (" + i.getClientID() 
                    + ", \"" + i.getDate() + "\", " + i.getTrayTypeID() + ", " + i.getQuantity() + ", " + i.getDicountPercentage() + ")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes invoice from the database
     *
     * @param i - the invoice to be deleted
     * @return number of rows changed
     */
    public int deleteInvoice(Invoice i) {
        int numRows = 0;
        try {
            //DELETE FROM tblinvoice WHERE invoiceID = 5
            String sql = "DELETE FROM tblinvoice WHERE invoiceID = " + i.getInvoiceID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a invoice as a parameter and updates in the database
     *
     * @param i - the invoice to be updated
     * @return number of rows changed
     */
    public int updateInvoice(Invoice i) {
        int numRows = 0;
        try {
            //UPDATE tblInvoice SET clientID = 1, date = "2023-09-16", trayTypeID = 3, quantity = 100, discountPercentage = 17 WHERE invoiceID = 4
            String sql = "UPDATE tblInvoice SET clientID = " + i.getClientID() + ", date = \"" + i.getDate()
                    + "\", trayTypeID = " + i.getTrayTypeID() + ", quantity = " + i.getQuantity() + ", discountPercentage = "
                    + i.getDicountPercentage() + " WHERE invoiceID = " + i.getInvoiceID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }
    //********************************************************************************************************************************
    //Orders
    /**
     * This method gets all of the orders in the database makes orders objects
     * from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Orders> - contains all orders in the database
     */
    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> orders = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblorders";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int trackingID = rs.getInt("trackingID");
                int invoiceID = rs.getInt("invoiceID");
                boolean paid = rs.getBoolean("paid");
                boolean delivered = rs.getBoolean("delivered");
                Orders o = new Orders(trackingID, invoiceID, paid, delivered);
                orders.add(o);
            }
            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return orders;
    }
    
          /**
     * take a order as a parameter and insert it into the database
     *
     * @param o - the order to be inserted
     * @return number of rows changed
     */
    public int insertOrders(Orders o) {
        int numRows = 0;
        try {
            //INSERT INTO tblorders(invoiceID, paid, delivered) VALUES (3,0,0)
            String sql = "INSERT INTO tblorders(invoiceID, paid, delivered) VALUES(" + o.getInvoiceID() + ", " + o.isPaid() + ", " + o.isDelivered() + ")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes order from the database
     *
     * @param o - the eggBatch to be deleted
     * @return number of rows changed
     */
    public int deleteOrders(Orders o) {
        int numRows = 0;
        try {
            //DELETE FROM tblorders WHERE trackingID = 5
            String sql = "DELETE FROM tblorders WHERE trackingID = " + o.getTrackingID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a order as a parameter and updates in the database
     *
     * @param o - the order to be updated
     * @return number of rows changed
     */
    public int updateOrders(Orders o) {
        int numRows = 0;
        try {
            //UPDATE tblorders SET invoiceID = 10, paid = 1, delivered = 1 WHERE trackingID = 6
            String sql = "UPDATE tblorders SET invoiceID = " + o.getInvoiceID() + ", paid = " + o.isPaid() + ", delivered = "
                   + o.isDelivered() + " WHERE trackingID = " + o.getTrackingID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }
    //********************************************************************************************************************************
    //TrayTypes
    /**
     * This method gets all of the traytypes in the database makes trayTypes
     * objects from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<TrayTypes> - contains all traytypes in the database
     */
    public ArrayList<TrayTypes> getAlltrayTypes() {
        ArrayList<TrayTypes> trayTypes = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tbltraytypes";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int trayTypeID = rs.getInt("trayTypeID");
                String type = rs.getString("type");
                TrayTypes t = new TrayTypes(trayTypeID, type);
                trayTypes.add(t);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return trayTypes;
    }
    
           /**
     * take a trayType as a parameter and insert it into the database
     *
     * @param t - the trayType to be inserted
     * @return number of rows changed
     */
    public int insertTrayTypes (TrayTypes t) {
        int numRows = 0;
        try {
            //INSERT INTO tbltraytypes(traytypeID, type) VALUES (4,"24's")
            String sql = "INSERT INTO tbltraytypes(traytypeID, type) VALUES(" + t.getTrayTypeID() + ", \"" + t.getType() + "\")";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes trayType from the database
     *
     * @param t - the trayType to be deleted
     * @return number of rows changed
     */
    public int deleteTrayTypes (TrayTypes t) {
        int numRows = 0;
        try {
            //DELETE FROM tbltraytypes WHERE trayTypeID = 4
            String sql = "DELETE FROM tbltraytypes WHERE trayTypeID = " + t.getTrayTypeID() +  ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a trayType as a parameter and updates in the database
     *
     * @param t - the trayType to be updated
     * @return number of rows changed
     */
    public int updateTrayTypes(TrayTypes t) {
        // fix updates!!!!
        int numRows = 0;
        try {
            //UPDATE chickenfarmdb.tblTrayTypes SET traytypeID = 5, type = "1" WHERE trayTypeID = 9
            String sql = "UPDATE tblTrayTypes SET traytypeID = " + t.getTrayTypeID() + ", type = \"" + t.getType() 
                    + "\" WHERE traytypeID = " + t.getTrayTypeID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

}
