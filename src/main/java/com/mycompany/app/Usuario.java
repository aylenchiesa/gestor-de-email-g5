package com.mycompany.app;

import java.util.List;

public class Usuario implements IMarcador {
    private String nombre;
    private String email;
    public boolean leido = false;
    private boolean eliminado = false;//por defecto falso
    private List<Email> emails;

    

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.leido = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    @Override
    public void marcarComoLeido() {
        this.leido = true;
    }

    @Override
    public void marcarComoNoLeido() {
      this.leido = false;
    }
    
    @Override
    public boolean isLeido() {
      return leido;
    }

    public void eliminarEmail(Email email) {
    emails.remove(email);
    }

    public boolean isEliminado() {
      return eliminado;
    }
}