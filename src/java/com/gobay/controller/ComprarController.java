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
public class ComprarController extends HttpServlet {
    
    private ProductoDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ProductoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto = new Producto();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("comprar.jsp");
        
        int cantidad = 1;
        String id = request.getParameter("ItemID");
        producto = dao.obtenerProducto(Long.parseLong(id));
                
        request.setAttribute("cantidad", cantidad);
        request.setAttribute("producto", producto);
                         
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
