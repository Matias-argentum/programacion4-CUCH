package com.prog4.payment_receipts.dto.email;

import java.time.LocalDateTime;

public record EmailResponseDTO(
        String id,
        String to,
        String subject,
        String status,
        String errorMessage,
        LocalDateTime sentAt
) {
    public static EmailResponseDTO success(String id, EmailRequestDTO req) {
        return new EmailResponseDTO(id, req.to(), req.subject(), "SENT", null, LocalDateTime.now());
    }

    public static EmailResponseDTO failure(String id, EmailRequestDTO req, String error) {
        return new EmailResponseDTO(id, req.to(), req.subject(), "FAILED", error, LocalDateTime.now());
    }
}