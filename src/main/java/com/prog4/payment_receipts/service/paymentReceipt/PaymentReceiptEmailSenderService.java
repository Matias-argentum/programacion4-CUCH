package com.prog4.payment_receipts.service.paymentReceipt;

import com.prog4.payment_receipts.EmailTemplateKeysEnum;
import com.prog4.payment_receipts.dto.email.EmailRequestDTO;
import com.prog4.payment_receipts.dto.email.EmailResponseDTO;
import com.prog4.payment_receipts.model.emailTemplate.EmailTemplate;
import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import com.prog4.payment_receipts.repository.emailTemplate.JpaEmailTemplateRepository;
import com.prog4.payment_receipts.service.email.EmailSenderService;
import com.prog4.payment_receipts.service.email.EmailVariableResolverService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class PaymentReceiptEmailSenderService {

    private final JpaEmailTemplateRepository emailTemplateRepository;
    private final EmailVariableResolverService emailVariableResolverService;
    private final EmailSenderService emailSenderService;

    public PaymentReceiptEmailSenderService(
            JpaEmailTemplateRepository emailTemplateRepository,
            EmailVariableResolverService emailVariableResolverService,
            EmailSenderService emailSenderService
    ) {
        this.emailTemplateRepository = emailTemplateRepository;
        this.emailVariableResolverService = emailVariableResolverService;
        this.emailSenderService = emailSenderService;
    }

    public EmailResponseDTO send(PaymentReceipt paymentReceipt) {

        EmailTemplate template = emailTemplateRepository.findByKey(EmailTemplateKeysEnum.PAYMENT_RECEIPT)
                .orElseThrow(() -> new IllegalStateException(
                        "No existe plantilla para key: " + EmailTemplateKeysEnum.PAYMENT_RECEIPT));

        Map<String, String> variables = Map.of(
                "nombre", paymentReceipt.getUser().getUsername(),
                "monto", paymentReceipt.getAmount().toPlainString(),
                "fecha", paymentReceipt.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );

        String subject = emailVariableResolverService.resolve(template.getSubject(), variables);
        String body = emailVariableResolverService.resolve(template.getBody(), variables);

        EmailRequestDTO request = new EmailRequestDTO(
                paymentReceipt.getUser().getEmail(),
                null,
                subject,
                body,
                true
        );

        return emailSenderService.sendEmail(request);
    }
}