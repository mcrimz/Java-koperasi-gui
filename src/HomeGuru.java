/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
/**
 *
 * @author Mahen
 */
public class HomeGuru extends javax.swing.JFrame {

    /**
     * Creates new form HomeGuru
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    String usr_guru = GuruSession.getG_username_guru();
    String pass_guru = GuruSession.getG_password_guru();
    String nm_guru = GuruSession.getG_nama_lngkap_guru();
    String almt_guru = GuruSession.getG_alamat_guru();
    
    public void doExit() {
      int confirm = JOptionPane.showConfirmDialog(this,
      "Konfirmasi Keluar ",
      "Yakin untuk keluar ? ",
      JOptionPane.YES_NO_OPTION,
     JOptionPane.QUESTION_MESSAGE);

     if (confirm == JOptionPane.YES_OPTION) {
         new LoginTingkatDua().setVisible(true);
        dispose();
     }
  }
    
    public HomeGuru() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        
        
        nama_guru.setText(nm_guru);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nama_guru = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_pinjam = new javax.swing.JButton();
        btn_beli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1430, 840));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1430, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Optimized-logo-koperasi.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 110));

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selamat Datang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        nama_guru.setFont(new java.awt.Font("Microsoft Tai Le", 1, 36)); // NOI18N
        nama_guru.setForeground(new java.awt.Color(255, 255, 255));
        nama_guru.setText("Nama");
        jPanel1.add(nama_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/phphFuPUXPM.jpg"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 192, 81));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 130));

        jPanel2.setBackground(new java.awt.Color(128, 207, 226));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel3.setText("Daftar Menu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        jPanel3.setBackground(new java.awt.Color(246, 254, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_pinjam.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btn_pinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/kisspng-advance-payment-computer-icons-bank-money-tracking-5b50f742c06350.979973121532032834788.png"))); // NOI18N
        btn_pinjam.setText("Pinjam");
        btn_pinjam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pinjamActionPerformed(evt);
            }
        });
        jPanel3.add(btn_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 220, 150));

        btn_beli.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        btn_beli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/IMGBIN_shopping-cart-online-shopping-amazon-com-png_z5hJnkhv.png"))); // NOI18N
        btn_beli.setText("Beli");
        btn_beli.setToolTipText("");
        btn_beli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beliActionPerformed(evt);
            }
        });
        jPanel3.add(btn_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 220, 140));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 810, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1430, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beliActionPerformed
        // TODO add your handling code here:
        new PanelMenuBarangGuru().setVisible(true);
    }//GEN-LAST:event_btn_beliActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        doExit();

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        doExit();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pinjamActionPerformed
        // TODO add your handling code here:
        new PanelPinjamUang().setVisible(true);
    }//GEN-LAST:event_btn_pinjamActionPerformed

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
            java.util.logging.Logger.getLogger(HomeGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeGuru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_beli;
    private javax.swing.JButton btn_pinjam;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nama_guru;
    // End of variables declaration//GEN-END:variables
}
