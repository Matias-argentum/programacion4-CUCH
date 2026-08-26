package com.prog4.payment_receipts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends  RuntimeException {
    public CategoryNotFoundException(Long id){
        super("No se encontró categoría con id " + id);
    }
}
