package com.prog4.payment_receipts.service.category;

import com.prog4.payment_receipts.dto.category.CategoryRequestDto;
import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreatorService {
    private final JpaCategoryRepository categoryRepository;

    public CategoryCreatorService(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDto create(CategoryRequestDto request){
        Category category = new Category();
        category.setName(request.name());
        category.setIconName(request.iconName());
        return CategoryResponseDto.fromEntity(categoryRepository.save(category));
    }
}
