/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitas;

import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author ACER TRAVELMATE
 */
public final class Pasien extends Database{
    public int id_pasien;
    public String nama_pasien;
    public String alamat;
    public String nomorTelepon;
    public String email;

    
    public final boolean create() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "INSERT INTO pasien VALUES (?, ?, ?, ?, ?)";
            this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            this.preparedStatement.setInt(1, this.id_pasien);
            this.preparedStatement.setString(2, this.nama_pasien);
            this.preparedStatement.setString(3, this.alamat);
            this.preparedStatement.setString(4, this.nomorTelepon);
            this.preparedStatement.setString(5, this.email);
            
            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        } finally {
            this.closeConnection();
        }
        
        return isOperationSuccess;
        }
        
    public final boolean update() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "UPDATE pasien "
                    + "SET nama_pasien = ?, "
                    + "alamat = ?,"
                    + "email = ?, "
                    + "no_telpn = ? "
                    + "WHERE id_pasien = ?";
            
            this.preparedStatement = this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, this.nama_pasien);
            this.preparedStatement.setString(2, this.alamat);
            this.preparedStatement.setString(3, this.email);
            this.preparedStatement.setString(4, this.nomorTelepon);
            this.preparedStatement.setInt(5, this.id_pasien);
            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        } finally {
            this.closeConnection();
        }
        
        return isOperationSuccess;
    }
        
    public final boolean delete(int id) {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "DELETE FROM pasien WHERE id_pasien = ?";
            this.preparedStatement = this.connection.prepareStatement(sql);

            this.preparedStatement.setInt(1, id);

            int result = this.preparedStatement.executeUpdate();

            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        } finally {
            this.closeConnection();
        }

        return isOperationSuccess;
    }



}
