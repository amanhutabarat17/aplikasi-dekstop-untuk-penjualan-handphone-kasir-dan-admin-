/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectakhir;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;
public class menuutama1 extends javax.swing.JFrame {

  
   Connection con;
   ResultSet rs;
   Statement stm;
   String sql;
   // int harga=0;
    String nama=null;
  //  int stok=0;
    
    ArrayList<Integer> harga=new ArrayList<>();
    ArrayList<Integer> stok=new ArrayList<>();
     ArrayList<String> ArraylistNama=new ArrayList<>();
     ArrayList<String> penyimpanann=new ArrayList<>();
     public static String logiinAs;
    public menuutama1() {
        initComponents();
         koneksi db=new koneksi();
        db.config();
        con=db.con;
        stm=db.stm;
        selectDB();
        //image();
      //  image2();
        displayImages();
        total();
        System.out.println(logiinAs);
    }
    public void total(){
        try{
          sql="SELECT SUM(stok) FROM datahp";
          rs=stm.executeQuery(sql);
        while(rs.next()){
            int stok=rs.getInt(1);
            lblsetok.setText(String.valueOf(stok));
        }   
        }catch(Exception e){
        JOptionPane.showConfirmDialog(this, e.getMessage());
    }
        try{
          sql="SELECT SUM(jumlahbeli) FROM penjualan";
          rs=stm.executeQuery(sql);
        while(rs.next()){
            int jum=rs.getInt(1);
           
          //  lblpemasukan.setText(String.valueOf(stok));
            lblpenjualan.setText(String.valueOf(jum));
        }   
        }catch(Exception e){
        JOptionPane.showConfirmDialog(this, e.getMessage());
    }
        try{
          sql="SELECT SUM(total) FROM penjualan";
          rs=stm.executeQuery(sql);
        while(rs.next()){
            int jum=rs.getInt(1);
           
          //  lblpemasukan.setText(String.valueOf(stok));
            lblpemasukan.setText(String.valueOf(jum));
        }   
        }catch(Exception e){
        JOptionPane.showConfirmDialog(this, e.getMessage());
    }
    }
    public void selectDB(){
        try{
     sql="SELECT namhp,penyimpanan,stok,harga from datahp";
     rs=stm.executeQuery(sql);
          while(rs.next()){
             ArraylistNama.add(rs.getString(1));
            penyimpanann.add(rs.getString(2));
            stok.add(rs.getInt(3));
            harga.add(rs.getInt(4));
          }
 }catch(Exception e){
       JOptionPane.showConfirmDialog(null, e.getMessage());
 
    }        
          JTextField[] textFields = {vivo1,vivo2,vivo3,vivo4,vivo5,vivo6,vivo7,vivo8,vivo9,vivo10,
                                      vivo11,vivo12,nama1,nama2,nama3,nama4,nama5,nama6,nama7,nama8,
                                      nama9,nama10,nama11,nama12};
JTextField[] textFields1 = {ramv9,ramv10,ramv11,ramv12,ramv1,ramv2,ramv3,ramv4,ramv5,ramv6,
                           ramv7,ramv8,ram7,ram8,ram9,ram10,ram11,ram12,ram35,ram36,ram37,
                           ram38,ram39,ram40};
JTextField[] textFields2={stokv9,stokv10,stokv11,stokv12,stokv1,stokv2,stokv3,
                           stokv4,stokv5,stokv6,stokv7,stokv8,txtstok4,txtstok5,
                           txtstokhp4,txtstoky18,txtstoky77,txtstoky35,txtstoky36,txtstoky37,
                           txtstoky38,txtstoky39,txtstoky40,txtstoky41};
  JTextField[] textFields3={hargav9,hargav10,hargav11,hargav12,hargav1,
                         hargav2,hargav3,hargav4,hargav5,hargav6,hargav7,hargav8,
                          txtharga5,txtharga7,txtharga8,txthargay18,txthargay77,txthargay35,txthargay36,
                          txthargay37,txthargay38,txthargay39,txthargay40,txthargay41};  
for (int i = 0; i < ArraylistNama.size(); i++) {
        String value = ArraylistNama.get(i);
 String value1 = penyimpanann.get(i);
       int value2 = stok.get(i);
       int value3=harga.get(i);
        if (i < textFields.length) {
            textFields[i].setText(value);
        }
        if(i<textFields1.length){
             textFields1[i].setText(value1);
        }
         if(i<textFields2.length){
           textFields2[i].setText(String.valueOf(value2));
        }
         if(i<textFields3.length){
             textFields3[i].setText(String.valueOf(value3));
         }
        
    }
    }
    public void performSearch() {
        
    // Assuming you have a method to perform the database search based on the keyword
    // and retrieve the relevant information for the search results
    // Replace this part with your actual database interaction logic

    // Convert the search keyword to lowercase for case-insensitive comparison
    String lowercaseKeyword = txtcari.getText().toLowerCase();

    // For demonstration purposes, let's assume you have a method like this
    ArrayList<String> searchResults = performActualDatabaseSearch(lowercaseKeyword);

    // Update the labels with the search results
    if (!searchResults.isEmpty()) {
       String namaCar=searchResults.get(0);
       String penyimpananCar=searchResults.get(1);
       String stokCar= searchResults.get(2);
       String hargaCar= searchResults.get(3);
       cari cr=new cari(namaCar,penyimpananCar,stokCar,hargaCar);
       cr.setLocationRelativeTo(null);
     //cr.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    cr.setVisible(true);
    
    } else {
       JOptionPane.showMessageDialog(this, "Tidak ditemukan");
    }
    

    // Display the search results using JOptionPane or your existing method
    
}

// Replace this method with your actual database interaction logic
private ArrayList<String> performActualDatabaseSearch(String lowercaseKeyword) {
    // Simulating a database search; replace this with your actual logic
    for (int i = 0; i < ArraylistNama.size(); i++) {
        if (ArraylistNama.get(i).toLowerCase().contains(lowercaseKeyword)) {
            // Found a match; return the relevant data
            ArrayList<String> result = new ArrayList<>();
            result.add(ArraylistNama.get(i));
            result.add(penyimpanann.get(i));
            result.add(String.valueOf(stok.get(i)));
            result.add(String.valueOf(harga.get(i)));
            return result;
        }
    }

    // No match found
    return new ArrayList<>();
}

    public void displayImages() {
    ArrayList<ImageIcon> images = new ArrayList<>();
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y22.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y35ril.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y02.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y16.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y75.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\y21.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\x80.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\x80pro.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\x80.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\v27ril.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\v25e.jpeg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo3.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo1.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo4.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo4.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo5.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo6.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo7.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo8.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo9.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo10.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo11.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo12.jpg"));
    images.add(new ImageIcon("C:\\Users\\HP\\Downloads\\oppo2.jpg"));

    JLabel[] labels = {y22, y35, y02, y16, y75, y21, y77, y79, y76, y80, y83, y82,y25,y36,y3,y18,y91,y26,y93,y94,y92,y95,y97,y96};


    for (int i = 0; i < images.size(); i++) {
        ImageIcon originalIcon = images.get(i);
        Image originalImage = originalIcon.getImage();
        
     int scaledWidth = labels[i].getWidth(); // Set your desired width
    int scaledHeight = labels[i].getHeight(); // Set your desired height
        // Scale the image
        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set the scaled icon to the JLabel
        labels[i].setIcon(scaledIcon);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        viv = new javax.swing.JPanel();
        viv1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        oppo = new javax.swing.JPanel();
        oppo1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ten = new javax.swing.JPanel();
        tentang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        mi4 = new javax.swing.JPanel();
        mi5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        mi = new javax.swing.JPanel();
        mi1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        penjualan = new javax.swing.JButton();
        pelanggan = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblpemasukan = new javax.swing.JLabel();
        lblmasuk = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        lblhpjual = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblpenjualan = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        lblstok = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblsetok = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        txtcari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        seriy = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        y22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        y35 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        y02 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        y16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        y75 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        y21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        vivo1 = new javax.swing.JTextField();
        ramv9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        stokv9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        hargav9 = new javax.swing.JTextField();
        btncekout = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        vivo2 = new javax.swing.JTextField();
        ramv10 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        stokv10 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        hargav10 = new javax.swing.JTextField();
        btncekout9 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        vivo3 = new javax.swing.JTextField();
        ramv11 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        stokv11 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        hargav11 = new javax.swing.JTextField();
        btncekout10 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        vivo4 = new javax.swing.JTextField();
        ramv12 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        stokv12 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        hargav12 = new javax.swing.JTextField();
        btncekout11 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        vivo5 = new javax.swing.JTextField();
        ramv1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        stokv1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        hargav1 = new javax.swing.JTextField();
        btncekout12 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        vivo6 = new javax.swing.JTextField();
        ramv2 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        stokv2 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        hargav2 = new javax.swing.JTextField();
        btncekout13 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        vivo7 = new javax.swing.JTextField();
        ramv3 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        stokv3 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        hargav3 = new javax.swing.JTextField();
        btncekout19 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        y76 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        y77 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        vivo8 = new javax.swing.JTextField();
        ramv4 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        stokv4 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        hargav4 = new javax.swing.JTextField();
        btncekout20 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        y79 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        y80 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        y82 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        y83 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        vivo9 = new javax.swing.JTextField();
        ramv5 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        stokv5 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        hargav5 = new javax.swing.JTextField();
        btncekout21 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        vivo10 = new javax.swing.JTextField();
        ramv6 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        stokv6 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        hargav6 = new javax.swing.JTextField();
        btncekout22 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        vivo11 = new javax.swing.JTextField();
        ramv7 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        stokv7 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        hargav7 = new javax.swing.JTextField();
        btncekout23 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        vivo12 = new javax.swing.JTextField();
        ramv8 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        stokv8 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        hargav8 = new javax.swing.JTextField();
        btncekout26 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        seriy1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        y25 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        y36 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        y3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        y18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        y91 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        y26 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        nama1 = new javax.swing.JTextField();
        ram7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtstok4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtharga5 = new javax.swing.JTextField();
        btncekout1 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        nama2 = new javax.swing.JTextField();
        ram8 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txtstok5 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtharga7 = new javax.swing.JTextField();
        btncekout14 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        nama3 = new javax.swing.JTextField();
        ram9 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtstokhp4 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtharga8 = new javax.swing.JTextField();
        btncekout15 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        nama4 = new javax.swing.JTextField();
        ram10 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        txtstoky18 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txthargay18 = new javax.swing.JTextField();
        btncekout16 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        nama5 = new javax.swing.JTextField();
        ram11 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtstoky77 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txthargay77 = new javax.swing.JTextField();
        btncekout17 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        nama6 = new javax.swing.JTextField();
        ram12 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtstoky35 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        txthargay35 = new javax.swing.JTextField();
        btncekout18 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        nama7 = new javax.swing.JTextField();
        ram35 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        txtstoky36 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        txthargay36 = new javax.swing.JTextField();
        btncekout38 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        y92 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        y93 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        nama8 = new javax.swing.JTextField();
        ram36 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        txtstoky37 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        txthargay37 = new javax.swing.JTextField();
        btncekout39 = new javax.swing.JButton();
        jPanel84 = new javax.swing.JPanel();
        y94 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        y95 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        y96 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        y97 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        nama9 = new javax.swing.JTextField();
        ram37 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txtstoky38 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        txthargay38 = new javax.swing.JTextField();
        btncekout40 = new javax.swing.JButton();
        jPanel89 = new javax.swing.JPanel();
        nama10 = new javax.swing.JTextField();
        ram38 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        txtstoky39 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        txthargay39 = new javax.swing.JTextField();
        btncekout41 = new javax.swing.JButton();
        jPanel90 = new javax.swing.JPanel();
        nama11 = new javax.swing.JTextField();
        ram39 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        txtstoky40 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        txthargay40 = new javax.swing.JTextField();
        btncekout42 = new javax.swing.JButton();
        jPanel91 = new javax.swing.JPanel();
        nama12 = new javax.swing.JTextField();
        ram40 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txtstoky41 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        txthargay41 = new javax.swing.JTextField();
        btncekout43 = new javax.swing.JButton();
        jPanel92 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 102));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("AMAN STORE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 187, -1));

        viv.setBackground(new java.awt.Color(0, 204, 51));
        viv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vivMouseClicked(evt);
            }
        });

        viv1.setBackground(new java.awt.Color(0, 204, 51));
        viv1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viv1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viv1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viv1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                viv1MouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel6.setText("VIVO");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout viv1Layout = new javax.swing.GroupLayout(viv1);
        viv1.setLayout(viv1Layout);
        viv1Layout.setHorizontalGroup(
            viv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viv1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viv1Layout.setVerticalGroup(
            viv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viv1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout vivLayout = new javax.swing.GroupLayout(viv);
        viv.setLayout(vivLayout);
        vivLayout.setHorizontalGroup(
            vivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viv1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vivLayout.setVerticalGroup(
            vivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vivLayout.createSequentialGroup()
                .addComponent(viv1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(viv, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 185, 276, -1));

        oppo.setBackground(new java.awt.Color(0, 204, 51));

        oppo1.setBackground(new java.awt.Color(0, 204, 51));
        oppo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oppo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oppo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oppo1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                oppo1MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel1.setText("OPPO");

        javax.swing.GroupLayout oppo1Layout = new javax.swing.GroupLayout(oppo1);
        oppo1.setLayout(oppo1Layout);
        oppo1Layout.setHorizontalGroup(
            oppo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oppo1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        oppo1Layout.setVerticalGroup(
            oppo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oppo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout oppoLayout = new javax.swing.GroupLayout(oppo);
        oppo.setLayout(oppoLayout);
        oppoLayout.setHorizontalGroup(
            oppoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oppo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        oppoLayout.setVerticalGroup(
            oppoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oppoLayout.createSequentialGroup()
                .addComponent(oppo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(oppo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 287, 276, -1));

        ten.setBackground(new java.awt.Color(0, 204, 51));

        tentang.setBackground(new java.awt.Color(0, 204, 51));
        tentang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tentangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tentangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tentangMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel11.setText("Tentang");

        javax.swing.GroupLayout tentangLayout = new javax.swing.GroupLayout(tentang);
        tentang.setLayout(tentangLayout);
        tentangLayout.setHorizontalGroup(
            tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tentangLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel11)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        tentangLayout.setVerticalGroup(
            tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tentangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tenLayout = new javax.swing.GroupLayout(ten);
        ten.setLayout(tenLayout);
        tenLayout.setHorizontalGroup(
            tenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tentang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tenLayout.setVerticalGroup(
            tenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tenLayout.createSequentialGroup()
                .addComponent(tentang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 386, -1, -1));

        mi4.setBackground(new java.awt.Color(0, 204, 51));

        mi5.setBackground(new java.awt.Color(0, 204, 51));
        mi5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi5MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel13.setText("Keluar");

        javax.swing.GroupLayout mi5Layout = new javax.swing.GroupLayout(mi5);
        mi5.setLayout(mi5Layout);
        mi5Layout.setHorizontalGroup(
            mi5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mi5Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mi5Layout.setVerticalGroup(
            mi5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mi5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mi4Layout = new javax.swing.GroupLayout(mi4);
        mi4.setLayout(mi4Layout);
        mi4Layout.setHorizontalGroup(
            mi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mi5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mi4Layout.setVerticalGroup(
            mi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mi4Layout.createSequentialGroup()
                .addComponent(mi5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(mi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 502, 276, -1));

        mi.setBackground(new java.awt.Color(0, 204, 51));

        mi1.setBackground(new java.awt.Color(0, 204, 51));
        mi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mi1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mi1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mi1MouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel8.setText("Home");

        javax.swing.GroupLayout mi1Layout = new javax.swing.GroupLayout(mi1);
        mi1.setLayout(mi1Layout);
        mi1Layout.setHorizontalGroup(
            mi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mi1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mi1Layout.setVerticalGroup(
            mi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout miLayout = new javax.swing.GroupLayout(mi);
        mi.setLayout(miLayout);
        miLayout.setHorizontalGroup(
            miLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        miLayout.setVerticalGroup(
            miLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miLayout.createSequentialGroup()
                .addComponent(mi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 93, 276, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1148, 816));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel41.setPreferredSize(new java.awt.Dimension(1148, 816));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/2849824_store_shopping_market_buy_shop_icon.png"))); // NOI18N
        penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penjualanActionPerformed(evt);
            }
        });
        jPanel41.add(penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 29, 0, 9));

        pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelangganActionPerformed(evt);
            }
        });
        jPanel41.add(pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 29, 0, -1));

        jPanel28.setBackground(new java.awt.Color(51, 102, 255));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Pemasukan");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setText("Jumlah ");

        lblpemasukan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addComponent(lblmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lblpemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(lblpemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(lblmasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 255, 242, -1));

        jPanel33.setBackground(new java.awt.Color(0, 204, 153));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel20.setText("Jumlah ");

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel21.setText("HP Terjual");

        lblpenjualan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(lblhpjual, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblpenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblpenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(lblhpjual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 255, -1, -1));

        jPanel36.setBackground(new java.awt.Color(255, 255, 51));

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel23.setText("Stok");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel24.setText("HP ");

        lblsetok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(lblstok, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsetok, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblsetok, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(lblstok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 255, -1, -1));

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jPanel41.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 564, -1, -1));

        jPanel42.setBackground(new java.awt.Color(204, 204, 204));

        txtcari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcari.setBorder(new javax.swing.border.MatteBorder(null));

        jButton1.setText("Cari product");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel22.setText("Selamat Datang, Kasir");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 57, 880, -1));

        jPanel1.add(jPanel41, "card5");

        seriy.setBackground(new java.awt.Color(255, 255, 255));
        seriy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        seriy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.MatteBorder(null));

        y22.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        seriy.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 106, -1, 116));

        y35.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y35, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        seriy.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 250, 144, -1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y02, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        seriy.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 380, 144, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        seriy.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 515, 144, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y75, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y75, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y21, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        seriy.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo1.setEditable(false);
        vivo1.setBackground(new java.awt.Color(0, 102, 102));
        vivo1.setForeground(new java.awt.Color(0, 255, 255));
        vivo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo1ActionPerformed(evt);
            }
        });

        ramv9.setEditable(false);
        ramv9.setBackground(new java.awt.Color(0, 102, 102));
        ramv9.setForeground(new java.awt.Color(0, 255, 255));
        ramv9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv9ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Stok :");

        stokv9.setEditable(false);
        stokv9.setBackground(new java.awt.Color(0, 102, 102));
        stokv9.setForeground(new java.awt.Color(0, 255, 255));
        stokv9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv9ActionPerformed(evt);
            }
        });

        jLabel15.setText("Rp.");

        hargav9.setEditable(false);
        hargav9.setBackground(new java.awt.Color(0, 102, 102));
        hargav9.setForeground(new java.awt.Color(0, 255, 255));
        hargav9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout.setText("check out");
        btncekout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(ramv9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv9))
                    .addComponent(vivo1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(vivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(hargav9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        seriy.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 106, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo2.setEditable(false);
        vivo2.setBackground(new java.awt.Color(0, 102, 102));
        vivo2.setForeground(new java.awt.Color(0, 255, 255));
        vivo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo2ActionPerformed(evt);
            }
        });

        ramv10.setEditable(false);
        ramv10.setBackground(new java.awt.Color(0, 102, 102));
        ramv10.setForeground(new java.awt.Color(0, 255, 255));
        ramv10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv10ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("Stok :");

        stokv10.setEditable(false);
        stokv10.setBackground(new java.awt.Color(0, 102, 102));
        stokv10.setForeground(new java.awt.Color(0, 255, 255));
        stokv10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv10ActionPerformed(evt);
            }
        });

        jLabel62.setText("Rp.");

        hargav10.setEditable(false);
        hargav10.setBackground(new java.awt.Color(0, 102, 102));
        hargav10.setForeground(new java.awt.Color(0, 255, 255));
        hargav10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout9.setText("check out");
        btncekout9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(ramv10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv10))
                    .addComponent(vivo2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(vivo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(hargav10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        seriy.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 250, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo3.setEditable(false);
        vivo3.setBackground(new java.awt.Color(0, 102, 102));
        vivo3.setForeground(new java.awt.Color(0, 255, 255));
        vivo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo3ActionPerformed(evt);
            }
        });

        ramv11.setEditable(false);
        ramv11.setBackground(new java.awt.Color(0, 102, 102));
        ramv11.setForeground(new java.awt.Color(0, 255, 255));
        ramv11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv11ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("Stok :");

        stokv11.setEditable(false);
        stokv11.setBackground(new java.awt.Color(0, 102, 102));
        stokv11.setForeground(new java.awt.Color(0, 255, 255));
        stokv11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv11ActionPerformed(evt);
            }
        });

        jLabel64.setText("Rp.");

        hargav11.setEditable(false);
        hargav11.setBackground(new java.awt.Color(0, 102, 102));
        hargav11.setForeground(new java.awt.Color(0, 255, 255));
        hargav11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout10.setText("check out");
        btncekout10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addComponent(ramv11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv11))
                    .addComponent(vivo3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(vivo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(hargav11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        seriy.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 380, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo4.setEditable(false);
        vivo4.setBackground(new java.awt.Color(0, 102, 102));
        vivo4.setForeground(new java.awt.Color(0, 255, 255));
        vivo4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo4ActionPerformed(evt);
            }
        });

        ramv12.setEditable(false);
        ramv12.setBackground(new java.awt.Color(0, 102, 102));
        ramv12.setForeground(new java.awt.Color(0, 255, 255));
        ramv12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv12ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setText("Stok :");

        stokv12.setEditable(false);
        stokv12.setBackground(new java.awt.Color(0, 102, 102));
        stokv12.setForeground(new java.awt.Color(0, 255, 255));
        stokv12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv12ActionPerformed(evt);
            }
        });

        jLabel66.setText("Rp.");

        hargav12.setEditable(false);
        hargav12.setBackground(new java.awt.Color(0, 102, 102));
        hargav12.setForeground(new java.awt.Color(0, 255, 255));
        hargav12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout11.setText("check out");
        btncekout11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(ramv12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv12))
                    .addComponent(vivo4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(vivo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(hargav12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        seriy.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 523, 171, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo5.setEditable(false);
        vivo5.setBackground(new java.awt.Color(0, 102, 102));
        vivo5.setForeground(new java.awt.Color(0, 255, 255));
        vivo5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo5ActionPerformed(evt);
            }
        });

        ramv1.setEditable(false);
        ramv1.setBackground(new java.awt.Color(0, 102, 102));
        ramv1.setForeground(new java.awt.Color(0, 255, 255));
        ramv1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv1ActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setText("Stok :");

        stokv1.setEditable(false);
        stokv1.setBackground(new java.awt.Color(0, 102, 102));
        stokv1.setForeground(new java.awt.Color(0, 255, 255));
        stokv1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv1ActionPerformed(evt);
            }
        });

        jLabel68.setText("Rp.");

        hargav1.setEditable(false);
        hargav1.setBackground(new java.awt.Color(0, 102, 102));
        hargav1.setForeground(new java.awt.Color(0, 255, 255));
        hargav1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout12.setText("check out");
        btncekout12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hargav1))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(ramv1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stokv1))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btncekout12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(vivo5))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(vivo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(hargav1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncekout12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        seriy.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, 116));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo6.setEditable(false);
        vivo6.setBackground(new java.awt.Color(0, 102, 102));
        vivo6.setForeground(new java.awt.Color(0, 255, 255));
        vivo6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo6ActionPerformed(evt);
            }
        });

        ramv2.setEditable(false);
        ramv2.setBackground(new java.awt.Color(0, 102, 102));
        ramv2.setForeground(new java.awt.Color(0, 255, 255));
        ramv2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv2ActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setText("Stok :");

        stokv2.setEditable(false);
        stokv2.setBackground(new java.awt.Color(0, 102, 102));
        stokv2.setForeground(new java.awt.Color(0, 255, 255));
        stokv2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv2ActionPerformed(evt);
            }
        });

        jLabel70.setText("Rp.");

        hargav2.setEditable(false);
        hargav2.setBackground(new java.awt.Color(0, 102, 102));
        hargav2.setForeground(new java.awt.Color(0, 255, 255));
        hargav2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout13.setText("check out");
        btncekout13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(ramv2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv2))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav2))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(vivo6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(vivo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(hargav2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        seriy.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo7.setEditable(false);
        vivo7.setBackground(new java.awt.Color(0, 102, 102));
        vivo7.setForeground(new java.awt.Color(0, 255, 255));
        vivo7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo7ActionPerformed(evt);
            }
        });

        ramv3.setEditable(false);
        ramv3.setBackground(new java.awt.Color(0, 102, 102));
        ramv3.setForeground(new java.awt.Color(0, 255, 255));
        ramv3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv3ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel81.setText("Stok :");

        stokv3.setEditable(false);
        stokv3.setBackground(new java.awt.Color(0, 102, 102));
        stokv3.setForeground(new java.awt.Color(0, 255, 255));
        stokv3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv3ActionPerformed(evt);
            }
        });

        jLabel82.setText("Rp.");

        hargav3.setEditable(false);
        hargav3.setBackground(new java.awt.Color(0, 102, 102));
        hargav3.setForeground(new java.awt.Color(0, 255, 255));
        hargav3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout19.setText("check out");
        btncekout19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(ramv3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokv3))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargav3))
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(vivo7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(vivo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(hargav3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        seriy.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, -1, -1));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y76, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        seriy.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, 116));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y77, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo8.setEditable(false);
        vivo8.setBackground(new java.awt.Color(0, 102, 102));
        vivo8.setForeground(new java.awt.Color(0, 255, 255));
        vivo8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo8ActionPerformed(evt);
            }
        });

        ramv4.setEditable(false);
        ramv4.setBackground(new java.awt.Color(0, 102, 102));
        ramv4.setForeground(new java.awt.Color(0, 255, 255));
        ramv4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv4ActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel83.setText("Stok :");

        stokv4.setEditable(false);
        stokv4.setBackground(new java.awt.Color(0, 102, 102));
        stokv4.setForeground(new java.awt.Color(0, 255, 255));
        stokv4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv4ActionPerformed(evt);
            }
        });

        jLabel84.setText("Rp.");

        hargav4.setEditable(false);
        hargav4.setBackground(new java.awt.Color(0, 102, 102));
        hargav4.setForeground(new java.awt.Color(0, 255, 255));
        hargav4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout20.setText("check out");
        btncekout20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(ramv4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel83)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stokv4))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hargav4))
                            .addComponent(vivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btncekout20, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(vivo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(hargav4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btncekout20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        seriy.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, -1, -1));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y79, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        seriy.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y80, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        seriy.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, -1, -1));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y82, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y82, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 145, -1));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y83, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y83, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, -1, -1));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo9.setEditable(false);
        vivo9.setBackground(new java.awt.Color(0, 102, 102));
        vivo9.setForeground(new java.awt.Color(0, 255, 255));
        vivo9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo9ActionPerformed(evt);
            }
        });

        ramv5.setEditable(false);
        ramv5.setBackground(new java.awt.Color(0, 102, 102));
        ramv5.setForeground(new java.awt.Color(0, 255, 255));
        ramv5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv5ActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel85.setText("Stok :");

        stokv5.setEditable(false);
        stokv5.setBackground(new java.awt.Color(0, 102, 102));
        stokv5.setForeground(new java.awt.Color(0, 255, 255));
        stokv5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv5ActionPerformed(evt);
            }
        });

        jLabel86.setText("Rp.");

        hargav5.setEditable(false);
        hargav5.setBackground(new java.awt.Color(0, 102, 102));
        hargav5.setForeground(new java.awt.Color(0, 255, 255));
        hargav5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout21.setText("check out");
        btncekout21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addComponent(ramv5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stokv5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargav5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btncekout21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(vivo9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(vivo9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(hargav5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, -1, -1));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo10.setEditable(false);
        vivo10.setBackground(new java.awt.Color(0, 102, 102));
        vivo10.setForeground(new java.awt.Color(0, 255, 255));
        vivo10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo10ActionPerformed(evt);
            }
        });

        ramv6.setEditable(false);
        ramv6.setBackground(new java.awt.Color(0, 102, 102));
        ramv6.setForeground(new java.awt.Color(0, 255, 255));
        ramv6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv6ActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel87.setText("Stok :");

        stokv6.setEditable(false);
        stokv6.setBackground(new java.awt.Color(0, 102, 102));
        stokv6.setForeground(new java.awt.Color(0, 255, 255));
        stokv6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv6ActionPerformed(evt);
            }
        });

        jLabel88.setText("Rp.");

        hargav6.setEditable(false);
        hargav6.setBackground(new java.awt.Color(0, 102, 102));
        hargav6.setForeground(new java.awt.Color(0, 255, 255));
        hargav6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout22.setText("check out");
        btncekout22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addComponent(ramv6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stokv6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargav6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btncekout22, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(vivo10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(vivo10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(hargav6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, -1, -1));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo11.setEditable(false);
        vivo11.setBackground(new java.awt.Color(0, 102, 102));
        vivo11.setForeground(new java.awt.Color(0, 255, 255));
        vivo11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo11ActionPerformed(evt);
            }
        });

        ramv7.setEditable(false);
        ramv7.setBackground(new java.awt.Color(0, 102, 102));
        ramv7.setForeground(new java.awt.Color(0, 255, 255));
        ramv7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv7ActionPerformed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel89.setText("Stok :");

        stokv7.setEditable(false);
        stokv7.setBackground(new java.awt.Color(0, 102, 102));
        stokv7.setForeground(new java.awt.Color(0, 255, 255));
        stokv7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv7ActionPerformed(evt);
            }
        });

        jLabel90.setText("Rp.");

        hargav7.setEditable(false);
        hargav7.setBackground(new java.awt.Color(0, 102, 102));
        hargav7.setForeground(new java.awt.Color(0, 255, 255));
        hargav7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout23.setText("check out");
        btncekout23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addComponent(ramv7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stokv7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargav7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btncekout23, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(vivo11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(vivo11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(hargav7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, -1, -1));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vivo12.setEditable(false);
        vivo12.setBackground(new java.awt.Color(0, 102, 102));
        vivo12.setForeground(new java.awt.Color(0, 255, 255));
        vivo12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vivo12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vivo12ActionPerformed(evt);
            }
        });

        ramv8.setEditable(false);
        ramv8.setBackground(new java.awt.Color(0, 102, 102));
        ramv8.setForeground(new java.awt.Color(0, 255, 255));
        ramv8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ramv8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramv8ActionPerformed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel95.setText("Stok :");

        stokv8.setEditable(false);
        stokv8.setBackground(new java.awt.Color(0, 102, 102));
        stokv8.setForeground(new java.awt.Color(0, 255, 255));
        stokv8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stokv8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokv8ActionPerformed(evt);
            }
        });

        jLabel96.setText("Rp.");

        hargav8.setEditable(false);
        hargav8.setBackground(new java.awt.Color(0, 102, 102));
        hargav8.setForeground(new java.awt.Color(0, 255, 255));
        hargav8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout26.setText("check out");
        btncekout26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(ramv8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stokv8))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hargav8))
                            .addComponent(vivo12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btncekout26, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(vivo12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramv8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokv8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(hargav8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncekout26, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        seriy.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 140, 116));

        jPanel50.setBackground(new java.awt.Color(0, 102, 102));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 255));
        jLabel12.setText("VIVO");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seriy.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1107, -1));

        jPanel1.add(seriy, "card2");

        seriy1.setBackground(new java.awt.Color(255, 255, 255));
        seriy1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y25, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        seriy1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 106, -1, -1));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y36, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        seriy1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 250, 142, -1));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        seriy1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 380, 142, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        seriy1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 515, 142, -1));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y91, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y91, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 106, -1, -1));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y26, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        seriy1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama1.setEditable(false);
        nama1.setBackground(new java.awt.Color(0, 102, 102));
        nama1.setForeground(new java.awt.Color(0, 255, 255));
        nama1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama1ActionPerformed(evt);
            }
        });

        ram7.setEditable(false);
        ram7.setBackground(new java.awt.Color(0, 102, 102));
        ram7.setForeground(new java.awt.Color(0, 255, 255));
        ram7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram7ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Stok :");

        txtstok4.setEditable(false);
        txtstok4.setBackground(new java.awt.Color(0, 102, 102));
        txtstok4.setForeground(new java.awt.Color(0, 255, 255));
        txtstok4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstok4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstok4ActionPerformed(evt);
            }
        });

        jLabel18.setText("Rp.");

        txtharga5.setEditable(false);
        txtharga5.setBackground(new java.awt.Color(0, 102, 102));
        txtharga5.setForeground(new java.awt.Color(0, 255, 255));
        txtharga5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout1.setText("check out");
        btncekout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtharga5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(ram7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstok4))
                    .addComponent(nama1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstok4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtharga5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        seriy1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 106, -1, -1));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama2.setEditable(false);
        nama2.setBackground(new java.awt.Color(0, 102, 102));
        nama2.setForeground(new java.awt.Color(0, 255, 255));
        nama2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama2ActionPerformed(evt);
            }
        });

        ram8.setEditable(false);
        ram8.setBackground(new java.awt.Color(0, 102, 102));
        ram8.setForeground(new java.awt.Color(0, 255, 255));
        ram8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram8ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setText("Stok :");

        txtstok5.setEditable(false);
        txtstok5.setBackground(new java.awt.Color(0, 102, 102));
        txtstok5.setForeground(new java.awt.Color(0, 255, 255));
        txtstok5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstok5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstok5ActionPerformed(evt);
            }
        });

        jLabel72.setText("Rp.");

        txtharga7.setEditable(false);
        txtharga7.setBackground(new java.awt.Color(0, 102, 102));
        txtharga7.setForeground(new java.awt.Color(0, 255, 255));
        txtharga7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout14.setText("check out");
        btncekout14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtharga7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                        .addComponent(ram8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstok5))
                    .addComponent(nama2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstok5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtharga7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        seriy1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 250, -1, -1));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama3.setEditable(false);
        nama3.setBackground(new java.awt.Color(0, 102, 102));
        nama3.setForeground(new java.awt.Color(0, 255, 255));
        nama3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama3ActionPerformed(evt);
            }
        });

        ram9.setEditable(false);
        ram9.setBackground(new java.awt.Color(0, 102, 102));
        ram9.setForeground(new java.awt.Color(0, 255, 255));
        ram9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram9ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("Stok :");

        txtstokhp4.setEditable(false);
        txtstokhp4.setBackground(new java.awt.Color(0, 102, 102));
        txtstokhp4.setForeground(new java.awt.Color(0, 255, 255));
        txtstokhp4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstokhp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokhp4ActionPerformed(evt);
            }
        });

        jLabel74.setText("Rp.");

        txtharga8.setEditable(false);
        txtharga8.setBackground(new java.awt.Color(0, 102, 102));
        txtharga8.setForeground(new java.awt.Color(0, 255, 255));
        txtharga8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout15.setText("check out");
        btncekout15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtharga8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                        .addComponent(ram9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstokhp4))
                    .addComponent(nama3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(nama3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstokhp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(txtharga8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        seriy1.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 380, -1, -1));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama4.setEditable(false);
        nama4.setBackground(new java.awt.Color(0, 102, 102));
        nama4.setForeground(new java.awt.Color(0, 255, 255));
        nama4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama4ActionPerformed(evt);
            }
        });

        ram10.setEditable(false);
        ram10.setBackground(new java.awt.Color(0, 102, 102));
        ram10.setForeground(new java.awt.Color(0, 255, 255));
        ram10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram10ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel75.setText("Stok :");

        txtstoky18.setEditable(false);
        txtstoky18.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky18.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky18ActionPerformed(evt);
            }
        });

        jLabel76.setText("Rp.");

        txthargay18.setEditable(false);
        txthargay18.setBackground(new java.awt.Color(0, 102, 102));
        txthargay18.setForeground(new java.awt.Color(0, 255, 255));
        txthargay18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout16.setText("check out");
        btncekout16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                        .addComponent(ram10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky18))
                    .addComponent(nama4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncekout16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(nama4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txthargay18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        seriy1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 523, 171, -1));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama5.setEditable(false);
        nama5.setBackground(new java.awt.Color(0, 102, 102));
        nama5.setForeground(new java.awt.Color(0, 255, 255));
        nama5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama5ActionPerformed(evt);
            }
        });

        ram11.setEditable(false);
        ram11.setBackground(new java.awt.Color(0, 102, 102));
        ram11.setForeground(new java.awt.Color(0, 255, 255));
        ram11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram11ActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel77.setText("Stok :");

        txtstoky77.setEditable(false);
        txtstoky77.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky77.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky77ActionPerformed(evt);
            }
        });

        jLabel78.setText("Rp.");

        txthargay77.setEditable(false);
        txthargay77.setBackground(new java.awt.Color(0, 102, 102));
        txthargay77.setForeground(new java.awt.Color(0, 255, 255));
        txthargay77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout17.setText("check out");
        btncekout17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txthargay77))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(ram11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtstoky77))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btncekout17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nama5))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(nama5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txthargay77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btncekout17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        seriy1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama6.setEditable(false);
        nama6.setBackground(new java.awt.Color(0, 102, 102));
        nama6.setForeground(new java.awt.Color(0, 255, 255));
        nama6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama6ActionPerformed(evt);
            }
        });

        ram12.setEditable(false);
        ram12.setBackground(new java.awt.Color(0, 102, 102));
        ram12.setForeground(new java.awt.Color(0, 255, 255));
        ram12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram12ActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel79.setText("Stok :");

        txtstoky35.setEditable(false);
        txtstoky35.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky35.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky35ActionPerformed(evt);
            }
        });

        jLabel80.setText("Rp.");

        txthargay35.setEditable(false);
        txthargay35.setBackground(new java.awt.Color(0, 102, 102));
        txthargay35.setForeground(new java.awt.Color(0, 255, 255));
        txthargay35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout18.setText("check out");
        btncekout18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(ram12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky35))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay35))
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout18, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(nama6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(txthargay35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout18, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        seriy1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, 110));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama7.setEditable(false);
        nama7.setBackground(new java.awt.Color(0, 102, 102));
        nama7.setForeground(new java.awt.Color(0, 255, 255));
        nama7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama7ActionPerformed(evt);
            }
        });

        ram35.setEditable(false);
        ram35.setBackground(new java.awt.Color(0, 102, 102));
        ram35.setForeground(new java.awt.Color(0, 255, 255));
        ram35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram35ActionPerformed(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel119.setText("Stok :");

        txtstoky36.setEditable(false);
        txtstoky36.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky36.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky36ActionPerformed(evt);
            }
        });

        jLabel120.setText("Rp.");

        txthargay36.setEditable(false);
        txthargay36.setBackground(new java.awt.Color(0, 102, 102));
        txthargay36.setForeground(new java.awt.Color(0, 255, 255));
        txthargay36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout38.setText("check out");
        btncekout38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(ram35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky36))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel120)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay36))
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel46Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout38, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(nama7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(txthargay36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout38, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        seriy1.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, 100));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y92, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        seriy1.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 106, -1, 110));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y93, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y93, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy1.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 140, -1));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama8.setEditable(false);
        nama8.setBackground(new java.awt.Color(0, 102, 102));
        nama8.setForeground(new java.awt.Color(0, 255, 255));
        nama8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama8ActionPerformed(evt);
            }
        });

        ram36.setEditable(false);
        ram36.setBackground(new java.awt.Color(0, 102, 102));
        ram36.setForeground(new java.awt.Color(0, 255, 255));
        ram36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram36ActionPerformed(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setText("Stok :");

        txtstoky37.setEditable(false);
        txtstoky37.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky37.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky37ActionPerformed(evt);
            }
        });

        jLabel122.setText("Rp.");

        txthargay37.setEditable(false);
        txthargay37.setBackground(new java.awt.Color(0, 102, 102));
        txthargay37.setForeground(new java.awt.Color(0, 255, 255));
        txthargay37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout39.setText("check out");
        btncekout39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addComponent(ram36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky37))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay37))
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel83Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout39, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(nama8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(txthargay37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout39, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy1.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 140, -1));

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y94, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y94, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        seriy1.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y95, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y95, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        seriy1.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, -1, -1));

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y96, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        seriy1.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 145, -1));

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y97, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(y97, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        seriy1.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama9.setEditable(false);
        nama9.setBackground(new java.awt.Color(0, 102, 102));
        nama9.setForeground(new java.awt.Color(0, 255, 255));
        nama9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama9ActionPerformed(evt);
            }
        });

        ram37.setEditable(false);
        ram37.setBackground(new java.awt.Color(0, 102, 102));
        ram37.setForeground(new java.awt.Color(0, 255, 255));
        ram37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram37ActionPerformed(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel123.setText("Stok :");

        txtstoky38.setEditable(false);
        txtstoky38.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky38.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky38ActionPerformed(evt);
            }
        });

        jLabel124.setText("Rp.");

        txthargay38.setEditable(false);
        txthargay38.setBackground(new java.awt.Color(0, 102, 102));
        txthargay38.setForeground(new java.awt.Color(0, 255, 255));
        txthargay38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout40.setText("check out");
        btncekout40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addComponent(ram37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky38))
                    .addGroup(jPanel88Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay38))
                    .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel88Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout40, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addComponent(nama9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(txthargay38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout40, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy1.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama10.setEditable(false);
        nama10.setBackground(new java.awt.Color(0, 102, 102));
        nama10.setForeground(new java.awt.Color(0, 255, 255));
        nama10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama10ActionPerformed(evt);
            }
        });

        ram38.setEditable(false);
        ram38.setBackground(new java.awt.Color(0, 102, 102));
        ram38.setForeground(new java.awt.Color(0, 255, 255));
        ram38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram38ActionPerformed(evt);
            }
        });

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel125.setText("Stok :");

        txtstoky39.setEditable(false);
        txtstoky39.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky39.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky39ActionPerformed(evt);
            }
        });

        jLabel126.setText("Rp.");

        txthargay39.setEditable(false);
        txthargay39.setBackground(new java.awt.Color(0, 102, 102));
        txthargay39.setForeground(new java.awt.Color(0, 255, 255));
        txthargay39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout41.setText("check out");
        btncekout41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addComponent(ram38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky39))
                    .addGroup(jPanel89Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay39))
                    .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel89Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout41, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addComponent(nama10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(txthargay39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout41, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy1.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, -1, -1));

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama11.setEditable(false);
        nama11.setBackground(new java.awt.Color(0, 102, 102));
        nama11.setForeground(new java.awt.Color(0, 255, 255));
        nama11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama11ActionPerformed(evt);
            }
        });

        ram39.setEditable(false);
        ram39.setBackground(new java.awt.Color(0, 102, 102));
        ram39.setForeground(new java.awt.Color(0, 255, 255));
        ram39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram39ActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel127.setText("Stok :");

        txtstoky40.setEditable(false);
        txtstoky40.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky40.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky40ActionPerformed(evt);
            }
        });

        jLabel128.setText("Rp.");

        txthargay40.setEditable(false);
        txthargay40.setBackground(new java.awt.Color(0, 102, 102));
        txthargay40.setForeground(new java.awt.Color(0, 255, 255));
        txthargay40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout42.setText("check out");
        btncekout42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addComponent(ram39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky40))
                    .addGroup(jPanel90Layout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay40))
                    .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel90Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout42, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(nama11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(txthargay40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout42, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy1.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 380, -1, -1));

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        nama12.setEditable(false);
        nama12.setBackground(new java.awt.Color(0, 102, 102));
        nama12.setForeground(new java.awt.Color(0, 255, 255));
        nama12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama12ActionPerformed(evt);
            }
        });

        ram40.setEditable(false);
        ram40.setBackground(new java.awt.Color(0, 102, 102));
        ram40.setForeground(new java.awt.Color(0, 255, 255));
        ram40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ram40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ram40ActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel129.setText("Stok :");

        txtstoky41.setEditable(false);
        txtstoky41.setBackground(new java.awt.Color(0, 102, 102));
        txtstoky41.setForeground(new java.awt.Color(0, 255, 255));
        txtstoky41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtstoky41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstoky41ActionPerformed(evt);
            }
        });

        jLabel130.setText("Rp.");

        txthargay41.setEditable(false);
        txthargay41.setBackground(new java.awt.Color(0, 102, 102));
        txthargay41.setForeground(new java.awt.Color(0, 255, 255));
        txthargay41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btncekout43.setText("check out");
        btncekout43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekout43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel91Layout.createSequentialGroup()
                        .addComponent(ram40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstoky41))
                    .addGroup(jPanel91Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargay41))
                    .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel91Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncekout43, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nama12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(nama12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstoky41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(txthargay41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncekout43, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        seriy1.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, -1, -1));

        jPanel92.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("OPPO");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel92Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        seriy1.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1134, -1));

        jPanel1.add(seriy1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// public void image(){
//        ImageIcon img=new ImageIcon("C:\\Users\\HP\\Pictures\\2849824_store_shopping_market_buy_shop_icon.png");
//        Image icon=img.getImage();
//      
//       Image scale=icon.getScaledInstance( penjualan.getWidth(),penjualan.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon baru= new ImageIcon(scale);
//        penjualan.setIcon(baru);
//
//   }
// public void image2(){
//        ImageIcon img=new ImageIcon("C:\\Users\\HP\\Downloads\\customer.png");
//        Image icon=img.getImage();
//      
//       Image scale=icon.getScaledInstance( pelanggan.getWidth(),pelanggan.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon baru= new ImageIcon(scale);
//       pelanggan.setIcon(baru);
//
//   }


    private void penjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penjualanActionPerformed
        
    }//GEN-LAST:event_penjualanActionPerformed

    private void pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganActionPerformed
//        cekout ck=new cekout();
//        ck.setVisible(true);
//        
    }//GEN-LAST:event_pelangganActionPerformed

    private void btncekout26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout26ActionPerformed
         String namahp=vivo12.getText();
        int hargahp=Integer.parseInt(hargav8.getText());
        int stok=Integer.parseInt(stokv8.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout26ActionPerformed

    private void stokv8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv8ActionPerformed

    private void ramv8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv8ActionPerformed

    private void vivo12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo12ActionPerformed

    private void btncekout23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout23ActionPerformed
        String namahp=vivo11.getText();
        int hargahp=Integer.parseInt(hargav7.getText());
        int stok=Integer.parseInt(stokv7.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout23ActionPerformed

    private void stokv7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv7ActionPerformed

    private void ramv7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv7ActionPerformed

    private void vivo11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo11ActionPerformed

    private void btncekout22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout22ActionPerformed
        String namahp=vivo10.getText();
        int hargahp=Integer.parseInt(hargav6.getText());
        int stok=Integer.parseInt(stokv6.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout22ActionPerformed

    private void stokv6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv6ActionPerformed

    private void ramv6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv6ActionPerformed

    private void vivo10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo10ActionPerformed

    private void btncekout21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout21ActionPerformed
        String namahp=vivo9.getText();
        int hargahp=Integer.parseInt(hargav5.getText());
        int stok=Integer.parseInt(stokv5.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout21ActionPerformed

    private void stokv5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv5ActionPerformed

    private void ramv5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv5ActionPerformed

    private void vivo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo9ActionPerformed

    private void btncekout20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout20ActionPerformed
       String namahp=vivo8.getText();
        int hargahp=Integer.parseInt(hargav4.getText());
        int stok=Integer.parseInt(stokv4.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout20ActionPerformed

    private void stokv4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv4ActionPerformed

    private void ramv4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv4ActionPerformed

    private void vivo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo8ActionPerformed

    private void btncekout19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout19ActionPerformed
        String namahp=vivo7.getText();
        int hargahp=Integer.parseInt(hargav3.getText());
        int stok=Integer.parseInt(stokv3.getText());
       cekout ck= new cekout(namahp,hargahp,stok,logiinAs);  
       ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout19ActionPerformed

    private void stokv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv3ActionPerformed

    private void ramv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv3ActionPerformed

    private void vivo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo7ActionPerformed

    private void btncekout13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout13ActionPerformed
        String namahp=vivo6.getText();
        int hargahp=Integer.parseInt(hargav2.getText());
        int stok=Integer.parseInt(stokv2.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout13ActionPerformed

    private void stokv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv2ActionPerformed

    private void ramv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv2ActionPerformed

    private void vivo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo6ActionPerformed

    private void btncekout12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout12ActionPerformed
        String namahp=vivo5.getText();
        int hargahp=Integer.parseInt(hargav1.getText());
        int stok=Integer.parseInt(stokv1.getText());
       cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
         ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout12ActionPerformed

    private void stokv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv1ActionPerformed

    private void ramv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv1ActionPerformed

    private void vivo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo5ActionPerformed

    private void btncekout11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout11ActionPerformed
        String namahp=vivo4.getText();
        int hargahp=Integer.parseInt(hargav12.getText());
        int stok=Integer.parseInt(stokv12.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout11ActionPerformed

    private void stokv12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv12ActionPerformed

    private void ramv12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv12ActionPerformed

    private void vivo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo4ActionPerformed

    private void btncekout10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout10ActionPerformed
      String namahp=vivo3.getText();
        int hargahp=Integer.parseInt(hargav11.getText());
        int stok=Integer.parseInt(stokv11.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout10ActionPerformed

    private void stokv11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv11ActionPerformed

    private void ramv11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv11ActionPerformed

    private void vivo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo3ActionPerformed

    private void btncekout9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout9ActionPerformed
        String namahp=vivo2.getText();
        int hargahp=Integer.parseInt(hargav10.getText());
        int stok=Integer.parseInt(stokv10.getText());
       cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
         ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekout9ActionPerformed

    private void stokv10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv10ActionPerformed

    private void ramv10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv10ActionPerformed

    private void vivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo2ActionPerformed

    private void btncekoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekoutActionPerformed
        String namahp=vivo1.getText();
        int hargahp=Integer.parseInt(hargav9.getText());
        int stok=Integer.parseInt(stokv9.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncekoutActionPerformed

    private void stokv9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokv9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokv9ActionPerformed

    private void ramv9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramv9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ramv9ActionPerformed

    private void vivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vivo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vivo1ActionPerformed

    private void oppo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oppo1MouseClicked
mi1.setBackground(new Color(0,204,51));
viv1.setBackground(new Color(0,204,51));
oppo1.setBackground(Color.YELLOW);
tentang.setBackground(new Color(0,204,51));
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(seriy1);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_oppo1MouseClicked

    private void viv1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viv1MouseClicked
viv1.setBackground(Color.YELLOW);
mi1.setBackground(new Color(0,204,51));
oppo1.setBackground(new Color(0,204,51));
tentang.setBackground(new Color(0,204,51));
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(seriy);
        jPanel1.repaint();
        jPanel1.revalidate();      
    }//GEN-LAST:event_viv1MouseClicked

    private void mi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi1MouseClicked
mi1.setBackground(Color.YELLOW);
viv1.setBackground(new Color(0,204,51));
oppo1.setBackground(new Color(0,204,51));
tentang.setBackground(new Color(0,204,51));
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel41);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_mi1MouseClicked

    private void nama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama1ActionPerformed

    private void ram7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram7ActionPerformed

    private void txtstok4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstok4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstok4ActionPerformed

    private void btncekout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout1ActionPerformed
 String namahp=nama1.getText();
        int hargahp=Integer.parseInt(txtharga5.getText());
        int stok=Integer.parseInt(txtstok4.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
        ck.setVisible(true);
        dispose();        
    }//GEN-LAST:event_btncekout1ActionPerformed

    private void nama2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama2ActionPerformed

    private void ram8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram8ActionPerformed

    private void txtstok5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstok5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstok5ActionPerformed

    private void btncekout14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout14ActionPerformed
       String namahp=nama2.getText();
        int hargahp=Integer.parseInt(txtharga7.getText());
        int stok=Integer.parseInt(txtstok5.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
            ck.setLocationRelativeTo(null);
        ck.setVisible(true);
      
        dispose();   
    }//GEN-LAST:event_btncekout14ActionPerformed

    private void nama3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama3ActionPerformed

    private void ram9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram9ActionPerformed

    private void txtstokhp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokhp4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokhp4ActionPerformed

    private void btncekout15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout15ActionPerformed
        String namahp=nama3.getText();
        int hargahp=Integer.parseInt(txtharga8.getText());
        int stok=Integer.parseInt(txtstokhp4.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout15ActionPerformed

    private void nama4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama4ActionPerformed

    private void ram10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram10ActionPerformed

    private void txtstoky18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky18ActionPerformed

    private void btncekout16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout16ActionPerformed
     String namahp=nama4.getText();
        int hargahp=Integer.parseInt(txthargay18.getText());
        int stok=Integer.parseInt(txtstoky18.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout16ActionPerformed

    private void nama5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama5ActionPerformed

    private void ram11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram11ActionPerformed

    private void txtstoky77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky77ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky77ActionPerformed

    private void btncekout17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout17ActionPerformed
     String namahp=nama5.getText();
        int hargahp=Integer.parseInt(txthargay77.getText());
        int stok=Integer.parseInt(txtstoky77.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout17ActionPerformed

    private void nama6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama6ActionPerformed

    private void ram12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram12ActionPerformed

    private void txtstoky35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky35ActionPerformed

    private void btncekout18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout18ActionPerformed
        String namahp=nama6.getText();
        int hargahp=Integer.parseInt(txthargay35.getText());
        int stok=Integer.parseInt(txtstoky35.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout18ActionPerformed

    private void nama7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama7ActionPerformed

    private void ram35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram35ActionPerformed

    private void txtstoky36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky36ActionPerformed

    private void btncekout38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout38ActionPerformed
       String namahp=nama7.getText();
        int hargahp=Integer.parseInt(txthargay36.getText());
        int stok=Integer.parseInt(txtstoky36.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout38ActionPerformed

    private void nama8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama8ActionPerformed

    private void ram36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram36ActionPerformed

    private void txtstoky37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky37ActionPerformed

    private void btncekout39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout39ActionPerformed
       String namahp=nama8.getText();
        int hargahp=Integer.parseInt(txthargay37.getText());
        int stok=Integer.parseInt(txtstoky37.getText());
       cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
         ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout39ActionPerformed

    private void nama9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama9ActionPerformed

    private void ram37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram37ActionPerformed

    private void txtstoky38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky38ActionPerformed

    private void btncekout40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout40ActionPerformed
        String namahp=nama9.getText();
        int hargahp=Integer.parseInt(txthargay38.getText());
        int stok=Integer.parseInt(txtstoky38.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout40ActionPerformed

    private void nama10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama10ActionPerformed

    private void ram38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram38ActionPerformed

    private void txtstoky39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky39ActionPerformed

    private void btncekout41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout41ActionPerformed
       String namahp=nama10.getText();
        int hargahp=Integer.parseInt(txthargay39.getText());
        int stok=Integer.parseInt(txtstoky39.getText());
         cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
           ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout41ActionPerformed

    private void nama11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama11ActionPerformed

    private void ram39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram39ActionPerformed

    private void txtstoky40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky40ActionPerformed

    private void btncekout42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout42ActionPerformed
        String namahp=nama11.getText();
        int hargahp=Integer.parseInt(txthargay40.getText());
        int stok=Integer.parseInt(txtstoky40.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout42ActionPerformed

    private void nama12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama12ActionPerformed

    private void ram40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ram40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ram40ActionPerformed

    private void txtstoky41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstoky41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstoky41ActionPerformed

    private void btncekout43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekout43ActionPerformed
        String namahp=nama12.getText();
        int hargahp=Integer.parseInt(txthargay41.getText());
        int stok=Integer.parseInt(txtstoky41.getText());
        cekout ck= new cekout(namahp,hargahp,stok,logiinAs);
          ck.setLocationRelativeTo(null);
        ck.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btncekout43ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tentangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentangMouseClicked
tentang2 t=new tentang2();
t.setLocationRelativeTo(null);
t.setVisible(true);
        mi1.setBackground(new Color(0,204,51));
viv1.setBackground(new Color(0,204,51));
oppo1.setBackground(new Color(0,204,51));
tentang.setBackground(Color.YELLOW);
    }//GEN-LAST:event_tentangMouseClicked

    private void viv1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viv1MouseReleased
//viv1.setBackground(new Color(0,204,135));         
    }//GEN-LAST:event_viv1MouseReleased

    private void mi5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi5MouseClicked
login n=new login();
n.setVisible(true);
n.setLocationRelativeTo(null);
        dispose();
       mi5.setBackground(Color.BLUE);
    }//GEN-LAST:event_mi5MouseClicked

    private void oppo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oppo1MouseReleased
        oppo.setBackground(Color.YELLOW);
    }//GEN-LAST:event_oppo1MouseReleased

    private void mi1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi1MouseReleased
       mi.setBackground(Color.YELLOW);
       
    }//GEN-LAST:event_mi1MouseReleased

    private void vivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vivMouseClicked
      viv1.setBackground(Color.YELLOW);
    }//GEN-LAST:event_vivMouseClicked

    private void viv1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viv1MouseEntered
        viv.setBackground(Color.BLUE);
    }//GEN-LAST:event_viv1MouseEntered

    private void oppo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oppo1MouseEntered
       oppo.setBackground(Color.BLUE);
    }//GEN-LAST:event_oppo1MouseEntered

    private void mi1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi1MouseExited
          mi.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_mi1MouseExited

    private void viv1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viv1MouseExited
         viv.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_viv1MouseExited

    private void mi1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi1MouseEntered
       mi.setBackground(Color.BLUE);
    }//GEN-LAST:event_mi1MouseEntered

    private void oppo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oppo1MouseExited
         oppo.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_oppo1MouseExited

    private void tentangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentangMouseExited
         ten.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_tentangMouseExited

    private void tentangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tentangMouseEntered
       ten.setBackground(Color.BLUE);
    }//GEN-LAST:event_tentangMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        performSearch();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuutama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuutama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuutama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuutama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuutama1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncekout;
    private javax.swing.JButton btncekout1;
    private javax.swing.JButton btncekout10;
    private javax.swing.JButton btncekout11;
    private javax.swing.JButton btncekout12;
    private javax.swing.JButton btncekout13;
    private javax.swing.JButton btncekout14;
    private javax.swing.JButton btncekout15;
    private javax.swing.JButton btncekout16;
    private javax.swing.JButton btncekout17;
    private javax.swing.JButton btncekout18;
    private javax.swing.JButton btncekout19;
    private javax.swing.JButton btncekout20;
    private javax.swing.JButton btncekout21;
    private javax.swing.JButton btncekout22;
    private javax.swing.JButton btncekout23;
    private javax.swing.JButton btncekout26;
    private javax.swing.JButton btncekout38;
    private javax.swing.JButton btncekout39;
    private javax.swing.JButton btncekout40;
    private javax.swing.JButton btncekout41;
    private javax.swing.JButton btncekout42;
    private javax.swing.JButton btncekout43;
    private javax.swing.JButton btncekout9;
    private javax.swing.JTextField hargav1;
    private javax.swing.JTextField hargav10;
    private javax.swing.JTextField hargav11;
    private javax.swing.JTextField hargav12;
    private javax.swing.JTextField hargav2;
    private javax.swing.JTextField hargav3;
    private javax.swing.JTextField hargav4;
    private javax.swing.JTextField hargav5;
    private javax.swing.JTextField hargav6;
    private javax.swing.JTextField hargav7;
    private javax.swing.JTextField hargav8;
    private javax.swing.JTextField hargav9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
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
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JLabel lblhpjual;
    private javax.swing.JLabel lblmasuk;
    private javax.swing.JLabel lblpemasukan;
    private javax.swing.JLabel lblpenjualan;
    private javax.swing.JLabel lblsetok;
    private javax.swing.JLabel lblstok;
    private javax.swing.JPanel mi;
    private javax.swing.JPanel mi1;
    private javax.swing.JPanel mi4;
    private javax.swing.JPanel mi5;
    private javax.swing.JTextField nama1;
    private javax.swing.JTextField nama10;
    private javax.swing.JTextField nama11;
    private javax.swing.JTextField nama12;
    private javax.swing.JTextField nama2;
    private javax.swing.JTextField nama3;
    private javax.swing.JTextField nama4;
    private javax.swing.JTextField nama5;
    private javax.swing.JTextField nama6;
    private javax.swing.JTextField nama7;
    private javax.swing.JTextField nama8;
    private javax.swing.JTextField nama9;
    private javax.swing.JPanel oppo;
    private javax.swing.JPanel oppo1;
    private javax.swing.JButton pelanggan;
    private javax.swing.JButton penjualan;
    private javax.swing.JTextField ram10;
    private javax.swing.JTextField ram11;
    private javax.swing.JTextField ram12;
    private javax.swing.JTextField ram35;
    private javax.swing.JTextField ram36;
    private javax.swing.JTextField ram37;
    private javax.swing.JTextField ram38;
    private javax.swing.JTextField ram39;
    private javax.swing.JTextField ram40;
    private javax.swing.JTextField ram7;
    private javax.swing.JTextField ram8;
    private javax.swing.JTextField ram9;
    private javax.swing.JTextField ramv1;
    private javax.swing.JTextField ramv10;
    private javax.swing.JTextField ramv11;
    private javax.swing.JTextField ramv12;
    private javax.swing.JTextField ramv2;
    private javax.swing.JTextField ramv3;
    private javax.swing.JTextField ramv4;
    private javax.swing.JTextField ramv5;
    private javax.swing.JTextField ramv6;
    private javax.swing.JTextField ramv7;
    private javax.swing.JTextField ramv8;
    private javax.swing.JTextField ramv9;
    private javax.swing.JPanel seriy;
    private javax.swing.JPanel seriy1;
    private javax.swing.JTextField stokv1;
    private javax.swing.JTextField stokv10;
    private javax.swing.JTextField stokv11;
    private javax.swing.JTextField stokv12;
    private javax.swing.JTextField stokv2;
    private javax.swing.JTextField stokv3;
    private javax.swing.JTextField stokv4;
    private javax.swing.JTextField stokv5;
    private javax.swing.JTextField stokv6;
    private javax.swing.JTextField stokv7;
    private javax.swing.JTextField stokv8;
    private javax.swing.JTextField stokv9;
    private javax.swing.JPanel ten;
    private javax.swing.JPanel tentang;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtharga5;
    private javax.swing.JTextField txtharga7;
    private javax.swing.JTextField txtharga8;
    private javax.swing.JTextField txthargay18;
    private javax.swing.JTextField txthargay35;
    private javax.swing.JTextField txthargay36;
    private javax.swing.JTextField txthargay37;
    private javax.swing.JTextField txthargay38;
    private javax.swing.JTextField txthargay39;
    private javax.swing.JTextField txthargay40;
    private javax.swing.JTextField txthargay41;
    private javax.swing.JTextField txthargay77;
    private javax.swing.JTextField txtstok4;
    private javax.swing.JTextField txtstok5;
    private javax.swing.JTextField txtstokhp4;
    private javax.swing.JTextField txtstoky18;
    private javax.swing.JTextField txtstoky35;
    private javax.swing.JTextField txtstoky36;
    private javax.swing.JTextField txtstoky37;
    private javax.swing.JTextField txtstoky38;
    private javax.swing.JTextField txtstoky39;
    private javax.swing.JTextField txtstoky40;
    private javax.swing.JTextField txtstoky41;
    private javax.swing.JTextField txtstoky77;
    private javax.swing.JPanel viv;
    private javax.swing.JPanel viv1;
    private javax.swing.JTextField vivo1;
    private javax.swing.JTextField vivo10;
    private javax.swing.JTextField vivo11;
    private javax.swing.JTextField vivo12;
    private javax.swing.JTextField vivo2;
    private javax.swing.JTextField vivo3;
    private javax.swing.JTextField vivo4;
    private javax.swing.JTextField vivo5;
    private javax.swing.JTextField vivo6;
    private javax.swing.JTextField vivo7;
    private javax.swing.JTextField vivo8;
    private javax.swing.JTextField vivo9;
    private javax.swing.JLabel y02;
    private javax.swing.JLabel y16;
    private javax.swing.JLabel y18;
    private javax.swing.JLabel y21;
    private javax.swing.JLabel y22;
    private javax.swing.JLabel y25;
    private javax.swing.JLabel y26;
    private javax.swing.JLabel y3;
    private javax.swing.JLabel y35;
    private javax.swing.JLabel y36;
    private javax.swing.JLabel y75;
    private javax.swing.JLabel y76;
    private javax.swing.JLabel y77;
    private javax.swing.JLabel y79;
    private javax.swing.JLabel y80;
    private javax.swing.JLabel y82;
    private javax.swing.JLabel y83;
    private javax.swing.JLabel y91;
    private javax.swing.JLabel y92;
    private javax.swing.JLabel y93;
    private javax.swing.JLabel y94;
    private javax.swing.JLabel y95;
    private javax.swing.JLabel y96;
    private javax.swing.JLabel y97;
    // End of variables declaration//GEN-END:variables
}
