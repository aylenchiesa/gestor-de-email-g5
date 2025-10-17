package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Email {
  
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private List<Contacto> destinatarios;

    private boolean leido; //por defecto falso
    private boolean borrador;

    //constructor
    public Email(String asunto, String contenido, Contacto remitente) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
        this.destinatarios = new ArrayList<>();
        this.leido = false;   // por defecto no leido obvio
        this.borrador = false; // por defecto no es borrador
    }

    //uso básico
    public void agregarDestinatario(Contacto contacto) {
        destinatarios.add(contacto);
    }

    /*public void restaurar() {
        this.eliminado = false;
    }*/

    // getters
    public String getAsunto() {
      return asunto;
    }

    public String getContenido() {
      return contenido;
    }
      
    public Contacto getRemitente() {
      return remitente;
    }
      
    public List<Contacto> getDestinatarios() {
      return destinatarios;
    }
      
    public boolean isLeido() {
      return leido;
    }
      
    public boolean isFavorito() {
      return favorito;
    }
      
    public boolean isEliminado() {
      return eliminado;
    }
      
    public boolean isBorrador() {
      return borrador;
    }

    @Override
    public String toString() {
        return "[Asunto: " + asunto + ", Remitente: " + remitente + ", Leído: " + leido + "]";
    }
    
    public int getId() {
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
  }

}