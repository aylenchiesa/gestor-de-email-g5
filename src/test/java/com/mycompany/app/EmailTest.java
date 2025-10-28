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
    public void testEnvioDeCorreo() {//raro este test
     
        Contacto remitente = new Contacto("Remitente 1", "remitente@demo.com");
        Contacto c1 = new Contacto("Contacto 1", "contacto1@demo.com");

        Email email = new Email("Prueba", "Hola, este es un correo de prueba", remitente);
        email.getRecipients().add(c1);

        //bandeja de entrada del destinatario
        Bandeja bandejaEntrada = new Bandeja();

        //simular que le llega un correo al destinatario
        bandejaEntrada.agregarEmail(email);

        assertEquals(1, bandejaEntrada.getEmails().size(), "La bandeja debería tener un correo recibido");
        assertEquals("Prueba", bandejaEntrada.getEmails().get(0).getSubject());
        assertFalse(bandejaEntrada.getEmails().get(0).isLeido(), "El correo recibido debería estar sin leer");
        assertEquals(remitente, bandejaEntrada.getEmails().get(0).getSender());
    }

    @Test
    public void testEnvioDeCorreoEntreBandejas() {
        // Crear remitente y destinatarios
        Contacto remitente = new Contacto("Carlos", "carlos@empresa.com");
        Contacto ana = new Contacto("Ana", "ana@empresa.com");
        Contacto luis = new Contacto("Luis", "luis@empresa.com");

        // Crear el correo
        Email email = new Email(
            "Reunión semanal",
            "Recordatorio de reunión el lunes a las 10:00.",
            remitente
        );

        // Agregar destinatarios
        email.getRecipients();
        email.getRecipients(); 

        // Crear el gestor de envío
        SendMail gestor = new SendMail();

        // Enviar el correo
        gestor.enviar(email, Arrays.asList(ana, luis));

        // Verificar que el estado del envío cambió
        assertEquals("Sent", gestor.getStatus(), "El estado del correo debería ser 'Sent'");

        // Verificar que el correo se guardó en la bandeja de salida del remitente
        assertEquals(1, remitente.getBandejaSalida().getEmails().size(), "El remitente debería tener un correo en su bandeja de salida");
        assertEquals("Reunión semanal", remitente.getBandejaSalida().getEmails().get(0).getSubject());

        // Verificar que cada destinatario recibió el correo en su bandeja de entrada
        assertEquals(1, ana.getBandejaEntrada().getEmails().size(), "Ana debería tener un correo en su bandeja de entrada");
        assertEquals(1, luis.getBandejaEntrada().getEmails().size(), "Luis debería tener un correo en su bandeja de entrada");

        // Verificar que el remitente del correo recibido sea correcto
        assertEquals(remitente, ana.getBandejaEntrada().getEmails().get(0).getSender());
        assertEquals(remitente, luis.getBandejaEntrada().getEmails().get(0).getSender());
    }
    // creo que me da algo raro este test jeje (pero por ahora lo dejo asi) (xq me sale el continue)
}



