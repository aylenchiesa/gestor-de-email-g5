package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class GestorContactos {
    private List<Contacto> contactos;
    
    public GestorContactos() {
        this.contactos = new ArrayList<>();
    }
    
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }
    
    public boolean eliminarContacto(String email) {
      return contactos.removeIf(contacto -> contacto.getEmail().equals(email));
    }
    
    //buscar contacto
    public Contacto buscarContactoPorEmail(String email) {
      for (Contacto c : contactos) {
        if (c.getEmail().equalsIgnoreCase(email)) {
          return c;
        }
      }
      return null; // no encontrado
    }
    
    //editar contacto
    public boolean editarContacto(String email, String nuevoNombre, String nuevoEmail) {
        Contacto contacto = buscarContactoPorEmail(email);
        if (contacto != null) {
            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                contacto.setNombre(nuevoNombre);
            }
            if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
                contacto.setEmail(nuevoEmail);
            }
            return true; // edición exitosa
        }
        return false; // no se encontró el contacto
    }

    
    public List<Contacto> getContactos() {
        return contactos;
    }
    
    public int size() {
        return contactos.size();
    }
}