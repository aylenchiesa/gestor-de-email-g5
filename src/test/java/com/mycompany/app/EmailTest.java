package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

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

    @Test
    void testEnvioCorreoImportante() {
        SendMail correoImportante = new SendMail(
            "URGENTE: Reunión",
            "Reunión urgente mañana a las 9 AM",
            "jefe@empresa.com",
            Arrays.asList("empleado1@empresa.com", "empleado2@empresa.com"),
            true  // Correo importante
        );

        assertTrue(correoImportante.isImportant());
        assertEquals("Pending", correoImportante.getStatus());

        // Enviar correo importante
        correoImportante.sendEmail("empleado1@empresa.com", "URGENTE: Reunión", "Reunión urgente mañana");

        assertEquals("Sent", correoImportante.getStatus());
    }
}



