package com.mycompany.app;
import java.util.List;

public class Filtro {
  //ejemplo de filtro para emails de dominio ucp.com
  public List<Email> filtroDominioUCP (List<Email> emails) {
    return emails.stream() 
        .filter(email -> email.getSender().getEmail().endsWith("@ucp.com")) 
        .toList();
  }

  //filtro que retorna lista de emails de dominio UCP
  public List<Email> obtenerEmailsDeUCP(List<Email> emails) {
    return emails.stream()
        .filter(email -> email.getSender().getEmail().endsWith("@ucp.com"))
        .toList();
  }

  //filtro genérico por dominio
  public List<Email> filtrarPorDominio(List<Email> emails, String dominio) {
    return emails.stream()
        .filter(email -> email.getSender().getEmail().endsWith("@" + dominio))
        .toList();
  }


  //filtra emails no leídos
  public List<Email> noLeidosEnInbox(List<Email> emails) {
        return emails.stream()
            .filter(email -> !email.isLeido())
            .toList();
    }
    
    //filtra emails por dominio del remitente
    public List<Email> porDominio(List<Email> emails, String dominio) {
        return emails.stream()
            .filter(email -> email.getSender().getEmail().endsWith("@" + dominio))
            .toList();
    }
}
