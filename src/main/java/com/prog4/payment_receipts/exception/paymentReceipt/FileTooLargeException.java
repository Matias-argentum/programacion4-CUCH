package com.prog4.payment_receipts.exception.paymentReceipt;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//ahora no sirve poruqe tenemos que hacer un global exception handler pero la dejamos
@ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
public class FileTooLargeException extends RuntimeException {
    public FileTooLargeException() {
        super("El archivo supera el tamaño máximo permitido");
    }
}