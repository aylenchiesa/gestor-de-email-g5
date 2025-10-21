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
    
    public List<Contacto> getContactos() {
        return contactos;
    }
    
    public int size() {
        return contactos.size();
    }
}