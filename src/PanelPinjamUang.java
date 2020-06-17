
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahen
 */
public class PanelPinjamUang extends javax.swing.JFrame {

    /**
     * Creates new form PanelPinjamUang
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    String nip_guru = GuruSession.getG_nip();
    
    private void peminjamanAnda(){
        
            try {
            koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            stat = DB.stm;
            String sq; 
                sq = "SELECT * FROM peminjaman WHERE nip_guru='"+nip_guru+"'";
            stat=con.createStatement();
            rs=stat.executeQuery(sq);
            
            while (rs.next())
            {
              String a=rs.getString("total");         
              txt_peminjaman_anda.setText(a);

            }
            rs.close();
            con.close();
         }catch (Exception e)
         {
             JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA PEMINJAMAN");
         }
     }
    
    private void setDisableEnable(){
        String a = txt_peminjaman_anda.getText();
        int b = Integer.parseInt(a);
         
         if(b ==0){
             txt_pengembalian.setEditable(false);
        }else{
             txt_pengembalian.setEditable(true);
         }
    }
    
    
    private void tampilMax(){
        
            try {
            String sql ="SELECT *FROM keuangan";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next())
            {
              String a=rs.getString("kas");         
              txt_max.setText(a);

            }
            rs.close();
            con.close();
         }catch (Exception e)
         {
             JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
         }
     }
    
    public void tampilKodePeminjaman(){
        try {
            koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            stat = DB.stm;
            sql="SELECT * FROM peminjaman ORDER BY kode_peminjaman DESC";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kode_peminjaman").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}

               txt_kode_peminjaman.setText("S" + Nol + AN);
            } else {
               txt_kode_peminjaman.setText("S0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
    }
    
    public PanelPinjamUang() {
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
        
        tampilMax();
        tampilKodePeminjaman();
        peminjamanAnda();
        setDisableEnable();
        
        txt_nip_guru.setText(nip_guru);
        
        
           
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_max = new javax.swing.JTextField();
        txt_peminjaman = new javax.swing.JTextField();
        button_pinjam = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_nip_guru = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_pengembalian = new javax.swing.JTextField();
        button_kembali = new javax.swing.JButton();
        button_batal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_peminjaman_anda = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_kode_peminjaman = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel1.setText("Form Peminjaman dan Pengembalian");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 200));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peminjaman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel3.setText("Peminjaman");

        txt_max.setEditable(false);
        txt_max.setBackground(new java.awt.Color(204, 204, 204));
        txt_max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maxActionPerformed(evt);
            }
        });

        txt_peminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_peminjamanKeyReleased(evt);
            }
        });

        button_pinjam.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        button_pinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-plus-48.png"))); // NOI18N
        button_pinjam.setText("Pinjam");
        button_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pinjamActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel6.setText("Max Pinjaman");

        txt_nip_guru.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txt_max)
                    .addComponent(txt_nip_guru))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(button_pinjam)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nip_guru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(button_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 350, 320));

        jPanel3.setBackground(new java.awt.Color(102, 102, 200));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pengembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel5.setText("Pengembalian");

        txt_pengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pengembalianActionPerformed(evt);
            }
        });

        button_kembali.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        button_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-plus-48.png"))); // NOI18N
        button_kembali.setText("Kembali");
        button_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(txt_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_kembali)
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(button_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 320, 220));

        button_batal.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        button_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-cancel-48.png"))); // NOI18N
        button_batal.setText("Batal");
        button_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batalActionPerformed(evt);
            }
        });
        jPanel1.add(button_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 120, 50));

        jPanel4.setBackground(new java.awt.Color(255, 31, 151));

        jLabel4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel4.setText("Peminjaman anda");

        txt_peminjaman_anda.setEditable(false);
        txt_peminjaman_anda.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(txt_peminjaman_anda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_peminjaman_anda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 320, 90));

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(102, 102, 255));
        txt_total.setForeground(new java.awt.Color(102, 102, 255));
        txt_total.setBorder(null);
        txt_total.setOpaque(false);
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 80, -1));

        txt_kode_peminjaman.setEditable(false);
        txt_kode_peminjaman.setBackground(new java.awt.Color(102, 102, 255));
        txt_kode_peminjaman.setForeground(new java.awt.Color(102, 102, 255));
        txt_kode_peminjaman.setBorder(null);
        txt_kode_peminjaman.setOpaque(false);
        jPanel1.add(txt_kode_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_batalActionPerformed

    private void button_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pinjamActionPerformed
        // TODO add your handling code here:
        String a = txt_max.getText();
        int b = Integer.parseInt(a);
        
        String c = txt_peminjaman.getText();
        int d = Integer.parseInt(c);
        
        String t = txt_peminjaman_anda.getText();
        int i = Integer.parseInt(t);
        
        int u = i+d;
        Integer.toString(u);
        
        int e = b-d;
        Integer.toString(e);
        
        if(d>b){
            JOptionPane.showMessageDialog(null, "Jumlah Peminjaman anda Terlalu banyak");
        }else{
        
        try {
            koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            stat = DB.stm;
            stat = con.createStatement();
            stat.executeUpdate("UPDATE  peminjaman SET "
                + "pinjaman='"      + u +"', "
                + "total='"         +u+"'"
                + "WHERE nip_guru='"    + txt_nip_guru.getText() +"'");
            
            stat.executeUpdate("UPDATE keuangan SET "
                + "kas='"      + e +"'");
            
            
            JOptionPane.showMessageDialog(null, "Peminjaman Berhasil");
            
            try {
            String sql ="SELECT *FROM keuangan";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next())
            {
              String s=rs.getString("kas");         
              txt_max.setText(s);

            }
         }catch (Exception ex){
             JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
         }
            
            try {
            
            String sq = "SELECT * FROM peminjaman WHERE nip_guru='"+nip_guru+"'";
            stat=con.createStatement();
            rs=stat.executeQuery(sq);
            
            while (rs.next())
            {
              String y=rs.getString("total");         
              txt_peminjaman_anda.setText(y);

            }
            
         }catch (Exception es){
             JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA PEMINJAMAN");
         }
     
            
            
            txt_peminjaman.setText("");
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
          }
    
        }
    }//GEN-LAST:event_button_pinjamActionPerformed

    private void txt_maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maxActionPerformed

    private void txt_peminjamanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_peminjamanKeyReleased
        // TODO add your handling code here:
        String c = txt_peminjaman.getText();
        txt_total.setText(c);
    }//GEN-LAST:event_txt_peminjamanKeyReleased

    private void txt_pengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pengembalianActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_txt_pengembalianActionPerformed

    private void button_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_kembaliActionPerformed
        // TODO add your handling code here:
        String t = txt_peminjaman_anda.getText();
        int i = Integer.parseInt(t);
        
        String a = txt_pengembalian.getText();
        int b = Integer.parseInt(a);
        
        String z = txt_max.getText();
        int y = Integer.parseInt(z);
        
        int kembali = y+b;
        String p = Integer.toString(kembali);
        
        int c = i-b;
        String f = Integer.toString(c);
        if(c==0){
            JOptionPane.showMessageDialog(null, "Hutang anda lunas");
        }
        if(b>i){
            int x = b-i;
            JOptionPane.showMessageDialog(null, "Uang anda kelebihan"+x+"Masukkan jumlah yang tepat");
        }else{
        
        
        try{
            koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            stat = DB.stm;
            stat = con.createStatement();
            
            stat.executeUpdate("UPDATE  peminjaman SET "
                + "pengembalian='"      + txt_pengembalian.getText() +"', "
                + "total='"         +f+"'"
                + "WHERE nip_guru='"    + txt_nip_guru.getText() +"'");
            
            stat.executeUpdate("UPDATE  keuangan SET "
                + "kas='"      + p +"'");
            
            
            JOptionPane.showMessageDialog(null, "Pengembalian anda berhasil");
            txt_pengembalian.setText("");
            tampilMax();
            peminjamanAnda();
            
        }catch (Exception e){
            e.printStackTrace();
            }
        }
    }//GEN-LAST:event_button_kembaliActionPerformed

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
            java.util.logging.Logger.getLogger(PanelPinjamUang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPinjamUang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPinjamUang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPinjamUang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPinjamUang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_batal;
    private javax.swing.JButton button_kembali;
    private javax.swing.JButton button_pinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_kode_peminjaman;
    private javax.swing.JTextField txt_max;
    private javax.swing.JTextField txt_nip_guru;
    private javax.swing.JTextField txt_peminjaman;
    private javax.swing.JTextField txt_peminjaman_anda;
    private javax.swing.JTextField txt_pengembalian;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
