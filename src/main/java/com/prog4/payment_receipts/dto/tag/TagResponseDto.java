package com.prog4.payment_receipts.dto.tag;

import com.prog4.payment_receipts.model.tag.Tag;

public record TagResponseDto(
        Long id,
        String name
) {
    public static TagResponseDto fromEntity(Tag tag) {
        return new TagResponseDto(tag.getId(), tag.getName());
    }
}