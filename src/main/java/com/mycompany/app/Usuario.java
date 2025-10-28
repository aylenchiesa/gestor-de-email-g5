package com.mycompany.app;

public class Usuario {
    private String nombre;
    private String email;
    private boolean leido = false;


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
    
    public void marcarComoLeido() {
      this.leido = true;
    }

    public void marcarComoNoLeido() {
      this.leido = false;
    }
}