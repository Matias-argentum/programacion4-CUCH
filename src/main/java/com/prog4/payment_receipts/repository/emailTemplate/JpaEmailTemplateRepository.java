package com.prog4.payment_receipts.repository.emailTemplate;

import com.prog4.payment_receipts.EmailTemplateKeysEnum;
import com.prog4.payment_receipts.model.emailTemplate.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaEmailTemplateRepository extends JpaRepository<EmailTemplate, String> {
    Optional<EmailTemplate> findByKey(EmailTemplateKeysEnum key);
}