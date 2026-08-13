package com.prog4.payment_receipts.repository.paymentReceipt;

import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentReceiptRepository extends JpaRepository<PaymentReceipt, Long> {
}
