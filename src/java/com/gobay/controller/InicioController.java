/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.controller;

import com.gobay.dao.ProductoDAO;
import com.gobay.model.Producto;
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
public class InicioController extends HttpServlet {
    
    private ProductoDAO dao;
    

    @Override
    public void init() throws ServletException {
        dao = new ProductoDAO();
            for(int i  = 1; i < 16; i++){
                Producto p = new Producto();
                    p.setId(Long.parseLong("00"+i));
                    p.setNombre("test_"+i);
                    p.setPrecio(10*i);
                    
                    dao.agregarProducto(p);
                    
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
            request.setAttribute("catalogo", dao.obtenerProductos());
            
            dispatcher.forward(request, response);
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

}
