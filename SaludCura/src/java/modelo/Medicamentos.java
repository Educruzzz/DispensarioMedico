/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DELL
 */
public class Medicamentos {
    
    private int idMedicamento;
    private String Descripcion, Marca, Farmaco, Ubicacion;
    private double Dosis;
    private boolean Estado;

    
    public Medicamentos(int idMedicamento, String Descripcion, String Marca, String Farmaco, String Ubicacion, double Dosis, boolean Estado) {
        
        this.idMedicamento = idMedicamento;
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

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public double getDosis() {
        return Dosis;
    }

    public void setDosis(double Dosis) {
        this.Dosis = Dosis;
    }

}


