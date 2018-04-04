/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.service;

import com.gobay.model.CompraItem;
import com.gobay.model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Argos
 */
public class CarritoServiceImpl implements CarritoService{
    
    private static final List<CompraItem> carrito = new ArrayList<CompraItem>();

    @Override
    public void agregarItems(Producto producto, int cantidad) {
        CompraItem item = new CompraItem();
            item.setId_producto(producto.getId());
            item.setCantidad(cantidad);
            item.setSubtotal(producto.getPrecio()*cantidad);
            item.setProducto(producto);
            
        carrito.add(item);
    }

    @Override
    public void quitarItems(Long id) {
        CompraItem delete = new CompraItem();
        for(CompraItem item : carrito){
            if(item.getId_producto().equals(id)){
                delete = item;
            }
        }
        
        carrito.remove(delete);
    }

    @Override
    public List<CompraItem> obtenerLista() {
        return carrito;
    }
    
}
