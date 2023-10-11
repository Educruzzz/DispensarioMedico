
package controlador;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Controladora;
import modelo.Medicamentos;


@WebServlet(name = "MedicamentosController", urlPatterns = {"/MedicamentosController"})
public class SvMedicamentos extends HttpServlet {
Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Medicamentos> listarMedicamentos = new ArrayList<>();
              
            listarMedicamentos = control.traerMedicamentos();
        
            HttpSession misesion = request.getSession();
            misesion.setAttribute("Medicamentos", listarMedicamentos);
            response.sendRedirect("MostrarMedicamentos.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
            int id = Integer.parseInt(request.getParameter("id"));
            int idMedicamento = Integer.parseInt(request.getParameter("idMedicamento"));
            String Marca = request.getParameter("Marca");
            String Descripcion = request.getParameter("Descripcion");
            String Ubicacion = request.getParameter("Ubicacion");
            String Farmaco = request.getParameter("Farmaco");
            boolean Estado = Boolean.getBoolean(request.getParameter("Estado"));
            Double Dosis = Double.parseDouble(request.getParameter("Dosis")); 
        
        Medicamentos med = new Medicamentos();
        
        med.setId(id); 
        med.setIdMedicamento(idMedicamento);
        med.setMarca(Marca);
        med.setDescripcion(Descripcion);
        med.setUbicacion(Ubicacion);
        med.setEstado(Estado);
        med.setDosis(Dosis);
        
        control.crearMedicamento(med);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
