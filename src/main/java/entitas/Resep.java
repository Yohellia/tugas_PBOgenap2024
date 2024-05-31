/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitas;

import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ACER TRAVELMATE
 */
public final class Resep extends Database {
    public int id_resep;
    public String tanggal_resep;
    public String pasien_id_pasien;
    public String apoteker_id_apoteker;
    
    
    public final boolean create() throws ParseException {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "INSERT INTO resep VALUES (?, ?, ?, ?)";
            this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            this.preparedStatement.setInt(1, this.id_resep);
            
            // Konversi String ke java.sql.Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
                java.util.Date parsedDate = dateFormat.parse(this.tanggal_resep);
                java.sql.Date tanggalDate = new java.sql.Date(parsedDate.getTime());

            this.preparedStatement.setDate(2, tanggalDate);
            this.preparedStatement.setString(3, this.pasien_id_pasien);
            this.preparedStatement.setString(4, this.apoteker_id_apoteker);
            
            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        return isOperationSuccess;
    }
    

    public final boolean update() throws ParseException {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "DELETE FROM resep WHERE id_resep = ?; ";
                    
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, this.id_resep);
            
            int result = this.preparedStatement.executeUpdate();
            
            this.create();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        return isOperationSuccess;
    }
    

    public final boolean delete(int id) {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "DELETE FROM resep WHERE id_resep = ?";
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
