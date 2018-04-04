<%-- 
    Document   : carrito
    Created on : 1/04/2018, 12:37:19 AM
    Author     : Argos
--%>

<%@page import="com.gobay.model.Producto"%>
<%@page import="com.gobay.model.CompraItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                <div align="center">
                    <h1>Carro de compras de GoBay</h1>
                </div>
                
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                        </tr>
                    </thead>
                    <tbody>
                <%
                    //List<Producto> catalogo = (ArrayList<Producto>) request.getAttribute("catalogo");
                    List<CompraItem> carrito = (ArrayList<CompraItem>) request.getAttribute("listCompra");
                
                    for(CompraItem item : carrito){ %>
                    <tr>
                        <td><%= item.getId_producto() %></td>
                        <td><%= item.getProducto().getNombre() %></td>
                        <td><%= item.getProducto().getPrecio() %></td>
                        <td><%= item.getCantidad() %></td>
                        <td><%= item.getSubtotal() %></td>
                        <td><a href="${pageContext.request.contextPath}/carrito?delete=7&ItemID=<%= item.getId_producto() %>&cantidad=0"><button>eliminar</button></a></td>
                    </tr>
                    <%}
                %>
                    </tbody>
                </table>
                <a href="${pageContext.request.contextPath}/pagar?buyAll=2"><button>Terminar Pedido</button></a> <a href="${pageContext.request.contextPath}/"><button>Continuar Comprando</button></a>
                
                <b><%= request.getParameter("add") %></b>
                <b><%= request.getParameter("delete") %></b>
    </body>
</html>
