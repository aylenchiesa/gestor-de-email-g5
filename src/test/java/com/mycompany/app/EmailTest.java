package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class EmailTest {
    
  // filtrar emails no leídos en bandeja de enteada o sea inbox
    @Test
    void testFiltrarEmailsNoLeidosEnInbox() {
        // Crear lista de emails de prueba
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(false, "INBOX", "usuario1@domain.com")); // No leído en INBOX
        emails.add(new Email(true, "INBOX", "usuario2@domain.com"));  // Leído en INBOX
        emails.add(new Email(false, "SENT", "usuario3@domain.com"));  // No leído en SENT
        emails.add(new Email(false, "INBOX", "usuario4@domain.com")); // No leído en INBOX
        emails.add(new Email(true, "SPAM", "usuario5@domain.com"));   // Leído en SPAM
        
        List<Email> resultado = noLeidosEnInbox(emails);
        
        //verificar que solo devuelve emails no leídos de INBOX
        assertEquals(2, resultado.size());
        for (Email email : resultado) {
            assertFalse(email.isLeido());
            assertEquals("INBOX", email.getBandeja());
        }
    }
    
// filtrar emails por dominio
    @Test
    void testFiltrarEmailsPorDominio() {
        // Crear lista de emails de prueba
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(false, "INBOX", "usuario1@gmail.com"));
        emails.add(new Email(true, "INBOX", "usuario2@yahoo.com"));
        emails.add(new Email(false, "SENT", "usuario3@gmail.com"));
        emails.add(new Email(false, "INBOX", "usuario4@hotmail.com"));
        emails.add(new Email(true, "SPAM", "usuario5@gmail.com"));
        
        List<Email> resultadoGmail = porDominio(emails, "gmail.com");
        
        //chequeo que solo devuelve emails del dominio gmail.com
        assertEquals(3, resultadoGmail.size());
        for (Email email : resultadoGmail) {
            assertTrue(email.getRemitente().endsWith("@gmail.com"));
        }
        
        List<Email> resultadoUCP = porDominio(emails, "ucp.edu.ar");
        assertEquals(1, resultadoUCP.size());
        assertTrue(resultadoUCP.get(0).getRemitente().endsWith("@ucp.edu.ar"));
    }

   /*private Predicate<Email> porDominio(String dominio) {
       return email -> email.getRemitente().endsWith("@" + dominio);
   }*/

}
