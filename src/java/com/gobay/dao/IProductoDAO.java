/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.dao;

import com.gobay.model.Producto;
import java.util.List;

/**
 *
 * @author Argos
 */
public interface IProductoDAO {
    void agregarProducto(Producto producto);
    void eliminarProducto(Long id);
    Producto obtenerProducto(Long id);
    List<Producto> obtenerProductos();
}
