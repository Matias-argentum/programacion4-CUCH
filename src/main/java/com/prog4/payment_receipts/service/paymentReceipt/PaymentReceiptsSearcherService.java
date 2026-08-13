package com.prog4.payment_receipts.service.paymentReceipt;

import com.prog4.payment_receipts.dto.paymentReceipt.PaymentReceiptResponseDto;
import com.prog4.payment_receipts.repository.paymentReceipt.JpaPaymentReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentReceiptsSearcherService {

    private final JpaPaymentReceiptRepository paymentReceiptRepository;

    public PaymentReceiptsSearcherService(JpaPaymentReceiptRepository paymentReceiptRepository) {
        this.paymentReceiptRepository = paymentReceiptRepository;
    }

    public List<PaymentReceiptResponseDto> findAll() {
        return paymentReceiptRepository.findAll().stream()
                .map(PaymentReceiptResponseDto::fromEntity)
                .toList();
    }
}