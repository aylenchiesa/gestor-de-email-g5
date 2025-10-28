package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String subject;
    private String content;
    private Contacto sender;
    private List<Contacto> recipients;

    private boolean leido; //por defecto falso
    private boolean important;
    private boolean borrador;
    public boolean eliminado;

    //constructor
    public Email(String subject, String content, Contacto sender) {
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.recipients = new ArrayList<>();
        this.leido = false; // por defecto no leido obvio
        this.important = false; // por defecto no es importante
        this.borrador = false; // por defecto no es borrador
        this.eliminado = false; // por defecto no eliminado
    }

    //uso básico
    public void restaurar() {
        this.eliminado = false;
    }

    public String getSubject() {
      return subject;
    }

    public String getContent() {
      return content;
    }

    public Contacto getSender() {
      return sender;
    }

    public List<Contacto> getRecipients() {
        return recipients;
    }
      
    public boolean isLeido() {
      return leido;
    }
      
    public boolean isBorrador() {
      return borrador;
    }

    public boolean isImportant() {
      return important;
    }

    public boolean isEliminado() {
      return eliminado;
    }

    
}