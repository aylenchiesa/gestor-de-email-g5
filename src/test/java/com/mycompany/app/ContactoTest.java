package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class ContactoTest {
    
    private Contacto contacto;
    
    @BeforeEach
    void setUp() {
        contacto = new Contacto();
    }
    

//crear un contacto usando el constructor por defecto
    @Test
    void testCrearContactoVacio() {
        assertNotNull(contacto);
        assertNull(contacto.getNombre());
        assertNull(contacto.getEmail());
    }
    
    @Test
    void testCrearContacto() {
        String nombre = "Juan Pérez";
        String email = "juan.perez@email.com";
        
        Contacto contactoCompleto = new Contacto(nombre, email);
        
        assertNotNull(contactoCompleto);
        assertEquals(nombre, contactoCompleto.getNombre());
        assertEquals(email, contactoCompleto.getEmail());
    }
    
    /**
     * Test para editar el nombre de un contacto
     */
    @Test
    void testEditarNombreContacto() {
        String nombreInicial = "María García";
        String nombreNuevo = "María García López";
        
        contacto.setNombre(nombreInicial);
        assertEquals(nombreInicial, contacto.getNombre());
        
        // Editar nombre
        contacto.setNombre(nombreNuevo);
        assertEquals(nombreNuevo, contacto.getNombre());
    }
    

//editar el email de un contacto
    @Test
    void testEditarEmailContacto() {
        String emailInicial = "maria@empresa.com";
        String emailNuevo = "maria.garcia@nuevaempresa.com";
        
        contacto.setEmail(emailInicial);
        assertEquals(emailInicial, contacto.getEmail());
        
        // Editar email
        contacto.setEmail(emailNuevo);
        assertEquals(emailNuevo, contacto.getEmail());
    }
    
    //Test para simular la eliminación de un contacto
    @Test
    void testEliminarContacto() {
        // Crear contacto con datos
        contacto.setNombre("Ana López");
        contacto.setEmail("ana.lopez@email.com");
        
        assertNotNull(contacto.getNombre());
        assertNotNull(contacto.getEmail());
        
        // Simular eliminación estableciendo valores a null
        contacto.setNombre(null);
        contacto.setEmail(null);
        
        assertNull(contacto.getNombre());
        assertNull(contacto.getEmail());
    }

    @Test
    void testContactoComoRemitente() {
        String nombre = "Carlos Sender";
        String email = "carlos.sender@email.com";
        
        Contacto remitente = new Contacto(nombre, email);
        
        // Verificar que los datos son correctos para usar como remitente
        assertNotNull(remitente.getNombre());
        assertNotNull(remitente.getEmail());
        assertEquals(nombre, remitente.getNombre());
        assertEquals(email, remitente.getEmail());
        assertTrue(remitente.getEmail().contains("@"));
    }
    
    @Test
    void testContactoComoDestinatario() {
        String nombre = "Laura Receiver";
        String email = "laura.receiver@email.com";
        
        Contacto destinatario = new Contacto(nombre, email);
        
        // Verificar que los datos son correctos para usar como destinatario
        assertNotNull(destinatario.getNombre());
        assertNotNull(destinatario.getEmail());
        assertEquals(nombre, destinatario.getNombre());
        assertEquals(email, destinatario.getEmail());
        assertTrue(destinatario.getEmail().contains("@"));
    }
    

}