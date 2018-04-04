/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.controller;

import com.gobay.dao.ProductoDAO;
import com.gobay.model.Producto;
import com.gobay.service.CarritoServiceImpl;

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
public class CarritoController extends HttpServlet {
    
    private CarritoServiceImpl carrito;
    private ProductoDAO dao;
    private Producto producto;
    
    @Override
    public void init() throws ServletException {
        carrito = new CarritoServiceImpl();
        dao = new ProductoDAO();
        producto = new Producto();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("carrito.jsp");
        
        if(request.getParameterNames().hasMoreElements()){
            if(request.getParameter("add") != null){
                
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                producto = dao.obtenerProducto(Long.parseLong(request.getParameter("ItemID")));
                carrito.agregarItems(producto, cantidad);
                
            }
            if(request.getParameter("delete") != null){
                carrito.quitarItems(Long.parseLong(request.getParameter("ItemID")));
            }
        }
        
        request.setAttribute("listCompra", carrito.obtenerLista());
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
