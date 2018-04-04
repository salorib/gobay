/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.controller;

import com.gobay.model.Transaccion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Argos
 */
public class TransaccionController extends HttpServlet {
    
    private Transaccion detalle;

    @Override
    public void init() throws ServletException {
        detalle = new Transaccion();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //RequestDispatcher dispatcher = request.getRequestDispatcher("terminado.jsp");
        
        //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("terminado.jsp");
        
        detalle.setName(request.getParameter("nombre"));
        detalle.setApellido(request.getParameter("apellido"));
        detalle.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        detalle.setEmail(request.getParameter("email"));
        
        detalle.setDireccion(request.getParameter("direccion"));
        detalle.setCiudad(request.getParameter("ciudad"));
        detalle.setEstado(request.getParameter("estado"));
        detalle.setCp(Integer.parseInt(request.getParameter("cp")));
        
        request.setAttribute("detalle", detalle);
        dispatcher.forward(request, response);
    }

}
