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
public class TrayTypes {

    private int trayTypeID;
    private String type;
    private int numEggsPerType;

    /**
     * Constructor method for trayTypes class
     *
     * @param trayTypeID - id for database to identify tray type
     * @param type - size of tray
     * @param numEggsPerType - number of eggs in tray type
     */
    public TrayTypes(int trayTypeID, String type, int numEggsPerType) {
        this.trayTypeID = trayTypeID;
        this.type = type;
        this.numEggsPerType = numEggsPerType;
    }

    /**
     * Constructor method for inserting new tray types
     * @param type - size of tray
     * @param numEggsPerType - number of eggs in tray type
     */
    public TrayTypes(String type, int numEggsPerType) {
        this.type = type;
        this.numEggsPerType = numEggsPerType;
    }

    public int getTrayTypeID() {
        return trayTypeID;
    }

    public String getType() {
        return type;
    }

    public int getNumEggsPerType() {
        return numEggsPerType;
    }

    @Override
    public String toString() {
        return "TrayTypes{" + "trayTypeID=" + trayTypeID + ", type=" + type + ", numEggsPerType=" + numEggsPerType + '}';
    }
    
    

}
