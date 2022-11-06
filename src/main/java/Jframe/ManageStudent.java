
package Jframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;

public class ManageStudent extends javax.swing.JFrame {
    String student_name , course , branch , year , semester;
    int student_id;
    DefaultTableModel model;
    public ManageStudent() {
        initComponents();
       setStudentDetailsToTable();
    }

    //set the student details into the table...
    public void setStudentDetailsToTable(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "raj@123");
        Statement st = con.createStatement();
//        st.executeUpdate("insert into student_details (student_name , course, branch , year , semester )values\n" +
//                "('Rajesh Ghosh' , 'B.tech' , 'cse' ,'2nd' , '4th');");
        ResultSet rs = st.executeQuery("select * from student_details");

        while (rs.next()){
            int student_id = rs.getInt("student_id");
            String student_name = rs.getString("student_name");
            String course = rs.getString("course");
            String branch = rs.getString("branch");
            String year = rs.getString("year");
            String semester = rs.getString("semester");

            Object[] obj  = {student_id,student_name,course,branch,year,semester};
            model = (DefaultTableModel)tdl_studentdetails.getModel();
            model.addRow(obj);
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }

//add student details to the table--->
    public boolean addstudent(){
        boolean isadded = false;
        student_id = Integer.parseInt(txt_studentid.getText());
        student_name = txt_studentname.getText();
        course = combocourse.getSelectedItem().toString();
        branch = combobranch.getSelectedItem().toString();
        year = comboyear.getSelectedItem().toString();
        semester = combosemester.getSelectedItem().toString();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(? ,? , ? , ? , ? ,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , student_id);
            pst.setString(2 , student_name);
            pst.setString(3 , course);
            pst.setString(4 , branch);
            pst.setString(5 , year);
            pst.setString(6 , semester);

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

    //update student details --- >
    public boolean updatestudent(){
        boolean isupdate = false;
        student_id = Integer.parseInt(txt_studentid.getText());
        student_name = txt_studentname.getText();
        course = combocourse.getSelectedItem().toString();
        branch = combobranch.getSelectedItem().toString();
        year = comboyear.getSelectedItem().toString();
        semester = combosemester.getSelectedItem().toString();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set student_name = ? , course = ? , branch = ? , year = ? , semester = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1 , student_name);
            pst.setString(2 , course);
            pst.setString(3 , branch);
            pst.setString(4 , year);
            pst.setString(5 , semester);
            pst.setInt(6 , student_id);

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

    // delete student details --->
    public boolean delete(){
        boolean isdelete = false;
        student_id = Integer.parseInt(txt_studentid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql ="delete from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , student_id);

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
        DefaultTableModel model = (DefaultTableModel)tdl_studentdetails.getModel();
        model.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combobranch = new javax.swing.JComboBox<>();
        combocourse = new javax.swing.JComboBox<>();
        comboyear = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        combosemester = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdl_studentdetails = new rojeru_san.complementos.RSTableMetro();
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

        txt_studentname.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_studentname.setPlaceholder("Enter Student Name");
        txt_studentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentnameFocusLost(evt);
            }
        });
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 320, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Student Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 220, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Moleskine_26px.png")); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 70));

        txt_studentid.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
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
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 320, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Student Id");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 220, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Contact_26px.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select Course");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 220, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Collaborator_Male_26px.png")); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 70, 70));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Branch");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 220, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Unit_26px.png")); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 70, 70));

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

        combobranch.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        combobranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CSE", "EE", "ETC", "MACHANICAL", "CIVIL", "AGRICULTURE" }));
        combobranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobranchActionPerformed(evt);
            }
        });
        jPanel1.add(combobranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 320, 30));

        combocourse.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        combocourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.TECH", "M.TECH", "DIPLOMA" }));
        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        jPanel1.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 320, 30));

        comboyear.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        comboyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th" }));
        comboyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboyearActionPerformed(evt);
            }
        });
        jPanel1.add(comboyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 320, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select year");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 220, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Moleskine_26px.png")); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 70, 70));

        combosemester.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        combosemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
        combosemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosemesterActionPerformed(evt);
            }
        });
        jPanel1.add(combosemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 320, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Select Semester");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 220, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Unit_26px.png")); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 70, 70));

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

        tdl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Course", "Branch", "year", "semester"
            }
        ));
        tdl_studentdetails.setColorBackgoundHead(new java.awt.Color(102, 255, 102));
        tdl_studentdetails.setColorBordeFilas(new java.awt.Color(255, 255, 51));
        tdl_studentdetails.setColorBordeHead(new java.awt.Color(255, 51, 51));
        tdl_studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tdl_studentdetails.setColorFilasForeground1(new java.awt.Color(0, 255, 255));
        tdl_studentdetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tdl_studentdetails.setColorSelBackgound(new java.awt.Color(255, 0, 255));
        tdl_studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tdl_studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tdl_studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tdl_studentdetails.setFuenteHead(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        tdl_studentdetails.setRowHeight(25);
        tdl_studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdl_studentdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdl_studentdetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 870, 300));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Student_Male_100px.png")); // NOI18N
        jLabel2.setText("  manage Students");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 320, 100));

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

    private void txt_studentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidFocusLost

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updatestudent() == true){
            JOptionPane.showMessageDialog(this , "student updated");
            cleartable();
            setStudentDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "student update failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocourseActionPerformed

    private void combobranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobranchActionPerformed

    private void comboyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboyearActionPerformed

    private void combosemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combosemesterActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (delete() == true){
            JOptionPane.showMessageDialog(this , "student deleted");
            cleartable();
            setStudentDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "student delation failed");
        }
    }

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (addstudent() == true){
            JOptionPane.showMessageDialog(this , "student added");
            cleartable();
            setStudentDetailsToTable();
        }
        else {
            JOptionPane.showMessageDialog(this , "student addition failed");
        }
    }

    private void tdl_studentdetailsMouseClicked(java.awt.event.MouseEvent evt) {
        int rowno = tdl_studentdetails.getSelectedRow();
        TableModel model = tdl_studentdetails.getModel();

        txt_studentid.setText(model.getValueAt(rowno , 0).toString());
        txt_studentname.setText(model.getValueAt(rowno , 1).toString());
        combocourse.setSelectedItem(model.getValueAt(rowno , 2).toString());
        combobranch.setSelectedItem(model.getValueAt(rowno , 3).toString());
        comboyear.setSelectedItem(model.getValueAt(rowno,4).toString());
        combosemester.setSelectedItem(model.getValueAt(rowno,5).toString());

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobranch;
    private javax.swing.JComboBox<String> combocourse;
    private javax.swing.JComboBox<String> combosemester;
    private javax.swing.JComboBox<String> comboyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private rojeru_san.complementos.RSTableMetro tdl_studentdetails;
    private app.bolivia.swing.JCTextField txt_studentid;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
