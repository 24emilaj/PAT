/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 24emilaj
 */
public class CaptureOrderUI extends javax.swing.JFrame {

    private DataHandler dh = new DataHandler();
    private ArrayList<Order> orders;
    private ArrayList<Invoice> invoice;

    /**
     * Creates new form CaptureOrderUI
     */
    public CaptureOrderUI() {
        initComponents();
        this.numDropDowns();
        this.insertDropDown();
        //this.setPrice();
        this.toolTips();
    }

    /**
     * method which sets all the tooltip texts for buttons/textfields on the
     * jframe
     */
    public void toolTips() {
        // sets the tool tip text for back button
        btnBack.setToolTipText("Click this utton to return to the menu");
        // sets the tool tip text for insert button
        btnInsert.setToolTipText("Click this button to insert the new order");
        // sets the tool tip text for clients textfield

        txtClients.setToolTipText("Fill in the clients name here");
        // sets the tool tip text for unit quantity 1 textfield
        txtUnitQuantity1.setToolTipText("Fill in the quantity for the first tray type");
        // sets the tool tip text for unit quantity 2 textfield
        txtUnitQuantity2.setToolTipText("Fill in the quantity for the second tray type");
        // sets the tool tip text for unit quantity 3 textfield
        txtUnitQuantity3.setToolTipText("Fill in the quantity for the third tray type");
        // sets the tool tip text for numbunittypes textfield
        txtNumUnitTypes.setToolTipText("fill in the number of unit types (less than 4)");
        // sets the tool tip text for unit types drpdown
        dropDown1.setToolTipText("select a packaging type");
        // sets the tool tip text for price textfield
        txtPrice.setToolTipText("total price for the order");
        // sets the tool tip text for paid check box
        checkPaid.setToolTipText("check if pament has been made");
        // sets the tool tip text for payment type textfield
        txtPaymentType.setToolTipText("Fill in the payment method");
        // sets the tool tip text for datePicker
        datePicker1.setToolTipText("click on the 3 dots to select date of the order");
        btnEnter.setToolTipText("Click this button to select packaging types");
        // sets the tool tip text for the calculate price button
        btnCalculatePrice.setToolTipText("Fill in all the tray types and quantities before clicking this button");
    }

    public void numDropDowns() {

        int numTypes = 0;//Integer.parseInt(txtNumUnitTypes.getText());
        //numTypes = Integer.parseInt(JOptionPane.showInputDialog("Select the number of tray types", numTypes));
        dropDown1.setVisible(false);
        dropDown2.setVisible(false);
        dropDown3.setVisible(false);
        txtUnitQuantity1.setVisible(false);
        txtUnitQuantity2.setVisible(false);
        txtUnitQuantity3.setVisible(false);

    }

    public void insertDropDown() {
        DataHandler dh = new DataHandler();
        String out = "";
        ArrayList<TrayTypes> trayTypes = dh.getAlltrayTypes();
        for (int i = 0; i < trayTypes.size(); i++) {
            out = trayTypes.get(i).getType();
            // dropDown.add(out);
            dropDown1.addItem(out);
            dropDown2.addItem(out);
            dropDown3.addItem(out);

        }
        // clients drop down
        String clientName = "";
        ArrayList<Client> clients = dh.getAllClients();
        for (int i = 0; i < clients.size(); i++) {
            clientName = clients.get(i).getClientname();
            txtClients.addItem(clientName);
        }

    }

    public void setPrice() {
        int numTypes = Integer.parseInt(txtNumUnitTypes.getText());
       
        String unit1 = "" + dropDown1.getSelectedItem();
        String unit2 = "";
        String unit3 = "";
        int q1 = Integer.parseInt(txtUnitQuantity1.getText());
        int q2 = 0;
        int q3 = 0;
        if (numTypes <= 2) {
            unit2 = "" + dropDown2.getSelectedItem();
            q2 = Integer.parseInt(txtUnitQuantity2.getText());
        }
        if (numTypes <= 3) {
            unit3 = "" + dropDown3.getSelectedItem();
            q3 = Integer.parseInt(txtUnitQuantity3.getText());
        }
        ArrayList<Price> prices = dh.getAllPrices();
        ArrayList<TrayTypes> t = dh.getAlltrayTypes();
        int trayTypeID = 0;
        int trayTypeID1 = 0;
        int trayTypeID2 = 0;
        int trayTypeID3 = 0;
        for (int j = 0; j < t.size(); j++) {
            if (unit1.equalsIgnoreCase(t.get(j).getType())) {
                trayTypeID1 = t.get(j).getTrayTypeID();
            }
            if (unit2.equalsIgnoreCase(t.get(j).getType())) {
                trayTypeID2 = t.get(j).getTrayTypeID();
            }
            if (unit3.equalsIgnoreCase(t.get(j).getType())) {
                trayTypeID3 = t.get(j).getTrayTypeID();
            }

        }
        double price1 = 0;
        double price2 = 0;
        double price3 = 0;

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).getTraytypeID() == trayTypeID1) {
                price1 = prices.get(i).getPrice();

            }
            if (prices.get(i).getTraytypeID() == trayTypeID2) {
                price2 = prices.get(i).getPrice();

            }
            if (prices.get(i).getTraytypeID() == trayTypeID3) {
                price3 = prices.get(i).getPrice();

            }

        }
        double totalPrice = price1 * q1 + price2 * q2 + price3 * q3;

        txtPrice.setText("" + totalPrice);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumUnitTypes = new javax.swing.JTextField();
        txtUnitQuantity1 = new javax.swing.JTextField();
        txtPaymentType = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        checkPaid = new javax.swing.JCheckBox();
        btnInsert = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        txtClients = new javax.swing.JComboBox<>();
        dropDown1 = new javax.swing.JComboBox<>();
        dropDown2 = new javax.swing.JComboBox<>();
        dropDown3 = new javax.swing.JComboBox<>();
        btnEnter = new javax.swing.JButton();
        txtUnitQuantity2 = new javax.swing.JTextField();
        txtUnitQuantity3 = new javax.swing.JTextField();
        checkDelivered = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        btnCalculatePrice = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        jTextField8.setText("jTextField8");

        jTextField5.setText("jTextField5");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Capture Order");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("Client");

        jLabel3.setText("unitType");

        jLabel4.setText("unitQuantity");

        jLabel5.setText("paid");

        jLabel6.setText("Payment type");

        jLabel7.setText("Price");

        jLabel8.setText("Date");

        txtUnitQuantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitQuantity1ActionPerformed(evt);
            }
        });

        checkPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPaidActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        dropDown1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        dropDown2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        dropDown3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel9.setText("Delivered");

        btnCalculatePrice.setText("Calculate Price");
        btnCalculatePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculatePriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(537, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBack)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(74, 74, 74)
                                            .addComponent(txtNumUnitTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEnter)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtUnitQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addComponent(dropDown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txtUnitQuantity2)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dropDown3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtUnitQuantity3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCalculatePrice)
                                        .addComponent(btnInsert))))
                            .addContainerGap(132, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(checkPaid)
                                .addGap(107, 107, 107)
                                .addComponent(checkDelivered)))
                        .addContainerGap(416, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dropDown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropDown2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropDown3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumUnitTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnter))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUnitQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUnitQuantity2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUnitQuantity3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkDelivered)
                                    .addComponent(jLabel9))))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkPaid)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnCalculatePrice)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnInsert))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUnitQuantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitQuantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitQuantity1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuUI m = new MenuUI();
        m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void checkPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPaidActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        int numTypes = Integer.parseInt(txtNumUnitTypes.getText());
        if (numTypes == Integer.parseInt("" + numTypes)) {
            txtNumUnitTypes.setText("" + numTypes);
            numTypes = Integer.parseInt(txtNumUnitTypes.getText());
            dropDown1.setVisible(false);
            dropDown2.setVisible(false);
            dropDown3.setVisible(false);
            txtUnitQuantity1.setVisible(false);
            txtUnitQuantity2.setVisible(false);
            txtUnitQuantity3.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Enter a number which is an integer");
        }
        if ("" + numTypes != null) {
            if (numTypes == 1) {
                dropDown1.setVisible(true);
                dropDown2.setVisible(false);
                dropDown3.setVisible(false);
                txtUnitQuantity1.setVisible(true);
            }
            if (numTypes == 2) {
                dropDown1.setVisible(true);
                dropDown2.setVisible(true);
                dropDown3.setVisible(false);
                txtUnitQuantity1.setVisible(true);
                txtUnitQuantity2.setVisible(true);
            }

            if (numTypes == 3) {
                dropDown1.setVisible(true);
                dropDown2.setVisible(true);
                dropDown3.setVisible(true);
                txtUnitQuantity1.setVisible(true);
                txtUnitQuantity2.setVisible(true);
                txtUnitQuantity3.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String q = "";
        ArrayList<Client> clients = dh.getAllClients();
        int numTypes = Integer.parseInt(txtNumUnitTypes.getText());
        String quantities = txtUnitQuantity1.getText();
        if (txtNumUnitTypes != null && txtUnitQuantity1 != null) {
            String clientName = "" + txtClients.getSelectedItem();
            int clientID = 0;
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getClientname().equalsIgnoreCase(clientName)) {
                    clientID = clients.get(i).getClientID();
                }
            }
            String unitType = "" + dropDown1.getSelectedItem();

            if (numTypes == 2) {
                unitType += "," + dropDown2.getSelectedItem();
            }
            if (numTypes == 3) {
                unitType += "," + dropDown2.getSelectedItem() + "," + dropDown3.getSelectedItem();
            }
            //System.out.println(unitType);
//            if (clientName.equalsIgnoreCase("select")) {
//
//            }
            //**** Quantities ********
            // another method is set up textfieds if expansion of types is required
//            switch (numTypes) {
//                case 1:
//                    int q1 = Integer.parseInt(txtUnitQuantity1.getText());
//                case 2:
//                    int q2 = Integer.parseInt(txtUnitQuantity2.getText());
//                case 3:
//                    int q3 = Integer.parseInt(txtUnitQuantity3.getText());
//                    break;
//
//                default:
//                    throw new AssertionError();
//            }

           // q = txtUnitQuantity1.getText() + "," + txtUnitQuantity2.getText() + "," + txtUnitQuantity3.getText();
           // System.out.println(q);

//            ArrayList<Integer> numbers = new ArrayList<>();
//            Scanner scFile = new Scanner(quantities);
//            scFile.useDelimiter(",");
//            while (scFile.hasNext()) {
//                switch (numTypes) {
//                    case 1:
//                        int q1 = scFile.nextInt();
//                        numbers.add(q1);
//                    case 2:
//
//                        int q2 = scFile.nextInt();
//                        numbers.add(q2);
//
//                    case 3:
//
//                        int q3 = scFile.nextInt();
//                        numbers.add(q3);
//
//                        break;
//                    default:
//                        throw new AssertionError();
//                }
//
//            }
//
//            int q1 = numbers.get(0);
//            int q2 = numbers.get(1);
//            int q3 = numbers.get(2);
//            System.out.println(q1 + "," + q2 + "," + q3);
//
//            scFile.close();
//        } else {
//            JOptionPane.showMessageDialog(null, "Fill in all the categories");
//        }
//******************************************************
            int invoiceID = 0;//invoice.size +1
            boolean paid = checkPaid.isSelected();
            // problem with the diff tray types
            int trayTypeID = 1;
            boolean delivered = checkPaid.isSelected();
            String paymentType = txtPaymentType.getText();
            String sDate = "" + datePicker1.getDate();
            //this.setPrice();
            // formatting may cause error may need multiple entries in the invoice table
            String qAll = txtUnitQuantity1.getText() + "," + txtUnitQuantity1.getText() + "," +txtUnitQuantity1.getText();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(sDate, dtf);
            double price = Double.parseDouble(txtPrice.getText());
      //      Order o = new Order(invoiceID, paid, delivered);
           // Invoice i = new Invoice(invoiceID,clientID,  date, trayTypeID,qAll, paymentType,date);
        }

    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnCalculatePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculatePriceActionPerformed
       this.setPrice();
    }//GEN-LAST:event_btnCalculatePriceActionPerformed

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
            java.util.logging.Logger.getLogger(CaptureOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaptureOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaptureOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaptureOrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaptureOrderUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculatePrice;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnInsert;
    private javax.swing.JCheckBox checkDelivered;
    private javax.swing.JCheckBox checkPaid;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JComboBox<String> dropDown1;
    private javax.swing.JComboBox<String> dropDown2;
    private javax.swing.JComboBox<String> dropDown3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JComboBox<String> txtClients;
    private javax.swing.JTextField txtNumUnitTypes;
    private javax.swing.JTextField txtPaymentType;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUnitQuantity1;
    private javax.swing.JTextField txtUnitQuantity2;
    private javax.swing.JTextField txtUnitQuantity3;
    // End of variables declaration//GEN-END:variables
}
