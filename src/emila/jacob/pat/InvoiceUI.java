/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emila.jacob.pat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 24emilaj
 */
public class InvoiceUI extends javax.swing.JFrame {
//public class InvoiceUI extends InvoicesUI {

    private DataHandler dh = new DataHandler();

    /**
     * Creates new form InvoiceUI
     */
    public InvoiceUI() {
        initComponents();
        btnSaveInPDF.setVisible(false);
        btnUpdate.setVisible(false);
     
        ImageIcon image = new ImageIcon("C:/Emila PAT/PAT/SVLOGO.jpg");
        lblLogo.setIcon(image);
        this.setTexts();
        this.getPricePerType();
        this.insertTable();
        this.toolTips();

    }

    /**
     * method which sets all the tooltip texts for buttons/textfields on the
     * jframe
     */
    public void toolTips() {
        // sets tooltip text for back button
        btnBack.setToolTipText("Click this button go back to the list of invoices");
        // sets tooltip text for update button
        btnUpdate.setToolTipText("Click this button to update any information on the invoice");
        // sets tooltip text for save in a pdf button
      //  btnSaveInPDF.setToolTipText("Click this button to save this invoice as a PDF");
      // sets Tool tip text for the view total button
      btnViewTotal.setToolTipText("Click this button to view the total for the invoice");
    }
    
    public double calculateTotalPrice(){
        double price = 0;
        ArrayList<pricesForInvoice> priceIn = this.getPricePerType();
        for (int i = 0; i < priceIn.size(); i++) {
            price += Double.parseDouble("" + tblInvoice.getValueAt(i, 3));
        }
        System.out.println(price);
        return price;
    }

    public void setTexts() {
        InvoicesUI i = new InvoicesUI();
        InvoiceList selectedInvoice = i.seeInvoice();
        txtBillTo.setText(i.billTo());
        //txtBillTo.setText(selectedInvoice.getClientName());
//        txtDeliveryAddress.setText(selectedInvoice.getDeliveryAddress());
//        txtContactName.setText(selectedInvoice.getContactName());
//        txtContactNumber.setText(selectedInvoice.getContactNumber());
//        txtInvoiceNumber.setText("" + selectedInvoice.getClientID());
//        datePickerDate.setDate(selectedInvoice.getDate());
//        txtTotalPrice.setText("" + selectedInvoice.getPrice());
//        txtName.setText(selectedInvoice.getClientName());
//        txtPaymentType.setText(selectedInvoice.getPaymentType());
//        checkPaid.setSelected(selectedInvoice.isPaid());
//        checkDelivered.setSelected(selectedInvoice.isDelivered());
        txtDeliveryAddress.setText(i.delAdd());
        txtContactName.setText(i.contactName());
        txtContactNumber.setText(i.contactNum());
        txtInvoiceNumber.setText(i.inNum());
        datePickerDate.setDate(i.date());
      //  txtTotalPrice.setText(i.tPrice());
      txtTotalPrice.setText("" );
        txtName.setText(i.billTo());
        txtPaymentType.setText(i.payType());
        checkPaid.setSelected(i.paid());
        checkDelivered.setSelected(i.del());
    }

    public ArrayList<pricesForInvoice> getPricePerType() {
        ArrayList<InvoiceList> inLists = dh.inList();
        InvoicesUI in = new InvoicesUI();
        InvoiceList selectedInvoice = in.seeInvoice();
        ArrayList<TrayTypes> t = dh.getAlltrayTypes();
        ArrayList<pricesForInvoice> prices = dh.pricesForInvoice();
        ArrayList<pricesForInvoice> types = new ArrayList<>();
        // System.out.println(prices.toString());
        for (int i = 0; i < prices.size(); i++) {
            if (selectedInvoice.getInvoiceID() == prices.get(i).getInvoiceID()) {
                String trayTypes = in.trays();
                String quantities = in.quantities();
                Scanner scFile = new Scanner(trayTypes);
                Scanner scQ = new Scanner(quantities);
                scFile.useDelimiter(",");
                scQ.useDelimiter(",");
                while (scFile.hasNext() && scQ.hasNext()) {
                    int invoiceID = selectedInvoice.getInvoiceID();
                    String type = scFile.next();

                    int trayTypeID = 0;
                    for (int j = 0; j < t.size(); j++) {
                        if (type.equalsIgnoreCase(t.get(j).getType())) {
                            trayTypeID = t.get(j).getTrayTypeID();
                        }
                    }
                    double price = prices.get(i).getPrice();

                    // maybe other date
                    LocalDate date = selectedInvoice.getDate();
                    int discount = prices.get(i).getDiscountPercentage();
                    int q = scQ.nextInt();
                    pricesForInvoice pFi = new pricesForInvoice(invoiceID, trayTypeID, type, price, date, discount, q);
                    types.add(pFi);

                }

            }
        }
     //   System.out.println(types.toString());
//
//        for (int i = 0; i < inLists.size(); i++) {
//            // check dates
//
//         //   System.out.println(prices.get(i).getInvoiceID() + "..");
//            if (inLists.get(i).getType().equalsIgnoreCase(prices.get(i).getType())) {
//             //   System.out.println(inLists.get(i).getType());
//            }
////            if (inLists.get(i).getInvoiceID()== prices.get(i).getInvoiceID() 
////                    && inLists.get(i).getDate().getMonth().compareTo((prices.get(i).getDateUpdated()).getMonth())<=1) {
////                int pos = i;
////                System.out.println(i);
////            }
//        }
//        InvoicesUI i = new InvoicesUI();
//    String trays = i.trays();
//       // System.out.println(i.trays());
//       DataHandler dh = new DataHandler();
//        ArrayList<String> types = new ArrayList<>();
//        ArrayList<TrayTypes> t = dh.getAlltrayTypes();
//        System.out.println(t);
//       Scanner scFile = new Scanner(trays);
//       scFile.useDelimiter(",");
//        while (scFile.hasNext()) {
//            String trayType = scFile.next();
//            if (types.isEmpty()) {
//                System.out.println("eee");
//            } else  {
//            types.add(trayType);
//        }}
//        scFile.close();
//        for (int j = 0; j < t.size(); j++) {
//            if (types.get(j).equalsIgnoreCase(t.get(j).getType())) {
//                int id = t.get(j).getTrayTypeID();
//                System.out.println(id);
//                //return id;
//            }
//        }
        // quan
        return types;
    }

    public void insertTable() {
        ArrayList<pricesForInvoice> priceIn = this.getPricePerType();
        DataHandler dh = new DataHandler();
        DefaultTableModel dtm = (DefaultTableModel) tblInvoice.getModel();
        dtm.setRowCount(0);
        tblInvoice.setModel(dtm);
        Object invoice[] = new Object[4];
        for (int i = 0; i < priceIn.size(); i++) {
            invoice[0] = priceIn.get(i).getQuantity();
            invoice[1] = priceIn.get(i).getType();
            invoice[2] = priceIn.get(i).getPrice();
            invoice[3] = priceIn.get(i).getQuantity() * priceIn.get(i).getPrice();
            dtm.addRow(invoice);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPaymentType = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSaveInPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtBillTo = new javax.swing.JTextField();
        txtDeliveryAddress = new javax.swing.JTextField();
        txtContactName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        checkDelivered = new javax.swing.JCheckBox();
        datePickerDate = new com.github.lgooddatepicker.components.DatePicker();
        lblLogo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        checkPaid = new javax.swing.JCheckBox();
        btnViewTotal = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField3.setText("jTextField3");

        jTextField1.setText("jTextField1");

        jTextField10.setText("jTextField10");

        jLabel18.setText("Total:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoice");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setText("Delivered:");

        jLabel3.setText("Payment Type:");

        jLabel4.setText("Signed received:");

        jLabel5.setText("Name:");

        txtPaymentType.setText("jTextField2");

        txtName.setText("jTextField4");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");

        btnSaveInPDF.setText("Save in PDF");

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Quantity", "Tray Type", "Price Per Type", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInvoice);

        jLabel6.setText("Natural Farming");

        jLabel9.setText("Healthy Living");

        jLabel10.setText("springviewnfarming@gmail.com");

        jLabel11.setText("www.springview.co.za");

        jLabel12.setText("Bill to:");

        jLabel13.setText("Delivery Address:");

        jLabel14.setText("Contact Name:");

        jLabel15.setText("Contact Number:");

        txtBillTo.setText("Kwandwe");
        txtBillTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillToActionPerformed(evt);
            }
        });

        txtDeliveryAddress.setText("rotenbag");
        txtDeliveryAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeliveryAddressActionPerformed(evt);
            }
        });

        txtContactName.setText("rty");

        txtContactNumber.setText("08653478655");
        txtContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNumberActionPerformed(evt);
            }
        });

        jLabel16.setText("Invoice Number:");

        txtInvoiceNumber.setText("5");

        jLabel17.setText("Date:");

        txtTotalPrice.setText("jTextField11");

        checkDelivered.setText("jCheckBox1");

        jLabel19.setText("071 7537573 (mobile number)");

        jLabel20.setText("Paid");

        checkPaid.setText("jCheckBox1");

        btnViewTotal.setText("View Total");
        btnViewTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel2))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(checkDelivered)
                                            .addComponent(checkPaid))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate)
                                .addGap(48, 48, 48)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveInPDF)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(jLabel17)
                                    .addGap(36, 36, 36)
                                    .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addGap(173, 173, 173)
                                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(34, 34, 34)
                                .addComponent(txtContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(81, 81, 81)
                                    .addComponent(txtBillTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(24, 24, 24)
                                .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(btnViewTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalPrice)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(txtBillTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtDeliveryAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(47, 47, 47)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTotal))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(checkDelivered))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(checkPaid))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnUpdate)
                    .addComponent(btnSaveInPDF))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        InvoicesUI i = new InvoicesUI();
        i.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtBillToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillToActionPerformed

    private void txtDeliveryAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeliveryAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeliveryAddressActionPerformed

    private void txtContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNumberActionPerformed

    private void btnViewTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTotalActionPerformed
        txtTotalPrice.setText("" + this.calculateTotalPrice());
    }//GEN-LAST:event_btnViewTotalActionPerformed

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
            java.util.logging.Logger.getLogger(InvoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveInPDF;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewTotal;
    private javax.swing.JCheckBox checkDelivered;
    private javax.swing.JCheckBox checkPaid;
    private com.github.lgooddatepicker.components.DatePicker datePickerDate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTextField txtBillTo;
    private javax.swing.JTextField txtContactName;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtDeliveryAddress;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPaymentType;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}
