/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;

import java.util.*;
*/
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
public class Orders extends javax.swing.JFrame {

    /**
     * Creates new form Orders
     */
    public Orders() {
        initComponents();
        add_rows_to_table();
        add_rows_to_table_sales();
        //ordersTable
        setResizable(false);
        setLocationRelativeTo(null);
        add_image();
    }
    private void add_image() {
        try {
            BufferedImage orig_logo;
            Image images_logo;
            orig_logo =ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/logo.png"));
            images_logo = orig_logo.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
            ImageIcon icon_logo = new ImageIcon(images_logo);
            
            this.logo_burger.setIcon(icon_logo);
            
            
            BufferedImage orig_home_btn;
            Image images_home_btn;
            orig_home_btn = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/png-home-icon-7.jpg"));
            images_home_btn = orig_home_btn.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
            ImageIcon icon_home_btn = new ImageIcon(images_home_btn);
            this.homeBtn.setIcon(icon_home_btn);
            
            BufferedImage orig_orders_btn;
            Image images_orders_btn;
            orig_orders_btn = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/inventory.png"));
            images_orders_btn = orig_orders_btn.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
            ImageIcon icon_orders_btn = new ImageIcon(images_orders_btn);
            this.ordersBtn.setIcon(icon_orders_btn);
            
            
            BufferedImage orig_inven_btn;
            Image images_inven_btn;
            orig_inven_btn = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/orderlist.png"));
            images_inven_btn = orig_inven_btn.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
            ImageIcon icon_inven_btn = new ImageIcon(images_inven_btn);
            this.invenBtn.setIcon(icon_inven_btn);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add_rows_to_table_sales() {
      
        DBConnection orders= new DBConnection();
        DefaultTableModel model = (DefaultTableModel) burgerSalesTable.getModel();
        for(BurgerSale sale: orders.get_burger_sales()){ 
            Object[] row = {
                sale.get_item(),
                sale.get_sales(),
                sale.get_price(),
                (sale.get_price()*(sale.get_sales()))
            };
            
            model.addRow(row);
        
        }
       
        burgerSalesTable.revalidate();
        burgerSalesTable.repaint();
        
    }
    public void add_rows_to_table() {
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        if (model.getRowCount() > 0) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);

            }
            
        }
        int filter = filterValue.getSelectedIndex();
       
        int totalSALES = 0;
        DBConnection orders= new DBConnection();
        
        String[] date;
        for(Order order: orders.getOrders()){ 
            if(filter == 0){
               
                 Object[] row = {order.get_foods(),
                    order.get_quantity(),
                    order.get_total_price(),
                    order.get_customer(),
                    order.get_receipt_code()};
                totalSALES += order.get_total_price();
                model.addRow(row);   
               
            }else if(filter == 3){
               
                    if(order.get_date().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()) 
                       {
                           System.out.println(order.get_date().getDayOfMonth() +" == "+LocalDateTime.now().getDayOfMonth());
                            Object[] row = {order.get_foods(),
                                            order.get_quantity(),
                                            order.get_total_price(),
                                            order.get_customer(),
                                            order.get_receipt_code()};
                            totalSALES += order.get_total_price();
                            model.addRow(row);          
                    }
                
            }else if(filter == 1){
                if(LocalDateTime.now().getYear() == order.get_date().getYear()){
                    System.out.println(order.get_date().getYear() +" == "+LocalDateTime.now().getYear());
                    Object[] row = {order.get_foods(),
                                    order.get_quantity(),
                                    order.get_total_price(),
                                    order.get_customer(),
                                    order.get_receipt_code()};
                    totalSALES += order.get_total_price();
                    model.addRow(row); 
                }
               
            }else if(filter == 2){
                if(LocalDateTime.now().getMonth() == order.get_date().getMonth() &&
                   LocalDateTime.now().getYear() == order.get_date().getYear()){
                     Object[] row = {order.get_foods(),
                                    order.get_quantity(),
                                    order.get_total_price(),
                                    order.get_customer(),
                                    order.get_receipt_code()};
                    totalSALES += order.get_total_price();
                    model.addRow(row); 
                }
            }
            
            
        }
        
        this.totalSalesLabel.setText(totalSALES + "PHP");
        ordersTable.revalidate();
        ordersTable.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalSalesLabel = new javax.swing.JLabel();
        filterValue = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        burgerSalesTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        logo_burger = new javax.swing.JLabel();
        logo = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        ordersBtn = new javax.swing.JButton();
        invenBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Burger Shop");
        setBackground(new java.awt.Color(255, 153, 51));
        setMinimumSize(new java.awt.Dimension(1097, 593));
        setSize(new java.awt.Dimension(1097, 593));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordersTable.setBackground(new java.awt.Color(255, 153, 51));
        ordersTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ordersTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orders", "Quantity", "Total Price", "Customer", "Order Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable.setToolTipText("");
        ordersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ordersTable.setPreferredSize(new java.awt.Dimension(375, 467));
        ordersTable.setSelectionBackground(new java.awt.Color(255, 153, 51));
        ordersTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ordersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ordersTable);

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(204, 102, 0)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Total Sales: ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("SALES");

        totalSalesLabel.setBackground(new java.awt.Color(255, 255, 255));
        totalSalesLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        totalSalesLabel.setForeground(new java.awt.Color(0, 153, 0));

        filterValue.setBackground(new java.awt.Color(255, 204, 51));
        filterValue.setForeground(new java.awt.Color(0, 51, 51));
        filterValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "This Year", "This Month", "Today" }));
        filterValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterValueMouseClicked(evt);
            }
        });
        filterValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSalesLabel)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(filterValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(filterValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalSalesLabel)))
        );

        burgerSalesTable.setBackground(new java.awt.Color(255, 153, 51));
        burgerSalesTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        burgerSalesTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        burgerSalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Burger", "Sales", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        burgerSalesTable.setToolTipText("");
        burgerSalesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        burgerSalesTable.setPreferredSize(new java.awt.Dimension(375, 467));
        burgerSalesTable.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jScrollPane3.setViewportView(burgerSalesTable);
        burgerSalesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (burgerSalesTable.getColumnModel().getColumnCount() > 0) {
            burgerSalesTable.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 570, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 462, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1030, 550));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));

        logo_burger.setBackground(new java.awt.Color(255, 255, 255));
        logo_burger.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        logo_burger.setForeground(new java.awt.Color(153, 0, 0));
        logo_burger.setText("Burger Shop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo_burger, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(868, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo_burger, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 40));

        logo.setBackground(new java.awt.Color(255, 153, 0));
        logo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        homeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        ordersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ordersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersBtnActionPerformed(evt);
            }
        });

        invenBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invenBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ordersBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(logoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeBtn)
                .addGap(18, 18, 18)
                .addComponent(ordersBtn)
                .addGap(18, 18, 18)
                .addComponent(invenBtn)
                .addContainerGap(471, Short.MAX_VALUE))
        );

        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 60, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void ordersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ordersBtnActionPerformed

    private void invenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Recipies recipe = new Recipies();
        recipe.setVisible(true);
    }//GEN-LAST:event_invenBtnActionPerformed

    private void ordersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) this.ordersTable.getModel();
        String orders = (String) model.getValueAt(this.ordersTable.getSelectedRow(), 0);
        System.out.println(orders);
    }//GEN-LAST:event_ordersTableMouseClicked

    private void filterValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterValueActionPerformed
        // TODO add your handling code here:
        System.out.println("Filter : " + filterValue.getSelectedItem().toString());
        add_rows_to_table();
    }//GEN-LAST:event_filterValueActionPerformed

    private void filterValueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterValueMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_filterValueMouseClicked

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable burgerSalesTable;
    private javax.swing.JComboBox<String> filterValue;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton invenBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logo_burger;
    private javax.swing.JButton ordersBtn;
    private javax.swing.JTable ordersTable;
    private javax.swing.JLabel totalSalesLabel;
    // End of variables declaration//GEN-END:variables

}
