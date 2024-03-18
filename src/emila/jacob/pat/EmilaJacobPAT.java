/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.util.ArrayList;

/**
 *
 * @author 24emilaj
 */
public class EmilaJacobPAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DataHandler dh = new DataHandler();
       ArrayList<Client> clients = dh.getAllClients();
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));   
        }
        System.out.println("\n");
        ArrayList<Price> prices = dh.getAllPrices();
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i);     
        }
    }
    
}
