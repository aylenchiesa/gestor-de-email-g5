import java.util.ArrayList;
import java.util.List;

package com.mycompany.app;


public class BandejaEntrada {
  private List<Correo> correos;
  
  public BandejaEntrada() {
    this.correos = new ArrayList<>();
  }
  
  public void agregarCorreo(Correo correo) {
    correos.add(correo);
  }
  
  public void eliminarCorreo(Correo correo) {
    correos.remove(correo);
  }
  
  public List<Correo> getCorreos() {
    return new ArrayList<>(correos);
  }
  
  public Correo buscarCorreoPorId(int id) {
    return correos.stream()
        .filter(correo -> correo.getId() == id)
        .findFirst()
        .orElse(null);
  }
  
  public void limpiarBandeja() {
    correos.clear();
  }
  
  public int getCantidadCorreos() {
    return correos.size();
  }
}