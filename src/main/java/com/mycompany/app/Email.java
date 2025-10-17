package com.mycompany.app;

public class Email {
 
  private boolean leido;
  private String bandeja;
  private String remitente;
  
  public Email(boolean leido, String bandeja, String remitente) {
      this.leido = leido;
      this.bandeja = bandeja;
      this.remitente = remitente;
  }
  
  public boolean isLeido() { return leido; }
  public String getBandeja() { return bandeja; }
  public String getRemitente() { return remitente; }

  public int getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }

    
}
