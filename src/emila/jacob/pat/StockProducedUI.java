/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 24emilaj
 */
public class StockProducedUI extends javax.swing.JFrame {
//coops and egg

    private ArrayList<Eggs> eggs;
    private ArrayList<Coop> coops;
    private ArrayList<StockProduced> stockProduced;
    private int selected;
    DataHandler dh = new DataHandler();

    /**
     * Creates new form StockProducedUI
     */
    public StockProducedUI() {
        initComponents();
        this.insertTable();
        //  this.tblStockMouseClicked(evt);
        txtavgEggs.setText("" + dh.avgEggsBasedOnLastMonth());
        txtavgEggs.setEditable(false);
        this.insertDropDown();
        this.selected();
        this.toolTips();

    }

    public void toolTips() {
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        toolTipManager.setInitialDelay(500);
        //sets tooltp text for btnShowDate
        btnShowDate.setToolTipText("Click this button after you have selected the date for which you would like to see the Stock");
        //sets tooltp text for btnInsert
        btnInsert.setToolTipText("Click this button to insert new stock into the database");
        //sets tooltp text for btnUpdate
        btnUpdate.setToolTipText("Click this button to update stock in the database");
        //sets tooltp text for btnDelete
        btnDelete.setToolTipText("Click this button to delete stock in the database");
        //sets tooltp text for btnClear
        btnClear.setToolTipText("Click this button to view the original Stock Produced table");
        //sets tooltp text for btnBack
        btnBack.setToolTipText("Click this button to return to the menu");
        //sets tooltp text for datePicker
        datePickerDate.setToolTipText("Click the 3 dots to selet a date");
        //sets tooltp text for NumEggs textfiled
        txtNumEggs.setToolTipText("Enter the number of eggs attained here");
        //sets tooltp text for dropDown menu
        dropDown.setToolTipText("Select a coop");

    }

//    public void test() {
//        DataHandler dh = new DataHandler();
//        for (int i = 0; i < dh.stockProduced().size(); i++) {
//            System.out.println(dh.stockProduced().get(i));
//        }
//    }
    /**
     * takes stockProduced arrayList and enters each stockProduced object into a
     * new row into the tblStock table
     */
    public void insertTable() {
        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
        stockProduced = dh.stockProduced();
        DefaultTableModel dtm = (DefaultTableModel) tblStock.getModel();
        dtm.setRowCount(0);
        tblStock.setModel(dtm);
        Object stock[] = new Object[3];
        // make a thick line btw every day
        for (int i = 0; i < stockProduced.size(); i++) {
            stock[0] = stockProduced.get(i).getCoopName();
            stock[1] = stockProduced.get(i).getAmount();
            stock[2] = stockProduced.get(i).getDate();
            dtm.addRow(stock);
        }
        tblStock.setRowSelectionInterval(0, 0);
    }

    public void entriesForDate() {
        LocalDate date = datePickerView.getDate();
        //  dh.stockProducedOnDate(date);
        stockProduced = dh.stockProducedOnDate(date);
        DefaultTableModel dtm = (DefaultTableModel) tblStock.getModel();
        dtm.setRowCount(0);
        tblStock.setModel(dtm);
        Object stock[] = new Object[3];
        // make a thick line btw every day
        for (int i = 0; i < stockProduced.size(); i++) {
            stock[0] = stockProduced.get(i).getCoopName();
            stock[1] = stockProduced.get(i).getAmount();
            stock[2] = stockProduced.get(i).getDate();
            dtm.addRow(stock);
        }
    }

    public void selected() {
        String data = "";
        int selectedRow = tblStock.getSelectedRow();
        if (!(selectedRow == -1)) {
            for (int i = 0; i < tblStock.getColumnCount(); i++) {
                data += "" + tblStock.getValueAt(selectedRow, i);
                System.out.println(data);
            }
            // dropDown.sho;
            // txtNumEggs.setText(data.trim());

        }
    }

    private void valueChanged() {
        selected = tblStock.getSelectedRow();
        coops = dh.getAllCoops();
        if (selected != -1) {
            //   for (int i = 0; i < coops.size(); i++) {
            String coopName = stockProduced.get(selected).getCoopName();
            int pos = coops.indexOf(coopName); //+1;
            //  }
            for (int i = 0; i < coops.size(); i++) {
                if (coopName.equalsIgnoreCase(dropDown.getItemAt(i))) {
                    dropDown.setSelectedIndex(i);
                }
            }

            txtNumEggs.setText("" + stockProduced.get(selected).getAmount());
            LocalDate date = stockProduced.get(selected).getDate();
            datePickerDate.setDate(date);
        }

    }

    public void insertDropDown() {
        String out = "";
        ArrayList<StockProduced> stockProduced = dh.stockProduced();
        ArrayList<Coop> coops = dh.getAllCoops();
        for (int i = 0; i < coops.size(); i++) {
            out = coops.get(i).getCoopName();
            // dropDown.add(out);
            dropDown.addItem(out);
        }

    }

    public void addStock(StockProduced newStock) {
        DefaultTableModel dtm = (DefaultTableModel) tblStock.getModel();
        stockProduced.add(newStock); // Add to the list of clients
        Object[] rowData = {
            newStock.getCoopName(),
            newStock.getAmount(),
            newStock.getDate()
        };
        dtm.addRow(rowData); // Add to the table model

        // Optionally select the newly added row
        int rowIndex = dtm.getRowCount() - 1;
        tblStock.setRowSelectionInterval(rowIndex, rowIndex);
        selected = tblStock.getSelectedRow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        txtCoopName = new javax.swing.JTextField();
        btnHelp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtavgEggs = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        datePickerView = new com.github.lgooddatepicker.components.DatePicker();
        btnShowDate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumEggs = new javax.swing.JTextField();
        datePickerDate = new com.github.lgooddatepicker.components.DatePicker();
        dropDown = new javax.swing.JComboBox<>();

        jLabel3.setText("View:");

        jScrollPane2.setViewportView(jTextPane1);

        btnHelp.setText("Help");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Stock Produced");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Coop Name", "no. of Eggs", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        jLabel2.setText("average produced per day (based on last month)");

        txtavgEggs.setText("jTextField1");
        txtavgEggs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtavgEggsActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnShowDate.setText("Show entries for:");
        btnShowDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear Selection");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Coop Name");

        jLabel5.setText("no. of eggs");

        jLabel6.setText("Date");

        txtNumEggs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumEggsActionPerformed(evt);
            }
        });

        dropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtavgEggs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))))
                                .addGap(0, 28, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnUpdate)
                                    .addGap(21, 21, 21)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumEggs, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClear)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnShowDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(datePickerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtavgEggs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePickerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShowDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNumEggs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btnInsert)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * creates a new menuUI and makes it visible makes stockProducedUI invisible
     *
     * @param evt
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuUI m = new MenuUI();
        m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtavgEggsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtavgEggsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavgEggsActionPerformed

    private void btnShowDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDateActionPerformed
        this.entriesForDate();
    }//GEN-LAST:event_btnShowDateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.insertTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            ArrayList<Coop> coops = dh.getAllCoops();
            String coopName = "" + dropDown.getSelectedItem();
            int id = 0;
            eggs = dh.getAllEggs();
            // System.out.println(stockProduced.size());
            for (int i = 0; i < coops.size(); i++) {
                if (coopName.equalsIgnoreCase(coops.get(i).getCoopName())) {
                    //int pos = i;
                    id = coops.get(i).getCoopID();
                    System.out.println(id);
                }
            }
            int numEggs = Integer.parseInt(txtNumEggs.getText());
            DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String sDate = "" + datePickerDate.getDate();
            LocalDate date = LocalDate.parse(sDate, dtm);
            
            Eggs e = new Eggs(id, date, numEggs);
            StockProduced s = new StockProduced(coopName, numEggs, date);
            this.addStock(s);
            dh.insertEggs(e);
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtNumEggsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumEggsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumEggsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        selected = tblStock.getSelectedRow();
        this.valueChanged();
    }//GEN-LAST:event_tblStockMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockProducedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockProducedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockProducedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockProducedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockProducedUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnShowDate;
    private javax.swing.JButton btnUpdate;
    private com.github.lgooddatepicker.components.DatePicker datePickerDate;
    private com.github.lgooddatepicker.components.DatePicker datePickerView;
    private javax.swing.JComboBox<String> dropDown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtCoopName;
    private javax.swing.JTextField txtNumEggs;
    private javax.swing.JTextField txtavgEggs;
    // End of variables declaration//GEN-END:variables
}
