<%-- 
    Document   : detalles
    Created on : 28/03/2018, 03:30:41 PM
    Author     : Argos
--%>

<%@page import="com.gobay.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GoBay</title>
    </head>
    <body>
                <div style="float: right">
                    <a href="${pageContext.request.contextPath}/">Home</a>  <a href="${pageContext.request.contextPath}/carrito">Carrito</a>
                </div>
        
            <%
                Producto p = (Producto) request.getAttribute("producto");
                %>

        <div align="center">
            <h1>details</h1>
        </div>
                
                <form action="${pageContext.request.contextPath}/pagar" id="pagarForm">
            <div style="float: left" >
                <center>
            <table border="1">
            <thead>
                <tr>
                    <th>clave</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>cantidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getPrecio() %></td>
                    <td><input type="text" id="cunt" name="cantidad" value="<%= request.getAttribute("cantidad") %>" size="5" /></td><input type="hidden" name="ItemID" value="<%= p.getId() %>" /><input type="hidden" name="buy" value="8" />
                </tr>
            </tbody>
            </table>
                </center>
            </div>
                </form>
                
            <div style="float: left">
                <center>
                    <a href='' onclick="this.href='${pageContext.request.contextPath}/carrito?add=1&ItemID=<%= p.getId() %>&cantidad='+document.getElementById('cunt').value">
                        <button>Agregar</button>
                    </a><br>
                    <button type="submit" form="pagarForm" value="Submit">Comprar</button>
                </center>
            </div>  
                
    </body>
</html>

