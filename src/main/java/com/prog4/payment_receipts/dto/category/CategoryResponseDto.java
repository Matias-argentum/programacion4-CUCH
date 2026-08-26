package com.prog4.payment_receipts.dto.category;

import com.prog4.payment_receipts.model.category.Category;

public record CategoryResponseDto(
        Long id,
        String name,
        String iconName
) {
    public static CategoryResponseDto fromEntity(Category category){
        return new CategoryResponseDto(category.getId(), category.getName(), category.getIconName());
    }
}
