package com.prog4.payment_receipts.dto.auth;

public record RegisterRequestDto(
        String email,
        String password
) {
}