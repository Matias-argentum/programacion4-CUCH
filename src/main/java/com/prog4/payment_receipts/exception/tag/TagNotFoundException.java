package com.prog4.payment_receipts.exception.tag;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
// se usa cuando no existe el tag o cuando es de otro userr
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super("No se encontro el tag con id " + id);
    }
}