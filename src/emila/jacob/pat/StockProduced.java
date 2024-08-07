/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emila.jacob.pat;

import java.time.LocalDate;

/**
 *
 * @author JJacob
 */
public class StockProduced {
 private String coopName;
 private int amount;
 private LocalDate date;

    public StockProduced(String coopName, int amount, LocalDate date) {
        this.coopName = coopName;
        this.amount = amount;
        this.date = date;
    }

    public String getCoopName() {
        return coopName;
    }

    public void setCoopName(String coopName) {
        this.coopName = coopName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StockProduced{" + "coopName=" + coopName + ", amount=" + amount + ", date=" + date + '}';
    }
 
 
}
