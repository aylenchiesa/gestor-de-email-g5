package com.mycompany.app;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BandejaTest {
    
    @Test
    public void testBuscarEmailsEnBandejaDeEntrada() {
      // Crear contactos
      Contacto remitente = new Contacto("Carlos", "carlos@empresa.com");
      Contacto ana = new Contacto("Ana", "ana@empresa.com");
      Contacto luis = new Contacto("Luis", "luis@empresa.com");

      // bandeja de entrada de Ana
      Bandeja bandejaEntrada = ana.getBandejaEntrada();

      // crear y agregar correos simulados
      Email correo1 = new Email("Reunión semanal", "Recordatorio de reunión el lunes a las 10:00.", remitente);
      correo1.getRecipients().add(ana);

      Email correo2 = new Email("Informe mensual", "Por favor enviar el informe antes del viernes.", remitente);
      correo2.getRecipients().add(ana);

      Email correo3 = new Email("Festejo", "Luis invita a un asado el sábado.", luis);
      correo3.getRecipients().add(ana);

      bandejaEntrada.agregarEmail(correo1);
      bandejaEntrada.agregarEmail(correo2);
      bandejaEntrada.agregarEmail(correo3);

      // aca probamos las busquedassss

      // buscar por asunto
      List<Email> resultadoAsunto = bandejaEntrada.buscarEmails("reunión");
      assertEquals(1, resultadoAsunto.size(), "Debería encontrar 1 correo con 'reunión' en el asunto");
      assertEquals("Reunión semanal", resultadoAsunto.get(0).getSubject());

      // buscar por contenido
      List<Email> resultadoContenido = bandejaEntrada.buscarEmails("informe");
      assertEquals(1, resultadoContenido.size(), "Debería encontrar 1 correo con 'informe' en el contenido");
      assertEquals("Informe mensual", resultadoContenido.get(0).getSubject());

      // buscar por remitente
      List<Email> resultadoRemitente = bandejaEntrada.buscarEmails("carlos@empresa.com");
      assertEquals(2, resultadoRemitente.size(), "Debería encontrar 2 correos enviados por Carlos");

      // buscar por destinatario
      List<Email> resultadoDestinatario = bandejaEntrada.buscarEmails("ana@empresa.com");
      assertEquals(3, resultadoDestinatario.size(), "Ana debería aparecer como destinataria en los 3 correos");

      // buscar texto inexistente
      List<Email> resultadoVacio = bandejaEntrada.buscarEmails("vacaciones");
      assertTrue(resultadoVacio.isEmpty(), "No debería encontrar correos con el texto 'vacaciones'");
    }
    
    @Test
    public void testIsEliminadoPorDefecto() {
        
        Contacto r1 = new Contacto("Carlos", "carlos@empresa.com");
        Contacto martu = new Contacto("Ana", "ana@empresa.com");
        Usuario martuUser = new Usuario("Martu", "martu@empresa.com");
        

    // Crear el correo
    Email email = new Email(
        "Ya es Viernes",
        "Hoy es viernes de cerveza.",
        r1);

    // Agregar destinatarios
    email.getRecipients().add(martu);

    //clase que envía
    SendMail gestor = new SendMail();

    //enviar
    gestor.enviar(email, Arrays.asList(martu));

    // verificar status sent y que se guardo en bandeja de salida
    assertEquals("Sent", gestor.getStatus(), "El estado del correo debería ser 'Sent'");
    assertEquals(1, r1.getBandejaSalida().getEmails().size(),
        "El remitente debería tener un correo en su bandeja de salida");
    
    martuUser.eliminarEmail(email);
    assertTrue(martuUser.getBandejaEntrada().getEmails().get(0).isEliminado());

    }


}
