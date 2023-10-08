
package config;

/**
 *
 * @author DELL
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion {
   
    
    public conexion getConnection(){
        try {
    String myBD = /*aca la URL de la BD */ "jdbc:derby://localhost:1527/DispensarioMedico";
            java.sql.Connection con = DriverManager.getConnection(myBD,"root", "1234" );
    return (conexion) con;
    
    } catch(SQLException e){
        
        System.out.println(e.toString());
        return null;
    }
  }  

    public PreparedStatement prepareStatement(String select_idvehicle_Caption_VIN_MotorNo_VLP_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


