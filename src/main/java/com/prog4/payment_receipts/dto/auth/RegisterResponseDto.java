package com.prog4.payment_receipts.dto.auth;

public record RegisterResponseDto(
        Long id,
        String email,
        String role
) {
}