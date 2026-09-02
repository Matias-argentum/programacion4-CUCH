package com.prog4.payment_receipts.controller.paymentReceipt;

import com.prog4.payment_receipts.dto.paymentReceipt.PaymentReceiptResponseDto;
import com.prog4.payment_receipts.service.paymentReceipt.PaymentReceiptCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payment-receipts")
public class PaymentReceiptCreatorController {

    private final PaymentReceiptCreatorService creatorService;

    public PaymentReceiptCreatorController(PaymentReceiptCreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<PaymentReceiptResponseDto> create(
            @RequestParam("file") MultipartFile file,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("date") LocalDate date,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam(value = "tagIds", required = false) List<Long> tagIds
    ) throws Exception {
        var receipt = creatorService.create(file, amount, date, description, categoryId, tagIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentReceiptResponseDto.fromEntity(receipt));
    }
}