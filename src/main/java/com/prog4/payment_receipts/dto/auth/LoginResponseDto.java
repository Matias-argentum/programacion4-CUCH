package com.prog4.payment_receipts.dto.auth;

public record LoginResponseDto(
        String token,
        String email,
        String role
) {
}