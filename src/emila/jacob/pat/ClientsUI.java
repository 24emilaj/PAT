/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package emila.jacob.pat;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JJacob
 */
public class ClientsUI extends javax.swing.JFrame {

    /**
     * Creates new form rt
     */
    private int selected;
    DataHandler dh = new DataHandler();
    private ArrayList<Client> clients = dh.getAllClients();

    public ClientsUI() {
        initComponents();
        this.insertTable();
        this.toolTips();
    }
/**
 * method which sets all the tooltip texts for buttons/textfields on the jframe
 */
    public void toolTips() {
        btnBack.setToolTipText("Click this button to return to the menu");
        //sets tooltp text for btnInsert
        btnInsert.setToolTipText("Click this button to insert a new client into the database");
        //sets tooltp text for btnUpdate
        btnUpdate.setToolTipText("Click this button to update a client in the database");
        //sets tooltp text for btnDelete
        btnDelete.setToolTipText("Click this button to delete a client from the database");
       //sets tooltp text for clientname textfield
        txtclientname.setToolTipText("fill in the clients name here");
        //sets tooltp text for contactname textfield
        txtcontactname.setToolTipText("fill in the clients contactname here");
        //sets tooltp text for contactnumber textfield
        txtcontactnumber.setToolTipText("fill in the clients contact number here");
        //sets tooltp text for deliveryaddress textfield
        txtdeliveryaddress.setToolTipText("fill in the clients delivery address here");
        //sets tooltp text for paymentcontact textfield
        txtpaymentcontact.setToolTipText("fill in the clients payment contact here");
        //sets tooltp text for area textfield
        txtarea.setToolTipText("fill in the area in whuch the client is based here");
        //sets tooltp text for email textfield
        txtemail.setToolTipText("fill in the clients email here");
    }

    public void insertTable() {
        DataHandler dh = new DataHandler();
        DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
        dtm.setRowCount(0);
        //this.add(tblClients);
        tblClients.setModel(dtm);
        Object client[] = new Object[7];
//        for (int i = 0; i < clients.size(); i++) {
        for (Client clients : clients) {

            client[0] = clients.getClientname();
            client[1] = clients.getContactname();
            client[2] = clients.getContactNum();
            client[3] = clients.getEmail();
            client[4] = clients.getPaymentContact();
            client[5] = clients.getDeliveryAddress();
            client[6] = clients.getArea();
            dtm.addRow(client.clone());

        }
        tblClients.setRowSelectionInterval(0, 0);

        selected = tblClients.getSelectedRow();
    }

    public void refreshTable() {
//          DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
//          dtm.setRowCount(0);
        this.insertTable();
//            DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
//            dtm.setRowCount(0);
//            tblClients.setModel(dtm);
//            Object client[] = new Object[7];
//            for (int i = 0; i < clients.size(); i++) {
//                client[0] = clients.get(i).getClientname();
//                client[1] = clients.get(i).getContactname();
//                client[2] = clients.get(i).getContactNum();
//                client[3] = clients.get(i).getEmail();
//                client[4] = clients.get(i).getPaymentContact();
//                client[5] = clients.get(i).getDeliveryAddress();
//                client[6] = clients.get(i).getArea();
//                dtm.addRow(client);
//                
//            }
//                        dtm.fireTableDataChanged();
//
//            // dtm.setRowCount(clients.size());
//       
//
//        // dtm.fireTableDataChanged();
//               selected = tblClients.getSelectedRow();
    }

    // Method to add a new client and update the table
    //chatGPT
    public void addClient(Client newClient) {
        DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
        clients.add(newClient); // Add to the list of clients
        Object[] rowData = {
            newClient.getClientname(),
            newClient.getContactname(),
            newClient.getContactNum(),
            newClient.getEmail(),
            newClient.getPaymentContact(),
            newClient.getDeliveryAddress(),
            newClient.getArea()
        };
        dtm.addRow(rowData); // Add to the table model

        // Optionally select the newly added row
        int rowIndex = dtm.getRowCount() - 1;
        tblClients.setRowSelectionInterval(rowIndex, rowIndex);
        selected = tblClients.getSelectedRow();
    }

    public void selected() {
        String data = "";
        int selectedRow = tblClients.getSelectedRow();
        if (!(selectedRow == -1)) {
            for (int i = 0; i < tblClients.getColumnCount(); i++) {
                data += "" + tblClients.getValueAt(selectedRow, i);
            }
            txtclientname.setText(data.trim());
        }
        // txtclientname.setText(tblClients.getSelectedRow().client[0]);
//        tblClients.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//                if (SwingUtilities.isRightMouseButton(me) == true) {
//                    int row = tblClients.rowAtPoint(me.getPoint());
//
//                    tblClients.clearSelection();
//                    tblClients.addRowSelectionInterval(row, row);
////your popup menu goes here.
//                }
//            }}

    }

    private void valueChanged() {
        selected = tblClients.getSelectedRow();
        if (selected != -1) {
            txtclientname.setText(clients.get(selected).getClientname());
            txtcontactname.setText(clients.get(selected).getContactname());
            txtcontactnumber.setText(clients.get(selected).getContactNum());
            txtemail.setText(clients.get(selected).getEmail());
            txtpaymentcontact.setText(clients.get(selected).getPaymentContact());
            txtdeliveryaddress.setText(clients.get(selected).getDeliveryAddress());
            txtarea.setText(clients.get(selected).getArea());

        }
    }
//      public void removeClient(int rowIndex) {
//        clients.remove(rowIndex);
//        fireTableRowsDeleted(rowIndex, rowIndex);
//    }

    public void removeClient(int selected) {
        DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
        if (selected != -1) {
            tblClients.remove(selected);

            dtm.fireTableRowsDeleted(selected, selected);
        }

    }

    public void updateClient(int rowIndex, Client updatedClient) {
        clients.set(rowIndex, updatedClient);
        DefaultTableModel dtm = (DefaultTableModel) tblClients.getModel();
        // Notify the table of changes to the specific row
        for (int i = 0; i < tblClients.getColumnCount(); i++) {
            dtm.fireTableCellUpdated(rowIndex, i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtclientname = new javax.swing.JTextField();
        txtcontactname = new javax.swing.JTextField();
        txtcontactnumber = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtpaymentcontact = new javax.swing.JTextField();
        txtdeliveryaddress = new javax.swing.JTextField();
        txtarea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Name", "Contact Name", "Contact Number", "email", "Payment Contact", "Delivery Address", "Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClients.getTableHeader().setReorderingAllowed(false);
        tblClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClients);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Clients");

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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtclientname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclientnameActionPerformed(evt);
            }
        });

        txtcontactnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactnumberActionPerformed(evt);
            }
        });

        jButton1.setText("Client Name");

        jButton2.setText("Contact Name");

        jButton3.setText("Contact Number");

        jButton4.setText("email");

        jButton5.setText("Payment Contact");

        jButton6.setText("Delivery Address");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(224, 224, 224)
                        .addComponent(jLabel3)))
                .addContainerGap(1027, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcontactname, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(txtcontactnumber)
                            .addComponent(txtemail)
                            .addComponent(txtpaymentcontact)
                            .addComponent(txtdeliveryaddress)
                            .addComponent(txtarea)
                            .addComponent(txtclientname, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclientname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcontactname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcontactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpaymentcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdeliveryaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//allows user to go back to menu
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuUI m = new MenuUI();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //chat

        int response = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this client",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        String clientname = txtclientname.getText().trim();
        String contactname = txtcontactname.getText();
        String contactNum = txtcontactnumber.getText();
        String paymentContact = txtpaymentcontact.getText();
        String deliveryAddress = txtdeliveryaddress.getText();
        String area = txtarea.getText();
        String email = txtemail.getText();
        Client c = new Client(clientname, contactname, contactNum, paymentContact, deliveryAddress, area, email);
        //System.out.println(c.toString());
        if (response == JOptionPane.YES_OPTION) {
            dh.deleteClient(c);
            JOptionPane.showMessageDialog(null, "Successful Deletion");
            selected = tblClients.getSelectedRow();
            this.removeClient(selected);
        } else {
            JOptionPane.showMessageDialog(null, "Deletion is cancelled");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtclientnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclientnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientnameActionPerformed
    /**
     * insert a new client object into the database when btnInsert in clicked
     *
     * @param evt
     */
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        //might need order to be changed for read in
        DataHandler dh = new DataHandler();
        String clientname = txtclientname.getText();
        String contactname = txtcontactname.getText();
        String contactNum = txtcontactnumber.getText();
        String paymentContact = txtpaymentcontact.getText();
        String deliveryAddress = txtdeliveryaddress.getText();
        String area = txtarea.getText();
        String email = txtemail.getText();
        Client c = new Client(clientname, contactname, contactNum, paymentContact, deliveryAddress, area, email);
        dh.insertNewClient(c);
        this.addClient(c);
        JOptionPane.showMessageDialog(null, "New client added.");
        this.refreshTable();
        //txtclientname.setToolTipText("wer");
        // btnInsert.setToolTipText("Click this button to insert a new client into the database.");
        //this.valueChanged();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // DataHandler dh = new DataHandler();
        //  int id = txtclientname.getText();
        int clientID = 0;
        
       String clientname = txtclientname.getText();
        for (int i = 0; i < clients.size(); i++) {
            if (clientname.equalsIgnoreCase(clients.get(i).getClientname())) {
                clientID = clients.get(i).getClientID();
            }
        }
        
        String contactname = txtcontactname.getText();
        String contactNumber = txtcontactnumber.getText();
        String paymentContact = txtpaymentcontact.getText();
        String deliveryAddress = txtdeliveryaddress.getText();
        String area = txtarea.getText();
        String email = txtemail.getText();
        Client c = new Client(clientID, clientname, contactname, contactNumber, paymentContact, deliveryAddress, area, email);
        dh.updateClient(clientID,c);
        System.out.println(c + " cv");
        JOptionPane.showMessageDialog(null, "Client info updated.");
        this.valueChanged();
        this.refreshTable();
        //this.insertTable();
        int rowIndex = selected;

        //clients.set(rowIndex, c);
        this.updateClient(rowIndex, c);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientsMouseClicked
        selected = tblClients.getSelectedRow();
        this.valueChanged();
    }//GEN-LAST:event_tblClientsMouseClicked

    private void txtcontactnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactnumberActionPerformed

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
            java.util.logging.Logger.getLogger(ClientsUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientsUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientsUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientsUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtarea;
    private javax.swing.JTextField txtclientname;
    private javax.swing.JTextField txtcontactname;
    private javax.swing.JTextField txtcontactnumber;
    private javax.swing.JTextField txtdeliveryaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtpaymentcontact;
    // End of variables declaration//GEN-END:variables
}
