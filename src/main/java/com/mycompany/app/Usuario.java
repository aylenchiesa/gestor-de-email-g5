package com.mycompany.app;


public class Usuario {
    private String nombre;
    private String email;
    private Contacto contacto; // Relación Usuario -> Contacto
    private boolean leido;

    public Usuario(String nombre, String email, Contacto contacto) {
        this.nombre = nombre;
        this.email = email;
        this.contacto = contacto;
    }

    public Usuario(String nombre2, String email2) {
      this.nombre = nombre2;
      this.email = email2;
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

    // Acceder al contacto asociado
    public Contacto getContacto() {
        return contacto;
    }

    public void marcarComoLeido(Email email) {
        email.marcarComoLeido();
    }

    public void marcarComoNoLeido(Email email) {
      email.marcarComoNoLeido();
    }
    

    // Usuario puede eliminar emails de su contacto asociado
    public void eliminarEmail(Email email) {
      email.eliminado = true; // Marcar como eliminado 
        if (contacto != null) {
            //usa el método de Bandeja para removerlo de la lista interna
            contacto.getBandejaEntrada().removerEmail(email); 
        }
    }

    public void restaurarEmail(Email email) {
      email.restaurar(); 
      if (contacto != null && !contacto.getBandejaEntrada().getEmails().contains(email)) {
          contacto.getBandejaEntrada().agregarEmail(email);
      }
    }
    
/*    public void eliminarEmail(Email email) {
        email.marcarComoEliminado();
        this.contacto.getBandejaEntrada().removerEmail(email);
    } */
}