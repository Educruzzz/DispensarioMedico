
package modelo;


//import java.sql.DatabaseConnection;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentosDAO {
    
    private Connection connection;
    
    public MedicamentosDAO(){
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
   
        if (connection == null) {
        throw new RuntimeException("Error: La conexión a la base de datos no se inicializó correctamente.");
    }
 }
    
    public List<Medicamentos> getMedicamentos(){
        PreparedStatement ps;
        ResultSet rs;
        
        List<Medicamentos> list = new ArrayList<>();
        
        try {
            ps = connection.prepareStatement("SELECT IDMEDICAMENTO, MARCA, DESCRIPCION, FARMACO, UBICACION, ESTADO, DOSIS FROM MEDICAMENTO");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int idMedicamento = rs.getInt("idMedicamento");
                String Marca = rs.getString("Marca");
                String Descripcion = rs.getString("Descripcion");
                String Ubicacion = rs.getString("Ubicacion");
                String Farmaco = rs.getString("Farmaco");
                boolean Estado = rs.getBoolean("Estado");
                double Dosis = rs.getDouble("Dosis");
                                
                Medicamentos medicamento = new Medicamentos(idMedicamento, Marca, Descripcion, Ubicacion, Farmaco, Dosis, Estado);
                list.add(medicamento);
                
            }
        
            } catch (SQLException e) {
            e.printStackTrace();
            }
            
            return list;
          

    }
    
    // Mostrar los medicamentos existentes
    
     public Medicamentos mostarMedicamentos(int _idMedicamento) {

        PreparedStatement ps;
        ResultSet rs;
        Medicamentos medicamento = null;

        List<Medicamentos> lista = new ArrayList<>();

        try {
            ps = connection.prepareStatement("SELECT IDMEDICAMENTO, MARCA, DESCRIPCION, FARMACO, UBICACION, ESTADO, DOSIS FROM MEDICAMENTO\n" +
"");
            ps.setInt(1, _idMedicamento);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idMedicamento = rs.getInt("idMedicamento");
                String Marca = rs.getString("Marca");
                String Descripcion = rs.getString("Descripcion");
                String Ubicacion = rs.getString("Ubicacion");
                String Farmaco = rs.getString("Farmaco");
                boolean Estado = rs.getBoolean("Estado");
                double Dosis = rs.getDouble("Dosis");

                medicamento = new Medicamentos(idMedicamento, Marca, Descripcion, Ubicacion, Farmaco, Dosis, Estado);  
            
            }
            return medicamento;
            
        } catch (SQLException e) {
            System.out.println("Error al mostrar producto: " + e.toString());
            return null;
        }
    }
    
    // insertar un nuevo medicamento
     
     public boolean insertar(Medicamentos medicamento) {

        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("INSERT INTO MEDICAMENTO (idMedicamento, Marca, Descripcion, Farmaco, Ubicacion, Estado, Dosis) VALUES (?,?,?,?,?,?,?)");
            
            ps.setInt(1, medicamento.getIdMedicamento());
            ps.setString(2, medicamento.getMarca());
            ps.setString(3, medicamento.getDescripcion());
            ps.setString(4, medicamento.getFarmaco());
            ps.setString(5, medicamento.getUbicacion());
            ps.setBoolean(6, medicamento.getEstado());
            ps.setDouble(7, medicamento.getDosis());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.toString());
            return false;
        }
    }
     
     
    // Actualizar los medicamentos almacenados
     
     
     public boolean actualizar(Medicamentos medicamento) {

        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("UPDATE MEDICAMENTO SET idMedicamento=?, Marca=?, Descripcion=?, Farmaco=?, Ubicacion=?, Estado=?, Dosis=? WHERE idMedicamento=?");
            
            ps.setInt(1, medicamento.getIdMedicamento());
            ps.setString(2, medicamento.getMarca());
            ps.setString(3, medicamento.getDescripcion());
            ps.setString(4, medicamento.getFarmaco());
            ps.setString(5, medicamento.getUbicacion());
            ps.setBoolean(6, medicamento.getEstado());
            ps.setDouble(7, medicamento.getDosis());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
     
    
    // Eliminar los medicamentos no existentes
        
        public boolean eliminar(int _idMedicamento) {

        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("DELETE FROM MEDICAMENTO WHERE idMedicamento=?");
            ps.setInt(1, _idMedicamento);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.toString());
            return false;
        }
    }
     
}
