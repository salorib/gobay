/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.dao;

import com.gobay.model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Argos
 */
public class ProductoDAO implements IProductoDAO{
    
    private static final List<Producto> catalogo = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        catalogo.add(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto delete = new Producto();
        for(Producto producto : catalogo){
            if(producto.getId().equals(id)){
                delete = producto;
            }
        }
        catalogo.remove(delete);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        for(Producto producto : catalogo){
            if(producto.getId().equals(id)){
                return producto;
            }
        }
        return null;
    }

    @Override
    public List<Producto> obtenerProductos() {
        if(catalogo.isEmpty()){
            return null;
        }
        return catalogo;
    }
    
}
