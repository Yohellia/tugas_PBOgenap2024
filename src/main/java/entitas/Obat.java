/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitas;

import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
/**
 *
 * @author ACER TRAVELMATE
 */
public class Obat extends Database{
    public int id;
    public String nama_obat;
    public String stok;
    public String tanggal_kadaluarsa;
    public String apoteker_id_apoteker;
    
        public boolean create() {
            boolean isOperationSuccess = false;

            try {
                this.openConnection();

                String sql = "INSERT INTO obat (id_obat, nama_obat, stok, tanggal_kadaluarsa,apoteker_id_apoteker) VALUES (?, ?, ?, ?,?)";
                this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                this.preparedStatement.setInt(1, this.id);
                this.preparedStatement.setString(2, this.nama_obat);
                this.preparedStatement.setString(3, this.stok);

                // Konversi String ke java.sql.Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
                java.util.Date parsedDate = dateFormat.parse(this.tanggal_kadaluarsa);
                java.sql.Date tanggalDate = new java.sql.Date(parsedDate.getTime());

                this.preparedStatement.setDate(4, tanggalDate);
                this.preparedStatement.setString(5,apoteker_id_apoteker );

                int result = this.preparedStatement.executeUpdate();

                isOperationSuccess = result > 0;
            } catch (SQLException | ParseException ex) {
                this.displayErrors((SQLException) ex);
            } 
            return isOperationSuccess;
            }
        
    public boolean find(String columnName, String value) {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String query = "SELECT * FROM obat WHERE " + columnName + " = ?";
            this.preparedStatement = this.connection.prepareStatement(query);

            this.preparedStatement.setString(1, value);

            this.resultSet = this.preparedStatement.executeQuery();

            if (this.resultSet.next()) {
                this.id = this.resultSet.getInt("id_obat");
                this.nama_obat = this.resultSet.getString("nama_obat");
                this.stok = this.resultSet.getString("stok");
                this.tanggal_kadaluarsa = this.resultSet.getString("tanggal_kadaluarsa");
                this.apoteker_id_apoteker = this.resultSet.getString("apoteker_id_apoteker");

                isOperationSuccess = true;
            }
        } catch (SQLException ex) {
            this.displayErrors(ex);
        } 
        return isOperationSuccess;
    }

        
        public boolean update() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "UPDATE obat "
                    + "SET nama_obat = ?, "
                    + "stok = ?,"
                    + "tanggal_kadaluarsa = ?, "
                    + "apoteker_id_apoteker = ? "
                    + "WHERE id_obat = ?";
            
            this.preparedStatement = this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, this.nama_obat);
            this.preparedStatement.setString(2, this.stok);
            this.preparedStatement.setString(3, this.tanggal_kadaluarsa);
            this.preparedStatement.setString(4, this.apoteker_id_apoteker);
            this.preparedStatement.setInt(5, this.id);
            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }         
        return isOperationSuccess;
    }
    
        public boolean delete(int id) {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "DELETE FROM obat WHERE id_obat = ?";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);

            int result = this.preparedStatement.executeUpdate();

            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        return isOperationSuccess;
    }
}