package uas;


import java.sql.*; //fungsi untuk memasukkan komponen sql
//import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class BarangJFrame extends javax.swing.JFrame {

 
    public Statement st;    //fungsi untuk mengaktifkan perintah sql
    public ResultSet rs;    //fungsi untuk mengeksekusi perintah sql
    Connection aam = uas.KoneksiDatabase.BukaKoneksi(); //fungsi untuk melakukan koneksi ke database mysql
    public BarangJFrame() {
        initComponents();
        TampilData();
    }
    
       
    //fungsi untuk membersihkan teks
    private void Bersih(){
        txtkode.setText("");
        txtnama.setText("");
        txtharga.setText("");
        txtjenis.setText("");
        txtstok.setText("");
        btnsimpan.setText("Simpan");
        txtkode.setEditable(true);
    }
    
    //fungsi untuk mencari data dari tabel di database mysql
    private void CariData(){
        try {
            st = aam.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_barang WHERE "
                    + cmbcari.getSelectedItem().toString()+
                    " LIKE '%" + txtcari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("harga");
            model.addColumn("jenis");
            model.addColumn("stok");

            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("harga"),
                  rs.getString("jenis"),
                  rs.getString("stok")
                };
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (Exception e) {
        }
    }
    

    //fungsi untuk menampilkan data dari tabel di database mysql
    private void TampilData(){
        try {
            st = aam.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_barang");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("harga");
            model.addColumn("jenis");
            model.addColumn("stok");

            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("harga"),
                  rs.getString("jenis"),
                  rs.getString("stok")
                };
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbcari = new javax.swing.JComboBox<>();
        txtcari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtkode = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Data Barang");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "kode", "nama", "harga", "stok"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 380, 617, 171));

        jLabel6.setText("Cari data");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 343, -1, -1));

        cmbcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode", "nama" }));
        getContentPane().add(cmbcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 340, 112, -1));

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 340, 282, -1));

        jPanel2.setBackground(new java.awt.Color(255, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        jPanel2.add(txtkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 260, -1));
        jPanel2.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 260, -1));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 260, -1));
        jPanel2.add(txtjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 260, -1));
        jPanel2.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 260, -1));

        jLabel5.setText("Jenis Barang  :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel8.setText("Jumlah Stok   :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel2.setText("Nama Barang  :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setText("Kode Barang    :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        jLabel4.setText("Harga Barang  :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, 20));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 126, -1));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 130, -1));

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        jPanel2.add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 580));

        jLabel7.setText("Jumlah Stok   :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 240, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = aam.createStatement();
            //fungsi cek data yang di simpan tidak boleh kosong
            if (txtkode.getText().equals("")|| 
                    txtnama.getText().equals("")||
                    txtharga.getText().equals("")||
                    txtjenis.getText().equals("")||
                    txtstok.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong","Informasi", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //fungsi simpan data ke database
            if (btnsimpan.getText()=="Simpan") {
                //fungsi untuk mengecek data kode barang
                String cek ="SELECT * FROM tbl_barang WHERE kode = '" + txtkode.getText()+"'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,"Kode Barang Sudah dipakai");
                }else{
                    //fungsi untuk menyimpan data ke tabel
                    String sql = "INSERT INTO tbl_barang VALUES('" + txtkode.getText()+
                            "','"+txtnama.getText() +
                            "','"+txtharga.getText() +
                            "','"+txtjenis.getText() +
                            "','"+txtstok.getText() + "' )";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data Barang Berhasil disimpan");
                    Bersih();
                    TampilData();
                }
            }else{
                //fungsi untuk mengubah Data
                String Update = "UPDATE tblbarang SET nama ='" + txtnama.getText() +
                        "', harga ='" +txtharga.getText()+
                         "', jenis ='" +txtjenis.getText()+
                        "', stok ='" +txtstok.getText()+
                        "' WHERE kode ='" +txtkode.getText()+"'";
                st.executeUpdate(Update);
                    JOptionPane.showMessageDialog(null,"Data Barang Berhasil diubah");
                Bersih();
                TampilData();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        // TODO add your handling code here:
        txtkode.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 1).toString());
        txtnama.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 2).toString());
        txtharga.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 3).toString());
        txtjenis.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
        txtstok.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
        txtkode.setEditable(false);
        btnsimpan.setText("Ubah");
    }//GEN-LAST:event_tbldataMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        //fungsi untuk menghapus data di tabel dari database
        if (txtkode.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Pilih data yang ingin dihapus");
        }else{
             int jawab = JOptionPane.showConfirmDialog(null,"Data ini akan dihapus, lanjutkan","Konfirmasi", JOptionPane.YES_NO_OPTION);
             if (jawab ==0) {
                 try {
                     st = aam.createStatement();
                     String sql = "DELETE FROM tbl_barang WHERE kode = '"+ txtkode.getText()+"'";
                     st.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                     TampilData();
                     Bersih();
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null,e);
                     
                 }
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // fungsi untuk membersihkan data di halaman aplikasi
        Bersih();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // fungsi untuk melakukan pencarian data pada tabel di halaman aplikasi
        CariData();
    }//GEN-LAST:event_txtcariKeyPressed

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

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
            java.util.logging.Logger.getLogger(BarangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbcari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel DefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
