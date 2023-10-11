
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Medicamentos implements Serializable {
    
    @Id
    
    private int idMedicamento, id;
    private String Descripcion, Marca, Farmaco, Ubicacion;
    private double Dosis;
    private boolean Estado;

    public Medicamentos() {
        
    }
    
    public Medicamentos(int idMedicamento, int id, String Descripcion, String Marca, String Farmaco, String Ubicacion, double Dosis, boolean Estado) {
        this.idMedicamento = idMedicamento;
        this.id = id;
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.Farmaco = Farmaco;
        this.Ubicacion = Ubicacion;
        this.Dosis = Dosis;
        this.Estado = Estado;
    }
    
    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getFarmaco() {
        return Farmaco;
    }

    public void setFarmaco(String Farmaco) {
        this.Farmaco = Farmaco;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public double getDosis() {
        return Dosis;
    }

    public void setDosis(double Dosis) {
        this.Dosis = Dosis;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
}
    

   