/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.service;

import com.gobay.model.CompraItem;
import com.gobay.model.Producto;
import java.util.List;

/**
 *
 * @author Argos
 */
public interface CarritoService {
    void agregarItems(Producto producto, int cantidad);
    void quitarItems(Long id);
    List<CompraItem> obtenerLista();
}
