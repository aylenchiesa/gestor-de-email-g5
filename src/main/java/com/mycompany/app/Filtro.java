package com.mycompany.app;
import java.util.List;
import java.util.function.Predicate;
 
public class Filtro {
  //ejemplo de filtro para emails de dominio ucp.com
  public List<Email> filtroDominioUCP(List<Email> emails) {
    return emails.stream()
        .filter(email -> email.getSender().getEmail().endsWith("@ucp.com"))
        .toList();
  }
 
 /*
  //predicado para filtrar emails por cantidad mínima de destinatarios
  private Predicate<Email> tieneDestinatariosMayorOIgualA(int cantidad) {
        return email -> email.getRecipients().size() >= cantidad;
  }*/

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
    
    //método genérico para usar cualquier predicado
    public List<Email> filtrar(List<Email> emails, Predicate<Email> condicion) {
        return emails.stream()
            .filter(condicion)
            .toList();
    }

    //filtra correos que contengan cierta palabra en asunto o contenido
     public List<Email> porTextoLibre(List<Email> emails, String texto) {
        String query = texto.toLowerCase();
        return emails.stream()
            .filter(email ->
                (email.getSubject() != null && email.getSubject().toLowerCase().contains(query)) ||
                (email.getContent() != null && email.getContent().toLowerCase().contains(query))
            )
            .toList();
    }

    
    //busqueda de email
    public static Predicate<Email> porTexto(String texto) {
        String query = texto.toLowerCase();

        return email ->
            (email.getSubject() != null && email.getSubject().toLowerCase().contains(query)) ||
            (email.getContent() != null && email.getContent().toLowerCase().contains(query)) ||
            (email.getSender() != null && email.getSender().toString().toLowerCase().contains(query)) ||
            (email.getRecipients() != null &&
                 email.getRecipients().toString().toLowerCase().contains(query));
    }
}

