<%-- 
    Document   : comprar
    Created on : 1/04/2018, 11:45:45 AM
    Author     : Argos
--%>

<%@page import="com.gobay.model.CompraItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                List<CompraItem> lita = (ArrayList<CompraItem>) request.getAttribute("lista");
                double total = 0;
        %>
        
        <div align="center">
            <h1>confirm and pay</h1>
        </div>
        
        <div style=" float: right">
        <table border="1">
            <thead>
                <tr>
                    <th>Clave</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(CompraItem item : lita){
                    %>
                <tr>
                    <td><%= item.getId_producto() %></td>
                    <td><%= item.getProducto().getNombre()  %></td>
                    <td><%= item.getProducto().getPrecio()  %></td>
                    <td><%= item.getCantidad()  %></td>
                    <td><%= item.getSubtotal()  %></td>
                </tr>
                <% 
                    total += item.getSubtotal();
                    }
                %>
                <tr>
                    <td colspan="3"></td>
                    <td>Total</td>
                    <td><%= total  %></td>
                </tr>
            </tbody>
        </table>
            
                <b><%= request.getParameter("buy") %></b>
                <b><%= request.getParameter("buyAll") %></b>                
        </div>
        
        <div style="float: left">
            <form action="${pageContext.request.contextPath}/completed" method="POST" id="complete">
            
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">Pagar con</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="2"><input type="text" name="cardnumber" placeholder="N.° de Tarjeta" size="66" /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fecha" placeholder="Fecha de Expiracion" size="30" /></td>
                        <td><input type="text" name="codigo" placeholder="Código de Seguridad" size="30" /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="cardNombre" placeholder="Nombre" size="30" /></td>
                        <td><input type="text" name="cardApellido" placeholder="Apellido" size="30" /></td>
                    </tr>
                </tbody>
            </table>
                        <br>
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">Enviar a</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><select name="Pais">
                                <option>MEX</option>
                                <option>EUA</option>
                                <option>CAN</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="nombre" placeholder="Nombre" size="40" /> <input type="text" name="apellido" placeholder="Apellido" size="40" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="text" name="direccion" placeholder="Direccion" size="85"/></td>
                    </tr>
                    <tr>
                        <td> <input type="text" name="ciudad" placeholder="Ciudad" /> <input type="text" name="estado" placeholder="Estado" /> <input type="text" name="cp" placeholder="Codigo Postal" /> </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="telefono" placeholder="Telefono" /> <input type="email" name="email" placeholder="email" size="50"/></td>
                    </tr>
                </tbody>
            </table>

        </form>
            <div align="center">
                <br><input type="submit" value="Confirmar y Pagar" form="complete" />
            </div>
        </div>
        
    </body>
</html>
