/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitas;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER TRAVELMATE
 */
public final class Cair extends Obat{
    public String mL;
    
    @Override
    public final boolean create() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "INSERT INTO cair VALUES (?,?)";
            this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            this.preparedStatement.setInt(1, this.id);
            this.preparedStatement.setString(2, this.mL);

            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        return isOperationSuccess;
    }
    
    @Override
    public final boolean update() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "UPDATE cair SET mL = ? WHERE id_obat = ?";
            
            this.preparedStatement = this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, this.mL);
            this.preparedStatement.setInt(2, this.id);
            
            int result = this.preparedStatement.executeUpdate();
            
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        return isOperationSuccess;
    }
    
    @Override
    public final boolean delete(int id) {
        boolean isOperationSuccess = false;

        try {
            this.openConnection();

            String sql = "DELETE FROM cair WHERE id_obat = ?";
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
