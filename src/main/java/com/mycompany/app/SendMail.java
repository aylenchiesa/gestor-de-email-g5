package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class SendMail implements ISend {
    private String status = "Pending";

    public String getStatus() {
      return status;
    }
    
    public void enviar(String to, String subject, String body) {
        Contacto remitente = new Contacto("Remitente por defecto", "remitente@demo.com");
        Contacto destinatario = new Contacto("Destinatario temporal", to);

        Email email = new Email(subject, body, remitente);
        email.getRecipients().add(destinatario);

        enviar(email, email.getRecipients());
    }

    @Override
    public void enviar(Email email, List<Contacto> recipients) {
    Contacto remitente = email.getSender();

    //guarda el correo en la bandeja de salida del remitente
    remitente.getBandejaSalida().agregarEmail(email);

    //guarda el correo en la bandeja de entrada de cada destinatario
    for (Contacto destinatario : recipients) {
        destinatario.getBandejaEntrada().agregarEmail(email);
    }

    this.status = "Sent";
}

}

