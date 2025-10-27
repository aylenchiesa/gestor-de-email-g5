package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class BandejaSalida {
    private List<Email> emailsEnviados;

    public BandejaSalida() {
        this.emailsEnviados = new ArrayList<>();
    }

    // guardar un correo que fue enviado
    public void registrarEnvio(Email email) {
        emailsEnviados.add(email);
    }

    // obtener todos los correos enviados
    public List<Email> getEmailsEnviados() {
        return new ArrayList<>(emailsEnviados);
    }

    // Buscar entre los correos enviados
    public List<Email> buscarEmailsEnviados(String texto) {
        List<Email> resultados = new ArrayList<>();
        String query = texto.toLowerCase();

        for (Email email : emailsEnviados) {
            boolean coincide =
                (email.getSubject() != null && email.getSubject().toLowerCase().contains(query)) ||
                (email.getContent() != null && email.getContent().toLowerCase().contains(query)) ||
                (email.getRecipients() != null && email.getRecipients().toString().toLowerCase().contains(query));

            if (coincide) {
                resultados.add(email);
            }
        }

        return resultados;
    }
}

