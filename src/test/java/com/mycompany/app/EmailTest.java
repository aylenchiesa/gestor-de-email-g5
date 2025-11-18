package com.mycompany.app;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EmailTest {

  //pruebaCI

  @Test
  public void testEnvioDeCorreo() {//raro este test

    Contacto remitente = new Contacto("Remitente 1", "remitente@demo.com");
    Contacto c1 = new Contacto("Contacto 1", "contacto1@demo.com");

    Email email = new Email("Prueba", "Hola, este es un correo de prueba", remitente, Arrays.asList(c1));

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
  public void testCopiasIndependientesEnDestinatarios() {
    // remitente y destinatarios bla bla
    Contacto remitente = new Contacto("Carlos", "carlos@empresa.com");
    Contacto ana = new Contacto("Ana", "ana@empresa.com");
    Contacto luis = new Contacto("Luis", "luis@empresa.com");

    // crear email ORIGINALLLL
    Email email = new Email("Reunión", "La reunión es a las 10hs.", remitente, Arrays.asList(ana, luis));

    // enviar email
    SendMail gestor = new SendMail();
    gestor.enviar(email, Arrays.asList(ana, luis));

    // verificar que ambos recibieron el correo
    assertEquals(1, ana.getBandejaEntrada().getEmails().size());
    assertEquals(1, luis.getBandejaEntrada().getEmails().size());

    Email emailAna = ana.getBandejaEntrada().getEmails().get(0);
    Email emailLuis = luis.getBandejaEntrada().getEmails().get(0);

    //sirve para verificar que dos objetos no son la misma instancia en memoria,(copias, no la misma referencia)
    assertNotSame(emailAna, emailLuis, "Cada destinatario debe recibir una copia independiente del correo");

    // al principio, ninguno está leído
    assertFalse(emailAna.isLeido());
    assertFalse(emailLuis.isLeido());

    // ana abre el correo (lee su copia)
    emailAna.getContent(); // esto marca como leído

    // verificar que solo el de Ana se marcó como leído
    assertTrue(emailAna.isLeido(), "El correo de Ana debería estar marcado como leído");
    assertFalse(emailLuis.isLeido(), "El correo de Luis no debería afectarse, sigue sin leer");
  }

  //NO SE TOCAAAA ESTE TEST PERFE
  @Test
  public void testLeerContenido() {
    Contacto remitente = new Contacto("Carlos", "carlos@empresa.com");
    Contacto meli = new Contacto("Meli", "meli@empresa.com");
    Contacto marto = new Contacto("Luis", "luis@empresa.com");

    //Usuario meliUser = new Usuario("Meli", "meli@empresa.com", meli);
    Usuario martoUser = new Usuario("Luis", "luis@empresa.com", marto);

    //enviar el correo
    Email reunion = new Email("Reunión importante",
        "Mañana a las 10am", remitente, Arrays.asList(meli, marto));

    SendMail gestor = new SendMail();
    gestor.enviar(reunion, Arrays.asList(meli, marto));

    assertTrue(remitente.getBandejaSalida().getEmails().contains(reunion));

    //correos clonados en bandejas de cada contacto
    Email emailMeli = meli.getBandejaEntrada().getEmails().get(0);
    Email emailMarto = marto.getBandejaEntrada().getEmails().get(0);

    assertNotSame(emailMeli, emailMarto);

    //verif bandeja de entrada de cada uno
    assertEquals(1, meli.getBandejaEntrada().getEmails().size());
    assertEquals(1, marto.getBandejaEntrada().getEmails().size());

    //verifico no leido
    assertFalse(emailMeli.isLeido());
    assertFalse(emailMarto.isLeido());

    //marto abre su correo
    martoUser.getContacto().getBandejaEntrada().getEmails().get(0).getContent();
    assertTrue(marto.getBandejaEntrada().getEmails().get(0).isLeido());

    //meli abre el correo
    meli.getBandejaEntrada().getEmails().get(0).getContent();
    assertTrue(emailMeli.isLeido(), "Meli marco como leído su correo");
  }

  @Test
  public void testCrearBorrador() {
    Contacto dualipa = new Contacto("Carlos", "dualipa@empresa.com");
    Usuario dualipaUser = new Usuario("Carlos User", "dualipa@empresa.com", dualipa);
    Contacto martu = new Contacto("Martu", "martu@empresa.com");

    Email borrador = dualipaUser.crearBorrador(
        "Prueba borrador",
        "Este es el contenido inicial del borrador.");

    assertTrue(borrador.isBorrador());

    //borrador está en la bandeja de borradores del remitente
    assertEquals(1, dualipa.getBandejaBorradores().getEmails().size(),
        "El contacto debe tener 1 email en su bandeja de borradores.");
    assertTrue(dualipa.getBandejaBorradores().getEmails().contains(borrador));

  }

  @Test
  public void testEditarYEnviarBorrador() {
    Contacto dualipa = new Contacto("Carlos", "dualipa@empresa.com");
    Usuario dualipaUser = new Usuario("Carlos User", "dualipa@empresa.com", dualipa);
    Contacto martu = new Contacto("Martu", "martu@empresa.com");

    Email borrador = dualipaUser.crearBorrador(
        "Prueba borrador",
        "Este es el contenido inicial del borrador.");

    //editar el borrador
    String nuevoTitulo = "Reunión de cerveza, Martes 10 AM";
    String nuevoContenido = "El viernes no, mejor el martes. Detalles en el adjunto.";

    dualipaUser.editarBorrador(borrador, nuevoTitulo, nuevoContenido);

    assertEquals(nuevoTitulo, borrador.getSubject(), "El asunto del borrador debe haberse actualizado.");
    assertEquals(nuevoContenido, borrador.getContent(), "El contenido del borrador debe haberse actualizado.");
    assertTrue(borrador.isBorrador(), "El email debe seguir marcado como borrador después de la edición.");

    //enviar el borrador
    // Usamos el método que se agregó al Usuario para gestionar la transición
    /*dualipaUser.enviarBorrador(borrador, Arrays.asList(martu));
    
    // Verificar 4.1: El objeto original ya no es un borrador
    assertFalse(borrador.isBorrador(), "Tras el envío, el email no debe estar marcado como borrador.");
    
    // Verificar 4.2: Se removió de la bandeja de borradores del remitente
    assertTrue(dualipa.getBandejaBorradores().getEmails().isEmpty(), "La bandeja de borradores debe estar vacía después de enviar.");
    
    // Verificar 4.3: El email llegó al destinatario (Martu)
    assertEquals(1, martu.getBandejaEntrada().getEmails().size(), "Martu debe tener 1 email en su bandeja de entrada.");
    
    // Verificar 4.4: La copia recibida en Martu contiene el contenido editado
    Email emailRecibido = martu.getBandejaEntrada().getEmails().get(0);
    assertEquals(nuevoTitulo, emailRecibido.getSubject(), "El email recibido debe tener el título final editado.");
    */
  }

}




