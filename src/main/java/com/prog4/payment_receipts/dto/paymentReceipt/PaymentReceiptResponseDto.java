package com.prog4.payment_receipts.dto.paymentReceipt;

import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import com.prog4.payment_receipts.model.tag.Tag;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PaymentReceiptResponseDto(
        Long id,
        BigDecimal amount,
        LocalDate date,
        String description,
        String imageKey,
        String categoryName,
        List<String> tagNames
) {
    public static PaymentReceiptResponseDto fromEntity(PaymentReceipt receipt) {
        return new PaymentReceiptResponseDto(
                receipt.getId(),
                receipt.getAmount(),
                receipt.getDate(),
                receipt.getDescription(),
                receipt.getImageLink(),
                receipt.getCategory() != null ? receipt.getCategory().getName() : null,
                receipt.getTags() != null
                        ? receipt.getTags().stream().map(Tag::getName).toList()
                        : List.of()
        );
    }
}