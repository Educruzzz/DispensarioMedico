/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Medicos {
    
    
    
    private int idMedico, Cedula;
    private String Nombre, Especialidad, Tanda, Estado;

    public Medicos(int idMedico, int Cedula, String Nombre, String Especialidad, String Tanda, String Estado) {
        this.idMedico = idMedico;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Especialidad = Especialidad;
        this.Tanda = Tanda;
        this.Estado = Estado;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getTanda() {
        return Tanda;
    }

    public void setTanda(String Tanda) {
        this.Tanda = Tanda;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}

