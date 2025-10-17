package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class BandejaEntrada {
  private List<Email> emails;
  
  public BandejaEntrada() {
    this.emails = new ArrayList<>();
  }
  
  public void agregarEmail(Email email) {
    emails.add(email);
  }
  
  public void eliminarEmail(Email email) {
    emails.remove(email);
  }
  
  public List<Email> getEmails() {
    return new ArrayList<>(emails);
  }
  
  public Email buscarEmailPorId(int id) {
    return emails.stream()
        .filter(email -> email.getId() == id)
        .findFirst()
        .orElse(null);
  }
  
  public void limpiarBandeja() {
    emails.clear();
  }
  
  public int getCantidadEmails() {
    return emails.size();
  }
}