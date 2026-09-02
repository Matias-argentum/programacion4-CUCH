package com.prog4.payment_receipts.controller.paymentReceipt;

import com.prog4.payment_receipts.service.paymentReceipt.PaymentReceiptFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/payment-receipts/files")
public class PaymentReceiptFileController {

    private final PaymentReceiptFileService fileService;

    public PaymentReceiptFileController(PaymentReceiptFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        String nombreObjeto = fileService.upload(file);
        return ResponseEntity.ok(nombreObjeto);
    }

    @GetMapping("/url/{nombreObjeto}")
    public ResponseEntity<String> getUrl(@PathVariable String nombreObjeto) throws Exception {
        return ResponseEntity.ok(fileService.getPresignedUrl(nombreObjeto));
    }
}