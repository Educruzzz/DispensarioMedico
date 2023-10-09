
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Medicamentos;
import modelo.MedicamentosDAO;


/**
 *
 * @author Keysi Ramirez
 */


@WebServlet(name = "MedicamentosController", urlPatterns = {"/MedicamentosController"})
public class MedicamentosController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MedicamentosDAO medicamentosDAO = new MedicamentosDAO(); // para ejecutar el constructor
        String accion; 
        RequestDispatcher dispatcher = null;//Indicar la vista a mostrar
        
        
        accion = request.getParameter("accion"); // Atibutos al servlet
    
        if(accion == null || accion.isEmpty()){
        
            dispatcher = request.getRequestDispatcher("WEB-INF/Medicamentos.html");
            
            List<Medicamentos> listarMedicamentos = medicamentosDAO.getMedicamentos();
            request.setAttribute("Lista", listarMedicamentos); // listar la tabla de los medicamentos
            
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/Medicamentos.html");
            
            
        }   else if (accion.equals("insertar")) {
            int idMedicamento = Integer.parseInt(request.getParameter("idMedicamento"));
            String Marca = request.getParameter("Marca");
            String Descripcion = request.getParameter("Descripcion");
            String Ubicacion = request.getParameter("Ubicacion");
            String Farmaco = request.getParameter("Farmaco");
            boolean Estado = Boolean.getBoolean(request.getParameter("Estado"));
            Double Dosis = Double.parseDouble(request.getParameter("Dosis"));
            
            Medicamentos medicamento = new Medicamentos(idMedicamento, Marca, Descripcion, Ubicacion, Farmaco, Dosis, Estado);
            MedicamentosDAO.insertar(Medicamentos medicamento);

            dispatcher = request.getRequestDispatcher("WEB-INF/Medicamentos.html");
            List<Medicamentos> listarMedicamentos = medicamentosDAO.getMedicamentos();            
            request.setAttribute("lista", listarMedicamentos);

        } else if (accion.equals("Mostrar Medicamento")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/Medicamentos.html");
            int id = Integer.parseInt(request.getParameter("idMedicamento"));
            Medicamentos medicamento = MedicamentosDAO.getMedicamentos(medicamento);
            request.setAttribute("medicamento", medicamento);

        } else if (accion.equals("actualizar")) {
            
            int idMedicamento = Integer.parseInt(request.getParameter("idMedicamento"));
            String Marca = request.getParameter("Marca");
            String Descripcion = request.getParameter("Descripcion");
            String Ubicacion = request.getParameter("Ubicacion");
            String Farmaco = request.getParameter("Farmaco");
            boolean Estado = Boolean.getBoolean(request.getParameter("Estado"));
            Double Dosis = Double.parseDouble(request.getParameter("Dosis"));
            Medicamentos medicamento = new Medicamentos(idMedicamento, Marca, Descripcion, Ubicacion, Farmaco, Dosis, Estado);
            MedicamentosDAO.actualizar(medicamento);

            dispatcher = request.getRequestDispatcher("WEB-INF/Medicamentos.html");
            List<Medicamentos> listarMedicamentos = medicamentosDAO.getMedicamentos();            
            request.setAttribute("lista", listarMedicamentos);

        } else if (accion.equals("eliminar")) {

            int idMedicamento = Integer.parseInt(request.getParameter("idMedicamento"));

            MedicamentosDAO.eliminar(idMedicamento);
            
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            
            List<Medicamentos> listarMedicamentos = medicamentosDAO.getMedicamentos();            
            request.setAttribute("lista", listarMedicamentos);
            
        } else {
            
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            
            List<Medicamentos> listarMedicamentos = medicamentosDAO.getMedicamentos();            
            request.setAttribute("lista", listarMedicamentos);
        }

        dispatcher.forward(request, response);
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
