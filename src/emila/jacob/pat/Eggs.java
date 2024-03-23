/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.time.LocalDate;

/**
 *
 * @author 24emilaj
 */
public class Eggs {

    private int eggBatchID;
    private LocalDate date;
    private int amount;
/**
 * Constructor method for egg class
 * @param eggBatchID - id for the database to identify the egg batch
 * @param date - date the egg batch was produced
 * @param amount - amount of eggs produced in the batch
 */
    public Eggs(int eggBatchID, LocalDate date, int amount) {
        this.eggBatchID = eggBatchID;
        this.date = date;
        this.amount = amount;
    }
/**
 * Constructor method for inserting eggBatches
 * @param date - date the egg batch was produced
 * @param amount - amount of eggs produced in the batch
 */
    public Eggs(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }
    

    public int getEggBatchID() {
        return eggBatchID;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Eggs{" + "eggBatchID=" + eggBatchID + ", date=" + date + ", amount=" + amount + '}';
    }

}
