/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobay.dao;

import com.gobay.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Argos
 */
public class ProductoDAOTest {
    
    private Producto producto;
    private Long id;
    private List<Producto> lista;
    private ProductoDAO instance;
    
    public ProductoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ProductoDAO();
        producto = new Producto();
        lista = new ArrayList<>();
        
        id = Long.parseLong("001");
        
        producto.setId(Long.parseLong("001"));
        producto.setNombre("test");
        producto.setPrecio(99.99);
        
        lista.add(producto);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agregarProducto method, of class ProductoDAO.
     */
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        ProductoDAO instance = new ProductoDAO();
        instance.agregarProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obtenerProducto method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProducto() {
        System.out.println("obtenerProducto");
        //Long id = null;
        //ProductoDAO instance = new ProductoDAO();
        Producto expResult = producto;
        Producto result = instance.obtenerProducto(id);
        
        System.out.println(expResult.getId());
        System.out.println(result.getId());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obtenerProductos method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProductos() {
        System.out.println("obtenerProductos");
        ProductoDAO instance = new ProductoDAO();
        List<Producto> expResult = lista;
        List<Producto> result = instance.obtenerProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    /**
     * Test of eliminarProducto method, of class ProductoDAO.
     */
    @Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        //Long id = null;
        ProductoDAO instance = new ProductoDAO();
        instance.eliminarProducto(id);
        // TODO review the generated test code and remove the default call to fail.
    }


    
}
