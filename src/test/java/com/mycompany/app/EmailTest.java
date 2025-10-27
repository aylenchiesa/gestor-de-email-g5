package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

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

    /*@Test
    void testEnvioCorreoImportante() {

      Contacto remitente = new Contacto("Aylena", "aylema@yahoo.com");
      Contacto destinatario1 = new Contacto("Vicka", "vic@yahoo.com");

      SendMail correoImportante = new SendMail(
          "Chismeeeeeeeee",
          "Birra mañana after class que hay chisme",
          remitente.getEmail(),
          Arrays.asList(destinatario1.getEmail()),
          true
      );
          

      assertTrue(correoImportante.isImportant());
      assertEquals("Pending", correoImportante.getStatus());
      assertEquals(remitente.getEmail(), correoImportante.getSender());
      assertTrue(correoImportante.getRecipients().contains(destinatario1.getEmail()));

      // enviar correo
      correoImportante.sendEmail(destinatario1.getEmail(), "Chismeeeeee", "Birra mañana after class que hay chisme");

      assertEquals("Sent", correoImportante.getStatus());

      //falta verificar que el destinatario reciba el correo en su bandeja de entrada
    }
    
    @Test
    public void testBuscarEmailsPorTextoLibre() {
        Bandeja bandeja = new Bandeja();
        
        Contacto remitente = new Contacto("Juan", "juan@mail.com");
        Contacto destinatario = new Contacto("Aylén", "aylen@mail.com");

        // Usar SendMail para enviar correos
        Email correo1 = new Email(
            "Reunión mañana", 
            "Confirmamos la reunión de las 10.", 
            remitente.getEmail(), 
            Arrays.asList(destinatario.getEmail()), 
            false
        );
           

        Email correo2 = new Email(
            "Pororó", 
            "Compramos pororó?", 
            remitente.getEmail(), 
            Arrays.asList(destinatario.getEmail()), 
            false
        );

        Email correo3 = new Email(
            "Saludos", 
            "Hola Aylén, ¿cómo estás?", 
            remitente.getEmail(), 
            Arrays.asList(destinatario.getEmail()), 
            false
        );

        // Enviar correos (esto cambia el status a "Sent")
        correo1.enviar(recipient.getEmail(), correo1.getSubject(), correo1.getContent());
        correo2.enviar(recipient.getEmail(), correo2.getSubject(), correo2.getContent());
        correo3.enviar(recipient.getEmail(), correo3.getSubject(), correo3.getContent());

        // Verificar que los correos fueron enviados correctamente
        assertEquals("Sent", correo1.getStatus());
        assertEquals("Sent", correo2.getStatus());
        assertEquals("Sent", correo3.getStatus());

        // Buscar emails en la bandeja
        List<Email> resultados = bandeja.buscarEmails("reunión");
        
        assertEquals(1, resultados.size());
        assertEquals("Reunión mañana", resultados.get(0).getSubject());
    }*/


    @Test
    void testEnvioCorreoMultipleDestinatarios() {
     // Crear contactos remitente y varios destinatarios
        Contacto remitente = new Contacto("Carlos Jefe", "jefe@empresa.com");
        Contacto d1 = new Contacto("Ana Empleada", "empleado1@empresa.com");
        Contacto d2 = new Contacto("Luis Empleado", "empleado2@empresa.com");
        Contacto d3 = new Contacto("María Secretaria", "secretaria@empresa.com");

        // Crear correo con varios destinatarios
        SendMail correo = new SendMail(
            "Aviso importante",
            "Recordatorio: reunión general el viernes a las 10 AM.",
            remitente.getEmail(),
            Arrays.asList(d1.getEmail(), d2.getEmail(), d3.getEmail()),  // varios destinatarios
            true // es importante
    );

    // Verificaciones iniciales
        assertEquals("Pending", correo.getStatus(), "El estado inicial debe ser 'Pending'");
        assertEquals(remitente.getEmail(), correo.getSender());
        assertEquals(3, correo.getRecipients().size(), "Debe tener tres destinatarios");
        assertTrue(correo.isImportant(), "El correo debe ser marcado como importante");
        assertTrue(correo.getRecipients().containsAll(Arrays.asList(
            d1.getEmail(), d2.getEmail(), d3.getEmail()
        )), "Los destinatarios deben coincidir con los agregados");

        // Envia el correo a todos los destinatarios
        for (String destinatario : correo.getRecipients()) {
            correo.sendEmail(destinatario, correo.getSubject(), correo.getContent());
        }

        // Verificar que el estado final sea 'Sent'
       assertEquals("Sent", correo.getStatus());
    }
}