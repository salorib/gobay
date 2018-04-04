/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.controller;

import com.gobay.dao.ProductoDAO;
import com.gobay.model.CompraItem;
import com.gobay.model.Producto;
import com.gobay.service.CarritoServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Argos
 */
public class PagarController extends HttpServlet {
    
    private ProductoDAO dao;
    private CarritoServiceImpl service;
    private Producto producto;
    private CompraItem item;
    
    
    @Override
    public void init() throws ServletException {
        dao = new ProductoDAO();
        producto = new Producto();
        item = new CompraItem();
        service = new CarritoServiceImpl();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagar.jsp");
        
        if(request.getParameterNames().hasMoreElements()){
            if(request.getParameter("buy") != null){
                List<CompraItem> lista = new ArrayList<>();;
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                producto = dao.obtenerProducto(Long.parseLong(request.getParameter("ItemID")));
                double subtotal = cantidad * producto.getPrecio();
                
                item.setId_producto(producto.getId());
                item.setProducto(producto);
                item.setCantidad(cantidad);
                item.setSubtotal(subtotal);
                
                lista.add(item);
                request.setAttribute("lista", lista);
            }
            if(request.getParameter("buyAll") != null){
                request.setAttribute("lista", service.obtenerLista());
            }
        }
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
