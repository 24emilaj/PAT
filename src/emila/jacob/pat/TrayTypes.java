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
// decide if it is variable type which then can be 12,18,30 

/**
 * Constructor method for trayTypes class
 * @param trayTypeID - id for database to identify tray type
 * @param type - size of tray
 */

    public TrayTypes(int trayTypeID, String type) {
        this.trayTypeID = trayTypeID;
        this.type = type;
    }
/**
 * Constructor method for inserting new tray types
 * @param type - size of tray
 */
    public TrayTypes(String type) {
        this.type = type;
    }

    public int getTrayTypeID() {
        return trayTypeID;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TrayTypes{" + "trayTypeID=" + trayTypeID + ", type=" + type + '}';
    }
    
    


}
