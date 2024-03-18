/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author 24emilaj
 */
public class DataHandler {

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

                Client c = new Client(clientID, clientname, contactname, contactNum, deliveryAddress);
                clients.add(c);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return clients;
    }

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
                prices.add(p);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return prices;
    }

    public ArrayList<Eggs> getAllEggs() {
        ArrayList<Eggs> eggs = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tbleggs";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                LocalDate date = rs.getDate("date").toLocalDate();
                int amount = rs.getInt("amount");
                Eggs e = new Eggs(amount, date);
                eggs.add(e);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return eggs;
    }

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
                Invoice i = new Invoice(invoiceID, clientID, trayTypeID, discountPercentage, date);
                //fix!!!!!
                //Invoice i = new Invoice(invoiceID, clientID, date, trayTypeID, quantity, discountPercentage);
                invoices.add(i);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return invoices;
    }

    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> orders = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblinvoice";
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

    public ArrayList<TrayTypes> getAlltrayTypes() {
        ArrayList<TrayTypes> trayTypes = new ArrayList();
        try {
            String sql = "SELECT * FROM chickenfarmdb.tblinvoice";
            Connect con = new Connect();
            ResultSet rs = con.query(sql);
            while (rs.next()) {
            int trayTypeID = rs.getInt("trayTypeID");
            String type = rs.getString("type");
            //fix!!!!
           // TrayTypes t = new TrayTypes(trayTypeID, type);
         //  trayTypes.add(t);
            }
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return trayTypes;
    }

}
