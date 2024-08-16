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
import java.time.format.DateTimeFormatter;

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
                String contactNum = rs.getString("contactNumber");
                String paymentContact = rs.getString("paymentContact");
                String deliveryAddress = rs.getString("deliveryAddress");
                String area = rs.getString("Area");
                String email = rs.getString("Email");

                Client c = new Client(clientID, clientname, contactname, contactNum, paymentContact, deliveryAddress, area, email);
                clients.add(c);
            }
            con.close();
        } catch (SQLException e) {
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
            String sql = "INSERT INTO tblClients(clientName,contactName,contactNumber,paymentContact,deliveryAddress,Area,Email)VALUES (\"" + c.getClientname() + "\",\"" + c.getContactname() + "\",\"" + c.getContactNum() + "\",\"" + c.getPaymentContact() + "\",\"" + c.getDeliveryAddress() + "\",\"" + c.getArea() + "\",\"" + c.getEmail() + "\")";
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
            //UPDATE chickenfarmdb.tblclients SET clientName = "Greg Jacobs"
            // WHERE clientName = "Greg Jacob"
            //UPDATE tblClients SET clientName = "George", contactName = "G", contactNum = "123456", deliveryAddress = "there" , Area = "NAM", Email = "life@food.com" WHERE clientID = 7
            String sql = "UPDATE tblClients SET clientName = \"" + c.getClientname() + "\", contactName = \"" + c.getContactNum()
                    + "\", contactNumber = \"" + c.getContactNum() + "\", paymentContact = \"" + c.getPaymentContact() + "\", deliveryAddress = \"" + c.getDeliveryAddress() + "\", Area = \""
                    + c.getArea() + "\", Email = \"" + c.getEmail() + "\" WHERE clientName = \"" + c.getClientname() + "\";";
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
        } catch (SQLException e) {
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
                int coopID = rs.getInt("coopID");
                LocalDate date = rs.getDate("date").toLocalDate();
                int amount = rs.getInt("amount");
                Eggs egg = new Eggs(eggBatchID, coopID, date, amount);
                eggs.add(egg);
            }
            con.close();
        } catch (SQLException e) {
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
            String sql = "INSERT INTO tblEggs(coopID,date,amount) VALUES(" + egg.getCoopID() + ",\"" + egg.getDate() + "\", " + egg.getAmount() + ")";
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
            String sql = "UPDATE tblEggs SET coopID = " + egg.getCoopID() + ", date = \"" + egg.getDate() + "\", amount = " + egg.getAmount()
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
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
                int numEggsPerType = rs.getInt("numEggsPerType");
                TrayTypes t = new TrayTypes(trayTypeID, type, numEggsPerType);
                trayTypes.add(t);
            }
            con.close();
        } catch (SQLException e) {
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
    public int insertTrayTypes(TrayTypes t) {
        int numRows = 0;
        try {
            //INSERT INTO tbltraytypes(traytypeID, type) VALUES (4,"24's")
            String sql = "INSERT INTO tbltraytypes( type,numEggsPerType) VALUES(\"" + t.getType() + "\", \"" + t.getNumEggsPerType() + "\" )";
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
    public int deleteTrayTypes(TrayTypes t) {
        int numRows = 0;
        try {
            //DELETE FROM tbltraytypes WHERE trayTypeID = 4
            String sql = "DELETE FROM tbltraytypes WHERE trayTypeID = " + t.getTrayTypeID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a trayType as a parameter and updates it in the database
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
                    + "\", numEggsPerType = \"" + t.getNumEggsPerType() + "\" WHERE traytypeID = " + t.getTrayTypeID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    //**********************************************************************************************************
    //Coop
    /**
     * This method gets all of the coops in the database makes coopName objects
     * from data, puts them in arraylist and returns arraylist
     *
     * @return arraylist<Coop> - contains all coop names in the database
     */
    public ArrayList<Coop> getAllCoops() {
        ArrayList<Coop> coops = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblcoops";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                int coopID = rs.getInt("coopID");
                String coopName = rs.getString("coopName");
                Coop c = new Coop(coopID, coopName);
                coops.add(c);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return coops;
    }

    /**
     * take a coop as a parameter and inserts it into the database
     *
     * @param c - the coopNames to be inserted
     * @return number of rows changed
     */
    public int insertCoop(Coop c) {
        int numRows = 0;
        try {
            //INSERT INTO tblcoops(coopName) VALUES("D1")
            String sql = "INSERT INTO tblcoops(coopName) VALUES( \"" + c.getCoopName() + "\")";
            Connect con = new Connect();
            con.makeChange(sql);
            //numRows++;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * deletes coopName from the database
     *
     * @param c - the coop to be deleted
     * @return number of rows changed
     */
    public int deleteCoop(Coop c) {
        int numRows = 0;
        try {
            //DELETE FROM tblcoops WHERE coopID = 9
            String sql = "DELETE FROM tblcoops WHERE coopID = " + c.getCoopID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

    /**
     * take a coop as a parameter and updates it in the database
     *
     * @param c - the coop to be updated
     * @return number of rows changed
     */
    public int updateCoop(Coop c) {

        int numRows = 0;
        try {
            //UPDATE tblcoops SET coopName = "S4" WHERE coopID = 8
            String sql = "UPDATE tblcoops SET coopName = \"" + c.getCoopName()
                    + "\"  WHERE coopID = " + c.getCoopID() + ";";
            Connect con = new Connect();
            con.makeChange(sql);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return numRows;
    }

//################################################################################################################
    //SELECT clientName, price, quantity, discountPercentage, invoiceid
    //FROM chickenfarmdb.tblinvoice, chickenfarmdb.tblclients, chickenfarmdb.tblprice
    //WHERE tblinvoice.clientID = tblclients.clientID
    //AND tblprice.dateUpdated = tblinvoice.date
//    //       public ArrayList<Coop> getAllCoops() {
//        ArrayList<Coop> coops = new ArrayList();
//        try {
//            String sql = "SELECT * FROM chickenfarmdb.tblcoops";
//            Connect con = new Connect();
//            ResultSet rs = con.query(sql);
//            while (rs.next()) {
//                int coopID = rs.getInt("coopID");
//                String coopName = rs.getString("coopName");
//                Coop c = new Coop(coopID, coopName);
//                coops.add(c);
//            }
//            con.close();
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return coops;
//    }
    public ArrayList<salesAnalysis> sales() {
        ArrayList<salesAnalysis> sales = new ArrayList();
        try {

////SELECT tblclients.clientName, tblprice.price, tblinvoice.quantity, tblinvoice.discountPercentage, tblinvoice.invoiceid
// FROM chickenfarmdb.tblinvoice, chickenfarmdb.tblclients, chickenfarmdb.tblprice
// WHERE tblinvoice.clientID = tblclients.clientID
// AND tblprice.dateUpdated = tblinvoice.date
            //String sql = "SELECT tblclients.clientName, tblprice.price, tblinvoice.quantity, tblinvoice.discountPercentage, tblinvoice.invoiceid FROM chickenfarmdb.tblinvoice, chickenfarmdb.tblclients, chickenfarmdb.tblprice WHERE tblinvoice.clientID = tblclients.clientID AND month(tblprice.dateUpdated) = month(tblinvoice.date) AND year(tblprice.dateUpdated) = year(tblinvoice.date)";
            String sql = "SELECT tblclients.clientName, SUM(tblprice.price*tblinvoice.quantity - tblprice.price*tblinvoice.quantity*tblinvoice.discountPercentage/100) AS totalIncome,\n"
                    + "COUNT(*) AS numOrders\n"
                    + "FROM chickenfarmdb.tblinvoice, chickenfarmdb.tblclients, chickenfarmdb.tblprice\n"
                    + "WHERE tblinvoice.clientID = tblclients.clientID AND month(tblprice.dateUpdated) = month(tblinvoice.date) AND year(tblprice.dateUpdated) = year(tblinvoice.date)\n"
                    + "GROUP BY tblclients.clientID,tblclients.clientName;";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                String clientName = rs.getString("clientName");
                //System.out.println(clientName);

                double totalIncome = rs.getDouble("totalIncome");
                int numOrders = rs.getInt("numOrders");
                //System.out.println(price);
//                int quantity = rs.getInt("quantity");
//                int discountPercentage = rs.getInt("discountPercentage");
//                int invoiceID = rs.getInt("invoiceID");
                salesAnalysis s = new salesAnalysis(clientName, totalIncome, numOrders);
                sales.add(s);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return sales;
    }

    //**********************Stock Produced***********************************************
    public ArrayList<StockProduced> stockProduced() {
        ArrayList<StockProduced> stockProduced = new ArrayList();
        try {
            String sql = "SELECT coopName, amount, date AS Date\n"
                    + " FROM chickenfarmdb.tbleggs, chickenfarmdb.tblcoops\n"
                    + " WHERE tbleggs.coopID=tblcoops.coopID\n"
                    + " ORDER BY date;";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                String coopName = rs.getString("coopName");
                int amount = rs.getInt("amount");
                String sDate = rs.getString("date");
//                System.out.println(sDate);
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(sDate, df);
                StockProduced sp = new StockProduced(coopName, amount, date);
                stockProduced.add(sp);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return stockProduced;
    }

    public ArrayList<StockProduced> stockProducedOnDate(LocalDate d) {
        ArrayList<StockProduced> stockProduced = new ArrayList();
        try {
            String sql = "    SELECT coopName, amount, date AS Date\n"
                    + " FROM chickenfarmdb.tbleggs, chickenfarmdb.tblcoops\n"
                    + " Where chickenfarmdb.tbleggs.coopID = chickenfarmdb.tblcoops.coopID\n"
                    + "AND date = \"" + d + "\"";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                String coopName = rs.getString("coopName");
                int amount = rs.getInt("amount");
                String sDate = rs.getString("date");
//                System.out.println(sDate);
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(sDate, df);
                StockProduced sp = new StockProduced(coopName, amount, date);
                stockProduced.add(sp);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return stockProduced;
    }

    public int avgEggsBasedOnLastMonth() {
        int avg = 0;
        try {
            String sql = "SELECT ROUND(avg(amount)) AS avgEggs FROM chickenfarmdb.tbleggs\n"
                    + "WHERE month(tbleggs.date) >= month(now())-1";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                avg = rs.getInt("avgEggs");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return avg;
    }
    //*********************Stock Projection**********************************

    public int avgEggs() {
        int avg = 0;
        try {
            String sql = "SELECT ROUND(avg(amount)) AS avgEggs FROM chickenfarmdb.tbleggs;";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                avg = rs.getInt("avgEggs");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return avg;
    }

    //**************************Price List***************************************
    public ArrayList<PriceList> priceLists() {
        ArrayList<PriceList> priceLists = new ArrayList();
        try {

            String sql = "SELECT tbltraytypes.type, price,dateUpdated FROM chickenfarmdb.tblprice, chickenfarmdb.tbltraytypes\n"
                    + "WHERE tblprice.trayTypeID = tbltraytypes.traytypeID\n"
                    + "ORDER BY dateUpdated;";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                String trayType = rs.getString("type");
                // System.out.println(trayType);
                double price = rs.getDouble("price");
                // System.out.println(price);
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date = "" + rs.getDate("dateUpdated");

                LocalDate dateImplemented = LocalDate.parse(date, df);
                //System.out.println(dateImplemented);
                PriceList l = new PriceList(trayType, price, dateImplemented);
                priceLists.add(l);
                // System.out.println(l.toString());
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        return priceLists;
    }

    //*******************************Invoice*******************************************
    public ArrayList<InvoiceList> inLists() {
        ArrayList<InvoiceList> inLists = new ArrayList();
        try {
            String sql = "SELECT clientName,contactName,contactNumber, paymentContact, deliveryAddress,\n"
                    + "tbltraytypes.type, quantity, paymentType,\n"
                    + "tblprice.price*tblinvoice.discountPercentage/100 AS Price,\n"
                    + "delivered, paid\n"
                    + "FROM chickenfarmdb.tblclients, chickenfarmdb.tblorders, chickenfarmdb.tblinvoice, chickenfarmdb.tbltraytypes, chickenfarmdb.tblprice\n"
                    + "WHERE tblinvoice.clientID = tblclients.clientID\n"
                    + "AND tblinvoice.invoiceID = tblorders.invoiceID\n"
                    + "AND tbltraytypes.traytypeID = tblinvoice.trayTypeID\n"
                    + "AND tblprice.trayTypeID = tblinvoice.trayTypeID;";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                String clientName = rs.getString("clientname");
                String contactName = rs.getString("contactName");
                String contactNumber = rs.getString("contactNumber");
                String paymentContact = rs.getString("paymentContact");
                String deliveryAddress = rs.getString("deliveryAddress");
                String type = rs.getString("type");
                int quantity = rs.getInt("quantity");
                String paymentType = rs.getString("paymentType");
                double price = rs.getDouble("Price");
                boolean delivered = rs.getBoolean("delivered");
                boolean paid = rs.getBoolean("paid");
                InvoiceList i = new InvoiceList(clientName, contactName, contactNumber, paymentContact, deliveryAddress,
                        type, quantity, paymentType,
                        price, delivered, paid);
                inLists.add(i);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return inLists;
    }

}
