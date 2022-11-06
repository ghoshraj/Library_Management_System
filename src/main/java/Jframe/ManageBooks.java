
package Jframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;

public class ManageBooks extends javax.swing.JFrame {
    String book_name , author;
    int book_id , quantity;
    DefaultTableModel model;
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }

    //set the book details into the table...
    public void setBookDetailsToTable(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "raj@123");
        Statement st = con.createStatement();
       // st.executeUpdate("insert into book_details (book_name , author, quantity )values\n" +
       //         "('java' , 'Narasimha Karumanchi' , 2);");
        ResultSet rs = st.executeQuery("select * from book_details");

        while (rs.next()){
            int book_id = rs.getInt("book_id");
            String name = rs.getString("book_name");
            String author = rs.getString("author");
            int quantity = rs.getInt("quantity");

            Object[] obj  = {book_id,name,author,quantity};
            model = (DefaultTableModel)tdl_bookdetails.getModel();
            model.addRow(obj);
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
//add book details to the table--->
    public boolean addbook(){
        boolean isadded = false;
        book_id = Integer.parseInt(txt_bookid.getText());
        book_name = txt_bookname.getText();
        author = txt_authorname.getText();
        quantity = Integer.parseInt(txt_quantity.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(? ,? , ? , ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , book_id);
            pst.setString(2 , book_name);
            pst.setString(3 , author);
            pst.setInt(4 , quantity);

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                isadded = true;
            }
            else {
                isadded = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return isadded;
    }

    //update book details --- >
    public boolean updatebook(){
        boolean isupdate = false;
        book_id = Integer.parseInt(txt_bookid.getText());
        book_name = txt_bookname.getText();
        author = txt_authorname.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set book_name = ? , author = ? , quantity = ? where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1 , book_name);
            pst.setString(2 , author);
            pst.setInt(3 , quantity);
            pst.setInt(4 , book_id);

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                isupdate = true;
            }
            else {
                isupdate = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isupdate;
    }

    // delete book details --->
    public boolean delete(){
        boolean isdelete = false;
        book_id = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql ="delete from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , book_id);

            int rowcount = pst.executeUpdate();
            if(rowcount > 0){
                isdelete = true;
            }
            else {
                isdelete = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return isdelete;
    }
    //clear table before add book details --- >
    public void cleartable(){
        DefaultTableModel model = (DefaultTableModel)tdl_bookdetails.getModel();
        model.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_bookname = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_authorname = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdl_bookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        txt_bookname.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_bookname.setPlaceholder("EnterBook Name....");
        txt_bookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_booknameFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 320, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Book Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Moleskine_26px.png")); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 70, 70));

        txt_bookid.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book ID.....");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 320, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Book Id");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 220, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Contact_26px.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, -1));

        txt_authorname.setBackground(new java.awt.Color(102, 102, 255));
        txt_authorname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authorname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_authorname.setPlaceholder("Enter Author Name....");
        txt_authorname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authornameFocusLost(evt);
            }
        });
        jPanel1.add(txt_authorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 320, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Author Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 220, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Collaborator_Male_26px.png")); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 70, 70));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_quantity.setPlaceholder("Total quantity...");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 320, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantity");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 220, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Unit_26px.png")); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 70, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 110, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 110, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 110, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 690));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));
        jPanel4.setForeground(new java.awt.Color(255, 102, 102));

        jLabel3.setBackground(new java.awt.Color(51, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 80, 40));

        tdl_bookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tdl_bookdetails.setColorBackgoundHead(new java.awt.Color(102, 255, 102));
        tdl_bookdetails.setColorBordeFilas(new java.awt.Color(255, 255, 51));
        tdl_bookdetails.setColorBordeHead(new java.awt.Color(255, 51, 51));
        tdl_bookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tdl_bookdetails.setColorFilasForeground1(new java.awt.Color(0, 255, 255));
        tdl_bookdetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tdl_bookdetails.setColorSelBackgound(new java.awt.Color(255, 0, 255));
        tdl_bookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tdl_bookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tdl_bookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tdl_bookdetails.setFuenteHead(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        tdl_bookdetails.setRowHeight(25);
        tdl_bookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdl_bookdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdl_bookdetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 830, 300));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Books_52px_1.png")); // NOI18N
        jLabel2.setText("  manage Book");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 220, 70));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 330, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 890, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_booknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_booknameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameFocusLost

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_authornameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authornameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authornameFocusLost

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updatebook() == true){
            JOptionPane.showMessageDialog(this , "book updated");
            cleartable();
            setBookDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "book update failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (delete() == true){
            JOptionPane.showMessageDialog(this , "book deleted");
            cleartable();
            setBookDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "book delation failed");
        }
    }

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (addbook() == true){
            JOptionPane.showMessageDialog(this , "book added");
            cleartable();
            setBookDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "book addition failed");
        }
    }

    private void tdl_bookdetailsMouseClicked(java.awt.event.MouseEvent evt) {
        int rowno = tdl_bookdetails.getSelectedRow();
        TableModel model = tdl_bookdetails.getModel();

        txt_bookid.setText(model.getValueAt(rowno , 0).toString());
        txt_bookname.setText(model.getValueAt(rowno , 1).toString());
        txt_authorname.setText(model.getValueAt(rowno , 2).toString());
        txt_quantity.setText(model.getValueAt(rowno , 3).toString());
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
       System.exit(0);
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        Home_Page page = new Home_Page();
        page.setVisible(true);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tdl_bookdetails;
    private app.bolivia.swing.JCTextField txt_authorname;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
