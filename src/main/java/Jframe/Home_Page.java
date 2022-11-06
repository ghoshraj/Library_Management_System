
package Jframe;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;


public class Home_Page extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(0 , 0 , 0);
    Color mouseExitColor = new Color(51 , 51 , 51);

    DefaultTableModel model;
    public Home_Page() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        SetDataToCards();
    }

    //set the student details into the table...
    public void setStudentDetailsToTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "raj@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()){
                int student_id = rs.getInt("student_id");
                String student_name = rs.getString("student_name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                String year = rs.getString("year");
                String semester = rs.getString("semester");

                Object[] obj  = {student_id,student_name,course,branch,year,semester};
                model = (DefaultTableModel)tdlstudentdetails.getModel();
                model.addRow(obj);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
                model = (DefaultTableModel)tblbookdetails.getModel();
                model.addRow(obj);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SetDataToCards(){
        Statement st = null;
        ResultSet rs = null;

        long l = System.currentTimeMillis();
        Date todaydate = new Date(l);

        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lbl_noofbooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from student_details");
            rs.last();
            lbl_noofstudent.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details where status = '"+"pending"+"'");
            rs.last();
            lbl_noofissuebooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details where due_date < '"+todaydate+"' and status = '"+"pending"+"'");
            rs.last();
            lbl_noofdefaultlist.setText(Integer.toString(rs.getRow()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showPieChart(){

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select book_name , count(*) as issue_count from issue_book_details group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                barDataset.setValue( rs.getString("book_name") , new Integer(rs.getInt("issue_count")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Library Details",barDataset, false,true,false);//explain

        PiePlot piePlot =(PiePlot) piechart.getPlot();

//        //changing pie chart blocks colors
//        piePlot.setSectionPaint("JAVA", new Color(255,255,102));
//        piePlot.setSectionPaint("C++", new Color(102,255,102));
//        piePlot.setSectionPaint("PHP", new Color(255,102,153));
//        piePlot.setSectionPaint("Python", new Color(0,204,204));


        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelpiechart.removeAll();
        panelpiechart.add(barChartPanel, BorderLayout.CENTER);
        panelpiechart.validate();
       }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lbl_noofbooks = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbl_noofstudent = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbl_noofissuebooks = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbl_noofdefaultlist = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdlstudentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel28 = new javax.swing.JLabel();
        panelpiechart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_menu_48px_1.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 5, 40));

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\male_user_50px.png")); // NOI18N
        jLabel2.setText("Welcome Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 240, 60));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 310, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 40, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 60));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Library_26px_1.png")); // NOI18N
        jLabel5.setText("      LMS Dashboard");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 190, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 330, 50));

        jPanel5.setBackground(new java.awt.Color(0, 0, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Exit_26px.png")); // NOI18N
        jLabel6.setText("logout");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel12.setBackground(new java.awt.Color(255, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\home_24px.png")); // NOI18N
        jLabel14.setText("View Issue Book");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 50));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 330, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Features");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 180, 30));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\home_24px.png")); // NOI18N
        jLabel8.setText("       Home Page");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 330, 50));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Book_26px.png")); // NOI18N
        jLabel9.setText("Manage Book");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 280, 50));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Read_Online_26px.png")); // NOI18N
        jLabel10.setText("Manage Student");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 280, 50));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Sell_26px.png")); // NOI18N
        jLabel11.setText("Issue Book");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 330, 50));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Return_Purchase_26px.png")); // NOI18N
        jLabel12.setText("return Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 330, 50));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_View_Details_26px.png")); // NOI18N
        jLabel13.setText("View Records");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 330, 50));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Books_26px.png")); // NOI18N
        jLabel15.setText("View Issue Book");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\home_24px.png")); // NOI18N
        jLabel16.setText("View Issue Book");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 50));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 330, 50));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Conference_26px.png")); // NOI18N
        jLabel17.setText("Default List");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel16.setBackground(new java.awt.Color(255, 102, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\home_24px.png")); // NOI18N
        jLabel18.setText("View Issue Book");
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 50));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 330, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 850));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofbooks.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_noofbooks.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Book_Shelf_50px.png")); // NOI18N
        lbl_noofbooks.setText("  10");
        jPanel18.add(lbl_noofbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 60));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 100));

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel20.setText("Student Details");
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 250, 20));

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofstudent.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_noofstudent.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_People_50px.png")); // NOI18N
        lbl_noofstudent.setText("  10");
        jPanel19.add(lbl_noofstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 60));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 220, 100));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel22.setText("Number Of Student");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 210, 20));

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofissuebooks.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_noofissuebooks.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_Sell_50px.png")); // NOI18N
        lbl_noofissuebooks.setText("  10");
        jPanel20.add(lbl_noofissuebooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, 60));

        jPanel17.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 220, 100));

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel24.setText("Issue Book");
        jPanel17.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 220, 20));

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(51, 51, 255)));
        jPanel21.setForeground(new java.awt.Color(51, 51, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofdefaultlist.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_noofdefaultlist.setIcon(new javax.swing.ImageIcon("D:\\webdev\\adminIcons\\adminIcons\\icons8_List_of_Thumbnails_50px.png")); // NOI18N
        lbl_noofdefaultlist.setText("  10");
        jPanel21.add(lbl_noofdefaultlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, 60));

        jPanel17.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 220, 100));

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel26.setText("Default List");
        jPanel17.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 170, 20));

        tdlstudentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch", "year", "semester"
            }
        ));
        tdlstudentdetails.setColorBackgoundHead(new java.awt.Color(102, 255, 102));
        tdlstudentdetails.setColorBordeFilas(new java.awt.Color(255, 255, 51));
        tdlstudentdetails.setColorBordeHead(new java.awt.Color(255, 51, 51));
        tdlstudentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tdlstudentdetails.setColorFilasForeground1(new java.awt.Color(0, 255, 255));
        tdlstudentdetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tdlstudentdetails.setColorSelBackgound(new java.awt.Color(255, 0, 255));
        tdlstudentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tdlstudentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tdlstudentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tdlstudentdetails.setFuenteHead(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        tdlstudentdetails.setRowHeight(25);
        jScrollPane1.setViewportView(tdlstudentdetails);

        jPanel17.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 640, 230));

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel27.setText("Number Of Books");
        jPanel17.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 20));

        tblbookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tblbookdetails.setColorBackgoundHead(new java.awt.Color(102, 255, 102));
        tblbookdetails.setColorBordeFilas(new java.awt.Color(255, 255, 51));
        tblbookdetails.setColorBordeHead(new java.awt.Color(255, 51, 51));
        tblbookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblbookdetails.setColorFilasForeground1(new java.awt.Color(0, 255, 255));
        tblbookdetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tblbookdetails.setColorSelBackgound(new java.awt.Color(255, 0, 255));
        tblbookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tblbookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tblbookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tblbookdetails.setFuenteHead(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        tblbookdetails.setRowHeight(25);
        jScrollPane2.setViewportView(tblbookdetails);

        jPanel17.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 580, 230));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel28.setText("Book Details");
        jPanel17.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 250, 20));

        panelpiechart.setLayout(new java.awt.BorderLayout());
        jPanel17.add(panelpiechart, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 350, 440));

        getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1000, 850));

        setSize(new java.awt.Dimension(1283, 865));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {
    DefaultList list = new DefaultList();
    list.setVisible(true);
    dispose();
    }

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel15.setBackground(mouseEnterColor);
    }

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {
        jPanel13.setBackground(mouseExitColor);
    }

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {
        IssueBookDetails details = new IssueBookDetails();
        details.setVisible(true);
        dispose();
    }

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel13.setBackground(mouseEnterColor);
    }

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {
        jPanel13.setBackground(mouseExitColor);
    }

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {
        ViewAllRecord view = new ViewAllRecord();
        view.setVisible(true);
        dispose();
    }

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel11.setBackground(mouseEnterColor);
    }

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {
        jPanel11.setBackground(mouseExitColor);
    }

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {
        ReturnBook book = new ReturnBook();
        book.setVisible(true);
        dispose();

    }

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel10.setBackground(mouseEnterColor);
    }

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {
        jPanel10.setBackground(mouseExitColor);
    }

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel8.setBackground(mouseEnterColor);
    }

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {
       jPanel8.setBackground(mouseExitColor);
    }

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
        ManageStudent student = new ManageStudent();
        student.setVisible(true);
        dispose();
    }

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
        IssueBook issue = new IssueBook();
        issue.setVisible(true);
        dispose();
    }

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {
        jPanel9.setBackground(mouseEnterColor);
    }

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {
        jPanel8.setBackground(mouseExitColor);
    }

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {
        jPanel7.setBackground(mouseExitColor);
    }

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {
    jPanel7.setBackground(mouseEnterColor);
    }

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
        ManageBooks books = new ManageBooks();
        books.setVisible(true);
        dispose();
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

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
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_noofbooks;
    private javax.swing.JLabel lbl_noofdefaultlist;
    private javax.swing.JLabel lbl_noofissuebooks;
    private javax.swing.JLabel lbl_noofstudent;
    private javax.swing.JPanel panelpiechart;
    private rojeru_san.complementos.RSTableMetro tblbookdetails;
    private rojeru_san.complementos.RSTableMetro tdlstudentdetails;
    // End of variables declaration//GEN-END:variables
}
