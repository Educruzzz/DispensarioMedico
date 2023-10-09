
package config;

/**
 *
 * @author DELL
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    
    public java.sql.Connection getConnection() {
        try {
            String myBD = "jdbc:mysql://localhost:3306/dispensariomedico?zeroDateTimeBehavior=convertToNull";
            java.sql.Connection con = DriverManager.getConnection(myBD, "root", "1234");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}

