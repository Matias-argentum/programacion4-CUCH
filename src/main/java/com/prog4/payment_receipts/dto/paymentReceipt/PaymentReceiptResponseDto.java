package com.prog4.payment_receipts.dto.paymentReceipt;


import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import com.prog4.payment_receipts.model.tag.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PaymentReceiptResponseDto {

    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private String imageLink;
    private String categoryName;
    private List<String> tagNames;

    public static PaymentReceiptResponseDto fromEntity(PaymentReceipt entity) {
        PaymentReceiptResponseDto response = new PaymentReceiptResponseDto();
        response.setId(entity.getId());
        response.setAmount(entity.getAmount());
        response.setDate(entity.getDate());
        response.setDescription(entity.getDescription());
        response.setImageLink(entity.getImageLink());
        response.setCategoryName(entity.getCategory().getName());
        response.setTagNames(
                entity.getTags().stream()
                        .map(tag -> tag.getName())
                        .toList()
        );
        return response;
    }
}
