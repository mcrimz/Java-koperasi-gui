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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mahen
 */
public class HomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    koneksi conn = new koneksi();
    
    int a_id = AdminSession.getA_id();
    String a_username_admin = AdminSession.getA_username_admin();
    String pass_admin = AdminSession.getA_pass_admin();
    String nama_admin = AdminSession.getA_nama();
    String alamat_admin = AdminSession.getA_alamat();
    //-------------end of session---------------------
    
    private DefaultTableModel tabGuru;
    private DefaultTableModel tabMurid;
    private DefaultTableModel tabBarang ;
    private DefaultTableModel tabPinjaman;
    
    public void doExit() {
      int confirm = JOptionPane.showConfirmDialog(this,
      "Konfirmasi Keluar ",
      "Yakin untuk keluar ? ",
      JOptionPane.YES_NO_OPTION,
     JOptionPane.QUESTION_MESSAGE);

     if (confirm == JOptionPane.YES_OPTION) {
         new LoginTingkatTiga().setVisible(true);
        dispose();
     }
  }
    
    public void tampilKodePeminjaman(){
        try {
            
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
    
    private void  judul(){    
        Object[] atas = {"Nip","Username","Password","Nama Guru","Alamat Guru"};
        tabGuru = new DefaultTableModel(null, atas);
        TabelGuru.setModel(tabGuru);
    }
    public void tampilData(String where){
        try{
            stat = con.createStatement();
            tabGuru.getDataVector().removeAllElements();
            tabGuru.fireTableDataChanged();
            
            
            rs = stat.executeQuery("SELECT * FROM guru " + where); 
            
            while(rs.next()){
                Object[] data = {
                rs.getString("nip_guru"),
                rs.getString("usrnm_guru"),
                rs.getString("pass_guru"),
                rs.getString("nm_lngkp_guru"),
                rs.getString("almt_guru")
                
                };
                tabGuru.addRow(data);
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        } 
    
    public void resetAdmin() {
        txt_nip.setText("");
        txt_username.setText("");
        txt_password.setText("");
        txt_nama.setText("");
        txt_alamat.setText("");
        
    }
    public void resetMurid() {
        txt_username_murid.setText("");
        txt_password_murid.setText("");
        txt_nama_murid.setText("");
        txt_alamat_murid.setText("");
    }
    public void resetBarang() {
        
        try {
            sql="SELECT * FROM barang ORDER BY kode_barang DESC";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kode_barang").substring(1);
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

               txt_kode_barang.setText("B" + Nol + AN);
            } else {
               txt_kode_barang.setText("B0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
        
        
        txt_nama_barang.setText("");
        txt_stock.setText("");
        txt_harga.setText("");
    }
  
//------------------------------------------------------------------------------
     
  private void kodeBarang()
    {
       try {
            sql="SELECT * FROM barang ORDER BY kode_barang DESC";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kode_barang").substring(1);
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

               txt_kode_barang.setText("B" + Nol + AN);
            } else {
               txt_kode_barang.setText("B0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
    }
//-------------------------------------------------------------------------------

    private void  judulMurid(){    
        Object[] atas = {"Username","Password","Nama Lengkap","Alamat"};
        tabMurid = new DefaultTableModel(null, atas);
        TabelMurid.setModel(tabMurid);
    }
    public void tampilDataMurid(String where){
        try{
            stat = con.createStatement();
            tabMurid.getDataVector().removeAllElements();
            tabMurid.fireTableDataChanged();
            
            
            rs = stat.executeQuery("SELECT * FROM murid " + where); 
            
            while(rs.next()){
                Object[] data = {
                rs.getString("usrnm_murid"),
                rs.getString("pass_murid"),
                rs.getString("nm_lngkp_murid"),
                rs.getString("almt_murid")
                };
                tabMurid.addRow(data);
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        } 
    //-------------------------------------------------------------------------
    private void  judulBarang(){    
        Object[] atas = {"Kode Barang","Nama Barang","Stock Barang","Harga Barang"};
        tabBarang = new DefaultTableModel(null, atas);
        TabelBarang.setModel(tabBarang);
    }
    public void tampilDataBarang(String where){
        try{
            stat = con.createStatement();
            tabBarang.getDataVector().removeAllElements();
            tabBarang.fireTableDataChanged();
            
            
            rs = stat.executeQuery("SELECT * FROM barang " + where); 
            
            while(rs.next()){
                Object[] data = {
                rs.getString("kode_barang"),
                rs.getString("nama_barang"),
                rs.getString("jumlah_barang"),
                rs.getString("Harga")
                };
                tabBarang.addRow(data);
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        } 
    
    private void tampilKas(){
        try {
           String sql ="SELECT *FROM keuangan";
           stat=con.createStatement();
           rs=stat.executeQuery(sql);
           while (rs.next())
           {
             String a=rs.getString("kas");         
             txt_kas.setText(a);
            
           }
           
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "GAGAL MENAMPILKAN DATA");
        }
    }
    
    private void  judulPinjaman(){    
        Object[] atas = {"Kode Peminjaman","NIP","Pinjaman","Pengembalian","Total"};
        tabPinjaman = new DefaultTableModel(null, atas);
        TabelKeuangan.setModel(tabPinjaman);
    }
    public void tampilDataPinjaman(String where){
        try{
            stat = con.createStatement();
            tabPinjaman.getDataVector().removeAllElements();
            tabPinjaman.fireTableDataChanged();
            
            
            rs = stat.executeQuery("SELECT * FROM peminjaman " + where); 
            
            while(rs.next()){
                Object[] data = {
                rs.getString("kode_peminjaman"),
                rs.getString("nip_guru"),
                rs.getString("pinjaman"),
                rs.getString("pengembalian"),
                rs.getString("total")
                };
                tabPinjaman.addRow(data);
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        } 
    
    //-------------------------------------------------------------------------

    DefaultTableModel def_mod;
    
    
    
    public HomeAdmin() throws SQLException {
        initComponents();
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        //--------------------------------------------------------------------
        masuk.setText(nama_admin);
        nama.setText(nama_admin);
        alamat.setText(alamat_admin);
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        HalamanInfoBeranda.setVisible(true);
        HalamanInfoGuru.setVisible(false);
        HalamanInfoMurid.setVisible(false);
        HalamanInfoKeuangan.setVisible(false);
        HalamanInfoBarang.setVisible(false);
        
        


        judul();
        tampilData("");
        judulMurid();
        tampilDataMurid("");
        judulBarang();
        tampilDataBarang("");
        judulPinjaman();
        tampilDataPinjaman("");
        kodeBarang();
        tampilKas();
        tampilKodePeminjaman();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kiri = new javax.swing.JPanel();
        Beranda = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        InfoGuru = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        InfoMurid = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        InfoBarang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        InfoKeuangan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        atas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        masuk = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_keluar = new javax.swing.JButton();
        HalamanInfoBeranda = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        HalamanInfoGuru = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelGuru = new javax.swing.JTable();
        buttonUpdate = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_nip = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        buttonHapus = new javax.swing.JButton();
        txt_kode_peminjaman = new javax.swing.JTextField();
        HalamanInfoMurid = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelMurid = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_username_murid = new javax.swing.JTextField();
        txt_password_murid = new javax.swing.JTextField();
        txt_nama_murid = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_alamat_murid = new javax.swing.JTextArea();
        ButtonSimpanMurid = new javax.swing.JButton();
        ButtonHapusMurid = new javax.swing.JButton();
        ButtonUpdateMurid = new javax.swing.JButton();
        ButtonResetMurid = new javax.swing.JButton();
        HalamanInfoBarang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelBarang = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_kode_barang = new javax.swing.JTextField();
        txt_nama_barang = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        ButtonSimpanBarang = new javax.swing.JButton();
        ButtonUpdateBarang = new javax.swing.JButton();
        ButtonResetBarang = new javax.swing.JButton();
        ButtonHapusBarang = new javax.swing.JButton();
        HalamanInfoKeuangan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_kas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelKeuangan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txt_tambah_kas = new javax.swing.JTextField();
        button_tambahKas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kiri.setBackground(new java.awt.Color(0, 0, 0));
        kiri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Beranda.setBackground(new java.awt.Color(13, 12, 66));
        Beranda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Beranda");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BerandaLayout = new javax.swing.GroupLayout(Beranda);
        Beranda.setLayout(BerandaLayout);
        BerandaLayout.setHorizontalGroup(
            BerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        BerandaLayout.setVerticalGroup(
            BerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BerandaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        kiri.add(Beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 100));

        InfoGuru.setBackground(new java.awt.Color(13, 12, 66));
        InfoGuru.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Info Guru");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout InfoGuruLayout = new javax.swing.GroupLayout(InfoGuru);
        InfoGuru.setLayout(InfoGuruLayout);
        InfoGuruLayout.setHorizontalGroup(
            InfoGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoGuruLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        InfoGuruLayout.setVerticalGroup(
            InfoGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoGuruLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        kiri.add(InfoGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 100));

        InfoMurid.setBackground(new java.awt.Color(13, 12, 66));
        InfoMurid.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Info Murid");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout InfoMuridLayout = new javax.swing.GroupLayout(InfoMurid);
        InfoMurid.setLayout(InfoMuridLayout);
        InfoMuridLayout.setHorizontalGroup(
            InfoMuridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoMuridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        InfoMuridLayout.setVerticalGroup(
            InfoMuridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoMuridLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        kiri.add(InfoMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 100));

        InfoBarang.setBackground(new java.awt.Color(13, 12, 66));
        InfoBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Info Barang");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout InfoBarangLayout = new javax.swing.GroupLayout(InfoBarang);
        InfoBarang.setLayout(InfoBarangLayout);
        InfoBarangLayout.setHorizontalGroup(
            InfoBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        InfoBarangLayout.setVerticalGroup(
            InfoBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoBarangLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        kiri.add(InfoBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 100));

        InfoKeuangan.setBackground(new java.awt.Color(13, 12, 66));
        InfoKeuangan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Info Keuangan");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout InfoKeuanganLayout = new javax.swing.GroupLayout(InfoKeuangan);
        InfoKeuangan.setLayout(InfoKeuanganLayout);
        InfoKeuanganLayout.setHorizontalGroup(
            InfoKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoKeuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        InfoKeuanganLayout.setVerticalGroup(
            InfoKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoKeuanganLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        kiri.add(InfoKeuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 180, 100));

        jPanel7.setBackground(new java.awt.Color(13, 12, 66));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        kiri.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 180, 100));

        jPanel8.setBackground(new java.awt.Color(13, 12, 66));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        kiri.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 180, 100));

        getContentPane().add(kiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 700));

        atas.setBackground(new java.awt.Color(0, 0, 0));
        atas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang");
        atas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 59, -1, 39));

        masuk.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        masuk.setForeground(new java.awt.Color(255, 255, 255));
        masuk.setText("Admin");
        atas.add(masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 59, -1, 39));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Optimized-logo-koperasi.png"))); // NOI18N
        atas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 13, 111, 106));

        button_keluar.setBackground(new java.awt.Color(0, 0, 0));
        button_keluar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        button_keluar.setForeground(new java.awt.Color(255, 255, 255));
        button_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/phphFuPUXPM.jpg"))); // NOI18N
        button_keluar.setText("Logout");
        button_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_keluarMouseClicked(evt);
            }
        });
        button_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_keluarActionPerformed(evt);
            }
        });
        atas.add(button_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, 192, 81));

        getContentPane().add(atas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 140));

        HalamanInfoBeranda.setBackground(new java.awt.Color(255, 255, 255));
        HalamanInfoBeranda.setForeground(new java.awt.Color(255, 255, 255));
        HalamanInfoBeranda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel30.setText("Alamat");

        jLabel29.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel29.setText("Nama");

        jLabel8.setFont(new java.awt.Font("Microsoft Tai Le", 1, 36)); // NOI18N
        jLabel8.setText("Info Admin");

        nama.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        nama.setText("Nama");

        alamat.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        alamat.setText("Nama");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama)
                            .addComponent(alamat)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel8)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel8)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama)
                    .addComponent(jLabel29))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(alamat))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        HalamanInfoBeranda.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 720, 450));

        getContentPane().add(HalamanInfoBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1250, 700));

        HalamanInfoGuru.setBackground(new java.awt.Color(255, 255, 255));
        HalamanInfoGuru.setMinimumSize(new java.awt.Dimension(486, 82));
        HalamanInfoGuru.setPreferredSize(new java.awt.Dimension(486, 82));
        HalamanInfoGuru.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel9.setText("Info Guru");
        HalamanInfoGuru.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        TabelGuru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nip", "Username", "Password", "Nama Lengkap", "Alamat", "Status Pinjam"
            }
        ));
        TabelGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGuruMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelGuru);
        if (TabelGuru.getColumnModel().getColumnCount() > 0) {
            TabelGuru.getColumnModel().getColumn(0).setResizable(false);
            TabelGuru.getColumnModel().getColumn(1).setResizable(false);
            TabelGuru.getColumnModel().getColumn(2).setResizable(false);
            TabelGuru.getColumnModel().getColumn(3).setResizable(false);
            TabelGuru.getColumnModel().getColumn(4).setResizable(false);
            TabelGuru.getColumnModel().getColumn(5).setResizable(false);
            TabelGuru.getColumnModel().getColumn(5).setPreferredWidth(7);
        }

        HalamanInfoGuru.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 690, 400));

        buttonUpdate.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        buttonUpdate.setText("Update");
        buttonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateMouseClicked(evt);
            }
        });
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        buttonSimpan.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSimpanMouseClicked(evt);
            }
        });
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(buttonSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        buttonReset.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(buttonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 70, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel13.setText("Nip");
        HalamanInfoGuru.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel14.setText("Username");
        HalamanInfoGuru.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel15.setText("Password");
        HalamanInfoGuru.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel16.setText("Nama Lengkap");
        HalamanInfoGuru.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel17.setText("Alamat");
        HalamanInfoGuru.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 20));
        HalamanInfoGuru.add(txt_nip, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 180, -1));

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 180, -1));

        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
        });
        HalamanInfoGuru.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 180, -1));
        HalamanInfoGuru.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 180, -1));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane3.setViewportView(txt_alamat);

        HalamanInfoGuru.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, 120));

        buttonHapus.setFont(new java.awt.Font("Microsoft Tai Le", 1, 13)); // NOI18N
        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(buttonHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        txt_kode_peminjaman.setEditable(false);
        txt_kode_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        txt_kode_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        txt_kode_peminjaman.setBorder(null);
        txt_kode_peminjaman.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_kode_peminjaman.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_kode_peminjaman.setEnabled(false);
        txt_kode_peminjaman.setOpaque(false);
        txt_kode_peminjaman.setSelectionColor(new java.awt.Color(255, 255, 255));
        txt_kode_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kode_peminjamanActionPerformed(evt);
            }
        });
        HalamanInfoGuru.add(txt_kode_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 110, -1));

        getContentPane().add(HalamanInfoGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1250, 700));

        HalamanInfoMurid.setBackground(new java.awt.Color(255, 255, 255));
        HalamanInfoMurid.setMinimumSize(new java.awt.Dimension(486, 82));
        HalamanInfoMurid.setPreferredSize(new java.awt.Dimension(486, 82));
        HalamanInfoMurid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel10.setText("Info Murid");
        HalamanInfoMurid.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        TabelMurid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabelMurid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Nama Lengkap", "Alamat"
            }
        ));
        TabelMurid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMuridMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelMurid);
        if (TabelMurid.getColumnModel().getColumnCount() > 0) {
            TabelMurid.getColumnModel().getColumn(0).setResizable(false);
            TabelMurid.getColumnModel().getColumn(1).setResizable(false);
            TabelMurid.getColumnModel().getColumn(2).setResizable(false);
            TabelMurid.getColumnModel().getColumn(2).setPreferredWidth(70);
            TabelMurid.getColumnModel().getColumn(3).setResizable(false);
            TabelMurid.getColumnModel().getColumn(3).setPreferredWidth(70);
        }

        HalamanInfoMurid.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 720, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel19.setText("Username");
        HalamanInfoMurid.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel20.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel20.setText("Password");
        HalamanInfoMurid.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel21.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel21.setText("Nama Lengkap");
        HalamanInfoMurid.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel22.setText("Alamat");
        HalamanInfoMurid.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));
        HalamanInfoMurid.add(txt_username_murid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 220, -1));

        txt_password_murid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password_muridActionPerformed(evt);
            }
        });
        HalamanInfoMurid.add(txt_password_murid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 220, -1));
        HalamanInfoMurid.add(txt_nama_murid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 220, -1));

        txt_alamat_murid.setColumns(20);
        txt_alamat_murid.setRows(5);
        jScrollPane4.setViewportView(txt_alamat_murid);

        HalamanInfoMurid.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 240, -1));

        ButtonSimpanMurid.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonSimpanMurid.setText("Simpan");
        ButtonSimpanMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSimpanMuridActionPerformed(evt);
            }
        });
        HalamanInfoMurid.add(ButtonSimpanMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        ButtonHapusMurid.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonHapusMurid.setText("Hapus");
        ButtonHapusMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHapusMuridActionPerformed(evt);
            }
        });
        HalamanInfoMurid.add(ButtonHapusMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 90, -1));

        ButtonUpdateMurid.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonUpdateMurid.setText("Update");
        ButtonUpdateMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateMuridActionPerformed(evt);
            }
        });
        HalamanInfoMurid.add(ButtonUpdateMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, -1, -1));

        ButtonResetMurid.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonResetMurid.setText("Reset");
        ButtonResetMurid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetMuridActionPerformed(evt);
            }
        });
        HalamanInfoMurid.add(ButtonResetMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 90, -1));

        getContentPane().add(HalamanInfoMurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1250, 700));

        HalamanInfoBarang.setBackground(new java.awt.Color(255, 255, 255));
        HalamanInfoBarang.setMinimumSize(new java.awt.Dimension(486, 82));
        HalamanInfoBarang.setPreferredSize(new java.awt.Dimension(486, 82));
        HalamanInfoBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel11.setText("Info Barang");
        HalamanInfoBarang.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        TabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Stock", "Harga"
            }
        ));
        TabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelBarangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelBarang);
        if (TabelBarang.getColumnModel().getColumnCount() > 0) {
            TabelBarang.getColumnModel().getColumn(0).setResizable(false);
            TabelBarang.getColumnModel().getColumn(1).setResizable(false);
        }

        HalamanInfoBarang.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 620, -1));

        jLabel23.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel23.setText("Kode Brang");
        HalamanInfoBarang.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel24.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel24.setText("Nama Barang");
        HalamanInfoBarang.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel25.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel25.setText("Stock");
        HalamanInfoBarang.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel26.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel26.setText("Harga");
        HalamanInfoBarang.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        txt_kode_barang.setEditable(false);
        txt_kode_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kode_barangActionPerformed(evt);
            }
        });
        HalamanInfoBarang.add(txt_kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, -1));
        HalamanInfoBarang.add(txt_nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 130, -1));
        HalamanInfoBarang.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 130, -1));
        HalamanInfoBarang.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 130, -1));

        ButtonSimpanBarang.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonSimpanBarang.setText("Simpan");
        ButtonSimpanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSimpanBarangActionPerformed(evt);
            }
        });
        HalamanInfoBarang.add(ButtonSimpanBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        ButtonUpdateBarang.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonUpdateBarang.setText("Update");
        ButtonUpdateBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateBarangActionPerformed(evt);
            }
        });
        HalamanInfoBarang.add(ButtonUpdateBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, -1));

        ButtonResetBarang.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonResetBarang.setText("Reset");
        ButtonResetBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetBarangActionPerformed(evt);
            }
        });
        HalamanInfoBarang.add(ButtonResetBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 80, -1));

        ButtonHapusBarang.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        ButtonHapusBarang.setText("Hapus");
        ButtonHapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHapusBarangActionPerformed(evt);
            }
        });
        HalamanInfoBarang.add(ButtonHapusBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 80, -1));

        getContentPane().add(HalamanInfoBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1250, 700));

        HalamanInfoKeuangan.setBackground(new java.awt.Color(255, 255, 255));
        HalamanInfoKeuangan.setMinimumSize(new java.awt.Dimension(486, 82));
        HalamanInfoKeuangan.setPreferredSize(new java.awt.Dimension(486, 82));
        HalamanInfoKeuangan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel12.setText("Info Keuangan");
        HalamanInfoKeuangan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel27.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel27.setText("Jumlah Kas");
        HalamanInfoKeuangan.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        txt_kas.setEditable(false);
        HalamanInfoKeuangan.add(txt_kas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daftar Pinjaman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        TabelKeuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(TabelKeuangan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        HalamanInfoKeuangan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 830, 550));

        jLabel28.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel28.setText("Tambah Kas");

        button_tambahKas.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        button_tambahKas.setText("Tambah");
        button_tambahKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tambahKasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(35, 35, 35)
                .addComponent(txt_tambah_kas)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(button_tambahKas)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_tambah_kas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(button_tambahKas)
                .addGap(35, 35, 35))
        );

        HalamanInfoKeuangan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 270, 150));

        getContentPane().add(HalamanInfoKeuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 1250, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        HalamanInfoBeranda.setVisible(true);
        HalamanInfoGuru.setVisible(false);
        HalamanInfoMurid.setVisible(false);
        HalamanInfoKeuangan.setVisible(false);
        HalamanInfoBarang.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        HalamanInfoBeranda.setVisible(false);
        HalamanInfoGuru.setVisible(true);
        HalamanInfoMurid.setVisible(false);
        HalamanInfoKeuangan.setVisible(false);
        HalamanInfoBarang.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        HalamanInfoBeranda.setVisible(false);
        HalamanInfoGuru.setVisible(false);
        HalamanInfoMurid.setVisible(true);
        HalamanInfoKeuangan.setVisible(false);
        HalamanInfoBarang.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        HalamanInfoBeranda.setVisible(false);
        HalamanInfoGuru.setVisible(false);
        HalamanInfoMurid.setVisible(false);
        HalamanInfoKeuangan.setVisible(false);
        HalamanInfoBarang.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        HalamanInfoBeranda.setVisible(false);
        HalamanInfoGuru.setVisible(false);
        HalamanInfoMurid.setVisible(false);
        HalamanInfoKeuangan.setVisible(true);
        HalamanInfoBarang.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void buttonSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSimpanMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonSimpanMouseClicked

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:

        try {
                koneksi DB = new koneksi();
                DB.config();
                con = DB.con;
                stat = DB.stm;
            stat = con.createStatement();
            stat.executeUpdate("INSERT INTO guru VALUES('" + txt_nip.getText() + "','"
                + txt_username.getText() + "','"
                + txt_password.getText()+ "','"
                + txt_nama.getText() + "','"
                + txt_alamat.getText() +"')");
            
            stat.executeUpdate("INSERT INTO peminjaman VALUES('" + txt_kode_peminjaman.getText() + "','"
                + txt_nip.getText() + "','" + 0+ "','" + 0 + "','" + 0 +"')");
            
            
            tampilData("");
            tampilDataPinjaman("");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            txt_nip.setText("");
            txt_username.setText("");
            txt_password.setText("");
            txt_nama.setText("");
            txt_alamat.setText("");
            
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void TabelGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGuruMouseClicked
        // TODO add your handling code here:
        txt_nip.setText(TabelGuru.getValueAt(TabelGuru.getSelectedRow(), 0).toString());
        txt_username.setText(TabelGuru.getValueAt(TabelGuru.getSelectedRow(), 1).toString());
        txt_password.setText(TabelGuru.getValueAt(TabelGuru.getSelectedRow(), 2).toString());
        txt_nama.setText(TabelGuru.getValueAt(TabelGuru.getSelectedRow(), 3).toString());
        txt_alamat.setText(TabelGuru.getValueAt(TabelGuru.getSelectedRow(), 4).toString());
        
        
    }//GEN-LAST:event_TabelGuruMouseClicked

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
              stat = con.createStatement();
              stat.executeUpdate("DELETE FROM guru WHERE nip_guru='"
                  + tabGuru.getValueAt(TabelGuru.getSelectedRow(), 0) + "'");
              
              stat.executeUpdate("DELETE FROM peminjaman WHERE nip_guru='"
                  + tabGuru.getValueAt(TabelGuru.getSelectedRow(), 0) + "'");
              
              tampilData("");
                tampilDataPinjaman("");
              resetAdmin();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        resetAdmin();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_passwordMouseClicked

    private void buttonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateMouseClicked
        // TODO add your handling code here:
        try {
            stat = con.createStatement();
            stat.executeUpdate("UPDATE guru SET " 
                + "nip_guru='"       + txt_nip.getText() + "', "
                + "usrnm_guru='"      + txt_username.getText() + "', "
                + "pass_guru='"   + txt_password.getText()+ "', "
                + "nm_lngkp_guru='"        + txt_nama.getText()+ "', "
                + "almt_guru='"    + txt_alamat.getText() +  "'"
                + "WHERE nip_guru='"    + txt_nip.getText() +"'");
            tampilData("");
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            resetAdmin();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_buttonUpdateMouseClicked

    private void TabelMuridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMuridMouseClicked
        // TODO add your handling code here:
        txt_username_murid.setText(TabelMurid.getValueAt(TabelMurid.getSelectedRow(), 0).toString());
        txt_password_murid.setText(TabelMurid.getValueAt(TabelMurid.getSelectedRow(), 1).toString());
        txt_nama_murid.setText(TabelMurid.getValueAt(TabelMurid.getSelectedRow(), 2).toString());
        txt_alamat_murid.setText(TabelMurid.getValueAt(TabelMurid.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_TabelMuridMouseClicked

    private void ButtonResetMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetMuridActionPerformed
        // TODO add your handling code here:
        resetMurid();
    }//GEN-LAST:event_ButtonResetMuridActionPerformed

    private void ButtonSimpanMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSimpanMuridActionPerformed
        // TODO add your handling code here:
        try {
            stat = con.createStatement();
            stat.executeUpdate("INSERT INTO murid VALUES('"+ txt_username_murid.getText() + "','"
                + txt_password_murid.getText() + "','"
                + txt_nama_murid.getText() + "','"
                + txt_alamat_murid.getText() +"')");
            tampilDataMurid("");
            JOptionPane.showMessageDialog(null, "Simpan Berhasil");
            
            txt_username_murid.setText("");
            txt_password_murid.setText("");
            txt_nama_murid.setText("");
            txt_alamat_murid.setText("");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonSimpanMuridActionPerformed

    private void txt_password_muridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password_muridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password_muridActionPerformed

    private void ButtonHapusMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHapusMuridActionPerformed
        // TODO add your handling code here:
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
              stat = con.createStatement();
              stat.executeUpdate("DELETE FROM murid WHERE usrnm_murid='"
                  + tabMurid.getValueAt(TabelMurid.getSelectedRow(), 0) + "'");
              tampilDataMurid("");
              resetMurid();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonHapusMuridActionPerformed

    private void ButtonUpdateMuridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateMuridActionPerformed
        // TODO add your handling code here:
        try {
            stat = con.createStatement();
            stat.executeUpdate("UPDATE murid SET "
                + "usrnm_murid='"      + txt_username_murid.getText() + "', "
                + "pass_murid='"   + txt_password_murid.getText()+ "', "
                + "nm_lngkp_murid='"        + txt_nama_murid.getText()+ "', "
                + "almt_murid='"    + txt_alamat_murid.getText() +  "'"
                + "WHERE usrnm_murid='"    + txt_username_murid.getText() +"'");
            
            tampilDataMurid("");
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            resetMurid();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonUpdateMuridActionPerformed

    private void ButtonSimpanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSimpanBarangActionPerformed
        // TODO add your handling code here:
       
        try {
            stat = con.createStatement();
            stat.executeUpdate("INSERT INTO barang VALUES('"+ txt_kode_barang.getText() + "','"
                + txt_nama_barang.getText() + "','"
                + txt_stock.getText() + "','"
                + txt_harga.getText() +"')");
            tampilDataBarang("");
            JOptionPane.showMessageDialog(null, "Simpan Berhasil");
            try {
            sql="SELECT * FROM barang ORDER BY kode_barang DESC";
            stat=con.createStatement();
            rs=stat.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kode_barang").substring(1);
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

               txt_kode_barang.setText("B" + Nol + AN);
            } else {
               txt_kode_barang.setText("B0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
            txt_nama_barang.setText("");
            txt_stock.setText("");
            txt_harga.setText("");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonSimpanBarangActionPerformed

    private void TabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBarangMouseClicked
        // TODO add your handling code here:
            txt_kode_barang.setText(TabelBarang.getValueAt(TabelBarang.getSelectedRow(), 0).toString());
            txt_nama_barang.setText(TabelBarang.getValueAt(TabelBarang.getSelectedRow(), 1).toString());
            txt_stock.setText(TabelBarang.getValueAt(TabelBarang.getSelectedRow(), 2).toString());
            txt_harga.setText(TabelBarang.getValueAt(TabelBarang.getSelectedRow(), 3).toString());
            
    }//GEN-LAST:event_TabelBarangMouseClicked

    private void txt_kode_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kode_barangActionPerformed

    }//GEN-LAST:event_txt_kode_barangActionPerformed

    private void ButtonHapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHapusBarangActionPerformed
        // TODO add your handling code here:
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
              stat = con.createStatement();
              stat.executeUpdate("DELETE FROM barang WHERE kode_barang='"
                  + tabBarang.getValueAt(TabelBarang.getSelectedRow(), 0) + "'");
              tampilDataBarang("");
              resetBarang();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonHapusBarangActionPerformed

    private void ButtonResetBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetBarangActionPerformed
        // TODO add your handling code here:
        resetBarang();
    }//GEN-LAST:event_ButtonResetBarangActionPerformed

    private void ButtonUpdateBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateBarangActionPerformed
        // TODO add +your handling code here:
        try {
            stat = con.createStatement();
            stat.executeUpdate("UPDATE barang SET "
                + "kode_barang='"      + txt_kode_barang.getText() + "', "
                + "nama_barang='"   + txt_nama_barang.getText()+ "', "
                + "jumlah_barang='"        + txt_stock.getText()+ "', "
                + "Harga='"    + txt_harga.getText() +  "'"
                + "WHERE kode_barang='"    + txt_kode_barang.getText() +"'");
            
            tampilDataBarang("");
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            resetBarang();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_ButtonUpdateBarangActionPerformed

    private void button_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_keluarMouseClicked
        // TODO add your handling code here:
        doExit();

    }//GEN-LAST:event_button_keluarMouseClicked

    private void button_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_keluarActionPerformed
        // TODO add your handling code here:
        doExit();
    }//GEN-LAST:event_button_keluarActionPerformed

    private void button_tambahKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tambahKasActionPerformed
        // TODO add your handling code here:
        String a = txt_tambah_kas.getText();
        int b = Integer.parseInt(a);
        
        String c = txt_kas.getText();
        int d = Integer.parseInt(c);
        int e = d+b;
        String f = Integer.toString(e);
        
        try {
            stat = con.createStatement();
            stat.executeUpdate("UPDATE keuangan SET "
                + "kas='"      + f + "'");
            
            
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            txt_tambah_kas.setText("");
           
           tampilKas();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        
    }//GEN-LAST:event_button_tambahKasActionPerformed

    private void txt_kode_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kode_peminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kode_peminjamanActionPerformed

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
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
          public void run(){
        }
          });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Beranda;
    private javax.swing.JButton ButtonHapusBarang;
    private javax.swing.JButton ButtonHapusMurid;
    private javax.swing.JButton ButtonResetBarang;
    private javax.swing.JButton ButtonResetMurid;
    private javax.swing.JButton ButtonSimpanBarang;
    private javax.swing.JButton ButtonSimpanMurid;
    private javax.swing.JButton ButtonUpdateBarang;
    private javax.swing.JButton ButtonUpdateMurid;
    private javax.swing.JPanel HalamanInfoBarang;
    private javax.swing.JPanel HalamanInfoBeranda;
    private javax.swing.JPanel HalamanInfoGuru;
    private javax.swing.JPanel HalamanInfoKeuangan;
    private javax.swing.JPanel HalamanInfoMurid;
    private javax.swing.JPanel InfoBarang;
    private javax.swing.JPanel InfoGuru;
    private javax.swing.JPanel InfoKeuangan;
    private javax.swing.JPanel InfoMurid;
    private javax.swing.JTable TabelBarang;
    private javax.swing.JTable TabelGuru;
    private javax.swing.JTable TabelKeuangan;
    private javax.swing.JTable TabelMurid;
    private javax.swing.JLabel alamat;
    private javax.swing.JPanel atas;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton button_keluar;
    private javax.swing.JButton button_tambahKas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel kiri;
    private javax.swing.JLabel masuk;
    private javax.swing.JLabel nama;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextArea txt_alamat_murid;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_kas;
    private javax.swing.JTextField txt_kode_barang;
    private javax.swing.JTextField txt_kode_peminjaman;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JTextField txt_nama_murid;
    private javax.swing.JTextField txt_nip;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_password_murid;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_tambah_kas;
    private javax.swing.JTextField txt_username;
    private javax.swing.JTextField txt_username_murid;
    // End of variables declaration//GEN-END:variables
}
