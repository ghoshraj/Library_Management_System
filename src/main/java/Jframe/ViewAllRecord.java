
package Jframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;

public class ViewAllRecord extends javax.swing.JFrame {

    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setissuebookDetailsToTable();
    }

    public void setissuebookDetailsToTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "raj@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

            while (rs.next()){
                int id = rs.getInt("id");
                String bookname = rs.getString("book_name");
                String studentname = rs.getString("student_name");
                String issuedate = rs.getString("issue_date");
                String duedate = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj  = {id , bookname , studentname , issuedate , duedate , status};
                model = (DefaultTableModel)tblissuetable.getModel();
                model.addRow(obj);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //clear table before add book details --- >
    public void cleartable(){
        DefaultTableModel model = (DefaultTableModel)tblissuetable.getModel();
        model.setRowCount(0);
    }

    //to see the record using date field------------>
    public void search(){
        Date d = datefromdate.getDatoFecha();
        Date dd = datefromdate.getDatoFecha();

        long l1 = d.getTime();
        long l2 = dd.getTime();

        java.sql.Date s = new java.sql.Date(l1);
        java.sql.Date ss = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1 , s);
            pst.setDate(2 , ss);

            ResultSet rs = pst.executeQuery();

            if (rs.next() == false){
                JOptionPane.showMessageDialog(this , "No Record Found");
            }
            else {
                while (rs.next()){

                    int id = rs.getInt("id");
                    String bookname = rs.getString("book_name");
                    String studentname = rs.getString("student_name");
                    String issuedate = rs.getString("issue_date");
                    String duedate = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj  = {id , bookname , studentname , issuedate , duedate , status};
                    model = (DefaultTableModel)tblissuetable.getModel();
                    model.addRow(obj);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        datetodate = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        datefromdate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblissuetable = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel12.setText("View All Records");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 300, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 105, 360, 5));

        datetodate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        datetodate.setPlaceholder("select due date");
        jPanel1.add(datetodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 320, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Due Date :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 120, 40));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 0, 51));
        jLabel18.setText("Issue Date :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, 40));

        datefromdate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        datefromdate.setPlaceholder("select issue date");
        jPanel1.add(datefromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 290, -1));

        rSMaterialButtonCircle1.setText("Search");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 160, 60));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, -1, 40));

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle2.setText("All");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 150, 160, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 220));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblissuetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue date", "Due Date", "Status"
            }
        ));
        tblissuetable.setColorBackgoundHead(new java.awt.Color(102, 255, 102));
        tblissuetable.setColorBordeFilas(new java.awt.Color(255, 255, 51));
        tblissuetable.setColorBordeHead(new java.awt.Color(255, 51, 51));
        tblissuetable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblissuetable.setColorFilasForeground1(new java.awt.Color(0, 255, 255));
        tblissuetable.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tblissuetable.setColorSelBackgound(new java.awt.Color(255, 0, 255));
        tblissuetable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tblissuetable.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tblissuetable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tblissuetable.setFuenteHead(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        tblissuetable.setRowHeight(25);
        jScrollPane1.setViewportView(tblissuetable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 1090, 290));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1330, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {
        cleartable();
        setissuebookDetailsToTable();
    }

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
        Home_Page page = new Home_Page();
        page.setVisible(true);
        dispose();
    }

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(datefromdate.getDatoFecha() != null && datetodate.getDatoFecha() != null) {
            cleartable();
            search();
        }
        else {
            JOptionPane.showMessageDialog(this , "Please Select A Date");
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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser datefromdate;
    private rojeru_san.componentes.RSDateChooser datetodate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tblissuetable;
    // End of variables declaration//GEN-END:variables
}
