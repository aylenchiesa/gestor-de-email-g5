package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailTest {

   //pruebaCI

    @Test
    public void testEnvioDeCorreo() {
     
        Contacto remitente = new Contacto("Remitente 1", "remitente@demo.com");
        Contacto c1 = new Contacto("Contacto 1", "contacto1@demo.com");

        Email email = new Email("Prueba", "Hola, este es un correo de prueba", remitente);
        email.agregarDestinatario(c1);

        //bandeja de entrada del destinatario
        Bandeja bandejaEntrada = new Bandeja();

        //simular que le llega un correo al destinatario
        bandejaEntrada.agregarEmail(email);

        assertEquals(1, bandejaEntrada.getEmails().size(), "La bandeja debería tener un correo recibido");
        assertEquals("Prueba", bandejaEntrada.getEmails().get(0).getAsunto());
        assertFalse(bandejaEntrada.getEmails().get(0).isLeido(), "El correo recibido debería estar sin leer");
        assertEquals(remitente, bandejaEntrada.getEmails().get(0).getRemitente());
    }
}


