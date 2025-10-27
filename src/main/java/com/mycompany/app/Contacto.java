package com.mycompany.app;

public class Contacto {
    // el contacto contiene la información del nombre y correo electrónico de una persona. 
    // Este podrá ser utilizado tanto como remitente o como destinatario en un correo. 
    
    private String nombre;
    private String email;

    public Contacto() {
    }

    public Contacto(String nombre, String email) { //agregar this bandeja de entrada para que cada contacto tenga su propia bandeja
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
    
    @Override
    public String toString() {
        return nombre + " <" + email + ">";
    }
}