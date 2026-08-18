package com.prog4.payment_receipts.dto.auth;

public record LoginRequestDto(
        String email,
        String password
) {
}