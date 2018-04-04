<%-- 
    Document   : formulario
    Created on : 4/04/2018, 01:38:29 PM
    Author     : Argos
--%>

<%@page import="com.gobay.model.Transaccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GoBay</title>
    </head>
    <body>
        <h1>GoBay! Transaction  Completed</h1>
        
        <%
            
            Transaccion t = (Transaccion) request.getAttribute("detalle");
            
            %>
        
        <table border="1">
            <thead>
                <tr>
                    <th colspan="2">Datos de envio</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Nombre:</td>
                    <td><%= t.getName() %></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><%= t.getApellido() %></td>
                </tr>
                <tr>
                    <td>Direccion:</td>
                    <td><%= t.getDireccion() %></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td><%= t.getEstado() %></td>
                </tr>
                <tr>
                    <td>Ciudad</td>
                    <td><%= t.getCiudad() %></td>
                </tr>
                <tr>
                    <td>CP:</td>
                    <td><%= t.getCp() %></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><%= t.getTelefono() %></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><%= t.getEmail() %></td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>

