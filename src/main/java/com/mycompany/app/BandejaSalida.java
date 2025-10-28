package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class BandejaSalida {
    private List<Email> emails;

    public BandejaSalida() {
        this.emails = new ArrayList<>();
    }

    public void agregarEmail(Email email) {
        emails.add(email);
    }

    public List<Email> getEmails() {
        return emails;
    }
}

