package com.prog4.payment_receipts.controller.paymentReceipt;

import com.prog4.payment_receipts.dto.paymentReceipt.PaymentReceiptResponseDto;
import com.prog4.payment_receipts.service.paymentReceipt.PaymentReceiptsSearcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// tenemos un controller por verbo como hicieron con mati
@RestController
@RequestMapping("/api/payment-receipts")
public class PaymentReceiptsGetController {

    private final PaymentReceiptsSearcherService paymentReceiptsSearcherService;

    public PaymentReceiptsGetController(PaymentReceiptsSearcherService paymentReceiptsSearcherService) {
        this.paymentReceiptsSearcherService = paymentReceiptsSearcherService;
    }

    //aca vamos a devolver un ResponseEntity
    @GetMapping
    public ResponseEntity<List<PaymentReceiptResponseDto>> getAll() {
        List<PaymentReceiptResponseDto> receipts = paymentReceiptsSearcherService.findAll();
        return ResponseEntity.ok(receipts);
    }

}
