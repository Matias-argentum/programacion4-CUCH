package com.prog4.payment_receipts.model.emailTemplate;
import com.prog4.payment_receipts.enumerated.emailTemplate.EmailTemplateKeysEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "email_templates")
public class EmailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private EmailTemplateKeysEnum key;

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String body;

    public EmailTemplate() {}

    public EmailTemplate(EmailTemplateKeysEnum key, String subject, String body) {
        this.key = key;
        this.subject = subject;
        this.body = body;
    }

    public String getId() { return id; }
    public EmailTemplateKeysEnum getKey() { return key; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }

    public void setSubject(String subject) { this.subject = subject; }
    public void setBody(String body) { this.body = body; }
}