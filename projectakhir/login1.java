/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectakhir;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
public class login1 extends javax.swing.JFrame {

  Connection con;
Statement stm;
ResultSet rs;
String sql;
    public login1() {
        initComponents();
          koneksi k =new koneksi();
        k.config();
       con=k.con;
    stm=k.stm;
    image6();
    image5();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public void image5(){
       ImageIcon img=new ImageIcon("C:\\Users\\HP\\Downloads\\bukalock.png");
       Image icon=img.getImage();
     
       Image scale=icon.getScaledInstance(anaknya2.getWidth(),anaknya2.getHeight(),Image.SCALE_SMOOTH);
       ImageIcon baru= new ImageIcon(scale);
       jLabel6.setIcon(baru);
    } public void image6(){
       ImageIcon img=new ImageIcon("C:\\Users\\HP\\Downloads\\buka.png");
       Image icon=img.getImage();
     
       Image scale=icon.getScaledInstance(anaknya.getWidth(),anaknya.getHeight(),Image.SCALE_SMOOTH);
       ImageIcon baru= new ImageIcon(scale);
       jLabel5.setIcon(baru);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtcon = new javax.swing.JPasswordField();
        utama = new javax.swing.JPanel();
        anaknya = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        anaknya2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        txtnama.setBackground(new java.awt.Color(0, 204, 204));
        txtnama.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        txtnama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 51, 51), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 255, 255)));
        txtnama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnamaFocusLost(evt);
            }
        });
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        jButton1.setText("Sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("SIGN IN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Konfirmasi Password");

        txtpass.setBackground(new java.awt.Color(0, 204, 204));
        txtpass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 255, 255)));

        txtcon.setBackground(new java.awt.Color(0, 204, 204));
        txtcon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 255, 255)));

        utama.setBackground(new java.awt.Color(0, 153, 153));
        utama.setLayout(new java.awt.CardLayout());

        anaknya.setBackground(new java.awt.Color(0, 153, 153));
        anaknya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anaknyaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout anaknyaLayout = new javax.swing.GroupLayout(anaknya);
        anaknya.setLayout(anaknyaLayout);
        anaknyaLayout.setHorizontalGroup(
            anaknyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );
        anaknyaLayout.setVerticalGroup(
            anaknyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        utama.add(anaknya, "card2");

        anaknya2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout anaknya2Layout = new javax.swing.GroupLayout(anaknya2);
        anaknya2.setLayout(anaknya2Layout);
        anaknya2Layout.setHorizontalGroup(
            anaknya2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );
        anaknya2Layout.setVerticalGroup(
            anaknya2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        utama.add(anaknya2, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcon, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 107, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(utama, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(utama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(txtpass.getText().equals(txtcon.getText())){
    try{
        sql="insert into login values('"+txtnama.getText()+"','"+txtpass.getText()+"')";
        java.sql.PreparedStatement pst=con.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, "Berhasil buat akun");
        login lg=new login();
        lg.setVisible(true);
        dispose();
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}else{
    txtpass.setText("");
    txtcon.setText("");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnamaFocusGained
        //        if(txtuser.getText().equals("*isikan username anda")){
            //        txtuser.setText("");
            //        txtuser.setForeground(new Color(0,0,0));
            //    }
        }

        private void txtnikFocusLost(java.awt.event.FocusEvent evt) {

    }//GEN-LAST:event_txtnamaFocusGained

    private void txtnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnamaFocusLost
        //         if(txtuser.getText().equals("")){
            //        txtuser.setText("*isikan username anda");
            //         txtuser.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_txtnamaFocusLost

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void anaknyaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anaknyaMouseClicked
        utama.removeAll();
        utama.repaint();
        utama.revalidate();

        utama.add(anaknya2);
        utama.repaint();
        utama.revalidate();
        txtpass.setEchoChar((char)0);
 txtcon.setEchoChar((char)0);
    }//GEN-LAST:event_anaknyaMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        utama.removeAll();
        utama.repaint();
        utama.revalidate();

        utama.add(anaknya);
        utama.repaint();
        utama.revalidate();

        txtpass.setEchoChar(('*'));
        txtcon.setEchoChar(('*'));
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anaknya;
    private javax.swing.JPanel anaknya2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtcon;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPanel utama;
    // End of variables declaration//GEN-END:variables
}
