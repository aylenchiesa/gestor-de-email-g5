package com.mycompany.app;

import java.util.List;

public class SendMail implements ISend {
    private String status = "Pending";

    public String getStatus() {
      return status;
    }

    @Override
    public void enviar(Email email, List<Contacto> recipients) {
    Contacto remitente = email.getSender();

    //guarda el correo en la bandeja de salida del remitente
    remitente.getBandejaSalida().agregarEmail(email);

    //guarda el correo en la bandeja de entrada de cada destinatario
    // CADA DESTINATARIO RECIBE SU PROPIA COPIA DEL EMAIL
    for (Contacto destinatario : recipients) {
        Email copiaEmail = new Email(email.getSubject(), email.getContent(), email.getSender());
        // Copiar los destinatarios originales
        copiaEmail.getRecipients().addAll(email.getRecipients());
        destinatario.getBandejaEntrada().agregarEmail(copiaEmail);
    }

    this.status = "Sent";
}

}

