<%-- 
    Document   : Medicamentos
    Created on : Oct 9, 2023, 8:48:12 PM
    Author     : DELL
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Medicamentos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Medicamento</title>
    </head>
    <body>
        <h1>Mostrar Medicamentos</h1>
        <form action="SvMedicamentos" method="POST">
            <label>Marca</label><input type="text" name="marca">
        </form>
        <%
            List<Medicamentos> listarMedicamentos = (List) request.getSession().getAttribute("listarMedicamentos");
            int contador = 1;
                for(Medicamentos med : listarMedicamentos){
        %> 
            <h2>Medicamentos existentes</h2>
            <p>ID: <% med.getId(); %> </p>
            <p>idMedicamento: <% med.getIdMedicamento(); %> </p>
            <p>Marca: <% med.getMarca(); %> </p>
            <p>Descripcion: <% med.getDescripcion(); %> </p>
            <p>Farmaco: <% med.getFarmaco(); %> </p>
            <p>Dosis: <% med.getDosis(); %> </p>
            <p>Ubicacion: <% med.getUbicacion(); %> </p>
            
            
            <% contador = contador + 1;%>
            

        <%        
                    
                
                }
               
        %>
    </body>
</html>
