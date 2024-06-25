/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emila.jacob.pat;

/**
 *
 * @author JJacob
 */
public class Coop {

    private int coopID;
    private String coopName;

    /**
     * Constructor for coop class
     *
     * @param coopID - number used for database to identify the coop
     * @param coopName - name used to identify coop
     */
    public Coop(int coopID, String coopName) {
        this.coopID = coopID;
        this.coopName = coopName;
    }

    /**
     * Constructor only used for inserting a new coop
     *
     * @param coopName - name of the coop
     */
    public Coop(String coopName) {
        this.coopName = coopName;
    }

    /**
     * Getter method for coopID
     *
     * @return coopID
     */
    public int getCoopID() {
        return coopID;
    }

    /**
     * Getter method for coopName
     *
     * @return coopName
     */
    public String getCoopName() {
        return coopName;
    }

    /**
     * toString method for coop class
     *
     * @return toString()
     */
    @Override
    public String toString() {
        return "coopID = " + coopID + ", coopName = " + coopName;
    }

}
