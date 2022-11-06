
package Jframe;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class IssueBook extends javax.swing.JFrame {

    public IssueBook() {
        initComponents();
    }

    //fetch the book details from the database and display the book details---->
    public void getbookdetails(){
        int bookid = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1 , bookid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                lblbookid.setText(rs.getString("book_id"));
                lblbookname.setText(rs.getString("book_name"));
                lblauthor.setText(rs.getString("author"));
                lblquantity.setText(rs.getString("quantity"));
            }
            else {
                lblbookerror.setText("Invalid Book ID!!!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //fetch the student details from the database and display the student details---->
    public void getstudentdetails(){
        int studentid = Integer.parseInt(txt_studentid.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1 , studentid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                lblstudentid.setText(rs.getString("student_id"));
                lblstudentname.setText(rs.getString("student_name"));
                lblcourse.setText(rs.getString("course"));
                lblbranch1.setText(rs.getString("branch"));
                lblyear.setText(rs.getString("year"));
                lblsemester.setText(rs.getString("semester"));
            }
            else{
                lblstudenterror.setText("Invalid book ID !!!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //insert issue book details to database---->
    public boolean issueBook(){
        boolean isissued = false;

        int bookid = Integer.parseInt(txt_bookid.getText());
        int studentid = Integer.parseInt(txt_studentid.getText());
        String bookname = lblbookname.getText();
        String name = lblstudentname.getText();

        Date issuedate = dateissuedate.getDatoFecha();
        Date duedate = dateduedate.getDatoFecha();

        Long l1 = issuedate.getTime();
        Long l2 = duedate.getTime();

        java.sql.Date Issuedate = new java.sql.Date(l1);
        java.sql.Date Duedate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id , book_name , student_id , " +
                    "student_name , issue_date , due_date , status) values (? ,? , ? , ? , ? , ? , ? )";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1  ,bookid);
            pst.setString(2 , bookname);
            pst.setInt(3 , studentid);
            pst.setString(4 , name);
            pst.setDate(5 , Issuedate);
            pst.setDate(6 , Duedate);
            pst.setString(7 , "Pending");

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                isissued = true;
            }
            else {
                isissued = false;
            }
        }
        catch (Exception e){

        }
        return isissued;
    }

    //update book count------------>
    public void updatebookcount(){
        int bookid = Integer.parseInt(txt_bookid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1 , bookid);

            int rowcount = pst.executeUpdate();
            if (rowcount > 0){
                JOptionPane.showMessageDialog(this , "book count updated");
                int initialcount = Integer.parseInt(lblquantity.getText());
                lblquantity.setText(Integer.toString(initialcount - 1));
            }
            else {
                JOptionPane.showMessageDialog(this , "book count not updated");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //checking whether book already allocated or not ------->
    public boolean isalreadyissue(){
        boolean isalreadyissue = false;
        int bookid = Integer.parseInt(txt_bookid.getText());
        int studentid = Integer.parseInt(txt_studentid.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql ="select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , bookid);
            pst.setInt(2 , studentid);
            pst.setString(3 , "pending");

           ResultSet rs = pst.executeQuery();
           if (rs.next()){
               isalreadyissue = true;
           }
           else {
               isalreadyissue = false;
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isalreadyissue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblquantity = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblbookid = new javax.swing.JLabel();
        lblbookname = new javax.swing.JLabel();
        lblauthor = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblbookerror = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblsemester = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblstudentid = new javax.swing.JLabel();
        lblstudentname = new javax.swing.JLabel();
        lblcourse = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblbranch1 = new javax.swing.JLabel();
        lblyear = new javax.swing.JLabel();
        lblstudenterror = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        dateduedate = new rojeru_san.componentes.RSDateChooser();
        dateissuedate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelmain.setBackground(new java.awt.Color(255, 255, 255));
        panelmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel12.setText("   Book Details");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 270, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 310, 5));

        lblquantity.setBackground(new java.awt.Color(255, 255, 102));
        lblquantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblquantity.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 230, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Book Id :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Book Name :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("Author :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        lblbookid.setBackground(new java.awt.Color(255, 255, 102));
        lblbookid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbookid.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblbookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 180, 30));

        lblbookname.setBackground(new java.awt.Color(255, 255, 102));
        lblbookname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbookname.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblbookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 210, 30));

        lblauthor.setBackground(new java.awt.Color(255, 255, 102));
        lblauthor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblauthor.setForeground(new java.awt.Color(51, 51, 255));
        jPanel3.add(lblauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 230, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setText("Quantity :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, 30));

        lblbookerror.setBackground(new java.awt.Color(255, 255, 102));
        lblbookerror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbookerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lblbookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 340, 30));

        panelmain.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 650));

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png")); // NOI18N
        jLabel3.setText("   Student Details");
        panelmain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 300, 120));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Books_52px_1.png")); // NOI18N
        jLabel1.setText("  Issue Book");
        panelmain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 180, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        panelmain.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 280, 5));

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

        panelmain.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 60, 40));

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 0, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\webdev\\AddNewBookIcons\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png")); // NOI18N
        jLabel2.setText("   Student Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 300, 120));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 310, 5));

        lblsemester.setBackground(new java.awt.Color(255, 255, 102));
        lblsemester.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblsemester.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblsemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 230, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Student Id :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Student Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Course :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Semester :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 110, 30));

        lblstudentid.setBackground(new java.awt.Color(255, 255, 102));
        lblstudentid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblstudentid.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 180, 30));

        lblstudentname.setBackground(new java.awt.Color(255, 255, 102));
        lblstudentname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblstudentname.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 210, 30));

        lblcourse.setBackground(new java.awt.Color(255, 255, 102));
        lblcourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblcourse.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 230, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 102));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 255));
        jLabel19.setText("Branch :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 102));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 255));
        jLabel20.setText("Year :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 30));

        lblbranch1.setBackground(new java.awt.Color(255, 255, 102));
        lblbranch1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbranch1.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblbranch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 230, 30));

        lblyear.setBackground(new java.awt.Color(255, 255, 102));
        lblyear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblyear.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 230, 30));

        lblstudenterror.setBackground(new java.awt.Color(255, 255, 102));
        lblstudenterror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblstudenterror.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lblstudenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 320, 30));

        panelmain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 400, 650));

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
        panelmain.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 290, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Enter Student Id :");
        panelmain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 330, 160, 30));

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
        panelmain.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 290, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Due Date :");
        panelmain.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 160, 40));

        dateduedate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateduedate.setPlaceholder("select due date");
        panelmain.add(dateduedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 290, 40));

        dateissuedate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateissuedate.setPlaceholder("select issue date");
        panelmain.add(dateissuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 290, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Enter Book Id :");
        panelmain.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 160, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Issue Date :");
        panelmain.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 160, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setText("Issue Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panelmain.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, 420, 60));

        getContentPane().add(panelmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 650));

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
        if(!txt_studentid.getText().equals("")) {
            getstudentdetails();
        }
    }

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {
        if(!txt_bookid.getText().equals("")) {
            getbookdetails();
        }
    }

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (lblquantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "this book is not available");
        }
        else {
            if (isalreadyissue() == false) {

                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "book issued successfully");
                    updatebookcount();
                } else {
                    JOptionPane.showMessageDialog(this, "can't issue Book");
                }
            } else {
                JOptionPane.showMessageDialog(this, "this student has already issue this book");
            }
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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser dateduedate;
    private rojeru_san.componentes.RSDateChooser dateissuedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lblbookerror;
    private javax.swing.JLabel lblbookid;
    private javax.swing.JLabel lblbookname;
    private javax.swing.JLabel lblbranch1;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JLabel lblsemester;
    private javax.swing.JLabel lblstudenterror;
    private javax.swing.JLabel lblstudentid;
    private javax.swing.JLabel lblstudentname;
    private javax.swing.JLabel lblyear;
    private javax.swing.JPanel panelmain;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
