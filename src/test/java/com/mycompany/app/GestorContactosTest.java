package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GestorContactosTest {
    
    private GestorContactos gestor;
    
    @BeforeEach
    void setUp() {
        gestor = new GestorContactos();
    }
    
    @Test
    void testAgregarContacto() {
        Contacto contacto = new Contacto("Juan", "juan@email.com");
        gestor.agregarContacto(contacto);
        
        assertEquals(1, gestor.size());
    }
    
    @Test
    void testEliminarContacto() {
        Contacto contacto = new Contacto("Juan", "juan@email.com");
        gestor.agregarContacto(contacto);
        
        boolean eliminado = gestor.eliminarContacto("juan@email.com");
        
        assertTrue(eliminado);
        assertEquals(0, gestor.size());
    }
    
    @Test
    void testEliminarContactoInexistente() {
        boolean eliminado = gestor.eliminarContacto("noexiste@email.com");
        
        assertFalse(eliminado);
    }
}