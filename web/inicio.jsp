<%-- 
    Document   : inicio
    Created on : 28/03/2018, 01:56:53 PM
    Author     : Argos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gobay.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GoBay</title>
    </head>
    <body>
                <div style="float: right">
                    <a href="${pageContext.request.contextPath}/">Home</a>  <a href="${pageContext.request.contextPath}/carrito">Carrito</a>
                </div>
        
        <div align="center">
            <h1>Hello annonymous customer! GoBay</h1>
        
        
        <%-- form action="${pageContext.request.contextPath}/comprar" method="GET" --%>
            
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
        <%
            List<Producto> myList = (ArrayList<Producto>) request.getAttribute("catalogo");
            int v = 1;
            
            for(Producto p : myList){ %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getNombre() %></td>
                <td><%=p.getPrecio() %></td>
                <td><a href="${pageContext.request.contextPath}/comprar?ItemID=<%= p.getId() %>" target="_parent"><button>comprar</button></a></td>
            </tr>
            <%}
        %>        
            </tbody>
            </table>
        </div>    
            <%--input type="submit" value="Comprar" name="comprar" /--%>
            <%-- /form --%>
           
        
    </body>
</html>

