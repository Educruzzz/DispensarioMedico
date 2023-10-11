
package Persistencia;

import java.util.List;
import modelo.Medicamentos;

public class ControladoraPersistencia {
 
    MedicamentosJpaController medJpa = new MedicamentosJpaController();
    
      public void crearMedicamento (Medicamentos med) {
    
        medJpa.create(med);
        
    }
    
    public List<Medicamentos> traerMedicamentos (){
        return medJpa.findMedicamentosEntities();
    
      
        }
    
}
