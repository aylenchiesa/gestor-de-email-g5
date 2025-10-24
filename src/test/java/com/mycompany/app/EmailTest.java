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
    void testEmailStatusChangesToSentAfterSending() {
        // 1. Configuración: Crear una instancia de SendMail.
        // Los valores de los parámetros (asunto, contenido, etc.) realmente no importan 
        // para este test, ya que solo probaremos el método 'sendEmail'.
        String subject = "Test de Envío Rápido";
        String content = "Contenido de prueba";
        String sender = "tester@ejemplo.com";
        // Usamos Collections.emptyList() para un caso simple
        SendMail mailToSend = new SendMail(subject, content, sender, Collections.emptyList(), false);

        // 2. Comprobación Inicial
        // Verificamos que el estado por defecto, establecido en el constructor, sea "Pending".
        assertEquals("Pending", mailToSend.getStatus(), 
                     "El estado inicial del email debe ser 'Pending'.");

        // 3. Acción: Llamar al método que estamos probando.
        // Los argumentos del método 'sendEmail' no se usan en tu implementación actual, 
        // pero los pasamos para cumplir con la firma.
        mailToSend.sendEmail("dummy@to.com", "dummy subject", "dummy body");

        // 4. Comprobación Final (Afirmación)
        // Verificamos que el método 'sendEmail' haya cambiado el estado a "Sent".
        assertEquals("Sent", mailToSend.getStatus(), 
                     "El estado del email debe ser 'Sent' después de llamar a sendEmail().");
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



