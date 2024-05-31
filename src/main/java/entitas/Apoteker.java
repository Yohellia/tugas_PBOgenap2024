
package entitas;
import java.sql.Statement;
import java.sql.SQLException;


/**
 *
 * @author ACER TRAVELMATE
 */
public final class Apoteker extends Database {
    public int id;
    public String nama;
    public String alamat;
    public String email;
    public String nomorTelepon;
    

    public final boolean create() {
        boolean isOperationSuccess = false;
        
        try {
            this.openConnection();
            
            String sql = "INSERT INTO Apoteker VALUES (?, ?, ?, ?, ?,Null)";
            this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            this.preparedStatement.setInt(1, this.id);
            this.preparedStatement.setString(2, this.nama);
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
            
            String sql = "UPDATE apoteker "
                    + "SET nama = ?, "
                    + "alamat = ?,"
                    + "email = ?, "
                    + "no_telpn = ? "
                    + "WHERE id_apoteker = ?";
            
            this.preparedStatement = this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, this.nama);
            this.preparedStatement.setString(2, this.alamat);
            this.preparedStatement.setString(3, this.email);
            this.preparedStatement.setString(4, this.nomorTelepon);
            this.preparedStatement.setInt(5, this.id);
            
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

            String sql = "DELETE FROM Apoteker WHERE id_apoteker = ?";
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