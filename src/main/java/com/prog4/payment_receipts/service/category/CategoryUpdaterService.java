package com.prog4.payment_receipts.service.category;

import com.prog4.payment_receipts.dto.category.CategoryRequestDto;
import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.exception.CategoryNotFoundException;
import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdaterService {
    private final JpaCategoryRepository categoryRepository;


    public CategoryUpdaterService(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDto update(Long id, CategoryRequestDto request){
        Category foundCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));
        foundCategory.setName(request.name());
        foundCategory.setIconName(request.iconName());

        return CategoryResponseDto.fromEntity(categoryRepository.save(foundCategory));
    }
}
