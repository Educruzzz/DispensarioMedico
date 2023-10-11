/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia ();
    
    public void crearMedicamento (Medicamentos med) {
        
        controlPersis.crearMedicamento(med);
         
    }
    
    public List<Medicamentos> traerMedicamentos (){
        
        return controlPersis.traerMedicamentos();
        
    }
    
}
