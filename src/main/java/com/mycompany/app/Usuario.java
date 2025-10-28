package com.mycompany.app;

public class Usuario implements IMarcador {
    private String nombre;
    private String email;
    public boolean leido = false;

    

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
    
}