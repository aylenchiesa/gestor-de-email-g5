package com.mycompany.app;

import java.util.List;

// Clase que implementa la interfaz ISend para enviar correos electrónicos.
public class SendMail implements ISend {
    private String subject;
    private String content;
    private String sender;
    private List<String> recipients;
    private boolean important;
    private String status;

    public SendMail(String subject, String content, String sender, List<String> recipients, boolean important) {
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.recipients = recipients;
        this.important = important;
        this.status = "Pending";
    }

    public String getStatus() {
        return status;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public boolean isImportant() {
        return important;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        // Implementation for sending email
        this.status = "Sent";
    }
}