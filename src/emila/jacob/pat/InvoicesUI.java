/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 24emilaj
 */
public class InvoicesUI extends javax.swing.JFrame {

    private int selected;
    private DataHandler dh = new DataHandler();
    private ArrayList<InvoiceList> inLists = dh.inList();
    public static int stat;

    /**
     * Creates new form InvoicesUI
     */
    public InvoicesUI() {
        initComponents();
        btnSave.setVisible(false);
        btnDelete.setVisible(false);
        this.insertTable();

        // tblInvoices.setRowSelectionInterval(selected, selected);
        //  this.setSelected();
        this.seeInvoice();
        this.valueChanged();

        this.toolTips();
    }

    /**
     * method which sets all the tooltip texts for buttons/textfields on the
     * jframe
     */
    public void toolTips() {
        btnBack.setToolTipText("Click this button to return to the menu");
        btnSeeInvoice.setToolTipText("Click this button to see the invoice selected for the table");
        btnDelete.setToolTipText("Click ths button to delete the selected invoice");

    }

//    public void insertTable() {
//        DefaultTableModel dtm = (DefaultTableModel) tblInvoices.getModel();
//        dtm.setRowCount(0);
//        tblInvoices.setModel(dtm);
//        Object invoice[] = new Object[13];
//        for (int i = 0; i < inLists.size(); i++) {
//            invoice[0] = inLists.get(i).getClientID();
//            invoice[1] = inLists.get(i).getClientName();
//            invoice[2] = inLists.get(i).getContactName();
//            invoice[3] = inLists.get(i).getContactNumber();
//            invoice[4] = inLists.get(i).getPaymentContact();
//            invoice[5] = inLists.get(i).getDeliveryAddress();
//            invoice[6] = inLists.get(i).getType();
//            invoice[7] = inLists.get(i).getQuantity();
//            invoice[8] = inLists.get(i).getPaymentType();
//            invoice[9] = inLists.get(i).getDate();
//            invoice[10] = inLists.get(i).getPrice();
//            invoice[11] = inLists.get(i).isDelivered();
//            invoice[12] = inLists.get(i).isPaid();
//            dtm.addRow(invoice.clone());
//        }
//        tblInvoices.setRowSelectionInterval(0, 0);
//
//        selected = tblInvoices.getSelectedRow();
//    }
    public void insertTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblInvoices.getModel();
        dtm.setRowCount(0);
        tblInvoices.setModel(dtm);
        // complex code used for aggregating the values traytypes and quantities 
        // Map to hold aggregated data
        Map<String, InvoiceList> aggregatedData = new HashMap<>();

        for (InvoiceList data : inLists) {
            // Key to group by client ID and invoice date
            String key = data.getClientID() + "|" + data.getDate();

            // Check if entry exists
            if (aggregatedData.containsKey(key)) {
                // Get existing data
                InvoiceList existingData = aggregatedData.get(key);

                // Update existing data
                existingData.setType(existingData.getType() + "," + data.getType());
                existingData.setQuantity(existingData.getQuantity() + "," + data.getQuantity());
                existingData.setPrice(existingData.getPrice() + data.getPrice());
                // Other fields can be updated or maintained as needed
            } else {
                // Add new entry to map
                aggregatedData.put(key, new InvoiceList(
                        data.getInvoiceID(),
                        data.getClientID(),
                        data.getClientName(),
                        data.getContactName(),
                        data.getContactNumber(),
                        data.getPaymentContact(),
                        data.getDeliveryAddress(),
                        data.getType(),
                        data.getQuantity(),
                        data.getPaymentType(),
                        data.getDate(),
                        data.getPrice(),
                        data.isDelivered(),
                        data.isPaid()
                ));
            }
        }

        // Add aggregated data to the table 
        for (InvoiceList data : aggregatedData.values()) {
            Object[] row = new Object[13];
            row[0] = data.getClientID();
            row[1] = data.getClientName();
            row[2] = data.getContactName();
            row[3] = data.getContactNumber();
            row[4] = data.getPaymentContact();
            row[5] = data.getDeliveryAddress();
            row[6] = data.getType();
            row[7] = data.getQuantity();
            row[8] = data.getPaymentType();
            row[9] = data.getDate();
            row[10] = data.getPrice();
            row[11] = data.isDelivered();
            row[12] = data.isPaid();
            dtm.addRow(row);
        }
        try {
            FileReader fr = new FileReader("selected.txt.txt");
            int pos = fr.read();
            fr.close();
          //  System.out.println(pos);
            if (pos >= 0 && pos < tblInvoices.getRowCount()) {
                tblInvoices.setRowSelectionInterval(pos, pos);
            } else {
                tblInvoices.setRowSelectionInterval(0, 0);
            }

        } catch (Exception e) {
        }

//        selected = tblInvoices.getSelectedRow();
//        tblInvoices.setRowSelectionInterval(selected, selected);
//        //a = selected;
//        System.out.println(selected);
        //   System.out.println(a);
        // ApplicationState.getInstance().setSelectedRow(tblInvoices.getSelectedRow());
    }

//    public ArrayList<inLists> lists(){
//    
//    }
    /**
     * gives integer selected a value sets the values
     */
    public void valueChanged() {
// issue because quantity is a string
        selected = tblInvoices.getSelectedRow();
        tblInvoices.setRowSelectionInterval(selected, selected);
        if (selected != -1) {
//            txtInvoiceNumber.setText("" + inLists.get(selected).getClientID());
//            txtClientName.setText(inLists.get(selected).getClientName());
//            txtContactName.setText(inLists.get(selected).getContactName());
//            txtContactNumber.setText(inLists.get(selected).getContactNumber());
//            txtPaymentContact.setText(inLists.get(selected).getPaymentContact());
//            txtDeliveryAddress.setText(inLists.get(selected).getDeliveryAddress());
//            txtTrayType.setText(inLists.get(selected).getType());
//            txtQuantity.setText("" + inLists.get(selected).getQuantity());
//            txtPaymentType.setText(inLists.get(selected).getPaymentType());
//            datePickerDate.setDate(inLists.get(selected).getDate());
//            txtPrice.setText("" + inLists.get(selected).getPrice());
//            checkDelivered.setSelected(inLists.get(selected).isDelivered());
//            checkPaid.setSelected(inLists.get(selected).isPaid());
            // works
            txtInvoiceNumber.setText("" + tblInvoices.getValueAt(selected, 0));
            txtClientName.setText((String) tblInvoices.getValueAt(selected, 1));
            txtContactName.setText((String) tblInvoices.getValueAt(selected, 2));
            txtContactNumber.setText((String) tblInvoices.getValueAt(selected, 3));
            txtPaymentContact.setText((String) tblInvoices.getValueAt(selected, 4));
            txtDeliveryAddress.setText((String) tblInvoices.getValueAt(selected, 5));
            txtTrayType.setText((String) tblInvoices.getValueAt(selected, 6));
            txtQuantity.setText("" + tblInvoices.getValueAt(selected, 7));
            txtPaymentType.setText("" + tblInvoices.getValueAt(selected, 8));
            //datePickerDate.setDate(inLists.get(selected).getDate());
            datePickerDate.setDate((LocalDate) tblInvoices.getValueAt(selected, 9));
            txtPrice.setText("" + tblInvoices.getValueAt(selected, 10));
            checkDelivered.setSelected((boolean) tblInvoices.getValueAt(selected, 11));
            checkPaid.setSelected((boolean) tblInvoices.getValueAt(selected, 12));
//tblInvoices.setRowSelectionInterval(selected, selected);

        }
    }

    public void setSelected(int selected) {
        // Store the original value of the static field
//        int originalStaticValue = staticField;
//
//        // Set the static field to the non-static field's value
//        staticField = nonStaticField;
//
//        // Print the current values for demonstration
//        System.out.println("Temporary Static Field Value: " + staticField);
//        System.out.println("Original Static Field Value: " + originalStaticValue);
//
//        // Perform operations with the static field set to the non-static field's value
//        // ...
//
//        // Restore the original value of the static field
//        staticField = originalStaticValue;
//        selected = tblInvoices.getSelectedRow();
//        int or = stat;
//        stat = selected;
//        System.out.println(or);
//        System.out.println(stat);
//    }
//
        try {

            FileWriter fw = new FileWriter("selected.txt.txt");
            fw.write(selected);
            System.out.println(String.valueOf(selected));
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public InvoiceList seeInvoice() {
        // ArrayList<InvoiceList> i = dh.inList();
        selected = tblInvoices.getSelectedRow();
        tblInvoices.setRowSelectionInterval(selected, selected);
        InvoiceList l = inLists.get(selected);
        //System.out.println(l);
//        String clientName = inLists.get(selected).getClientName();
//        LocalDate date = inLists.get(selected).getDate();
//        for (int j = 0; j < inLists.size(); j++) {
//            if (clientName.equals(inLists.get(j).getClientName())) {
//                if (date.equals(inLists.get(j).getDate())) {
//                    l = inLists.get(j);
//                }
//            } else {gh
//                // JOptionPane.showMessageDialog(null, "");
//            }
//        }
        return l;

    }

    public String billTo() {
        return "" + tblInvoices.getValueAt(selected, 1);
    }
//    txtDeliveryAddress.setText(selectedInvoice.getDeliveryAddress());
//        txtContactName.setText(selectedInvoice.getContactName());
//        txtContactNumber.setText(selectedInvoice.getContactNumber());
//        txtInvoiceNumber.setText("" + selectedInvoice.getClientID());
//        datePickerDate.setDate(selectedInvoice.getDate());
//        txtTotalPrice.setText("" + selectedInvoice.getPrice());
//        txtName.setText(selectedInvoice.getClientName());
//        txtPaymentType.setText(selectedInvoice.getPaymentType());
//        checkPaid.setSelected(selectedInvoice.isPaid());
//        checkDelivered.setSelected(selectedInvoice.isDelivered());

    public String delAdd() {
        return "" + tblInvoices.getValueAt(selected, 5);
    }

    public String contactName() {
        return "" + tblInvoices.getValueAt(selected, 2);
    }

    public String contactNum() {
        return "" + tblInvoices.getValueAt(selected, 3);
    }

    public String inNum() {
        return "" + tblInvoices.getValueAt(selected, 0);
    }

    public LocalDate date() {
        String sDate = "" + tblInvoices.getValueAt(selected, 9);
        LocalDate date = LocalDate.parse(sDate);
        return date;
    }

    public String tPrice() {
        return "" + tblInvoices.getValueAt(selected, 10);
    }

    public String payType() {
        return "" + tblInvoices.getValueAt(selected, 8);
    }

    public boolean paid() {
        boolean b = Boolean.parseBoolean("" + tblInvoices.getValueAt(selected, 11));
        return b;
    }

    public boolean del() {
        boolean b = Boolean.parseBoolean("" + tblInvoices.getValueAt(selected, 12));
        return b;
    }

    public String trays() {
        return "" + tblInvoices.getValueAt(selected, 6);
    }

    public String quantities() {
        return "" + tblInvoices.getValueAt(selected, 7);
    }
//
//    public String client() {
//
//        String i = txtInvoiceNumber.getText();
//        String s = txtClientName.getText();
//        txtContactName.getText();
//        txtContactNumber.getText();
//        txtPaymentContact.setText((String) tblInvoices.getValueAt(selected, 4));
//        txtDeliveryAddress.setText((String) tblInvoices.getValueAt(selected, 5));
//        txtTrayType.setText((String) tblInvoices.getValueAt(selected, 6));
//        txtQuantity.setText("" + tblInvoices.getValueAt(selected, 7));
//        txtPaymentType.setText("" + tblInvoices.getValueAt(selected, 8));
//        //datePickerDate.setDate(inLists.get(selected).getDate());
//        datePickerDate.setDate((LocalDate) tblInvoices.getValueAt(selected, 9));
//        txtPrice.setText("" + tblInvoices.getValueAt(selected, 10));
//        checkDelivered.setSelected((boolean) tblInvoices.getValueAt(selected, 11));
//        checkPaid.setSelected((boolean) tblInvoices.getValueAt(selected, 12));
//        return s;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSeeInvoice = new javax.swing.JButton();
        txtClientName = new javax.swing.JTextField();
        txtContactName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtPaymentContact = new javax.swing.JTextField();
        txtDeliveryAddress = new javax.swing.JTextField();
        txtTrayType = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPaymentType = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        checkDelivered = new javax.swing.JCheckBox();
        checkPaid = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        datePickerDate = new com.github.lgooddatepicker.components.DatePicker();

        jTextField11.setText("jTextField11");

        jTextField10.setText("jTextField10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoices");

        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice Number", "ClientName", "ContactName", "Contact Number", "Payment Contact", "Delivery Address", "Tray Type", "Quantity", "Payment Type", "Date", "Price", "Delivered", "Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInvoices);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save in PDF");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSeeInvoice.setText("See Invoice");
        btnSeeInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInvoiceActionPerformed(evt);
            }
        });

        jLabel2.setText("Client Name");

        jLabel4.setText("Contact Number");

        jLabel5.setText("Contact Name");

        jLabel6.setText("Payment Contact");

        jLabel7.setText("Delivery Address");

        jLabel8.setText("Tray Type");

        jLabel9.setText("Quantity");

        jLabel10.setText("Payment Type");

        jLabel11.setText("Price");

        jLabel12.setText("Delivered");

        jLabel13.setText("Paid");

        jLabel3.setText("Invoice Number");

        jLabel14.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContactName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPaymentContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTrayType, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(320, 320, 320)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(336, 336, 336)
                                        .addComponent(checkDelivered))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeeInvoice)
                                .addGap(45, 45, 45)
                                .addComponent(btnSave)
                                .addGap(39, 39, 39)
                                .addComponent(btnDelete)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkPaid)
                            .addComponent(jLabel13))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnBack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1605, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel3)
                                        .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkPaid)
                                            .addComponent(checkDelivered))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 4, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtPaymentContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTrayType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDelete)
                                .addComponent(btnSave)
                                .addComponent(btnSeeInvoice)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addComponent(jLabel5))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuUI m = new MenuUI();
        m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    /**
     * creates a new invoiceUI makes it visible makes the invoicesui disappear
     *
     * @param evt
     */
    private void btnSeeInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInvoiceActionPerformed
        InvoiceUI i = new InvoiceUI();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeeInvoiceActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        int response = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this invoice?",
//                "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoicesMouseClicked
        selected = tblInvoices.getSelectedRow();
        this.valueChanged();
        this.setSelected(selected);
        tblInvoices.setRowSelectionInterval(selected, selected);
        // System.out.println(selected);
    }//GEN-LAST:event_tblInvoicesMouseClicked

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
            java.util.logging.Logger.getLogger(InvoicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoicesUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSeeInvoice;
    private javax.swing.JCheckBox checkDelivered;
    private javax.swing.JCheckBox checkPaid;
    private com.github.lgooddatepicker.components.DatePicker datePickerDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtContactName;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtDeliveryAddress;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtPaymentContact;
    private javax.swing.JTextField txtPaymentType;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTrayType;
    // End of variables declaration//GEN-END:variables
}
