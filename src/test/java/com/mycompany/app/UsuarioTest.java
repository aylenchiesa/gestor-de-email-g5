package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
  
  @Test
  public void crearUsuario() {
    //debe crear un usuario con nombre y email
    String nombre = "Juan Perez";
    String email = "juan.perez@example.com";
    Usuario usuario = new Usuario(nombre, email);
    assertEquals("Juan Perez", usuario.getNombre());
    assertEquals("juan.perez@example.com", usuario.getEmail());


    
  }
}