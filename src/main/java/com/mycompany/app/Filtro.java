package com.mycompany.app;

import java.util.List;

public class Filtro {
  //filtra emails no leídos
    public List<Email> noLeidosEnInbox(List<Email> emails) {
        return emails.stream()
            .filter(email -> !email.isLeido() && email.getBandeja().equals("INBOX"))
            .toList();
    }
    
    //filtra emails por dominio del remitente
    public List<Email> porDominio(List<Email> emails, String dominio) {
        return emails.stream()
            .filter(email -> email.getRemitente().endsWith("@" + dominio))
            .toList();
    }
}
