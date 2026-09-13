package com.prog4.payment_receipts.dto.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record EmailRequestDTO(
        @NotBlank @Email String to,
        List<String> cc,
        @NotBlank String subject,
        @NotBlank String body,
        boolean isHtml
) {}