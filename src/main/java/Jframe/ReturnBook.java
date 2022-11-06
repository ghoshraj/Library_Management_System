
package Jframe;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }
    //to fetch the issue book details from the database and display it---------->
    public void getissuebook(){

        int bookid = Integer.parseInt(txt_bookid.getText());
        int studentid = Integer.parseInt(txt_studentid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , bookid);
            pst.setInt(2 , studentid);
            pst.setString(3 , "pending");

            ResultSet rs = pst.executeQuery();
            if (rs.next()){
               lblissueid.setText(rs.getString("id"));
               lblbookname.setText(rs.getString("book_name"));
               lblstudentname.setText(rs.getString("student_name"));
               lblissuedate.setText(rs.getString("issue_date"));
               lblduedate.setText(rs.getString("due_date"));
               lblbookerror.setText("");
            }
            else {
                lblbookerror.setText("No Record found");

                lblissueid.setText("");
                lblbookname.setText("");
                lblstudentname.setText("");
                lblissuedate.setText("");
                lblduedate.setText("");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //return book ----->
    public boolean returnbook(){
        boolean isreturn = false;
        int bookid = Integer.parseInt(txt_bookid.getText());
        int studentid = Integer.parseInt(txt_studentid.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id= ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1 , "returned");
            pst.setInt(2 , studentid);
            pst.setInt(3 , bookid);
            pst.setString(4 , "pending");

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                isreturn = true;
            }
            else {
                isreturn = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isreturn;
    }

    //update book count------------>
    public void updatebookcount(){
        int bookid = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity + 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1 , bookid);

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                JOptionPane.showMessageDialog(this , "book count updated");
                int initialcount = Integer.parseInt(lblissuedate.getText());
                lblissuedate.setText(Integer.toString(initialcount - 1));
            }
            else {
                JOptionPane.showMessageDialog(this , "book count not updated");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblissuedate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblissueid = new javax.swing.JLabel();
        lblbookname = new javax.swing.JLabel();
        lblstudentname = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblbookerror = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblduedate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelmain.setBackground(new java.awt.Color(255, 255, 255));
        panelmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel12.setText("   Book Details");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 270, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 310, 5));

        lblissuedate.setBackground(new java.awt.Color(255, 255, 102));
        lblissuedate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblissuedate.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblissuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 230, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Issue Id :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Book Name :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("Student Name :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, 30));

        lblissueid.setBackground(new java.awt.Color(255, 255, 102));
        lblissueid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblissueid.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblissueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 180, 30));

        lblbookname.setBackground(new java.awt.Color(255, 255, 102));
        lblbookname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbookname.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblbookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 210, 30));

        lblstudentname.setBackground(new java.awt.Color(255, 255, 102));
        lblstudentname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblstudentname.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 220, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setText("Issue Date :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        lblbookerror.setBackground(new java.awt.Color(255, 255, 102));
        lblbookerror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbookerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lblbookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 340, 30));

        jLabel22.setBackground(new java.awt.Color(255, 255, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 255));
        jLabel22.setText("Due Date :");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 120, 30));

        lblduedate.setBackground(new java.awt.Color(255, 255, 102));
        lblduedate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblduedate.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblduedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 230, 30));

        panelmain.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 400, 650));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Books_52px_1.png")); // NOI18N
        jLabel1.setText(" Return Book");
        panelmain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, 180, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        panelmain.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 180, 280, 5));

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.setForeground(new java.awt.Color(255, 102, 102));

        jLabel8.setBackground(new java.awt.Color(51, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(610, 610, 610))
        );

        panelmain.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 0, 60, 40));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));
        txt_studentid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student Id.");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        panelmain.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 330, 250, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Enter Student Id :");
        panelmain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 160, 30));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));
        txt_bookid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_bookid.setPlaceholder("Enter Book Id.");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        panelmain.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 250, 250, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Enter Book Id :");
        panelmain.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 260, 160, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonCircle2.setText("RETURN BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panelmain.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 530, 390, 60));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panelmain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 255, 0));
        rSMaterialButtonCircle3.setForeground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("FIND");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panelmain.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 440, 390, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\webdev\\icons\\icons\\library-2.png")); // NOI18N
        panelmain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 650, 570));

        getContentPane().add(panelmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
       Home_Page page = new Home_Page();
        page.setVisible(true);
        dispose();
    }                                     

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {

    }

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {

    }

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {
        getissuebook();
    }

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {
    if (returnbook() == true){
        JOptionPane.showMessageDialog(this , "Book returned Successfully");
        updatebookcount();
    }
    else {
        JOptionPane.showMessageDialog(this , "Book returned Fail");
    }
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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblbookerror;
    private javax.swing.JLabel lblbookname;
    private javax.swing.JLabel lblduedate;
    private javax.swing.JLabel lblissuedate;
    private javax.swing.JLabel lblissueid;
    private javax.swing.JLabel lblstudentname;
    private javax.swing.JPanel panelmain;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
