
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectakhir;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class datahp extends javax.swing.JFrame {
Connection con;
Statement stm;
ResultSet rs;
String sql;
    public datahp() {
        initComponents();
        koneksi DB= new koneksi();
        DB.config();
        stm=DB.stm;
        con=DB.con;
       // loadtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
//    public void loadtable(){
//        DefaultTableModel model=new DefaultTableModel();
//        
//         model.addColumn("no");
//        model.addColumn("Kode Handphone");
//        model.addColumn("Nama Handphone");
//        model.addColumn("Harga");
//        model.addColumn("Stok ");
//        model.addColumn("Penyimpanan");
//        model.addColumn("Keterangan");
//        try{
//            int no=1;
//            sql="Select * from datahp";
//            rs=stm.executeQuery(sql);
//            while(rs.next()){
//                model.addRow(new Object[]{no++, rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
//            } 
//        tblhp.setModel(model);
//            }catch(Exception e){
//    
//     }
//
//        
//    }
//    public void insert(){
//     try{
//          sql="insert into datahp values('"+kodehp.getText()+"','"+namahp.getText()+"','"+hargahp.getText()+"','"+stok.getText()+"','"+txtpenyimpanan.getText()+"','"+txtket.getText()+"')";
//          java.sql.PreparedStatement pst=con.prepareStatement(sql);
//          pst.execute();
//          JOptionPane.showConfirmDialog(null, "Penyimpanan berhasil");
//          loadtable();
//      }catch(Exception e){
//          JOptionPane.showConfirmDialog(this, e.getMessage());
//      }
//    }
//     public void update(){
//        try{
//            sql="UPDATE datahp  SET namhp='"+namahp.getText()+"',harga='"+hargahp.getText()+"',stok='"+stok.getText()+"',penyimpanan='"+txtpenyimpanan.getText()+"',keterangan='"+txtket.getText()+"' WHERE idhp='"+kodehp.getText()+"'";
//            java.sql.PreparedStatement pst=con.prepareStatement(sql);
//            pst.execute();
//            JOptionPane.showConfirmDialog(null, "Data berhail di update");
//        }catch(Exception e){
//            JOptionPane.showConfirmDialog(null, e.getMessage());
//        }
//    }
//    public void hapus(){
//        try{
//            sql="delete from datahp where idhp='"+kodehp.getText()+"'";
//            java.sql.PreparedStatement pst=con.prepareStatement(sql);
//            pst.execute();
//            JOptionPane.showConfirmDialog(this, "Data dihapus");
//        }catch(Exception e){
//            JOptionPane.showConfirmDialog(this, e.getMessage());
//        }
//    }public void reset(){
//        namahp.setText("");
//        kodehp.setText("");
//        hargahp.setText("");
//        stok.setText("");
//        txtpenyimpanan.setText("");
//        txtket.setText("");
//        
//    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("DATA-DATA HANDPHONE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(977, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(1004, 1004, 1004))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
       DefaultTableModel tb= new DefaultTableModel();
        
        
   
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
            java.util.logging.Logger.getLogger(datahp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datahp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datahp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datahp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datahp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}