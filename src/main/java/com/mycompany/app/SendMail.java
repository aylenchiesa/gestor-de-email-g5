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
    for (Contacto destinatario : recipients) {
        destinatario.getBandejaEntrada().agregarEmail(email);
    }

    this.status = "Sent";
}

}

