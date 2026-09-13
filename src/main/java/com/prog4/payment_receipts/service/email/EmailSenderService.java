package com.prog4.payment_receipts.service.email;

import com.example.mail.dto.EmailRequestDTO;
import com.example.mail.dto.EmailResponseDTO;
import com.example.mail.entity.EmailLog;
import com.example.mail.repository.EmailLogRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;
    private final EmailLogRepository emailLogRepository;

    public EmailSenderService(JavaMailSender mailSender, EmailLogRepository emailLogRepository) {
        this.mailSender = mailSender;
        this.emailLogRepository = emailLogRepository;
    }

    public EmailResponseDTO sendEmail(EmailRequestDTO request) {
        String logId = UUID.randomUUID().toString();

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.to());
            helper.setSubject(request.subject());
            helper.setText(request.body(), request.isHtml());

            if (request.cc() != null && !request.cc().isEmpty()) {
                helper.setCc(request.cc().toArray(new String[0]));
            }

            mailSender.send(message);

            return EmailResponseDTO.success(logId, request);

        } catch (MessagingException e) {
            return EmailResponseDTO.failure(logId, request, e.getMessage());
        }
    }
}