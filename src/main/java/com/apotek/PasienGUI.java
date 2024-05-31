package com.apotek;

import entitas.Database;
import entitas.Pasien;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ACER TRAVELMATE
 */
public class PasienGUI extends javax.swing.JFrame {
    private Database db;
    /**
     * Creates new form Pasien
     */
        
    private void populateTable() {
       DefaultTableModel model = (DefaultTableModel) tblApoteker.getModel();
       model.setRowCount(0); // Mengosongkan tabel
       model.setColumnIdentifiers(new Object[]{"ID Pasien", "Nama", "Alamat", "No. Telepon","E-mail"});

       try {
            Database db = new Database();
            db.openConnection();
            db.statement = db.connection.createStatement();

            String query = "SELECT * FROM pasien";
            ResultSet resultSet = db.statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pasien");
                String nama = resultSet.getString("nama_pasien");
                String alamat = resultSet.getString("alamat");
                String telpn = resultSet.getString("No_telpn");
                String email = resultSet.getString("email");

                model.addRow(new Object[]{id, nama, alamat, telpn,email});
            }

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions
        }    
    }
    
    private boolean isIdDuplicate(String id) {
        try {
            Database db = new Database();
            db.openConnection();
            db.statement = db.connection.createStatement();

            String query = "SELECT * FROM pasien WHERE id_pasien = " + id;
            ResultSet resultSet = db.statement.executeQuery(query);

            return resultSet.next(); // Mengembalikan true jika ID sudah ada, false jika belum ada

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions
        } finally {
            db.closeConnection();
        }

        return false;
    }
    
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void clearFields() {
        txtID.setText("");
        txtNAMA.setText("");
        txtALAMAT.setText("");
        txtTELP.setText("");
        txtEMAIL.setText("");
    }
    
    public PasienGUI() {
        initComponents();
        db = new Database(); // Inisialisasi objek Database
        db.openConnection(); // Buka koneksi database
        populateTable();
        clearFields();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNAMA = new javax.swing.JTextField();
        txtALAMAT = new javax.swing.JTextField();
        txtTELP = new javax.swing.JTextField();
        txtEMAIL = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblApoteker = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        Kembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Data Pasien");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 210, 90));

        jLabel3.setText("ID Pasien");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        jLabel4.setText("Nama");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 20));

        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 70, 20));

        jLabel6.setText("No. Telepon");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 70, 20));

        jLabel7.setText("Alamat");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 20));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, -1));
        getContentPane().add(txtNAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 180, -1));
        getContentPane().add(txtALAMAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 210, -1));
        getContentPane().add(txtTELP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 140, -1));
        getContentPane().add(txtEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 140, -1));

        btnTambah.setText("Tambah Data");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        tblApoteker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblApoteker.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblApoteker);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 600, 110));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 60, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });
        getContentPane().add(Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/curd.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        // TODO add your handling code here:
        this.dispose(); // Menutup jendela login
        MenuApotekerGUI mainMenu = new MenuApotekerGUI();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_KembaliActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String id_pasien = txtID.getText();
        
        String nama = txtNAMA.getText();
        String alamat = txtALAMAT.getText();
        String email = txtEMAIL.getText();
        String nomorTelepon = txtTELP.getText();
        // Memeriksa apakah ID sudah ada dalam database
        if (isIdDuplicate(id_pasien)) {
            JOptionPane.showMessageDialog(this, "ID sudah ada dalam database.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Validasi input, pastikan tidak ada input yang kosong
        if (nama.isEmpty() || alamat.isEmpty() || email.isEmpty() || nomorTelepon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!isInteger(id_pasien)) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!isInteger(nomorTelepon)) {
            JOptionPane.showMessageDialog(this, "No. Telepon harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(id_pasien);
            // Buat objek ApotekerGUI dan isi dengan data yang diambil dari GUI
            Pasien pasien = new Pasien();
            pasien.id_pasien = id;
            pasien.nama_pasien = nama;
            pasien.alamat = alamat;
            pasien.email = email;
            pasien.nomorTelepon = nomorTelepon;
            
            // Tambahkan data ke database
            if (pasien.create()) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Bersihkan input setelah berhasil menambahkan data
                clearFields();
                // Perbarui tabel setelah menambahkan data baru
                populateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan data.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String id_pasien = txtID.getText();

        // Validasi input, pastikan ID yang akan dihapus tidak kosong
        if (id_pasien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Obat harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!isInteger(id_pasien)) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }


        try {
            int id = Integer.parseInt(id_pasien);

            Pasien pasien = new Pasien();

            // Hapus data berdasarkan ID
           if (pasien.delete(id)) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Bersihkan input setelah berhasil menghapus data
                clearFields();
                // Perbarui tabel setelah menghapus data
                populateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String id_pasien = txtID.getText();
        int id = Integer.parseInt(id_pasien);
        String nama = txtNAMA.getText();
        String alamat = txtALAMAT.getText();
        String email = txtEMAIL.getText();
        String nomorTelepon = txtTELP.getText();
        
        if (id_pasien.isEmpty() || nama.isEmpty() || alamat.isEmpty() || email.isEmpty() || nomorTelepon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!isInteger(id_pasien)) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!isInteger(nomorTelepon)) {
            JOptionPane.showMessageDialog(this, "No. Telepon harus berupa angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {

            Pasien pasien = new Pasien();
            pasien.id_pasien = id;
            pasien.nama_pasien = nama;
            pasien.alamat = alamat;
            pasien.email = email;
            pasien.nomorTelepon = nomorTelepon;

            // Coba mengupdate data dalam database
            if (pasien.update()) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Bersihkan input setelah berhasil mengupdate data
                clearFields();
                // Perbarui tabel setelah mengupdate data
                populateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }      
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(PasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasienGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kembali;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblApoteker;
    private javax.swing.JTextField txtALAMAT;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtTELP;
    // End of variables declaration//GEN-END:variables
}
