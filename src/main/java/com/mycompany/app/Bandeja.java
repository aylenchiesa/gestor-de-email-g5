package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Bandeja {
  private List<Email> emails;
  
  public Bandeja() {
    this.emails = new ArrayList<>();
  }
  
  public void agregarEmail(Email email) { //o sea recibir
    emails.add(email);
  }
  
  /*public void eliminarEmail(Email email) {
    emails.remove(email);
  }*/
  
  public List<Email> getEmails() {
    return new ArrayList<>(emails);
  }
  
  public Email buscarEmailPorId(int id) {
    return emails.stream()
        .filter(email -> email.getId() == id)
        .findFirst()
        .orElse(null);
  }
  
  /*public void limpiarBandeja() {
    emails.clear();
  } */

  public List<Email> buscarEmails(String texto) {
        List<Email> resultados = new ArrayList<>();
        String query = texto.toLowerCase();

        for (Email email : emails) {
            boolean coincide =
                (email.getAsunto() != null && email.getAsunto().toLowerCase().contains(query)) ||
                (email.getContenido() != null && email.getContenido().toLowerCase().contains(query)) ||
                (email.getRemitente() != null && email.getRemitente().toString().toLowerCase().contains(query)) ||
                (email.getDestinatarios() != null && email.getDestinatarios().toString().toLowerCase().contains(query));
            
            if (coincide) {
                resultados.add(email);
            }
        }

        return resultados;
    }
}