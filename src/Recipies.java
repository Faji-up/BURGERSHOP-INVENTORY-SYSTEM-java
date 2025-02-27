
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Recipies extends javax.swing.JFrame {

    /**
     * Creates new form Foods
     */
    public Recipies() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        add_rows_to_table();
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
            
            BufferedImage orig_ref_btn;
            Image images_ref_btn;
            orig_ref_btn = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/refresh.png"));
            images_ref_btn = orig_ref_btn.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
            ImageIcon icon_ref_btn = new ImageIcon(images_ref_btn);
            this.refBtn.setIcon(icon_ref_btn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add_rows_to_table() {
        int totalSALES = 0;
        DBConnection foods = new DBConnection();
        DefaultTableModel model = (DefaultTableModel) this.inventoryTable.getModel();

        for (Recipe recipe : foods.getRecipies()) {
            Object[] row = {recipe.get_recipe_name(), recipe.get_price(), recipe.get_stock(), recipe.get_total_price()};
            model.addRow(row);

        }
        this.inventoryTable.revalidate();
        this.inventoryTable.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo_burger = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalSalesLabel = new javax.swing.JLabel();
        refBtn = new javax.swing.JButton();
        logo = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        ordersBtn = new javax.swing.JButton();
        invenBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Burger Shop");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(858, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo_burger, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 40));

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe  Name", "Price", "Stock", "Total Price"
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
        inventoryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryTable);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1020, 500));

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, new java.awt.Color(204, 102, 0)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("Inventory");

        totalSalesLabel.setBackground(new java.awt.Color(255, 255, 255));
        totalSalesLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        totalSalesLabel.setForeground(new java.awt.Color(0, 153, 0));

        refBtn.setBackground(new java.awt.Color(168, 136, 0));
        refBtn.setForeground(new java.awt.Color(0, 0, 0));
        refBtn.setText("Refresh");
        refBtn.setBorderPainted(false);
        refBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalSalesLabel)
                .addGap(38, 38, 38))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 782, Short.MAX_VALUE)
                .addComponent(refBtn)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(refBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalSalesLabel))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1020, -1));

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

    private void inventoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTableMouseClicked
        // TODO add your handling code here:
        System.out.println(this.inventoryTable.getSelectedRow());
        DefaultTableModel model = (DefaultTableModel) this.inventoryTable.getModel();
        String burgerName = (String) model.getValueAt(this.inventoryTable.getSelectedRow(), 0);
        int price = (int) model.getValueAt(this.inventoryTable.getSelectedRow(), 1);
        int stock = (int) model.getValueAt(this.inventoryTable.getSelectedRow(), 2);
        System.out.println(model.getValueAt(this.inventoryTable.getSelectedRow(), 0));
        new UpdateRecipe(burgerName, price, stock);

    }//GEN-LAST:event_inventoryTableMouseClicked

    private void refBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        if (model.getRowCount() > 0) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);

            }
            add_rows_to_table();
        }

    }//GEN-LAST:event_refBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void ordersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Orders orders = new Orders();
        orders.setVisible(true);
    }//GEN-LAST:event_ordersBtnActionPerformed

    private void invenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenBtnActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_invenBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Recipies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recipies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recipies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recipies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recipies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton invenBtn;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logo_burger;
    private javax.swing.JButton ordersBtn;
    private javax.swing.JButton refBtn;
    private javax.swing.JLabel totalSalesLabel;
    // End of variables declaration//GEN-END:variables
}
